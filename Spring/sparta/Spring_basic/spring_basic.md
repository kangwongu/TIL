## 스프링 기초

### Rest
서버의 응답이 JSON 형식임을 나타낸다.  
HTML, CSS, JS를 주고받을 땐 Rest를 붙이지 않는다.  
데이터(JSON)로 응답하려면, RestController를 사용해야 한다.

<br>

### Controller
클라이언트의 요청(Request)을 전달받는 코드를 의미한다.  
JSON을 돌려주는 것은 **RestController**이다.

``` java
@RestController
public class PersonController {
    @GetMapping("/myinfo")
    public Person getPerson() {
        // JSON객체로 반환할 Person객체 생성
        Person person = new Person("부카요 사카", 20, "축구선수", "010-1234-5678");

        // JSON으로 변환해서 반환
        return person;
    }
}
```

브라우저에 '/myinfo'으로 접근하면 JSON형식의 클래스 정보를 확인할 수 있다.
![RestController](https://user-images.githubusercontent.com/59812251/169764459-8374b1c5-93e9-4066-b609-9310c91dd407.png)

메소드를 잘 만들고 매핑을 잘해주면, 클라이언트로부터 요청이 왔을 때,
만든 메소드들을 알맞게 스프링이 알아서 처리해 준다. (메소드 호출, JSON 변환 등등)  
메소드만 잘 작성하면 된다.

<br>

### Gradle
다른사람의 코드(라이브러리)를 다운받고, 적용하는 것을 간편하게 해 준다.  
라이브러리를 가져와서 build.gradle의 dependency에 추가해주는 방식으로 사용한다.  
인터넷에 스프링 프로젝트를 배포할 수 있게 빌드를 도와주는 역할도 수행한다.