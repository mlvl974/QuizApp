package com.questionservice.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.questionservice.model.Question;

public class CustomQuestionRepositoryImpl implements CustomQuestionRepository {

	@Autowired
	EntityManager springDataJPA;
	// Session in hibernate 

	@Override
	public List<Question> getAllQuestion(String category, int marks) {
		String query = "from Question q where q.category = :category and q.marks = :marks";
		Query q = springDataJPA.createQuery(query,Question.class);
		q.setParameter("category", category);
		q.setParameter("marks", marks);
		
		List<Question> list =q.getResultList();
		System.err.println("INFO : Custom Question Repository IMPL" + list.size());
	
		for (Question question : list)
		{
			System.out.println(question);
		}
		return list;
	
	}
	
	

	
	
	
}
