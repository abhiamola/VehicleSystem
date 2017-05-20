package com.catp.model;
import java.util.Date;


public class User {
	private int userId;
	private String password;
	private String role;
	private Date createdDate;
	private String status;
	
	public User()
	{
	}
	
	public User(int userId, String password, String role, Date createdDate,
			String status) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.createdDate = createdDate;
		this.status = status;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	

}
