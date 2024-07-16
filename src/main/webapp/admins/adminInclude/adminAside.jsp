<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />  
<%
request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<style type="text/css">
	<%@ include file="../static/css/jquery-ui-1.12.1.css" %>
	<%@ include file="../static/css/reset.css" %>
	<%@ include file="../static/css/jsp-test.css" %>
</style>
<script type="text/javascript">
	<%@ include file="../static/js/popper.min.js" %>
	<%@ include file="../static/js/moment-2.29.1.js" %>
	<%@ include file="../static/js/bootstrap.min.js" %>
	<%@ include file="../static/js/common.js" %>
</script>
</head>
<body>
	<header>
	       <div class="lnb">
	           <div class="logo">
	                <a href="${contextPath}/admin/index/count"> <span>Admin</span></a>
	           </div>
	           
	           <div class="useInfo">
	               <span> </span>
	           </div>
	           
	           <ul class="nav">
	                   <li class="on"><a class="menu1" href="${contextPath}/admin/index/count"><i class="fas fa-home fa-w-18"></i><span style="margin-left: 7px;">홈</span></a></li>
	                   <li class="on"><a class="menu1"  href="${contextPath}/admin/member/selectAll"><i class="fas fa-users fa-w-18"></i> <span style="margin-left: 3px;">회원관리 </span></a></li>
	                   <li class="on"><a class="menu1" href="${contextPath}/admin/product/selectAll"><i class="fas fa-table fa-w-18"></i> <span style="margin-left: 4px;">상품관리 </span></a></li>
	                   <li class="on"><a class="menu1" href="${contextPath}/admin/order/selectAll"><i class="fas fa-shopping-cart fa-w-18"></i> <span style="margin-left: 3px;">주문관리 </span></a></li>
	                   <li class="on"><a class="menu1" href="${contextPath}/index.jsp"><i class="fas fa-shopping-bag fa-w-18"></i> <span style="margin-left: 4px;">쇼핑몰 </span></a></li>
	           </ul>
	       </div>
	    </header>
</body>
</html>