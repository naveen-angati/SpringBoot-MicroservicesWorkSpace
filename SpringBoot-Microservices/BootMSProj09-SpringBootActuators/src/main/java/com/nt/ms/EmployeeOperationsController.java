//EmployeeOperationsController.java
package com.nt.ms;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@ConfigurationProperties(prefix = "nit.info")
public class EmployeeOperationsController {
	private String name;
	private String addrs;
	
	@GetMapping("/show")
	public  ResponseEntity<String>  showData(){
		return  new ResponseEntity<String>("from Employee Operations",HttpStatus.OK);
	}

}
