package com.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adminservice.model.Result;

public interface ResultRepository extends JpaRepository<Result,Integer>,CustomResultRepository {





}
