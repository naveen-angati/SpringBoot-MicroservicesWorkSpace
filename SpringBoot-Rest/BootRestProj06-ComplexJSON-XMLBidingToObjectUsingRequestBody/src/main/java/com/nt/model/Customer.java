package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class Customer {
	 //simple properties
	private Integer cno;
	private  String cname;
	private  Double  billamt;
	//HAS - A property 
	private Address addrs;
	// collection properties
	private String[]  nickNames;
	private  List<String> friends;
	private  Set<Long> phoneNumbers;
	private  Map<String,Long> idDetails;
	
	

}
