<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
   HttpSession adminSessionCheck = request.getSession();

   Object adminLoginInfo = adminSessionCheck.getAttribute("adminLoginInfo");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="${contextPath}/assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="${contextPath}/assets/img/favicon.ico">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
	<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<style type="text/css">
	<%@ include file="../assets/css/templatemo.css" %>
	<%@ include file="../assets/css/bootstrap.min.css" %>
	<%@ include file="../assets/css/templatemo.css" %>
	<%@ include file="../assets/css/fontawesome.min.css" %>
	/* 네모박스 스타일 설정 */
         .product-container {
	        display: flex;
		    justify-content: space-between; /* 요소 사이의 간격을 최대로 벌립니다. */
		    align-items: flex-start; /* 요소를 컨테이너의 위쪽에 정렬합니다. */
		    width: 75%;
		    height: auto; /* 높이를 자동으로 조정하여 내용에 따라 늘어나도록 설정 */
		    padding: 5px;
		    border-radius: 5px;
		    background-color: #E9EAF0;
		    margin: 0 auto; /* 가운데 정렬을 위한 속성 추가 */
	    }
	   
	    .product-content {
	    	font-size: 18px;
	    	flex-grow: 0.5; /* 내용이 남은 공간을 모두 차지하도록 설정합니다. */
	        width: 45%;
	        height: 100%;
	        margin-top: 5px;
	        margin-bottom: 20px;
	        padding: 10px;
	        border: 1px solid #BDBDBD;
	        border-radius: 5px;
	        text-align: left;
	        background-color: #FFFFFF;
	    }
	    
	    .product-img {
		    flex: 0 0 100px; /* 이미지 너비를 고정합니다. */
		    max-width: 100%; /* 이미지의 최대 너비를 설정하여 유연한 크기 조정 */
		    height: auto; /* 이미지의 높이를 자동으로 조정하여 가로세로 비율 유지. */
		}
	    
	    #Product_Quantity{
	    	width: 150px;
	    	height: 30px;
	    	font-size: 15px;
	    }
	    
	    #cartbtn, #orderbtn{
	    	font-size: 12px;
	    	margin-bottom: 13px;	    	
	        margin-left: 10px;
	        border: 1px solid #BDBDBD;
	     	width: 150px;
	     	height: 50px;
	     	background-color: #E6EEF6;
	    }
</style>
<!-- Start Script -->
    <script src="${contextPath}/assets/js/jquery-1.11.0.min.js"></script>
    <script src="${contextPath}/assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="${contextPath}/assets/js/bootstrap.bundle.min.js"></script>
    <script src="${contextPath}/assets/js/templatemo.js"></script>
    <script src="${contextPath}/assets/js/custom.js"></script>
<!-- End Script -->
<title>COM</title>
</head>
<body>


 <!-- Start Top Nav -->
    <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
        <div class="container text-light">
            <div class="w-100 d-flex justify-content-between">
                <div>
                    <i class="fa fa-envelope mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="mailto:info@company.com">com@test.com</a>
                    <i class="fa fa-phone mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="tel:010-020-0340">010-xxxx-xxxx</a>
                </div>
                <div>
                	<c:choose>
					<c:when test="${adminLoginInfo == null}">
	                	<a href="${contextPath}/admins/adminLogin.jsp"  style="color:white; text-decoration-line:none; text-align=right; font-size:15px;"> 관리자 </a>
					</c:when>
					
					<c:otherwise>
	                	<a href="${contextPath}/admin/index/count" style="color:white; text-decoration-line:none; font-size:15px;"> 관리자 </a>
	                </c:otherwise>
                </c:choose>
                 <!--    <a class="text-light" href="https://fb.com/templatemo" target="_blank" rel="sponsored"><i class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://www.instagram.com/" target="_blank"><i class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://twitter.com/" target="_blank"><i class="fab fa-twitter fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://www.linkedin.com/" target="_blank"><i class="fab fa-linkedin fa-sm fa-fw"></i></a> -->
                </div>
            </div>
        </div>
    </nav>
    <!-- Close Top Nav -->


    <!-- Header -->
    <nav class="navbar navbar-expand-lg navbar-light shadow">
        <div class="container d-flex justify-content-between align-items-center">

            <a class="navbar-brand text-success logo h1 align-self-center"  href="${contextPath}/index.jsp">
                IT_Shop
            </a>

            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
                <div class="flex-fill">
					<ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="${contextPath}/index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${contextPath}/userfilter/product/searchByCategory?category=desktop">본체</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${contextPath}/userfilter/product/searchByCategory?category=monitor">모니터</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${contextPath}/userfilter/product/searchByCategory?category=keyboard">키보드</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${contextPath}/userfilter/product/searchByCategory?category=mouse">마우스</a>
                        </li>
                       
                    </ul>
                </div>
                <div class="navbar align-self-center d-flex">
                    <div class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
                        <div class="input-group"> 
                            <input type="text" class="form-control" id="inputMobileSearch" placeholder="Search ...">
                            <div class="input-group-text">
                                <i class="fa fa-fw fa-search"></i>
                            </div>
                        </div>
                    </div>
                 <!--     <a class="nav-icon d-none d-lg-inline" href="#" data-bs-toggle="modal" data-bs-target="#templatemo_search">
                        <i class="fa fa-fw fa-search text-dark mr-2"></i>
                    </a>  -->
                    <b>${loginInfo}님 /  </b>
                     <a class="nav-icon position-relative text-decoration-none" href="${contextPath}/userfilter/action/logout">
                       <b>로그아웃 </b>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"></span>
                    </a>
                    <a class="nav-icon position-relative text-decoration-none" href="${contextPath}/user/cart/selectAll?userId=${loginInfo}">
                        <i class="fa fa-fw fa-cart-arrow-down text-dark mr-1"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"></span>
                    </a>
                    <a class="nav-icon position-relative text-decoration-none" href="${contextPath}/user/action/detail">
                        <i class="fa fa-fw fa-user text-dark mr-3"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"></span>
                    </a> 
                    <a class="nav-icon position-relative text-decoration-none" href="${contextPath}/user/order/selectAll">
                        <i class="fa fa-fw fa-shopping-cart text-dark mr-3"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"></span>
                    </a>      
                    
                    
                </div>
            </div>

        </div>
    </nav>
    <!-- Close Header -->

