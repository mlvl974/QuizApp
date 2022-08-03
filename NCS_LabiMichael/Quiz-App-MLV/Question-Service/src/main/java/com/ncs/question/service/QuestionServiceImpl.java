package com.ncs.question.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.question.model.Question;
import com.ncs.question.repository.QuestionRepository;


@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	@Override
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public List<Question> getAllQuestions() {

		return questionRepository.findAll();
	}

	@Override
	public List<Question> getAllQuestionsByCategoryAndMarks(String category, int marks) {
		return questionRepository.getAllQuestionByCategoryAndMarks(category, marks);
	}

	@Override
	public List<Question> getAllQuestionsByCategory(String category) {
		return questionRepository.getAllQuestionsByCategory(category);

	}

	@Override
	public List<Question> getAllQuestionsByMarks(int marks) {
		return questionRepository.getAllQuestionByMarks(marks);

	}
	
	

	@Override
	public List<Question> getQuiz(String category, int marks) {
		List<Question> allQuestion = questionRepository.getAllQuestionByCategoryAndMarks(category, marks);
		List<Question> list = new ArrayList<Question>();
		Random random = new Random();
		while(list.size()!=20)
		{
			int rand = random.nextInt(allQuestion.size());
			list.add(allQuestion.get(rand));
			allQuestion.remove(rand);
			
		}
					System.out.println(list);

				return list;
	}

	

	@Override
	public Question updateAnswer(int questionId, String answer) {
		boolean status = questionRepository.updateAnswer(questionId, answer);
		if (status) {
			Question question = questionRepository.findById(questionId).get();
			return question;
		}

		else
			return null;
	}

	@Override
	public Question updateQuestion(Question question) {

		 return	questionRepository.save(question);
	}

	@Override
	public boolean deleteQuestion(int questionId) {
		questionRepository.deleteById(questionId);
		return true;

	}
	
	

}
