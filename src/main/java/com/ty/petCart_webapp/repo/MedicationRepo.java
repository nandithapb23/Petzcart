package com.ty.petCart_webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.petCart_webapp.entity.Medications;

public interface MedicationRepo extends JpaRepository<Medications, Integer>{
	@Query("select m from Medications m where m.drug_name=?1")
	public Medications getMedicationsByDrugname(String drug_name);
}
