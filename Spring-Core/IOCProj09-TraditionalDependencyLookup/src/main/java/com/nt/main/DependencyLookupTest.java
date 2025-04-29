// DependencyLookupTest.java
package com.nt.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.Cricketer;

public class DependencyLookupTest {

	public static void main(String[] args) {
	   //create IOC container
		 ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		 //get  target spring bean class object
		 Cricketer cktr=ctx.getBean("cktr",Cricketer.class);
		 //invoke the b.methods
		 System.out.println(cktr.batting());
		 System.out.println(cktr.bowling());
		 System.out.println(cktr.fileding());
		 System.out.println("------------------");
		 System.out.println(cktr.batting());
		 
		 
		 //close the container
		   ctx.close();
		 

	}

}
