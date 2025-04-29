<%@ page isELIgnored="false"  contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>


 <h1 style="color:red;text-align:center"> <spring:message  code="home.title"/> </h1>
 
         <h3 style="text-align:center"><a href="register"><spring:message code="home.link"/></a></h3>
         
         
         <br><br><br>
         <hr>
         <a href="?lang=fr_FR">French</a>  &nbsp;   &nbsp;   &nbsp;  &nbsp;   &nbsp;  &nbsp;
         <a href="?lang=de_DE">German</a>  &nbsp;   &nbsp;   &nbsp;  &nbsp;   &nbsp;  &nbsp;
         <a href="?lang=hi_IN">Hindi</a>  &nbsp;   &nbsp;   &nbsp;  &nbsp;   &nbsp;  &nbsp;
         <a href="?lang=zh_CN">Chinese</a>  &nbsp;   &nbsp;   &nbsp;  &nbsp;   &nbsp;  &nbsp;
          <a href="?lang=en_US">English</a>  &nbsp;   &nbsp;   &nbsp;  &nbsp;   &nbsp;  &nbsp;
         
         
         <br> <br>
         <h4> Current Locale is  ${pageContext.response.locale}</h4>
         
         <fmt:setLocale  value="${pageContext.response.locale}"/>
         
         <br><br>
         <jsp:useBean  id="dt"  class="java.util.Date"/>
         
         <fmt:formatDate var="fdt"  value="${dt}"  type="date"  dateStyle="FULL"/>
         
         <fmt:formatDate var="fdt1"  value="${dt}"  type="time"  dateStyle="FULL"/>
         
         <b>Formatted date and time:: ${fdt}</b> <br>
         <b>Formatted date and time:: ${fdt1}</b> <br>
         
         
         <hr>
         
         <fmt:formatNumber  var="fnumber"  value="1000000000"  type="number"  />
         formatted number is  :: ${fnumber}  <br>
         
         
         <fmt:formatNumber  var="fcurrency"  value="1000000000"  type="currency"  />
         formatted number is  :: ${fcurrency}  <br>
         
         <fmt:formatNumber  var="fpercentage"  value="0.221"  type="percent"/>
         formatted number is  :: ${fpercentage}  <br>
         
         
         
         
         
         
         
         


