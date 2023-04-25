package com.ty.petCart_webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.petCart_webapp.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
