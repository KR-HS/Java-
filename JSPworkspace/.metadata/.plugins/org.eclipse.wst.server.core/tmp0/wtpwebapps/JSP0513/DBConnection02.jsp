<%@page import="kr.human.jdbc.JDBCUtil"%>
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
		Connection conn = null;  //연결
		Statement stmt = null;  //명령
		ResultSet rs = null;  //결과
		try{
			// 1. db에 연결한다.
			conn = JDBCUtil.getConnection();
			out.println("연결 성공 : " + conn+ "<br>");
			// 3. 사용
			String sql = "select now() date, 123*4 num, '한사람' name";
			stmt = conn.createStatement();
			// select 명령은 executeQuery()로 실행하고 ResultSet으로 받는다.
			// 그외의 명령은 executeUpdate()로 실행하고 int로 받는다.
			rs=stmt.executeQuery(sql);
			if(rs.next()){ // 결과 있다면
				do{
					out.println(rs.getString("date")+"<br>"); // 실행할 명령
					out.println(rs.getInt("num")+"<br>"); // 명령 객체 얻기 
					out.println(rs.getString("name")+"<br>"); // 명령을 실행해서 결과 받기
				}while(rs.next()); // 반복
			}else{
				out.println("없다<br>");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			// 4. 닫기
			JDBCUtil.close(rs);
			JDBCUtil.close(stmt);
			JDBCUtil.close(conn);
		}
		
	%>
</body>
</html>