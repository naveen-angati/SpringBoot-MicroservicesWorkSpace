package com.nt.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.nt.model.Employee;

import reactor.core.publisher.Mono;

@Component
public class RemoveRecordByIdOperationTestRunner implements CommandLineRunner {
	

	@Override
	public void run(String... args) throws Exception {
		//create WebClient class object 
		WebClient client= WebClient.create("http://localhost:4041");
		// invoke provider  service
		Mono<Void> mono=client.delete().
				                                     uri("/employee/remove/1002")
				                                     .retrieve().bodyToMono(Void.class);

                  mono.subscribe(System.out::println);
                  System.out.println("Record deleted");
	}//main

}//class
