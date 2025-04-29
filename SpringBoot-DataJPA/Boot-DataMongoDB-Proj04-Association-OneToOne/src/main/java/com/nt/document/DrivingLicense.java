//DrivingLicense.java
package com.nt.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class DrivingLicense {
	@Id
    private  Long  lid;
	private  String licenseType;
	private LocalDate expiryDate;
	private  Person  personDetails;
	
	
	//toString()
	@Override
	public String toString() {
		return "DrivingLicense [lid=" + lid + ", licenseType=" + licenseType + ", expiryDate=" + expiryDate + "]";
	}
}
