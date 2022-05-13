<!-- %@로 시작하면 디렉티브라고 하고 환경설정시 사용 -->

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type = "text/javascript">
		/*
		$(function(){
			alert('Hello World!!!');
		});
		*/
		
	</script>

	<!-- %!로 시작하면 선언문이라고 한다. 메서드 선언시 사용. -->
	<%!
		public String now(){
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY년 MM월 DD일(E 요일)");
			return sdf.format(new Date());
		}
	%>

</head>
<body>
	<!-- %=으로 시작하면 표현식이라고 하고 무언가를 출력할때 사용! -->
	<!--  실행시간 : <%=new Date()%> -->
	<%-- JSP주석 --%>
	<h1>현재 시간 : <%=new Date().toLocaleString() %></h1>
	<h1>현재 시간 : <%=LocalDateTime.now() %></h1>
	<hr/>
	<h2><%="안녕 JSP" %></h2>
	<hr/>
	
	<!-- %로 시작하면 스크립트릿이라고 하고 자바 코드를 적는다 -->
	<%
		for(int i=2;i<=9;i++){
			for(int j=1;j<=9;j++)
				out.println(i+" * "+j+ " =  "+ i*j+"<br/>");
		}
	%>
</body>
</html>