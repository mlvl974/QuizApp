package com.ncs.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.admin.model.User;





public interface AdminRepository extends JpaRepository<User, Integer>, CustomAdminRepository {

	
	
}
