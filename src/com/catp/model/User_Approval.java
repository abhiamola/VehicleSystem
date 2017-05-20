package com.catp.model;
import java.sql.Date;


public class User_Approval {
int userId;
String role;
Date createdDate;
String Status;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
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
	return Status;
}
public void setStatus(String status) {
	Status = status;
}

}
