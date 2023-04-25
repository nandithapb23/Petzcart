package com.ty.petCart_webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.petCart_webapp.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
//	@Query("select u from User u where u.email=?1")
	public User findByEmail(String email);
}
