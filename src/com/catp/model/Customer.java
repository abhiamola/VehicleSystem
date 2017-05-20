package com.catp.model;

import java.util.Date;

public class Customer {
	private int login_id;
	private String cusName;
	private Date dob;
	private String address;
	private String email;
	private String phone;
	private String occ;
	
	public Customer()
	{
		
	}

	public Customer(int login_id, String cusName, Date dob, String address,
			String email, String phone, String occ) {
		super();
		this.login_id = login_id;
		this.cusName = cusName;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.occ = occ;
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public String getOcc() {
		return occ;
	}

	public void setOcc(String occ) {
		this.occ = occ;
	}
	
}
