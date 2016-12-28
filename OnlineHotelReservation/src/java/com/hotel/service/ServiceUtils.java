package com.hotel.service;

import com.hotel.service.impl.GuestServiceImpl;
import com.hotel.service.impl.RoomServiceImpl;
import com.hotel.service.impl.RoomTypeServiceImpl;

public class ServiceUtils {

	public static GuestService getGuestService(){
		return GuestServiceImpl.getInstance();
	}	
	
	public static RoomTypeService getRoomTypeService(){
		return RoomTypeServiceImpl.getInstance();
	}	
	
	public static RoomService getRoomService(){
		return RoomServiceImpl.getInstance();
	}	
}
