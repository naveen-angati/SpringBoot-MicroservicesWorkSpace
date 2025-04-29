//ShowHomeController.java
package com.nt.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ShowHomeController {

	// @RequestMapping("/home")
	@RequestMapping("/")
	public String showHomePage() {

		// return LVN
		return "welcome";
	}

	/*	@RequestMapping("/process")
		public  String  processRequest(Map<String,Object> map) {
			System.out.println("ShowHomeController.processRequest()::"+map.getClass());
			  //add model attrbutes
			  map.put("attr1", "val1");
			  map.put("sysDate", new Date());
			// return LVN
			return  "show_results";
		}*/

	/*	@RequestMapping("/process")
		public  String  processRequest(Model model) {
			System.out.println("ShowHomeController.processRequest()::"+model.getClass());
			  //add model attrbutes
		         model.addAttribute("attr1","val1");
		         model.addAttribute("sysDate", LocalDateTime.now());
			// return LVN
			return  "show_results";
		}*/

	/*@RequestMapping("/process")
	public  String  processRequest(ModelMap map) {
		System.out.println("ShowHomeController.processRequest()::"+map.getClass());
		  //add model attrbutes
	         map.addAttribute("attr1","val1");
	         map.addAttribute("sysDate", LocalDateTime.now());
		// return LVN
		return  "show_results";
	}*/

	/*@RequestMapping("/process")
	public  Model  processRequest() {
		System.out.println("ShowHomeController.processRequest()");
		  Model model=new BindingAwareModelMap();
		  model.addAttribute("attr1","val1");
		  model.addAttribute("sysDate", LocalDateTime.now());
		//return Model object
		   return model;
	}
	*/
	/*	@RequestMapping("/process")
		public  Map<String,Object>  processRequest() {
			System.out.println("ShowHomeController.processRequest()");
			Map<String,Object> map=new HashMap();
			map.put("attr1","val1");
			map.put("sysDate",LocalDate.now());
			
			return map;
			
		}*/

	/*	@RequestMapping("/process")
		public  ModelAndView  processRequest() {
			System.out.println("ShowHomeController.processRequest()");
			 ModelAndView mav=new ModelAndView();
			 mav.addObject("attr1", "val1");
			 mav.addObject("sysDate",LocalDateTime.now());
			 mav.setViewName("show_results");
			return mav;
			
		}*/

	  @Autowired
	  private  ServletConfig  cg;
	  @Autowired
	  private  ServletContext sc;
	
		/*@RequestMapping("/process")
		public  String  processRequest(HttpSession ses) {
			System.out.println("ShowHomeController.processRequest()");
			System.out.println("DS logics name ::"+cg.getServletName());
			System.out.println("Web application name::"+sc.getContextPath());
			 ses.setAttribute("attr1", "val1");
			 ses.setAttribute("sysDate", LocalDateTime.now());
			 return "show_results";
			
		}*/

	/*@RequestMapping("/process")
	public  String  processRequest(HttpServletRequest req) {
		System.out.println("ShowHomeController.processRequest()");
		 map.put("attr1", "val1");
		 map.put("sysDate",LocalDateTime.now());
		 req.setAttribute("msg1", "hello");
		//return "redirect:report";
		   return  "forward:report";
	}
	
	@RequestMapping("/report")
	public  String  processReport(HttpServletRequest  req) {
		System.out.println("ShowHomeController.processReport()");
		System.out.println("req attribute value ::"+req.getAttribute("msg1"));
		return "result";
	}
	*/
	  
	  @RequestMapping("/process")
		public  void  processRequest(HttpServletResponse  res)throws Exception {
		    //get PrintWriter
		   PrintWriter pw=res.getWriter();
		   //set respinse content type
		   res.setContentType("text/html");
		   
		   pw.println("<h1> hello , how are u  </h1>");
		   
		   
	    }

}
