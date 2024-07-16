<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<body>
	<script>
        var contextPath = '${contextPath}';
        
        alert("로그인 후 이용해 주세요!");
        window.location.href = contextPath + '/users/login.jsp';
    </script>
</body>
</body>
</html>