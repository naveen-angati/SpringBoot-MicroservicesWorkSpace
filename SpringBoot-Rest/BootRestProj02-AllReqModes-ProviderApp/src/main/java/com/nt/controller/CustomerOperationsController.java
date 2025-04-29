package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerapi")
public class CustomerOperationsController {
	
	
	@GetMapping("/all")
	public  ResponseEntity<String>  getAllCustomers(){
		return new  ResponseEntity<String>("All Customers  are retrived(GET)",HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public   ResponseEntity<String>  registerCustomer(){
		return new  ResponseEntity<String>("Customer is registered(POST)",HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public   ResponseEntity<String>  updateCustomer(){
		return new  ResponseEntity<String>("Customer is fully updated(PUT)",HttpStatus.OK);
	}
	
	@PatchMapping("/updateEmail")
	public   ResponseEntity<String>  updateCustomerEmail(){
		return new  ResponseEntity<String>("Customer Email updated(PATCH)",HttpStatus.OK);
	}
	
	@DeleteMapping("/remove")
	public   ResponseEntity<String>  removeCustomer(){
		return new  ResponseEntity<String>("Customer is deleted(DELETE)",HttpStatus.OK);
	}
	
	


}
