package com.ty.petCart_webapp.exception;

public class CustomerEmailIdNotFound extends RuntimeException{

	private String message="customer email not found";

	@Override
	public String getMessage() {
		return message;
	}

	public CustomerEmailIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	
	
}
