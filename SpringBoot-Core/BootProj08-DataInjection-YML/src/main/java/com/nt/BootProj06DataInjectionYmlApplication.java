package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.CustomerInfo;

@SpringBootApplication
public class BootProj06DataInjectionYmlApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj06DataInjectionYmlApplication.class, args);
		//get Spring bean class object
		CustomerInfo custInfo=ctx.getBean("cust",CustomerInfo.class);
		System.out.println(custInfo);
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
