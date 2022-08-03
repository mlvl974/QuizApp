package com.ncs.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.login.model.User;


@Repository
public interface AppUsersRepository extends JpaRepository<User, Integer> 
{

	@Query("from User where username = :username")
	public User getUserByUsername(String username);
}
