package com.ncs.login.exception;

public class DuplicateUserException extends Exception{

	private String errorMsg;
	private String name;
	
	
	
	
	
	public DuplicateUserException() {
		super();
		
	}



	public DuplicateUserException(String errorMsg, String name) {
		super();
		this.errorMsg = errorMsg;
		this.name = name;
	}
	
	
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "DuplicateUserException [errorMsg=" + errorMsg + ", name=" + name + "]";
	}
	
	
}
