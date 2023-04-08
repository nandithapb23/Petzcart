package com.ty.petCart_webapp.dto;

import org.springframework.stereotype.Component;

@Component
public class MedicationsDto {

	private int m_id;
	private String drug_name;
	private String med_duration;
	private String symptoms;
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getDrug_name() {
		return drug_name;
	}
	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}
	public String getMed_duration() {
		return med_duration;
	}
	public void setMed_duration(String med_duration) {
		this.med_duration = med_duration;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	
	
}
