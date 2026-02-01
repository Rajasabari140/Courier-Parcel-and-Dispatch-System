package com.courier.bean;

public class Parcel {
private String parcelID;
private String senderName;
private String recipientName;
private String origin;
private String destination;
private double weight;
private String dimensions;
private String currentStatus;
public String getParcelID() {
	return parcelID;
}
public void setParcelID(String parselID) {
	this.parcelID = parselID;
}
public String getSenderName() {
	return senderName;
}
public void setSenderName(String senderName) {
	this.senderName = senderName;
}
public String getRecipientName() {
	return recipientName;
}
public void setRecipientName(String recipientName) {
	this.recipientName = recipientName;
}
public String getOrigin() {
	return origin;
}
public void setOrigin(String origin) {
	this.origin = origin;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}
public String getDimensions() {
	return dimensions;
}
public void setDimensions(String dimensions) {
	this.dimensions = dimensions;
}
public String getCurrentStatus() {
	return currentStatus;
}
public void setCurrentStatus(String currentStatus) {
	this.currentStatus = currentStatus;
}

}
