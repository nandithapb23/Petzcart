package com.ty.petCart_webapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.petCart_webapp.config.ResponseStructure;
import com.ty.petCart_webapp.dto.AddressDto;
import com.ty.petCart_webapp.entity.Address;
import com.ty.petCart_webapp.service.AddressService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService service;
	
	@ApiOperation(value = "Save Address", notes = "API is used to save address for given user id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 404, message = "id not found for given user id") })
	@PostMapping
	public ResponseEntity<ResponseStructure<AddressDto>> saveAddress(@Valid @RequestBody Address address,@RequestParam int id) {
		return service.saveAddress(address,id);
	}
	
	@ApiOperation(value = "Update Address", notes = "API is used to update address for given address id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "id not found for given address id") })
	@PutMapping
	public ResponseEntity<ResponseStructure<AddressDto>> updateAddress(@RequestBody Address address,@RequestParam int a_id) {
		return service.updateAddressDto(address, a_id);
	}
	
	@ApiOperation(value = "Delete Address", notes = "API is used to delete address for given address id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 404, message = "id not found for given address id") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<AddressDto>> deleteAddress(@RequestParam int a_id) {
		return service.deleteAddress(a_id);
	}
	@ApiOperation(value = "Get Address By Id", notes = "API is used to find the address based on Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 404, message = "address not found for given particular address id") })
	@GetMapping
	public ResponseEntity<ResponseStructure<AddressDto>> getAddressById(@RequestParam int a_id) {
		return service.getAddressById(a_id);
	}
}
