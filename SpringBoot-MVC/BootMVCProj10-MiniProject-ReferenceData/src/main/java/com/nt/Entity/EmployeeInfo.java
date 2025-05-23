//EmployeeInfo.java
package com.nt.Entity;

import java.io.Serializable;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="EMP")
@Data
@Entity
public class EmployeeInfo implements Serializable{
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "EMP_ID_SEQ",allocationSize = 1,initialValue = 251)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private  Integer empno;
	@Column(length = 20)
	private   String ename;
	private  Double   sal;
	@Column(length = 20)
	private  String  job="CLERK";
	private   Integer deptno=10;
}
