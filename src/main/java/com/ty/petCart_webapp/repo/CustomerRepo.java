package com.ty.petCart_webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.petCart_webapp.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	public Customer findCustomerByEmail(String email);
}
