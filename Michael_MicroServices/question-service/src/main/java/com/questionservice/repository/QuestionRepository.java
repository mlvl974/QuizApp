package com.questionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.questionservice.model.Question;



public interface QuestionRepository extends JpaRepository<Question, Integer>,CustomQuestionRepository {

}
