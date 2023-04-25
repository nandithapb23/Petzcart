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
import com.ty.petCart_webapp.dto.PetsDto;
import com.ty.petCart_webapp.entity.Pets;
import com.ty.petCart_webapp.exception.PetsNotFoundForParticularUser;
import com.ty.petCart_webapp.service.PetService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PetController {
	@Autowired
	private PetService petService;

	@ApiOperation(value = "Save Pets", notes = "API is used to save Pets for given Pet Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 404, message = "fields cannot be null") })
	@PostMapping("/pets")
	public ResponseEntity<ResponseStructure<PetsDto>> savePets(@Valid @RequestBody Pets pets,@RequestParam int userid) {
		return petService.savePets(pets,userid);
	}
	@ApiOperation(value = "sell pets to customer", notes = "API is used to sell pets for given Customer Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "Id not found for the given customer or pet ID") })
	@PutMapping("/petsold")
	public ResponseEntity<ResponseStructure<PetsDto>> sellPetsToCustomer(@Valid @RequestParam int p_id,int customerid) {
		return petService.sellPetsToCustomer(p_id, customerid);
	}
	@ApiOperation(value = "Update Pets", notes = "API is used to update pets for given pet Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "Id not found for the given pet ID") })
	@PutMapping("/pets")
	public ResponseEntity<ResponseStructure<PetsDto>> updatePets(@RequestBody Pets pets, @RequestParam int p_id) {
		return petService.updatePets(pets, p_id);
	}
	@ApiOperation(value = "delete pets", notes = "API is used to delete pets for given pet Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 404, message = "Id not found for the given pet ID") })
	@DeleteMapping("/pets")
	public ResponseEntity<ResponseStructure<PetsDto>> deletePets(@RequestParam int p_id) {
		return petService.deletePets(p_id);
	}
	@ApiOperation(value = "get pets by id", notes = "API is used to get pets for given pet Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 404, message = "Id not found for the given pet ID") })
	@GetMapping("/pets")
	public ResponseEntity<ResponseStructure<PetsDto>> getPetsById(@RequestParam int p_id) {
		return petService.getPetsById(p_id);
	}
	@ApiOperation(value = "get pets by category", notes = "API is used to get pets for given pet category")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 404, message = "pets not found for the given pet category") })
	@GetMapping("/petscategory")
	public ResponseEntity<ResponseStructure<List<Pets>>> getPetsByCategory(@RequestParam String p_category){
		return petService.getPetsByCategory(p_category);
	}
	@ApiOperation(value = "update petsUser", notes = "API is used to update pets for given user Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "Id not found for the given user or pet ID") })
	@PutMapping("/petsuser")
	public ResponseEntity<ResponseStructure<Pets>> updatePetUser(@RequestParam int p_id,@RequestParam int id) {
		return petService.updatePetUser(p_id,id);
	}
	@ApiOperation(value = "get User pets", notes = "API is used to get pets for given user Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 404, message = "Id not found for the given user or pet ID") })
	@GetMapping("/userpets")
	public ResponseEntity<ResponseStructure<List<Pets>>> getUserPets(@RequestParam int id) throws PetsNotFoundForParticularUser {
		return petService.getUserpets(id);
	}
	

}
