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
public class JpaRepoTestRunner implements CommandLineRunner {
	@Autowired
	private  IDoctorMgmtService  service;

	@Override
	public void run(String... args) throws Exception {
	
		  
	     // System.out.println(service.deleteDoctorsByIdsInBatch(List.of(678,901)));
	      
		//System.out.println(service.deleteDoctorsByIdsInBatch(Arrays.asList(16,null)));
		
		
		/*Doctor  doctor=new Doctor();
		doctor.setSpecialization("cardio"); doctor.setIncome(90000.0);
		service.showDoctorsByExampleData(doctor, true, "income").forEach(System.out::println);*/
		
		System.out.println(service.findDoctorById(5674));
	      
	}

}
