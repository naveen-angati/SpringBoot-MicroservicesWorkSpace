package com.nt.cms;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/billing")
public class BillingServiceOperationsController {
	@Autowired
	private IPaymentServiceClient  clientComp;
	
	@GetMapping("/info")
	public   ResponseEntity<String>  showBillingAmount(){
		System.out.println("clientComp class obj::"+clientComp.getClass());
		//generate the bill amount
		double billAmount = new Random().nextDouble(1000000.0);
	
		  System.out.println(" clientComp obj class name::"+clientComp.getClass());
		// invoke the  Provider MS RestOperation
		  ResponseEntity<String>  response=clientComp.getPaymentChoices();
		 //prepare final  result
		  String finalResult="Bill Amount="+billAmount+" and payment options are::"+response.getBody();
		  
		  //return final ResponseEntity object
		  return  new ResponseEntity<String>(finalResult, HttpStatus.OK);
		
	}

}
