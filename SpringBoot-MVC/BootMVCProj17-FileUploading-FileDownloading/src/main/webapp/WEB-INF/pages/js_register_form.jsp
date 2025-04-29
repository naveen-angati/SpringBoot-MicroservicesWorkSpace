
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>


<h1 style="color:red;text-align:center">Job Seeker Registration Including File Uploading</h1>

<frm:form    modelAttribute="js"  enctype="multipart/form-data" >
 
  
  <table border="0"  align="center" bgcolor="cyan">

    <tr>
      <td>Job Seeker name::  </td>
      <td><frm:input path="jsName"/> </td>
    </tr>
      <tr>
      <td>JobSeeker Address:: </td>
      <td><frm:input path="jsAddrs"/> </td>
    </tr>
    <tr>
      <td> Job Seeker Resumt (file)  </td>
      <td><frm:input type="file" path="resume" /> </td>
    </tr>
    <tr>
      <td> Job Seeker Photo (file)  </td>
      <td><frm:input type="file" path="photo" /> </td>
    </tr>
      <tr>
      <td colspan="2"><input type="submit" value="register"></td>
    </tr>
  </table>
   
</frm:form>


          
         