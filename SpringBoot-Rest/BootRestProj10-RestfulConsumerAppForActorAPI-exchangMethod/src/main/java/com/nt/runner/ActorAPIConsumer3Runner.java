package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Actor;

 //@Component
public class ActorAPIConsumer3Runner implements CommandLineRunner {
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
	
		 //keep the service url ready
		String serviceUrl="http://localhost:4040/BootRestProj10-ResfulProivderApp-ActorAPI/actor-api/report";
		
		// invoke the provider's   rest operation method   (through provide operation gives object/List of objs we get them
		                                                                                      //  in Consumer App as  JSON String )
		ResponseEntity<String>  response=template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		
		
		System.out.println(" response body (final result as json content)::"+response.getBody());
		System.out.println("response  status code ::"+response.getStatusCode());
		System.out.println("response  status code name ::"+response.getStatusCode().value());
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		// use  Jackson api to convert   the recieved  JSON content  back to  model class obj
		 String json_body=response.getBody();
		ObjectMapper mapper=new ObjectMapper();
		Actor actor=mapper.readValue(json_body,Actor.class);
		System.out.println("Data after the DeSerialization::"+actor);
		
		
		
				
		
		
		//System.exit(0);
		

	}

}
