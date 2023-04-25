package com.ty.petCart_webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.petCart_webapp.config.ResponseStructure;
import com.ty.petCart_webapp.dao.AddressDao;
import com.ty.petCart_webapp.dao.CustomerDao;
import com.ty.petCart_webapp.dao.PetsDao;
import com.ty.petCart_webapp.dao.UserDao;
import com.ty.petCart_webapp.dto.PetsDto;
import com.ty.petCart_webapp.entity.Address;
import com.ty.petCart_webapp.entity.Customer;
import com.ty.petCart_webapp.entity.Pets;
import com.ty.petCart_webapp.entity.User;
import com.ty.petCart_webapp.exception.CustomerIdNotFound;
import com.ty.petCart_webapp.exception.PetCategoryNotFoundException;
import com.ty.petCart_webapp.exception.PetIdNotFound;
import com.ty.petCart_webapp.exception.PetsNotFoundForParticularUser;
import com.ty.petCart_webapp.exception.UserIdNotFound;

@Service
public class PetService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PetsDao dao;
	@Autowired
	private PetsDto dto;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private CustomerDao customerDao;
	ResponseStructure<PetsDto> structure = new ResponseStructure<>();

	public PetsDto getPetsDto(Pets pets) {
		dto.setP_id(pets.getP_id());
		dto.setP_breed(pets.getP_breed());
		dto.setP_address(pets.getP_address());
		dto.setP_category(pets.getP_category());
		dto.setP_lifespan(pets.getP_lifespan());
		dto.setStatus(pets.getStatus());
		dto.setP_cost(pets.getP_cost());
		dto.setUser(pets.getUser());
		dto.setCustomer(pets.getCustomer());
		dto.setMedications(pets.getMedications());
		return dto;
	}

	public ResponseEntity<ResponseStructure<PetsDto>> savePets(Pets pets,int userid) {
		User user=userDao.getUserById(userid);
		if(user!=null) {
			pets.setUser(user);
		ResponseStructure<PetsDto> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("pets succesfully saved");
		responseStructure.setData(getPetsDto(dao.savePets(pets)));
		return new ResponseEntity<ResponseStructure<PetsDto>>(responseStructure, HttpStatus.CREATED);
	}else {
		throw new UserIdNotFound("user id not found");
	}
	}
	
	public ResponseEntity<ResponseStructure<PetsDto>> sellPetsToCustomer(int p_id,int customerid ){
		Customer customer=customerDao.getCustomerById(customerid);
		if(customer!=null) {
			Pets pets=dao.getPetsById(p_id);
			if(pets!=null) {
				pets.setStatus("sold");
				pets.setCustomer(customer);
				ResponseStructure<PetsDto> responseStructure = new ResponseStructure<>();
				responseStructure.setStatus(HttpStatus.CREATED.value());
				responseStructure.setMessage("pets succesfully sold");
				responseStructure.setData(getPetsDto(dao.updatePets(pets)));
				return new ResponseEntity<ResponseStructure<PetsDto>>(responseStructure, HttpStatus.CREATED);
			}else 
				throw new PetIdNotFound("pets not found");
		}
		else
			throw new CustomerIdNotFound("customer not found");
		}


	public ResponseEntity<ResponseStructure<PetsDto>> updatePets(Pets pets, int p_id) {
		Pets pets2 = dao.getPetsById(p_id);
		if (pets2 != null) {
			pets.setP_id(p_id);
			pets.setUser(pets2.getUser());
			pets.setStatus(pets2.getStatus());
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("pets succesfully updated");
			structure.setData(getPetsDto(dao.updatePets(pets)));
			return new ResponseEntity<ResponseStructure<PetsDto>>(structure, HttpStatus.OK);
		}
		throw new PetIdNotFound("pets id not found " + p_id);
	}

	public ResponseEntity<ResponseStructure<PetsDto>> deletePets(int p_id) {
		Pets pets = dao.deletePets(p_id);
		ResponseStructure<PetsDto> structure = new ResponseStructure<>();
		if (pets != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("pets sucessfully deleted");
			structure.setData(getPetsDto(pets));
			return new ResponseEntity<ResponseStructure<PetsDto>>(structure, HttpStatus.OK);
		}
		throw new PetIdNotFound("pets id not found " + p_id);
	}

	public ResponseEntity<ResponseStructure<PetsDto>> getPetsById(int p_id) {
		Pets pets = dao.getPetsById(p_id);
		ResponseStructure<PetsDto> structure = new ResponseStructure<>();
		if (pets != null) {
			System.out.println(pets.toString());
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("pets id found");
			structure.setData(getPetsDto(pets));
			return new ResponseEntity<ResponseStructure<PetsDto>>(structure, HttpStatus.FOUND);
		}
		throw new PetIdNotFound("pets id not found " + p_id);
	}

	public ResponseEntity<ResponseStructure<List<Pets>>> getPetsByCategory(String p_catageory) {
		List<Pets> list = dao.getPetsByCategory(p_catageory);
		ResponseStructure<List<Pets>> structure = new ResponseStructure<>();
		if (list.isEmpty()) {
			throw new PetCategoryNotFoundException("pet category not found " + p_catageory);
		} else {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("pets category found");
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Pets>>>(structure, HttpStatus.FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Pets>> updatePetUser(int p_id, int id) {
		User user = userDao.getUserById(id);
		Pets pets = dao.getPetsById(p_id);
		pets.setUser(user);
		ResponseStructure<Pets> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("pet user updated");
		structure.setData(dao.updatePets(pets));
		return new ResponseEntity<ResponseStructure<Pets>>(structure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<List<Pets>>> getUserpets(int id) throws PetsNotFoundForParticularUser {
		User user=userDao.getUserById(id);
		List<Pets> dblist=new ArrayList<>();
		List<Pets> list=dao.getAllPets();
		for(Pets pets:list) {
			if(pets.getUser().equals(user)) {
				dblist.add(pets);
			}
		}
		if(dblist.isEmpty()) {
			throw new PetsNotFoundForParticularUser("pets not found for given user");
		}
		ResponseStructure<List<Pets>> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("pet user found");
		structure.setData(dblist);
		return new ResponseEntity<ResponseStructure<List<Pets>>>(structure, HttpStatus.FOUND);
		
	}
}
