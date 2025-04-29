package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{
	@Autowired
	private IEmployeeRepository repo;
	
	public Mono<Employee> saveEmployee(Employee emp) {
		        try {
		        	 Thread.sleep(30000);
		         }
		         catch(Exception e) {
		        	 e.printStackTrace();
		         }
				 return repo.save(emp).switchIfEmpty(Mono.empty());
	}
	
	public Flux<Employee> findAllEmployees() {
	 /*    try {
	        	 Thread.sleep(30000);
	         }
	         catch(Exception e) {
	        	 e.printStackTrace();
	         }*/
		return repo.findAll().switchIfEmpty(Flux.empty());
	}
	
	public Mono<Employee> getOneEmployee(Integer id) {
		return repo.findById(id).switchIfEmpty(Mono.empty());
	}
	
	public Mono<Void> removeEmployee(Integer id) {
		return repo.deleteById(id);
	}
	
}