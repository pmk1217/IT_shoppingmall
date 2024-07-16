<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   HttpSession sessionCheck = request.getSession();
   Object adminLoginInfo = sessionCheck.getAttribute("adminLoginInfo");
   String loginErrorMsg = (String) request.getAttribute("loginErrorMsg");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
        var loginErrorMsg = '${loginErrorMsg}';
        var contextPath = '${contextPath}';
        
        alert(loginErrorMsg);
        window.location.href = contextPath + '/users/login.jsp';
    </script>
</body>
</html>



