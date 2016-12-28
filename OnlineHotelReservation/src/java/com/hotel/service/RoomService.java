package com.hotel.service;

import java.util.List;

import com.hotel.domain.Room;
import com.hotel.domain.RoomType;

public interface RoomService extends Service {
	
	Room getRoom(Integer id);
	
	Room save(Room room);
	
	void delete(Room room);
	
	List<Room> getRoomsByRoomType(RoomType roomType);	
}
