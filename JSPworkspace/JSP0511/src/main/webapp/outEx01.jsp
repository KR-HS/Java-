<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name=request.getParameter("name");
	
		// out객체가 없다면
		if(name ==null || name.trim().length()==0){
	%>
		name does not exist. <br>
	<%} else{ %>
	<%= name %>님 반가워요<br><% }  %><hr>
</body>
</html>