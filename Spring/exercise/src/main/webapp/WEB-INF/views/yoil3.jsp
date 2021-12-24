<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>요일 구하기</title>
</head>
<body>
  <h1>날짜를 입력하세요</h1>
  <form action="<c:url value="/yoil/result" />" method="GET">
    <fieldset>
      <legend>연,월,일</legend>
      <label for="year">연도</label>
      <input type="number" id="year" name="year" min="1950" max="2050">
      <label for="month">월</label>
      <input type="number" id="month" name="month" min="1" max="12">
      <label for="day">일</label>
      <input type="number" id="day" name="day" min="1" max="31">
    </fieldset>
    <div>
      <input type="submit" value="요일구하기">
      <input type="reset" value="다시 입력하기">
    </div>
  </form>
</body>
</html>
