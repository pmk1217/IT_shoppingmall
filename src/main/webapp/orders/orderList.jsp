<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<style>
.cartContainer{
      display: flex;   
      width: 75%;
      margin: 0 auto;
   }
   
   table {   
       border-radius: 10px; /* 테두리를 둥글게 만듦 */
       border-spacing: 0; /* 테두리 간격을 0으로 설정 */       
/*        margin-left:15px; */      
       color: #1C1C1C;       
   }
   
   table th, table td table tr {
       padding: 10px; /* 셀 내부의 여백 설정 */
       border: 1px solid #E6E6E6; /* 셀의 테두리 설정 */
       height: 50px;
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
      margin-left: 20px;
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
       margin-left: 230px;
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
        padding: 15px 30px;
        background-color: red;
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

    /* paymentButton 호버 효과 */
    #paymentButton:hover {
        background-color: #45a049;
    }
    
   #checkDeletetButton:hover {
        background-color: #DF0101;
    }

   #Ordertext{
     margin-left: 15px;
   }
   
   #orderTable {
       border-spacing: 0; /* 테두리 간격을 0으로 설정 */       
       margin-left:15px;
       color: #1C1C1C;       
   }
   
   table th, table td {
       border: 1px solid #E6E6E6; /* 셀의 테두리 설정 */
        white-space: normal;
          overflow: hidden;
          text-overflow: ellipsis;
   }  
   
    #orderthead{
       background-color: #DFEBE8;
       text-align: center;       
    }  
    
    #ordertbody{
       font-size: 15px;
    }
      
      #ordCancel{
         display: inline-block; /* 버튼을 가운데 정렬하기 위해 inline-block 속성을 설정합니다. */
       vertical-align: middle; /* 버튼을 수직으로 가운데 정렬합니다. */
         background-color: #E7EDEC;
       border: none; 
       border-radius: 8px;
       margin-top : 12px;
       margin-left : 6px;
      }
          #ordCancel:hover {
        background-color: #D9E4DF;
    }
</style>
<%@ include file="../include_css/userHeaderAfterLogin.jsp"%>

<p></p>

    <p><h3 id="text" style="margin-left: 250px; padding-top: 30px;"> 주문 목록</h3></p>
   <p><h5 id="text" style="margin-left: 250px; padding-bottom: 30px;"> 구매해주셔서 감사합니다 </h5></p>
   <hr>
   <br>
   
        <div class="cartContainer">        
                
                <table id="pdtable" style="margin: 0 auto; table-layout: fixed;">   
                    <colgroup>
                     <col width="70" />
                     <col width="200"/>
                     <col width="100" /> 
                     <col width="500" />
                     <col width="150" />
                     <col width="100" />
                     <col width="150" />
                     <col width="100" />
                  </colgroup>

        <thead id="orderthead">
                <tr>
                    <th>주문번호</th>
                    <th>주문일자</th>
                    <th>주문상태</th>
                    <th>상품명</th>
                    <th>상품가격</th>
                    <th>상품갯수</th>
                    <th>총 금액</th>
                    <th>상태</th>
                </tr>
            </thead>
    
    <tbody>
       <c:choose>
          <c:when test="${orderList.size() < 1}">
                 <tr> <td colspan="8">상품이 없습니다</td> </tr>
          </c:when>
          <c:otherwise>
    
                 <c:forEach var="order" items="${orderList}" varStatus="status">
                    <tr style="height: 50px;">
                        <td align="center"><c:out value="${orderList[status.index].order_id}" /></td>
                        <td align="center"><c:out value="${fn:substring(orderList[status.index].created_at, 0, 16)}" /></td>
                        <td align="center">
                            <c:choose>
                                <c:when test="${orderList[status.index].orderProcess eq 0}">
                                    결제 대기
                                </c:when>
                                <c:when test="${orderList[status.index].orderProcess eq 1}">
                                    결제 승인
                                </c:when>
                                <c:when test="${orderList[status.index].orderProcess eq 2}">
                                    결제 취소
                                </c:when>
                            </c:choose>
                        </td>
                        
                        <td align="center"><c:out value="${productList[status.index].name}" /></td>
                        
                        <td align="center"><fmt:formatNumber pattern="#,##0" value="${productList[status.index].price}" />원</td>
                        
                        <td align="center"><c:out value="${orderList[status.index].quantity}개" /></td>
                        
                        <td align="center"><fmt:formatNumber pattern="#,##0" value="${productList[status.index].price * orderList[status.index].quantity}" />원</td>
                         
                         <td>
                         <c:if test="${orderList[status.index].orderProcess eq 0}">
                            <form action="${contextPath}/user/order/delete"  method="post">
                               <input type="hidden" name="order_id" value="${orderList[status.index].order_id}">
                               <input type="submit" id="ordCancel" value="주문취소">
                            </form>
                         </c:if>
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
<div id="totalInfo">
   <fmt:formatNumber pattern="#,##0" value="" />
</div>
<p></p>
      
<p></p>
<%@ include file="../include_css/userFooter.jsp"%>