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
	<title>JSTL 예제3</title>
</head>
<body>
  <c:if test="${true}">
    <h1>항상 참입니다.</h1>
  </c:if>
  
  <%-- <c:if test="11!=11"> EL 안써도 잘 작동함  --%>
  <c:if test="${11==11}">
  	<h1>두 값은 같아요</h1>
  </c:if>
  
  <c:if test="${11!=21}">
  	<h1>두 값은 같지 않죠</h1>
  </c:if>
  
  <c:if test="${(id=='saka') && (name=='bukayo saka')}">
  	<h1>아이디는 ${id}이고 이름은 ${name}이에요</h1>
  </c:if>
  
  <c:if test="${age==20}">
  	<h1>이름은 ${name}이고 나이는 ${age}살이에요</h1>
  </c:if>
  
  <c:if test="${age>=20}">
  	<h1>${name}는 겨우 ${age}살이에요</h1>
  </c:if>
  
  <c:if test="${height < 180}">
  	<h1>${name}은 아쉽게도 키가 180이 넘지 않아요. 그는 ${height}이에요</h1>
  </c:if>
  
</body>
</html>