package com.ty.petCart_webapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ty.petCart_webapp.entity.Pets;
import com.ty.petCart_webapp.repo.PetRepo;

public class PetsDao {
	@Autowired
	private PetRepo petRepo;
	
	public Pets savePets(Pets pets) {
		return petRepo.save(pets);
	}
	public Pets updatePets(Pets pets,int p_id) {
		Optional<Pets> pets2=petRepo.findById(p_id);
		if(pets2.isPresent()) {
			pets.setP_id(p_id);
			pets.setAddress(pets.getAddress());
			petRepo.save(pets);
			return pets2.get();
		}
		return pets;
	}
	
}
