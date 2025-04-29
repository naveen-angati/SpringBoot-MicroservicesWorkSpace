package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.IPurchaseOrderService;

@SpringBootApplication
public class BootMailProj01SendMailOperationApplication {

	public static void main(String[] args) {
		  //get IOC container
		ApplicationContext ctx=
				  SpringApplication.run(BootMailProj01SendMailOperationApplication.class, args);
		//get Service class obj ref
		IPurchaseOrderService service=ctx.getBean("purchaseService",IPurchaseOrderService.class);
		//invoke b.method
		try {
			String result=service.purchase(new String[] {"shirt","trouser","blazer"},
					                                              new double[] {2999.0,56789.0,7890.0},
					                                              new String[] {"nataraz@gmail.com","Sangitrasetha52@gmail.com","whatcharan1@gmail.com"});
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
			}
		//close the container
		  ((ConfigurableApplicationContext) ctx).close();
	}//main

}//class
