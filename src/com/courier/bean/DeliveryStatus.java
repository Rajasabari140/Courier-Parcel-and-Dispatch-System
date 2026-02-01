package com.courier.bean;

import java.sql.Timestamp;

public class DeliveryStatus {
  private int statusID;
  private int dispatchID;
  private Timestamp statusTimestamp;
  private String location;
  private String status;
public int getStatusID() {
	return statusID;
}
public void setStatusID(int statusID) {
	this.statusID = statusID;
}
public int getDispatchID() {
	return dispatchID;
}
public void setDispatchID(int dispatchID) {
	this.dispatchID = dispatchID;
}
public Timestamp getStatusTimestamp() {
	return statusTimestamp;
}
public void setStatusTimestamp(Timestamp statusTimestamp) {
	this.statusTimestamp = statusTimestamp;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
  
	

}
