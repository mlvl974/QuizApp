package com.ncs.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.student.model.Question;

public interface QuestionRepository extends  JpaRepository<Question, Integer>{

}