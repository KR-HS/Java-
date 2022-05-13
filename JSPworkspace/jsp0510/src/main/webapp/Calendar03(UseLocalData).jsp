<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="java.io.FileReader"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.human.lunar.LunarVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.human.lunar.LunarUtil"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만년달력 만들기 01</title>
<%
	// 년도와 월을 받는다.
	int year = LocalDate.now().getYear();
	int month = LocalDate.now().getMonthValue();
	try{
		year = Integer.parseInt(request.getParameter("yy"));
		month = Integer.parseInt(request.getParameter("mm"));
	}catch(Exception e){
		// 넘어온 값이 유효하지 않다면 현재의 년월을 가지자!!!
		year = LocalDate.now().getYear();
		month = LocalDate.now().getMonthValue();
	}
	// 월이 감소하다가 보면 0이하가 된다. 이때는 년도가 1감소하고 월을 12월로 만든다.
	if(month<=0){
		year--;
		month = 12;
	}
	// 월이 증가하다가 보면 13이상이 된다. 이때는 년도가 1증가하고 월을 1월로 만든다.
	if(month>=13){
		year++;
		month = 1;
	}
	
	if(year<=0){
		year = LocalDate.now().getYear();
	}
	System.out.println(year + "년 " + month + "월");
	//-------------------------------------------------------------------------------------
	//음력 데이터를 읽어온다.
	//List<LunarVO> list = LunarUtil.getLunarDate(year,month);
	// 인터넷이 아니라 저장된 경로에서 json파일을 읽어오자.
	// 서버의 경로 얻기
	String path = application.getRealPath("./data/");
	//파일 이름 만들기 : 202101.json
	String fileName=path+String.format("%04d%02d.json",year,month);
	
	//Gson을 이용해 읽어오자
	Gson gson = new Gson();
	FileReader fr = new FileReader(fileName);
	
	List<LunarVO> list= gson.fromJson(fr,new TypeToken<List<LunarVO>>(){}.getType());
	//--------------------------------------------------------------------------------------
	
	
	int lastDay=list.size();
	int week=list.get(0).getIntSolarWeek();

%>
<style type="text/css">
	table {
		width: 500px; margin: auto; border: none;border-spacing: 3px;
	}
	.title {
		font-size: 18pt; text-align: center; border: none; padding: 5px; background-color: white;
	}
	th { background-color: silver; border: 1px solid gray; padding: 5px;}
	td { border: 1px solid gray; padding: 5px; border-radius: 15px; text-align: center; height: 40px; }
	.lunar{font-size:5px;}
	
</style>
</head>
<body>
	<table>
		<tr>
			<th colspan="2" class="title">
				<a href="?yy=<%=year-1 %>&mm=<%=month%>"><img src="./images/previousYear.png" alt="prevYear" height=20px/></a> 
				<a href="?yy=<%=year %>&mm=<%=month-1%>"><img src="./images/previousMonth.png" alt="prevMonth" height=20px/></a>
			</th>
			<th colspan="3" class="title"><%=year %>년 <%=month %>월</th>
			<th colspan="2" class="title">
				<a href="?yy=<%=year %>&mm=<%=month+1%>"><img src="./images/nextMonth.png" alt="nextMonth" height=20px/></a>
				<a href="?yy=<%=year+1 %>&mm=<%=month%>"><img src="./images/nextYear.png" alt="nextYear" height=20px/></a>
			</th>
		</tr>
		<tr>
			<th width="100px" style='background-color:lightblue'>일</th>
			<th width="100px" style='background-color:lightblue'>월</th>
			<th width="100px" style='background-color:lightblue'>화</th>
			<th width="100px" style='background-color:lightblue'>수</th>
			<th width="100px" style='background-color:lightblue'>목</th>
			<th width="100px" style='background-color:lightblue'>금</th>
			<th width="100px" style='background-color:lightblue'>토</th>
		</tr>
		<tr>
			<%
				// 1일의 요일을 맞추기 위해 빈칸 출력
				for(int i=0;i<week;i++){
					out.println("<td class='blank_date' style='background-color:lightblue'>&nbsp;</td>");
				}
				// 1일부터 마지막 날짜까지 출력. 단 토요일이면 줄바꿈
				for(LunarVO vo : list){
					week = vo.getIntSolarWeek(); // 요일 : 0(일요일)
					if(week==0)
						out.println("<td style='color:red'>" + vo.getSolarDay()+"<div class='lunar'>"
									+vo.getLunarMonth()+"-"+vo.getLunarDay() + "("+vo.getGanjiDayCn()+")"+"</div></td>");
					else if(week==6)
						out.println("<td style='color:blue'>" + vo.getSolarDay() +"<div class='lunar'>"
								+vo.getLunarMonth()+"-"+vo.getLunarDay()+ "("+vo.getGanjiDayCn()+")"+"</div></td>");
					else
					out.println("<td>" + vo.getSolarDay() + "<div class='lunar'>"
							+vo.getLunarMonth()+"-"+vo.getLunarDay()+"("+vo.getGanjiDayCn()+")"+"</div></td>");
					
					if(week==6){ // 토요일이면
						out.println("</tr>"); //줄바꿈
						if(Integer.parseInt(vo.getSolarDay())<lastDay){ // 출력한 날짜가 마지막 날짜가 아니라면 새로운줄 추가
							out.println("<tr>");
						}
					}
				}
				if(week<6){
					for(int i=week;i<6;i++)out.println("<td style='background-color:lightblue'>&nbsp;</td>");
					out.println("</tr>");
				}
			%>
	</table>

</body>
</html>