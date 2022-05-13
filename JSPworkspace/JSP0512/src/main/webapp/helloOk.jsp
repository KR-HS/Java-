<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- VO로 한번에 받아보자 --%>
	<%--
		jsp:useBean 은 
		PersonVO = new PersonVO();
		request.setAttribute("vo",vo);
		와 같다.
	--%>
	
	<jsp:useBean id="vo" class="kr.human.vo.PersonVO" scope="request"/>
	
	<%-- vo의 setter를 불러줘야한다. --%>
	<%--
		property="*" 은 모든 setter를 불러준다.
	 --%>
	<jsp:setProperty property="*" name="vo"/>
	<%-- 특정 setter를 불러 직접 값 입력도 가능 --%>
	<jsp:setProperty property="ip" name="vo" value="<%=request.getRemoteAddr() %>"/>

	이름 : <jsp:getProperty property="name" name="vo"/><br>
	이름 : ${vo.name}<br/>
	내년 나이 : ${vo.age+1 }<br>
	성별: ${vo.gender?"남자":"여자" }<br>
	<hr/>
	${vo }
</body> 
</html>