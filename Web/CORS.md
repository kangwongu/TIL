## CORS
Cross Origin Resource Sharing의 약자로 CORS 정책은 우리가 가져오는 리소스들이 안전한지 검사하는 관문이다.

보안 상의 이유로, 브라우저는 스크립트에서 시작한 교차 출처 HTTP 요청을 제한한다.

API를 사용하는 웹 애플리케이션은 자신의 출처와 동일한 리소스만 불러올 수 있으며, 다른 출처의 리소스를 불러오려면 그 출처에서 올바른 CORS 헤더를 포함한 응답을 반환해야 한다.

<br>

### Cross Origin
프로토콜, 포트, 호스트 중 하나라도 일치하지 않으면 Cross Origin이라고 한다.

<br>

### CORS 에러
CORS를 허용해서 다른 출처 리소스 공유를 허락해달라는 권고와 같다. 

```
프론트 서버의 URL이 http://localhost:3000이고,
백엔드 서버가 http://localhost:8080에 띄워져 있다고 하면

이때 프론트 서버와 백엔드 서버는 다른 출처 (Origin)으로써 Same-Origin Policy 정책을 어긋나기 때문에, 서버로부터 응답이 넘어올 때 브라우저에서 CORS Policy 오류를 발생시킨다.
```

웹 애플리케이션은 리소스가 자신의 출처(도메인, 프로토콜, 포트)와 다를 때 교차 출처 HTTP 요청을 실행하게 된다.

<br>

### 참고
https://inpa.tistory.com/entry/WEB-%F0%9F%93%9A-CORS-%F0%9F%92%AF-%EC%A0%95%EB%A6%AC-%ED%95%B4%EA%B2%B0-%EB%B0%A9%EB%B2%95-%F0%9F%91%8F

https://developer.mozilla.org/ko/docs/Web/HTTP/CORS