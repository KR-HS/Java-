<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더값을 읽어보자</title>
</head>
<body>
	<h1> 모든 헤더정보 보기</h1>
	<%
	
		// 1개의 헤더값 얻기
		out.println(request.getHeader("user-agent")+"<br><hr>");
		// 모든 헤더의 이름 얻기
		Enumeration<String> headerNames = request.getHeaderNames();
		
		while(headerNames.hasMoreElements()){
			String headerName = headerNames.nextElement();			
			out.println(headerName+ " : ");
			
			// 값을 얻기
			Enumeration<String> headerValues=request.getHeaders(headerName);
			while(headerValues.hasMoreElements()){
				out.println(headerValues.nextElement()+"<br>");
			}
			out.println("<br><hr>");
		}
	%>
</body>
</html>