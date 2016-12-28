package com.hotel.domain.impl;

import java.util.Date;

import com.hotel.domain.Domain;

public class DomainImpl implements Domain {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8197580142147126593L;

	protected Integer id;
	protected Date createdDate;
	protected Date modifiedDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
