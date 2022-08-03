package com.ncs.result.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import com.ncs.result.model.Result;


public interface ResultRepository extends JpaRepository<Result,Integer>,CustomResultRepository {





}
