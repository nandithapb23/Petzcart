package com.ty.petCart_webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.petCart_webapp.entity.Pets;

public interface PetRepo extends JpaRepository<Pets, Integer>{

}
