package com.ncs.login.exception;

public class UserNotFoundException extends Exception {

	private String errorMsg;
	private int userInput;

	public UserNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(int userInput) {

		this.userInput = userInput;
	}

	public UserNotFoundException(String errorMsg, int userInput) {
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
		return "UserNotFoundException [errorMsg=" + "User Not Found - " + userInput + "]";
	}

}
