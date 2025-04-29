package com.nt.cms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/billing")
@Slf4j
public class BillingServiceOperationsController {
	@Autowired
	private IPaymentServiceClient  clientComp;
	
	@GetMapping("/info")
	public   ResponseEntity<String>  showBillingAmount(){
		log.info("start of showBillingAmount() method");
		//generate the bill amount
		double billAmount = new Random().nextDouble(1000000.0);
	
		  System.out.println(" clientComp obj class name::"+clientComp.getClass());
		// invoke the  Provider MS RestOperation
		  log.info("target MS is invoked");
		  ResponseEntity<String>  response=clientComp.getPaymentChoices();
		 //prepare final  result
		
		  String finalResult="Bill Amount="+billAmount+" and payment options are::"+response.getBody();
		  log.debug("final  result is prepared");
		  //return final ResponseEntity object
		  log.info("end of  showBillingAmount() method");
		  return  new ResponseEntity<String>(finalResult, HttpStatus.OK);
		
	}

}
