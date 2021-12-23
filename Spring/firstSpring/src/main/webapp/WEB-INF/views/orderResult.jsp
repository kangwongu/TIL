<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>주문서</title>
</head>
<body>
  <h1>주문내용</h1>
  <h3>배송정보</h3>
  <ul>
  	<li>이름 : ${order.name}</li>
  	<li>배송주소 : ${order.address}</li>
  	<li>이메일 : ${order.email}</li>
  	<li>연락처 : ${order.phone}</li>
  	<li>배송 지정 : ${order.date}</li>
  	<li>가입경로 : ${order.path}</li>
  	<li>메모 : ${order.memo}</li>
  </ul>
  <h3>상품정보</h3>
  <ul>
  	<li>상품 : ${order.product}</li>
  	<li>포장여부 : ${order.pack}</li>
  </ul>
</body>
</html>
