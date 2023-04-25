package com.ty.petCart_webapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.petCart_webapp.config.ResponseStructure;
import com.ty.petCart_webapp.dto.CustomerDto;
import com.ty.petCart_webapp.entity.Customer;
import com.ty.petCart_webapp.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.val;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@ApiOperation(value = "login Customer", notes = "API is used to login customer")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully loggedin"),
			@ApiResponse(code = 404, message = "invalid login details") })
	@GetMapping("/customerlogin")
	public ResponseEntity<ResponseStructure<CustomerDto>> loginCustomer(@Valid @RequestParam String email,@RequestParam String password) {
		return service.loginCustomer(email, password);
	}
	
	@ApiOperation(value = "save Customer", notes = "API is used to save customer for given id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 404, message = "fields can not be null") })
	@PostMapping("/customer")
	public ResponseEntity<ResponseStructure<CustomerDto>> saveCustomer(@Valid@RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}
	

	@ApiOperation(value = "update Customer", notes = "API is used to update customer for given id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "details not found for particular customer id") })
	@PutMapping("/customer")
	public ResponseEntity<ResponseStructure<CustomerDto>> updateCustomer(@RequestBody Customer customer, @RequestParam int customerid) {
		return service.updateCustomer(customer, customerid);
	}


	@ApiOperation(value = "Delete Customer", notes = "API is used to delete customer for given id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 404, message = "id not found for given customer id") })
	@DeleteMapping("/customer")
	public ResponseEntity<ResponseStructure<CustomerDto>> deleteCustomer(@RequestParam int customerid) {
		return service.deleteCustomer(customerid);
	}
	

	@ApiOperation(value = "Get Customer By Id", notes = "API is used to find customer for given id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 404, message = "customer details not found for particular customer id") })
	@GetMapping("/customer")
	public ResponseEntity<ResponseStructure<CustomerDto>> getCustomerById(@RequestParam int customerid) {
		return service.getCustomerById(customerid);
	}

	@ApiOperation(value = "Get Customer By Email", notes = "API is used to find customer for given email")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 404, message = "customer details not found for given customer email") })
	@GetMapping("/customeremail")
	public ResponseEntity<ResponseStructure<CustomerDto>> getCustomerByEmail(@RequestParam String email){
		return service.getCustomerByEmail(email);
	}
}


