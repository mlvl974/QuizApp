package com.ncs.midterm.service;

import org.springframework.stereotype.Service;


import com.ncs.midterm.exception.InvalidAgeException;
import com.ncs.midterm.exception.InvalidPincodeException;
import com.ncs.midterm.exception.InvalidUserRoleException;
import com.ncs.midterm.model.MySecuredUsers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public interface AppUserService extends UserDetailsService{
	public MySecuredUsers saveUsers(MySecuredUsers appUsers) throws InvalidAgeException,InvalidUserRoleException;
	public MySecuredUsers getUserByPincode(long pincode)throws InvalidPincodeException;
	public MySecuredUsers viewProfile(int id)throws IllegalArgumentException,NoSuchElementException;
	public MySecuredUsers updatePincode(int id, long pincode)throws InvalidPincodeException;
	public List<MySecuredUsers> getAllUsers();
}
