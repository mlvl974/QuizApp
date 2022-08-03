package com.ncs.login.exception;

public class InvalidUserRoleException extends Exception {

	private String errorMsg;
	private String userInput;

	public InvalidUserRoleException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidUserRoleException(String errorMsg, String userInput) {
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

	public String getUserInput() {
		return userInput;
	}

	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}

	@Override
	public String toString() {
		return "InvalidUserRoleException [errorMsg= " + "Only admin & student roles allowed-" + userInput + "]";
	}

}
