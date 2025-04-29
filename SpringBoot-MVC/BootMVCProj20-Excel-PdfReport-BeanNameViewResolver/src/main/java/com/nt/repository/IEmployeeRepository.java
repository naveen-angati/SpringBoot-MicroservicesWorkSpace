package com.nt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer> {
	
	

}
