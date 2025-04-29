package com.nt.ms;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/ticket")
public class TicketBookingOperationsController {
	  int count=0;
	
	@GetMapping("/book")
	/*
	 * @HystrixCommand(fallbackMethod = "dummyMethod", commandProperties =
	 * {@HystrixProperty(name = "circuitBreaker.enabled",value = "true") })
	 */
	@HystrixCommand(fallbackMethod = "dummyMethod",
	              commandProperties ={@HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
	                                                      @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
	                                                      @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000")
	                                                    }
	                                                   )
	public  ResponseEntity<String> bookTickets(){
		System.out.println("TicketBookingOperationsController.bookTickets()");
		int randVal=new Random().nextInt(10);
		  if(randVal<=8)
			  throw new RuntimeException(" Invalid  booking");
		  else
			  return new ResponseEntity<String>("Ticket booking is done",HttpStatus.OK);
	}
	
	public   ResponseEntity<String> dummyMethod(){
		 count++;
	  System.out.println("TicketBookingOperationsController.dummyMethod()::"+count);	
	  return new ResponseEntity<String>(" Technical problem in Business operation",HttpStatus.BAD_GATEWAY);
	}

}
