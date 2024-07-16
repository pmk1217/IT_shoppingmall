<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카트 목록 테스트</title>
</head>
<body>
    <c:forEach var="cart" items="${cartList}">
        <p>유저 아이디: ${cart.c_userId}</p>
        <p>상품 아이디: ${cart.c_productId}</p>
        <p>수량: ${cart.quantity}</p>
        <br>
    </c:forEach>
    
    <c:forEach var="product" items="${productList}">
        <p>상품명: ${product.name}</p>
        <p>가격: ${product.price}</p>
        <p>수량: ${product.quantity}</p>
        <br>
    </c:forEach>
</body>
</html>
