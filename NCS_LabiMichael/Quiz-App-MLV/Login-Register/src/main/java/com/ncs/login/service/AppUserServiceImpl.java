package com.ncs.login.service;

import java.util.List;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ncs.login.exception.DuplicateUserException;
import com.ncs.login.exception.InvalidUserRoleException;
import com.ncs.login.model.User;
import com.ncs.login.model.MyUserDetails;
import com.ncs.login.repository.AppUsersRepository;
import com.ncs.login.util.ValidateMySecuredUsers;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUsersRepository userRepo;

	@Autowired
	ValidateMySecuredUsers validateMySecuredUsers;

	@Override // from UserDetailsService
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.getUserByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("Username not found with username:" + username);

		System.out.println(" ");
		System.out.println("--------Inside App User Service IMP ---------- ");
		System.out.println(" Arg :- " + username);
		System.out.println(" From Database " + user);

		return new MyUserDetails(user);

	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

//	@Override
//	public User saveUsers(User appUsers) {
//		return userRepo.save(appUsers);
//	}

	@Override
	public User saveUsers(User appUsers) throws DuplicateUserException 
	{
		User user = new User ();
		if (user != null) 
		{
			boolean duplicateCheck = validateMySecuredUsers.validateDuplicateUser(appUsers);
			if (duplicateCheck == true) 
			{
				user = userRepo.save(appUsers);
			} 
			else 
			{
				throw new DuplicateUserException("Duplicate user found", appUsers.getUsername());
			}
		}
		return user;
	}

}
