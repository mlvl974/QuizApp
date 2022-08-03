package com.ncs.result.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.result.dto.ResultResponseDTO;
import com.ncs.result.model.Result;
import com.ncs.result.model.User;
import com.ncs.result.repository.ResultRepository;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	ResultRepository resultRepository;

	@Override
	public Result submitQuiz(Result result) {

		return resultRepository.save(result);
	}

	@Override
	public List<Result> getResultByUserId(int userId) {
		return resultRepository.getResultByUserId(userId);
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
	public Result updateResult(int testId, ResultResponseDTO result) {
		Result r = resultRepository.findById(testId).get();
		r.setLevel(result.getLevel());
		r.setCategory(result.getCategory());
		r.setTotalScore(result.getTotalScore());

		int totalScore = result.getTotalScore();
		// 20 - 100% , 15 - 75%, 10 - 50%
		int marks = (totalScore * 100) / 20;
		r.setMarks(marks);

		Result updateResult = resultRepository.save(r);

		return updateResult;
	}

	@Override
	public List<Result> getAllResultsByDateRange(String date1, String date2) {

		return resultRepository.getAllResultByDateRange(date1, date2);
	}

	@Override
	public List<Result> getAllResultsByCategory(String category) {
		return resultRepository.getAllResultByCategory(category);
	}

	@Override
	public List<Result> getAllResultsByMarks(int marks) {
		return resultRepository.getAllResultByMarks(marks);
	}

}
