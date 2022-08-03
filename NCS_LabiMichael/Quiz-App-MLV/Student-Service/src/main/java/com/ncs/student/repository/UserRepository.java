package com.ncs.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ncs.student.model.User;



public interface UserRepository extends JpaRepository<User, Integer>, CustomUserRepository {

}

