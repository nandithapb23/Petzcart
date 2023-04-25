package com.ty.petCart_webapp.dto;

import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.ty.petCart_webapp.entity.Address;
import com.ty.petCart_webapp.entity.Customer;
import com.ty.petCart_webapp.entity.Medications;
import com.ty.petCart_webapp.entity.User;

@Component
public class PetsDto {
	
	private int p_id;
	private String p_category;
	private String p_breed;
	private String p_lifespan;
	private double p_cost;
	private String p_address;
	private String status;
	private User user;
	private Customer customer;
	private List<Medications> medications;
	
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
