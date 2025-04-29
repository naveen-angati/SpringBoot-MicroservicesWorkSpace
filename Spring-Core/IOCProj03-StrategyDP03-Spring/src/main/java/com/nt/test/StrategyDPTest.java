//StrategyDPTest.java
package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.DTDC;
import com.nt.sbeans.Flipkart;

public class StrategyDPTest {

	public static void main(String[] args) {
		//create  IOC Container
		//FileSystemXmlApplicationContext ctx= new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
		   
		//FileSystemXmlApplicationContext ctx= new FileSystemXmlApplicationContext("E:\\Worskpaces\\Spring\\NTSPBMS616\\IOCProj03-StrategyDP03-Spring\\src\\main\\java\\com\\nt\\cfgs\\applicationContext.xml");
		   
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
