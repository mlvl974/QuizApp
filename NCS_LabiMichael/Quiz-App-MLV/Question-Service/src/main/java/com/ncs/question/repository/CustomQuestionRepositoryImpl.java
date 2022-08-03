package com.ncs.question.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncs.question.model.Question;

public class CustomQuestionRepositoryImpl implements CustomQuestionRepository {

	@Autowired
	EntityManager springDataJPA;
	// Session in hibernate 

	@Override
	public List<Question> getAllQuestionByCategoryAndMarks(String category, int marks) {
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


	@Override
	public List<Question> getAllQuestionsByCategory(String category) {
		String query = "from Question q where q.category = :category";
		Query q = springDataJPA.createQuery(query,Question.class);
		q.setParameter("category", category);
		List<Question> list =q.getResultList();
		System.err.println("INFO : Custom Question Repository IMPL" + list.size());
		
		for (Question question : list)
		{
			System.out.println(question);
		}
		return list;
	}


	@Override
	public List<Question> getAllQuestionByMarks(int marks) {
		String query = "from Question q where q.marks = :marks";
		Query q = springDataJPA.createQuery(query,Question.class);
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
