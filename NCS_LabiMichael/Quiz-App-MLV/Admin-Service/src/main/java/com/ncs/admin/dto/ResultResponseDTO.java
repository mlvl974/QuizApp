package com.ncs.admin.dto;

import java.time.LocalDate;


import com.ncs.admin.model.User;

public class ResultResponseDTO {
	private int testId;
	private int userId;
	private String date;
	private String category;
	private String level;
	private int totalScore;
	private int marks;
	
	public ResultResponseDTO() {
		super();
		
	}

	

	public ResultResponseDTO(int testId, int userId, String date, String category, String level, int totalScore,
			int marks) {
		super();
		this.testId = testId;
		this.userId = userId;
		this.date = date;
		this.category = category;
		this.level = level;
		this.totalScore = totalScore;
		this.marks = marks;
	}



	public int getTestId() {
		return testId;
	}



	public void setTestId(int testId) {
		this.testId = testId;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}



	@Override
	public String toString() {
		return "ResultResponseDTO [testId=" + testId + ", userId=" + userId + ", date=" + date + ", category="
				+ category + ", level=" + level + ", totalScore=" + totalScore + ", marks=" + marks + "]";
	}

	
	
	
	

	
	
}
