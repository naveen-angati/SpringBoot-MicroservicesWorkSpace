// JobSeekerOperationsController.java
package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeeker;
import com.nt.service.IJobSeekerInfoMgmtService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class JobSeekerOperationsController {
	@Autowired
	private  IJobSeekerInfoMgmtService jsService;
	
	
	@GetMapping("/")
	public  String showHomePage() {
		//return LVN
		return "welcome";
	}
	
	
	@GetMapping("/js_register")
	public  String   showJobSeekerRegistrationFormPage(@ModelAttribute("js") JobSeeker seeker) {
		//return  LVN (form page)
		return "js_register_form";
	}
	
	
	@Autowired
	private Environment env;
	
	@PostMapping("/js_register")
	public  String    registerJobSeeker(@ModelAttribute("js") JobSeeker seeker,
			                                                     Map<String,Object> map) {
		//  get location to save the uploaded in Server Machine Filesystem
		String  location=env.getRequiredProperty("upload.store");
		// check the folder  avaiablilty , if not there create it
		File file=new File(location);
		if(!file.exists())
			  file.mkdir();
		
		//get  the names of the uploaded files
		String resumeFileName=seeker.getResume().getOriginalFilename();
		String photoFileName=seeker.getPhoto().getOriginalFilename();
		
		
		
		
		// get InputStream  representing the  upload files
		try(InputStream resumeIS=seeker.getResume().getInputStream();
				InputStream photoIS=seeker.getPhoto().getInputStream();	
				//create OutputStream  pointing to dest files 
				OutputStream resumeOS=new FileOutputStream(location+"\\"+resumeFileName);
				OutputStream photoOS=new FileOutputStream(location+"\\"+photoFileName);
				){
			
			//perform  Copy Stream operation to complete the file uploading
			IOUtils.copy(photoIS, photoOS);
			IOUtils.copy(resumeIS, resumeOS);
			
			//convert  Model class obj data to  Entity object  data  
			JobSeekerInfo jsInfo=new JobSeekerInfo();
			jsInfo.setJsName(seeker.getJsName());
			jsInfo.setJsAddrs(seeker.getJsAddrs());
			jsInfo.setResumePath(location+"\\"+resumeFileName);
			jsInfo.setPhotoPath(location+"\\"+photoFileName);
			
			//use Service class
			String resultMsg=jsService.registerJobSeeker(jsInfo);
			//add reuslts  to model attributes
			map.put("resultMsg",resultMsg);
			map.put("resumeFileName", resumeFileName);
			map.put("photoFileName", photoFileName);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//return  LVN
		return "show_result";
		
		
	}//method
	
	
	@GetMapping("/js_report")
	public  String   show_Report(Map<String,Object> map) {
		//use service
		List<JobSeekerInfo> list=jsService.getAllJobSeekersInfo();
		//add the result model attributes
		map.put("jsInfo", list);
		
		//return LVN
		return "show_report";
		
	}
	
	@Autowired
	private  ServletContext sc;
	
	@GetMapping("/download")
	public  String  downloadFile(@RequestParam("id") Integer id,
			                                          @RequestParam("type") String type,
			                                          HttpServletResponse res) {
		  String fileLocation=null;
		  if(type.equalsIgnoreCase("resume"))
			     fileLocation=jsService.findResumePathById(id);
		  else
			     fileLocation=jsService.findPhotoPathById(id);
		  
		  //  crate the File object representing the file to be download
		     File file=new File(fileLocation);
		  
		  //get the File Content lenth and make  it  as response content length
		     long length=file.length();
		     res.setContentLengthLong(length);
		     
		     // get file MIME type and make it as the  response content type
		     String mimeType=sc.getMimeType(fileLocation);
		     mimeType=mimeType==null?"application/octet-stream":mimeType;
		     res.setContentType(mimeType);
		      //create InputStream pointing to the file
		      //create OutputStream pointing to response obj
		     
		     try(InputStream is=new FileInputStream(file);
		    		OutputStream os=res.getOutputStream(); ){
		    	  //gives special instruction to browser  to make the recieved output as the downloadable file
		    	  res.setHeader("Content-Disposition","attachment;fileName="+file.getName());
		    	 //  copy the content of the file to  response objs
		    	   IOUtils.copy(is, os);
		        }//try
		      catch(Exception e) {
		    	  e.printStackTrace();
		      }
		return null;  // To make the response going to browser directly from here (No DS,ViewResolver and view comps)
	}//method
	

}//class
