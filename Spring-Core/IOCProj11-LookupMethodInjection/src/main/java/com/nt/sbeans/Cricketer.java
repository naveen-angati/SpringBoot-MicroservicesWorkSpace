//Cricketer.java (Target class)
package com.nt.sbeans;

import java.util.Random;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("cktr")
public abstract class Cricketer  {
	
	public Cricketer() {
		System.out.println("Cricketer:: 0-param consturctor:"+this.getClass());
	}
		
	//@Lookup("cBat")
	@Lookup
	public  abstract CricketBat getBat();
	
	//special method
	public String batting() {
		// get Dependent class object    (internally uses the IOC container dependency lookup code of Proxy class)
		  CricketBat  bat=getBat();
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
