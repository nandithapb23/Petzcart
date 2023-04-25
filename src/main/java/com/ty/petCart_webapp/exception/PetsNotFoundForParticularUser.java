package com.ty.petCart_webapp.exception;

public class PetsNotFoundForParticularUser extends Exception {

	private String message="pets not found for particular user";

	@Override
	public String getMessage() {
		return message;
	}

	public PetsNotFoundForParticularUser(String message) {
		super();
		this.message = message;
	}
	
	
}
