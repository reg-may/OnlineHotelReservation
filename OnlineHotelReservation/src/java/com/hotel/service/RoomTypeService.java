package com.hotel.service;

import java.util.List;

import com.hotel.domain.RoomType;

public interface RoomTypeService extends Service {
	
	RoomType getRoomType(Integer id);
	
	RoomType save(RoomType roomType);
	
	void delete(RoomType roomType);
	
	List<RoomType> getRoomTypes();
}
