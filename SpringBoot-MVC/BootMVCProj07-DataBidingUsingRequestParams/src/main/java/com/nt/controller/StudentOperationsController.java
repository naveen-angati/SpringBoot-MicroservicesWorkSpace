//StudentOperationsController.java
package com.nt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentOperationsController {
	
	
	
	/*@GetMapping("/data")
	public  String  processStudent(@RequestParam("sno") int no,@RequestParam("sname") String name) {
		System.out.println("StudentOperationsController.processStudent() sno="+no+"<---->"+" sname="+name);
		 
		//return LVN
		return "show_data";
	}*/
	
	/*@GetMapping("/data")
	public  String  processStudent(@RequestParam int sno,@RequestParam String sname) {
		System.out.println("StudentOperationsController.processStudent() sno="+sno+"<---->"+" sname="+sname);
		 
		//return LVN
		return "show_data";
	}*/
	
	/*@GetMapping("/data")
	public  String  processStudent(@RequestParam int sno,@RequestParam(required = false) String sname) {
		System.out.println("StudentOperationsController.processStudent() sno="+sno+"<---->"+" sname="+sname);
		 
		//return LVN
		return "show_data";
	}*/
	
	/*@GetMapping("/data")
	public  String  processStudent(@RequestParam int sno,@RequestParam(defaultValue = "RRR") String sname) {
		System.out.println("StudentOperationsController.processStudent() sno="+sno+"<---->"+" sname="+sname);
		 
		//return LVN
		return "show_data";
	}*/
	
	/*@GetMapping("/data")
	public  String  processStudent(@RequestParam(defaultValue = "2001") int sno,@RequestParam String sname) {
		System.out.println("StudentOperationsController.processStudent() sno="+sno+"<---->"+" sname="+sname);
		 
		//return LVN
		return "show_data";
	}*/
	
	/*	@GetMapping("/data")
		public  String  processStudent(@RequestParam(required = false) Integer sno,@RequestParam String sname) {
			System.out.println("StudentOperationsController.processStudent() sno="+sno+"<---->"+" sname="+sname);
			 
			//return LVN
			return "show_data";
		}*/
	
	/*@GetMapping("/data")
	public  String  processStudent(@RequestParam Integer sno,@RequestParam String sname,
			                                                 @RequestParam("sadd") String []address1,
			                                                 @RequestParam("sadd") List<String> address2,
			                                                 @RequestParam("sadd") Set<String> address3
				                                              ) {
		System.out.println("StudentOperationsController.processStudent() sno="+sno+"<---->"+" sname="+sname);
		System.out.println(Arrays.toString(address1)+"  "+address2.toString()+"  "+address3.toString());
		 
		//return LVN
		return "show_data";
	}*/
	
	@GetMapping("/data")
	public  String  processStudent(@RequestParam Integer sno,@RequestParam String sname,
			                                                 @RequestParam("sadd") String address) {		                                              
		System.out.println("StudentOperationsController.processStudent() sno="+sno+"<---->"+" sname="+sname+" sadd="+address);
		
		 
		//return LVN
		return "show_data";
	}

}
