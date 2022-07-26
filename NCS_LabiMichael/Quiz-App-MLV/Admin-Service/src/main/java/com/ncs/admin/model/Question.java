package com.ncs.admin.model;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties("hibernateLazyInitializer")
@Entity
public class Question implements Comparable<Question>, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	@NotNull(message = "Question cannot be left blank.")
	private String questionString;
	@NotNull(message = "Category cannot be left blank.")
	private String category;
	@Min(value = 1, message = "Marks cannot be negative.")
	private int marks;
	@NotNull(message = "Option 1 cannot be left blank.")
	private String option1;
	@NotNull(message = "Option 2 cannot be left blank.")
	private String option2;
	@NotNull(message = "Option 3 cannot be left blank.")
	private String option3;
	@NotNull(message = "Option 4 cannot be left blank.")
	private String option4;
	@NotNull(message = "Answer cannot be left blank.")
	private String answer;

	public Question() {
		// TODO Auto-generated constructor stub
	}

	public Question(int questionId, String questionString, String category, int marks, String option1, String option2,
			String option3, String option4, String answer) {
		super();
		this.questionId = questionId;
		this.questionString = questionString;
		this.category = category;
		this.marks = marks;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionString() {
		return questionString;
	}

	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getanswer() {
		return answer;
	}

	public void setanswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionString=" + questionString + ", category=" + category
				+ ", marks=" + marks + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3
				+ ", option4=" + option4 + ", answer=" + answer + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, answer, marks, option1, option2, option3, option4, questionId,
				questionString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(category, other.category) && Objects.equals(answer, other.answer)
				&& marks == other.marks && Objects.equals(option1, other.option1)
				&& Objects.equals(option2, other.option2) && Objects.equals(option3, other.option3)
				&& Objects.equals(option4, other.option4) && questionId == other.questionId
				&& Objects.equals(questionString, other.questionString);
	}

	@Override
	public int compareTo(Question q1) {
		// TODO Auto-generated method stub
		return this.getQuestionId() - q1.getQuestionId();
	}

}

