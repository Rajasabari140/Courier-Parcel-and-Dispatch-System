package com.courier.util;

public class ActiveDispatchException extends Exception{

	public String tostring()
	{
		return"Parcel has active dispatch or tracking records";
	}
}
