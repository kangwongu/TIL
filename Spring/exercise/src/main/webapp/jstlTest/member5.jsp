<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- 회원 정보를 jstl태그를 이용해 저장 --%>
<c:set var="id" value="saka"/>
<c:set var="pwd" value="1234"/>
<c:set var="name" value="${'bukayo saka'}"/>
<c:set var="age" value="${20}"/>
<c:set var="height" value="178"/>

<html>
<head>
	<title>JSTL 예제4</title>
</head>
<body>
  <table align="center" border=1>
    <tr align="center" bgcolor="lightgreen">
      <td width="7%"><b>아이디</b></td>
      <td width="7%"><b>비밀번호</b></td>
      <td width="7%"><b>이름</b></td>
      <td width="7%"><b>나이</b></td>
      <td width="7%"><b>키</b></td>
	</tr>
  <c:choose >
  	<c:when test="${empty name}">
  	  <tr>
  	    <td colspan=5>이름을 입력하세요!</td>
  	  </tr>
  	</c:when>
    <c:otherwise>
      <tr align="center">
	<%-- EL을 사용해 출력 --%>
        <td>${id}</td>
        <td>${pwd}</td>
        <td>${name}</td>
        <td>${age}</td>
        <td>${height}</td>
	  </tr>  
    </c:otherwise>
  </c:choose>
	  
  </table>
</body>
</html>