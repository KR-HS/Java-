<%@page import="kr.human.guest.vo.GuestbookVO"%>
<%@page import="kr.human.guest.dao.GuestbookDAO"%>
<%@page import="kr.human.jdbc.JDBCUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DAO TEST</title>
</head>
<body>
	<%
	Connection conn = null;
	try{
		conn= JDBCUtil.getConnection();
		conn.setAutoCommit(false);
		//--------------------------------
		// 명령실행
		
		GuestbookVO vo = new GuestbookVO();
		vo.setName("한사람");
		vo.setPassword("1234");
		vo.setContent("호에에에에에에에엥");
		vo.setIp(request.getRemoteAddr());
		
		GuestbookDAO.getInstance().insert(conn,vo);
		
		int count = GuestbookDAO.getInstance().selectCount(conn);
		out.println("전체 : " +count+"개<br>");
		//--------------------------------
		
		GuestbookVO vo2 = GuestbookDAO.getInstance().selectByIdx(conn,1);
		if(vo2!=null){
			out.println("얻어온 값 : "+vo2+"<br>");
		}else{
			out.println("1번 데이터는 없습니다.<br>");
		}
		
		vo2=GuestbookDAO.getInstance().selectByIdx(conn,10000);
		if(vo2!=null){
			out.println("얻어온 값 : "+vo2+"<br>");
		}else{
			out.println("10000번 데이터는 없습니다.<br>");
		}
	
		conn.commit();
	}catch(SQLException e){
		JDBCUtil.rollback(conn);
		e.printStackTrace();
	}finally{
		JDBCUtil.close(conn);
	}
	%>
</body>
</html>