<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="helloOk.jsp" method="post"> <%-- action속성 : 서버에서 요청을 받아줄 이름 --%>
		<!--  name과 value속성 반드시 필요 -->
		이름 : <input type="text" name="name"/>
		<br/>
		나이 : <input type="number" name="age"/><br/>
		취미 :
		<label><input type="checkbox" name="hobby" value="술마시기" id="hobby1"/>술마시기 </label>
		<input type="checkbox" name="hobby" value="노래하기" id="hobby2"/>
		<label for="hobby2">노래하기</label>
		<input type="checkbox" name="hobby" value="춤추기" id="hobby3"/>춤추기
		<input type="checkbox" name="hobby" value="잠자기" id="hobby4"/>잠자기
		<br/>
		성별 : <%-- radio는 value와  --%>
		<label> <input type="radio" value="true" name="gender" checked="checked"/> 남자</label>
		<label> <input type="radio" value="false" name="gender"/> 여자</label>
		<br/>
		<input type="submit" value="전송하기"/>

	</form>
</body>
</html>