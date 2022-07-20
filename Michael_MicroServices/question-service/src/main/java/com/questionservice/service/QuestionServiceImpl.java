package com.questionservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionservice.model.Question;
import com.questionservice.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	
	@Override
	public Question getQuestionDetails(int questionId) {
		return questionRepository.findById(questionId).get();
	}

	@Override
	public List<Question> getAllQuestions() {

		return questionRepository.findAll();
	}

	@Override
	public List<Question> getAllQuestion(String category, int marks) {
		return questionRepository.getAllQuestion(category, marks);
	}

	

}
