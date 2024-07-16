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
<title>Insert title here</title>
</head>
<style type="text/css">
   <%@ include file="./static/css/jquery-ui-1.12.1.css" %>
   <%@ include file="./static/css/reset.css" %>
   <%@ include file="./static/css/login-jsp-test.css" %>
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
   <%@ include file="./static/js/bootstrap.min.js" %>
</script>
<body>
<div class="main">
        <div class="container">
            <div class="logo">
                <a href="#"><span>ADMIN</span></a>
            </div>
            <div class="content">
                <div class="tit">Login</div>
                <div class="form">   
                    <form action="${contextPath}/adminfilter/action/login"  method="post">
                     <input type="text"  name="admin_id"  placeholder="ID"  required>
                    <input type="password" id="password" name="admin_password"   placeholder="password" required> 
                    <button type="submit" id="submit">LOGIN</button>
                    <span style="text-align: center; color:red; font-size: 16px; font-weight: bold;"> ${loginErrorMsg} </span>
                </form>
                <ul>
                    <li class="signin"><a href="${contextPath}/index.jsp">뒤로 가기</a></li>
                </ul>
                
                </div>
            </div>
        </div>
    </div>
</body>
</html>