package com.nt.runner;

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
				Employee emp=new Employee();
				emp.setEno(101); emp.setEname("raja1");emp.setEadd("hyd1"); emp.setSalary(90000.0f);
				Employee emp1=new Employee();
				emp1.setEno(null); emp1.setEname("rajesh1"); emp1.setSalary(80000.0f);
				
				System.out.println(empService.saveDocument(emp));
				System.out.println(empService.saveDocument(emp1));
				
				
			}//try
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		   //empService.findAllEmployees().forEach(System.out::println);
		
			/*	  try {
				  System.out.println(empService.findEmployeeById("6408a1710437b051817c8208"));
				  }
				  catch(Exception e) {
					  e.printStackTrace();
				  }*/
			/*try {
			   System.out.println(empService.modifyEmployeeWithNewSalary("6408a1710437b051817c8208", 20.0f));
			}
			catch(Exception e) {
			   e.printStackTrace();
			}
			*/
		
		
		
			/*	try {
					System.out.println(empService.removeEmployee("6408a1710437b051817c8208"));
				}
				catch(Exception e) {
					e.printStackTrace();
				}*/
		
			/*  Employee  emp=new Employee();
			  emp.setSalary(90000.0f); emp.setEadd("hyd");
			  try {
				  empService.searchEmployeesByExampleData(emp,true, "ename").forEach(System.out::println);
			  }
			  catch(Exception e) {
				  e.printStackTrace();
			  }*/
		
		try {
			
				Employee emp=new Employee();
				emp.setId("54354353AAA");
				emp.setEno(335); emp.setEname("raj");emp.setEadd("delhi"); emp.setSalary(90000.0f);
				System.out.println(empService.registerEmployee(emp));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//

}
