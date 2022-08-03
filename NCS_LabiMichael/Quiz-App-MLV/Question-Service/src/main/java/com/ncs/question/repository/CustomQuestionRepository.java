package com.ncs.question.repository;

import java.util.List;

import com.ncs.question.model.Question;

public interface CustomQuestionRepository {

	public List<Question> getAllQuestionByCategoryAndMarks(String category, int marks);

	public List<Question> getAllQuestionsByCategory(String category);

	public List<Question> getAllQuestionByMarks(int marks);

	public boolean updateAnswer(int questionId, String answer);
}
