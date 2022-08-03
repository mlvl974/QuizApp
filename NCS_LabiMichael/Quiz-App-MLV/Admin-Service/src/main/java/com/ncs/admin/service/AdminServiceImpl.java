package com.ncs.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.admin.exception.DuplicateUserException;
import com.ncs.admin.exception.UserNotFoundException;
import com.ncs.admin.model.User;
import com.ncs.admin.repository.AdminRepository;
import com.ncs.admin.util.ValidateUser;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	ValidateUser validateUser;

	@Override
	public User addUser(User user) throws DuplicateUserException {

		if (user != null) {
			boolean duplicateCheck = validateUser.validateDuplicateUser(user);
			if (duplicateCheck == true) {
				User savedUser = adminRepository.save(user);
				return savedUser;
			} else {
				throw new DuplicateUserException("Duplicate user found", user.getUsername() + "is not available.");
			}
		} else {
			throw new NullPointerException("User Details is null");
		}

	}

	@Override
	public User getUserDetails(int userId) {

		return adminRepository.findById(userId).get();
	}

	@Override
	public List<User> getAllUser() {
		return adminRepository.findAll();
	}

	public boolean deleteUser(int userId) {
		adminRepository.deleteById(userId);
		return true;
	}

	@Override
	public User getUserByUsername(String username) {
		return adminRepository.getUserByUsername(username);
	}

	@Override
	public User updateUser(User user) throws UserNotFoundException {
		return adminRepository.save(user);
	}

}
