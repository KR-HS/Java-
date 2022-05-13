<%@page import="kr.human.util.CookieUtil"%>
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
		// 쿠키 저장
		CookieUtil cookieutil = new CookieUtil(request);
		response.addCookie(CookieUtil.createCookie("name","쿠키이름"));
		response.addCookie(CookieUtil.createCookie("value","쿠키값",60*60));
		
		// 쿠키 읽기
		CookieUtil cookieUtil = new CookieUtil(request);
		
		if(cookieUtil.exists("gender")){
			out.println(cookieUtil.getValue("gender")+"<br>");
		}else{
			out.println("gender 쿠키는 존재하지 않습니다.<br>");
		}
		
		if(cookieUtil.exists("name")){
			out.println(cookieUtil.getValue("name")+"<br>");
		}else{
			out.println("name 쿠키는 존재하지 않습니다.<br>");
		}
	%>
</body>
</html>