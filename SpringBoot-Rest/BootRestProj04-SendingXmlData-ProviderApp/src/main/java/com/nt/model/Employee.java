package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private  Integer eno;
	private  String  ename;
	private   Double salary;
	private   String desg;
	// 2D array
	private   Company company; //HAS -A property
	// 1D Array
	private   String[]  nickNames;
	private   List<String> friends;
	private   Set<Long> phoneNumbers;
	//2D array
	private Map<String,Long> idDetails;
	

}
