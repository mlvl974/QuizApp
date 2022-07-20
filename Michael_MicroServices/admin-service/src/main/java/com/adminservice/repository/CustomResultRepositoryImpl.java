package com.adminservice.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomResultRepositoryImpl implements CustomResultRepository {

	@Autowired
	EntityManager springDataJPA;
	// Session in hibernate

	@Override
	public boolean updateResultMarks(int testId, int marks) {
		String query = "Update Result set marks = :marks where testId = :testId";
		Query q = springDataJPA.createQuery(query);
		q.setParameter("testId", testId);
		q.setParameter("marks", marks);
		int x = q.executeUpdate();
		
		// ternary operator
		// checks if true or false
		return (x == 1) ? true : false;
	}

}
