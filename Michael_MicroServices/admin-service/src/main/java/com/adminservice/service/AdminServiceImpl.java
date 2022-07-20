package com.adminservice.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminservice.model.User;
import com.adminservice.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public User addUser(User user) {
		return adminRepository.save(user);
	
	}

	@Override
	public User getUserDetails(int userId) {
		
		 return adminRepository.findById(userId).get();
	}

	@Override
	public List<User> getAllUser() {
		return adminRepository.findAll();
	}
	
	public boolean deleteUser(int userId)
	{
		adminRepository.deleteById(userId);
		return true;
	}

}
