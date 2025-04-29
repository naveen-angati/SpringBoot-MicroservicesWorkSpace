// CustomerOperationsController.java
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerapi")
public class CustomerOperationsController {
	
	/*@PostMapping("/report")
	public  ResponseEntity<String> reportCustomerData(@RequestParam("cno") int no,
			                                                                                   @RequestParam("cname") String name){
		System.out.println(no+"........"+name);
		return  new ResponseEntity<String>(no+" ....."+name, HttpStatus.OK);
	}*/
	
	
	/*@PostMapping("/report")
	public  ResponseEntity<String> reportCustomerData(@RequestParam("cno") int no,
			                                                                                   @RequestParam(name = "cname",required = false) String name){
		System.out.println(no+"........"+name);
		return  new ResponseEntity<String>(no+" ....."+name, HttpStatus.OK);
	}*/
	
/*	@PostMapping("/report")
	public  ResponseEntity<String> reportCustomerData(@RequestParam int cno,
			                                                                                   @RequestParam(required = false) String cname){
		System.out.println(cno+"........"+cname);
		return  new ResponseEntity<String>(cno+" ....."+cname, HttpStatus.OK);
	} */
	
	@PostMapping("/report")
	public  ResponseEntity<String> reportCustomerData(@RequestParam int cno,
			                                                                                   @RequestParam(required = true,defaultValue = "king") String cname){
		System.out.println(cno+"........"+cname);
		return  new ResponseEntity<String>(cno+" ....."+cname, HttpStatus.OK);
	} 

}
