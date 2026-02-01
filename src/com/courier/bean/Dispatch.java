package com.courier.bean;
import java.util.Date;

public class Dispatch {
              private int dispatchID;
              private String parcelID;
              private String vehicleID;
              private Date dispatchDate;
              private Date expectedDeliveryDate;
              private String status;
			public int getDispatchID() {
				return dispatchID;
			}
			public void setDispatchID(int dispatchID) {
				this.dispatchID = dispatchID;
			}
			public String getParcelID() {
				return parcelID;
			}
			public void setParcelID(String parcelID) {
				this.parcelID = parcelID;
			}
			public String getVehicleID() {
				return vehicleID;
			}
			public void setVehicleID(String vehicleID) {
				this.vehicleID = vehicleID;
			}
			public Date getDispatchDate() {
				return dispatchDate;
			}
			public void setDispatchDate(Date dispatchDate) {
				this.dispatchDate = dispatchDate;
			}
			public Date getExpectedDeliveryDate() {
				return expectedDeliveryDate;
			}
			public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
				this.expectedDeliveryDate = expectedDeliveryDate;
			}
			public String getStatus() {
				return status;
			}
			public void setStatus(String status) {
				this.status = status;
			}
              
	
}
