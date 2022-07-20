package com.adminservice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adminservice.model.Question;
import com.adminservice.model.Result;
import com.adminservice.model.User;
import com.adminservice.service.AdminService;
import com.adminservice.service.QuestionService;
import com.adminservice.service.ResultService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	@Autowired
	QuestionService questionService;

	@Autowired
	ResultService resultService;

	public AdminController() {
		System.out.println("--->> Admin Controller Constructor ....");
	}

	// ----------------------User REST API ------------------------------------//

	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return adminService.addUser(user);
	}

	@GetMapping("/user/{userId}")
	public User getUserDetails(@PathVariable int userId) {
		return adminService.getUserDetails(userId);
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return adminService.getAllUser();
	}

	@DeleteMapping("/user/{userId}")
	public void deleteUser(@PathVariable int userId) {
		adminService.deleteUser(userId);
	}

	// ----------------------Question REST API ------------------------------------//
	@PostMapping("/question/add")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {

		Question savedQuestion = questionService.addQuestion(question);
		return new ResponseEntity<Question>(savedQuestion, HttpStatus.OK);

	}

	@PutMapping("/update/{questionId}/answer")
	public Question updateAnswer(@PathVariable int questionId, @RequestParam String answer) {

		return questionService.updateAnswer(questionId, answer);
	}

	@DeleteMapping("{questionId}")
	public void deleteQuestion(@PathVariable int questionId) {
		questionService.deleteQuestion(questionId);
	}
	
	// ----------------------Result REST API ------------------------------------//
	
	
	@PostMapping("/result/add")
	public ResponseEntity<Result> addResult(@RequestBody Result result)
	{
		Result savedResult = resultService.addResult(result);
		return new ResponseEntity<Result>(savedResult, HttpStatus.OK);
	}
	
	@PutMapping ("/update/{testId}/marks")
	public Result updateResultMarks(@PathVariable int testId, @RequestParam int marks)
	{
		return resultService.updateResultMarks(testId, marks);
	}
	
	@DeleteMapping("{testId}")
	public void deleteResult(@PathVariable int testId)
	{
		resultService.deleteResult(testId);
	}

}// end of class
