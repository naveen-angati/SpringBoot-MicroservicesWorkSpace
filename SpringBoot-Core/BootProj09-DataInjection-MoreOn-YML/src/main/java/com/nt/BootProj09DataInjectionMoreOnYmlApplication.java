package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProj09DataInjectionMoreOnYmlApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj09DataInjectionMoreOnYmlApplication.class, args);
		//get Spring Bean class obj ref
		Employee  emp=ctx.getBean("emp",Employee.class);
		System.out.println(emp);
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
