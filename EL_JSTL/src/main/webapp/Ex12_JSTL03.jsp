<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 예외처리 --%>
	<c:catch var="e">
		<%=12/3 %>
	</c:catch>
	<hr>
	
	<c:catch var="e">
		<%=12/0 %>
	</c:catch>
	

	<c:if test="${not empty e }">
		에러 발생 ${e} : ${e.message }
	</c:if>
	
	<hr>
	<!-- EL에서 정수 연산시 실수의 결과가 나온다.
		 아래 식은 12/0 => inf가 나옴
	 -->
	<c:catch var="e">
		12 / 0 = ${12/0 }
	</c:catch>
	

	<c:if test="${not empty e }">
		에러 발생 ${e} : ${e.message }
	</c:if>
	
</body>
</html>