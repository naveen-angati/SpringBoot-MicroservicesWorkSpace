package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IEmployeeMgmtService;

@Component
public class MongoDB_QueryMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private IEmployeeMgmtService  empService;

	@Override
	public void run(String... args) throws Exception {
	
		/*List<Object[]> list=empService.fetchEmpsDataByAddrs("hyd");
		list.forEach(row->{
			for(Object val:row) {
				System.out.print(val+"  ");
			}
			System.out.println();
		});
		
		System.out.println("_______________________________");
		empService.fetchEmpsfullDataByAddrs("hyd").forEach(System.out::println);
		
		System.out.println("_____________________________________");
		empService.fetchEmpsDataBySalaryAndAddrs(90000.0, "hyd").forEach(row->{
			System.out.println(Arrays.toString(row));
		});
		
		System.out.println("_____________________________________");
		empService.fetchEmpsDataBySalaryRange(50000.0, 80000.0).forEach(row->{
			System.out.println(Arrays.toString(row));
		});
		
		System.out.println("_____________________________________");
		empService.fetchEmpsFullDataByAddresses("hyd", "delhi").forEach(System.out::println);*/
		
		/*	System.out.println("___________containing data_____________________");
			empService.fetchEmpsFullDataByInitChars("r").forEach(System.out::println);	
			System.out.println("___________starting with data_____________________");
			empService.fetchEmpsFullDataByInitChars("^r").forEach(System.out::println);	
			System.out.println("___________ending with data_____________________");
			empService.fetchEmpsFullDataByInitChars("j$").forEach(System.out::println);	*/
		
		/*  int count=empService.fetchEmpsCountBySalaryRange(40000.0, 90000.0);
		  System.out.println(" employees count ::"+count);*/
		
		  //empService.fetchEmployeesByEnameSorted().forEach(System.out::println);
     
		    //System.out.println(" null  eno employees deleted count ::"+empService.removeNullEnoEmployees());
		
		       System.out.println(" 40000 to 80000 employees are avaiable or not?"+empService.checkEmployeesAvailabilityBySalaryRange(20000.0, 90000.0));

	}

}
