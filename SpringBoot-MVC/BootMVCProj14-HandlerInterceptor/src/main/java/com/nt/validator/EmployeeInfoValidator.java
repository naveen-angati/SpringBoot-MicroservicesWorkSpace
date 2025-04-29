package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.Entity.EmployeeInfo;

@Component
public class EmployeeInfoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {  //  This method checks wheather the  current
		                                                                    // validator class is getting correct  Model class obj or not
		                                                                    // if not getting  this  method returns false and validate(-) does not excute
		
		return clazz.isAssignableFrom(EmployeeInfo.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeInfoValidator.validate()");
		//typecasting
		EmployeeInfo emp=(EmployeeInfo)target;
		//server side form validation logic
		if(emp.getEname()==null || emp.getEname().length()==0 || emp.getEname().equals("")) //required rule 
			errors.rejectValue("ename", "emp.name.required");
		else if(emp.getEname().length()<5 || emp.getEname().length()>15)  //minlength rule
			errors.rejectValue("ename", "emp.name.length");
		
		if(emp.getJob()==null || emp.getJob().length()==0 || emp.getJob().equals(""))  //required rule
			errors.rejectValue("job", "emp.job.required");
		else if(emp.getJob().length()<5  || emp.getJob().length()>10)  //minlenth rule
			errors.rejectValue("job", "emp.job.length");
		
	if(!errors.hasFieldErrors("sal")) {
		if(emp.getSal()==null)  //required rule
			errors.rejectValue("sal", "emp.salary.required");
		else if(emp.getSal()<10000 || emp.getSal()>200000) //range rule
			errors.rejectValue("sal", "emp.salary.range");
	}
		
		if(emp.getDeptno()==null)  //required rule
			errors.rejectValue("deptno", "emp.deptno.required");
		
		
		
		

	}

}
