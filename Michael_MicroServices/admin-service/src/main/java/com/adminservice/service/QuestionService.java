package com.adminservice.service;

import java.util.List;



import com.adminservice.model.Question;

public interface QuestionService {

	public Question addQuestion(Question question);
	public Question getQuestionDetails(int questionId);
	public List<Question> getAllQuestions();
	public boolean deleteQuestion(int questionId);
	
	public Question updateAnswer(int questionId, String answer);
	
	
}
