<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력</title>
</head>
<body>
	<h2>구구단을 출력하자</h2>
	<form action="?"> 	<%-- action에서 ?는 자기자신을 의미 --%>
		몇단?
		<select name="dan">
			<option value="2">2 단</option>
			<option value="3">3 단</option>
			<option value="4">4 단</option>
			<option value="5">5 단</option>
			<option value="6">6 단</option>
			<option value="7">7 단</option>
			<option value="8">8 단</option>
			<option value="9">9 단</option>	
		</select>
		
		<input type="submit" value="입력">
	</form>
	<hr/>
	<%-- 데이터를 받아서 여기에 출력해보자 --%>
	<%
		int dan=0;
		try{
			dan=Integer.parseInt(request.getParameter("dan"));
			
		}catch(Exception e){
			;
		}
		if(dan<=0){
			out.println("<h2 style='color:red;'> 정확한 값을 전달해 주세요!");
		}
		
		else{
			out.println("<h2 style='color:blue;'>"+dan+"단</h2>");
			for(int i=1;i<=9;i++){
				out.println("<ol>"+dan+" * "+i+" = "+ dan*i+"</ol>");
			}
		}
	%>
	
	
</body>
</html>
