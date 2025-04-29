//ClientApp
package com.nt;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorService;

@SpringBootApplication
public class BootDataJpaProj1CrudRepositoryApplication {

	public static void main(String[] args) {
		 //get IOC container
		
		ApplicationContext ctx=SpringApplication.run(BootDataJpaProj1CrudRepositoryApplication.class, args);
		 //get Service class obj
		IDoctorService service=ctx.getBean("doctorService",IDoctorService.class);
		
		/*try {
			 // create Doctor class object
			 Doctor doctor=new Doctor();
			 doctor.setDocName("rajesh1"); doctor.setSpecialization("MD-Cardio"); doctor.setIncome(890000.0);
			//invoke the b.method
			String resultMsg=service.registerDoctor(doctor);
			System.out.println(resultMsg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		/*	
			try {
				Doctor doc1=new Doctor();
				 doc1.setDocName("mahesh"); doc1.setIncome(90000.0); doc1.setSpecialization("Cardio");
					Doctor doc2=new Doctor();
					 doc2.setDocName("raja"); doc2.setIncome(90000.0); doc2.setSpecialization("physician");
					 Doctor doc3=new Doctor();
					 doc3.setDocName("naresh"); doc3.setIncome(90000.0); doc3.setSpecialization("ortho");
					
					 //String msg=service.registerGroupOfDoctors(List.of(doc1,doc2,doc3));
					  String msg=service.registerGroupOfDoctors(Arrays.asList(doc1,doc2,doc3));
					 
					 System.out.println(msg);
				 
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*	try {
			    System.out.println("count of records ::"+service.fetchDoctorsCount());
			}
			catch(Exception  e) {
				e.printStackTrace();
			}*/
		
		/*  try {
		   System.out.println("201 Id doctor exists ?::"+service.checkDoctorAvailbility(201));
		  }
		  catch(Exception  e) {
			e.printStackTrace();
		}*/
		
		/*try {
			Iterable<Doctor>  it=service.showAllDoctors();
			it.forEach(doc->{
				System.out.println(doc);
			});
			System.out.println("_____________");
			it.forEach(doc->System.out.println(doc));
			System.out.println("_________");
			it.forEach(System.out::println);
			System.out.println("____________");
			for(Doctor doc:it) {
				System.out.println(doc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*	try {
				service.showAllDoctorsByIds(List.of(1,2,100,200,101)).forEach(System.out::println);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
			
		/*	try {
				Doctor doctor=service.showDoctorById(11);
				System.out.println(doctor);
			}
			catch(Exception e) {
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}*/
		
		/*try {
			System.out.println("101 doctor info::"+service.showDoctorById(101));
			System.out.println(service.updateDoctorIncomeById(101, 20.0f));
			System.out.println("101 doctor info::"+service.showDoctorById(101));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			 Doctor doc=new Doctor();
			 doc.setDocId(1020); doc.setDocName("karan"); doc.setIncome(9000.0); //doc.setSpecialization("Cardio");
			 System.out.println(service.registerOrUpdateDoctor(doc));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		/*	
			try {
				System.out.println(service.deleteDoctorById(111));
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*	
			try {
				 Doctor doc=new Doctor();
				 doc.setDocId(12); doc.setDocName("karan");
				System.out.println(service.deleteDoctor(doc));
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*	try {
				System.out.println(service.removeAllDoctors());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			*/
		
		try {
			System.out.println(service.removeDoctorsByIds(List.of(14,15)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close the IOC container
		 ((ConfigurableApplicationContext) ctx).close();
	}

}
