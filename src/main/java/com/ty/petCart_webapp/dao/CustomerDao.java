package com.ty.petCart_webapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.petCart_webapp.entity.Customer;
import com.ty.petCart_webapp.repo.CustomerRepo;

@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepo repo;
	
	public Customer saveCustomer(Customer customer) {
		return  repo.save(customer);
	}

	public Customer updateCustomer(Customer customer, int customerid) {
		Optional<Customer> customer2=repo.findById(customerid);
		if (customer2.isPresent()) {
			customer.setCustomerid(customerid);
			repo.save(customer);
			return customer2.get();
		}
		return null;
	}

	public Customer deleteCustomer(int customerid) {
		Customer customer=repo.findById(customerid).get();
		if(customer!=null) {
			repo.delete(customer);
			return customer;
		}
		return null;
	}

	public Customer getCustomerById(int customerid) {
		Optional<Customer> customer=repo.findById(customerid);
		if(customer.isPresent()) {
			return repo.findById(customerid).get();
		}
		return null;
	}
	public Customer getCustomerByEmail(String email) {
		Customer customer=repo.findCustomerByEmail(email);
		if(customer!=null) {
			return customer;
		}
		return null;
	}
}


