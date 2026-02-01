package com.courier.util;

public class ParcelAlreadyDispatchedException extends Exception {
  public String toString()
  {
	  return "Parcel is already dispatched or not in ready state";
  }
}
