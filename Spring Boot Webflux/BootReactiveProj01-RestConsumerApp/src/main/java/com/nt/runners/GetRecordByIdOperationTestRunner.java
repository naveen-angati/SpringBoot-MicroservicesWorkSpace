package com.nt.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.nt.model.Employee;

import reactor.core.publisher.Mono;

//@Component
public class GetRecordByIdOperationTestRunner implements CommandLineRunner {
	

	@Override
	public void run(String... args) throws Exception {
		//create WebClient class object 
		WebClient client= WebClient.create("http://localhost:4041");
		// invoke provider  service
		Mono<Employee> mono=client.
				                                     get().
				                                     uri("/employee/one/1002")
				                                     .retrieve().bodyToMono(Employee.class);

                  mono.subscribe(System.out::println);
	}//main

}//class
