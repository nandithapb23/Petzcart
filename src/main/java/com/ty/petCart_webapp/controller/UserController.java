package com.ty.petCart_webapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.petCart_webapp.config.ResponseStructure;
import com.ty.petCart_webapp.dto.UserDto;
import com.ty.petCart_webapp.entity.User;
import com.ty.petCart_webapp.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

public class UserController {
	@Autowired
	private UserService service;
	
	@ApiOperation(value = "login User", notes = "API is used to login user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully loggedin"),
			@ApiResponse(code = 404, message = "Invalid login credentials") })
	@GetMapping("/userlogin")
	public ResponseEntity<ResponseStructure<UserDto>> loginUser(@Valid@RequestParam String email,@RequestParam String password) {
		return service.loginUser(email,password);
	}
	@ApiOperation(value = "Save User", notes = "API is used to save user for given user Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 404, message = "fields cannot be null") })
	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(@Valid @RequestBody User user) {
		return service.saveUser(user);
	}
	@ApiOperation(value = "update User", notes = "API is used to update user for given user Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "Id not found for the given user ID") })
	@PutMapping("/user")
	public ResponseEntity<ResponseStructure<UserDto>> updateUser(@RequestBody User user, @RequestParam int id) {
		return service.updateUser(user, id);
	}
	@ApiOperation(value = "delete User", notes = "API is used to delete user for given user Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 404, message = "Id not found for the given user ID") })
	@DeleteMapping("/user")
	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(@RequestParam int id) {
		return service.deleteUser(id);
	}
	@ApiOperation(value = "Get User By Id", notes = "API is used to Fetch user for given user Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 404, message = "Id not found for the given user ID") })
	@GetMapping("/user")
	public ResponseEntity<ResponseStructure<UserDto>> getUserById(@RequestParam int id) {
		return service.getUserById(id);
	}
	@ApiOperation(value = "Get User By Email", notes = "API is used to Fetch user for given user email")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 404, message = "email not found for the given user email") })
	@GetMapping("/useremail")
	public ResponseEntity<ResponseStructure<UserDto>> getUserByEmail(@RequestParam String email){
		return service.getUserByEmail(email);
	}
}
