package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ISeasonFinder;

@Controller
//@RequestMapping("/season-ops")
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
		 //return  LVN
		 return  "display";
		 
	}
	
	@GetMapping("/report1")
	public   String   showReport1() {
		System.out.println("SeasonOperationsController.showReport1()");
		 //return "report1";
		//return "forward:demo-ops/report1";
		return "redirect:demo-ops/report1";

	}
	

}
