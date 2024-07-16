<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page import="java.util.List, user.product.vo.UserProductVO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productList.jsp</title>
<style type="text/css">
	<%@ include file="../assets/css/templatemo.css" %>
	<%@ include file="../assets/css/bootstrap.min.css" %>
	<%@ include file="../assets/css/templatemo.css" %>
</style>
<style type="text/css">
		
		@font-face {
	    font-family: 'omyu_pretty';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-01@1.0/omyu_pretty.woff2') format('woff2');
	    font-weight: normal;
	    font-style: normal;
		}
		
        /* 네모박스 스타일 설정 */
        .product-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            padding: 5px;
        }

        .product-item {
            width: calc(20% - 20px); /* 네모박스 간격 포함하여 너비 설정 */
            height : 400px;
            margin-bottom: 20px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            text-align: center;
        }
        
        .product-item li {
            list-style: none;
        }
		
		.product-item #text {
			font-family: 'omyu_pretty';
			font-size : 13px;
            margin : 10px
        }
		
        .product-item img {
            width: 70%;
            border-radius: 5px;
            margin-bottom: 10px;
        }
</style>
<script type="text/javascript">
	function setCategory(category) {
		  $.ajax({
		            url: '${pageContext.request.contextPath}/user/product/categories',
		            type: 'GET',
		            data: { category: category },
		            success: function(data) {
		                $('#product-container').html(data);
		            },
		            error: function() {
		                alert('상품을 가져오는 데 문제가 발생했습니다.');
		            }
		        });
	    	}
</script>
</head>
<body>
	<div>
		<p>카테고리</p>
			  <a href="${contextPath}/user/product/categories?category=desktop">본체</a>
        <a href="${contextPath}/user/product/categories?category=monitor">모니터</a>
        <a href="${contextPath}/user/product/categories?category=keyboard">키보드</a>
        <a href="${contextPath}/user/product/categories?category=mouse">마우스</a>   
    </div>
    
    <div>
	  <a href="${contextPath}/admin/order/selectOrderAll">관리자</a>
	  </div>
       
	<br>
	<p>상품목록</p><br>
	<div class="product-container">
		<c:choose>
			<c:when test="${ProductList.size() < 1 }">
				<h5>상품이 없습니다</h5>
			</c:when>
			<c:otherwise>
				<c:forEach var="ProductList" items="${ProductList}">           
					<div class="product-item" onclick = "location.href='<c:url value="user/product/detail?product_id=${ProductList.getProduct_id()}"/>'">
					
							<p><img src="${contextPath}/images/${ProductList.getCategory()}/${ProductList.getImg()}" alt="${product.getName()}"></p>
							<p id = "text">${ProductList.getName()}</p>
							<p id = "text">${ProductList.getPrice()} 원</p>
							<p id = "text">${ProductList.getLikes()}</p>
												
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>