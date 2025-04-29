//WishMessGenerator.java (target class)
package com.nt.sbeans;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	//HAS- A Property
	@Autowired
	private LocalDateTime dateTime;
	@Autowired
	private   Date  date;
	
	
	
	
	/*@Autowired
	public  WishMessageGenerator(LocalDateTime dateTime) {
		System.out.println("WishMessageGenerator: 1-param constructor");
		 this.dateTime=dateTime;
	}*/
	

	/*@Autowired
	public  WishMessageGenerator (LocalDateTime dataTime, Date date) {
		System.out.println("WishMessageGenerator: 2-param constructor");
		 this.dateTime=dateTime;
		 this.date=date;
	}
	*/
	
	/*///setter method for setter Injection
		@Autowired
		public void  setDateTime(LocalDateTime dateTime) {
			System.out.println("WishMessageGenerator.setDateTime()");  //systrace +ctrl +space gives  s.o.p with message
			this.dateTime=dateTime;
		}
		@Autowired
		public void  setDate(Date date) {
			System.out.println("WishMessageGenerator.setDate()");
			this.date=date;
		}*/
	
	//b.method
	public  String showWishMessage(String user) {
		System.out.println("WishMessageGenerator.showWishMessage()");
		System.out.println("dateTime::"+dateTime+"  date::"+date);
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
