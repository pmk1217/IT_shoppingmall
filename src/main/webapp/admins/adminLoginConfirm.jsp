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
	.toptable td{
		text-align: left;
	}
	.toptable input, textarea {
		float: left;
	}
	img {
	width:220px;
	height:220px;
	}
</style>
		
		<%@ include file="./adminInclude/adminHeader.jsp"%>
		<%@ include file="./adminInclude/adminAside.jsp" %>
			
			
		<div class="container">
				<div class="title">관리자만 이용할 수 있습니다. 로그인 해주세요.</div>
		<section>
     
	
		
		</section>  
		</div>
		<%@ include file="./adminInclude/adminFooter.jsp" %>
</body>
</html>