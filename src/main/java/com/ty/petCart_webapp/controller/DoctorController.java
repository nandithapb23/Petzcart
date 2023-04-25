package com.ty.petCart_webapp.controller;

import java.util.List;

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
import com.ty.petCart_webapp.dto.DoctorDto;
import com.ty.petCart_webapp.entity.Doctors;
import com.ty.petCart_webapp.entity.Medications;
import com.ty.petCart_webapp.exception.DoctorNotFoundByEmail;
import com.ty.petCart_webapp.service.DoctorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class DoctorController {
	@Autowired
	private DoctorService service;

	@ApiOperation(value = "Save Doctor", notes = "API is used to save doctor for given doctor Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 404, message = "fields cannot be null") })
	@PostMapping("/doctor")
	public ResponseEntity<ResponseStructure<DoctorDto>> saveDoctor(@Valid @RequestBody Doctors doctors) {
		return service.saveDoctor(doctors);
	}
	
	@ApiOperation(value = "Update Doctor", notes = "API is used to update doctor for given doctor Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "Id not found for the given doctor id") })
	@PutMapping("/doctor")
	public ResponseEntity<ResponseStructure<DoctorDto>> updateDoctor(@RequestBody Doctors doctors, @RequestParam int d_id) {
		return service.updateDoctor(doctors, d_id);
	}

	@ApiOperation(value = "Delete Doctor", notes = "API is used to delete doctor for given doctor Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 404, message = "Id not found for the given doctor id") })
	@DeleteMapping("/doctor")
	public ResponseEntity<ResponseStructure<DoctorDto>> deleteDoctor(@RequestParam int d_id) {
		return service.deleteDoctor(d_id);
	}

	@ApiOperation(value = "Get Doctor By Id", notes = "API is used to find the doctor based on doctor id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 404, message = "Doctor details not found for the given doctor id") })
	@GetMapping("/doctor")
	public ResponseEntity<ResponseStructure<DoctorDto>> getDoctorById(@RequestParam int d_id) {
		return service.getDoctorById(d_id);
	}
	@ApiOperation(value = "Get Doctor By Email", notes = "API is used to find the doctor based on doctor email")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "Id not found for the given doctor id") })
	@GetMapping("/doctoremail")
	public ResponseEntity<ResponseStructure<DoctorDto>> getDoctorByEmail(@RequestParam String email) throws DoctorNotFoundByEmail {
		return service.getDoctorByEmail(email);
	}
	
	@ApiOperation(value = "Update Doctor Medicines", notes = "API is used to update the medicines for particular doctor id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "Id not found for the given doctor id") })
	@PutMapping("/docmed")
	public ResponseEntity<ResponseStructure<Doctors>> updatedoctorMedication(@RequestParam int d_id,@RequestBody List<Integer> integers) {
		return service.updatedoctorMedication(d_id,integers);
	}

	
}
