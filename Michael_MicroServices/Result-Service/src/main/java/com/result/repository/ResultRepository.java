package com.result.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.result.model.Result;



public interface ResultRepository extends JpaRepository<Result,Integer>,CustomResultRepository {





}
