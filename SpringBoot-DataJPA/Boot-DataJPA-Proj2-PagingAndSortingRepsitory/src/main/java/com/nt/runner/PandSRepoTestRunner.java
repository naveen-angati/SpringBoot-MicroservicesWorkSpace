package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class PandSRepoTestRunner implements CommandLineRunner {
	@Autowired
	private  IDoctorMgmtService  service;

	@Override
	public void run(String... args) throws Exception {
		/*  service.showDoctorsBySorting(true, "docName").forEach(System.out::println);
		System.out.println("_________________________________");
		service.showDoctorsBySorting(false, "income","docName").forEach(System.out::println);*/
	    
	    System.out.println("___________________________");
	    //service.showDoctorsInfoByPageNo(1, 3, true, "docName").forEach(System.out::println);
		/* Page<Doctor> page=service.showDoctorsInfoByPageNo(1, 3, false, "docName");
		 page.getContent().forEach(System.out::println);
		 System.out.println("current page number ::"+page.getNumber());
		 System.out.println("total pages count ::"+page.getTotalPages());
		 System.out.println("total records ::"+page.getTotalElements());
		 System.out.println(" is the first page ::"+page.isFirst());*/
	    
	    service.showDataThroughPagination(3);
	      
	      
	      
	}

}
