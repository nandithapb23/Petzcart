package com.ty.petCart_webapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.petCart_webapp.entity.Medications;
import com.ty.petCart_webapp.repo.MedicationRepo;

@Repository
public class MedicationDao {
	@Autowired
	private MedicationRepo repo;

	public Medications saveMedications(Medications medications) {
		return repo.save(medications);
	}

	public Medications updateMedications(Medications medications, int m_id) {
		Optional<Medications> medications2 = repo.findById(m_id);
		if (medications2.isPresent()) {
			medications.setM_id(m_id);
			repo.save(medications);
			return medications2.get();
		}
		return medications;
	}

	public Medications deleteMedications(int m_id) {
		Medications medications = repo.findById(m_id).get();
		if (medications != null) {
			repo.delete(medications);
			return medications;
		}
		return null;
	}

	public Medications getMedicationsById(int m_id) {
		return repo.findById(m_id).get();	
	}
	public Medications getMedicationsByDrugname(String drug_name) {
		Medications medications=repo.getMedicationsByDrugname(drug_name);
		if(medications!=null)
		{
			return medications;
			}
		return null;
		}
}
