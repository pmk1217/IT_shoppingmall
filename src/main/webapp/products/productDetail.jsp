<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page import="user.product.vo.UserProductVO"%>
<%
    System.out.println("productDetail.jsp 실행 중 : " + "");    
%>

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
 
 
 <script>
   // cartQuantity의 value 가져오기
   // cartQuantity의 value 가져오기
// cartQuantity의 value 가져오기
function inputValueChange() {
    var cartQuantityValue = document.getElementById('cartQuantity').value;
    console.log(cartQuantityValue);
    document.getElementById('orderQuantity').value = cartQuantityValue;
}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('orderbtn').onclick = function() {
        var maxQuantity = parseInt(`${ProductVO.getQuantity()}`);
        var currentQuantity = parseInt(document.getElementById('cartQuantity').value);
        if (currentQuantity > maxQuantity) {
            alert("최대 수량을 초과하였습니다.");
            return false; // 서블릿으로 이동하지 않도록 false를 반환
        }
        if (currentQuantity < 1 ){
            alert("주문 수량은 1이하가 될 수 없습니다.");
            return false; // 서블릿으로 이동하지 않도록 false를 반환
        }
    };
});

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('cartbtn').onclick = function() {
        var maxQuantity = parseInt(`${ProductVO.getQuantity()}`);
        var currentQuantity = parseInt(document.getElementById('cartQuantity').value);
        var cartVoQuantity = parseInt(`${CartVO.getQuantity()}`);
        var limitQuantity = maxQuantity - cartVoQuantity;
        if (currentQuantity + cartVoQuantity > limitQuantity) {
        	var what = currentQuantity + cartVoQuantity;
        	alert(limitQuantity);
        	alert(what);
        	alert(maxQuantity);
            alert(limitQuantity + "개만 담을 수 있습니다.");
            return false; // 서블릿으로 이동하지 않도록 false를 반환
        }
        if (currentQuantity < 1 ){
            alert("주문 수량은 1이하가 될 수 없습니다.");
            return false; // 서블릿으로 이동하지 않도록 false를 반환
        }
    };
});


</script>
 <p></p>
     <div class="product-container">
         <div class="product-img">
               <img src="${contextPath}/images/${ProductVO.getCategory()}/${ProductVO.getImg()}">
         </div>
         
         <div class="product-content">
                     
                        <p><h2>${ProductVO.getName()}</h2></p>
                        <hr>
                        
                        <p><b>상세설명</b></p>
                        <hr>
                        <p>${ProductVO.getContent()}</p>
                         <br>
                         
                        <p><b>가격 </b><fmt:formatNumber pattern="#,##0" value="${ProductVO.getPrice()}" />원</p>
                        
                        <c:choose>
                           <c:when test="${ProductVO.getQuantity() == 0}">
                              <br>
                              <h3>해당 상품의 재고가 없습니다.</h3>
                           </c:when>
                           
                           <c:otherwise>
                              <form action="${contextPath}/user/cart/insert" method="post">
                                 <p>
                                     <b>수량 </b>
                                    <input type="number" name="quantity" onchange="inputValueChange()" id="cartQuantity" value="1" min="1" max="${ProductVO.getQuantity()}" required>
                                    개
                                 </p>                  
                              <br>                                          
                                 <input type="hidden" name="c_userId" value="${loginInfo}">
                                 <input type="hidden" name="c_productId" value="${product_id}">         
                                 <input type="submit" id="cartbtn" value="장바구니 추가">
                              </form>
                           
                              <form action="${contextPath}/user/order/insert" method="post" id="orderForm">
                                 <input type="hidden" name="loginInfo" value="${loginInfo}">
                                 <input type="hidden" name="product_id" value="${ProductVO.getProduct_id()}">
                                 <input type="hidden" name="orderQuantity" id="orderQuantity" value="" >    
                            	 <input type="submit" id="orderbtn" value="바로 주문하기">

                              </form>
                           </c:otherwise>
                        </c:choose>
                           
         </div><br>
     </div>
     <p></p>
<%@ include file="../include_css/userFooter.jsp"%>
