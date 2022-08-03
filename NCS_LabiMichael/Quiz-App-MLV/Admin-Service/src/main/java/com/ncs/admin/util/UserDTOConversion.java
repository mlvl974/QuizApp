package com.ncs.admin.util;

import org.springframework.stereotype.Component;

import com.ncs.admin.dto.UserResponseDTO;
import com.ncs.admin.model.User;

//Data Transfered Object -  without user password
//hide implementation details of entity 

@Component
public class UserDTOConversion {

	public static UserResponseDTO convertToResponse (User u)
	{
		UserResponseDTO dto = new UserResponseDTO();
		dto.setUserId(u.getUserId());
		dto.setUsername(u.getUsername());
		dto.setRole(u.getRole());
		dto.setEmail(u.getEmail());
		return dto;
		
	}
	
}
