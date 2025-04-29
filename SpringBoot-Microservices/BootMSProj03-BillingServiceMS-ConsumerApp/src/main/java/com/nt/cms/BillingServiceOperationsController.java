package com.nt.cms;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	private DiscoveryClient  clientComp;
	
	@GetMapping("/info")
	public   ResponseEntity<String>  showBillingAmount(){
		//generate the bill amount
		double billAmount = new Random().nextDouble(1000000.0);
		
		//  use Client Comp to get Provider MS related ServiceInstance from the EurekaServer
		List<ServiceInstance>  siList=clientComp.getInstances("PAYMENT-SERVICE");
		// get Details from  Provider MS Details
		  String url=siList.get(0).getUri()+"/payment/options";   //Provider MS one Rest operation method
		  System.out.println(url);
		//create RestTemplate object
		  RestTemplate  template=new RestTemplate();
		// invoke the  Provider MS RestOperation
		  ResponseEntity<String>  response=template.exchange(url,HttpMethod.GET,null,String.class);
		 //prepare final  result
		  String finalResult="Bill Amount="+billAmount+" and payment options are::"+response.getBody();
		  
		  //return final ResponseEntity object
		  return  new ResponseEntity<String>(finalResult, HttpStatus.OK);
		
	}

}
