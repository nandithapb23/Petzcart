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
	public User updateUSer(User user,int id) {
		Optional<User> user2 = repo.findById(id);
		if (user2.isPresent()) {
			user.setId(id);
//			user.setPets(user.getPets());
			repo.save(user);
			return user2.get();
		}
		return null;
	}
	public User deleteUser(int id) {
		Optional<User> user = repo.findById(id);
		if (user.isPresent()) {
			repo.deleteById(id);
			return user.get();
		}
		return null;
	}
	public User getUserById(int id) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}
