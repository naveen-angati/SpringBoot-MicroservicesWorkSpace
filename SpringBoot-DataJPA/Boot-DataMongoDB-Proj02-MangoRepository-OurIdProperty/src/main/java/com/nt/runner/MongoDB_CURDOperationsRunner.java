package com.nt.runner;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Employee;
import com.nt.service.IEmployeeMgmtService;

@Component
public class MongoDB_CURDOperationsRunner implements CommandLineRunner {
	@Autowired
	private IEmployeeMgmtService  empService;

	@Override
	public void run(String... args) throws Exception {
		
		/*	try {
			    Employee emp=new  Employee();
			    emp.setEno(new Random().nextInt(1000000));
			    emp.setEname("rajesh"); emp.setSalary(90000.0f); emp.setEadd("hyd");emp.setVaccinated(true);
			    System.out.println(empService.saveDocument(emp));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("_______________________");
			try {
				empService.findAllEmployees().forEach(System.out::println);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("_______________________");
			try {
				System.out.println(empService.findEmployeeById(865933));
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*  empService.fetchEmployeesBySalaryRange(10000.0, 200000.0).forEach(emp->{
		  	System.out.println(emp);
		  });*/
		
		  System.out.println(empService.fetchEmployeeByName("raj"));
		  

	}//

}
