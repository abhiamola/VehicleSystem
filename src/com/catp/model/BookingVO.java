package com.catp.model;


public class BookingVO {
	
	String user_id;
	String vehicle_id;
	String manufacturer_name;
	int exprice;
	String branch_location;
	String color ;
	int seating;
	String status="N";
	int vehicle_in_stock;
	String stock_lasts_till;
	String comments;
	String bookingconfirmdate;
	public String getBookingconfirmdate() {
		return bookingconfirmdate;
	}

	public void setBookingconfirmdate(String bookingconfirmdate) {
		this.bookingconfirmdate = bookingconfirmdate;
	}

	public BookingVO() {
		
		user_id = "1001";
		// TODO Auto-generated constructor stub
	}
	
	public BookingVO(String user_id, String vehicle_id,
			String manufacturer_name, int exprice, String branch_location,
			String color, int seating, String status, int vehicle_in_stock,
			String stock_lasts_till, String comments) {
		super();
		this.user_id = user_id;
		this.vehicle_id = vehicle_id;
		this.manufacturer_name = manufacturer_name;
		this.exprice = exprice;
		this.branch_location = branch_location;
		this.color = color;
		this.seating = seating;
		this.status = status;
		this.vehicle_in_stock = vehicle_in_stock;
		this.stock_lasts_till = stock_lasts_till;
		this.comments = comments;
	}

	
	
	
	
	
	
	
	
	
	
	
	public int getSeating() {
		return seating;
	}
	public void setSeating(int seating) {
		this.seating = seating;
	}
	public int getExprice() {
		return exprice;
	}
	public int getVehicle_in_stock() {
		return vehicle_in_stock;
	}
	public void setVehicle_in_stock(int vehicle_in_stock) {
		this.vehicle_in_stock = vehicle_in_stock;
	}

	public void setExprice(int exprice) {
		this.exprice = exprice;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getManufacturer_name() {
		return manufacturer_name;
	}
	public void setManufacturer_name(String manufacturer_name) {
		this.manufacturer_name = manufacturer_name;
	}
	public String getBranch_location() {
		return branch_location;
	}
	public void setBranch_location(String branch_location) {
		this.branch_location = branch_location;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStock_lasts_till() {
		return stock_lasts_till;
	}
	public void setStock_lasts_till(String stock_lasts_till) {
		this.stock_lasts_till = stock_lasts_till;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
	

}

