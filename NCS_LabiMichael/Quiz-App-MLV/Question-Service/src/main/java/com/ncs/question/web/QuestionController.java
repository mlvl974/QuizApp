package com.ncs.question.web;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.question.model.Question;
import com.ncs.question.service.QuestionService;


@Validated
@RestController
@CrossOrigin(origins = {"http://localhost:8083", "http://localhost:4200"},allowedHeaders = "*")
@RequestMapping("/abc-university/question")
public class QuestionController {

	@Autowired
	QuestionService questionService;

	public QuestionController() {
		System.out.println("--->> Question Controller Constructor ....");
	}

	@PostMapping("/add")
	public ResponseEntity<Question> addQuestion(@RequestBody @Valid Question question) {
		
		Question savedQuestion = questionService.addQuestion(question);
		return new ResponseEntity<Question>(savedQuestion, HttpStatus.OK); 
	}

	@GetMapping("/allQuestions")
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	@GetMapping("/getByCategory/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
		List<Question> list = questionService.getAllQuestionsByCategory(category);

		return new ResponseEntity<List<Question>>(list, HttpStatus.OK);
	}

	@GetMapping("/getByMarks/{marks}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable int marks) {
		List<Question> list = questionService.getAllQuestionsByMarks(marks);

		return new ResponseEntity<List<Question>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getByCategoryAndMarks/{category}/{marks}")
	
	public ResponseEntity<List<Question>> getQuestionsByCategoryAndMarks(@PathVariable String category,
			@PathVariable int marks) {
		List<Question> list = questionService.getAllQuestionsByCategoryAndMarks(category, marks);

		return new ResponseEntity<List<Question>>(list, HttpStatus.OK);
	}

	@PutMapping("/update")
	public Question updateQuestion(@RequestBody Question question) {

		return questionService.updateQuestion(question);
		
	}

	@DeleteMapping("/delete/{questionId}")
	public void deleteQuestion(@PathVariable int questionId) {
		questionService.deleteQuestion(questionId);
	}
	
	@GetMapping("/getQuiz")
	public ResponseEntity <List<Question>> getQuiz(@RequestParam String category, @RequestParam int marks)
	{
		
		List<Question> list = questionService.getQuiz(category, marks);
		return new ResponseEntity<List<Question>>(list, HttpStatus.OK);
	}
	

}// end of class
