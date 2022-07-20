package com.ncs.midterm.exception;

public class InvalidAgeException extends Exception {

	private String errorMsg;
	private int userInput;
	
	
	public InvalidAgeException() {
		
	}
	
	
	public InvalidAgeException(String errorMsg, int userInput) {
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

	public int getUserInput() {
		return userInput;
	}

	public void setUserInput(int userInput) {
		this.userInput = userInput;
	}


	@Override
	public String toString() {
		return "InvalidAgeException [errorMsg= Age must be above 18 =" + userInput + "]";
	}


	
	
	
	

}
