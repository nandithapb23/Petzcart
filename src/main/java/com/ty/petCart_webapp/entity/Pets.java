package com.ty.petCart_webapp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Pets {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int p_id;
	@NotNull(message = "pet category should not be null")
	@NotBlank(message = "pet category should not be blank")
	private String p_category;
	@NotNull(message = "pet breed should not be null")
	@NotBlank(message = "pet breed should not be blank")
	private String p_breed;
	@NotNull(message = "pet lifespan should not be null")
	@NotBlank(message = "pet lifespan should not be blank")
	private String p_lifespan;
	@Min(value = 0)
	private double p_cost;
	@NotNull(message = "pet address should not be null")
	@NotBlank(message = "pet address should not be blank")
	private String p_address;
	@NotNull(message = "pet status should not be null")
	@NotBlank(message = "pet status should not be blank")
	private String status;
	@ManyToOne
	private User user;
	@ManyToOne
	private Customer customer;
	@ManyToMany
	private List<Medications>  medications;

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_category() {
		return p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
	}

	public String getP_breed() {
		return p_breed;
	}

	public void setP_breed(String p_breed) {
		this.p_breed = p_breed;
	}

	public String getP_lifespan() {
		return p_lifespan;
	}

	public void setP_lifespan(String p_lifespan) {
		this.p_lifespan = p_lifespan;
	}

	public double getP_cost() {
		return p_cost;
	}

	public void setP_cost(double p_cost) {
		this.p_cost = p_cost;
	}

	public String getP_address() {
		return p_address;
	}

	public void setP_address(String p_address) {
		this.p_address = p_address;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Medications> getMedications() {
		return medications;
	}

	public void setMedications(List<Medications> medications) {
		this.medications = medications;
	}

	
	
	
}
