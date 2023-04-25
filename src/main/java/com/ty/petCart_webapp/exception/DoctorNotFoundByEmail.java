package com.ty.petCart_webapp.exception;

public class DoctorNotFoundByEmail extends Exception {

	private String message="doctor not found for particular email";

	@Override
	public String getMessage() {
		return message;
		
	}

	public DoctorNotFoundByEmail(String message) {
		super();
		this.message = message;
	}
	
	
	
}
