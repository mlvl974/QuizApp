package com.ncs.question.service;

import java.util.List;


import com.ncs.question.model.Question;


public interface QuestionService {

	public Question addQuestion(Question question);
	
	
	public List<Question> getAllQuestions();

	// Custom Repo
	public List<Question> getAllQuestionsByCategory(String category);

	public List<Question> getAllQuestionsByMarks(int marks);

	public List<Question> getAllQuestionsByCategoryAndMarks(String category, int marks);


	public Question updateAnswer(int questionId, String answer);

	public Question updateQuestion(Question question);
	
	public boolean deleteQuestion(int questionId);
	
	public List<Question> getQuiz(String category, int marks);
	
	
	

}
