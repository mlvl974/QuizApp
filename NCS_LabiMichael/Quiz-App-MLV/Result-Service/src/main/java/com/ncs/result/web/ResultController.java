package com.ncs.result.web;

import java.util.List;

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

import com.ncs.result.dto.ResultResponseDTO;
import com.ncs.result.exception.InvalidDateRangeException;
import com.ncs.result.model.Result;

import com.ncs.result.service.ResultService;
import com.ncs.result.util.ResultDTOConversion;

@Validated
@RestController
@CrossOrigin(origins = { "http://localhost:8085", "http://localhost:4200" }, allowedHeaders = "*")
@RequestMapping("/abc-university/result")
public class ResultController {

	@Autowired
	ResultService resultService;

	@Autowired
	ResultDTOConversion resultDTOConversion;

	@PostMapping("/submit")
	public ResponseEntity<ResultResponseDTO> submitQuiz(@RequestBody @Valid Result result) {

		Result savedResult = resultService.submitQuiz(result);
		ResultResponseDTO dto = resultDTOConversion.convertToResponse(savedResult);
		return new ResponseEntity<ResultResponseDTO>(dto, HttpStatus.OK);

	}

	@PutMapping("/update/{testId}")
	public ResponseEntity<ResultResponseDTO> updateResult(@PathVariable int testId, ResultResponseDTO result) {
		Result updateResult = resultService.updateResult(testId, result);
		ResultResponseDTO dto = resultDTOConversion.convertToResponse(updateResult);
		return new ResponseEntity<ResultResponseDTO>(dto, HttpStatus.OK);
	}

	@GetMapping("/allResults") // localhost:8085/abc-university/result/allResults
	public ResponseEntity<List<ResultResponseDTO>> getAllResults() {
		List<Result> list = resultService.getAllResults();
		List<ResultResponseDTO> dto = resultDTOConversion.convertToResponse(list);
		return new ResponseEntity<List<ResultResponseDTO>>(dto, HttpStatus.OK);
	}

	@GetMapping("/getByUserId/{userId}")
	public ResponseEntity<List<ResultResponseDTO>> getResultByUserId(@PathVariable int userId) {
		List<Result> list = resultService.getResultByUserId(userId);
		List<ResultResponseDTO> dto = resultDTOConversion.convertToResponse(list);
		return new ResponseEntity<List<ResultResponseDTO>>(dto, HttpStatus.OK);
	}

	@GetMapping("/getByCategory/{category}") // localhost:8085/abc-university/result/getByCategory/{category}
	public ResponseEntity<List<ResultResponseDTO>> getResultByCategory(@PathVariable String category) {

		List<Result> list = resultService.getAllResultsByCategory(category);
		List<ResultResponseDTO> dto = resultDTOConversion.convertToResponse(list);
		return new ResponseEntity<List<ResultResponseDTO>>(dto, HttpStatus.OK);
	}

	@GetMapping("/getByMarks/{marks}") // localhost:8085/abc-university/result/getByMarks/{marks}
	public ResponseEntity<List<ResultResponseDTO>> getResultByMarks(@PathVariable int marks) {
		List<Result> list = resultService.getAllResultsByMarks(marks);
		List<ResultResponseDTO> dto = resultDTOConversion.convertToResponse(list);
		return new ResponseEntity<List<ResultResponseDTO>>(dto, HttpStatus.OK);
	}

	@GetMapping("/date")
	public ResponseEntity<List<ResultResponseDTO>> getResultsByDateRange(@RequestParam String date1,
			@RequestParam String date2) throws InvalidDateRangeException {
		if (date1 == null || date1 == date2) {

			throw new InvalidDateRangeException();
		}
		List<Result> list = resultService.getAllResultsByDateRange(date1, date2);
		List<ResultResponseDTO> dto = resultDTOConversion.convertToResponse(list);
		return new ResponseEntity<List<ResultResponseDTO>>(dto, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{testId}")
	public void deleteResult(@PathVariable int testId) {
		resultService.deleteResult(testId);
	}

}
