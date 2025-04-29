package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorAPIConsumerRunner implements CommandLineRunner {
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
	
		 //keep the service url ready
		String serviceUrl="http://localhost:4040/BootRestProj10-ResfulProivderApp-ActorAPI/actor-api/wish";
		
		// invoke the provider's   rest operation method
		ResponseEntity<String>  response=template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		
		System.out.println(" response body (final result)::"+response.getBody());
		System.out.println("response  status code ::"+response.getStatusCode());
		System.out.println("response  status code name ::"+response.getStatusCode().value());
		//System.exit(0);
		}

}
