package com.ncs.admin.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ncs.admin.model.User;
import com.ncs.admin.repository.AdminRepository;

@Component
public class ValidateUser {

	@Autowired
	AdminRepository adminRepository;
	
	public boolean validateUserRole(User user) {
		String role = user.getRole();
		if (role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("student")) {
			return false;
		} else
			return true;
	}
	
	public boolean validateDuplicateUser(User user) 
	{
		List<User> userList = adminRepository.findAll();
		System.out.println("list" + userList);
		String username = user.getUsername();
		for (User u : userList) 
		{
			if (u.getUsername().equalsIgnoreCase(username))
			{
				return false;
			}
		} 
		return true;
	}
}
