//WishMessGenerator.java (target class)
package com.nt.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("wmg")
@Scope("request")
@Lazy(true)
public class WishMessageGenerator {
	//HAS- A Property
	@Autowired
	private LocalDateTime dateTime;
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator:: 0-param constructor");
	}
	
	
	
	//b.method
	public  String showWishMessage(String user) {
		System.out.println("WishMessageGenerator.showWishMessage()");
		System.out.println("dateTime::"+dateTime+"  "+dateTime.hashCode());
		 //get current  hour of  day
		 int hour=dateTime.getHour();
		 //generate the wish message
		  if(hour<12)
			   return "Good Morning:"+user;
		  else if(hour<16)
			  return "Good Afternoon:"+user;
		  else if(hour<20)
			  return "Good Evening:"+user;
		  else
			  return "Good Night :"+user;
	}

}
