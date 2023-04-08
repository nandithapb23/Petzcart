package com.ty.petCart_webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.petCart_webapp.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
