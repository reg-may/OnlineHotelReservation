package com.hotel.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hotel.domain.service.RoomService;

@Entity(name="Room")
@Table(name="room", catalog="hotel")
public class Room implements RoomService{

	private static final long serialVersionUID = -6368563423571760879L;
	
	private Integer id;
	private String number;
	private String name;
	private String status;
	private Boolean smoke;
	private RoomType roomType;
	private Date createdDate;
	private Date modifiedDate;	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="number", nullable=true, length=45)
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Column(name="name", nullable=true, length=45)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="status", nullable=true, length=45)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="smoke", nullable=true, length=1)
	public Boolean getSmoke() {
		return smoke;
	}
	public void setSmoke(Boolean smoke) {
		this.smoke = smoke;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_type_id", nullable = false)
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
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
