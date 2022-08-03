package com.ncs.result.service;

import java.util.List;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.ncs.result.dto.ResultResponseDTO;
import com.ncs.result.model.Result;
import com.ncs.result.model.User;

public interface ResultService {

	public Result submitQuiz(Result result);

	public List<Result> getAllResults();

	public Result updateResult(int testId, ResultResponseDTO result);

	// Custom Repo
	public List<Result> getResultByUserId(int userId);

	public List<Result> getAllResultsByMarks(int marks);

	public List<Result> getAllResultsByDateRange(String date1, String date2);

	public List<Result> getAllResultsByCategory(String category);

	public boolean deleteResult(int testId);

}
