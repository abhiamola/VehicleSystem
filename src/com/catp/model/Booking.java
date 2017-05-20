package com.catp.model;

import java.util.Date;

public class Booking {
		String customerName;
		String vehicleCode; 
		String manufactureName;
		String status;
		String vehicleName;
		String branch; 
		String color;
		int stockNo ;
		int reqno;
		int exShowroomPrice;
		Date stockLastTill;
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getVehicleCode() {
			return vehicleCode;
		}
		public void setVehicleCode(String vehicleCode) {
			this.vehicleCode = vehicleCode;
		}
		public String getManufactureName() {
			return manufactureName;
		}
		public void setManufactureName(String manufactureName) {
			this.manufactureName = manufactureName;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getVehicleName() {
			return vehicleName;
		}
		public void setVehicleName(String vehicleName) {
			this.vehicleName = vehicleName;
		}
		public String getBranch() {
			return branch;
		}
		public void setBranch(String branch) {
			this.branch = branch;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public int getStockNo() {
			return stockNo;
		}
		public void setStockNo(int stockNo) {
			this.stockNo = stockNo;
		}
		public int getExShowroomPrice() {
			return exShowroomPrice;
		}
		public void setExShowroomPrice(int exShowroomPrice) {
			this.exShowroomPrice = exShowroomPrice;
		}
		public Date getStockLastTill() {
			return stockLastTill;
		}
		public void setStockLastTill(Date stockLastTill) {
			this.stockLastTill = stockLastTill;
		}
		public int getReqno() {
			return reqno;
		}
		public void setReqno(int reqno) {
			this.reqno = reqno;
		}
		
		
		
}