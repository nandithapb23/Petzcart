package com.ty.petCart_webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.petCart_webapp.config.ResponseStructure;
import com.ty.petCart_webapp.dao.AddressDao;
import com.ty.petCart_webapp.dao.UserDao;
import com.ty.petCart_webapp.dto.UserDto;
import com.ty.petCart_webapp.entity.Address;
import com.ty.petCart_webapp.entity.Pets;
import com.ty.petCart_webapp.entity.User;
import com.ty.petCart_webapp.exception.UserEmailNotFoundException;
import com.ty.petCart_webapp.exception.UserIdNotFound;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	@Autowired
	private UserDto dto;
	@Autowired
	private AddressDao addressDao;

	public UserDto getUserDto(User user) {
		dto.setId(user.getId());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setEmail(user.getEmail());
		dto.setPhone(user.getPhone());
		dto.setAddress(user.getAddress());
		return dto;
	}

	public ResponseEntity<ResponseStructure<UserDto>> saveUser(User user) {
		
		ResponseStructure<UserDto> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("user succesfully saved");
		responseStructure.setData(getUserDto(dao.saveUser(user)));
		return new ResponseEntity<ResponseStructure<UserDto>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<UserDto>> updateUser(User user, int id) {
		User user2 = dao.updateUSer(user, id);
		ResponseStructure<UserDto> responseStructure = new ResponseStructure<>();
		if (user2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("user succesfully updated");
			responseStructure.setData(getUserDto(user2));
			return new ResponseEntity<ResponseStructure<UserDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new UserIdNotFound("user id not found " + id);
		}
	}

	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(int id) {
		User user = dao.deleteUser(id);
		ResponseStructure<UserDto> responseStructure = new ResponseStructure<>();
		if (user != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("user succesfully deleted");
			responseStructure.setData(getUserDto(user));
			return new ResponseEntity<ResponseStructure<UserDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new UserIdNotFound("user id not found " + id);
		}
	}

	public ResponseEntity<ResponseStructure<UserDto>> getUserById(int id) {
		User user = dao.getUserById(id);
		ResponseStructure<UserDto> responseStructure = new ResponseStructure<>();
		if (user != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("found the given id");
			responseStructure.setData(getUserDto(user));
			return new ResponseEntity<ResponseStructure<UserDto>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new UserIdNotFound("user id not found " + id);
		}
	}

	public ResponseEntity<ResponseStructure<UserDto>> getUserByEmail(String email) {
		User user = dao.getUserByEmail(email);
		ResponseStructure<UserDto> responseStructure = new ResponseStructure<>();
		if (user != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("found the given email");
			responseStructure.setData(getUserDto(user));
			return new ResponseEntity<ResponseStructure<UserDto>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new UserEmailNotFoundException("user email not found " + email);
		}

	}

	public ResponseEntity<ResponseStructure<UserDto>> loginUser(String email, String password) {
		ResponseStructure<UserDto> responseStructure = new ResponseStructure<>();
		User user = dao.getUserByEmail(email);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("logged in succesfully");
				responseStructure.setData(getUserDto(user));
				return new ResponseEntity<ResponseStructure<UserDto>>(responseStructure, HttpStatus.OK);
			} else {
				responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
				responseStructure.setMessage("invalid details");
				responseStructure.setData(null);
				return new ResponseEntity<ResponseStructure<UserDto>>(responseStructure, HttpStatus.BAD_REQUEST);
			}
		}
		throw new UserEmailNotFoundException("User with the given mail not found");
	}

}
