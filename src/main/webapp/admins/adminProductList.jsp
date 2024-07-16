<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>       
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />  
<%
request.setCharacterEncoding("UTF-8");
%>    
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
				<div class="title">상품관리</div>
				<section>
     
	
		 <table class="toptable" style="table-layout: fixed; ">
		<!-- <caption>게시판 목록</caption> <!--  테이블에 제목 붙이는 태그 -->
		<colgroup> <!--  컬럼들을 하나의 그룹화 시켜줌 -->
			<col width="15" />
			<col width="120" />  		<!--  컬럼의 크기등을 세팅 -->
			<col width="30" />
			<col width="30" />
			<col width="20" />
			<col width="50" />
		</colgroup>
		<thead>		<!--  테이블의 헤드 영역을 묶어줌 -->
			<!-- 글제목  -->
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>가격</th>
				<th>분류</th>
				<th>재고</th>
				<th>수정일</th>
			</tr>
		</thead>

		<!--  글목록의 데이터부분 시작-->
		<tbody>		<!--  데이터 영역을 묶어줌 -->
			<c:choose>
				<c:when test="${totalCount == 0}">
					<tr>
						<td align="center" colspan="6">등록된 상품이 없습니다.</td>
					</tr>
				</c:when>

				<c:otherwise>
					<c:forEach var="product" items="${productList}" varStatus="status">
						<tr>
							<td align="center"><c:out value="${totalCount - (status.index+1) + 1 - (productVO.pageNum - 1) * productVO.listCount}" /></td>
						
							<td><%-- <c:url value="/admin/product/detail?product_id=${product.product_id}&pageNum=${productVO.pageNum}&amp;searchType=${productVO.searchType}&amp;searchText=${productVO.searchText}" /> --%>
									<a href='<c:url value="/admin/product/detail?product_id=${product.product_id}&pageNum=${productVO.pageNum}&amp;searchType=${productVO.searchType}&amp;searchText=${productVO.searchText}"></c:url>'>
									<c:out value="${product.name}" />
							</a> </td>

							<td align="center"><c:out value="${product.price}" />원</td>

							<td align="center"><c:out value="${product.category}" /></td>

							<td align="center"><c:out value="${product.quantity}"/>개</td>
							
							 <td align="center"><%-- <img src="../images/${product.image }"> --%>
									<c:out value="${fn:substring(product.updated_at, 0, 16)}" /></td> 
																								<!-- 현재 시간을 쪼개서 일부분만 나오게 함 --> 																						
							<%-- <input type="button" value="상세보기" class="btn"
										onclick="location.href='<c:url value="/product/productViewServlet?no=${product.no}"/>'" /> --%>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
		<!--  글 목록의 데이터부분 종료 -->
		<tfoot style="margin-top:10px; height: 60px;">
			<tr>
				<td align="center" colspan="6"  style="border-bottom:none;"><c:out value="${pageNavigator}" 
				escapeXml="false" /></td>
				<!--  태그 출력을 방지 -->
			</tr>
		</tfoot>
	</table> 



	 <table>
		<tr>
			<td style="text-align: right; border-style:none; width: 72%;">
			
			<input type="button" value="목록" class="inputbtn"
				onclick="location.href='<c:url value="/admin/product/selectAll"/>'" />
	
			<input type="button" value="상품등록" class="inputbtn"
				onclick="location.href='<c:url value="/admin/product/write"/>'" />
		</td>
		</tr>
		</table> 
	
		<form action="" method="get">
		<table class="search" style="margin-bottom: 10px;">
			<tr>
				<td style="border-style: none; text-align: center;">
				<select name="searchType"  class="select">
					<option value="ALL" selected="selected">전체</option>
					<option value="NAME"
						<c:if test="${productVO.searchType eq 'NAME'}">selected="selected"</c:if>>
						상품명</option>   <!--  전체검색이면 value가 ALL -->
	
					<option value="CONTENT"
						<c:if test="${productVO.searchType eq 'CONTENT'}">selected="selected"</c:if>>
						내용</option>
	
					<option value="CATEGORY"
						<c:if test="${productVO.searchType eq 'CATEGORY'}">selected="selected"</c:if>>
						카테고리</option>
				</select> 
				<input type="text" name="searchText"  maxlength="15" size="18"
					value="<c:out value="${productVO.searchText}" />" /> 
					<input type="submit"  class="inputbtn"  value="검색" />
			</tr>
		</table>
		</form>
		</section>  
		</div>
		<%@ include file="./adminInclude/adminFooter.jsp" %>
</body>
</html>