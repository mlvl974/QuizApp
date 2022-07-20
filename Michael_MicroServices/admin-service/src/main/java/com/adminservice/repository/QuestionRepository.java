package com.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import com.adminservice.model.Question;



public interface QuestionRepository extends JpaRepository<Question, Integer>,CustomQuestionRepository {

	
	
}
