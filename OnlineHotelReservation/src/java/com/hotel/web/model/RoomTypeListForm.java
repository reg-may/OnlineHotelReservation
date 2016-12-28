package com.hotel.web.model;

public class RoomTypeListForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2602287631060839275L;

    protected Integer roomTypeId = null;
    protected String[] roomTypeIds = null;
 
    
	public Integer getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String[] getRoomTypeIds() {
		return roomTypeIds;
	}

	public void setRoomTypeIds(String[] roomTypeIds) {
		this.roomTypeIds = roomTypeIds;
	}

}
