//Client app
package com.nt.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import com.nt.sbeans.PersonInfo;
import com.nt.sbeans.PersonInfo1;

public class PropertiesFileTest {

	public static void main(String[] args) {
	   //create IOC container
		ClassPathXmlApplicationContext ctx=
				 new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get  Spring bean class obj
		PersonInfo info=ctx.getBean("pInfo",PersonInfo.class);
		System.out.println(info);
		
		System.out.println("======================");
		PersonInfo1 info1=ctx.getBean("pInfo1",PersonInfo1.class);
		System.out.println(info1.toString());
		
		
		System.out.println("===============================");
		Environment  env=ctx.getEnvironment();
		System.out.println( "name:"+env.getProperty("per.name")+" "+env.getProperty("per.age")+"\n"
				     +"os name::"+env.getProperty("os.name")+"\n Path data::"+env.getProperty("Path"));
		
		
		System.out.println("_________________________");
	     PersonInfo1  pi1=ctx.getBean("pInfo1",PersonInfo1.class);
	     PersonInfo1  pi2=ctx.getBean("pi1",PersonInfo1.class);
	     PersonInfo1  pi3=ctx.getBean("pi2",PersonInfo1.class);
	     System.out.println(pi1.hashCode()+"  "+pi2.hashCode());
	     
		
		
		//close container
		ctx.close();

	}

}
