package com.nt.pms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentServiceOperationsController {
	@Value("${eureka.instance.instance-id}")
	private String  instanceNo;
	@Value("${server.port}")
	private int portNumber;
	
	
	@GetMapping("/options")
	public   ResponseEntity<String>  getPaymentOptions(){
		return  new ResponseEntity<String>(" U can do payment using  GPay, PhonePe  and etc..--->from:::"+instanceNo+"....."+portNumber
				                                                                                                                                                                                                     ,HttpStatus.OK);
	}

}
