package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmployeeMgmtService {
       public  String   saveDocument(Employee emp);
       public   Iterable<Employee>  findAllEmployees();
       public    Employee   findEmployeeById(String  id);
       public    String  modifyEmployeeWithNewSalary(String id, float hikePercentage);
       public    String  removeEmployee(String id);
       public   List<Employee>  searchEmployeesByExampleData(Employee emp, boolean asc,String ...props);
       public   String  registerEmployee(Employee emp);
}
