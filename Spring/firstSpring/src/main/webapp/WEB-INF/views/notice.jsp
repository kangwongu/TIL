<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">

  <title>수습 국원 모집</title>
</head>
<body>
  <h1>수습 국원 모집</h1>
  <h2>방송에 관심 있는 새내기 여러분 환영합니다.</h2>
  <p>교내 방송국에서 신입생을 대상으로 수습국원을 모집합니다. 학부와 전공은 상관없습니다.
    <br>방송에 관심 있는 여러 학우의 지원바랍니다.
  </p>
  <ul>
    <li><b>모집 기간 </b>: 3월 2일 ~ 3월 11일</li>
    <li><b>모집 분야 </b>: 아나운서, PD, 엔지니어</li>
    <li><b>지원 방법 </b>: 양식 작성 후 이메일 접수</li>
    <i>지원서 양식은 교내 방송국 홈페이지 공지 게시판에 있습니다.</i>
  </ul>
  <h3>혜택</h3>
  <ol type="a">
    <li>수습기자 활동 중 소정의 활동비 지급</li>
    <li>정기자로 진급하면 장학금 지급</li>
  </ol>
  <img src="resources/images/mic.jpg" alt="카메라/마이크">
  <br>
  <a href="<c:url value="/apply"/>" target="_blank">지원하기</a>
</body>
</html>