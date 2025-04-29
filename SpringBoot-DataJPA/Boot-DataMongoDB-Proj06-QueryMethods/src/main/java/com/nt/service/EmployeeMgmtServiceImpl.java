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
	public List<Object[]> fetchEmpsDataByAddrs(String addrs) {
		return empRepo.getEmpsDataByAddrs(addrs);
	}

	@Override
	public List<Employee> fetchEmpsfullDataByAddrs(String addrs) {
	  return  empRepo.getEmpsFfullDataByAddrs(addrs);
	}

	@Override
	public List<Object[]> fetchEmpsDataBySalaryAndAddrs(double salary, String addrs) {
		
		return empRepo.getEmpsDataBySalaryAndAddrs(salary, addrs);
	}

	@Override
	public List<Object[]> fetchEmpsDataBySalaryRange(double start, double end) {
		return empRepo.getEmpsDataBySalaryRange(start, end);
	}

	@Override
	public List<Employee> fetchEmpsFullDataByAddresses(String addrs1, String addrs2) {
		
		return empRepo.getEmpsFullDataByAddresses(addrs1, addrs2);
	}

	@Override
	public List<Employee> fetchEmpsFullDataByInitChars(String initialChars) {
		
		return empRepo.getEmpsFullDataByEnameInitialChars(initialChars);
	}

	@Override
	public int fetchEmpsCountBySalaryRange(double start, double end) {
		
		return empRepo.getEmployeesCountBySalaryRange(start, end);
	}

	@Override
	public List<Employee> fetchEmployeesByEnameSorted() {
		return empRepo.getEmployeesByEnameSorting();
	}

	@Override
	public int removeNullEnoEmployees() {
	  
		return  empRepo.removeEmptyEnoEmployees();
	}

	@Override
	public boolean checkEmployeesAvailabilityBySalaryRange(double start, double end) {
		return empRepo.exitsEmployeesBySalaryRange(start, end);
	}


}
