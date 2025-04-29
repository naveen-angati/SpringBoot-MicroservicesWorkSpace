package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeOperationsController {
	
	@Autowired
	private IEmployeeMgmtService service;
	
	@PostMapping("/save")
	public Mono<Employee> saveOneEmployee(@RequestBody Employee employee) 
	{       System.out.println("save(-) "+Thread.currentThread().hashCode());
			Mono<Employee> mono= service.saveEmployee(employee);
			return mono;
	}
	
	@GetMapping("/all")
	public Flux<Employee> getAllEmps() {
		   System.out.println("all(-) "+Thread.currentThread().hashCode());
				return service.findAllEmployees();
	}
	
	@GetMapping("/one/{id}")
	public Mono<Employee> getOneEmployee(@PathVariable Integer id)
	{
		 System.out.println("one(-) "+Thread.currentThread().hashCode());
		Mono<Employee> mono = service.getOneEmployee(id);
		return  mono;
	}
	
	@DeleteMapping("/remove/{id}")
	public Mono<Void> removeEmployee(	@PathVariable Integer id)
	{
		 System.out.println("remove(-) "+Thread.currentThread().hashCode());
		return service.removeEmployee(id);
		//service.removeEmployee(id);
		//return Mono.just("Employee Deleted!!");
	}
	
}