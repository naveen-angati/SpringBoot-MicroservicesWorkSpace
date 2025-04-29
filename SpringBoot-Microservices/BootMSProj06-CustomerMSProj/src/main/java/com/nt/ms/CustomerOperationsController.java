//EmployeeOperationsController.java
package com.nt.ms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerOperationsController {
	@Value("${db.user}")
	private  String  uname;
	@Value("${db.pwd}")
	private  String  pwd;
	
	
	@GetMapping("/show")
	public  ResponseEntity<String>  showConfigServerData(){
		return new ResponseEntity<String>("(Customer)Data collected from Config SErver is ::"+ uname+"...."+pwd,HttpStatus.OK);
	}

}
