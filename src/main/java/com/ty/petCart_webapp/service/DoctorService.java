package com.ty.petCart_webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.petCart_webapp.config.ResponseStructure;
import com.ty.petCart_webapp.dao.DoctorDao;
import com.ty.petCart_webapp.dao.MedicationDao;
import com.ty.petCart_webapp.dto.DoctorDto;
import com.ty.petCart_webapp.entity.Doctors;
import com.ty.petCart_webapp.entity.Medications;
import com.ty.petCart_webapp.exception.DoctorIdNotFound;
import com.ty.petCart_webapp.exception.DoctorNotFoundByEmail;

@Service
public class DoctorService {
	@Autowired
	private DoctorDao dao;
	@Autowired
	private DoctorDto doctorDto;
	@Autowired
	private MedicationDao medicationDao;

	public DoctorDto getDoctorDto(Doctors doctors) {
		doctorDto.setD_id(doctors.getD_id());
		doctorDto.setD_name(doctors.getD_name());
		doctorDto.setD_phone(doctors.getD_phone());
		doctorDto.setEmail(doctors.getEmail());
		doctorDto.setH_address(doctors.getH_address());
		doctorDto.setH_name(doctors.getH_name());
		doctorDto.setList(doctors.getList());
		return doctorDto;
	}

	public ResponseEntity<ResponseStructure<DoctorDto>> saveDoctor(Doctors doctors) {
		Doctors doctors2 = dao.saveDoctors(doctors);
		ResponseStructure<DoctorDto> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("doctor saved succesfully");
		structure.setData(getDoctorDto(doctors2));
		return new ResponseEntity<ResponseStructure<DoctorDto>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<DoctorDto>> updateDoctor(Doctors doctors, int d_id) {
		Doctors doctors2 = dao.updateDoctors(doctors, d_id);
		ResponseStructure<DoctorDto> structure = new ResponseStructure<>();
		if (doctors2 != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("doctor updated sucesfully");
			structure.setData(getDoctorDto(doctors2));
			return new ResponseEntity<ResponseStructure<DoctorDto>>(structure, HttpStatus.OK);
		}
		throw new DoctorIdNotFound("doctor id not found " + d_id);
	}

	public ResponseEntity<ResponseStructure<DoctorDto>> deleteDoctor(int d_id) {
		Doctors doctors2 = dao.deleteDoctors(d_id);
		ResponseStructure<DoctorDto> structure = new ResponseStructure<>();
		if (doctors2 != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("doctor deleted sucesfully");
			structure.setData(getDoctorDto(doctors2));
			return new ResponseEntity<ResponseStructure<DoctorDto>>(structure, HttpStatus.OK);
		}
		throw new DoctorIdNotFound("doctor id not found" + d_id);
	}

	public ResponseEntity<ResponseStructure<DoctorDto>> getDoctorById(int d_id) {
		Doctors doctors = dao.getDoctorsById(d_id);
		ResponseStructure<DoctorDto> structure = new ResponseStructure<>();
		if (doctors != null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("doctor found sucesfully");
			structure.setData(getDoctorDto(doctors));
			return new ResponseEntity<ResponseStructure<DoctorDto>>(structure, HttpStatus.FOUND);
		}
		throw new DoctorIdNotFound("doctor id not found" + d_id);
	}

	public ResponseEntity<ResponseStructure<Doctors>> updatedoctorMedication(int d_id, List<Integer> integers) {
		Doctors doctors = dao.getDoctorsById(d_id);
		List<Medications> list = new ArrayList<>();
		for (Integer integer : integers) {
			int id = integer;
			Medications medications = medicationDao.getMedicationsById(id);
			list.add(medications);
		}
		doctors.setList(list);

		ResponseStructure<Doctors> structure = new ResponseStructure<>();
		structure.setMessage("DOc Med Updated");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dao.updateDoctors(doctors, d_id));

		return new ResponseEntity<ResponseStructure<Doctors>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<DoctorDto>> getDoctorByEmail(String email) throws DoctorNotFoundByEmail {
		Doctors doctors = dao.getDoctorByEmail(email);
		ResponseStructure<DoctorDto> structure = new ResponseStructure<>();
		if (doctors != null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("doctor found sucesfully");
			structure.setData(getDoctorDto(doctors));
			return new ResponseEntity<ResponseStructure<DoctorDto>>(structure, HttpStatus.FOUND);
		}
		throw new DoctorNotFoundByEmail("doctor not found");
	}
}
