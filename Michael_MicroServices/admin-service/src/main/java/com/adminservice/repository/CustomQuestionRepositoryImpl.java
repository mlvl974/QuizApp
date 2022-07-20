package com.adminservice.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomQuestionRepositoryImpl implements CustomQuestionRepository {
	
	@Autowired
	EntityManager springDataJPA;
	// Session in hibernate 

	@Override
	@Transactional 
	public boolean updateAnswer(int questionId,String answer) {
		String query = "Update Question set answer = :answer where questionId = :questionId";
		Query q = springDataJPA.createQuery(query);
		
		q.setParameter("questionId", questionId);
		q.setParameter("answer", answer);
		int x = q.executeUpdate();
		
		// ternary operator
		//checks if true or false 
		return (x==1)?true:false;
	}
	
}
