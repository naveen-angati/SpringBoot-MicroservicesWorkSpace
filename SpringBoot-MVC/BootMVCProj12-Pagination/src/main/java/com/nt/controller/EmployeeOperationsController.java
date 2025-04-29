//EmployeeOperationsController.java
package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.Entity.EmployeeInfo;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validator.EmployeeInfoValidator;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService  empService;
	@Autowired
	private  EmployeeInfoValidator  empValidator;
	
	
	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	
	@GetMapping("/report")
	public  String   showReportData(Map<String,Object> map) {
		//use service
		List<EmployeeInfo> list=empService.getAllEmployees();
		//add results in Model attributes
		map.put("resultList", list);
		//return LVN
		return "show_report";
		
	}
	
	@GetMapping("/add")
	public  String  ShowAddEmployeeFormPage(@ModelAttribute("emp") EmployeeInfo emp) {
		//return  LVN
		return "employee_register";
	}
	
	/*	@PostMapping("/add")
		public   String    registerEmployee(@ModelAttribute("emp") EmployeeInfo  emp,
				                                                       Map<String,Object>  map) {
			//use  Service
			String result=empService.addEmployee(emp);
			List<EmployeeInfo> list=empService.getAllEmployees();
			//  add the result to Model attribute
			map.put("resultMsg", result);
			map.put("resultList", list);
			// return LVN
			return  "show_report";
			
		}*/
	
	/*@PostMapping("/add")
	public   String    registerEmployee(@ModelAttribute("emp") EmployeeInfo  emp,
			                                                       Map<String,Object>  map) {
		//use  Service
		String result=empService.addEmployee(emp);
		//  add the result to Model attribute
		map.put("resultMsg", result);
		// return LVN
		return  "redirect:report";
		
	}*/
	
	/*@PostMapping("/add")
	public   String    registerEmployee(@ModelAttribute("emp") EmployeeInfo  emp,
			                                                      RedirectAttributes  rAttrs) {
		//use  Service
		String result=empService.addEmployee(emp);
		//  add the result to Model attribute
		 rAttrs.addFlashAttribute("resultMsg", result);
		// return LVN
		return  "redirect:report";
		
	}*/
	
	@PostMapping("/add")
	public   String    registerEmployee(@ModelAttribute("emp") EmployeeInfo  emp,
			                                                     RedirectAttributes attrs,BindingResult errors) {
	if(emp.getVflag().equalsIgnoreCase("no")) {	
		 if(empValidator.supports(EmployeeInfo.class)) {
			   empValidator.validate(emp, errors);
			   
			   //Application logic errors
			   if(empService.isDesgRejected(emp.getJob()))
				   errors.rejectValue("job", "emp.desg.rejected");
			   
			   if(errors.hasErrors())
				   return "employee_register";   //display same form page if validation are there
		 }
	}
			 
		//use  Service
		String result=empService.addEmployee(emp);
		//  add the result to Model attribute
		 attrs.addFlashAttribute("resultMsg", result);
		// return LVN
		return  "redirect:report";
		
	}
	
	@GetMapping("/edit")
	public  String  showEditPage(@RequestParam("no") int eno,@ModelAttribute("emp") EmployeeInfo info) 
	{
		//use service
		  EmployeeInfo info1=empService.findEmployeeByEno(eno);
		  //copy data
		   BeanUtils.copyProperties(info1, info);
		  //return  edit employee form page lauch
		  return "employee_edit";
	}
	
	@PostMapping("/edit")
	public   String   processEditFormSubmission(@ModelAttribute("emp") EmployeeInfo info,
			                                                                    RedirectAttributes attrs,BindingResult errors) {
	if(info.getVflag().equalsIgnoreCase("no")) {	
		 if(empValidator.supports(EmployeeInfo.class)) {
			   empValidator.validate(info, errors);
			   
			   //Application logic errors
			   if(empService.isDesgRejected(info.getJob()))
				   errors.rejectValue("job", "emp.desg.rejected");
			   
			   if(errors.hasErrors())
				   return "employee_edit";   //display same form page if validation are there
		 }
	}//if
		 
		 //use service
		 String resultMsg=empService.updateEmployee(info);
		 //keep results in model attributes
		 attrs.addFlashAttribute("resultMsg", resultMsg);
		 //return LVN
		 return "redirect:report";
	}
	
	@GetMapping("/delete")
	public  String   deleteEmployee(@RequestParam("no") int eno,
		                                                          	RedirectAttributes attrs  ) {
		//use service
		String resultMsg=empService.deleteEmployee(eno);
		 //keep results in model attributes
		 attrs.addFlashAttribute("resultMsg", resultMsg);
		 //return LVN
		 return "redirect:report";
	}
	
	@ModelAttribute("deptNoInfo")
	public  List<Integer>  populateDepts(){
		System.out.println("EmployeeOperationsController.populateDepts()");
		//use sevice
		return  empService.showAllDepts();
	}
	
	@GetMapping("/page_report")
	public  String   showReportDataForPagination(Map<String,Object> map,
			                                                                       @PageableDefault(page = 0,size =5,sort = "job", direction = Direction.ASC )   Pageable pageable) {
		//use service
		Page<EmployeeInfo> page=empService.findEmployeesForReport(pageable);
		//keep the results in request scope
		map.put("pageData", page);
		//retrun lvn;
		return  "show_report_page";
		
	}

}
