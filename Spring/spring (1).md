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

### 웹 어플리케이션 구조
![구조](https://user-images.githubusercontent.com/59812251/171817658-ac299d42-c16c-4354-b32b-fdefae78b498.png)

<br>

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

<br>

## 스프링 빈과 의존관계
Controller가 Service를 통해 Repository를 사용할 수 있도록 의존관계를 맺어줘야 한다.  
스프링 빈을 등록하는 방법엔 2가지 방식이 있다.

### 컴포넌트 스캔

``` java
@Component  // 스프링 빈으로 자동 등록된다.

// @Component가 포함되어 있어 자동으로 스프링 빈에 등록된다.
@Controller
@Service
@Repository
```

<br>

``` java
// 객체 의존관계를 외부에서 넣어주는 것을 DI (Dependency Injection), 의존성 주입
@Autowired
public MemberController(MemberService memberService) {
    this.memberService = memberService;
}
```
생성자에 @Autowired를 사용하면 객체 생성 시점에 스프링 컨테이너에서 해당하는 스프링 빈을 찾아 주입한다.  
스프링 빈에 등록되지 않은 객체에서는 동작하지 않는다.

<br>

### 코드로 직접 스프링 빈 등록하기

``` java
// 직접 스프링 빈 등록하기
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
```
이와 같이 직접 빈으로 등록할 수 있다.

<br>

### 사용?
실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다.  
그리고 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로
등록한다.

<br>

## 웹 MVC 개발

**등록**

Controller
``` java
@PostMapping("/members/new")
// 넘어온 값이 MemberForm의 name에 저장됨
public String create(MemberForm form) {
    Member member = new Member();
    member.setName(form.getName());

    memberService.join(member);

    return "redirect:/";
}
```

<br>

넘어온 값을 받을 클래스
``` java
public class MemberForm {
    // html의 input의 name속성과 매핑
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

<br>

'/members/new' 페이지
``` html
<form action="/members/new" method="post">
    <div class="form-group">
      <label for="name">이름</label>
      <!-- MemberForm의 name과 input의 name속성이 매핑 -->
      <input type="text" id="name" name="name" placeholder="이름을
입력하세요">
    </div>
    <button type="submit">등록</button>
  </form>
```

`http://localhost:8080/members/new`에서 폼에 입력을 하고 등록버튼을 누르면, input의 적힌 내용이 Controller에 전달되고, MemberForm 클래스로 넘겨져 값이 담기게 된다.

<br>

#### 타임리프문

반복문
``` html
<!-- 서버에서 'members'라는 이름으로 리스트가 내려왔을때 -->
<tr th:each="member : ${members}">
 <td th:text="${member.id}"></td>
 <td th:text="${member.name}"></td>
 </tr>
```

<br>

## 스프링 DB 접근 기술

### JDBC

환경 설정
``` java
// build.gradle
implementation 'org.springframework.boot:spring-boot-starter-jdbc'
runtimeOnly 'com.h2database:h2'
```
jdbc, h2 DB 라이브러리 추가

<br>

스프링 부트 데이터베이스 연결 설정
``` java
// application.properties
spring.datasource.url=jdbc:h2:tcp://localhost/~/test
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
```

<br>

아아주 옛날 선배들이 작성하던 방식으로 정신건강을 위해 참고만 하자고 하셨다..

<br>

#### 개방-폐쇄 원칙 (OCP)
``` java
// 직접 스프링 빈 등록하기
@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
```
기존에 직접 스프링 빈을 등록할 때 사용한 설정 클래스를 변경했다.  
MemoryMemberRepository를 사용하다가 JdbcMemberRepository로 변경했는데, 어떠한 수정 없이, 설정 클래스에서의 변경으로 수정되고 정상 작동한다.  
Spring DI로 기존 코드를 손대지 않고, 설정 변경으로 수정이 가능한 것이다!

<br>

### 스프링 통합 테스트
DB를 사용했기 때문에 스프링 컨테이너와 DB까지 연결한 통합 테스트를 통해 테스트할 수 있다.

예시
``` java
@SpringBootTest
@Transactional  // 테스트 실행 시, DB에 데이터를 넣고 테스트 끝나면 DB 데이터 삭제
public class MemberServiceIntegrationTest {

    // 테스트때만 쓰기 때문에, 필드 의존성 주입을 해줌
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    ...
}
```

<br>

``` java
@SpringBootTest // 스프링 컨테이너와 테스트를 함께 실행
@Transactional  // 테스트 시작 전에 트랜잭션 시작, 테스트 완료 후 롤백
```

<br>

### JdbcTemplate

jdbc와 동일한 환경설정  
jdbc에서 작성하는 반복 코드들을 대부분 제거해주지만, SQL을 직접 작성해야 하는 부분은 동일하다.

<br>

### JPA
DB연결을 위한 반복되는 코드는 물론이고 기본적인 SQL도 JPA가 직접 만들어서 실행해준다.  
SQL과 데이터 중심 설계에서 객체 중심의 설계로 전환할 수 있다.

<br>

환경설정
``` java
// build.gradle
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
```

<br>

스프링부트에 JPA 설정 추가
``` java
// application.properties
spring.jpa.show-sql=true
```
JPA에서 만들고 날리는 쿼리를 볼 수 있는 설정이다. (굳이 안해도 됨)

<br>

JPA Entity 매핑
``` java
@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 알아서 생성
    private Long id;

    ...
}
```
기존 클래스를 수정한다

<br>

JPA Repository
``` java
public class JpaMemberRepository implements MemberRepository {

    // JPA 사용 위해 필요
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    ...
}
```
많이 간편화 되었지만, JPA의 내용도 스프링 못지않게 방대하므로 추가적으로 공부해야함!

<br>

JPA Service
``` java
@Transactional
public class MemberService {}
```
JPA를 통한 모든 데이터 변경은 트랜잭션 안에서 실행되어야 하기 때문에 @Transactional을 붙여야 한다.

<br>

### Spring Data JPA
Repository 구현 클래스 없이 인터페이스 만으로 개발을 할 수 있고, 기본 CRUD 기능도 Spring Data JPA가 제공해준다.  

JPA -> Spring Data JPA

``` java
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
```

<br>

설정 클래스
``` java
// 직접 스프링 빈 등록하기
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);

//    }
}
```
이전에는 Repository도 빈으로 등록해주어야 했었는데, Spring Data JPA가
스프링 빈으로 자동 등록해준다.

<br>

## AOP

공통 관심 사항과, 핵심 관심 사항을 분리할 수 있게 하는 것  


``` java
@Aspect // AOP 어노테이션
@Component
public class TimeTraceAop {

    // AOP 적용 hello.hellospring패키지 하위에 적용
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed(); // 실제 메소드 수행
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + timeMs + "ms");
        }
    }
}
```
AOP도 스프링 빈으로 등록해줘야 사용이 가능하다.  
AOP는 3계층처럼 정형화된 것이 아니기 때문에, 직접 코드를 통해 빈으로 설정하는 방식이 더 좋은 방식이다.