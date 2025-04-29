package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankOperationsService;

public class MethodReplacerTest {

	public static void main(String[] args) {
		//create IOC container 
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Target spring bean class object
		BankOperationsService proxy=ctx.getBean("bankService",BankOperationsService.class);
		System.out.println(proxy.getClass()+"-------"+proxy.getClass().getSuperclass());
		//invoke the b.method
		try {
			double  intrAmt=proxy.calculateIntrestAmount(100000.0, 2.0, 12.0);
			System.out.println("Intrest amount is ::"+intrAmt);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		 ctx.close();

	}

}
