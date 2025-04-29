package com.nt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.Employee;
import com.nt.service.ISeasonFinder;

@Controller
public class SeasonOperationsController {
	@Autowired
	private  ISeasonFinder  finder;
	
	@RequestMapping("/")
	//@RequestMapping
	public   String  showHomePage() {
		System.out.println("SeasonOperationsController.showHomePage()");
		return "welcome";
	}
	
	@RequestMapping("/season")
	public   String    showSeasonName(Map<String,Object> map) {
		//use service
		 String  msg=finder.findSeason();
		 // keep results in model attribute
		 map.put("seasonName", msg);
		 map.put("name","raja");
		 map.put("age", 30);
		 // for collections and arrays
		 map.put("nickNames", new String[] {"raj","chinna","munna"});
		 map.put("friends", List.of("srinivas","rajesh","suresh","mahesh"));
		 map.put("phoneNumbers",Set.of(9999999L,645646464L,6646456464L));
		 map.put("idDetails",Map.of("aadhar",5453453,"voterId",5454535,"panNo",45345435));
		 //for Model class obj as the Model attribute
		 Employee emp=new Employee();
		 emp.setEmpno(1010); emp.setEname("rajesh"); emp.setJob("CLERK"); emp.setSalary(89000.0);
		 map.put("empData",emp);
		 // for collection of Model class objs
		  Employee emp1=new Employee(1001, "rajesh", "CLERK", 90000.0);
		  Employee emp2=new Employee(1002, "suresh", "MANAGER", 80000.0);
		  Employee emp3=new Employee(1003, "ramana", "CLERK", 90000.0);
		  List<Employee>  listEmps=List.of(emp1,emp2,emp3);
		  //map.put("listEmps", listEmps);
		  
		  
		 
		 
		 
		 //return  LVN
		 return  "display";
		 
	}
	

}
