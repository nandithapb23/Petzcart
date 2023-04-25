package com.ty.petCart_webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.petCart_webapp.config.ResponseStructure;
import com.ty.petCart_webapp.dao.MedicationDao;
import com.ty.petCart_webapp.dao.PetsDao;
import com.ty.petCart_webapp.dto.MedicationsDto;
import com.ty.petCart_webapp.entity.Medications;
import com.ty.petCart_webapp.entity.Pets;
import com.ty.petCart_webapp.exception.MedicationsIdNotFound;
import com.ty.petCart_webapp.exception.MedicationsNotFoundByDrugname;
import com.ty.petCart_webapp.exception.PetIdNotFound;

@Service
public class MedicationService {
	@Autowired
	private MedicationDao dao;
	@Autowired
	private MedicationsDto dto;
	@Autowired
	private PetsDao petsDao;

	public MedicationsDto getMedicationsDto(Medications medications) {
		dto.setM_id(medications.getM_id());
		dto.setDrug_name(medications.getDrug_name());
		dto.setMed_duration(medications.getMed_duration());
		dto.setSymptoms(medications.getDrug_name());
		return dto;
	}
	public ResponseEntity<ResponseStructure<MedicationsDto>> saveMedications(Medications medications,int petid) {
		Pets pets=petsDao.getPetsById(petid);
		if(pets!=null) {
			List<Medications>list=new ArrayList<>();
			list.add(medications);
			list.addAll(pets.getMedications());
			pets.setMedications(list);
			Medications medications2=dao.saveMedications(medications);
			petsDao.updatePets(pets);

			ResponseStructure<MedicationsDto> structure=new ResponseStructure<>();
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setMessage("medications succesfully saved");
			structure.setData(getMedicationsDto(medications2));
			return new ResponseEntity<ResponseStructure<MedicationsDto>>(structure, HttpStatus.CREATED);
		}else {
			throw new PetIdNotFound("pet id not found");
		}
	
	}

	public ResponseEntity<ResponseStructure<MedicationsDto>> updateMedications(Medications medications, int m_id) {
		Medications medications2=dao.updateMedications(medications, m_id);
		ResponseStructure<MedicationsDto> structure=new ResponseStructure<>();
		if(medications2!=null) {
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("medications succesfully updated");
		structure.setData(getMedicationsDto(medications2));
		return new ResponseEntity<ResponseStructure<MedicationsDto>>(structure, HttpStatus.OK);
	}
		throw new MedicationsIdNotFound("medications id not found"+m_id);
	}

	public ResponseEntity<ResponseStructure<MedicationsDto>> deleteMedications(int m_id) {
		Medications medications2=dao.deleteMedications(m_id);
		ResponseStructure<MedicationsDto> structure=new ResponseStructure<>();
		if(medications2!=null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("medications succesfully deleted");
			structure.setData(getMedicationsDto(medications2));
			return new ResponseEntity<ResponseStructure<MedicationsDto>>(structure,HttpStatus.OK);
		}
		throw new MedicationsIdNotFound("medications id not found "+m_id);
	}

	public ResponseEntity<ResponseStructure<MedicationsDto>> getMedicationsById(int m_id) {
		Medications medications = dao.getMedicationsById(m_id);
		ResponseStructure<MedicationsDto> structure=new ResponseStructure<>();
		if(medications!=null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("medications succesfully found");
			structure.setData(getMedicationsDto(medications));
			return new ResponseEntity<ResponseStructure<MedicationsDto>>(structure,HttpStatus.FOUND);
		}
		throw new MedicationsIdNotFound("medications id not found "+m_id);
	}
	public ResponseEntity<ResponseStructure<MedicationsDto>> getMedicationsByDrugname(String drug_name) {
		Medications medications=dao.getMedicationsByDrugname(drug_name);
		ResponseStructure<MedicationsDto> structure=new ResponseStructure<>();
		if(medications!=null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("medications succesfully found");
			structure.setData(getMedicationsDto(medications));
			return new ResponseEntity<ResponseStructure<MedicationsDto>>(structure,HttpStatus.FOUND);
		}
		throw new MedicationsNotFoundByDrugname("medications not found for particular drugname "+drug_name);
	}

	
	}