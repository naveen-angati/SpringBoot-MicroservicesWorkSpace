package com.nt.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.nt.model.Employee;

import reactor.core.publisher.Flux;

//@Component
public class GetAllRecordsOperationTestRunner implements CommandLineRunner {
	

	@Override
	public void run(String... args) throws Exception {
		//create WebClient class object 
		WebClient client= WebClient.create("http://localhost:4041");
		// invoke provider  service
		Flux<Employee> flux= client.
				                                     get().
				                                     uri("/employee/all")
				                                     .retrieve().bodyToFlux(Employee.class);

                  flux.doOnNext(System.out::println).blockLast();
	}//main

}//class
