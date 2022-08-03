package com.ncs.student.dto;

public class QuizResultDTO {


	private String date;
	private String category;
	private String level;
	private int marks;
	private int totalScore;
	
	public QuizResultDTO() {
		super();
		
	}

	public QuizResultDTO(String date, String category, String level, int marks, int totalScore) {
		super();
		this.date = date;
		this.category = category;
		this.level = level;
		this.marks = marks;
		this.totalScore = totalScore;
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

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return "QuizResultDTO [date=" + date + ", category=" + category + ", level=" + level + ", marks=" + marks
				+ ", totalScore=" + totalScore + "]";
	}

	
	
	
	
}
