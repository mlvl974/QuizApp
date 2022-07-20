package com.questionservice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.questionservice.model.Question;
import com.questionservice.service.QuestionService;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
	QuestionService questionService;

	public QuestionController() {
		System.out.println("--->> Question Controller Constructor ....");
	}

	@GetMapping("/questions")
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	@GetMapping("/getById/{questionId}")
	public ResponseEntity<Question> getQuestionById(@PathVariable int questionId) {
		System.out.println("path variable:" + questionId);

		Question output = questionService.getQuestionDetails(questionId);
		return new ResponseEntity<Question>(output, HttpStatus.OK);

	}
	
	@GetMapping("/getByCategory")
	public ResponseEntity<List<Question>> getQuestionByCategory(@RequestParam String category, @RequestParam int marks)
	{
		List<Question> list = questionService.getAllQuestion(category, marks);
		System.out.println(list);
		return new ResponseEntity<List<Question>>(list, HttpStatus.OK);
	}


}// end of class
