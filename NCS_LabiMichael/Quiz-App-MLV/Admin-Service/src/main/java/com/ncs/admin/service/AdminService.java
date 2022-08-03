package com.ncs.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ncs.admin.exception.DuplicateUserException;
import com.ncs.admin.exception.UserNotFoundException;
import com.ncs.admin.model.User;

public interface AdminService {

	public User addUser(User user) throws DuplicateUserException;

	public User getUserDetails(int userId);

	public List<User> getAllUser();

	public User updateUser(User user) throws UserNotFoundException;

//Custom Repo
	public User getUserByUsername(String username);


	public boolean deleteUser(int userId);

}
