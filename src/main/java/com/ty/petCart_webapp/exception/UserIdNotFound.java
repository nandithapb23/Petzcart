package com.ty.petCart_webapp.exception;

public class UserIdNotFound extends RuntimeException{

	private String message="user id not found";
	@Override
	public String getMessage() {
		return message;
	}
	public UserIdNotFound(String message) {
		super();
		this.message = message;
	}
	

	
}
