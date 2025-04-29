package com.nt.ms;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/ticket")
public class TicketBookingOperationsController {
	
	@GetMapping("/book")
	@HystrixCommand(fallbackMethod = "dummyMethod")
	public  ResponseEntity<String> bookTickets(){
		System.out.println("TicketBookingOperationsController.bookTickets()");
		int randVal=new Random().nextInt(10);
		  if(randVal<=7)
			  throw new RuntimeException(" Invalid  booking");
		  else
			  return new ResponseEntity<String>("Ticket booking is done",HttpStatus.OK);
	}
	
	public   ResponseEntity<String> dummyMethod(){
	  System.out.println("TicketBookingOperationsController.dummyMethod()");	
	  return new ResponseEntity<String>(" Technical problem in Business operation",HttpStatus.BAD_GATEWAY);
	}

}
