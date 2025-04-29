package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private  IDoctorMgmtService  service;

	@Override
	public void run(String... args) throws Exception {
	  // service.showDoctorsByIncomeRange(20000.0, 300000.0).forEach(System.out::println);
		//---------------- select -Entity Query -------------------
		/*service.searchDoctorsBySpecialization("physician", "cardio").forEach(System.out::println);
		System.out.println("_________select --- Entity Projection Query_(specific multiple col values)___");
		service.showDoctorsDataByIncome(20000.0, 2000000.0).forEach(row->{
			for(Object obj:row) {
				System.out.print(obj+"     ");
			}
			System.out.println();
		});
		System.out.println("_________select --- Entity Projection Query___(specific multiple col value____");
		service.showDoctorsDataByIncome(20000.0, 2000000.0).forEach(row->{
			System.out.println(Arrays.toString(row));
		});
		
		System.out.println("_________select --- Entity Projection Query___(specific single col value____");
		service.showDoctorosDataByIncomeRange(40000.0, 5000000.0).forEach(System.out::println);*/
		
		/*System.out.println("==================================================");
		Doctor doctor=service.searchDoctorByNameDocName("raja");
		System.out.println("Doctor Info ::"+doctor);
		
		System.out.println("____________________________");
		Object obj=service.searchDoctorDataByName("raja");
		Object data[]=(Object[])obj;
		for(Object o:data) {
			System.out.print(o+"  ");
		}
		System.out.println();
		System.out.println("Result is ::"+Arrays.toString(data));
		System.out.println("____________________________");
		String result=service.searchSpecilizationByName("raja");
		System.out.println("specilization is ::"+result);*/
		
		/*System.out.println("unique doctor names count ::"+service.showDoctorNamesCount());
		System.out.println("___________________________________");
		 Object[] results=(Object[])service.showAggregateData();
		 System.out.println(" records count ::"+results[0]);
		 System.out.println("max income value:: "+results[1]);
		 System.out.println("min income value ::"+results[2]);
		 System.out.println("avg of income  ::"+results[3]);
		 System.out.println("sum of income  ::"+results[4]);*/
		
		
		/*	System.out.println("______non-select operations________");
			 int count=service.appraiseDoctorsIncomeBySpecialization("cardio", 10.0);
			 System.out.println("no.of records that are effected::"+count);
			 
			 System.out.println("delected doctors count::"+service.fireDoctorsByIncomeRange(10000.0, 150000.0));*/
		 
		 System.out.println("________native  SQL Queries__________");
		 //System.out.println(service.insertDoctor("suresh", 800000.0,"cardio"));
		 //System.out.println("system date time ::"+service.showSystemDate());
		   
		 System.out.println(service.createTempDBtable());
		 
		 
		
		
	}

}
