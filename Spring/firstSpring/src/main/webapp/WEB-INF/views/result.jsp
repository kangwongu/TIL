<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>수습 국원 지원 확인서</title>
</head>
<body>
  <h1>수습 국원 지원 내용 확인</h1>
  <table>
    <tr>
      <th rowspan="3">개인정보</th>
      <th>이름</th>
      <td>${name}</td>
    </tr>
    <tr>
      
      <th>학과/학번</th>
      <td>${id}</td>
    </tr>
    <tr>
      
      <th>연락처</th>
      <td>${phoneNumber}</td>
    </tr>
    <tr>
      <th>지원 분야</th>
      <td colspan="2">${check}</td>
      
    </tr>
  </table>
</body>
</html>
