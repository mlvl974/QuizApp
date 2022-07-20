package com.ncs.midterm.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ncs.midterm.exception.InvalidPincodeException;
import com.ncs.midterm.exception.InvalidUserRoleException;
import com.ncs.midterm.model.MySecuredUsers;
import com.ncs.midterm.model.MyUserDetails;
import com.ncs.midterm.repository.AppUsersRepository;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUsersRepository userRepo;

	@Override // from UserDetailsService
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		MySecuredUsers user = userRepo.getUsersByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("Username not found with username:" + username);

		System.out.println(" ");
		System.out.println("--------Inside App User Service IMP ---------- ");
		System.out.println(" Arg :- " + username);
		System.out.println(" From Database " + user);

		return new MyUserDetails(user);

		// User user1 = new User("raja","abc",Arrays.asList(new
		// SimpleGrantedAuthority("admin")));
		// return user1;
	}

	@Override
	public MySecuredUsers saveUsers(MySecuredUsers appUsers) throws InvalidUserRoleException {
		return userRepo.save(appUsers);
	}
	
	@Override
	public List<MySecuredUsers> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public MySecuredUsers getUserByPincode(long pincode) throws InvalidPincodeException {

		return userRepo.getUserByPincode(pincode);
	}

	@Override
	public MySecuredUsers viewProfile(int id) throws NullPointerException {

		MySecuredUsers user = userRepo.findById(id).get();
		return (user);
	}

	@Override
	public MySecuredUsers updatePincode(int id, long pincode) throws InvalidPincodeException {
		boolean status = userRepo.updatePincode(id, pincode);
		if (status) {
			MySecuredUsers user = viewProfile(id);
			return user;
		} else
			return null;
	}

	

}
