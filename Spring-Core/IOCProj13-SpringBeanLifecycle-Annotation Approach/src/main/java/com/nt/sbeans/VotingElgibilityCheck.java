//VotingElgibilityCheck.java
package com.nt.sbeans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("vec")
public class VotingElgibilityCheck {
	//spring bean  properites
	@Value("${voter.name}")
	 private  String name;
	@Value("${voter.age}")
	 private  int age;
	 private  Date verifiedOn;

	 public VotingElgibilityCheck() {
		System.out.println("VotingElgibilityCheck:: 0-param constructor");
	}

	
	public   String  checkVotingElgibility() {
		System.out.println("VotingElgibilityCheck.checkVotingElgibility() (Business Method)");
		if(age<18)
			 return  "Mr/Mrs/Miss."+name +"  u r elgible not for voting  on date:: "+verifiedOn;
		else
			 return  "Mr/Mrs/Miss."+name +"  u r elgible  for voting on date::"+verifiedOn;
	}
	
	@PostConstruct
	public void myInit() {
		System.out.println("VotingElgibilityCheck.myInit()");
		 //initialize the left over properties
		    verifiedOn=new Date();
		  //check wheather important properties  are cfg with correct values or not
		    if(name==null || name.trim().length()==0  || age<=0)
		    	throw new IllegalArgumentException("invalid values are injecgted  for spring bean properites(name,age)");
	}
	
	@PreDestroy
	public void myDestroy() {
		System.out.println("VotingElgibilityCheck.myDestroy()");
		//nullify the spring bean properties
		 name=null;
		 age=0;
	}
   
}
