package com.courier.util;

public class ValidationException extends Exception {

   public String toString()
   {
	   return "validation failed:Invalid input data";
   }
}
