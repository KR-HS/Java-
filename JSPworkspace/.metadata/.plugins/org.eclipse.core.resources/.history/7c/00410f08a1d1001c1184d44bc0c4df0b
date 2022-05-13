<%@page import="kr.human.util.CookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// GET방식 요청을 막아보자!!!
		if(!request.getMethod().equals("POST")){ // POST 전송이 아니라면
			response.sendRedirect("login.jsp");
			return; // 이것을 생략하면 하단의 자바코드가 실행된다.
		}
	
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String saveid = request.getParameter("saveid");
		
		System.out.println(userid);
		System.out.println(password);
		System.out.println(saveid);
		
		// DB에서 데이터를 읽어서 로그인을 처리해야 하지만 
		// 아직 DB를 배우지 않았으므로 id와 password가 같으면 로그인 된것으로 가정하자!!!
		if(userid.equals(password)){
			// 로그인 성공!!!
			// 1. 로그인 정보를 세션에 저장한다. (나중에는 MemberVO객체 자체를 저장한다.)
			session.setAttribute("userid", userid);
			// 2. 아이디 자동 저장을 쿠키로 처리한다.
			Cookie cookie = null;
			if(saveid!=null && saveid.equals("true")){
				// 사용자 아이디를 1주일 동안 보관
				cookie = CookieUtil.createCookie("userid", userid, 60*60*24*7); 
			}else{
				cookie = CookieUtil.createCookie("userid", "", 0); // 쿠키 삭제 
			}
			response.addCookie(cookie);
			// 3. 페이지 이동
			response.sendRedirect("main.jsp");
			return;
		}else{
			out.println("<script>");
			out.println("alert('잘못된 정보입니다.');");
			out.println("location.href='login.jsp';");
			out.println("</script>");
		}
	%>
</body>
</html>