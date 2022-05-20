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
	<%-- forEach는 반복할때 사용 --%>
	
	<c:forEach var="name" items="한놈,두식이,석삼,너구리">
		<div> ${name }</div>
	</c:forEach>
	<hr>
	<%
		request.setAttribute("names","한놈,두식이,석삼,너구리".split(","));
	%>
	<c:forEach var="name" items="${names }">
		<div>${name }</div>
	</c:forEach>
	<hr>
	
	<c:forEach var="name" items="${names }" begin="1" end ="2">
		<div>${name }</div>
	</c:forEach>
	<hr>
	<%--
			varStatus : 반복횟수와 인덱스를 알아낼 수 있다. 
			varStatus에서 설정해준 변수명.count는 반복횟수, 변수명.index는 인덱스값
	--%>
	<c:forEach var="name" items="${names }" begin="0" end ="2" varStatus="vs">
		<div>${vs.count}-${vs.index} : ${name }</div>
	</c:forEach>
	<hr>
</body>
</html>