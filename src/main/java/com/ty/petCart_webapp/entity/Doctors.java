package com.ty.petCart_webapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int d_id;
	private String d_name;
	private String h_name;
	private String h_address;
	private String email;
	private long d_phone;

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public String getH_name() {
		return h_name;
	}

	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	public String getH_address() {
		return h_address;
	}

	public void setH_address(String h_address) {
		this.h_address = h_address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getD_phone() {
		return d_phone;
	}

	public void setD_phone(long d_phone) {
		this.d_phone = d_phone;
	}

	

}
