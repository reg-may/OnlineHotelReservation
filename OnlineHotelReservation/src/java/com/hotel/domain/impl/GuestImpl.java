package com.hotel.domain.impl;

import com.hotel.domain.Guest;

public class GuestImpl extends DomainImpl implements Guest {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2256935857954782210L;
	
	private String userName;
	private String passWord;
	private String email;
	private String phoneNo;
	private String firstName;
	private String lastName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("GuestImpl[");
		buffer.append(" id = ").append(id);
		buffer.append(" userName = ").append(userName);
		buffer.append(" passWord = ").append(passWord);
		buffer.append(" email = ").append(email);
		buffer.append(" phoneNo = ").append(phoneNo);
		buffer.append(" firstName = ").append(firstName);
		buffer.append(" lastName = ").append(lastName);
		buffer.append("]");
		return buffer.toString();
	}
}
