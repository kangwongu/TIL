## 페이지 렌더링

### CSR (Client Side Rendering)
클라이언트(브라우저)에서 웹 페이지를 렌더링하는 것이다. 모든 로직, 데이터 가져오기, 템플릿, 라우팅은 서버가 아닌 모두 클리이언트에서 처리된다.  
어플리케이션 구동에 필요한 HTML, JS, CSS 파일 등을 모두 다운로드 한 뒤에 뷰가 구성된다.  
ex) ajax,fetch , 치명적 단점은 코드가 모두 노출된다..

<br>

### SSR (Server Side Rendering)
서버에서 뷰 구성에 필요한 전체 HTML을 요청을 받은 즉시 생성해서 반환합니다. 이렇게 하면 클라이언트 브라우저에서 응답을 받은 후, 이미 완성된 뷰를 그대로 보여지게 된다.  
ex) flask rendering,jsp,php…

<br>

### SSG (Static Site Generator)
클라이언트에서 필요한 페이지들을 사전에 미리 준비해뒀다가, 요청을 받으면 이미 완성된 파일을 단순히 반환하여 브라우저에서 뷰를 보여지게 된다.  
웹페이지를 미리 싸그리 만들어놓고 요청이 들어오면 만들어 놓은 웹페이지를 그대로 응답만 해준다.

<br>

## 참고

https://ajdkfl6445.gitbook.io/study/web/csr-vs-ssr-vs-ssg

https://velog.io/@altmshfkgudtjr/CSR-SSR-SSG-%EC%A1%B0%ED%99%94%EB%A5%BC-%EC%9D%B4%EB%A3%A8%EB%8B%A4