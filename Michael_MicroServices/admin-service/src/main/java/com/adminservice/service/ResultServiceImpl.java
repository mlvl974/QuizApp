package com.adminservice.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminservice.model.Result;
import com.adminservice.model.User;
import com.adminservice.repository.ResultRepository;
@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	ResultRepository resultRepository;
	
	
	
	@Override
	public Result addResult(Result result) {
		return resultRepository.save(result);
	}

	@Override
	public Result getResultDetails(int testId) {
		return resultRepository.findById(testId).get();
	}

	@Override
	public List<Result> getAllResults() {
		return resultRepository.findAll();
	}

	@Override
	public boolean deleteResult(int testId) {
		resultRepository.deleteById(testId);
		return true;
	}

	@Override
	public Result updateResultMarks(int testId, int marks) {
		boolean status = resultRepository.updateResultMarks(testId,marks);
		if(status)
		{
			Result result = getResultDetails(testId);
			return result;
		}
		else return null;
	}

	

}
