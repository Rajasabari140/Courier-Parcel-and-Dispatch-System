package com.courier.service;
import com.courier.bean.Dispatch;
import com.courier.dao.DispatchDAO;

public class DispatchService {
	
	DispatchDAO dao=new DispatchDAO();
	
	public String createDispatch(Dispatch dispatch)
	{
		if(dispatch == null) {
			 return "INVALID DISPATCH DATA";
		}
		
		int dispatchID =dao.generateDispatchID();
		dispatch.setDispatchID(dispatchID);
		
		boolean result =dao.recordDispatch(dispatch);
		
		if(result) {
			return "DISPATCH CREATED SUCCESSFULLY.ID:"+ dispatchID;
		} return "DISPATCH CREATION FAILED";
	}
	
	public Dispatch getDispatchDetails(int dispatchID)
	{
		if(dispatchID<=0)
		{
			return null;
		}
		
		return dao.findDispatch(dispatchID);
	}
	public String cancelDispatch(int dispatchID) {
		if(dispatchID<=0) return "INVALID DISPATCH ID";
		
		boolean result =dao.cancelDispatch(dispatchID);
		
		if(result)
		{
			return "Dispatch cancelled successfully";
		}
		return "Dispatch Not Fount or Already Cancelled";
	}

}
