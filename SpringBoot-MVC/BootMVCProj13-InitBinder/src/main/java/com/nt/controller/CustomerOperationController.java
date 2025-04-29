package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Customer;

@Controller
public class CustomerOperationController {
	
	@GetMapping("/")
	public  String showHomePage() {
		System.out.println("CustomerOperationController.showHomePage()");
		//return LVN
		return  "welcome";
	}
	
	@GetMapping("/customer_register")
	public String showCustomFormPage(@ModelAttribute("cust")Customer cust) {
		System.out.println("CustomerOperationController.showCustomFormPage()");
		//return  LVN
		return "customer_form";
	}
	
	@PostMapping("/customer_register")
	public   String processCustomerForm(@ModelAttribute("cust")Customer cust,
			                                                          Map<String,Object> map) {
		System.out.println("CustomerOperationController.processCustomerForm()");
		System.out.println("model obj data::"+cust);
		
		//keep model object as model attribute
		map.put("custData", cust);
		
		//return LVN
		return "show_result";
		
	}
	
	@InitBinder
	public  void  myDataBinder(WebDataBinder binder) {
		System.out.println("CustomerOperationController.myDataBinder()");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf1, true));
		
	}

}
