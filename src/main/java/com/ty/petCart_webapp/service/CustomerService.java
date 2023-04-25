package com.ty.petCart_webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.petCart_webapp.config.ResponseStructure;
import com.ty.petCart_webapp.dao.CustomerDao;
import com.ty.petCart_webapp.dto.CustomerDto;
import com.ty.petCart_webapp.entity.Customer;
import com.ty.petCart_webapp.exception.CustomerEmailIdNotFound;
import com.ty.petCart_webapp.exception.CustomerIdNotFound;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao dao;
	@Autowired
	private CustomerDto dto;
	
	public CustomerDto getCustomerDto(Customer customer) {
		dto.setCustomerid(customer.getCustomerid());
		dto.setName(customer.getName());
		dto.setEmail(customer.getEmail());
		dto.setPhone(customer.getPhone());
		dto.setAddress(customer.getAddress());
		dto.setPassword(customer.getPassword());
		return dto;
	}
	
public ResponseEntity<ResponseStructure<CustomerDto>> saveCustomer(Customer customer) {
		
		ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("customer succesfully saved");
		responseStructure.setData(getCustomerDto(dao.saveCustomer(customer)));
		return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.CREATED);
	}

public ResponseEntity<ResponseStructure<CustomerDto>> updateCustomer(Customer customer, int customerid) {
	
	Customer customer2=dao.updateCustomer(customer, customerid);
	ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
	if (customer2 != null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("customer succesfully updated");
		responseStructure.setData(getCustomerDto(customer2));
		return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.OK);
	} else {
		throw new CustomerIdNotFound("customer id not found " + customerid);
	}
}
	public ResponseEntity<ResponseStructure<CustomerDto>> deleteCustomer(int customerid) {
		Customer customer=dao.getCustomerById(customerid);
		ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
		if (customer != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("user succesfully deleted");
			responseStructure.setData(getCustomerDto(customer));
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFound("customer id not found " + customerid);
		}
	}
	public ResponseEntity<ResponseStructure<CustomerDto>> getCustomerById(int customerid) {
		Customer customer=dao.getCustomerById(customerid);
		ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
		if (customer != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("found the given id");
			responseStructure.setData(getCustomerDto(customer));
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new CustomerIdNotFound("customer id not found " + customerid);
		}
	}
	public ResponseEntity<ResponseStructure<CustomerDto>> getCustomerByEmail(String email) {
		Customer customer=dao.getCustomerByEmail(email);
		ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
		if (customer != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("found the given email");
			responseStructure.setData(getCustomerDto(customer));
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new CustomerEmailIdNotFound("customer email not found " + email);
		}

	}

	public ResponseEntity<ResponseStructure<CustomerDto>> loginCustomer(String email, String password) {
		ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
		Customer customer=dao.getCustomerByEmail(email);
		if (customer != null) {
			if (customer.getPassword().equals(password)) {
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("logged in succesfully");
				responseStructure.setData(getCustomerDto(customer));
				return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.OK);
			} else {
				responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
				responseStructure.setMessage("invalid details");
				responseStructure.setData(null);
				return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.BAD_REQUEST);
			}
		}
		throw new CustomerEmailIdNotFound("customer with the given mail not found");
	}

}


