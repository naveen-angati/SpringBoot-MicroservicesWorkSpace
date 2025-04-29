//Cricketer.java
package com.nt.sbeans;

import java.util.Random;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("cktr")
@Lazy(true)
public class Cricketer {
	
	public Cricketer() {
		System.out.println("Cricketer:: 0-param constructor");
	}
	
	public String batting() {
		//create additional IOC container
		 ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		 //get Dependent spring bean class object  (Dependency lookup)
		 CricketBat  bat=ctx.getBean("cBat",CricketBat.class);
	     // use the depednent object
		  int runs=bat.scoreRuns();
		 return "Cricketer is batting"+bat.scoreRuns();
	}
	
	public  String bowling() {
		return " Cricketer is bowling";
	}
	
	public  String wicketKeeping() {
		return " Cricketer is keeping the wickets";
	}
	
	public  String fileding() {
		return " Cricketer is fielding the ball";
	}

}
