package com.nt.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="DEPT")
@Entity
@Data
public class Department implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deptno;
	private String dname;
	private  String loc;

}
