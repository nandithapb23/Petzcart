package com.ty.petCart_webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.petCart_webapp.config.ResponseStructure;
import com.ty.petCart_webapp.dao.AddressDao;
import com.ty.petCart_webapp.dao.UserDao;
import com.ty.petCart_webapp.dto.AddressDto;
import com.ty.petCart_webapp.entity.Address;
import com.ty.petCart_webapp.entity.User;
import com.ty.petCart_webapp.exception.AddressIdNotFound;
import com.ty.petCart_webapp.exception.UserIdNotFound;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;
	@Autowired
	private AddressDto addressDto;
	@Autowired
	private UserDao dao;

	public AddressDto getAddressDto(Address address) {
		addressDto.setA_id(address.getA_id());
		addressDto.setStreet_name(address.getStreet_name());
		addressDto.setDistrict(address.getDistrict());
		addressDto.setLandmark(address.getLandmark());
		addressDto.setPincode(address.getPincode());
		return addressDto;
	}
	public ResponseEntity<ResponseStructure<AddressDto>> saveAddress(Address address,int id) {
		User  user=dao.getUserById(id);
		if(user!=null) {
	Address address2=addressDao.saveAddress(address);
	user.setAddress(address2);
	dao.updateUSer(user, id);
	ResponseStructure<AddressDto> structure=new ResponseStructure<>();
	structure.setStatus(HttpStatus.CREATED.value());
	structure.setMessage("address saved succesfully");
	structure.setData(getAddressDto(address2));
		return new ResponseEntity<ResponseStructure<AddressDto>>(structure, HttpStatus.CREATED);
	}else {
		throw new UserIdNotFound("user id not found");
	}
	}

	public ResponseEntity<ResponseStructure<AddressDto>> updateAddressDto(Address address, int a_id) {
		Address address2=addressDao.updateAddress(address, a_id);
		ResponseStructure<AddressDto> structure=new ResponseStructure<>();
		if(address2!=null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("address updated succesfully");
			structure.setData(getAddressDto(address2));
			return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.OK);
		}
		throw new AddressIdNotFound("address id not found");
	}

	public ResponseEntity<ResponseStructure<AddressDto>> deleteAddress(int a_id) {
		Address address2=addressDao.deleteAddress(a_id);
		ResponseStructure<AddressDto> structure=new ResponseStructure<>();
		if(address2!=null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("address deleted succesfully");
			structure.setData(getAddressDto(address2));
		return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.OK);
	}
		throw new AddressIdNotFound("address id not found");

	}

	public ResponseEntity<ResponseStructure<AddressDto>> getAddressById(int a_id) {
		Address address = addressDao.getAddressById(a_id);
		ResponseStructure<AddressDto> structure=new ResponseStructure<>();
		if(address!=null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("address found succesfully");
			structure.setData(getAddressDto(address));
		return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.OK);
	}
		throw new AddressIdNotFound("address id not found");

}
}
