package com.catp.exception;

public class VRSBusinessException extends Exception{

	private static final long serialVersionUID = 1L;

	public VRSBusinessException(){
		super("No of Vehicles in Main Memory are not enough to cater the request.");
	}
}
