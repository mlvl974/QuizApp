package com.ncs.admin.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncs.admin.model.User;

public class CustomAdminRepositoryImpl implements CustomAdminRepository {

	@Autowired
	EntityManager springDataJPA;
	// Session in hibernate

	@Override
	public User getUserByUsername(String username) {
		String query = "from User u where u.username = :username;";
		Query q = springDataJPA.createQuery(query, User.class);
		q.setParameter("username", username);
		User queryOutput = (User) q.getSingleResult();
		return queryOutput;
	}

	@Override
	@Transactional
	public boolean updateUser(int userId, String username) {
		String query = "Update User set username = :username where userId = :userId";
		Query q = springDataJPA.createQuery(query);
		q.setParameter("userId", userId);
		q.setParameter("username", username);
		int x = q.executeUpdate();

		// ternary operator
		// checks if true or false
		return (x == 1) ? true : false;
	}

}
