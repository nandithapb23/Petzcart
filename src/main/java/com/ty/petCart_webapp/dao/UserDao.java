package com.ty.petCart_webapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.petCart_webapp.entity.User;
import com.ty.petCart_webapp.repo.UserRepo;

@Repository
public class UserDao {
	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User updateUSer(User user, int id) {
		Optional<User> user2 = repo.findById(id);
		if (user2.isPresent()) {
			user.setId(id);
			user.setAddress(user2.get().getAddress());
			repo.save(user);
			return user2.get();
		}
		return null;
	}

	public User deleteUser(int id) {
		User user=repo.findById(id).get();
		if(user!=null) {
			repo.delete(user);
			return user;
		}
		return null;
	}

	public User getUserById(int id) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
			return repo.findById(id).get();
		}
		return null;
	}
	public User getUserByEmail(String email) {
		User user=repo.findByEmail(email);
		if(user!=null) {
			return user;
		}
		return null;
	}
}
