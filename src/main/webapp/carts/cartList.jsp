<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List, user.cart.vo.UserCartVO"%>
    
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<% System.out.println("cartList.jsp 시작"); %>
<%	  
   HttpSession sessionCheck = request.getSession();
   Object loginInfo = sessionCheck.getAttribute("loginInfo");
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
    <link rel="stylesheet" href="${contextPath}/assets/css/fontawesome.min.css" >
    
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>

<title>COM</title>
<style type="text/css">
     <%@ include file="../assets/css/templatemo.css" %>
    <%@ include file="../assets/css/bootstrap.min.css" %>
    <%@ include file="../assets/css/templatemo.css" %>
	
	.cartContainer{
		display: flex;
		justify-content: center;		
	}
	
	table {   
	    border-radius: 10px; /* 테두리를 둥글게 만듦 */
	    border-spacing: 0; /* 테두리 간격을 0으로 설정 */	    
/* 	    margin-left:15px; */		
	    color: #1C1C1C;	    
	}
	
	table th, table td {
	    padding: 10px; /* 셀 내부의 여백 설정 */
	    border: 1px solid #E6E6E6; /* 셀의 테두리 설정 */
	}
    
    thead{
    	background-color: #DFEBE8;
    	text-align: center;    	
    }  
    
    tbody{
    	font-size: 15px;
    }
    
    .row0 {
	    text-align: center; /* 내부 요소를 가운데 정렬합니다. */
	}
	
	.row0 input[type="checkbox"] {
	    display: inline-block; /* 체크박스를 가운데 정렬하기 위해 inline-block 속성을 설정합니다. */
	    vertical-align: middle; /* 체크박스를 수직으로 가운데 정렬합니다. */
	}	    
    
    #row2, #row3, #row4{
    	text-align: center;
    }
    
    #row5 .row5Form {
	    display: flex;
	    align-items: center;
    	justify-content: center; /* 수평 가운데 정렬을 적용합니다. */
    	margin-left: 5px;
	}
    
    #row5 .row5Form form input[type="number"] {
   	 	width: 60px; /* 입력란의 너비를 조정할 수 있습니다. */ 
   	 	margin-left: 15px;  	 
	}
    
    #row5 .row5Form form{
    	display: inline-block; /* 각 버튼을 가로로 나란히 배치합니다. */
	}
     
    #modBtn{
    	background-color: #DEECE9; /* 원하는 색상 코드로 변경하세요 */
	    border: none; /* 버튼의 테두리를 제거합니다. */
	    border-radius: 8px;
	    font-size: 10px;
    	margin-left: -15px;
    	margin-top: 10px;
    } 
    
    #delBtn{
    	background-color: #DEECE9;
	    border: none; 
	    border-radius: 8px;
	    font-size: 10px;
    	margin-left: -35px;
    	margin-top: 42px;
    } 
    
    #delBtn:hover {
        background-color: #D9E4DF;
    }
    
    #modBtn:hover {
        background-color: #D9E4DF;
    }
     
    td#row1 span:hover {
	     background-color: #DDF3EE;
	     cursor: pointer; /* 마우스 커서를 포인터로 변경하여 사용자에게 클릭 가능함을 나타냄 */
    }      
    
	#row6 {
	    text-align: center; /* 내부 요소를 가운데 정렬합니다. */
	}
	
	#ordbtn {
	    display: inline-block; /* 버튼을 가운데 정렬하기 위해 inline-block 속성을 설정합니다. */
	    vertical-align: middle; /* 버튼을 수직으로 가운데 정렬합니다. */
    	background-color: #E7EDEC;
	    border: none; 
	    border-radius: 8px;
    }
    
    #ordbtn:hover {
        background-color: #D9E4DF;
    }
    
    #btns{
        display: flex;
	    align-items: center;
    	justify-content: flex-start; /* 수평 가운데 정렬을 적용합니다. */
    }
    
    img{
      width: 80px;
    }
    
    .product-info {
	    display: flex; /* 이미지와 텍스트를 가로로 나란히 배치합니다. */
	    align-items: center; /* 이미지와 텍스트를 수직으로 가운데 정렬합니다. */
	}
	
	.product-info img {
	    margin-right: 15px; /* 이미지와 텍스트 사이의 간격을 조절합니다. */
	}
	
    #text{
      margin-left: 10px;
    }
	
	#numrow {
   	 text-align: center; /* 텍스트를 가운데 정렬합니다. */
	}
	
	#totalInfo {
/*         margin-top: 20px; */
        padding: 20px;
        text-align: center;
        font-size: 24px;
        font-weight: bold;
        color: #333;
        background-color: #f5f5f5;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
	
	#buttonContainer {
    	display: flex;
		justify-content: center;	
	}
	
	#buttonContainer form, #buttonContainer form p {
	    display: inline-block; /* 폼 요소와 문단 요소를 인라인 블록으로 표시 */
	}
	
	#buttonContainer button {
	    margin: 0 10px; /* 버튼 사이의 여백 설정 */
	}
	
    /* paymentButton 스타일 */
    #paymentButton {
        margin-top: 20px;
        margin-bottom: 20px;
        padding: 15px 30px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 20px;
        transition: background-color 0.3s;
        text-align: center;
        width: 200px;
        margin: 0 auto;
    }
    
    #checkDeletetButton{
    	margin-top: 20px;
        margin-bottom: 20px;
        padding: 10px 20px;
        background-color: #AABFB3;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 15px;
        transition: background-color 0.3s;
        text-align: center;
        width: 100px;
        margin: 0 auto;
    }
 
    /* paymentButton 호버 효과 */
    #paymentButton:hover {
        background-color: #45a049;
    }
    
	#checkDeletetButton:hover {
        background-color: #99AAA0;
    }
		        
</style>

<script type="text/javascript">
	function DeleteBtn() {
	    var checkboxes = document.getElementsByName('chkbox');	
	    var checkedIds = [];
	
	    for (var i = 0; i < checkboxes.length; i++) {	        
	        if (checkboxes[i].checked) {	            
	            checkedIds.push(checkboxes[i].getAttribute('data-cartId'));	            	            
	        }
	    }
		
	    var selectedIdsString = checkedIds.join(',');
	   
	    
	    if (checkedIds.length === 0) {
	        alert("삭제할 상품이 없습니다.");
	        return;
	    }
		
	    var deleteForm = document.getElementById('deleteForm');	    
   
	    var hiddenInput = document.createElement('input');
		    hiddenInput.setAttribute('type', 'hidden');
		    hiddenInput.setAttribute('name', 'cart_id');
		    hiddenInput.setAttribute('value', selectedIdsString);		
			    
		deleteForm.appendChild(hiddenInput);		
		document.getElementById('deleteBtn').disabled = true;	
	    document.getElementById('deleteForm').submit();
	}
	
	 window.onload = function() {
	        calculateTotalPrice();
	 };
	 
	 
	function calculateTotalPrice() {
				    
	    var checkboxes = document.getElementsByName('chkbox');
	    var totalPrice = 0;
	    var selectedCount = 0;
	    for (var i = 0; i < checkboxes.length; i++) {
	        if (checkboxes[i].checked) {
	            var totalPriceElement = checkboxes[i].parentNode.nextElementSibling.
	            nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling;
	            var totalPriceText = totalPriceElement.textContent.trim();
	            var price = parseInt(totalPriceText.replace(/[^0-9]/g, ''));
	            totalPrice += price;
	            selectedCount++;
	        }
	    }
	    var formattedTotalPrice = totalPrice.toLocaleString();
	    var totalInfo = document.getElementById('totalInfo');
	    totalInfo.innerHTML = '<h5>선택된 상품 수 : ' + selectedCount + ' 개 <br>  선택된 상품의 총 가격 : <b>' + formattedTotalPrice + '</b> 원</h5>';
	}
</script>
</head>
<body>
<%@ include file="../include_css/userHeaderAfterLogin.jsp"%>

<br>
    <p><h3 id="text" style="margin-left: 250px;"> 장바구니 목록</h3></p>
	<p><h5 id="text" style="margin-left: 250px;"> 상품명을 클릭하면 상세페이지로 이동합니다 </h5></p>
	<hr>
		
	<br>
	
	<div class="cartContainer">
	<table>	
	    <colgroup> <!--  컬럼들을 하나의 그룹화 시켜줌 -->
			<col width="80" />
			<col width="80"/>
			<col width="650" />  		<!--  컬럼의 크기등을 세팅 -->
			<col width="130" />
			<col width="100" />
			<col width="130" />
			<col width="180" />
			<col width="110" />
		</colgroup>
		
    <thead>
        <tr>
        	<th class="row0" style="margin-left:10px;">		
	        	<form action="${contextPath}/user/cart/delete" method="post" id="deleteForm" name="deleteForm">
					<input type="hidden" name="cart_id" id="cart_id" value="">
					<button id="checkDeletetButton" onclick="DeleteBtn()">선택삭제</button>
				</form>
			</th>
        	<th>번호</th>
            <th>제품</th>
            <th>가격</th>
            <th>수량</th>
            <th>총 가격</th>
            <th>수정/삭제</th>
            <th>구매</th>
        </tr>
        
    </thead>
    
    <tbody>
        <c:choose>
            <c:when test="${cartList.size() < 1}">
                <tr><th colspan="8" style="text-align : center;"> 주문한 상품이 없습니다 </th></tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="product" items="${productList}" varStatus="status">  
                    <tr>                   
                     <c:set var="cartItem" value="${cartList[status.index]}" />
                    	<td class="row0">
                    		<input data-cartId="${cartItem.getCart_id()}" type="checkbox" value="${cartItem.getCart_id()}" name="chkbox" id="chkbox" checked="checked" onchange="calculateTotalPrice()" >
                    	</td>                            
                        <td id="numrow">${status.index + 1}</td>
                        
                        <td id="row1" onclick="location.href='<c:url value='/userfilter/product/detail?product_id=${product.getProduct_id()}' />'">
						    <div class="product-info">
						        <img src="${pageContext.request.contextPath}/images/${product.getCategory()}/${product.getImg()}">
						        <span>${product.getName()}</span>
						    </div>
						</td>

                        
                        <td id="row2"><fmt:formatNumber pattern="#,##0" value="${product.getPrice()}" />원</td>
                        
                     <c:set var="cartItem" value="${cartList[status.index]}" />
                     <c:set var="totalPrice" value="${totalPriceList[status.index]}" />
                       
                        <td id="row3">${cartItem.getQuantity()} 개</td>
                        
                        <td id="row4"><fmt:formatNumber pattern="#,##0" value="${totalPrice}" />원</td>
                        
                        <td id="row5">
                          <div class="row5Form"> 
                            <form action="${contextPath}/user/cart/modify" method="post">
                                <input type="hidden" name="cart_id" value="${cartItem.getCart_id()}">
                                <input type="number" name="quantity" id="box"  value="${cartItem.getQuantity()}"  min ="1" max="${product.getQuantity()}">개<br>
                                <input type="submit" id="modBtn" value="수정">
                            </form>
							<form action="${contextPath}/user/cart/delete" method="post">
							    <input type="hidden" name="cart_id" value="${cartItem.getCart_id()}">
							    <input type="submit" id="delBtn" value="삭제">
							</form>	
						  </div>
						</td>
						
                        <td id="row6">
                           	<form action="${contextPath}/user/order/insert" method="post">
								<input type="hidden" name="loginInfo" value="${loginInfo}">
								<input type="hidden" name="product_id" value="${cartItem.getC_productId()}">
								<input type="hidden" name="orderQuantity" value="${cartItem.getQuantity()}">	
							    <button type="submit" id="ordbtn">주문하기</button>
							</form>												
                        </td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </tbody>
</table>

</div>
<p></p>  
<br>    
<div id="totalInfo"><fmt:formatNumber pattern="#,##0" value="" /></div>
<!-- <p></p> -->
<!-- 		<div id="buttonContainer"> -->
<%-- 		<form action="${contextPath}/user/cart/delete" method="post" id="deleteForm" name="deleteForm"> --%>
<!-- 				<input type="hidden" name="cart_id" id="cart_id" value=""> -->
<!-- 				<button id="checkDeletetButton" onclick="DeleteBtn()">선택삭제</button> -->
<!-- 		</form> -->
<!-- 		<p></p> -->
<%-- <%-- 		<form action="${contextPath}/user/order/insert" method="post" id="orderForm" name="orderForm"> --%>
<%-- <%-- 				<input type="hidden" name="loginInfo" value="${loginInfo}"> --%>
<!-- <!-- 				<input type="hidden" name="product_id" value=""> -->
<!-- <!-- 				<input type="hidden" name="orderQuantity" value="">	 -->
<!-- <!-- 				<button id="paymentButton" onclick="orderBtn()">전체 결제</button> --> 
<!-- <!-- 		</form> -->
<!-- 			<button id="paymentButton" onclick="orderBtn()">전체 결제</button> -->
<!-- 		</div> -->
<p></p>
<%@ include file="../include_css/userFooter.jsp"%>


 <!-- Start Script -->
    <script src="${contextPath}/assets/js/jquery-1.11.0.min.js"></script>
    <script src="${contextPath}/assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="${contextPath}/assets/js/bootstrap.bundle.min.js"></script>
    <script src="${contextPath}/assets/js/templatemo.js"></script>
    <script src="${contextPath}/assets/js/custom.js"></script>
    <!-- End Script -->      
</body>
</html>
