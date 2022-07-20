package com.adminservice.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminservice.model.Question;
import com.adminservice.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	@Override
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Question getQuestionDetails(int questionId) {
		return questionRepository.findById(questionId).get();
	}

	@Override
	public List<Question> getAllQuestions() {

		return questionRepository.findAll();
	}

	@Override
	public boolean deleteQuestion(int questionId) {
		 questionRepository.deleteById(questionId);
		 return true;

	}

	@Override
	public Question updateAnswer(int questionId,String answer) {
		boolean status = questionRepository.updateAnswer(questionId,answer);
		if(status)
		{
			Question question = getQuestionDetails(questionId);
			return question;
		}
		
		
		else return null;
	}

}
