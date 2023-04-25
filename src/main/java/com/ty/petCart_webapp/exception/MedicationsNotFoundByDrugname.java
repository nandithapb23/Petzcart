package com.ty.petCart_webapp.exception;

import com.ty.petCart_webapp.entity.Medications;

public class MedicationsNotFoundByDrugname extends RuntimeException {
	private String message="medications not found for particular drug name";

	@Override
	public String getMessage() {
		return message;
		
	}

	public MedicationsNotFoundByDrugname(String message) {
		super();
		this.message = message;
	}
	
	
	
}
