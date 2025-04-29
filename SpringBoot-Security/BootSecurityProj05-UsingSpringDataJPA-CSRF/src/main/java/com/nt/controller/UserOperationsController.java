package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.UsersInfo;
import com.nt.service.IUserInfoMgmtService;

@RequestMapping("/user")
@Controller
public class UserOperationsController {
	@Autowired
	private IUserInfoMgmtService userService;
	
	@GetMapping("/showLogin")
	public  String  showLoginPage() {
		return  "custom_login";
	}
	
	@GetMapping("/register")
	public  String showUserForm(@ModelAttribute("user") UsersInfo user) {  //for launching the form page
		return  "user_register";
	}
	
	
	@PostMapping("/register")
	public  String  registerUser(@ModelAttribute("user") UsersInfo user, Map<String,Object> map) {
		//user service
		 String msg=userService.registerUser(user);
		 map.put("resultMsg", msg);
		 return "user_register_success";
	}
	
	

}
