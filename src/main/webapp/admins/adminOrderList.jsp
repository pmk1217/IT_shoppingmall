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
				<div class="title">주문관리</div>
				<section>
     
	
		<table class="toptable" style="table-layout: fixed;">
      <tr>
         <th width="10%" ><b>주문 ID</b></th>
         <th width="7%" ><b>사용자 ID</b></th>
          <th width="7%" ><b>상품 ID</b></th>
         <th width="10%" ><b>수량</b></th>
         <th width="35%" ><b>주문 처리 상태</b></th>      
         <th width="20%" ><b>생성일</b></th>
         <th width="15%" ><b>수정일</b></th>  
   </tr>

<c:choose>
    <c:when test="${empty  AdminOrderList}" >
      <tr>
        <td colspan="7">
          <b>등록된 주문이 없습니다.</b>
       </td>  
      </tr>
   </c:when>
     
	   <c:when test="${!empty AdminOrderList}" >
	      <c:forEach  var="order" items="${AdminOrderList}" >
	        <tr align="center">
	         <td>${order.order_id}</td>
	  		 <td>${order.o_user}</td>
			 <td>${order.o_product}</td>
			 <td>${order.quantity}</td>   
	
	         <form action="${contextPath}/admin/order/modify" method="post">
								<td>
									<c:choose>
										<c:when test="${order.getOrderProcess() == 0}">
											<input type="text" value="결제 대기" readOnly>
											<select name="orderProcess"  style="height: 27px; padding-top: 3px;">
												<option value="0" selected>대기</option>
												<option value="1">승인</option>
												<option value="2">취소</option>
											</select>
										</c:when>
										<c:when test="${order.getOrderProcess() == 1}">

											<input type="text" value="결제 승인" readOnly>
											<select name="orderProcess"  style="height: 27px; padding-top: 3px;">
												<option value="0">대기</option>
												<option value="1" selected>승인</option>
												<option value="2">취소</option>
											</select>
										</c:when>
										<c:when test="${order.getOrderProcess() == 2}">
											<input type="text" value="결제 취소" readOnly>
											<select name="orderProcess"  style="height: 27px; padding-top: 3px;">
											<option value="0">대기</option>
											<option value="1">승인</option>
											<option value="2" selected>취소</option>
											</select>
										</c:when>
									</c:choose> <input class="inputbtn" type="hidden" name="order_id"
									value="${order.getOrder_id()}"> <input class="inputbtn"
									type="submit" value="수정"></td>
			</form>
	        <td>${fn:substring(order.getCreated_at(), 0, 10)}</td>
	        <td>${fn:substring(order.getUpdated_at(), 0, 10)}</td>
          
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