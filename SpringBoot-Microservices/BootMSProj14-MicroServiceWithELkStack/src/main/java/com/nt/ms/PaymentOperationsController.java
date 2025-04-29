package com.nt.ms;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/payment")
@RestController
@Slf4j
public class PaymentOperationsController {

	 @GetMapping("/billing")
	public    ResponseEntity<String>  doPayment(){
		 log.info("At beging of doPayment() method");
		//generatne paymnent
		 int amount=new Random().nextInt(100000);
		 log.info("Bill Amount is generated");
		   if(amount<10000) {
			   try {
			    log.error("Problem is  billamoint generated");
			   throw new RuntimeException("this is not a valid payment");
			   }
			   catch(Exception e) {
				   log.error("Problem is  billamoint generated::"+e.getMessage());
				   return new ResponseEntity<String>("problem is  billamoint genernattion::",HttpStatus.INTERNAL_SERVER_ERROR);
			   }
		   }
		   else {
			   log.info("Bill Amount is successfully send  to  Client App");
			   return new ResponseEntity<String>("Amount ::"+amount,HttpStatus.OK);
		   }
	}
	
}
