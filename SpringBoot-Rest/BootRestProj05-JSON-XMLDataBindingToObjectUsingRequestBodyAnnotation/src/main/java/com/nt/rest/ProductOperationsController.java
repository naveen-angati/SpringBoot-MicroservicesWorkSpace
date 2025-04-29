//ProductOperationsController.java
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Product;

@RestController
@RequestMapping("/productapi")
public class ProductOperationsController {
	
	@PostMapping("/register")
	public  ResponseEntity<String>  registerProduct(@RequestBody Product prod){
		System.out.println("ProductOperationsController.registerProduct():::"+prod);
		return new   ResponseEntity<String>(prod.toString()+" is registered",HttpStatus.CREATED);
	}

}
