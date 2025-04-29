package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProj06MoreBulkDataInjectionApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj06MoreBulkDataInjectionApplication.class, args);
		//get Employee Spring bean class object
		Employee emp=ctx.getBean("emp",Employee.class);
		System.out.println(emp);
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
