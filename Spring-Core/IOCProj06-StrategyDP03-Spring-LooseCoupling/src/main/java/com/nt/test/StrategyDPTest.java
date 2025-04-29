//StrategyDPTest.java
package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.DTDC;
import com.nt.sbeans.Flipkart;

public class StrategyDPTest {

	public static void main(String[] args) {
		//create  IOC Container
		   ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		     // get Target sspring bean class obj
		    Flipkart fpkt=  ctx.getBean("fpkt",Flipkart.class);
		
			//invoke the b.method
				String result=fpkt.shopping(new String[] {"shirt","trouser"},
						                                         new double[] {4000.0,6000.0});
				System.out.println(result);
		
		//close container
		ctx.close();

	}

}
