package com.ty.petCart_webapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Doctors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int d_id;
	@NotNull(message = "doctor name should not be null")
	@NotBlank(message = "doctor name should not be blank")
	private String d_name;
	@NotNull(message = "hospital name should not be null")
	@NotBlank(message = "hospital name should not be blank")
	private String h_name;
	@NotNull(message = "hospital address should not be null")
	@NotBlank(message = "hospital address should not be blank")
	private String h_address;
	@NotNull(message = "email should not be null")
	@NotBlank(message = "email should not be blank")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid Email")
	private String email;
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long d_phone;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Medications> list;
	
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

	public List<Medications> getList() {
		return list;
	}

	public void setList(List<Medications> list) {
		this.list = list;
	}

	

	

}
