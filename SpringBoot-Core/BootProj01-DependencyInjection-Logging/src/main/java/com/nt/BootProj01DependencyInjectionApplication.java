//main class
package com.nt;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {
	private static Logger logger=LoggerFactory.getLogger(BootProj01DependencyInjectionApplication.class);
	
	@Bean(name="ld")
	 public LocalDate  createDate() {
		logger.debug("createDate() method");
		 return  LocalDate.now();
	 }

	public static void main(String[] args) {
		logger.debug("start of main(-) method");
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		System.out.println("ctx obj class name::"+ctx.getClass());
		//get  Target spring bean class obj
		SeasonFinder  finder=ctx.getBean("sf",SeasonFinder.class);
		//invoke the b.method
		  String  seasonName=finder.findSeason();
		  System.out.println("Season Name::"+seasonName);
		  //close the IOC container
		   ((ConfigurableApplicationContext) ctx).close();
		   
			logger.debug("end of main(-) method");
	}

}
