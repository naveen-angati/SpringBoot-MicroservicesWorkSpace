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
		String idVal=empRepo.insert(emp).getId();
		return  "employee is saved with id value :"+idVal;
	}

	@Override
	public Iterable<Employee> findAllEmployees() {
			return empRepo.findAll();
	}

	@Override
	public Employee findEmployeeById(String id) {
		return  empRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
	}

	@Override
	public String modifyEmployeeWithNewSalary(String id, float hikePercentage) {
		  //find  Employee by Id
		Optional<Employee> opt=empRepo.findById(id);
		if(opt.isPresent()) {
			Employee emp=opt.get();
			emp.setSalary(emp.getSalary()+(emp.getSalary()*hikePercentage/100.0f));
			String idVal=empRepo.save(emp).getId();
			return  idVal+" document is updated";
		}
		return id+" document is not found";
	}

	@Override
	public String removeEmployee(String id) {
		  //find  Employee by Id
			Optional<Employee> opt=empRepo.findById(id);
			if(opt.isPresent()) {
				Employee emp=opt.get();
				empRepo.delete(emp);
				return id+" id document is deleted";
			}
			else {
				return (id+"  document is not deleted"); 
			}
	
	}//method 
	
	@Override
	public List<Employee> searchEmployeesByExampleData(Employee emp, boolean asc, String... props) {
		Example< Employee> example= Example.of(emp);
		Sort  sort=Sort.by(asc?Direction.ASC:Direction.DESC, props);
		List<Employee> list=empRepo.findAll(example, sort);
		return list;
	}
	
	@Override
	public String registerEmployee(Employee emp) {
		// String id=UUID.randomUUID().toString();
		 //System.out.println(id);
		  //emp.setId(id);
		 String idVal=empRepo.insert(emp).getId();
		 return "Employee doc is saved with id value ::"+idVal;
	}

}
