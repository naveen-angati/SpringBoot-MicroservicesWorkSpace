
function   validate(frm){
	
	// empty  the existing validation error messages
	document.getElementById("enameErr").innerHTML="";
	document.getElementById("jobErr").innerHTML="";
	document.getElementById("salErr").innerHTML="";
	document.getElementById("deptnoErr").innerHTML="";
	
	
	
	
	//read form data 
	let  name=frm.ename.value;
	let  desg=frm.job.value;
	let  salary=frm.sal.value;
	let  dno=frm.deptno.value;
	
	let isValid=true;
	//client side form validation logics
	if(name==""){
		document.getElementById("enameErr").innerHTML=" Employee name is mandatory";
		isValid=false;
	}
	else if(name.length<5 || name.length>15){
		document.getElementById("enameErr").innerHTML=" Employee name must have >=5 and <=15 characters";
		isValid=false;
	}
	
	if(desg==""){
		document.getElementById("jobErr").innerHTML=" Employee desg is mandatory";
		isValid=false;
	}
	else if(desg.length<5 || desg.length>10){
		document.getElementById("jobErr").innerHTML=" Employee desg must have >=5 and <=10 characters";
		isValid=false;
	}
	
	if(salary==""){
		document.getElementById("salErr").innerHTML=" Employee salary is mandatory";
		isValid=false;
	}
	else if(isNaN(salary)){
	  document.getElementById("salErr").innerHTML=" Employee salary must be numeric value";
		isValid=false;	
	}
	else if(salary<10000 || salary>200000){
		document.getElementById("salErr").innerHTML=" Employee must be there is the range of 10,000 to 2,00,000";
		isValid=false;
	}
	
	if(dno==""){
		document.getElementById("dnoErr").innerHTML=" Employee deptno is required";
		isValid=false;
	}
	// changing the vflag value to "yes" indicating that the client side form validations are done
	frm.vflag.value="yes";
	alert(" Client side form validations");
	
	return  isValid;
}