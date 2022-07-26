package com.ncs.student.model;

import java.io.Serializable;


import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("hibernateLazyInitializer")
@Entity
public class Result implements Comparable<Result>, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testId;
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	@NotNull(message = "Date cannot be null.")
	private String date;
	@NotNull(message = "Category cannot be left blank.")
	private String category;
	@NotNull(message = "Level cannot be left blank.")
	private String level;
	@Min(value = 0, message = "totalScore cannot be negative.")
	@Max (value =100, message = "totalScore limit is 100")
	private int totalScore;
	@Min(value = 0, message = "Marks cannot be negative.")
	private int marks;
	
	
	public Result() {
		// TODO Auto-generated constructor stub
	}


	

	public Result(int testId, User user, @NotNull(message = "Date cannot be null.") String date,
			@NotNull(message = "Category cannot be left blank.") String category,
			@NotNull(message = "Level cannot be left blank.") String level,
			@Min(value = 0, message = "totalScore cannot be negative.") @Max(value = 100, message = "totalScore limit is 100") int totalScore,
			@Min(value = 0, message = "Marks cannot be negative.") int marks) {
		super();
		this.testId = testId;
		this.user = user;
		this.date = date;
		this.category = category;
		this.level = level;
		this.totalScore = totalScore;
		this.marks = marks;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public Result(int testId, @NotNull String date, @NotNull String category, @NotNull String level,
			int totalScore, int marks) {
		super();
		this.testId = testId;
		
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
	public int compareTo(Result r1) {
		// TODO Auto-generated method stub
		return this.getTestId()-r1.getTestId();
	}


	@Override
	public int hashCode() {
		return Objects.hash(category, date, level, marks, testId, totalScore);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		return Objects.equals(category, other.category) && Objects.equals(date, other.date)
				&& Objects.equals(level, other.level) && marks == other.marks && testId == other.testId
				&& totalScore == other.totalScore;
	}




	@Override
	public String toString() {
		return "Result [testId=" + testId + ", user=" + user + ", date=" + date + ", category=" + category + ", level="
				+ level + ", totalScore=" + totalScore + ", marks=" + marks + "]";
	}


	

	
	
	

}
