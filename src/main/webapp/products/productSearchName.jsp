<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, user.product.vo.UserProductVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
   List<UserProductVO> NameSearchList = (List<UserProductVO>) request.getAttribute("NameSearchList");
    System.out.println("productSearchName.jsp 실행 중 : " + NameSearchList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="${contextPath}/assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="${contextPath}/assets/img/favicon.ico">

    <link rel="stylesheet" href="${contextPath}/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/assets/css/templatemo.css">
    <link rel="stylesheet" href="${contextPath}/assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="${contextPath}/assets/css/fontawesome.min.css">
    
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<title>COM</title>
<style type="text/css">
   <%@ include file="../assets/css/templatemo.css" %>
   <%@ include file="../assets/css/bootstrap.min.css" %>
   <%@ include file="../assets/css/templatemo.css" %>
</style>
<style type="text/css">
      
      #pdtable tr, td {
         padding: 10px;
         overflow: hidden;
         text-overflow: ellipsis;
      }
      
      table {
         border-collapse: collapse;
      }
      
      img {
         width: 190px;
         height: 150px;
      }
      
      tbody {
         font-size: 14px;
         border: 1px solid #ddd;
      }
      
        /* 네모박스 스타일 설정 */
        .NameSearch-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            padding: 5px;
        }

        .NameSearch-item {
            width: calc(21% - 20px); /* 네모박스 간격 포함하여 너비 설정 */
            height : 400px;
            margin-bottom: 20px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            text-align: center;
        }
      
      .NameSearch-item #text {
         font-size : 14px;
            margin : 10px
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
   
   <div class="container py-5">
        <div class="row">    

            <div class="col-lg-9">
            
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
                
                <!-- 검색 결과 -->
               <table id="pdtable" style="display: flex; flex-wrap: wrap; margin: 0 auto">
                  <c:choose>
                     <c:when test="${empty NameSearchList}">
                        <!-- if() 부분 -->
                        <tr>
                           <td align="center" width="1000px;"><h5>상품이 없습니다</h5></td>
                        </tr>
                     </c:when>
                     <c:otherwise>
                        <c:forEach var="NameSearch" items="${NameSearchList}">
                           <tbody style="margin-left: 18px; margin-bottom: 15px; border: 1px solid #ddd; width: 220px; height: 330px;">
                              <tr>
                                 <td align="center" colspan="3">
                                  <a href="${contextPath}/userfilter/product/detail?product_id=${NameSearch.getProduct_id()}">
                                       <img src="${pageContext.request.contextPath}/images/${NameSearch.getCategory()}/${NameSearch.getImg()}" alt="${NameSearch.getName()}"
                                       onclick="handleClick('${contextPath}/userfilter/product/detail?product_id=${NameSearch.getProduct_id()}', '${NameSearch.getProduct_id()}' )">
                                 </a></td>
                              </tr>

                              <tr>
                                 <td align="center" colspan="3" height="80px;"><c:out
                                       value="${NameSearch.getName()}" /></td>
                              </tr>

                              <tr>
                                 <td align="left"
                                    style="color: black; font-size: 10px; font-weight: bold">조회
                                    수 : ${NameSearch.getViews()}</td>
                              </tr>

                              <tr>
                                 <td><input class="fas fa-heart"
                                    style="color: red; margin-left: 2px;" type="button"
                                    id="likeButton${NameSearch.getProduct_id()}" value="좋아요"
                                    onclick="handleLike('${NameSearch.getProduct_id()}')" />
                                    <b id="likes${NameSearch.getProduct_id()}"
                                    style="font-size: 14px; margin-left: 1px;">${NameSearch.getLikes()}
                                 </b></td>
                                 <td align="right"
                                    style="color: red; font-size: 18px; font-weight: bold"><fmt:formatNumber pattern="#,##0" value="${NameSearch.getPrice()}" />원</td>
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


<%@ include file="../include_css/userFooter.jsp"%>
</body>
</html>