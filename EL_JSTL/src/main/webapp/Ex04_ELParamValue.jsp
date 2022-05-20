<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSTL을 사용하려면 태그라이브러리 디렉티브를 써야한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>주소표시줄 뒤에 ?n=12&m=34&n=56&m=78 를 붙여 실행</h2>
	
	n=${param.n }<br>
	m=${param.m }<br>
	
	${paramValues.n }<br>
	${paramValues.m }<br>
	<hr>
	
	<c:forEach var="i" items="${paramValues.n }">
		n=${i}<br>
	</c:forEach>
	
	<c:forEach var="i" items="${paramValues.m }">
		m=${i}<br>
	</c:forEach>
</body>
</html>