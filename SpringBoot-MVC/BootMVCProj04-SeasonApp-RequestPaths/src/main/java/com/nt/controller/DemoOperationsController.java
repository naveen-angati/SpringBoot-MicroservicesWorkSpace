package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo-ops")
public class DemoOperationsController {
	
	
	/*@RequestMapping("/")
	public   String  showHome() {
		System.out.println("DemoOperationsController.showHome()");
		return "welcome";
		
	}*/
	
	@GetMapping("/report1")
	public   String  showReport1() {
		System.out.println("DemoOperationsController.showReport1()--GET");
		return  "report1";
	}
	
	@PostMapping("/report")
	public   String  showReport2() {
		System.out.println("DemoOperationsController.showReport2()--POST");
		return  "report2";
	}

}
