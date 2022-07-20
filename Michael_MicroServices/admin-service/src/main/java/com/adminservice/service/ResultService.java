package com.adminservice.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.adminservice.model.Result;
import com.adminservice.model.User;

public interface ResultService {
	
	public Result addResult(Result result);
	public Result getResultDetails(int testId);
	public List<Result>getAllResults();
	public boolean deleteResult(int testId);
	
	public Result updateResultMarks(int testId, int marks);
	
	
	
	
	
}
