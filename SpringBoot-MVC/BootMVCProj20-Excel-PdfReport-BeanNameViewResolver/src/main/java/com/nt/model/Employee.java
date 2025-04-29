package com.nt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="EMP")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empno;
	private String ename;
	private String job;
	private  Double sal;
	private  Integer deptno;

}
