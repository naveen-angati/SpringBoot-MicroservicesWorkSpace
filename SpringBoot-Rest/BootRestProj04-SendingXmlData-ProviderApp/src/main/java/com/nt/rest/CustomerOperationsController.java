package com.nt.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;
import com.nt.model.Employee;

@RestController
@RequestMapping("/customerapi")
public class CustomerOperationsController {
	
	/*@GetMapping("/cust_report")
	public   ResponseEntity<Customer>  reportCustomerData(){
		Customer cust=new Customer(1001,"raja","hyd",90000.0);
	    return  new  ResponseEntity<Customer>(cust,HttpStatus.OK);
	}*/
	
	@GetMapping("/cust_report")
	public  Customer  reportCustomerData(){
		Customer cust=new Customer(1001,"raja","hyd",90000.0);
	    return  cust;
	}
	
	/*@GetMapping("/emp_report")
	public   ResponseEntity<Employee> reportEmployeeData(){
		Employee emp=new Employee(101, "raja", 90000.0, "MANAGER", 
                new Company(4567,"HCL","hyd",450), 
                new String[] {"king","raj","maharaj"},
                List.of("vasu","naresh","suresh"), 
                Set.of(54646543L,54353534L,54535334L),
                Map.of("aadhar",534535554334L,"pan" ,64564646L));
                     return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}*/
	
	@GetMapping("/emp_report")
	public   Employee reportEmployeeData(){
		Employee emp=new Employee(101, "raja", 90000.0, "MANAGER", 
                new Company(4567,"HCL","hyd",450), 
                new String[] {"king","raj","maharaj"},
                List.of("vasu","naresh","suresh"), 
                Set.of(54646543L,54353534L,54535334L),
                Map.of("aadhar",534535554334L,"pan" ,64564646L));
                     return emp;
	}
	
}
