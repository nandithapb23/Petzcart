package com.ty.petCart_webapp.exception;

public class CustomerIdNotFound extends RuntimeException{

	private String message="customer id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public CustomerIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	
}
