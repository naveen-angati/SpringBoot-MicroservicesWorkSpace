package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Customer;

@Controller
public class CustomerOperationsController {
	
	
	@GetMapping("/")
	public  String showHome() {
		 //return LVN
		return "welcome";
	}
	
	@GetMapping("/register")
	public  String   showCustomerFormPage(@ModelAttribute("cust") Customer cust) {
		//return LVN
		return  "customer_form";
	}
	
	@PostMapping("/register")
	public  String    processCustomerFormSubmission(Map<String,Object> map,
			                                                                              @ModelAttribute("cust") Customer cust) {
		 //write the b.logic
			if(cust.getBillAmt()<10000)
			map.put("resultMsg","Customer is Ecomony Customer");
			else
			 map.put("resultMsg","Customer is Luxory Customer");
						
		//return  LVN
			return "show_result";
		
	}

}
