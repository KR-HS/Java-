<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
		String driverName="org.mariadb.jdbc.Driver";
		// jdbc:mariadb://서버아이피:포트번호/DB이름
		String url="jdbc:mariadb://localhost:3306/jspdb";
		String user="jspuser";
		String password="123456";
	
		// 1. 드라이버를 로드한다.
		Class.forName(driverName);
	
		Connection conn = null; // 연결
		Statement  stmt = null; // 명령
		ResultSet  rs = null;   // 결과
		try{
			// 2. DB에 연결한다.
			conn = DriverManager.getConnection(url, user, password);
			out.println("연결 성공 : " + conn + "<br>");
			// 3. 사용
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			// 4. 닫기
			if(conn!=null) try{ conn.close(); }catch(SQLException e){ ; }
		}
	
	%>
</body>
</html>