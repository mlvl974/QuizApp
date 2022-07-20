package com.result.service;

import java.util.List;

import com.result.model.Result;



public interface ResultService {
	
	
	public Result getResultDetails(int testId);
	public List<Result>getAllResult(int userId);
	public List<Result>getAllResults();
	public List<Result>getAllResult(String dateRange1, String dateRange2);
	
	
	
	
}
