<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
 
  <title>제목태그</title>
</head>
<body>
  <img src="images/tangerines.jpg" alt="레드향">
  <audio src="medias/spring.mp3" controls></audio>
  <h1>레드향</h1>
  <p>껍질에 붉은 빛이 돌아 <b>레드향</b>이라 불린다.</p>
  <p>레드향은 <em>한라봉과 귤을 교배</em>한 것으로 <br>일반 귤보다 2~3배 크고, 과육이 붉고 통통하다.</p>
  <blockquote><i>비타민 C</i>와 <i>비타민 P</i>가 풍부해 
    <br><strong>혈액순환, 감기예방</strong> 등에 좋은 것으로 알려져 있다.</blockquote>
  
  <h2>레드향 샐러드 레시피</h2>
    <p><b>재료:</b> 레드향 1개, 아보카도 1개, 토마토 1개, 샐러드 채소 30g</p>
    <p><b>드레싱:</b> 올리브유 1큰술, 레몬즙 2큰술, 꿀 1큰술, 소금 약간</p>
    <h4>재료준비</h4>
    <ol type="a">
      <li>샐러드 채소를 씻어 물기를 제거한 후 먹기 좋게 썰어서 준비합니다.</li>
      <li>레드향과 아보카도, 토마토도 먹기 좋은 크기로 썰어 둡니다.</li>
    </ol>
    <h4>드레싱 준비</h4>
    <ol type="a" start="3">
      <li>드레싱 재료를  믹서에 한꺼번에 넣고 갈아 줍니다.</li>
    </ol>
    <h4>샐러드 완성</h4>
    <ol type="a" start=4>
      <li>불에 샐러드 채소와 레드향, 아보카도, 토마토를 넣고 드레싱을 뿌리면 끝</li>
    </ol>
    <video src="medias/salad.mp4" controls width="700"></video>
  <h2>상품 구성</h2>
  <dl>
    <dt>선물용 3kg</dt>
    <dd>소과 13~16과</dd>
    <dd>중과 10~12과</dd>
  </dl>
  <dl>
    <dt>선물용 5kg</dt>
    <dd>중과 15~19과</dd>
  </dl>
  <table>
    <caption>선물용과 가정용 상품 구성</caption> 
    <colgroup>
      <col style="background-color:#eee">
      <col>
      <col span="2" style="width: 150px;">
    </colgroup>
    <thead>
      <tr>
        <th>용도</th>
        <th>중량</th>
        <th>개수</th>
        <th>가격</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td rowspan="2">선물용</td>
        <td>3kg</td>
        <td>11~16과</td>
        <td>35,000원</td>
      </tr>
      <tr>
        <td>5kg</td>
        <td>18~26과</td>
        <td>52,000원</td>
      </tr>
      <tr>
        <td rowspan="2">가정용</td>
        <td>3kg</td>
        <td>11~16과</td>
        <td>30,000원</td>
      </tr>
      <tr>
        <td>5kg</td>
        <td>18~26과</td>
        <td>47,000원</td>
      </tr>
    </tbody>
  </table>
  <p><a href="<c:url value="/order"/>" target="_blank">주문하러 가기</a></p>
</body>
</html>