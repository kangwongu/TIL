<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.fastcampus.exercise.*" %>
<%
	// 지역변수, EL은 지역변수 사용 불가 -> 저장소에 저장 후 사용
	Person person = new Person();
	request.setAttribute("person", person);
	request.setAttribute("name", "강원구");   
	request.setAttribute("list", new java.util.ArrayList());	
%>
<html>  
<head>   
	<title>EL</title>   
</head>  
<body>   
person.getCar().getColor()=<%=person.getCar().getColor() %> <br>
person.getCar().getColor()=${person.getCar().getColor()} <br>
person.getCar().getColor()=${person.car.color} <br>

<!-- request는 지역변수이기 때문에 EL에서 사용 불가, 따라서 request의 저장소인 requestScope사용 -->
name=<%=request.getAttribute("name") %> <br>
name=${requestScope.name} <br>
name=${name} <br>

id=<%=request.getParameter("id") %> <br>
<!-- request는 지역변수이기 때문에 EL에서 사용 불가, pageContext저장소에서 request를 참조하는 식으로 사용 -->
id=${pageContext.request.getParameter("id")} <br>
id=${param.id} <br>

<!-- 문자열 + 숫자 -->
"1" + 1 = ${"1"+1} <br> 			<!-- 숫자 -->
"1" += 1 = ${"1"+=1} <br>			<!-- 문자열 -->
"2" > 1 = ${"2">1} <br>
null = ${null} <br>
null+1 = ${null+1} <br>
null+null = ${null+null} <br>
"" + null = ${""+null} <br>
"" -1 = ${""-1} <br>
empty null = ${empty null} <br>		<!-- 비어있으면 true -->
empty list = ${empty list} <br>
null == 0 = ${null==0} <br>
null eq 0 = ${null eq 0} <br>
name == "강원구" = ${name=="강원구"} <br>
name eq "강원구" = ${name eq "강원구" } <br>
name != "강원구" = ${name != "강원구"} <br>
name ne "강원구" = ${name ne "강원구"} <br>
name.equals("강원구") = ${name.equals("강원구")} <br>
</body>
</html>