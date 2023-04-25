package com.ty.petCart_webapp.exception;

public class DoctorIdNotFound extends RuntimeException{

	private String message="Doctor Id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public DoctorIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	
}
