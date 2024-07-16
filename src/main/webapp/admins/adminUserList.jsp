<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>       
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />  
<%
request.setCharacterEncoding("UTF-8");
%>  
<script type="text/javascript">
function email(){
     alert("이메일을 보냈습니다.");
}
</script>
  <style type="text/css">
			.page {
				padding-top:6px;
				padding-bottom:6px;
				padding-left:10px;
				padding-right:10px;
				border:1px solid #ddd;
				background-color: white; 
				color:black;
			}
			.page:hover {
				background-color: #ddd;
			}
			#thispage {
				background-color: #ddd;
			}
			a:hover {
				color:skyblue;
			}
		</style>
		
		<%@ include file="./adminInclude/adminHeader.jsp"%>
		<%@ include file="./adminInclude/adminAside.jsp" %>
			
			
		<div class="container">
				<div class="title">회원관리</div>
				<section>
     
	
		 <table class="toptable" style="table-layout: fixed;">
      <tr style="height: 23px;">
         <th width="10%" ><b>회원아이디</b></th>
         <th width="7%" ><b>패스워드</b></th>
          <th width="7%" ><b>회원이름</b></th>
         <th width="10%" ><b>생년월일</b></th>
         <th width="20%" ><b>이메일</b></th>      
         <th width="20%" ><b>가입일</b></th>
         <th width="15%" ><b>메일보내기</b></th>  
   </tr>

<c:choose>
    <c:when test="${empty  userList}" >
      <tr>
        <td colspan="7">
          <b>등록된 회원이 없습니다.</b>
       </td>  
      </tr>
   </c:when>
     
   <c:when test="${!empty userList}" >
      <c:forEach  var="user" items="${userList }" >
        <tr align="center">
          <td>${user.user_id }</td>
          <td>${user.password }</td>
          <td>${user.name}</td>     
          <td>${user.birthday}</td>     
          <td>${user.email}</td>
          <td>${fn:substring(user.created_at, 0, 10)}</td>
          
         <td><a href="#" onclick="email()">메일보내기</a></td>      
       </tr>
     </c:forEach>
</c:when>
</c:choose>
   </table> 
		</section>  
		</div>
		<%@ include file="./adminInclude/adminFooter.jsp" %>
</body>
</html>