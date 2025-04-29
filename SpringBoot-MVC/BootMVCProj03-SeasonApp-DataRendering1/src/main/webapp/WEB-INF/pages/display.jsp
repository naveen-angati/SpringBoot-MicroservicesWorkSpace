<%@ page isELIgnored="false"  import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<h1 style="color:red;text-align:center">Result Page</h1>
<c:if test="${!empty seasonName}">
<h2  style="color:red;text-align:center"> Season name :: ${seasonName}</h2>
</c:if>


<br><br><br>
<c:if test="${!empty name  and  !empty age}">
 <b>SimpleModel attributes  are ::  ${name},${age} </b>  
</c:if>
 
 <br><br><br>
 <c:if test="${!empty  nickNames and !empty friends and !empty phoneNumbers and !empty idDetails}">
 <b> collection  model attributes are</b> <%=Arrays.toString(((String[])request.getAttribute("nickNames"))) %>
                       <br>,${friends},<br>${phoneNumbers},<br>${idDetails}
   </c:if>
                       
<br><br><br><br><br>
 <c:if test="${!empty  empData}">
    <b> Model class obj as Model attribute value :: ${empData} </b>
</c:if>


<br><br><br>
<c:choose>
   <c:when test="${!empty  listEmps }">
        <table  border="1" bgcolor="cyan" align="center">
          <tr>
             <th>empno</th><th>ename </th><th>job </th><th>salary </th>
          </tr>
         <c:forEach var="e" items="${listEmps}">
           <tr>
             <td>${e.empno}</td>
             <td>${e.ename}</td>
             <td>${e.job}</td>
             <td>${e.salary}</td>
           </tr>
         </c:forEach> 
        </table>
   </c:when>
   <c:otherwise>
             <h1 style='color:red;text-align:center'> Records not found </h1> 
   </c:otherwise>
</c:choose>
                        


<br><br>
<a href="./">home</a>