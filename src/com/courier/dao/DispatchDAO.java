package com.courier.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import com.courier.bean.Dispatch;
import com.courier.util.DBUtil;

public class DispatchDAO {

	public int generateDispatchID()
	{
		int dispatchID=0;
		String query="SELECT NVL(MAX(DISPATCH_ID),90000)+1 FROM COURIER_DB.DISPATCH_TBL";
		try(Connection connection=DBUtil.getDBConnection();
				Statement st=connection.createStatement();
				ResultSet rs=st.executeQuery(query))
		{
			if(rs.next())
			{
				dispatchID=rs.getInt(1);
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return dispatchID;
	}  
	
	public boolean recordDispatch(Dispatch dispatch)
	{
		String query="INSERT INTO COURIER_DB.DISPATCH_TBL VALUES(?,?,?,?,?,?)";
		
		try(Connection connection=DBUtil.getDBConnection();
				PreparedStatement ps=connection.prepareStatement(query))
		{
			ps.setInt(1, dispatch.getDispatchID());
            ps.setString(2, dispatch.getParcelID());
            ps.setString(3, dispatch.getVehicleID());
            ps.setDate(4, new java.sql.Date(dispatch.getDispatchDate().getTime()));
            ps.setDate(5, new java.sql.Date(dispatch.getExpectedDeliveryDate().getTime()));
            ps.setString(6, dispatch.getStatus());
            int rows=ps.executeUpdate();
            return rows>0;
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public Dispatch findDispatch(int dispatchID)
	{
		Dispatch dispatch=null;
		String query="SELECT * FROM COURIER_DB.DISPATCH_TBL WHERE DISPATCH_ID=?";

		try(Connection connection=DBUtil.getDBConnection();
				PreparedStatement ps=connection.prepareStatement(query))
		{
			ps.setInt(1,dispatchID);
			ResultSet rs=ps.executeQuery();
			
			if (rs.next()) {
                dispatch = new Dispatch();
                dispatch.setDispatchID(rs.getInt("DISPATCH_ID"));
                dispatch.setParcelID(rs.getString("PARCEL_ID"));
                dispatch.setVehicleID(rs.getString("VEHICLE_ID"));
                //dispatch.setDispatchedDate(rs.getDate("DISPATCHED_DATE"));
                dispatch.setExpectedDeliveryDate(rs.getDate("EXPECTED_DELIVERY_DATE"));
                dispatch.setStatus(rs.getString("STATUS"));
            }
		}  catch(Exception e)
		{
			e.printStackTrace();
		} return dispatch;
	}
	
	
	public boolean cancelDispatch(int dispatchID)
	{
		String query ="UPDATE COURIER_DB.DISPATCH_TBL SET STATUS='CANCELLED' WHERE DISPATCH_ID=?";
		
		try(Connection connection=DBUtil.getDBConnection();
				PreparedStatement ps=connection.prepareStatement(query))
		{
			ps.setInt(1,dispatchID);
			int rows=ps.executeUpdate();
			return rows>0;
		}  catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
