package com.nt.ms;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketBookingOperationsController {
	
	@GetMapping("/book")
	@HystrixCommnad(dummyMethod="fackMethod")
	public  ResponseEntity<String> bookTickets(){
		int randVal=new Random().nextInt(10);
		  if(randVal<=9)
			  throw new IllegalArgumentException(" Invalid  booking");
		  else
			  return new ResponseEntity<String>("Ticket booking is done",HttpStatus.OK);
	}

}
