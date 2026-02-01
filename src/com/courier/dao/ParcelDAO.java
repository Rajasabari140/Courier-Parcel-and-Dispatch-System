package com.courier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.courier.bean.Parcel;
import com.courier.util.DBUtil;

public class ParcelDAO {
	
	public Parcel findParcel(String parcelID)
	{
		Parcel parcel=null;
		String query="SELECT *FROM COURIER_DB.PARCEL_TBL WHERE PARCEL_ID=?";
		
		try(Connection connection =DBUtil.getDBConnection();
				PreparedStatement ps=connection.prepareStatement(query))
		{
			 ps.setString(1, parcelID);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                parcel = new Parcel();
	                parcel.setParcelID(rs.getString("PARCEL_ID"));
	                parcel.setSenderName(rs.getString("SENDER_NAME"));
	                parcel.setRecipientName(rs.getString("RECIPIENT_NAME"));
	                parcel.setOrigin(rs.getString("ORIGIN"));
	                parcel.setDestination(rs.getString("DESTINATION"));
	                parcel.setWeight(rs.getDouble("WEIGHT"));
	                parcel.setDimensions(rs.getString("DIMENSIONS"));
	                parcel.setCurrentStatus(rs.getString("CURRENT_STATUS"));
	            }

		}  catch (Exception e)
		{
			e.printStackTrace();
		}   return parcel;
	}
	 public List<Parcel> viewAllParcels() {
	        List<Parcel> list = new ArrayList<>();
	        String query = "SELECT * FROM COURIER_DB.PARCEL_TBL";

	        try (Connection connection = DBUtil.getDBConnection();
	             Statement st = connection.createStatement();
	             ResultSet rs = st.executeQuery(query)) {

	            while (rs.next()) {
	                Parcel parcel = new Parcel();
	                parcel.setParcelID(rs.getString("PARCEL_ID"));
	                parcel.setSenderName(rs.getString("SENDER_NAME"));
	                parcel.setRecipientName(rs.getString("RECIPIENT_NAME"));
	                parcel.setOrigin(rs.getString("ORIGIN"));
	                parcel.setDestination(rs.getString("DESTINATION"));
	                parcel.setWeight(rs.getDouble("WEIGHT"));
	                parcel.setDimensions(rs.getString("DIMENSIONS"));
	                parcel.setCurrentStatus(rs.getString("CURRENT_STATUS"));
	                list.add(parcel);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

	 public boolean insertParcel(Parcel parcel) {

	        String query = "INSERT INTO COURIER_DB.PARCEL_TBL VALUES (?,?,?,?,?,?,?,?)";

	        try (Connection connection = DBUtil.getDBConnection();
	             PreparedStatement ps = connection.prepareStatement(query)) {

	            ps.setString(1, parcel.getParcelID());
	            ps.setString(2, parcel.getSenderName());
	            ps.setString(3, parcel.getRecipientName());
	            ps.setString(4, parcel.getOrigin());
	            ps.setString(5, parcel.getDestination());
	            ps.setDouble(6, parcel.getWeight());
	            ps.setString(7, parcel.getDimensions());
	            ps.setString(8, parcel.getCurrentStatus());

	            int rows = ps.executeUpdate();
	            return rows > 0;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return false;
	    }
	 
	 public boolean updateParcelStatus(String parcelID, String newStatus) {

	        String query = "UPDATE COURIER_DB.PARCEL_TBL SET CURRENT_STATUS=? WHERE PARCEL_ID=?";

	        try (Connection connection = DBUtil.getDBConnection();
	             PreparedStatement ps = connection.prepareStatement(query)) {

	            ps.setString(1, newStatus);
	            ps.setString(2, parcelID);

	            int rows = ps.executeUpdate();
	            return rows > 0;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return false;
	    }
	 
	  public boolean deleteParcel(String parcelID) {

	        String query = "DELETE FROM COURIER_DB.PARCEL_TBL WHERE PARCEL_ID=?";

	        try (Connection connection = DBUtil.getDBConnection();
	             PreparedStatement ps = connection.prepareStatement(query)) {

	            ps.setString(1, parcelID);
	            int rows = ps.executeUpdate();
	            return rows > 0;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
	    }}
