package com.harvraja.myclerk.shared;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

public class UserProfile implements IsSerializable {
  private String username;
  private String fname;
  private String lname;
  private String password;
  private String city;
  ArrayList requests = new ArrayList();
	public UserProfile(){
	  
  }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
