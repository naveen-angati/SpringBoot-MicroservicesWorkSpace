
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>





<h1 style="color:red;text-align:center">Customer registration page</h1>

<frm:form    modelAttribute="cust" >
 
  
  <table border="0"  align="center" bgcolor="cyan">
   <tr>
      <td>Customer number::  </td>
      <td><frm:input path="cno"/> </td>
    </tr>
    <tr>
      <td>Customer name::  </td>
      <td><frm:input path="cname"/> </td>
    </tr>
      <tr>
      <td>Customer BillAmount::  </td>
      <td><frm:input path="billAmount"/> </td>
    </tr>
       <tr>
      <td>Customer DOB  </td>
      <td><frm:input path="dob" type="date"/> </td>
    </tr>
    
     <tr>
      <td>Customer DOJ  </td>
      <td><frm:input path="doj" type="date"/> </td>
    </tr>
  
      <tr>
      <td>Customer DOP(Purchase)  </td>
      <td><frm:input path="dop" type="datetime-local"/> </td>
    </tr>
       <tr>
      <td>Customer TOB(Time of Birth)  </td>
      <td><frm:input path="tob" type="time"/> </td>
    </tr>
    
    
      <tr>
      <td colspan="2"><input type="submit" value="register"></td>
    </tr>
  </table>
   
</frm:form>