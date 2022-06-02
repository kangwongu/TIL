## Spring

### 뷰 지정하기

#### 정적 웹페이지
src - main - resources - static에 index.html 추가  
스프링 서버를 띄우고 localhost:8080으로 접속하면 index.html이 보여진다.

<br>

#### 동적 웹페이지
src - main - resources - templates에 hello.html 추가  

hello.html
``` html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org"> <!-- 타임리프 문법 사용 가능 -->
<head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<p th:text="'안녕하세요. ' + ${data}" >안녕하세요. 손님</p>
</body>
</html>
```
타임리프 문법을 사용해 동적 페이지를 작성했다.

Controller 작성
``` java
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        // 'data'라는 이름으로 데이터가 담겨서 hello로 전달된다
        model.addAttribute("data", "Spring!!!!");

        // resources - templates에서 hello.html을 보여준다.
        return "hello";
    }
}
```

<br>

## 스프링 웹 개발 기초

### 정적 컨텐츠
파일을 그대로 전달해준다.

src - main - resources - static에 hello-static.html 추가  
localhost:8080/hello-static.html으로 접근 가능

<br>

### MVC와 템플릿 엔진
서버에서 변형을 해서 전달해준다.  
뷰와 컨트롤러 분리는 기본이다.

MVC : Model, View, Controller

``` java
@GetMapping("hello-mvc")
public String helloMvc(@RequestParam("name") String name, Model model) {
    model.addAttribute("name", name);
    return "hello-template";
}
```

``` html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>
<p th:text="'hello ' + ${name}">hello! empty</p>
</body>
</html>
```

`localhost:8080/hello-mvc?name=안녕`으로 접속하면 ${name}부분이 안녕으로 치환된다.  
@ReqeustParam의 required속성을 따로 기입해주지 않으면 기본 true이기 때문에 요청 시, name을 넘겨주지 않으면 오류가 발생한다.

<br>

### API
JSON을 전달해준다.

뷰를 전달하는 것이 아니라, 데이터 자체를 전달해준다.

``` java
@GetMapping("hello-api")
@ResponseBody
public Hello helloApi(@RequestParam("name") String name) {
    Hello hello = new Hello();
    hello.setName(name);
    return hello;   // 객체를 넘김 (JSON)
}
```
@ResponseBody 를 사용하고, 객체를 반환하면 객체가 JSON으로 변환된다.  
`localhost:8080/hello-mvc?name=안녕`으로 접속하면 {"name":"안녕"}형태로 반환된다.

<br>

## 백엔드 개발

### 테스트 케이스 작성
JUnit이라는 프레임워크로 테스트를 할 수 있다.

src - test에서 테스트 코드를 작성한다.

``` java
@Test   // 해당 어노테이션을 붙이면 테스트를 실행할 수 있다.
public void 테스트이름() {
    // given

    // when

    // then
}
Assertions.assertThat([실제 값]).isEqualTo([기대하는 값]);

@BeforeEach //각 테스트 실행 전에 호출된다. 테스트가 서로 영향이 없도록 항상 새로운 객체를 생성하고, 의존관계도 새로 맺어준다.

@AfterEach  // 테스트가 끝난 후 실행할 코드를 넣는다.
```
테스트 시, given, when, then으로 구분해 작성하는 것이 좋다.
