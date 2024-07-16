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
   .box {
          width:200px;
          border-radius:10px;
          padding: 10px;
          box-sizing: border-box; 
          margin:0 auto;
          display:flex;
          padding:20px;
          color:white;
          box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
          transition: all 0.3s cubic-bezier(.25,.8,.25,1);
      }
      .box:hover {
            box-shadow: 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22);
            cursor: pointer;
      }
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
      width: 210px;
      height: 200px;
      padding:5px;
   }
</style>
      
      <%@ include file="./adminInclude/adminHeader.jsp"%>
      <%@ include file="./adminInclude/adminAside.jsp" %>
         <style>
            td {
               white-space: normal;
               border: none;
            }
         </style>
         
      <div class="container" >
      <section>
                 <div style="display: flex; width: 85%; justify-content: space-between;"> 
              
                  <div class="box" style="background-color: #0058ff;" onclick="location.href='${contextPath}/admin/member/selectAll'">
                  <i class="fas fa-user fa-6x"></i>
                  <div style="text-align: center; margin: 0 auto;">
                     <h2>회원 수</h2> <h1 style="font-size: 50px; font-weight: bold;"> <c:out value="${userCount}"/></h1>
                     </div>               
                 </div>
                 
                 <div class="box" style="background-color: green;" onclick="location.href='${contextPath}/admin/product/selectAll'">
                  <i class="fas fa-gift fa-6x"></i>
                  <div style="text-align: center; margin: 0 auto;">
                     <h2>상품 수</h2> <h1 style="font-size: 50px; font-weight: bold;"> <c:out value="${productCount}"/></h1>
                     </div>               
                 </div>      
           </div>

             
        <div style="width: 95%;"> 
           <h1 style="margin-top: 50px; margin-bottom: 20px; font-size: 30px; font-weight: bold;">재고가 거의 남지 않았습니다.</h1> <hr>
           <table id="pdtable" style="display:flex;  flex-wrap : wrap; margin: 0 auto;">
              <c:choose>
               <c:when test="${empty productQuantity}">
                           <!-- if() 부분 -->
                           <tr>
                              <td align="center"  width="1000px;">등록된 상품이 없습니다.</td>
                           </tr>
               </c:when>
             <c:otherwise>     
                     <c:forEach items="${productQuantity}" var="product"  varStatus="status">
                     <c:if test="${status.index < 5}">
                        <tbody style="margin-left: 18px; margin-bottom: 15px; margin-top:20px; border: 1px solid #c5c5c5; width: 210px; padding-left: 10px; padding-right: 10px;">
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
                                    <td align="left" style="color: black; font-size: 13px; font-weight:bold; padding-bottom: 5px; padding-top: 5px; ">재고 수 : ${product.getQuantity()}개</td>                       
                             </tr>
                                <tr>
                                  <td style="color: red; font-size: 18px; font-weight:bold; text-align: right;"><fmt:formatNumber pattern="#,##0" value="${product.getPrice()}" />원</td>
                                    <!--c:out  -->
                              </tr> 
                           </tbody>        
                           </c:if>          
                    </c:forEach>
               </c:otherwise>
             </c:choose>     
            </table>
      </div>
         <div style="width: 95%;"> 
             <h1 style="margin-top: 50px; margin-bottom: 20px; font-size: 30px; font-weight: bold;">인기가 가장 많은 상품</h1> <hr>
             <table id="pdtable" style="display:flex;  flex-wrap : wrap; margin: 0 auto;">
              <c:choose>
               <c:when test="${empty productLikes}">
                           <!-- if() 부분 -->
                           <tr>
                              <td align="center"  width="1000px;">등록된 상품이 없습니다.</td>
                           </tr>
               </c:when>
             <c:otherwise>     
                     <c:forEach items="${productLikes}" var="product"  varStatus="status">
                     <c:if test="${status.index < 5}">
                        <tbody style="margin-left: 18px; margin-bottom: 15px; margin-top:20px; border: 1px solid #c5c5c5; width: 230px; height: 390px;">
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
                                <td>
                                    <input class="fas fa-heart"   style="color: red; margin-left: 2px;" type="button"  id="likeButton${product.getProduct_id()}" value="좋아요" onclick="handleLike('${product.getProduct_id()}')" />
                                    <b id="likes${product.getProduct_id()}" style="font-size: 14px; margin-left: 1px;">${product.getLikes()} </b>
                                    </td>
                                  <td style="color: red; font-size: 18px; font-weight:bold; text-align: right;"><fmt:formatNumber pattern="#,##0" value="${product.getPrice()}" />원</td>
                                    <!--c:out  -->
                              </tr> 
                           </tbody>        
                           </c:if>          
                    </c:forEach>
               </c:otherwise>
             </c:choose>     
            </table>
             </div>
      </section>  
      </div>
      