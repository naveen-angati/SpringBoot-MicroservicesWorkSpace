
package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class Person {
	@Id
	private Integer pid;
	private String pname;
	private  String paddrs;
	private  DrivingLicense licenseDetails;
	
	
	//toString()
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	

}
