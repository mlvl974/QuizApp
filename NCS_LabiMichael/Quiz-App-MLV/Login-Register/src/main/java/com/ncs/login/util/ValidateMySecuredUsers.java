package com.ncs.login.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ncs.login.model.User;
import com.ncs.login.repository.AppUsersRepository;

@Component
public class ValidateMySecuredUsers {

	@Autowired
private	AppUsersRepository appUsersRepository;

	
	public boolean validateUserRole(User appUsers) {
		String role = appUsers.getRole();
		if (role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("public") || role.equalsIgnoreCase("student")) {
			return false;
		} else
			return true;
	}

	public boolean validateDuplicateUser(User appUsers) 
	{
		List<User> userList = appUsersRepository.findAll();
		System.out.println("list" + userList);
		String username = appUsers.getUsername();
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
