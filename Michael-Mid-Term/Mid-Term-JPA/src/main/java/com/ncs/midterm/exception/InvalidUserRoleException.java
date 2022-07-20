package com.ncs.midterm.exception;

public class InvalidUserRoleException extends Exception {

	private String errorMsg;
	private int userInput;
	
	
	public InvalidUserRoleException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public InvalidUserRoleException(String errorMsg, int userInput) {
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
		return "InvalidUserRoleException [errorMsg=" +errorMsg+" Only admin, public & user roles allowed-" + userInput + "]";
	}
	
	
	
}
