package com.ty.petCart_webapp.exception;

public class MedicationsIdNotFound extends RuntimeException{

	private String message="medications Id Not Found";

	@Override
	public String getMessage() {
		return message;
		
	}

	public MedicationsIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	 
}
