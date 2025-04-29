//Employee.java
package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
   private  Integer empno;
   private  String  ename;
   private   String  job;
   private   Double salary;
}
