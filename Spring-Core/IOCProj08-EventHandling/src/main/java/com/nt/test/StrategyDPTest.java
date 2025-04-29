//StrategyDPTest.java
package com.nt.test;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.Flipkart;

public class StrategyDPTest {

	public static void main(String[] args) {
		//create  IOC Container
		   ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		     // get Target sspring bean class obj
		    com.nt.sbeans.Flipkart fpkt=  ctx.getBean("Flipkart",com.nt.sbeans.Flipkart.class);
		    System.out.println(fpkt.hashCode());
			//invoke the b.method
				String result=fpkt.shopping(new String[] {"shirt","trouser"},
						                                         new double[] {4000.0,6000.0});
				System.out.println(result);
				
				System.out.println("++++++++++++++++++++++++++");
				Date d1=ctx.getBean("java.util.Date",Date.class);
				System.out.println(d1.hashCode());
				Date d2=ctx.getBean("java.util.Date#0",Date.class);
				System.out.println(d2.hashCode());
				
				Date d3=ctx.getBean("java.util.Date#1",Date.class);
				System.out.println(d3.hashCode());
		//close container
		ctx.close();
	}

}
