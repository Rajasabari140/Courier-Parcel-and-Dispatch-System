package com.courier.app;

import java.util.Date;
import com.courier.bean.Parcel;
import com.courier.bean.Dispatch;
import com.courier.service.DispatchService;
import com.courier.dao.ParcelDAO;

public class CourierMain {

    public static void main(String[] args) {

        DispatchService dispatchService = new DispatchService();

        Parcel parcel = new Parcel();
        parcel.setParcelID("P1002");
        parcel.setSenderName("Saran");
        parcel.setRecipientName("ibrahim");
        parcel.setOrigin("Tenkasi");
        parcel.setDestination("Namakkal");
        parcel.setWeight(2.5);
        parcel.setDimensions("30x20x10");
        parcel.setCurrentStatus("BOOKED");
        
        ParcelDAO parcelDAO = new ParcelDAO();
        boolean inserted = parcelDAO.insertParcel(parcel);

        if (inserted) {
            System.out.println("PARCEL INSERTED SUCCESSFULLY");
        } else {
            System.out.println("PARCEL INSERT FAILED");
        }
        Dispatch dispatch = new Dispatch();
        dispatch.setParcelID("P1001");
        dispatch.setVehicleID("V101");
        dispatch.setDispatchDate(new Date());
        dispatch.setExpectedDeliveryDate(new Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000));
        dispatch.setStatus("DISPATCHED");

        String dispatchResult = dispatchService.createDispatch(dispatch);
        System.out.println(dispatchResult);

        Dispatch foundDispatch = dispatchService.getDispatchDetails(dispatch.getDispatchID());

        if (foundDispatch != null) {
            System.out.println("Dispatch ID : " + foundDispatch.getDispatchID());
            System.out.println("Parcel ID   : " + foundDispatch.getParcelID());
            System.out.println("Vehicle ID  : " + foundDispatch.getVehicleID());
            System.out.println("Status      : " + foundDispatch.getStatus());
        } else {
            System.out.println("Dispatch not found");
        }

        String cancelResult = dispatchService.cancelDispatch(dispatch.getDispatchID());
        System.out.println(cancelResult);
    }
}

