# 스프링 웹 MVC 1편

<br>

## 웹 애플리케이션의 이해

웹은 HTTP 기반으로 동작한다.  
웹 브라우저에서 URL을 치고 접속하면 인터넷을 통해서 해당 URL 서버에 요청을 하고 응답을 받아 웹 브라우저가 그려준다.  
이 때, 요청/응답은 HTTP 프로토콜을 기반으로 동작한다.

HTTP 메시지에 거의 모든 것을 담아서 주고 받을 수 있다.

<br>

### 웹 서버 (Web Server)
HTTP 기반으로 동작하고 정적 리소스(HTML,CSS,JS,이미지,영상등)를 제공하는 역할을 수행한다.  
ex) APACHE, NGINX

<br>

### 웹 애플리케이션 서버 (Web Application Server)
HTTP 기반으로 동작하고 정적 리소스를 제공하는 역할은 웹 서버와 같고, 추가로 프로그램 코드를 실행해서 애플리케이션 로직을 수행한다.  
ex) 사용자에 따라 다른 화면보여주기 등등  
동적 HTML, HTTP API(JSON)

서블릿, JSP, 스프링 MVC등으로 구현한다.

ex) 톰캣, Jetty, Undertow

<br>

### 웹 시스템 구성 - WEB, WAS, DB
웹 서버의 기능을 웹 애플리케이션 서버도 제공하기 때문에, 웹 애플리케이션 서버만 사용할 것 같지만, 그렇지 않다.

![웹 시스템 구성](https://user-images.githubusercontent.com/59812251/173743474-700f9745-14f7-47e4-8744-09e1b5033963.png)

정적 리소스는 웹 서버가 처리하고, 애플리케이션 로직과 같은 동적인 처리가 필요하면 WAS에 넘긴다.  
WAS는 애플리케이션 로직 처리를 전담한다.

상대적으로 웹 서버는 WAS, DB보다는 문제 발생빈도가 적기 때문에, WAS, DB 장애시 웹 서버가 오류 화면을 제공한다.

<br>

### 서블릿

![서블릿](https://user-images.githubusercontent.com/59812251/173748453-0b820310-316f-4423-9ade-4931850c8a0b.png)

클라이언트가 요청을 하면, WAS는 Request, Response 객체를 만들고 서블릿 객체를 호출한다.  
HttpServletRequest 객체를 통해 HTTP 요청 정보를 편리하게 꺼내서 사용할 수 있고, HttpServletResponse 객체를 통해서 HTTP 응답 정보를 편리하게 입력할 수 있다.  
WAS는 Response 객체에 담긴 내용으로 HTTP 응답 정보를 생성하고 클라이언트에 넘겨준다.

#### 서블릿 컨테이너
서블릿을 지원하는 WAS를 서블릿 컨테이너라고 한다. (톰캣)  
서블릿 객체를 생성/초기화/호출/종료하는 생명주기를 관리한다.  
서블릿 객체는 싱글톤으로 관리되며, 동시 요청을 위한 멀티 쓰레드 처리를 지원한다.

<br>

### 동시요청 - 멀티 쓰레드
매우 중요!

트래픽이 많을 때 해결하기 위해 필수로 알고 있어야 하는 개념

HTTP 요청이 오면 WAS는 서블릿 객체를 생성하고 요청을 받는다.  
이 때, 쓰레드가 배정되어서 서블릿 객체의 애플리케이션 로직을 실행시킨다.

WAS는 멀티 쓰레드 처리를 지원하기 때문에, 쓰레드가 담겨있는 쓰레드 풀을 갖고 있다.  
HTTP 요청이 오면, 쓰레드 풀에서 쓰레드 하나가 배정되고 다 쓰면 반납하는 형식으로 동작이 이루어진다.  
멀티 쓰레드를 처리해주는 WAS덕분에 개발자는 멀티 쓰레드 관련 코드를 신경쓰지 않아도 되며, 싱글 쓰레드 프로그래밍을 하듯 평소처럼 개발하면 된다

WAS의 주요 튜닝 포인트는 최대 쓰레드 수이다.
쓰레드의 개수가 많냐 적냐에 따라 성능에 큰 차이를 보이기 때문이다.

<br>

### HTML, HTTP API, CSR, SSR

서버는 정적 리소스, HTML 페이지, HTTP API(JSON)으로 응답을 해주기 때문에, 이 3가지 방식을 잘 알고 있어야 한다.

#### 정적 리소스
고정된 HTML 파일, CSS, JS, 이미지, 영상등을 제공한다

#### HTML
동적으로 필요한 HTML 파일을 생성(JSP, 타임리프등)해서 전달하는 방식이다.

#### HTTP API
HTML이 아니라 데이터(JSON)을 전달하는 방식이며 다양한 시스템에서 호출한다.  
데이터만 주고 받는 형태이며, UI 화면이 필요하면 클라이언트가 별도로 처리한다.

```
UI 클라이언트 접점
    - 앱 클라이언트(아이폰, 안드로이드, PC 앱)
    - 웹 브라우저에서 자바스크립트를 통한 HTTP API 호출
    - React, Vue.js 같은 웹 클라이언트
서버 to 서버
    - 주문 서버 -> 결제 서버
    - 기업간 데이터 통신
```

<br>

#### SSR - 서버 사이드 렌더링
HTML 최종 결과를 서버에서 만들어 웹 브라우저에 전달하는 것이다.  
주로 정적인 화면에 사용 되며 JSP, 타임리프등을 사용한다.

#### CSR - 클라이언트 사이드 렌더링
HTML 결과를 JS를 사용해 브라우저에서 동적으로 생성하는 것이다.  
주로 동적인 화면에 사용하며, React, Vue등을 사용한다.

<br>

서블릿을 통해 개발하면, 자바 코드로 HTML을 만들어 내려주는 것이 너무 복잡하다.  
이를 개선하기 위해 템플릿 엔진(HTML 문서에서 필요한 곳만 코드를 적용해 동적으로 변경)인 JSP가 등장했다.

하지만, JSP 파일 안에 비즈니스 로직과, 뷰 영역이 함께 있어 JSP의 역할이 너무 많아 복잡하고 유지보수도 어렵다.  
이를 개선하기 위해 MVC 패턴이 등장했다.  
비즈니스 로직은 비즈니스 로직, 뷰는 뷰에만 집중하도록 분리한 것이다.

<br>

## MVC 패턴
하나의 서블릿이나 JSP에서 비즈니스 로직과 뷰 렌더링까지 담당하게 되면 너무 많은 역할을 하게되고, 유지보수가 어려워진다.  
그래서 분리한다.

컨트롤러와 뷰 영역으로 서로 역할을 나눈다.

### Controller
HTTP 요청을 받고, 비즈니스 로직을 실행한다.  
뷰에 전달할 데이터를 모델에 담는다.

<br>

### Model
뷰에 출력할 데이터를 담아둔다.

<br>

### View
모델에 담겨있는 데이터를 사용해서 화면을 그린다

<br>

### 프론트 컨트롤러

입구를 하나로!

이전엔 해당 서블릿 URL에 요청하면 바로 접근했지만, 프론트 컨트롤러 사용으로 인해 해당 URL에 요청하면 프론트 컨트롤러가 먼저 요청을 받고, 요청에 맞는 컨트롤러를 찾아서 호출하는 방식으로 전환된다.

이거 왜 쓸까?  
이전 방식에서는 중복되는 코드가 많았다.
특히, 공통으로 처리하는 부분을 중복으로 서블릿마다 작성해주어야 했었는데, 프론트 컨트롤러 도입으로 인해 공통 처리가 가능하게 되었다.

스프링 웹 MVC의 DispatcherServlet이 프론트 컨트롤러 패턴으로 구현되어 있다!

<br>

## Spring MVC

```
동작 순서
1. 핸들러 조회: 핸들러 매핑을 통해 요청 URL에 매핑된 핸들러(컨트롤러)를 조회한다.
2. 핸들러 어댑터 조회: 핸들러를 실행할 수 있는 핸들러 어댑터를 조회한다.
3. 핸들러 어댑터 실행: 핸들러 어댑터를 실행한다.
4. 핸들러 실행: 핸들러 어댑터가 실제 핸들러를 실행한다.
5. ModelAndView 반환: 핸들러 어댑터는 핸들러가 반환하는 정보를 ModelAndView로 변환해서
반환한다.
6. viewResolver 호출: 뷰 리졸버를 찾고 실행한다.
7. View 반환: 뷰 리졸버는 뷰의 논리 이름을 물리 이름으로 바꾸고, 렌더링 역할을 담당하는 뷰 객체를
반환한다.
8. 뷰 렌더링: 뷰를 통해서 뷰를 렌더링 한다.
```

<br>

### DispatcherServlet
스프링 부트는 DispatcherServlet을 서블릿으로 자동으로 등록하면서 모든 경로에 대해서 매핑한다

<br>

### @RequestMapping

@RequestMapping을 붙임으로써, 더욱 간편해졌다.  
핸들러로 만들기 위해 특별히 인터페이스를 상속받지 않아도 되고, 애노테이션만 붙이면 된다.

핸들러 매핑, 핸들러 어댑터
```
RequestMappingHandlerMapping
RequestMappingHandlerAdapter
```

RequestMappingHandlerMapping은 @Controller, @RequestMapping이 클래스 레벨이 붙어 있는 경우에 매핑 정보로 인식한다.

클래스 레벨에 @Controller를 붙이고, 메소드에 @RequestMapping을 붙여주면, 핸들러 매핑과 핸들러 어댑터를 조회하고 실행하는 과정을 애노테이션을 붙임으로써 간편화할 수 있다.

<br>

### 요청 매핑

특정 헤더 조건 매핑
``` java
@GetMapping(value = "/mapping-header", headers = "mode=debug")
public String mappingHeader() {
    log.info("mappingHeader");
    return "ok";
}
```
요청 시, header에 포함되어야 하는 정보를 기입해야 한다.

<br>

미디어 타입 조건 매핑 - HTTP 요청 Content-Type, consume
``` java
@PostMapping(value = "/mapping-consume", consumes = "application/json")
public String mappingConsumes() {
    log.info("mappingConsumes");
    return "ok";
}
```
요청 시, consumes에 기입된 content-type으로 요청을 해야한다.  
일치하지 않으면 415(Unsupported Media Type)를 반환한다.

<br>

미디어 타입 조건 매핑 - HTTP 요청 Accept, produce
``` java
@PostMapping(value = "/mapping-produce", produces = "text/html")
public String mappingProduces() {
    log.info("mappingProduces");
    return "ok";
}
```
요청 시, produces에 기입된 Accept으로 요청을 해야한다.  
일치하지 않으면 406(Not Acceptable)을 반환한다.

<br>

### HTTP 요청 파라미터

``` java
public String requestParamV1(HttpServletRequest request, HttpServletResponse response) {
               
     ...
}
```


``` java
public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {
               
     ...
}
```

``` java
public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {
               
     ...
}
```

``` java
public String requestParamV4(String username, int age) {
               
     ...
}
```

``` java
public String requestParamDefault(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) int age) {
               
     ...
}
```

``` java
public String requestParamMap(
            @RequestParam(required = false, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "999") int age) {
               
     ...
}
```

``` java
public String requestParamRequired(@RequestParam Map<String, Object> paramMap) {
               
     ...
}
```

<br>

#### @ModelAttribute

``` java
@ResponseBody
@RequestMapping("/model-attribute-v1")
public String modelAttributeV1(@RequestParam String username, @RequestParam int age) {
    HelloData helloData = new HelloData();
    helloData.setUsername(username);
    helloData.setAge(age);
    ...
}
```

<br>

@ModelAttribute 사용으로 간편하게 작성 가능
``` java
@ResponseBody
@RequestMapping("/model-attribute-v1")
public String modelAttributeV1(@ModelAttribute HelloData helloData) {
    ...
}
```

<br>

@ModelAttribute도 생략 가능
``` java
@ResponseBody
@RequestMapping("/model-attribute-v2")
public String modelAttributeV2(HelloData helloData) {
    ...
}
```
기본 타입, String은 @RequestParam을 생략할 수 있고, 그 외 참조형은 @ModelAttribute를 생략할 수 있다.

<br>

#### HTTP 메시지 바디로 직접 데이터가 넘어오는 경우

HTTP 메시지 바디를 통해 데이터가 직접 넘어오는 경우는 @RequestParam, @ModelAttribute 를 사용할 수 없다

<br>

**텍스트**

HttpEntity 사용
``` java
@ResponseBody
@PostMapping("/request-body-string-v3")
public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {

    String messageBody = httpEntity.getBody();

    log.info("messageBody={}", messageBody);
    return new HttpEntity<>("ok");
}
```
HttpEntity를 이용해 HTTP 헤더, 바디를 조회할 수 있다.  
요청 파라미터를 조회하는 기능과 관계가 없다.

<br>

@RequestBody
``` java
@PostMapping("/request-body-string-v4")
public String requestBodyStringV4(@RequestBody String messageBody) {
    log.info("messageBody={}", messageBody);
    return "ok";
}
```
@RequestBody 애노테이션을 사용해 HTTP 메시지 바디 정보를 편리하게 조회가 가능하다.

<br>

**JSON**

``` java
@ResponseBody
@PostMapping("/request-body-json-v3")
public String requestBodyJsonV3(@RequestBody HelloData helloData) {
    log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

    return "ok";
}
```


``` java
@ResponseBody
@PostMapping("/request-body-json-v5")
public HelloData requestBodyJsonV5(@RequestBody HelloData data) {
    log.info("username={}, age={}", data.getUsername(), data.getAge());
    return data;
}
```


### 요청 파라미터 VS HTTP 메시지 바디
```
요청 파라미터를 조회하는 기능: @RequestParam , @ModelAttribute
HTTP 메시지 바디를 직접 조회하는 기능: @RequestBody
```

<br>

### HTTP 응답
스프링에서 응답 데이터를 만드는 방법은 크게 3가지 이다.

#### 정적 리소스
웹 브라우저에 정적인 리소스를 제공하는 경우

<br>

#### 뷰 템플릿
웹 브라우저에 동적인 HTML을 제공할 때 사용한다.

<br>

#### HTTP 메시지 사용
HTML이 아닌 데이터를 전달하는 경우이며, HTTP 메시지 바디에 JSON 같은 형식으로 데이터를 실어 보낸다.

<br>

### HTTP 메시지 컨버터

HTTP API처럼 JSON 데이터를 HTTP 메시지 바디에서 직접 읽거나 쓰는 경우, HTTP 메시지 컨버터를 사용하면 편리하다.

@ResponseBody를 사용하게 되면 뷰가 아닌 데이터를 직접 HTTP 메시지 바디에 넣어 반환하게 된다.  
HTTP 요청이 왔을 때, viewResolver대신에 HttpMessageConverter가 동작한다.

```
HTTP 요청: @RequestBody , HttpEntity(RequestEntity)
HTTP 응답: @ResponseBody , HttpEntity(ResponseEntity)
```

<br>

## 로깅
로그 라이브러리는 다양한 것들이 있는데, 이것들을 통합해서 인터페이스로 제공하는 것이 SLF4J라이브러리이다.  
실무에서는 스프링 부트가 기본으로 제공하는 SLF4J의 구현체인 Logback을 대부분 사용한다.

``` java
// 로깅 선언
private final Logger log = LoggerFactory.getLogger(getClass());

@RequestMapping("/log-test")
public String logTest() {
    String name = "Spring";

    System.out.println("name = " + name);

    // 로그 호출
    log.trace("trace log={}", name);
    log.debug("debug log={}", name);
    log.info("info log={}", name);
    log.warn("warn log={}", name);
    log.error("error log={}", name);

    return "ok";
}
```
롬복 @Slf4j를 사용해서 로깅 선언을 대신할 수 있다.

<br>

로그 레벨은 다음과 같다
```
LEVEL: TRACE > DEBUG > INFO > WARN > ERROR
개발 서버는 debug 출력
운영 서버는 info 출력
```

로그 레벨 설정
``` java
// application.properties

// 전체 로그 레벨 설정(기본 info)
logging.level.root=info
// hello.springmvc 패키지와 그 하위 로그 레벨 설정
logging.level.hello.springmvc=debug
```

### 왜 쓰는지?
쓰레드 정보, 클래스 이름 같은 부가 정보를 함께 볼 수 있고, 로그 레벨에 따라 상황에 맞게 로그 출력을 조절할 수 있다는 점  
(기존에 System.out을 쓰면 항상 출력이 됐었음)

파일이나 네트워크 등, 로그를 별도에 위치로 남길 수 있고, 로그를 분할하는 것도 가능하다.