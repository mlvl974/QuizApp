package com.ncs.login.service;

import org.springframework.stereotype.Service;

import com.ncs.login.exception.DuplicateUserException;
import com.ncs.login.exception.InvalidUserRoleException;
import com.ncs.login.model.User;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public interface AppUserService extends UserDetailsService{
	
	
	// public User saveUsers(User appUsers); 
	
	public User saveUsers(User appUsers) throws DuplicateUserException;
	// throws DuplicateUserException
	
	// throws InvalidUserRoleException;
	
	public List<User> getAllUsers();
}
