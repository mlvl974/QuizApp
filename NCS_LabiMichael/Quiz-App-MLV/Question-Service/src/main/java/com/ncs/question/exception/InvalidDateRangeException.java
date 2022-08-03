package com.ncs.question.exception;

public class InvalidDateRangeException extends Exception {

	private String date1;
	private String date2;
	private String errorMsg;

	public InvalidDateRangeException() {
		super();

	}

	public InvalidDateRangeException(String date1, String date2) {
		super();
		this.date1 = date1;
		this.date2 = date2;

	}

	public InvalidDateRangeException(String date1, String date2, String errorMsg) {
		super();
		this.date1 = date1;
		this.date2 = date2;
		this.errorMsg = errorMsg;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "InvalidDateRangeException [date1=" + date1 + ", date2=" + date2 + ", errorMsg=" + errorMsg + "]";
	}

}
