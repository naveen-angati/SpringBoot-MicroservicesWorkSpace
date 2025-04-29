// JobSeekerOperationsController.java
package com.nt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeeker;
import com.nt.service.IJobSeekerInfoMgmtService;

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
		
		
	}
	

}
