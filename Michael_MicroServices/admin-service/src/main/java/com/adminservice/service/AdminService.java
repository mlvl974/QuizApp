package com.adminservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adminservice.model.User;


public interface AdminService {
	
public User addUser(User user);
public User getUserDetails(int userId);
public List<User> getAllUser();
public boolean deleteUser(int userId);


}
