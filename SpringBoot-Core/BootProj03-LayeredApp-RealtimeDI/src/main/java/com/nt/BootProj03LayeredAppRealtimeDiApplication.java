package com.nt;

import java.io.Closeable;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj03LayeredAppRealtimeDiApplication {

	public static void main(String[] args) {
		
		//read inputs from the enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee name::");
		String name=sc.next();
		System.out.println("Enter employee desg::");
		String desg=sc.next();
		System.out.println("Enter employee basicSalary::");
		double basicSalary=sc.nextDouble();
		//create the Employee class object
		Employee emp=new Employee();
		emp.setDesg(desg); emp.setEname(name); emp.setSalary(basicSalary);
		
		// get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj03LayeredAppRealtimeDiApplication.class, args);
		//get Controller class object
		PayrollOperationsController controller=ctx.getBean("payrollController",PayrollOperationsController.class);
		//invoke the method
		try {
		   String result=controller.processEmployee(emp);
		   System.out.println(result);
		}//try
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem--- Try again "+e.getMessage());
		}
		//close the container
		 ((ConfigurableApplicationContext) ctx).close();
	}//main

}//class
