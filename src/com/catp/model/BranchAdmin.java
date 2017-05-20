package com.catp.model;

import java.util.Date;

public class BranchAdmin {
	private int login_id;
	private String bLoc;
	private String address;
	private String email;
	private String phone;
	
	public BranchAdmin(){}
	
	public BranchAdmin(int login_id, String bLoc, String address, String email,
			String phone) {
		super();
		this.login_id = login_id;
		this.bLoc = bLoc;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	public String getbLoc() {
		return bLoc;
	}

	public void setbLoc(String bLoc) {
		this.bLoc = bLoc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
