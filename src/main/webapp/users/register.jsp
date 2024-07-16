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
	<script>
    	function overlappedId(){
    		 var _id=$("#m_id").val();
    		    
    		    const regExp = /[a-zA-Z0-9]/g;
    		    if(regExp.test(_id)){

    		    }else{
    		    	alert("영문 숫자만 가능합니다.");
    		        return;
    		    }
    		    
    		
    		    $.ajax({
	    		       type:"post",
	    		       async:true,  
	    		       url:"${contextPath}/userfilter/action/duplicatedId",
	    		       dataType:"text",
	    		       data: {user_id:_id},
	    		       
	    		       success:function (data,textStatus){
	    		          if(data=='usable'){
	//    		        	  swal.fire('사용할 수 있는 ID입니다.');
	    	 	        	  alert("사용할 수 있는 ID입니다.");
	//    	 	       	   $('#message').text("사용할 수 있는 ID입니다.");
	    		       	   $('#id_check').prop("disabled", true);
	    		          }else{
	//   		        	  swal.fire('사용할 수 없는 ID입니다.');
	    	 	        	  alert("사용할 수 없는 ID입니다.");
	//    	 	       	   $('#message').text("사용할 수 없는 ID입니다.");
	    		          }
	    		       },
	    		       error:function(data,textStatus){
	    		          alert("잘못 입력했습니다.");ㅣ
	    		       },
	    		       complete:function(data,textStatus){
	    		          //alert("작업을완료 했습니다");
	    		       }
    		    });  // ajax() END	 
    		    
    	}
    </script>
</head>
<body>

<div class="main">
        <div class="container" style="background-color: #007eff;">
            <div class="logo">
                <a href="${contextPath}/index.jsp"><span>IT_Shop</span></a>
            </div>
            <div class="content">
                <div class="tit">회원가입</div>
                <div class="form" style="width:100%">   
                    <form action="${contextPath}/userfilter/action/register" method="post">
                    	<table>
                    	<tr>
                    		<td> ID </td>
                    		<td>
				         	<input type="text"  style="width: 49%" placeholder="ID" name="user_id"  id="m_id" required> <input type="button"   id="id_check"  value="중복확인" onclick="overlappedId()" style="width: 49%">
				         	</td>

				         </tr>
				        <tr>
				        <td> PW </td>
				        <td>
				        <input type="password" name="password"   placeholder="password" required> 
				        </td>

				        <tr>
		            	<td>패스워드 확인</td>
		            	<td><input type="password" name="pwdconfirm"   required></td>
		      
		            </tr>
		            <tr>
		            	<td>이름</td>
		            	<td><input type="text" name="name"   required></td>
		          
		            </tr>
		            <tr>
		            	<td>생년월일</td>
		            	<td><input type="text" name="birthday"  placeholder="ex)830815"  required></td>
		       
		            </tr>
		            <tr>
		            	<td>이메일</td>
		            	<td><input type="email" name="email"  required></td>
		        
		            </tr>
		            <tr>
		            	<td>우편번호</td>
		            	<td><input type="text" id="zipcode" name="zipcode" maxlength="5" size="5" style="width: 49%">&nbsp;<input type="button"   style="width: 49%"  value="우편번호찾기"  onclick="window.open('${contextPath}/users/zipcode.jsp', 'a', 'width=500px, height=300px,top=250px,left=250px,');" ></td>

		            </tr>
		            <tr>
		            	<td>주소</td>
		            	<td><input type="text" id="address" name="address"></td>

		            </tr>	        
				        <tr>
				        <td colspan="3">
				        <button type="submit"  id="submit">회원가입</button>
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