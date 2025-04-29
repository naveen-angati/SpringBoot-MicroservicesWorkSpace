
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>

<link rel="stylesheet"  type="text/css" href="css/style.css"/>  

<script type="text/javascript" src="js/validation.js">
</script>

<h1 style="color:red;text-align:center"> Employee registration page</h1>

<frm:form    modelAttribute="emp"  onsubmit="return validate(this)">
 <%-- <p style="color:red;text-align: center"> <frm:errors path="*"/> </p> --%>
  
  
  <table border="0"  align="center" bgcolor="cyan">
    <tr>
      <td>Employee name::  </td>
      <td><frm:input path="ename"/><frm:errors path="ename"/> <span id="enameErr"></span> </td>
    </tr>
      <tr>
      <td>Employee JOB::  </td>
      <td><frm:input path="job"/><frm:errors path="job"/><span id="jobErr"></span> </td>
    </tr>
       <tr>
      <td>Employee Salary::  </td>
      <td><frm:input path="sal"/> <frm:errors path="sal"/> <span id="salErr"></span></td>
    </tr>
    
     <tr>
      <td>DeptNo:: </td>
      <td><frm:select path="deptno">
                  <frm:options items="${deptNoInfo}"/>
                 <%-- <frm:option value="10">10</frm:option>
                  <frm:option value="20">20</frm:option> --%>
                  
      </frm:select>  <frm:errors path="deptno"/>  <span id="deptnoErr"></span></td>
    </tr>
    
      <tr>
      <td colspan="2"><input type="submit" value="register"></td>
    </tr>
  </table>
      <frm:hidden  path="vflag"/>
</frm:form>