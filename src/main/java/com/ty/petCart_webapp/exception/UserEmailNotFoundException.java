package com.ty.petCart_webapp.exception;

public class UserEmailNotFoundException extends RuntimeException{

	private String message="user email not found";

	@Override
	public String getMessage() {
		return message;
	}

	public UserEmailNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
