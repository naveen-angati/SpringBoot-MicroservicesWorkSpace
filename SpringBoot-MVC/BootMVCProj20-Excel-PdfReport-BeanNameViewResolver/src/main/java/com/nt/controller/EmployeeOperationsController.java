
package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService empService;
	
	@GetMapping("/")
	public  String showHomePage() {
		return "welcome";
	}
	
	
	
	
	
	@GetMapping("/report")
	public  String   getEmployeeReport(Map<String,Object> map , @RequestParam("type") String type) {
		//use  service
		Iterable<Employee> itEmps=empService.getAllEmployees();
		//keep the results in Model attribubtes
		map.put("empsData", itEmps);
		 //return   java class/spring bean id  that is takean as  view  class  as the LVN   
		if(type.equalsIgnoreCase("excel"))
			return "excel_view";
		else
			return "pdf_view";
		
		
		
	}

}
