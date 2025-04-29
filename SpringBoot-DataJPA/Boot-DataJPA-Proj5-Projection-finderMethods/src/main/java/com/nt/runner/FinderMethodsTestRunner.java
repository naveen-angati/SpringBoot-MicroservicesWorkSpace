package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepository;
import com.nt.view.IResultView;
import com.nt.view.IResultView1;
import com.nt.view.IResultView2;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private  IDoctorRepository  doctorRepo;
	

	@Override
	public void run(String... args) throws Exception {
		
	
		 
		/*
		Iterable<IResultView> it= doctorRepo.findBySpecializationIn(List.of("cardio"));
		it.forEach(doc->{
			 //head  "doc"  represents  in InMemory Proxy class implementing  IResultView(I)
			System.out.println(doc.getDocName()+" ...."+doc.getIncome());
		});*/
	
	System.out.println("_________________________");
     Iterable<IResultView1> it1=doctorRepo.findByIncomeBetween(50000.0, 200000.0,IResultView1.class);
       it1.forEach(data->{
    	    System.out.println(data.getDocName()+"...."+data.getSpecialization());
       });
			 		  
       System.out.println("________________________________");
       
       Iterable<IResultView2> it2=doctorRepo.findByIncomeBetween(50000.0, 200000.0,IResultView2.class);
       it2.forEach(data->{
    	    System.out.println(data.getDocName()+"...."+data.getSpecialization()+"...."+data.getIncome());
       });
		
	      
	}

}
