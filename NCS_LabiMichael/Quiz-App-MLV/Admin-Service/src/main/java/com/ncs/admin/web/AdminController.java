package com.ncs.admin.web;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ncs.admin.dto.ResultResponseDTO;
import com.ncs.admin.exception.DuplicateUserException;
import com.ncs.admin.exception.InvalidUserRoleException;
import com.ncs.admin.exception.UserNotFoundException;
import com.ncs.admin.model.Question;
import com.ncs.admin.model.Result;
import com.ncs.admin.model.User;
import com.ncs.admin.service.AdminService;
import com.ncs.admin.util.UserDTOConversion;

@Validated
@RestController
@CrossOrigin(origins = { "http://localhost:8082", "http://localhost:4200" }, allowedHeaders = "*")
@RequestMapping("/abc-university/admin")
public class AdminController {

	String orgKey = "ncs-";

	@Autowired
	AdminService adminService;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	UserDTOConversion userDTOConversion;

	public AdminController() {
		System.out.println("--->> Admin Controller Constructor ....");
	}

	public boolean validateToken(HttpServletRequest request) {

		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", orgKey + request.getHeader("Authorization"));
		headers.set("userType", "admin");
		// headers.set("Authority", request.getHeader("Authority"));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Boolean> tokenTrue = restTemplate.exchange("http://LOGIN-SERVICE/abc-university/public/validate",
				HttpMethod.GET, entity, Boolean.class);

		return tokenTrue.getBody().booleanValue();
	}

	// ---------------------- User ------------------------------------//

	@PostMapping("/user/add")
	public ResponseEntity<User> addUser(@RequestBody @Valid User user, HttpServletRequest request)
			throws DuplicateUserException {

		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {
			User addedUser = adminService.addUser(user);
			System.out.println("User added -" + user);
			return new ResponseEntity<User>(addedUser, HttpStatus.OK);
		}
		return null;

	}

	@PutMapping("/user/update")
	public User updateUser(@RequestBody User user, HttpServletRequest request) throws UserNotFoundException {
		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {

			return adminService.updateUser(user);
		} else {
			throw new UserNotFoundException();
		}

	}

	@GetMapping("/user/{userId}")

	public User getUserDetails(@PathVariable int userId, HttpServletRequest request) throws UserNotFoundException {
		boolean tokenIsValid = validateToken(request);

		if ((tokenIsValid) && (userId > 0)) {

			return adminService.getUserDetails(userId);
		} else {

			throw new UserNotFoundException(userId);

		}

	}

	@GetMapping("/allUsers")
	public List<User> getAllUsers(HttpServletRequest request) {
		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {
			return adminService.getAllUser();
		}

		else {
			// add throw exception
			return null;
		}

	}

	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId, HttpServletRequest request) {

		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {

			adminService.deleteUser(userId);
			String msg = "User deleted -" + userId;
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		return null;

	}

	// ---------------------- Question ------------------------------------//
	@PostMapping("/question/add")
	public ResponseEntity<Question> addQuestion(@RequestBody @Valid Question question, HttpServletRequest request) {
		boolean tokenIsValid = validateToken(request);
		if (tokenIsValid) {
			ResponseEntity<Question> savedQuestion = restTemplate
					.postForEntity("http://QUESTION-SERVICE/abc-university/question/add", question, Question.class);

			return savedQuestion;
		} else {
			// add throw exception
			return null;
		}

	}

	@PutMapping("/question/update")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question, HttpServletRequest request) {
		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {
			Question updatedQuestion = question;
			restTemplate.put("http://QUESTION-SERVICE/abc-university/question/update", updatedQuestion, Question.class);
			return new ResponseEntity<Question>(updatedQuestion, HttpStatus.OK);
		} else {
			// add throw exception
			return null;
		}

	}

	@GetMapping("/question/allQuestions")
	public List<Question> getAllQuestions(HttpServletRequest request) {

		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {
			List<Question> list = restTemplate
					.getForObject("http://QUESTION-SERVICE/abc-university/question/allQuestions", List.class);
			return list;
		} else {
			// add throw exception
			return null;
		}

	}

	@GetMapping("/question/getByCategory/{category}") // /question/getByCategory/?category=science
	public List<Question> getQuestionsByCategory(@PathVariable String category, HttpServletRequest request) {
		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {
			List<Question> list = restTemplate.getForObject(
					"http://QUESTION-SERVICE/abc-university/question/getByCategory/" + category, List.class);

			return list;
		} else {
			// add throw exception
			return null;
		}

	}

	@GetMapping("/question/getByMarks/{marks}")
	public List<Question> getQuestionsByMarks(@PathVariable int marks, HttpServletRequest request) {
		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {
			List<Question> list = restTemplate
					.getForObject("http://QUESTION-SERVICE/abc-university/question/getByMarks/" + marks, List.class);

			return list;
		} else {
			// add throw exception
			return null;
		}

	}

	@DeleteMapping("/delete/{questionId}")
	public ResponseEntity<String> deleteQuestion(@PathVariable int questionId, HttpServletRequest request) {
		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {
			restTemplate.delete("http://Question-Service/abc-university/question" + questionId);
			return new ResponseEntity<String>("Deleted question -" + questionId, HttpStatus.OK);
		} else {
			// add throw exception
			return null;
		}
	}

	// ---------------------- Result ------------------------------------//

	@PutMapping("/result/update/{testId}")
	public ResponseEntity<String> updateResult(@PathVariable int testId, @RequestBody ResultResponseDTO result,
			HttpServletRequest request) {
		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {

			restTemplate.put("http://RESULT-SERVICE/abc-university/result/update/{testId}", result, testId);
			String updated = "Result updated -" + testId;
			return new ResponseEntity<String>(updated, HttpStatus.OK);
		} else {
			return null;
		}
	}

	@GetMapping("/result/allResults")
	public List<Question> getAllResults(HttpServletRequest request) {
		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {
			List<Question> list = restTemplate.getForObject("http://RESULT-SERVICE/abc-university/result/allResults",
					List.class);

			return list;
		} else {
			// add throw exception
			return null;
		}

	}

	@DeleteMapping("/delete/{testId}")
	public ResponseEntity<String> deleteResult(@PathVariable int testId, HttpServletRequest request) {

		boolean tokenIsValid = validateToken(request);
		if (tokenIsValid) {
			restTemplate.delete("http://RESULT-SERVICE/abc-university/result/" + testId);
			return new ResponseEntity<String>("Deleted result -" + testId, HttpStatus.OK);

		} else {
			// add throw exception
			return null;
		}

	}

}// end of class
