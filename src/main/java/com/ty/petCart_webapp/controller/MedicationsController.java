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
import com.ty.petCart_webapp.dto.MedicationsDto;
import com.ty.petCart_webapp.entity.Medications;
import com.ty.petCart_webapp.service.MedicationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedicationsController {
	@Autowired
	private MedicationService service;

	@ApiOperation(value = "Save Medications", notes = "API is used to save medications for given Pet Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 404, message = "fields cannot be null") })
	@PostMapping("/medications")
	public ResponseEntity<ResponseStructure<MedicationsDto>> saveMedications(@Valid@RequestBody Medications medications,@RequestParam int petsid) {
		return service.saveMedications(medications,petsid);
	}
	@ApiOperation(value = "Update Medications", notes = "API is used to update medications  for given medication Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "Id not found for the given medication ID") })
	@PutMapping("/medications")
	public ResponseEntity<ResponseStructure<MedicationsDto>> updateMedications(@RequestBody Medications medications, @RequestParam int m_id) {
		return service.updateMedications(medications, m_id);
	}
	
	@ApiOperation(value = "Delete Medications", notes = "API is used to save Pets for given Pet Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 404, message = "Id not found for the given medication ID") })
	@DeleteMapping("/medications")
	public ResponseEntity<ResponseStructure<MedicationsDto>> deleteMedications(@RequestParam int m_id) {
		return service.deleteMedications(m_id);
	}
	
	@ApiOperation(value = "Get Medications By Id", notes = "API is used to get medications for given medication Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 404, message = "Id not found for the given medication ID") })
	@GetMapping("/medications")
	public ResponseEntity<ResponseStructure<MedicationsDto>> getMedicationsById(@RequestParam int m_id) {
		return service.getMedicationsById(m_id);
	}
	@ApiOperation(value = "Get Medications By drugname", notes = "API is used to get medications for given medication drugname")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 404, message = "medication not found for given drugname") })
	@GetMapping("/medrug")
	public ResponseEntity<ResponseStructure<MedicationsDto>> getMedicationsByDrugname(@RequestParam String drug_name) {
		return service.getMedicationsByDrugname(drug_name);

}
}