//DrivingLicense.java
package com.nt.document;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class Sport {
	@Id
    private  Integer  sid;
	private  String type;
	private  String[] kitItems;
	
	
	
	//toString()
	@Override
	public String toString() {
		return "Sport [sid=" + sid + ", type=" + type + ", kitItems=" + Arrays.toString(kitItems) + "]";
	}

}
