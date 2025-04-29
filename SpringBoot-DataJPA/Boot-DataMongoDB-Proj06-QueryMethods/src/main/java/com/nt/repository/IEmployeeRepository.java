package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Employee;

public interface IEmployeeRepository extends MongoRepository<Employee, String> {

	
	@Query(value="{eadd:?0}", fields = "{id:1,eno:1,ename:1}")
	 public  List<Object[]> getEmpsDataByAddrs(String addrs);
	 
	 //@Query(value="{eadd:?0}", fields = "{}")
	 @Query(value="{eadd:?0}")
	 public  List<Employee>  getEmpsFfullDataByAddrs(String addrs);

	 @Query(value="{eadd:?1,salary:?0}",fields = "{ename:1,eadd:1,salary:1 }")
	 public  List<Object[]>   getEmpsDataBySalaryAndAddrs(double salary, String addrs);
	 
	 @Query(value="{salary:{$gte:?0,$lte:?1}}",fields = "{ename:1,eadd:1,salary:1 }")
	 //@Query(value="{salary:{$gte:?0},salary:{$lte:?1}}",fields = "{ename:1,eadd:1,salary:1 }")
	 public  List<Object[]>   getEmpsDataBySalaryRange(double start,double end);
	 
	 @Query(value="{$or:[{eadd:?0},{eadd:?1}]}")
	 public  List<Employee>   getEmpsFullDataByAddresses(String addrs1,String addr2);
	 
	 @Query(value="{ename:{'$regex':?0, '$options':'i'}}")
	// @Query(value="{ename:{'$regex':?0}}")
	 public  List<Employee>   getEmpsFullDataByEnameInitialChars(String initChars);
	 
	 @Query(value="{salary:{$gte:?0,$lte:?1}}",count = true)
	 public  int   getEmployeesCountBySalaryRange(double start , double end);
	 
	 @Query(value="{}",sort = "{ename:-1}")
	 public  List<Employee>   getEmployeesByEnameSorting();
	 
	 @Query(value="{eno:null}",delete=true)
	 public   int   removeEmptyEnoEmployees();
	 
	 @Query(value="{salary:{$gte:?0,$lte:?1}}",exists = true)
	 public    boolean   exitsEmployeesBySalaryRange(double start, double end);
	 
	 
	 
}
