package com.nt.runner;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.MarriageSeeker;
import com.nt.service.IMarriageSeekerMgmtService;

@Component
public class LOBsTestRunner1 implements CommandLineRunner {
	@Autowired
	private IMarriageSeekerMgmtService  msService;

	@Override
	public void run(String... args) throws Exception {
	
	       
	     
	       try {
	    	  MarriageSeeker ms=msService.findMarriageSeekerById(1);
	    	  if(ms!=null) {
	    		  System.out.println(ms.getMsId()+" "+ms.getMsName()+"  "+ms.getMsAddrs()+" "+ms.getDob()+" "+ms.isIndian());
	    		  // read byte[] from  ms object and write to dest file
	    		  byte[] photoContent=ms.getMsPhoto();
	    		  OutputStream os=new FileOutputStream("photo_retrieved.jfif");
	    		  os.write(photoContent); 
	    		  os.flush();
	    		  os.close();
	    		// read char[] from  ms object and write to dest file
	    		  char[] resumeContent=ms.getMsResume();
	    		  Writer writer=new FileWriter("resume_retrieved.txt");
	    		  writer.write(resumeContent);
	    		  writer.flush();
	    		  writer.close();
	    		  System.out.println("LOBs(files) are retrieved");
	    				 
	    	  }
	    	
	       }
	       catch(Exception e) {
	    	   e.printStackTrace();
	       }

	}

}
