package com.nt.pms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentServiceOperationsController {
	
	
	@GetMapping("/options")
	public   ResponseEntity<String>  getPaymentOptions(){
		try {
			Thread.sleep(30000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return  new ResponseEntity<String>(" U can do payment using  GPay, PhonePe  and etc..",HttpStatus.OK);
	}

}
