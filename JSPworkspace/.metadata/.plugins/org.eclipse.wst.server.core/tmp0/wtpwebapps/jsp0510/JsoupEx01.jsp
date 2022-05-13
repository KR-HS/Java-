<%@page import="kr.human.lunar.LunarUtil"%>
<%@page import="kr.human.lunar.LunarVO"%>
<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTML 파싱하기</title>
</head>
<body>
	<%

		String urlAddress = "https://astro.kasi.re.kr/life/pageView/5";
		// 문서 객체 얻기
		Document document= Jsoup.connect(urlAddress).get();
		out.println(document.title()+"<br>");
		
		Elements elements= document.select("table");
		out.println("테이블 개수 : " + elements.size()+"<br>");
		
		/* out.println("<table border='1'>");
		out.println(elements.get(0).html());
		out.println("</table>");
		 */
		 // 테이블 안에있는 tobdy태그 및의 tr들 얻기
		 Elements trs= elements.select("tbody tr");
		 out.println("TR 개수 : "+trs.size()+"개<br>");
		 
		 for(Element tr : trs){
			 //out.println(tr.text()+"<br>");
			 out.println(tr.select("td").get(1)+"<br>"); // 음력만
			 
		 }
		 LunarUtil util = new LunarUtil();
		 out.println(util.getLunarDate(2022, 5).get(1).getLunar());
	%>
</body>
</html>