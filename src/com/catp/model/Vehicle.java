package com.catp.model;


public class Vehicle {
	private String mName, vCode, colour, bLocation;
	private int exPrice, vAvailable, sCapacity;
	private java.util.Date stockDate ;
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getvCode() {
		return vCode;
	}
	public void setvCode(String vCode) {
		this.vCode = vCode;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public java.util.Date getStockDate() {
		return stockDate;
	}
	public void setStockDate(java.util.Date stockDate) {
		this.stockDate = stockDate;
	}
	public String getbLocation() {
		return bLocation;
	}
	public void setbLocation(String bLocation) {
		this.bLocation = bLocation;
	}
	public int getExPrice() {
		return exPrice;
	}
	public void setExPrice(int exPrice) {
		this.exPrice = exPrice;
	}
	public int getvAvailable() {
		return vAvailable;
	}
	public void setvAvailable(int vAvailable) {
		this.vAvailable = vAvailable;
	}
	public int getsCapacity() {
		return sCapacity;
	}
	public void setsCapacity(int sCapacity) {
		this.sCapacity = sCapacity;
	}
	
}
