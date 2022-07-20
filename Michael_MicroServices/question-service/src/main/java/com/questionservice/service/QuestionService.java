package com.questionservice.service;

import java.util.List;

import com.questionservice.model.Question;

public interface QuestionService {

	public Question getQuestionDetails(int questionId);

	public List<Question> getAllQuestions();
	
	public List<Question> getAllQuestion(String category, int marks);

}
