package com.ty.petCart_webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.petCart_webapp.dto.UserDto;
import com.ty.petCart_webapp.entity.User;
import com.ty.petCart_webapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping
	public UserDto saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	@PutMapping
	public User updateUser(@RequestBody User user,@RequestParam int id) {
		return service.updateUser(user, id);
	}
	@DeleteMapping
	public User deleteUser(@RequestParam int id) {
		return service.deleteUser(id);
	}
	@GetMapping
	public User getUserById(@RequestParam int id) {
		return service.getUserById(id);
	}
	
}
