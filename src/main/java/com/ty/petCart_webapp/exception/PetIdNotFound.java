package com.ty.petCart_webapp.exception;

public class PetIdNotFound extends RuntimeException{

	private String message="Pets Id not found";
	@Override
	public String getMessage() {
		return message;
	}
	public PetIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	
}
