package com.ncs.admin.exception;

public class InvalidCategoryException extends Exception {

	private String errorMsg;
	private int userInput;

	public InvalidCategoryException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidCategoryException(String errorMsg, int userInput) {
		super();
		this.errorMsg = errorMsg;
		this.userInput = userInput;
	}

	@Override
	public String toString() {
		return "InvalidCategoryException [errorMsg=" + "Invalid Category -" + userInput + "]";
	}

}// end of class
