package com.ncs.student.web;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.client.RestTemplate;

import com.ncs.student.dto.QuizResultDTO;
import com.ncs.student.model.Question;

import com.ncs.student.model.Result;
import com.ncs.student.model.User;
import com.ncs.student.service.StudentService;
import com.ncs.student.util.QuizResultDTOConversion;

@RestController
@CrossOrigin(origins = { "http://localhost:8084", "http://localhost:4200" }, allowedHeaders = "*")
@RequestMapping("/abc-university/student")
public class StudentController {

	String orgKey = "ncs-";

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	StudentService studentService;

	@Autowired
	QuizResultDTOConversion quizResultDTOConversion;

	public StudentController() {
		System.out.println("--->> Student Controller Constructor ....");
	}

	public boolean validateToken(HttpServletRequest request) {

		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", orgKey + request.getHeader("Authorization"));
		headers.set("userType", "student");
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Boolean> tokenTrue = restTemplate.exchange("http://LOGIN-SERVICE/abc-university/public/validate",
				HttpMethod.GET, entity, Boolean.class);

		return tokenTrue.getBody().booleanValue();
	}

	// ---------------------- Question ------------------------------------//

	// getQuiz
	@GetMapping("/{userId}/getQuiz")
	public ResponseEntity<?> getQuiz(@PathVariable int userId, @PathVariable @RequestParam String category,
			@RequestParam int marks, HttpServletRequest request) {
		boolean tokenIsValid = validateToken(request);
		if (tokenIsValid) {
			Map<String, String> uriParams = new HashMap<String, String>();
			uriParams.put("category", category);
			uriParams.put("marks", String.valueOf(marks));

			List<Question> list = restTemplate.getForObject(
					"http://QUESTION-SERVICE/abc-university/question/getQuiz?category={category}&marks={marks} ",
					List.class, uriParams);
			return new ResponseEntity<List<Question>>(list, HttpStatus.OK);
		}
		return null;
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
	// ---------------------- Result ------------------------------------//

	@PostMapping("/result/{userId}/submitQuiz")
	public ResponseEntity<QuizResultDTO> submitQuiz(@PathVariable int userId,
			@RequestBody @Valid QuizResultDTO quizResultDTO, HttpServletRequest request) {
		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {

			User user = studentService.getUserById(userId);
			System.err.println("userId - " + userId);

			Result result = quizResultDTOConversion.convertToResultResponse(user, quizResultDTO);

			QuizResultDTO dto = restTemplate.postForObject("http://RESULT-SERVICE/abc-university/result/submit", result,
					QuizResultDTO.class);
			return new ResponseEntity<QuizResultDTO>(dto, HttpStatus.OK);
		}
		return null;

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

	@GetMapping("/result/getByUserId/{userId}")
	public List<Result> getResultByUserId(@PathVariable int userId, HttpServletRequest request) {
		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {
			List<Result> list = restTemplate
					.getForObject("http://RESULT-SERVICE/abc-university/result/getByUserId/" + userId, List.class);
			return list;
		} else {
			// add throw exception
			return null;
		}

	}

	@GetMapping("/result/date")
	public List<Result> getResultsByDateRange(@RequestParam String date1, @RequestParam String date2,
			HttpServletRequest request) {
		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {
			Map<String, String> uriParams = new HashMap<String, String>();
			uriParams.put("date1", date1);
			uriParams.put("date2", date2);

			List<Result> list = restTemplate.getForObject(
					"http://RESULT-SERVICE/abc-university/result/date?date1={date1}&date2={date2}", List.class,
					uriParams);
			return list;
		} else {
			// add throw exception
			return null;
		}

	}

	@GetMapping("/result/getByCategory/{category}")
	public List<Question> getResultByCategory(@PathVariable String category, HttpServletRequest request) {
		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {
			List<Question> list = restTemplate
					.getForObject("http://RESULT-SERVICE/abc-university/result/getByCategory/" + category, List.class);

			return list;
		} else {
			// add throw exception
			return null;
		}

	}

	@GetMapping("/result/getByMarks/{marks}")
	public List<Question> getResultByCategory(@PathVariable int marks, HttpServletRequest request) {
		boolean tokenIsValid = validateToken(request);

		if (tokenIsValid) {
			List<Question> list = restTemplate
					.getForObject("http://RESULT-SERVICE/abc-university/result/getByMarks/" + marks, List.class);

			return list;
		} else {
			// add throw exception
			return null;
		}

	}

}
