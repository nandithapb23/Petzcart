package com.ty.petCart_webapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.petCart_webapp.entity.Pets;

public interface PetRepo extends JpaRepository<Pets, Integer>{
	@Query("select p from Pets p where p.p_category=?1")
	public List<Pets> getPetsByCategory(String p_category);
}
