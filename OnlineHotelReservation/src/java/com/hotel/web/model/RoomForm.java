package com.hotel.web.model;

import java.util.List;

import com.hotel.domain.RoomType;

public class RoomForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5625567154758022732L;
	private Integer roomId;
	private String name;
	private String number;
	private String status;
	private Boolean smoke;
    private String roomType;
    
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Boolean getSmoke() {
		return smoke;
	}
	public void setSmoke(Boolean smoke) {
		this.smoke = smoke;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
}
