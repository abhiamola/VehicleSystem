package com.catp.model;

public class AddRequestAdmin {
	private String bName, vCode, color, approveRequest, comments, vehiclesApproved;  
    private int requested, mainStock;
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getvCode() {
		return vCode;
	}
	public void setvCode(String vCode) {
		this.vCode = vCode;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getApproveRequest() {
		return approveRequest;
	}
	public void setApproveRequest(String approveRequest) {
		this.approveRequest = approveRequest;
	}
	public String getVehiclesApproved() {
		return vehiclesApproved;
	}
	public void setVehiclesApproved(String vehiclesApproved) {
		this.vehiclesApproved = vehiclesApproved;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getRequested() {
		return requested;
	}
	public void setRequested(int requested) {
		this.requested = requested;
	}
	public int getMainStock() {
		return mainStock;
	}
	public void setMainStock(int mainStock) {
		this.mainStock = mainStock;
	}
	
}
