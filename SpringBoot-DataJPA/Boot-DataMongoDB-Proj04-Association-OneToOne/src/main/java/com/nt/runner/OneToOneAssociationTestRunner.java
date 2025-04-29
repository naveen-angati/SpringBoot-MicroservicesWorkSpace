package com.nt.runner;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;
import com.nt.service.IRTAMgmtService;

@Component
public class OneToOneAssociationTestRunner implements CommandLineRunner {
	@Autowired
	private IRTAMgmtService  rtaService;

	@Override
	public void run(String... args) throws Exception {
		//save object using parent
		try {
			//parent object
			Person per=new Person();
			per.setPid(1001); per.setPname("rajesh"); per.setPaddrs("hyd");
			//child object
			DrivingLicense license=new DrivingLicense();
			license.setLid(new Random().nextLong(100000000000L)); license.setLicenseType("LMV");
			license.setExpiryDate(LocalDate.of(2043, 10, 20));
			//perform association 
			per.setLicenseDetails(license);
			//use service
			System.out.println(rtaService.registerPerson(per));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("========================================");
		try {
			//parent object
			Person per=new Person();
			per.setPid(1002); per.setPname("raj"); per.setPaddrs("delhi");
			//child object
			DrivingLicense license=new DrivingLicense();
			license.setLid(new Random().nextLong(100000000000L)); license.setLicenseType("HMV");
			license.setExpiryDate(LocalDate.of(2045, 10, 20));
			//perform association 
			 license.setPersonDetails(per);
			//use service
			System.out.println(rtaService.registerDrivingLicense(license));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}//method

}//class
