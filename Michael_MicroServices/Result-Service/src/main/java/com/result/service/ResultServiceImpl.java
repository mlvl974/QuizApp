package com.result.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import com.result.model.Result;
import com.result.repository.ResultRepository;


public class ResultServiceImpl implements ResultService {

	@Autowired
	ResultRepository resultRepository;
	
	
	
	

	@Override
	public Result getResultDetails(int testId) {
		return resultRepository.findById(testId).get();
	}

	@Override
	public List<Result> getAllResults() {
		return resultRepository.findAll();
	}

	@Override
	public List<Result> getAllResult(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Result> getAllResult(String dateRange1, String dateRange2) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
