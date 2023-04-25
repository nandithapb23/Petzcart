package com.ty.petCart_webapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.petCart_webapp.entity.Doctors;
import com.ty.petCart_webapp.repo.DoctorRepo;

@Repository
public class DoctorDao {
	@Autowired
	private DoctorRepo doctorRepo;
	
	public Doctors saveDoctors(Doctors doctors) {
		return doctorRepo.save(doctors);
	}
	public Doctors updateDoctors(Doctors doctors,int d_id) {
		Optional<Doctors> doctors2=doctorRepo.findById(d_id);
		if(doctors2.isPresent()) {
			doctors.setD_id(d_id);
			doctors.setList(doctors.getList());
			doctorRepo.save(doctors);
			return doctors2.get();
		}
		return doctors;
	}
	public Doctors deleteDoctors(int d_id) {
		Doctors doctors=doctorRepo.findById(d_id).get();
		if(doctors!=null) {
			doctorRepo.delete(doctors);
			return doctors;
		}
		return null;
	}
	public Doctors getDoctorsById(int d_id) {
		return doctorRepo.findById(d_id).get();
	}
	public Doctors getDoctorByEmail(String email) {
		return doctorRepo.findDoctorByEmail(email);
	}
}
