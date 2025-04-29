package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentOperationsController {
	
	@GetMapping("/")
	public   String showHome() {
		//return  LVN
		return  "welcome";
		
	}
	
	@GetMapping("/register")
	public  String  showFormPage() {   //Handler method to launch the form page
		//return  LVN of the form page
		return "student_register";
	}
	
	@PostMapping("/register")
	public  String  processStudent(@ModelAttribute("stud") Student st,Map<String,Object> map) {
		System.out.println("Student class obj data ::"+st);
		// write  b.logic using Model class obj data
		String result=null;
		 if(st.getAvg()<35.0f)
			 result="fail";
		 else if(st.getAvg()<50.0)
			 result="Third class";
		 else if(st.getAvg()<60.0)
			 result="Second class";
		 else if(st.getAvg()<70)
			 result="First class";
		 else 
			 result="First class with Distinction";
		 //keep the results in model class
		 map.put("resultMsg", result);
		 //return  LVN
		 
		 return "show_result";
		 
		
	}

}
