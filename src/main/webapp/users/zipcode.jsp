<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 찾기</title>
<script type="text/javascript">
function test(zipcode, area){
	window.opener.document.getElementById("zipcode").value = zipcode;
	window.opener.document.getElementById("address").value = area;
	window.close();
}
</script>
</head>
<body>
	<form action="${contextPath}/userfilter/action/zipcode" method="post">
		<div align="center" >
			<input type="text" name="zip_area3">
			<input type="submit" value="검색">
		</div>
		
		 <div align="center">
			<p>- 검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.</p>
		</div>
			<c:forEach var="zip" items="${zipList}" varStatus="status">
					<p align="left" ><a href="#"  onclick="test('${zip.zipcode }','${zip.area }')">${zip.getZipcode()} ${zip.getArea()}</a></p>
			</c:forEach>
			
		<div align="center">
			<input type="button" value="닫기" onclick="window.close()">
		</div>
		<!-- window.opener.document.getElementById("부모").value = document.getElementById("자식").value
			window.close()
		-->
	</form>
</body>
</html>