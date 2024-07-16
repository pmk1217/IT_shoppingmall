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
<title>UserLike</title>
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
	#pdtable tr, td{
		padding: 10px;
		overflow: hidden; 
		text-overflow: ellipsis;
	}
	table {
		border-collapse: collapse;
	}
	img {
		width: 250px;
		height: 220px;
	}

</style>
</head>
<body style="height: auto; background-color: white;">
   <div class="main">
        <div class="container"  style="border: 1px solid #c5c5c5; background-color: white;">
            <div class="logo">
                <a href="${contextPath}/index.jsp"><span style="color: black;">IT_Shop</span></a>
            </div>
            <div class="content">
                <div class="tit" style="color: black;">   <i class="fas fa-heart fa-1x"  style="color:red;"> </i> 좋아요 한 상품   <i class="fas fa-heart fa-1x"  style="color:red;"> </i> </div>
                <div class="form" style="width:100%">   
                
                
                
                <table id="pdtable" style="display:flex;  flex-wrap : wrap; margin: 0 auto">
				  <c:choose>
					<c:when test="${empty productList}">
									<!-- if() 부분 -->
									<tr>
										<td align="center" > 좋아요 한 상품이 없습니다.</td>
									</tr>
					</c:when>
				 <c:otherwise>     
			            <c:forEach var="product" items="${productList}" varStatus="status">
				            <tbody style="margin-left: 18px; margin-bottom: 15px; border: 1px solid #c5c5c5; width: 260px; height: 350px;">
				            <tr>  
							 <td align="center"  colspan="3">
				                  <a href="${contextPath}/userfilter/product/detail?product_id=${product.getProduct_id()}">
				                 <img src= "${pageContext.request.contextPath}/images/${product.getCategory()}/${product.getImg()}"   alt="${product.getName()}" onclick="handleClick('${contextPath}/userfilter/product/detail?product_id=${product.getProduct_id()}', '${product.getProduct_id()}' )" >
				                </a>
				          		  </td>
				          		  </tr>
				          		  <tr>
				          				 <td align="center" colspan="3" height="60px;"> <c:out value="${product.getName()}" /></td>
				          		 </tr>          		 
				          	  	  <tr>
				                	   <td style="color: red; font-size: 18px; font-weight:bold ; text-align: right;"><fmt:formatNumber pattern="#,##0" value="${product.getPrice()}" />원</td>
				                  	   <!--c:out  -->
				                  </tr> 
				               </tbody>		            
		              </c:forEach>
				   </c:otherwise>
				 </c:choose>  
				        
				</table>
                
                
                
                
                
                
                
                
                
                    	<table style="border: none;">                        
				        <tr>
				        <td colspan="3">
				        <button id="submit" onclick="history.back()" >뒤로가기</button>
				        </td>
				        </tr>
				        </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
