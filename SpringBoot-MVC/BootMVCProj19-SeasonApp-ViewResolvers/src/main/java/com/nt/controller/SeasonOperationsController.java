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
			  
		 
		 
		 
		 //return  LVN
		 return  "display";
		 
	}
	

}
