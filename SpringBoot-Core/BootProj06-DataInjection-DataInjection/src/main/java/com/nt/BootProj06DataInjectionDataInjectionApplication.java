package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Company1;
import com.nt.sbeans.Company2;

@SpringBootApplication
public class BootProj06DataInjectionDataInjectionApplication {

	public static void main(String[] args) {
		//get  IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj06DataInjectionDataInjectionApplication.class, args);
		//get  Spring bean class objects
		Company1 comp1=ctx.getBean("comp1",Company1.class);
		System.out.println(comp1);
		System.out.println("------------------------------------");
		//get  Spring bean class objects
				Company2 comp2=ctx.getBean("comp2",Company2.class);
				System.out.println(comp2);
	   System.out.println("system properties are ::"+System.getProperties());
				
	//close container
				 ((ConfigurableApplicationContext) ctx).close();
	}

}
