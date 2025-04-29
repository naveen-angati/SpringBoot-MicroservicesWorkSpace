package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepository  empRepo;

	@Override
	public String saveDocument(Employee emp) {
		int idVal=empRepo.insert(emp).getEno();
		return  "employee is saved with id value :"+idVal;
	}

	@Override
	public Iterable<Employee> findAllEmployees() {
			return empRepo.findAll();
	}

	@Override
	public Employee findEmployeeById(Integer  id) {
		return  empRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
	}

	@Override
	public List<Employee> fetchEmployeesBySalaryRange(double start, double end) {
			return empRepo.findBySalaryBetween(start, end);
	}

	@Override
	public Employee fetchEmployeeByName(String name) {
		
		return  empRepo.findByEname(name);
	}

	
}
