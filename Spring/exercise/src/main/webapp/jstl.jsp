<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>JSTL</title>
</head>
<body>
<!-- 저장소에 저장한 것, scope="page"가 생략, EL이 지역변수를 사용못하기 때문에 저장소에 저장 -->
<c:set var="to" value="10"/>						<!-- 변수 선언/초기화 -->
${to} <br>
<c:set var="arr" value="10,20,30,40,50,60,70"/>		<!-- 배열 선언/초기화 -->
${arr} <br>		
<c:forEach var="i" begin="1" end="${to}">			<!-- 반복문 -->
	${i}
</c:forEach>
<br>

<c:if test="${not empty arr}">						<!-- 조건문/반복문 -->
	<c:forEach var="elem" items="${arr}" varStatus="status">
		${status.count}.arr[${status.index}]=${elem} <br>
	</c:forEach>
</c:if>
<br>
<c:if test="${param.msg!=null}">					<!-- 요청으로 msg값이 있다면 출력 -->
	msg=${param.msg}
	msg=<c:out value="${param.msg}"/>				<!-- 매개변수로 태그가 들어와도 해석x -->
</c:if>
<br>
<c:if test="${param.msg==null}">메세지가 없습니다.<br></c:if>
<c:set var="age" value="${param.age}"/>				<!-- 요청으로 들어온 age값을 변수age에 저장 -->
<c:choose>											<!-- if-else문 -->
	<c:when test="${age>=19}">성인입니다.</c:when>
	<c:when test="${0<=age && age<19 }">성인이 아닙니다.</c:when>
	<c:otherwise>값이 유효하지 않아요</c:otherwise>
</c:choose>
<br>
<c:set var="now" value="<%=new java.util.Date() %>"/>
Server time is <fmt:formatDate value="${now}" type="both" pattern="yyyy/MM/dd HH:mm:ss"/>

</body>
</html>