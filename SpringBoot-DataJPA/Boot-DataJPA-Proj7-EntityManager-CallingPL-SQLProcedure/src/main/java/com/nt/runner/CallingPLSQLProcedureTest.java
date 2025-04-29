package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorManagementService;

@Component
public class CallingPLSQLProcedureTest implements CommandLineRunner {
	@Autowired
	private IDoctorManagementService  service;

	@Override
	public void run(String... args) throws Exception {
		//invoke the b.method of service
		service.showDoctorsByIncomeRange(10000.0, 2000000.0).forEach(System.out::println);

	}

}
