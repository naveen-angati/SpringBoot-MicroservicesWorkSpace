//SearchServiceOperationsController.java
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SearchService")
public class SearchServiceOperationsController {
	
	@GetMapping("/show")
	public  ResponseEntity<String> showMessage(){
		return new ResponseEntity<String>("welcome to  MicroService Development (SearchService)",
				                                                       HttpStatus.OK);
	}

}//class
