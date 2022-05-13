<%@page import="kr.human.util.CookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 아이디 자동 저장을 처리해 줘야 한다.
	// 1. 일단 모든 쿠키를 읽는다.
	CookieUtil cookieUtil = new CookieUtil(request);
	// 2. userid 쿠키값이 있는지 판단한다.
	String userid = "";
	if(cookieUtil.exists("userid")){
		userid = cookieUtil.getValue("userid");
	}
	// 3. 있으면 폼에 표시한다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 활용</title>
<!-- Bootstrap과 Jquery사용 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){ // window.onload
		$("#userid").focus();
	});
	// 입력값 검증하는 함수
	function formCheck(){
		var value = $("#userid").val(); // id값이 userid인 객체를 찾아 값을 가져온다.
		if(value==null || value.trim().length==0){ // 값이 없거나 공백만 입력되었다면
			alert('아이디는 반드시 입력해야 합니다.'); // 경고!!!
			$("#userid").val(""); // 값을 지우고
			$("#userid").focus(); // 커서를 이동하고
			return false; // 전송 취소
		}
		var value = $("#password").val();
		if(value==null || value.trim().length==0){
			alert('비밀번호는 반드시 입력해야 합니다.');
			$("#password").val("");
			$("#password").focus();
			return false;
		}
		return true;
	}
</script>
<style type="text/css">
	table {
		width: 400px; margin: auto; padding: 10px; border: 1px solid gray;
	}
	td.title {font-size: 14pt; background-color: silver; text-align: center; padding: 5px;}
	td{ padding: 5px;}
</style>
</head>
<body>
	<% 
	// 세션에 사용자 정보가 없으면 로그인 폼을 보여주고
	if(session.getAttribute("userid")==null){ 
	%>
	<form action="loginOk.jsp" method="post" onsubmit="return formCheck();">
		<table>
			<tr>
				<td colspan="2" align="center" class="title">로그인</td>
			</tr>		
			<tr>
				<td align="right">사용자 아이디</td>
				<td>
					<input type="text" name="userid" id="userid" required="required" value="<%=userid%>"/>
				</td>
			</tr>
			<tr>
				<td align="right">사용자 비밀번호</td>
				<td>
					<input type="password" name="password" id="password" required="required"/>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<label>
					아이디 자동저장 
					<%-- 쿠키값이 있으면 체크가 되어야하고 없으면 체크해제해야 한다. --%>
						<input type="checkbox" name="saveid" id="saveid" <%=userid!=null&&!userid.equals("") ? "checked='checked'":""%> value="true"/>
					</label>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="로그인" class="btn btn-sm btn-outline-success" />
				</td>
			</tr>
		</table>
	</form>
	<%}else{ // 사용자 정보가 있으면 사용자 정보를 보여준다. %>
		<table>
			<tr>
				<td colspan="2" align="center" class="title">회원정보</td>
			</tr>		
			<tr>
				<td align="right">사용자 아이디</td>
				<td>
					<%=session.getAttribute("userid")%>
				</td>
			</tr>
			<tr>
				<td align="right">사용자 정보</td>
				<td>
					이름 : 어쩌구저쩌구 <br />
					포인트/ 별명....
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="button" value="로그아웃" class="btn btn-sm btn-outline-success" onclick="location.href='logout.jsp'"/>
				</td>
			</tr>
		</table>	
	<%} %>
</body>
</html>