package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorAPIConsumer2Runner implements CommandLineRunner {
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
	
		 //keep the service url ready
		String serviceUrl="http://localhost:4040/BootRestProj10-ResfulProivderApp-ActorAPI/actor-api/register";
		
		//json body
		String json_body="{ \"id\": 1001 , \"name\": \"raja\" , \"addrs\": \"hyd\" , \"remuneration\": 90000 }";
		
		// headers
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//constructor request obj having  headers ,body
		 HttpEntity<String>  entityRequest=new HttpEntity<String>(json_body,headers);
		
		// invoke the provider's   rest operation method
		ResponseEntity<String>  response=template.exchange(serviceUrl,
				                                                                                       HttpMethod.POST,
				                                                                                       entityRequest,
				                                                                                       String.class);
		
		
		System.out.println(" response body (final result)::"+response.getBody());
		System.out.println("response  status code ::"+response.getStatusCode());
		System.out.println("response  status code name ::"+response.getStatusCode().value());
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		
		System.exit(0);
		

	}

}
