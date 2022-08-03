package com.ncs.student.service;

import java.util.ArrayList;




import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ncs.student.model.User;

import com.ncs.student.repository.UserRepository;

@Service
public class StudentServiceImpl  implements StudentService {

	@Autowired 
	UserRepository userRepository;
	

	@Override
	public User getUserById(int userId) {
		User user = userRepository.findById(userId).get();
		return user;
	}
	

	
	
	
	
	



	
	

	
	
	

}
