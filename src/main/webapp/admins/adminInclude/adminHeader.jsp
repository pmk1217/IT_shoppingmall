<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>       
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />  
<%
request.setCharacterEncoding("UTF-8");
%>    
<%
   HttpSession sessionCheck = request.getSession();

   Object adminLoginInfo = sessionCheck.getAttribute("adminLoginInfo");
%>
    
	<div  class="userInfo" >
		<i class="fas fa-user" style="color:white;"></i>
			   <span> ${adminLoginInfo} / </span>
				   <button type="button">
				       <a href="${contextPath}/admin/action/logout"> Signout </a>
			   </button>
		</div>
</body>
</html>