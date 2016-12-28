package com.hotel.domain.service;

import java.io.Serializable;
import java.util.Date;

public interface RoomTypeService extends Serializable {
	void setId(Integer id);
	
	Integer getId();
  
	String getDescription();
	
	void setDescription(String description);
	
	Integer getMaxCapacity();
	
	void setMaxCapacity(Integer maxCapacity);
	
	void setCreatedDate(Date createdDate);
	
	Date getCreatedDate();
	
	void setModifiedDate(Date modifiedDate);
	
	Date getModifiedDate();
}
