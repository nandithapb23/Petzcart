package com.ty.petCart_webapp.dto;

import org.springframework.stereotype.Component;

import com.ty.petCart_webapp.entity.Address;

@Component
public class UserDto {

		private int id;
		private String firstName;
		private String lastName;
		private String email;
		private long phone;
		private Address address;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public long getPhone() {
			return phone;
		}
		public void setPhone(Long phone) {
			this.phone = phone;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		
		
	}

