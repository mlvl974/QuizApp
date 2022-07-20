package com.ncs.midterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.midterm.model.MySecuredUsers;

@Repository
public interface AppUsersRepository extends JpaRepository<MySecuredUsers, Integer> 
{
	@Query("from MySecuredUsers where username = :username")
	public MySecuredUsers getUsersByUsername(String username);
	
	@Query("from MySecuredUsers where pincode = :pincode")
	public MySecuredUsers getUserByPincode(long pincode);
	
	@Query("from MySecuredUsers where id = :id")
	public MySecuredUsers viewProfile(int id);
	
	@Query("Update MySecuredUsers set pincode = :pincode where id = :id")
	public boolean updatePincode(int id, long pincode);
}
