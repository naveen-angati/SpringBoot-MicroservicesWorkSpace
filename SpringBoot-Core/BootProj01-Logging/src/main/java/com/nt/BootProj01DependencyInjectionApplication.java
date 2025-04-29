//main class
package com.nt;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j   // lombok api annotation
public class BootProj01DependencyInjectionApplication {
	
	@Bean(name="ld")
	 public LocalDate  createDate() {
		log.debug(" from  createDate() method");
		 return  LocalDate.now();
	 }

	public static void main(String[] args) {
		log.trace("App is started");
		log.debug("start of main  method");
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		log.info("IOC container is created");
		System.out.println("ctx obj class name::"+ctx.getClass());
		//get  Target spring bean class obj
		SeasonFinder  finder=ctx.getBean("sf",SeasonFinder.class);
		//invoke the b.method
		  String  seasonName=finder.findSeason();
		  System.out.println("Season Name::"+seasonName);
		  log.info("B.method is invoked");
		  
		  //close the IOC container
		   ((ConfigurableApplicationContext) ctx).close();
		   log.info("IOC container is closed");
		   log.debug("End of main(-) method");
		   log.trace("Application is about to complete");
	}

}
