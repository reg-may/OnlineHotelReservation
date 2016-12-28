package com.hotel.domain.service;

import java.io.Serializable;
import java.util.Date;

import com.hotel.domain.RoomType;

public interface RoomService extends Serializable {
	
	Integer getId();
	void setId(Integer id);

	String getNumber();
	void setNumber(String number);
	 
	String getName();
	void setName(String name);
	
	String getStatus();
	void setStatus(String status);
	
	Boolean getSmoke();
	void setSmoke(Boolean smoke);
	
	RoomType getRoomType();
	void setRoomType(RoomType roomType);
	
	void setCreatedDate(Date createdDate);	
	Date getCreatedDate();
	
	void setModifiedDate(Date modifiedDate);
	Date getModifiedDate();
}
