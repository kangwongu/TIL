# 스프링 심화반 1주차

**Servlet**

자바를 사용하여 웹페이지를 동적으로 생성하는 서버측 프로그램이다.  
웹 개발의 봄, Spring 수업에서 Controller를 사용해 구현을 했는데, 이를 Servlet으로 구현할 수 있다.

<br>

상품 검색 API를 Servlet으로 구현
``` java
@WebServlet(urlPatterns = "/api/search")
public class ItemSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       // 1. API Request 의 파라미터 값에서 검색어 추출 -> query 변수
        String query = request.getParameter("query");

        // 2. 네이버 쇼핑 API 호출에 필요한 Header, Body 정리
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "zdqMoIkFaK8uKvC2oNY2");
        headers.add("X-Naver-Client-Secret", "LiZfsgtuD5");
        String body = "";
        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

        // 3. 네이버 쇼핑 API 호출 결과 -> naverApiResponseJson (JSON 형태)
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        String naverApiResponseJson = responseEntity.getBody();

        // 4. naverApiResponseJson (JSON 형태) -> itemDtoList (자바 객체 형태)
        // - naverApiResponseJson 에서 우리가 사용할 데이터만 추출 -> List<ItemDto> 객체로 변환
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode itemsNode = objectMapper.readTree(naverApiResponseJson).get("items");
        List<ItemDto> itemDtoList = objectMapper
                .readerFor(new TypeReference<List<ItemDto>>() {})
                .readValue(itemsNode);

        // 5. API Response 보내기
        // 5.1) response 의 header 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        // 5.2) response 의 body 설정
        PrintWriter out = response.getWriter();
        // - itemDtoList (자바 객체 형태) -> itemDtoListJson (JSON 형태)
        String itemDtoListJson = objectMapper.writeValueAsString(itemDtoList);
        out.print(itemDtoListJson);
        out.flush();
    }
}
```
Controller를 사용할 때와 비교하면 상당히 복잡하다는 것을 알 수 있다.  
그리고, Controller가 아닌 Servlet으로 구현해도 정상적으로 동작한다.

그럼 왜 Servlet으로 구현할 수 있는 것을 Controller로 구현할까?

<br>

### Controller의 장점

```
1. Controller는 HTTP request, response 처리를 위해 매번 작성해 줘야하는 중복코드를 생략할 수 있다

2. Controller는 API 이름마다 파일을 만들 필요가 없다 (유사한 성격의 API를 하나의 Controller로 관리)
```

<br>

상품 검색 API를 Controller로 구현
``` java
@Controller
public class ItemSearchController {

    // Controller 가 자동으로 해주는 일
    // 1. API Request 의 파라미터 값에서 검색어 추출 -> query 변수
    // 5. API Response 보내기
    //  5.1) response 의 header 설정
    //  5.2) response 의 body 설정
    @GetMapping("/api/search")
    @ResponseBody
    public List<ItemDto> getItems(@RequestParam String query) throws IOException {
        // 2. 네이버 쇼핑 API 호출에 필요한 Header, Body 정리
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "zdqMoIkFaK8uKvC2oNY2");
        headers.add("X-Naver-Client-Secret", "LiZfsgtuD5");
        String body = "";
        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

        // 3. 네이버 쇼핑 API 호출 결과 -> naverApiResponseJson (JSON 형태)
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        String naverApiResponseJson = responseEntity.getBody();

        // 4. naverApiResponseJson (JSON 형태) -> itemDtoList (자바 객체 형태)
        //  - naverApiResponseJson 에서 우리가 사용할 데이터만 추출 -> List<ItemDto> 객체로 변환
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode itemsNode = objectMapper.readTree(naverApiResponseJson).get("items");
        List<ItemDto> itemDtoList = objectMapper
                .readerFor(new TypeReference<List<ItemDto>>() {})
                .readValue(itemsNode);

        return itemDtoList;
    }
}
```

Servlet으로 구현한 것 보다 코드가 절약되는 것을 알 수 있다

<br>

### 스프링 3계층 (Controller, Service, Repository) 설계의 이유 파악

Controller에 모든 코드를 넣고 실행해도 잘 동작한다.  
그럼 Service, Repository는 왜 필요한 걸까?

우선, Controller에 모든 코드를 넣어도 동작은 잘 되지만, 문제들이 있다.
```
1. 한 개의 클래스에 너무 많은 양의 코드가 존재한다. -> 코드 이해하기 어려움
2. 현업에서는 코드 추가, 변경등이 빈번하게 일어남 -> 코드 이해하기 어려워 시간이 많이 걸림
등등
```
그래서, **분리**하는 것! (**관심사 분리**)

<br>

각 역할 별로 하는 일을 정리해보면 다음과 같다
```
1. Controller
- 클라이언트의 요청을 받음
- 요청에 대한 처리는 서비스에게 전담
- 클라이언트에게 응답

2. Service
- 사용자의 요구사항을 처리 (비즈니스 로직을 처리)
- 현업에서는 서비스 코드가 계속 비대해진다
- DB 정보가 필요할 때는 Repository 에게 요청

3. Repository
- DB 관리 (연결, 해제, 자원 관리)
- DB CRUD 작업 처리
```
각 역할 별로 분리하면 위의 문제를 해결할 수 있다.

<br>

```
1. 한 개의 클래스에 너무 많은 양의 코드가 존재했던 것이 3개의 클래스에 역할별로 코드가 정리된다
2. 현업에서는 코드 추가, 변경등이 빈번하게 일어나는데, 코드가 역할별로 정리되었기 때문에 어느 부분을 수정해야 하 는지 알기 쉬워진다.
```

<br>

## 스프링 MVC
MVC(Model - View - Controller)는 디자인 패턴이다.  
코드를 Model(데이터 저장), View(출력), Controller(처리) 부분으로 나누는 것을 의미한다.

### Response
서버에서 HTML을 클라이언트에게 반환하는 경우

1. 정적(static) 웹페이지
    - Controller가 클라이언트의 요청을 Model로 받아 처리 후, 클라이언트에게 View(정적 웹페이지)를 반환

2. 동적(dynamic) 웹페이지
    - Controller가 클라이언트의 요청을 Model로 받아 처리 후, 템플릿 엔진에 View, Model 전달
        - View : 동적 HTML 파일
        - Model : View에 적용할 정보들 

    - 템플릿 엔진에서 View에 Model을 적용 (동적 웹페이지 생성) 후, 클라이언트에게 View(동적 웹페이지)를 반환
        - Template engine 종류: 타임리프 (Thymeleaf), Groovy, FreeMarker, Jade 등 (스프링에서 JSP 이용은 추천x)

<br>

#### Controller와 HTTP Response 메시지

![response](https://user-images.githubusercontent.com/59812251/173173569-f26af1f7-7331-4b2e-ba8c-d0bf21540c4c.png)

(1). 정적 웹페이지
1. static 폴더
    - static폴더에 있는 html파일을 주소창에 그대로 치고 입력하면 접근가능
    - ex) http://localhost:8080/hello.html

<br>

2. Redirect
- http://localhost:8080/hello/response/html/redirect로 접근하면 hello.html로 이동

    ``` java
    @Controller
    @RequestMapping("/hello/response")
    public class HelloResponseController {
        @GetMapping("/html/redirect")
        public String htmlFile() {
            return "redirect:/hello.html";
        }
    }
    ```

<br>

3. 템플릿 엔진에 View전달
- http://localhost:8080/hello/response/html/templates로 접근하면 hello.html로 이동

    ``` java
    @GetMapping("/html/templates")
    public String htmlTemplates() {
        return "hello";
    }
    ```
    "hello"문자열을 반환했을 뿐인데, 타임리프에 의해 hello.html이 보여진다

    타임리프 default 설정
    -   prefix: classpath:/templates/
    -   suffix: .html

    resources/templates/hello.html

<br>

4. @ResponseBody
- View 를 사용하지 않고, HTTP Body 에 들어갈 String 을 직접 입력
- http://localhost:8080/hello/response/html/templates로 접근하면 return값들을 출력

    ``` java
    @GetMapping("/body/html")
    @ResponseBody
    public String helloStringHTML() {
        return "<!DOCTYPE html>" +
            "<html>" +
                "<head><title>By @ResponseBody</title></head>" +
                "<body> Hello, 정적 웹 페이지!!</body>" +
            "</html>";
    }
    ```

<br>

(2) 동적 웹페이지

``` java
private static long visitCount = 0;

@GetMapping("/html/dynamic")
public String helloHtmlFile(Model model) {
    visitCount++;
    model.addAttribute("visits", visitCount);
    return "hello-visit";
}
```
View, Model 정보 → 타임리프에게 전달한다.  
타임리프는 Model의 정보를 View에 적용 후, 클라이언트에게 반환한다

<br>

(3) JSON 데이터

    - 반환값: String외 자바 클래스

``` java
@GetMapping("/json/class")
@ResponseBody
public Star helloJson() {
    return new Star("BTS", 28);
}
```
자바 객체 -> JSON으로 변환해서 반환한다.  
이 때, 변환은 스프링이 알아서 해 준다

<br>

### Controller 와 HTTP Request 메시지

![request](https://user-images.githubusercontent.com/59812251/173173572-8421e1b4-dd17-4049-8f39-4d7697126629.png)


<br>

### 스프링 MVC 동작원리
```
1. Client → DispatcherServlet
- DispatcherServlet이 가장 앞 단에서 요청을 받는다

2. DispatcherServlet → Controller
- API를 처리할 Controller를 찾고, 요청을 전달한다.
- Handler Mapping에서 API path와 Controller 함수가 매칭되어 있어, 여기서 path를 찾음
- Controller에서 필요한 매개변수들을 넣어줌

3. Controller → DispathcerServlet
- Controller 가 Client 으로 받은 API 요청을 처리
- 'Model' 정보와 'View' 정보를 DispatcherServlet 으로 전달

4. DispatcherServlet → Client
- ViewResolver 통해 View 에 Model 을 적용
- View를 Client에게 응답
```

<br>

## 스프링의 핵심인 IoC / DI 이해

### IoC (제어의 역전)
프로그램의 제어 흐름이 뒤바뀐 것을 의미한다.  
사용자 자신이 필요한 객체를 생성 후 사용하던 것에서 용도에 맞게 필요한 객체를 가져와 사용하는 것으로 변경된 상태를 의미한다.

<br>

### DI (의존성 주입)
미리 객체를 생성해 놓은 것을 가져다 쓰는 개념이다.

DI 를 사용하기 위해서는 객체 생성이 우선 되어야 한다. 과연 어디서 객체 생성을 해야 할까?  
바로 스프링 프레임워크가 필요한 객체를 생성하여 관리하는 역할을 대신해 준다.

'빈'에 등록
```
빈(Bean): 스프링이 관리하는 객체

스프링 IoC 컨테이너 / DI 컨테이너: '빈'을 모아둔 통
```

<br>

#### @Bean 등록 방법

'빈'을 등록하는 방법은 2가지가 있다

1. @Component

    클래스 선언 위에 애너테이션을 붙이는 방식이다.


    ``` java
    @Component
    public class ProductService { ... }
    ```
    스프링 서버가 뜰 때, 스프링 IoC컨테이너에 '빈' 저장

    <br>

    @Component클래스에서 스프링이 해주는 일
    ``` java
    // 1. ProductService 객체 생성
    ProductService productService = new ProductService();

    // 2. 스프링 IoC(DI) 컨테이너에 빈 (productService) 저장
    // productService -> 스프링 IoC(DI) 컨테이너
    ```

    스프링 '빈' 이름: 클래스의 앞글자만 소문자로 변경  
    public class ProductServcie → productServcie

<br>

2. @Bean

    직접 객체를 생성해 빈으로 등록 요청


    ``` java
    @Configuration // 스프링이 동작할 때 이 부분을 읽음
    public class BeanConfiguration {

        @Bean  // Bean등록, return값을 Bean으로 등록함
        public ProductRepository productRepository() {
            String dbUrl = "jdbc:h2:mem:springcoredb";
            String dbId = "sa";
            String dbPassword = "";

            return new ProductRepository(dbUrl, dbId, dbPassword);
        }
    }
    ```

    <br>

    스프링 서버가 뜰 때 스프링 IoC 에 '빈' 저장

    ``` java
    // 1. @Bean 설정된 함수 호출
    ProductRepository productRepository = beanConfiguration.productRepository();

    // 2. 스프링 IoC 컨테이너에 빈 (productRepository) 저장
    // productRepository -> 스프링 IoC(DI) 컨테이너
    ```

    스프링 '빈' 이름: @Bean 이 설정된 함수명  
    public ProductRepository productRepository() {..} → productRepostory

<br>

#### @Bean 사용 방법

1. @Autowired

    멤버변수 선언 위에 @Autowired → 스프링에 의해 DI (의존성 주입) 됨

    ``` java
    @Component
    public class ProductService {

        @Autowired
        private ProductRepository productRepository;

        ...
    }
    ```

    <br>

    '빈' 을 사용할 함수 위에 @Autowired → 스프링에 의해 DI 됨
    ``` java
    @Component
    public class ProductService {

        private final ProductRepository productRepository;

        @Autowired
        public ProductService(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        ...
    }
    ```

    <br>

    @Autowired 적용 조건  
      : 스프링 IoC 컨테이너에 의해 관리되는 클래스에서만 가능

    <br>

    ※ Lombok 의 @RequiredArgsConstructor 를 사용하면 다음과 같이 코딩 가능

    ``` java
    @RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
    @RestController // JSON으로 데이터를 주고받음을 선언합니다.
    public class ProductController {

        private final ProductService productService;
        
        // 생략 가능
        // @Autowired
        // public ProductController(ProductService productService) {
        //     this.productService = productService;
        // }
    }
    ```

<br>

2. ApplicationContext

    스프링 IoC 컨테이너에서 빈을 수동으로 가져오는 방법

    ``` java
    @Component
    public class ProductService {
        private final ProductRepository productRepository;

        @Autowired
        public ProductService(ApplicationContext context) {
            // 1.'빈' 이름으로 가져오기
            ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");
            // 2.'빈' 클래스 형식으로 가져오기
            // ProductRepository productRepository = context.getBean(ProductRepository.class);
            this.productRepository = productRepository;
        }

        ...
    }
    ```