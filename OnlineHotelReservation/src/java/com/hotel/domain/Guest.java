package com.hotel.domain;

public interface Guest extends Domain {

  String getUserName();
  
  void setUserName(String userName);
  
  String getPassWord();
  
  void setPassWord(String passWord);
  
  String getEmail();
  
  void setEmail(String email);
  
  String getPhoneNo();
  
  void setPhoneNo(String phoneNo);
  
  String getFirstName();
  
  void setFirstName(String firstName);
  
  String getLastName();
  
  void setLastName(String lastName);
  
}
