package com.nt.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.MarriageSeeker;
import com.nt.service.IMarriageSeekerMgmtService;

//@Component
public class LOBsTestRunner implements CommandLineRunner {
	@Autowired
	private IMarriageSeekerMgmtService  msService;

	@Override
	public void run(String... args) throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Marriage seeker name::");
		String name=sc.next();
		
		System.out.println("Marriage seeker address::");
		String addrs=sc.next();
		
		System.out.println("Marriage seeker Indian?::");
		boolean indian=sc.nextBoolean();
		
		System.out.println("Marriage seeker DOB(yyyy-MM-ddThh:mm:ss) ::");
	       String sdob=sc.next();
		
	   	System.out.println("Marriage seeker Photo file path::");
	   	    sc.nextLine();
	       String photoPath=sc.nextLine();
	       
	       System.out.println("Marriage seeker resume file path::");
	       String resumePath=sc.nextLine();
	       
	       //Convert Stirng date value to java.time.LocalDateTime class object
	       LocalDateTime  dob=LocalDateTime.parse(sdob);
	       
	       // create  byte[]  from photo file
	       InputStream is=new FileInputStream(photoPath);
	       byte[] photoContent=new byte[is.available()];
	       photoContent=is.readAllBytes();
 
	      //creat char[] from resume file
	       File file=new File(resumePath);
	       Reader reader=new FileReader(file);
	       char[] resumeContent=new char[(int) file.length()];
	       reader.read(resumeContent);
	       
	       // create MarrriaggeSeeker Object
	       MarriageSeeker  seeker=new MarriageSeeker(name, addrs, indian, dob, photoContent, resumeContent);
	       try {
	    	   String msg=msService.saveMarriageSeeker(seeker);
	    	   System.out.println(msg);
	       }
	       catch(Exception e) {
	    	   e.printStackTrace();
	       }

	}

}
