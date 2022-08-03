package com.ncs.result.repository;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncs.result.model.Result;
import com.ncs.result.model.User;

public class CustomResultRepositoryImpl implements CustomResultRepository {

	@Autowired
	EntityManager springDataJPA;
	// Session in hibernate

	@Override
	public List<Result> getAllResultByDateRange(String date1, String date2) {
		String query = "from Result where date between :d1 and :d2";
		Query q = springDataJPA.createQuery(query, Result.class);
		q.setParameter("d1", date1);
		q.setParameter("d2", date2);
		List<Result> list = q.getResultList();
		System.err.println("INFO : Custom Repository IMPL" + list.size());
		for (Result result : list) {
			System.out.println(result);
		}
		return list;
	}

	@Override
	public List<Result> getAllResultByCategory(String category) {
		String query = "from Result r where r.category = :category";
		Query q = springDataJPA.createQuery(query, Result.class);
		q.setParameter("category", category);
		List<Result> list = q.getResultList();
		System.err.println("INFO : Custom Repository IMPL" + list.size());
		for (Result result : list) {
			System.out.println(result);
		}
		return list;

	}

	@Override
	public List<Result> getAllResultByMarks(int marks) {
		String query = "from Result r where r.marks = :marks";
		Query q = springDataJPA.createQuery(query, Result.class);
		q.setParameter("marks", marks);
		List<Result> list = q.getResultList();
		System.err.println("INFO : Custom Repository IMPL" + list.size());
		for (Result result : list) {
			System.out.println(result);
		}
		return list;

	}

	@Override
	public List<Result> getResultByUserId(int userId) {
		String query = "from Result where user_id = :userId";
		Query q = springDataJPA.createQuery(query, Result.class);
		q.setParameter("userId", userId);
		List<Result> list = q.getResultList();
		System.err.println("INFO : Custom Repository IMPL" + list.size());
		for (Result result : list) {
			System.out.println(result);
		}
		return list;

	}

}
