package com.ty.petCart_webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.petCart_webapp.entity.Doctors;

public interface DoctorRepo extends JpaRepository<Doctors, Integer>{
//	@Query("select d from Doctors d where d.email=?1")
	public Doctors findDoctorByEmail(String email);
}
