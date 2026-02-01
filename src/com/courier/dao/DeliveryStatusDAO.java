package com.courier.dao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.courier.bean.DeliveryStatus;
import com.courier.util.DBUtil;

public class DeliveryStatusDAO {
	
	public int generateSequenceNumber()
	{
		int statusID=0;
		String query = "SELECT NVL(MAX(STATUS_ID),700000) + 1 FROM COURIER_DB.DELIVERY_STATUS_TBL";
		try(Connection connection =DBUtil.getDBConnection();
		Statement st=connection.createStatement();
				ResultSet rs=st.executeQuery(query)) {   
			if(rs.next())
			{
				statusID=rs.getInt(1);
			}  }  catch(Exception e)
		{
				e.printStackTrace();} return statusID;}
		
	
	public boolean recordStatus(DeliveryStatus status)
	{
		String query ="INSERT INTO COURIER_DB.DELIVERY_STATUS_TBL VALUES(?,?,?,?,?)";
		try(Connection connection=DBUtil.getDBConnection();
				PreparedStatement ps=connection.prepareStatement(query))
		{
			ps.setInt(1,status.getStatusID());
			ps.setInt(2,status.getDispatchID());
			 ps.setTimestamp(3, status.getStatusTimestamp());
	            ps.setString(4, status.getLocation());
	            ps.setString(5, status.getStatus());
	            
	            int rows=ps.executeUpdate();   return rows>0;
	            
		} catch(Exception e)
		{
			e.printStackTrace();
		}  return false;
	}
	
	
	public List<DeliveryStatus> viewStatusHistory(int dispatchID)
	{
		List<DeliveryStatus> list= new ArrayList<>();
		String query="SELECT * FROM COURIER_DB.DELIVERY_STATUS_TBL WHERE DISPATCH_ID=? ORDER BY STATUS_TIMESTAMP";	
		try(Connection connection=DBUtil.getDBConnection();
				PreparedStatement ps=connection.prepareStatement(query))
		{
			ps.setInt(1, dispatchID);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				DeliveryStatus ds=new DeliveryStatus();
				ds.setStatusID(rs.getInt("STATUS_ID"));
                ds.setDispatchID(rs.getInt("DISPATCH_ID"));
                ds.setStatusTimestamp(rs.getTimestamp("STATUS_TIMESTAMP"));
                ds.setLocation(rs.getString("LOCATION"));
                ds.setStatus(rs.getString("STATUS"));
                list.add(ds);
			}  }
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}
}
