<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>


<style type="text/css">
	<%@ include file="../assets/css/templatemo.css" %>
	<%@ include file="../assets/css/bootstrap.min.css" %>
	<%@ include file="../assets/css/templatemo.css" %>
	<%@ include file="../assets/css/fontawesome.min.css" %>
</style>


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
<!-- Modal -->
    <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="w-100 pt-1 mb-5 text-right">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="" method="get" class="modal-content modal-body border-0 p-0">
                <div class="input-group mb-2">
                    <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                    <button type="submit" class="input-group-text bg-success text-light">
                        <i class="fa fa-fw fa-search text-white"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>



    <!-- Start Banner Hero -->
    <div id="template-mo-zay-hero-carousel" class="carousel slide" data-bs-ride="carousel">
        <ol class="carousel-indicators">
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="0" class="active"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="1"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="2"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="3"></li>
        </ol>
        <div class="carousel-inner">
           <!-- 1번째 광고 -->
            <div class="carousel-item active" onclick="location.href='${contextPath}/userfilter/product/searchByCategory?category=desktop'">
                <div class="container">
                    <div class="row p-5" >
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="${contextPath}/images/Advertisement/desktopAD.png" alt="">
                        </div>
                        
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            
                            <div class="text-align-left align-self-center">
                            <br>
                                <h1 class="h1 text-success"><strong>성능좋은 데스크탑</strong></h1>
                                <h3 class="h2">오직 COM에서만 접할 수 있는 기회</h3>
                                <p>
                                  > 바로 보러가기
                                </p>
                            </div>                            
                        </div>                       
                    </div>
                </div>
            </div>
            
            <!-- 2번째 광고 -->
            <div class="carousel-item" onclick="location.href='${contextPath}/userfilter/product/searchByCategory?category=monitor'">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="${contextPath}/images/Advertisement/monitorAD.png" alt="">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left">
                                <h1 class="h1"><strong>[삼성전자] 오디세이 게이밍 모니터 G3 S27AG300M</strong></h1>
                                <h3 class="h2">현실처럼 즐기는 게임 플레이</h3>
                                <p>
                                    <strong>27인치 광시야각 와이드(16:9) 평면 모니터</strong>를 통해 
                                    현실보다 더 현실같은 게임을 플레이하세요!
                                </p>
                                <p> > 바로 보러가기 </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- 3번째 광고 -->
            <div class="carousel-item" onclick="location.href='${contextPath}/userfilter/product/searchByCategory?category=keyboard'">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="${contextPath}/images/Advertisement/keyboardAD.png" alt="">
                        </div>
                        
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left">
                                <h1 class="h1"><strong>비주얼과 타감을 </strong></h1>
                                <h1 class="h1"><strong>모두 갖춘 키보드는?</strong></h1>
                                <h3 class="h2"> COM에서 바로 만나보세요!</h3>
                                <p>
                                    > 바로 보러가기
                                </p>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
           
			<!-- 4번째 광고 -->
            <div class="carousel-item" onclick="location.href=${contextPath}/userfilter/product/searchByCategory?category=mouse'">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="${contextPath}/images/Advertisement/mouseAD.png" alt="">
                        </div>
                        
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left">
                                <h1 class="h1"><strong> 이 마우스는 </strong></h1>
                                <h1 class="h1"><strong> 아래에서 빛이 나요 </strong></h1>
                                <h3 class="h2"> 무지갯빛 클릭을 해보고 싶다면? </h3>
                                <p>
                                    <strong>[RAZER] 무선 게이밍 광마우스 Cobra Pro PKG 무선 마우스+충전독</strong>
                                </p>
                                <p>
                                    > 바로 보러가기
                                </p>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>  
        </div>
        <a class="carousel-control-prev text-decoration-none w-auto ps-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="prev">
            <i class="fas fa-chevron-left fa-3x" style="color: #59ab6e;"></i>
        </a>
        <a class="carousel-control-next text-decoration-none w-auto pe-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="next">
            <i class="fas fa-chevron-right fa-3x" style="color: #59ab6e;"></i>
        </a>
    </div>
    <!-- End Banner Hero -->


    <!-- Start Categories of The Month -->
    <section class="container py-5">
        <div class="row text-center pt-3">
            <div class="col-lg-6 m-auto">
                <h1 class="h1">최고 매출 제품 Top 3</h1>
                <p>
<!--                 	We've been waiting for you.  -->
<!--                 	This product is our top 3, chosen by us without any specific standards. -->
<!--                 	Experience COM's Premium products that are exclusively available.					 -->
						IT_Shop에서 제공하는 최고 성능과 최다 판매의 상품들을 소개합니다!
				</p>
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="#"><img src="${contextPath}/images/desktop/desktop1.jpg" class="rounded-circle img-fluid border"></a>
                <h5 class="text-center mt-3 mb-3">프리미엄 본체</h5>
                <p class="text-center"><a class="btn btn-success" onclick="location.href='${contextPath}/userfilter/product/detail?product_id=1'">구매 하기</a></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3"> 
                <a href="#"><img src="${contextPath}/images/keyboard/keyboard1.jpg" class="rounded-circle img-fluid border"></a>
                <h2 class="h5 text-center mt-3 mb-3">프리미엄 키보드</h2>
                <p class="text-center"><a class="btn btn-success" onclick="location.href='${contextPath}/userfilter/product/detail?product_id=31'">구매 하기</a></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="#"><img src="${contextPath}/images/monitor/monitor1.jpg" class="rounded-circle img-fluid border"></a>
                <h5 class="text-center mt-3 mb-3">프리미엄 마우스</h5>
                <p class="text-center"><a class="btn btn-success" onclick="location.href='${contextPath}/userfilter/product/detail?product_id=21'">구매 하기</a></p>
            </div>
        </div>
    </section>
    <!-- End Categories of The Month -->

<br><br>
<%@ include file="../include_css/userFooter.jsp"%>
