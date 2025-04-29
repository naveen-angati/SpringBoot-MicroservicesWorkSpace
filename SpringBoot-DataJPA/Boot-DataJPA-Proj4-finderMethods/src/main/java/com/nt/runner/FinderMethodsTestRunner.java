package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private  IDoctorRepository  doctorRepo;
	

	@Override
	public void run(String... args) throws Exception {
	
		  // calling finder methods
			/*	doctorRepo.findByDocNameEquals("raja").forEach(System.out::println);
				System.out.println("____________________________________");
				doctorRepo.findByDocNameIs("raja").forEach(System.out::println);
				System.out.println("____________________________________");
				doctorRepo.findByDocName("raja").forEach(System.out::println);
			*/
			/*System.out.println("_____________________________________");
			   doctorRepo.findByIncomeBetween(10000.0, 200000.0).forEach(doc->{
				   System.out.println(doc);
			   });*/
			/* System.out.println ("_______________________________________");
			 doctorRepo.findBySpecializationIn(List.of("cardio","physician")).forEach(doc->{
				 System.out.println(doc);
			 });
			*/
			/*System.out.println ("_______________________________________");
			  doctorRepo.findByDocNameLike("r%").forEach(System.out::println);*/
			/*  
				System.out.println ("_______________________________________");
				 doctorRepo.findByDocNameStartsWith("r").forEach(System.out::println);
				 
					System.out.println ("_______________________________________");
					 doctorRepo.findByDocNameEndsWith("h").forEach(System.out::println);
					 
					 System.out.println ("_______________________________________");
					 doctorRepo.findByDocNameContains("ja").forEach(System.out::println);*/
		
		          Iterable<Doctor> it=doctorRepo.findByIncomeGreaterThanEqualAndIncomeLessThanEqual(50000.0, 200000.0);
		          it.forEach(System.out::println);
		          
		          System.out.println("------------------------------");
		          doctorRepo.findBySpecializationInOrIncomeBetween(List.of("cardio","physician"), 3000.0, 7000.0).forEach(System.out::println);
		          
		          
			 		  
		
	      
	}

}
