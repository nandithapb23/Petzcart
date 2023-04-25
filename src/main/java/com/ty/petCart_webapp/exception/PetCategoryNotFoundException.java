package com.ty.petCart_webapp.exception;

public class PetCategoryNotFoundException extends RuntimeException {

	private String message = "pet category not found";

	@Override
	public String getMessage() {
		return message;

	}

	public PetCategoryNotFoundException(String message) {
		super();
		this.message = message;
	}

}
