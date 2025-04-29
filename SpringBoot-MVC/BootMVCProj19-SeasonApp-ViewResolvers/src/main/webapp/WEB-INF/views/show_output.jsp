<%@ page isELIgnored="false"  import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<h1 style="color:red;text-align:center">Result Page</h1>
<c:if test="${!empty seasonName}">
<h2  style="color:red;text-align:center"> Season name :: ${seasonName}</h2>
</c:if>



<br><br>
<a href="./">home</a>