package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmployeeMgmtService {
       public  String   saveDocument(Employee emp);
       public   Iterable<Employee>  findAllEmployees();
       public    Employee   findEmployeeById(Integer  id);
       
       public  List<Employee> fetchEmployeesBySalaryRange(double start, double end);
       public   Employee  fetchEmployeeByName(String name);
       
}
