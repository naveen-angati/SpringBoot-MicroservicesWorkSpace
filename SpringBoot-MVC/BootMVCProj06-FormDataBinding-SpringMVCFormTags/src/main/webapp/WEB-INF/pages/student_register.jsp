
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>



<h1 style="color:red;text-align:center"> Student registration page</h1>

<frm:form    modelAttribute="st">
  <table border="0"  align="center" bgcolor="cyan">
    <tr>
      <td>Student Id::  </td>
      <td><frm:input path="sno"/> </td>
    </tr>
    <tr>
      <td>Student name::  </td>
      <td><frm:input path="sname"/> </td>
    </tr>
      <tr>
      <td>Student address::  </td>
      <td><frm:input path="address"/> </td>
    </tr>
       <tr>
      <td>Student avg::  </td>
      <td><frm:input path="avg"/> </td>
    </tr>
    
      <tr>
      <td colspan="2"><input type="submit" value="register"></td>
    </tr>
  </table>
  
</frm:form>