package com.ncs.admin.repository;

import com.ncs.admin.model.User;

public interface CustomAdminRepository {
	public User getUserByUsername(String username);
	public boolean updateUser(int userId, String username);
}
