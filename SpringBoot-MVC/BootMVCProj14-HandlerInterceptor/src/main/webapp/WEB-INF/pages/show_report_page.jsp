<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"/> 

<h1  style="color:red;text-align:center"> Employee Report Page through pagination  </h1>
<c:choose>
  <c:when test="${!empty pageData.getContent()}">
     <table    align="center" class="table  table-hover  table-dark">
       
        <tr class="table-success">  <th>EmpNo  </th> <th>EmpName  </th> <th>Emp Desg  </th> <th> Employee salary </th><th>deptno</th><th>operations </th> </tr>
       
         <c:forEach var="emp" items="${pageData.getContent()}">
           <tr>
              <td>${emp.empno} </td>
               <td>${emp.ename} </td>
               <td>${emp.job} </td>
               <td>${emp.sal} </td>
                <td>${emp.deptno} </td>
               <td><a href="edit?no=${emp.empno}"><img src=" images/edit.png" width="25" height="25"></a>
                       <a href="delete?no=${emp.empno}" onclick="return confirm(' Are U sure delete the employee ')"><img src=" images/delete.jpg" width="25" height="25"></a>
                  </td>
           </tr>
         </c:forEach>
     </table>
     <br><br>
     <center>
       <c:if test="${!pageData.isFirst() }">
           <a href="page_report?page=0">first</a>
       </c:if>
       <c:if test="${pageData.hasPrevious() }">
           <a href="page_report?page=${pageData.getNumber()-1}">previous</a>
       </c:if>
       
       <c:forEach var="i" begin="0" end="${pageData.getTotalPages()-1}" step="1">
        [<a href="page_report?page=${i}">${i+1}</a> ] 
       </c:forEach>
          <c:if test="${pageData.hasNext() }">
           <a href="page_report?page=${pageData.getNumber()+1}">next</a>
       </c:if>
          <c:if test="${!pageData.isLast() }">
           <a href="page_report?page=${pageData.getTotalPages()-1}">last</a>
       </c:if>
      
       </center>
  </c:when>
  <c:otherwise>
      <h1  style="color:red;text-align:center"> Records  not found  </h1>
  </c:otherwise>
 </c:choose>
   <center>
             <h1  style="color:green;text-align:center">${resultMsg}</h1>
   </center>
<center>
<a href="./">home <img src="images/home.jfif" width="70" height="70"></a>  
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="add">Add Employee<img src="images/add.jpg" width="70" height="70"></a>  
</center>
