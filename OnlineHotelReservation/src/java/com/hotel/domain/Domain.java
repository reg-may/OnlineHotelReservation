package com.hotel.domain;

import java.io.Serializable;
import java.util.Date;

public interface Domain extends Serializable {
	
	void setId(Integer id);
	
	Integer getId();
	
	void setCreatedDate(Date createdDate);
	
	Date getCreatedDate();
	
	void setModifiedDate(Date modifiedDate);
	
	Date getModifiedDate();
}
