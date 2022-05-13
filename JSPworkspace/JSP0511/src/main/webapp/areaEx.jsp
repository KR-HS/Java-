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
		int i=100;
		pageContext.setAttribute("i",200);
		request.setAttribute("i", 200);
		session.setAttribute("i",400);
		application.setAttribute("i",500);
	%>
	현재 파일의 변수 값 : <%=i %><br>
	페이지 영역의 변수값 : <%=pageContext.getAttribute("i") %><br>
	request 영역의 변수값 : <%=request.getAttribute("i") %><br>
	session 영역의 변수값 : <%=session.getAttribute("i") %><br>
	application 영역의 변수값 : <%=application.getAttribute("i") %><br>
	
	<hr>
	<h2> EL을 쓰면 편리(EL로 값을 출력하려면 반드시 영역에 저장)</h2>
	변수값 : ${i }<br>
	페이지 영역의 변수값 : ${pageScope.i }<br>
	request 영역의 변수값 : ${requestScope.i }<br>
	session 영역의 변수값 : ${sessionScope.i }<br>
	application 영역의 변수값 : ${applicationScope.i}<br>
	
	<%
		pageContext.forward("areaEx2.jsp");
	%>
</body>
</html>