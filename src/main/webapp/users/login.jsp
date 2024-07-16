<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>       
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />  
<%
request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<style type="text/css">
	<%@ include file="../admins/static/css/jquery-ui-1.12.1.css" %>
	<%@ include file="../admins/static/css/reset.css" %>
	<%@ include file="../admins/static/css/login-jsp-test.css" %>
	
	#password{
		border : none;
		border-radius: 4px;
		width:100%; /* 가로 길이를 원하는 크기로 조정 */
		background-color: #F2F2F2;
		padding: 0 10px;
		box-sizing: border-box;
	}
	
</style>
<script type="text/javascript">
	<%@ include file="../admins/static/js/bootstrap.min.js" %>
</script>
<body>

<div class="main">
        <div class="container" style="background-color: #007eff;">
            <div class="logo">
                <a href="${contextPath}/index.jsp"><span>IT_Shop</span></a>
            </div>
            <div class="content">
                <div class="tit">Login</div>
                <div class="form">   
                    <form action="${contextPath}/userfilter/action/login" method="post">
				         <input type="text"  name="user_id"  placeholder="ID"  required>
				        <input type="password" name="password"  id="password" placeholder="password" required> 
				        <button type="submit"  id="submit">LOGIN</button>
				    </form>
				    <ul>
				        <li class="signin"><a href="#" onclick="window.open('${contextPath}/users/register.jsp')">회원가입</a></li>
				    </ul>
				    
                </div>
            </div>
        </div>
    </div>
</body>
</html>