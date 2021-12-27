<%@ page contentType="text/html;charset=utf-8" import="java.util.*"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
  List dataList = new ArrayList();
  dataList.add("Hello");
  dataList.add("World");
  dataList.add("안녕 세상");
%>

<c:set var="list" value="${dataList }"/>

<html>
<head>
	<title>JSTL 예제5</title>
</head>
<body>
  <c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
    i=${i}  &nbsp;&nbsp;&nbsp;  반복횟수: ${loop.count} <br>
  </c:forEach>
  <br>
  
  <c:forEach var="i" begin="1" end="10" step="2">
    5*${i} = ${5*i} <br>
  </c:forEach>
  <br>
  
  <c:forEach var="data" items="${list}">
    ${data} <br>
  </c:forEach>
	


</body>
</html>