package com.questionservice.repository;

import java.util.List;



import com.questionservice.model.Question;

public interface CustomQuestionRepository {

	public List<Question> getAllQuestion(String category, int marks);
	
}
