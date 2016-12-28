package com.hotel.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hotel.domain.service.RoomTypeService;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="RoomType")
@Table(name="roomtype", catalog="hotel")
public class RoomType implements RoomTypeService {
 
	private static final long serialVersionUID = -1244799779065665162L;
	private Integer id;
	private Date createdDate;
	private Date modifiedDate;	
	private String description;
	private Integer maxCapacity;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="description", nullable=true, length=45)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="max_capacity", nullable=true, length=11)
	public Integer getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	@Column(name="created_at", nullable=true)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Column(name="modified_at", nullable=true)
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
