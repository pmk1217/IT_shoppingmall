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
<title>User Register</title>
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
	<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<style type="text/css">
	<%@ include file="../admins/static/css/jquery-ui-1.12.1.css" %>
	<%@ include file="../admins/static/css/reset.css" %>
	<%@ include file="../admins/static/css/login-jsp-test.css" %>
</style>
<style type="text/css">
	.form input {border:1px solid #eee;border-radius:4px;width:100%;height:36px;margin:0;padding:0 10px;box-sizing:border-box}
</style>
<script type="text/javascript">
	<%@ include file="../admins/static/js/bootstrap.min.js" %>
</script>
<style type="text/css">
	a:hover {
		color: skyblue;
	}
</style>
</head>
<body>

<div class="main">
        <div class="container" style="background-color: #007eff;">
            <div class="logo">
                <a href="${contextPath}/index.jsp"><span>IT_Shop</span></a>
            </div>
            <div class="content">
                <div class="tit">회원정보</div>
                <div class="form" style="width:100%">   
                    <form action="${contextPath}/user/action/detailToModify" method="post">
                    	<table>
                    	<tr>
                    		<td> ID </td>
                    		<td>
				         	<input type="text"  name="user_id"  id="m_id"  value="${user.getUser_id()}" readonly> 
				         	</td>

				         </tr>
				        <tr>
				        <td> PW </td>
				        <td>
				        <input type="password" name="passwordView" value="********" readonly> 
						<input type="hidden" name="password" value="${user.getPassword()}">
				        </td>

		            <tr>
		            	<td>이름</td>
		            	<td><input type="text" name="name"  value="${user.getName()}" readonly></td>
		          
		            </tr>
		            <tr>
		            	<td>생년월일</td>
		            	<td><input type="text" name="birthday"   value="${user.getBirthday()}" readonly></td>
		       
		            </tr>
		            <tr>
		            	<td>이메일</td>
		            	<td><input type="email" name="email"  value="${user.getEmail()}" readonly></td>
		        
		            </tr>
		            <tr>
		            	<td>우편번호</td>
		            	<td><input type="text" id="zipcode" name="zipcode" value="${user.getZipcode()}" readonly></td>

		            </tr>        
		            <tr>
		            	<td>주소</td>
		            	<td><input type="text" id="address" name="address"  value="${user.getAddress()}" readonly></td>
		            </tr>	             
					<tr>
						  <td>  <i class="fas fa-heart" style="color: red;"></i> 좋아요 한 상품 </td>
						  <td colspan="2"  style="text-align: center; height: 50px;">
				       			<a href="${contextPath}/user/action/userLike?user_id=${user.getUser_id()}"   style="width:100%; background-color: #ddd; border-radius: 5px; color:black; padding:10px;">
				       			좋아요 한 상품 보러가기</a> 
				       	 </td>
				        <tr>
				        <td colspan="3">
				        <button type="submit"  id="submit">회원정보 수정하기</button>
				        </td>
				        </tr>
				        </table>
				    </form>
<%-- 				    <ul>
				        <li class="signin"><a href="#" onclick="window.open('${contextPath}/users/register.jsp')">회원가입</a></li>
				    </ul> --%>
				    
                </div>
            </div>
        </div>
    </div>
</body>
</html>