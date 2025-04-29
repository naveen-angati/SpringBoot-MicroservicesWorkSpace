//WishMessageRenderingController.java
package com.nt.rest;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageapi")
public class WishMessageRenderingController {
	
	@GetMapping("/wish")
	public   ResponseEntity<String> showMessage(){
		// get System Date and time
		LocalDateTime ldt=LocalDateTime.now();
		//get current hour of the day
		int hour=ldt.getHour();
		//generates wish message
		String msg=null;
		if(hour<12)
			msg="Good Morning;";
		else if(hour<16)
			msg="Good AfterNoon";
		else if(hour<20)
			msg="Good Evening";
		else 
			msg="Good Night";
			
		return  new ResponseEntity<String>(msg,HttpStatus.OK);
	}//method
	@GetMapping("/agesInfo")
	public ResponseEntity<Map<String,Integer>>  showAgesInfo(){
		Map<String,Integer> map=Map.of("raja", 30, "ramesh", 40, "suresh", 60 );
		return  new  ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);
	}
}//class
