//SpringI18nTest.java
package com.nt.main;

import java.util.Locale;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringI18nTest {

	public static void main(String[] args) {
		//create the  IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	          //create Locale object
		  Locale locale=new Locale(args[0], args[1]);
			//get message from the Locale specific or   base properites file
		    String msg1=ctx.getMessage("welcome.msg", new Object[] {}, locale);
		    String msg2=ctx.getMessage("goodbye.msg", new Object[] {}, locale);
		    //display the MEssage
		     System.out.println(msg1+"  "+msg2);
		 
		//close the container
		       ctx.close();

	}

}
