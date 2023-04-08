package com.ty.petCart_webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.petCart_webapp.dao.UserDao;
import com.ty.petCart_webapp.dto.UserDto;
import com.ty.petCart_webapp.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	@Autowired
	private UserDto dto;
	
	public UserDto saveUser(User user) {
		 dao.saveUser(user);
		 dto.setId(user.getId());
		 dto.setFirstName(user.getFirstName());
		 dto.setLastName(user.getLastName());
		 dto.setEmail(user.getEmail());
		 dto.setPhone(user.getPhone());
		return dto;
	}
	public User updateUser(User user,int id) {
		return dao.updateUSer(user, id);	
		}
	public User deleteUser(int id) {
		return dao.deleteUser(id);
	}
	public User getUserById(int id) {
		return dao.getUserById(id);
	}
	}
