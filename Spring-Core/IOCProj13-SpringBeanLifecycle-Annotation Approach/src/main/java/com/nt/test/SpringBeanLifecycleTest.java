//SpringBeanLifecycleTest.java
package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.VotingElgibilityCheck;

public class SpringBeanLifecycleTest {

	public static void main(String[] args) {
		//create  IOC container 
		ClassPathXmlApplicationContext ctx=
				  new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		System.out.println("__________________");
		//get spring bean class object
		VotingElgibilityCheck  vec=ctx.getBean("vec",VotingElgibilityCheck.class);
		
		try {
		//invoke the b.method
		String result=vec.checkVotingElgibility();
		System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("____________________");
		//close the container
		ctx.close();

	}

}
