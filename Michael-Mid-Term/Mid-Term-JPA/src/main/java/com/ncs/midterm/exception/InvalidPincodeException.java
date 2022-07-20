package com.ncs.midterm.exception;

public class InvalidPincodeException extends Exception {
	private String errorMsg;
	private long userInput;
	
	
	public InvalidPincodeException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvalidPincodeException(String errorMsg, long userInput) {
		super();
		this.errorMsg = errorMsg;
		this.userInput = userInput;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public long getUserInput() {
		return userInput;
	}
	public void setUserInput(long userInput) {
		this.userInput = userInput;
	}
	@Override
	public String toString() {
		return "InvalidPincodeException [errorMsg=" +errorMsg+" Pincode can only have max 8 digits=" + userInput + "]";
	}

	
}
