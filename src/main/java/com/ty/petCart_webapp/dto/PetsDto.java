package com.ty.petCart_webapp.dto;

import org.springframework.stereotype.Component;

@Component
public class PetsDto {
	
	private int p_id;
	private String p_category;
	private String p_breed;
	private String p_lifespan;
	private double p_cost;
	private String p_address;
	private int user_id;
	private long phone;
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	
}
