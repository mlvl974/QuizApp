package com.ncs.midterm.util;

import org.springframework.stereotype.Component;

import com.ncs.midterm.model.MySecuredUsers;

@Component
public class ValidateMySecuredUsers {

	public boolean validateUserPincode(MySecuredUsers appUsers)
	{
		long pincode = appUsers.getPincode();
		
		if(pincode<99999999)
		{
			return false;
		}
		else return true;
	}
	
	
	public boolean validateUserRole(MySecuredUsers appUsers)
	{
		String role = appUsers.getRole();
		if(role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("public") 
			|| role.equalsIgnoreCase("user"))
		{
			return false;
		}
		else return true;
	}
	
	public boolean validateUserAge(MySecuredUsers appUsers)
	{
		int age = appUsers.getAge();
		if(age < 18)
		{
			return false;
		}
		else return true;
	}
	
}
