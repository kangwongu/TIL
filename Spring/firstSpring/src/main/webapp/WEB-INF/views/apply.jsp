<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>수습 국원 지원서</title>
</head>
<body>
  <h1>수습 국원 지원 양식</h1>
  <h2>개인정보</h2>
  <form action="<c:url value="/apply"/>" method="POST">
    <ul>
      <li>
        <label for="name">이름</label>
        <input type="text" id="name" name="name">
      </li>
      <li>
        <label for="id">학과/학번</label>
        <input type="text" id="id" name="id">
      </li>
      <li>
        <label for="phoneNumber">연락처</label>
        <input type="text" id="phoneNumber" name="phoneNumber">
      </li>
    </ul>
  
  <h2>지원 분야</h2>
	  <label><input type="checkbox" id="check" name="check" value="PD">PD</label>
	  <label><input type="checkbox"	id="check" name="check" value="아나운서">아나운서</label>
	  <label><input type="checkbox"	id="check" name="check" value="엔지니어">엔지니어</label>
	  <input type="submit" value="제출하기">
  </form>
</body>
</html>