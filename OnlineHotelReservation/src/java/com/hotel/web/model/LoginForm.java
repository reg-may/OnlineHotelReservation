package com.hotel.web.model;

public class LoginForm extends BaseForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1008826170928148622L;
	private String userName = null;
	private String email = null;
	private String passWord = null;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
