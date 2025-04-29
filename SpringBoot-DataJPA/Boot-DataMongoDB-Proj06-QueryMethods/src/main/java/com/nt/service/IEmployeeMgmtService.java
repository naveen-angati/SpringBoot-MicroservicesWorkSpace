package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmployeeMgmtService {
     public   List<Object[]>  fetchEmpsDataByAddrs(String addrs);
     public List<Employee>  fetchEmpsfullDataByAddrs(String addrs);
     public  List<Object[]> fetchEmpsDataBySalaryAndAddrs(double salary, String addrs);
     public  List<Object[]> fetchEmpsDataBySalaryRange(double start, double end);
     public   List<Employee> fetchEmpsFullDataByAddresses(String addrs1,String addrs2);
     public   List<Employee> fetchEmpsFullDataByInitChars(String initialChars);
     
     public  int   fetchEmpsCountBySalaryRange(double start, double end);
     
     public  List<Employee>  fetchEmployeesByEnameSorted();
     
     public  int removeNullEnoEmployees();
     
     public boolean checkEmployeesAvailabilityBySalaryRange(double start, double end);
}
