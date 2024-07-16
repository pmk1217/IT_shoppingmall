<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<% System.out.println("productListCategory.jsp 구동 시작"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="${contextPath}/assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="${contextPath}/assets/img/favicon.ico">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="${contextPath}/assets/css/fontawesome.min.css">
    
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<title>COM</title>
<style type="text/css">
	<%@ include file="../assets/css/templatemo.css" %>
	<%@ include file="../assets/css/bootstrap.min.css" %>
	
</style>
<style>
	#pdtable tr, td{
		padding: 10px;
		overflow: hidden; 
		text-overflow: ellipsis;
	}
	table {
		border-collapse: collapse;
	}
	img {
		width: 200px;
		height: 160px;
	}
	tbody {
		font-size: 14px;
		border: 1px solid #ddd;
	}
	.col-lg-3 {
		width:20%;
	}
	.col-lg-9 {
		width:80%;
	}
</style>

<script>
	
	// 조회수 증가 클릭 버튼 함수
    function handleClick(url ,product_id) {
    	
    	// 제품 조회수 증가 서블릿 호출
        incrementViews(product_id);
    	
        // 제품 상세 페이지로 이동
        redirectToProductDetail(url);
       
    }

    function redirectToProductDetail(url) {
        // 제품 상세 페이지로 이동
        window.location.href = url;
    }

    function incrementViews(product_id) {
        // jQuery Ajax를 사용하여 서블릿 호출
        $.ajax({
            url: '${contextPath}/userfilter/product/incrementViews?product_id=' + product_id,
            type: 'GET',
            success: function(response) {
                // 성공적으로 서블릿이 실행된 경우에 수행할 작업
                console.log('서블릿이 성공적으로 실행되었습니다.');
            },
            error: function(xhr, status, error) {
                // 서블릿 호출에 실패한 경우에 수행할 작업
                console.error('서블릿 호출 중 오류가 발생했습니다.');
                console.error('Status: ' + status);
                console.error('Error: ' + error);
            }
        });
    }
    
    // 좋아요 버튼 클릭 버튼 함수 
    function handleLike(product_id) {
    	// 해당 ID의 요소를 가져옵니다.
    	var likeButton = document.getElementById("likeButton" + product_id);
    	var likeValue = document.getElementById("likes"+ product_id);
 
       	incrementLikes(product_id, likeButton, likeValue);
    	
    }

    // 좋아요 추가 요청을 보내는 함수
    function incrementLikes(product_id, likeButton, likeValue) {
      
        $.ajax({
            type: "GET",
            url: "${contextPath}/user/product/incrementLikes?product_id="+product_id,
            success:function(data) {
     
                var likeCountPlus = data.likeCount;

                likeValue.value = likeCountPlus + product_id;
                location.reload();//새로고침
            },
            error:function(status, error) {
                console.error("AJAX request failed:", status, error);
            }
        });
       
    }
</script>

</head>
<body>
<%
   HttpSession sessionCheck = request.getSession();

   Object loginInfo = sessionCheck.getAttribute("loginInfo");

%>

 <% 
     if (loginInfo == null) {
 %> 
       <%@ include file="../include_css/userHeaderBeforeLogin.jsp"%> 
 <% 
    } else {
 %> 
         <%@ include file="../include_css/userHeaderAfterLogin.jsp"%> 
 <% 
   }
 %> 



 <!-- Start Content -->
    <div class="container py-5">
        <div class="row">    

			<%@ include file="../include_css/userAside.jsp"%> 

            <div class="col-lg-9" style="width: 83%">
                <div class="row">
                    <div class="col-md-6">
                        <ul class="list-inline shop-top-menu pb-3 pt-1">
                            <li class="list-inline-item">
                                <a class="h3 text-dark text-decoration-none mr-3" href="${contextPath}/userfilter/product/sortByLikes?category=${sessionScope.category}" > 인기순 </a>
                            </li>
                            <li class="list-inline-item">
                                <a class="h3 text-dark text-decoration-none mr-3" href="${contextPath}/userfilter/product/sortByCreaetedAt?category=${sessionScope.category}" >최신순</a>
                            </li>
                            <li class="list-inline-item">
                                <a class="h3 text-dark text-decoration-none" href="${contextPath}/userfilter/product/sortByViews?category=${sessionScope.category}" >조회순</a>
                            </li>
                             <li class="list-inline-item">
                                <a class="h3 text-dark text-decoration-none" href="${contextPath}/userfilter/product/sortByPrice?category=${sessionScope.category}" >가격순</a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-6 pb-4" >
                        <div class="d-flex" style="float:right;">
								<!-- 검색 기능 -->
								<div style="float:right; margin-left:5px;">								
									<form action="${contextPath}/userfilter/product/search" method="post">
										<select name="searchType">
								            <option value="productName" selected>상품명</option>
								            <option value="productContent" selected>내용</option>
								        </select>
								        <input type = "hidden" name = "category" value= "${category}"> 
								        <input type="text" name="SearchText" placeholder="검색어를 입력하세요" maxlength="15" size="17" style="height: 27px; background-color: white; border:1px solid black;">
								        <input type="submit" value="검색" style="height: 27px;">
								    </form>								
								</div>	
                        </div>
                    </div>
                </div>
                
               
                
                <div class="row">
                
                
                
                <!--  여기서부터  -->
                  
              <table id="pdtable" style="display:flex;  flex-wrap : wrap; margin: 0 auto">
				  <c:choose>
					<c:when test="${empty categoryList}">
									<!-- if() 부분 -->
									<tr>
										<td align="center"  width="1000px;">등록된 상품이 없습니다.</td>
									</tr>
					</c:when>
				 <c:otherwise>     
			            <c:forEach var="category" items="${categoryList}" varStatus="status">
				            <tbody style="margin-left: 18px; margin-bottom: 15px; border: 1px solid #ddd; width: 240px; height: 350px;">
				            <tr>  
				                 <td align="center"  colspan="3">
				                  <a href="${contextPath}/userfilter/product/detail?product_id=${category.getProduct_id()}">
				                 <img src= "${pageContext.request.contextPath}/images/${category.getCategory()}/${category.getImg()}"   alt="${category.getName()}" onclick="handleClick('${contextPath}/userfilter/product/detail?product_id=${category.getProduct_id()}', '${category.getProduct_id()}' )" >
				                </a>
				          		  </td>
				          		  </tr>
				          		  <tr>
				          				 <td align="center" colspan="3" height="80px;"> <c:out value="${category.getName()}" /></td>
				          		 </tr>
				          		 <tr>
				          		 		 <td align="left" style="color: black; font-size: 10px; font-weight:bold; padding-bottom: 5px; padding-top: 5px; ">조회 수 : ${category.getViews()}</td>
				          		 
				          		 </tr>
				          		 
				          	  	  <tr>
				          	  	 	  <td>
				          	  	 	  <input class="fas fa-heart"   style="color: red; margin-left: 2px;" type="button"  id="likeButton${category.getProduct_id()}" value="좋아요" onclick="handleLike('${category.getProduct_id()}')" />
				          	  	 	  <b id="likes${category.getProduct_id()}" style="font-size: 14px; margin-left: 1px;">${category.getLikes()} </b>
				          	  	 	  </td>
				                	   <td align="right" style="color: red; font-size: 18px; font-weight:bold "><fmt:formatNumber pattern="#,##0" value="${category.getPrice()}" />원</td>
				                  	   <!--c:out  -->
				                  </tr> 
				               </tbody>		            
		              </c:forEach>
				   </c:otherwise>
				 </c:choose>  
				        
				</table>
               
                
                
            </div>
		</div>
        </div>
    </div>
    <!-- End Content -->
<%@ include file="../include_css/userFooter.jsp"%>