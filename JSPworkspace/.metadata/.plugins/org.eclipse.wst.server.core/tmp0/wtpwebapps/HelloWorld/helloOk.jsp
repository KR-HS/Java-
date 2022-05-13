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
		
	%>
	전송 방식 : <%=request.getMethod() %><br/><hr/>

	<%
		String name=request.getParameter("name"); // 요청 정보를 받는다. (String)
		

		if(name!=null && name.trim().length()>0){
			out.println(name+"님 환영합니다.");
		}else{
			out.println("손님 환영합니다.");
		}
		String hobby = request.getParameter("hobby");
		out.println("<br>취미 : "+hobby+"<br>");
		
		//name 속성의 값이 같은것이 여러개 존재하면 배열로 받아야 한다.
		String[] hobbys = request.getParameterValues("hobby");
		// 반드시 넘어온 값이 있는지 확인해서 처리.
		if(hobbys!=null){
			for(String h:hobbys){
				out.print(h+" ");
			}
		}
		
	%>
	</br>
	성별 : <%= request.getParameter("gender") %><br/>
</body>
</html>