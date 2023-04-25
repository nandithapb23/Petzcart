package com.ty.petCart_webapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.petCart_webapp.entity.Address;
import com.ty.petCart_webapp.entity.Medications;
import com.ty.petCart_webapp.repo.AddressRepo;

@Repository
public class AddressDao {
	@Autowired
	private AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	public Address updateAddress(Address address,int a_id) {
		Optional<Address> address2=addressRepo.findById(a_id);
		if(address2.isPresent()) {
			address.setA_id(a_id);
			addressRepo.save(address);
			return address2.get();
		}
		return address;
	}
	public Address deleteAddress(int a_id) {
		Address address=addressRepo.findById(a_id).get();
		if(address!=null) {
			addressRepo.delete(address);
			return address;
		}
		return null;
	}
	public Address getAddressById(int a_id) {
		return addressRepo.findById(a_id).get();
	}
}
