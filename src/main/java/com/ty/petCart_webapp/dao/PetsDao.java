package com.ty.petCart_webapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.petCart_webapp.entity.Pets;
import com.ty.petCart_webapp.repo.PetRepo;

@Repository
public class PetsDao {
	@Autowired
	private PetRepo petRepo;

	public Pets savePets(Pets pets) {
		return petRepo.save(pets);
	}

	public Pets updatePets(Pets pets) {
		return petRepo.save(pets);
	}

	public Pets deletePets(int p_id) {
		Pets pets = getPetsById(p_id);
		if (pets != null) {
			petRepo.delete(pets);
			return pets;
		}
		return null;

	}

	public Pets getPetsById(int p_id) {
		Optional<Pets> pets2 = petRepo.findById(p_id);
		if (pets2.isPresent()) {
			return pets2.get();
		}
		return null;
	}
	public List<Pets> getPetsByCategory(String p_category){
		List<Pets> pets= petRepo.getPetsByCategory(p_category);
		if(pets!=null) {
			return pets;
		}
		return null;
	}
	public List<Pets> getAllPets(){
		return petRepo.findAll();
	}
}
