// CustomerOperationsController.java
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerapi")
public class CustomerOperationsController {
	
	
	/*@GetMapping("/report/{no}/{name}")
	public  ResponseEntity<String> reportCustomerData(@PathVariable("no") int cno,
			                                                                                   @PathVariable("name") String cname){
		System.out.println(cno+"........"+cname);
		return  new ResponseEntity<String>(cno+" ....."+cname, HttpStatus.OK);
	} */
	
	/*@GetMapping("/report/{cno}/{cname}")
	public  ResponseEntity<String> reportCustomerData(@PathVariable(required = false) String cno,
			                                                                                   @PathVariable(required = false) String cname){
		System.out.println(cno+"........"+cname);
		return  new ResponseEntity<String>(cno+" ....."+cname, HttpStatus.OK);
	} */
	
	@GetMapping("/report/101/raja")
	public  ResponseEntity<String> reportData1(@PathVariable(required = false) String cno,
			                                                                                   @PathVariable(required = false) String cname){
		  return  new ResponseEntity<String>("reportData1",HttpStatus.OK);
	} 
	
	@GetMapping("/report/{cno}/{cname}")
	public  ResponseEntity<String> reportData2(@PathVariable(required = false) String cno,
			                                                                                   @PathVariable(required = false) String cname){
		  return  new ResponseEntity<String>("reportData2",HttpStatus.OK);
	} 
	

	
	/*@GetMapping("/report/{cno}/cname")
	public  ResponseEntity<String> reportData3(@PathVariable(required = false) String cno,
			                                                                                   @PathVariable(required = false) String cname){
		  return  new ResponseEntity<String>("reportData3",HttpStatus.OK);
	}
	
	@GetMapping("/report/cno/{cname}")
	public  ResponseEntity<String> reportData4(@PathVariable(required = false) String cno,
			                                                                    @PathVariable(required = false) String cname){
		  return  new ResponseEntity<String>("reportData4",HttpStatus.OK);
	} */


}
