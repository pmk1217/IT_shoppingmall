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
	table input {
	folat:left;
	}
	#adwrite input, textarea {
		float:left;
	}
	#adwrite td {
		text-align:left;
	}
	img {
	width:180px;
	height:120px;
	}
		</style>
		
		<%@ include file="./adminInclude/adminHeader.jsp"%>
		<%@ include file="./adminInclude/adminAside.jsp" %>
			
			
		<div class="container">
				<div class="title">상품수정</div>
				<section>
     
	
		 <form action="<c:url value="/admin/product/modify" />" method="post"   onsubmit="return productModifyCheck();">
		
		<input type="hidden" name="product_id" value="<c:out value="${productVO.product_id}" />" />
		
		
		<table id="adwrite">
		<colgroup>
			<col width="100" />
			<col width="400" />
		</colgroup>
		<tbody>
			<tr>
				<td>상품명</td>
				<td><input type="text"  name="name"  size="30"  maxlength="100"  value="${productVO.name }" /></td>
			</tr>
			<tr>
				<td>상품분류</td>
				<td><input type="text" name="category" size="10" maxlength="100"  value="<c:out value="${productVO.category}" />"/>
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" size="10" maxlength="100"  value="<c:out value="${productVO.price}" />"/>원
				</td>
			</tr>
			<tr>
				<td>설명</td>
				<td>
						<textarea style="padding:8px;" rows="10" cols="64" name="content" ><c:out value="${productVO.content}"  escapeXml="false"/></textarea>
				</td>
			</tr>
			<tr>
				<td>좋아요 수</td>
				<td> <input type="text" name="likes" size="3" maxlength="100"   readonly value="<c:out value="${productVO.likes}" />"/>개
				</td>
			</tr>
			<tr>
				<td>재고</td>
				<td> <input type="text" name="quantity" size="3" maxlength="100"  value="<c:out value="${productVO.quantity}" />"/>개
				</td>
			</tr>
			<tr>
				<td>상품 이미지</td>
				<td>
					<img src="${contextPath}/images/${productVO.category }/${productVO.img }">
					<input type="file"  name="img"  style="border: none;">
				</td>
			</tr>
			
			
		<tr>
		<td width="400" colspan="2" style="border-bottom:none;">
		<input style="float:left;" class="inputbtn" type="button" value="목록" onclick="location.href='<c:url value="/admin/product/selectAll"/>'" >
		<input style="float:right; margin-left:5px;" class="inputbtn"  type="reset" value="다시입력" > 
		<input style="float:right;" class="inputbtn" type="submit" value="상품수정"  onclick="goModify()">
		</td>
			</tr>
			</tbody>
	</table>
	</form>
		</section>  
		</div>
		<%@ include file="./adminInclude/adminFooter.jsp" %>
</body>
</html>