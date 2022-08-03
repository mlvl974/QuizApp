package com.ncs.result.repository;

import java.util.List;

import com.ncs.result.model.Result;
import com.ncs.result.model.User;

public interface CustomResultRepository {
	
	public List<Result> getAllResultByDateRange(String date1, String date2);
	public List<Result>getAllResultByCategory(String category);
	public List<Result>getAllResultByMarks(int marks);
	public List<Result>getResultByUserId(int userId);
}
