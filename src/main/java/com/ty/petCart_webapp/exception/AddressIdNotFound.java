package com.ty.petCart_webapp.exception;

public class AddressIdNotFound extends RuntimeException{

	private String message="Address Id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public AddressIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	
}
