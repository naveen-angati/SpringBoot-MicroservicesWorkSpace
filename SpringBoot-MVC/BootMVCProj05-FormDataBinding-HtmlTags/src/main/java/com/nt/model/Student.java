//Student.java
package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private Integer sno;
	private String sname;
	private String address="hyd";
	private  Float avg;
	
	public Student() {
		System.out.println("Student:: 0-param constructor");
	}

}
