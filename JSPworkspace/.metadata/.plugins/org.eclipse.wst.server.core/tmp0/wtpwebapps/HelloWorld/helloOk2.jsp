<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- POST전송의 경우 tomcat 9는 한글이 깨진다. 받을때 인코딩을 지정해주어야한다. --%>
	<%
		request.setCharacterEncoding("UTF-8");	

		// POST전송이 아니면 다른곳으로 보낸다.
		if(!request.getMethod().equals("POST")){
			response.sendRedirect("hello.jsp");
			return;
		}
		
		
		// name 속성만 모두 얻기
		Enumeration<String> names=request.getParameterNames();
		while(names.hasMoreElements()){
			out.println(names+"<br>");
			String name=names.nextElement(); // 이름 1개 얻기
			String[] values = request.getParameterValues(name); // 값 얻기
			out.println(name+" : "); // 이름속성 출력
			
			// 값 출력
			if(values!=null && values.length>0){
				for(String value : values){
					out.println(value+" ");
				}
				out.println("<br>");
			}
		}
	%>
	
</body>
</html>