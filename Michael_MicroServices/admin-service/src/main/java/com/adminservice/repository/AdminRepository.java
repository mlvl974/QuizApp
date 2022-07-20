package com.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.adminservice.model.User;

public interface AdminRepository extends JpaRepository<User, Integer>, CustomAdminRepository {

}
