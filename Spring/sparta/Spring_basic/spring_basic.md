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

<br>

### JPA
자바코드로 작성한 것을 SQL로 번역해준다.  
SQL을 쓰지 않고 데이터를 생성, 조회, 수정, 삭제할 수 있도록 해준다.

#### 설정
``` sql
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
```

#### 사용

데이터베이스에서 "테이블"은 자바에서 "Domain"으로 표현되고,  
데이터베이스에서 "SQL"은 자바에서 "Repository"로 표현된다.

**테이블을 자바에서 Domain으로 만드려면?**
``` java
// 테이블임을 나타낸다.
@Entity
public class Course {

    // ID 값, Primary Key로 사용하겠다는 뜻
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 컬럼 값이고 반드시 값이 존재해야 함을 나타낸다.
    @Column(nullable = false)
    private String title;

	...
}
```

<br>

**SQL을 자바에서 Repository로 사용하려면?**
``` java
// jpa는 인터페이스를 통해서만 사용할 수 있기 때문에 인터페이스로 정의
// sql역할을 대신 해줌,                                // 클래스, id
public interface CourseRepository extends JpaRepository<Course, Long> {
}
```
JpaRepository를 상속받아야 사용이 가능하다.

<br>

**Insert**
``` java
Course course = new Course("웹개발의 봄, Spring", "남병관");
repository.save(course);  // repository는 CourseRepository를 의미함
```

<br>

**Select**

모든 데이터 조회하기
``` java
List<Course> list = repository.findAll();
// 콘솔에 출력해보기
for (int i=0; i<list.size(); i++) {
    Course c = list.get(i);
    System.out.println(c.getTitle());
    System.out.println(c.getTutor());
}
```
```
[출력]
웹개발의 봄, Spring
남병관
```

특정 데이터 조회하기
``` java
Course course = repository.findById(1L).orElseThrow(
        () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
);
```

<br>

**Update**

update는 Service 부분에 작성하고 사용한다.

``` java
Course new_course = new Course("웹개발의 봄, Spring", "임민영");
courseService.update(1L, new_course);  // update메소드는 Service에서 작성
```

<br>

**Delete**

``` java
// 전체 삭제
courseRepository.deleteAll();

// 특정한 데이터 삭제
courseRepository.deleteById([삭제할 id]);
```

<br>

### 스프링의 구조
3가지 영역으로 구분된다. (3계층)  
서버에서 클라이언트 처리를 하는 전체적인 과정을 3가지 영역으로 나눈 것이다.

```
1. Controller
- 클라이언트-서버간 통신을 담당한다.
- 요청/응답을 처리한다.

2. Service
- 실제 중요한 작동이 많이 일어나는 부분이다.
- 클라이언트의 요청을 서버에서 진짜 처리해주는 핵심 역할(비즈니스 로직)

3. Repository
    - 서버-DB간 통신을 담당
```

#### Service

예시
``` java
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class CourseService {

    ...

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, Course course) {
        // 업데이트할 데이터의 id가 DB에 있는지 확인
        Course course1 = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        // 업데이트할 데이터로 기존 데이터를 업데이트
        course1.update(course);
        return course1.getId();
    }
}
```
Repository에 update메소드가 없기 때문에 Service에서 작성하고 관리한다.  
@Transactional 어노테이션을 통해, 찾은 객체의 데이터를 변경할 경우 DB에 반영되도록 함

<br>

### Lombok
필수적으로 필요한 메소드/생성자 등을 자동생성해줌으로써 코드를 절약할 수 있도록 도와주는 라이브러리이다.

예시
``` java
@Getter  // Lombok 사용으로 코드를 절약 가능
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Course extends Timestamped {
    ...

    // public String getTitle() {
    //     return this.title;
    // }

    // public Long getId() {
    //     return this.id;
    // }

    // public String getTutor() {
    //     return this.tutor;
    // }

    ...
}
```

<br>

### DTO
데이터를 주고 받을 때 사용하는 클래스이다.  
테이블을 직접 주고 받는 것은 위험하기 때문에 DTO를 사용해서 데이터를 주고받는다

예시
``` java
@Getter
@Setter
@RequiredArgsConstructor
public class CourseRequestDto {
    private final String title;
    private final String tutor;
}
```

``` java
CourseRequestDto requestDto = new CourseRequestDto("웹개발의 봄, Spring", "임민영");
courseService.update(1L, requestDto);
```
직접 Entity 클래스에 접근해서 데이터를 옮기고 수정하는 것이 아니라, DTO를 사용해서 데이터를 주고 받는다.

<br>

### API

클라이언트가 정한대로 서버에게 요청(Request)을 보내면,
서버가 요구사항을 처리하여 응답(Response)을 반환하는, 클라이언트 - 서버간의 약속이다.

<br>

#### REST
주소에 명사, 요청 방식에 동사를 사용함으로써 의도를 명확히 드러내는 것

<br>

**GET**

``` java
@GetMapping("/api/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
```
'api/courses'로 접근하면, DB에서 모든 데이터를 가져와 반환해준다.

![GET](https://user-images.githubusercontent.com/59812251/169990155-e8649bcb-98aa-496e-b49a-6c6b8930d68b.png)

<br>

**POST**

``` java
// 같은 주소라도 메소드가 다르기 때문에 다름을 구분한다.
    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody CourseRequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미
        // Course를 만들기 위해서는 title과 tutor가 필요
        // 그 정보를 가져오는 것이 CourseRequestDto

        // 저장하는 것은 Dto가 아니라 Course
        Course course = new Course(requestDto);

        // JPA를 이용하여 DB에 저장
        return courseRepository.save(course);
    }
```
@RequestBody는 JSON으로 넘어오는 데이터를 받는 데 사용하는 것이다.

요청을 보낼 때, 아래 그림과 같이 요청한다.

![POST (1)](https://user-images.githubusercontent.com/59812251/169993197-72f213be-2fb4-43fb-8b62-29b8215f9d34.png)

![POST (2)](https://user-images.githubusercontent.com/59812251/169993201-c25ef2d1-c56e-4dc1-94f7-fda2168ee357.png)

Header를 추가해 JSON 타입임을 알리고, Body에 JSON으로 데이터를 담아 요청한다.  

<br>

**PUT**

``` java
@PutMapping("/api/courses/{id}")
    public Long updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {
        return courseService.update(id, requestDto);
    }
```

PUT도 POST와 마찬가지로 DTO를 통해 업데이트할 데이터를 받는데, @RequestBody를 통해 받고, 요청 시엔 Header를 추가해 JSON 타입임을 알리고, Body에 JSON으로 데이터를 담아 요청한다.

update메소드는 Service에 구현되어 있으므로, Service의 update메소드를 호출해 처리한다.

<br>

**DELETE**

``` java
@DeleteMapping("/api/courses/{id}")
    public Long deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return id;
    }
```

<br>

### 클라이언트에서 서버에 요청할 때

클라이언트에서 서버(스프링)로 데이터를 전송할 때는 JSON만을 보내야 한다.  
하지만 API간 데이터를 주고 받는 건 문자열만 가능하기 때문에 서버로 데이터를 전송 시,  
`JSON.stringify([서버로 전달할 데이터])`로 문자열로 변환해서 보내줘야 하고,  
문자열로 보내지만, 이 데이터는 JSON이라는 것을 알려주기 위해 contentType을 `application/json`이라고 명시해준다.

``` java
// 서버로 전달할 데이터를 JSON으로 만든다.
let data = {'username': username, 'contents': contents};

$.ajax({
    type: 'POST',
    url: '/api/memos',
    contentType: 'application/json', // JSON 형식으로 전달함을 알림
    // API간 데이터를 주고 받는 건 문자열밖에 안 됨
    data: JSON.stringify(data),  // json -> string
    success: function (response) {
        alert('저장이 완료되었습니다.')
        window.location.reload();
    }
});
```

<br>

### 네이버 쇼핑 API 이용해보기

![20220526_170231](https://user-images.githubusercontent.com/59812251/170445423-55762847-241f-4022-b774-50d12e733203.png)

네이버 쇼핑 API 이용을 신청한다.

<br>

![20220526_170248](https://user-images.githubusercontent.com/59812251/170445429-1f12f3d8-00bd-46af-8e23-219db68439ce.png)

어플리케이션 이름과 환경을 WEB으로 설정하고, URL을 기입한다. (나는 로컬에서 사용할 것이기 때문에 locahost로 기입)

신청을 완료하면 Client ID, Client SECRET을 발급받는다.  
이 친구들은 API 요청할 때 쓸 것이다.

<br>

사용 방법은 https://developers.naver.com/docs/search/shopping/ 을 참고하면 된다.  
위 링크를 바탕으로 네이버 쇼핑 API에 요청을 해보았다.

![20220526_171154](https://user-images.githubusercontent.com/59812251/170447062-d9c74832-b496-4e1f-887f-3744a26245bc.png)

Heder에 발급받은 Client ID, Client SECRET를 추가해주고, '아스날'상품을 검색해보았다.

<br>

![20220526_171217](https://user-images.githubusercontent.com/59812251/170447070-851b63b5-2dd7-480a-8ddb-b972bb8f9421.png)

결과가 나오는 것을 확인할 수 있다.

<br>

``` java
public class NaverShopSearch {
    public String search() {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "[Client ID]");
        headers.add("X-Naver-Client-Secret", "[Client SECRET]");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=아스날", HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    public static void main(String[] args) {
        NaverShopSearch naverShopSearch = new NaverShopSearch();
        naverShopSearch.search();
    }
}
```
java로 변환해서 네이버 쇼핑 API 이용할 수도 있다.

<br>

### 네이버 쇼핑 API를 스프링에서 활용하기

네이버 쇼핑 API를 자바 코드로 만들어서 사용해보았는데, 이를 스프링에서 활용할 수 있도록 해보자  
검색결과를 클라이언트에게 반환해 줄 것이다.  

필요한 2가지
```
1. 검색어는 사용자가 입력해야 함
2. 검색 결과를 문자열로 받는 것이 아니라, DTO로 바꿔서 클라이언트에 전달하도록 변경해야하 함
```

검색 결과를 클라이언트에게 반환해주기 위해서 네이버 쇼핑 API클래스를 수정하고 DTO 클래스를 생성했다.

<br>

네이버 쇼핑 API 클래스
``` java
public class NaverShopSearch {
    public String search(String query) {
        ...
    }

    // 검색 결과를 JSON으로 변환 후 Dto로 만들어서 반환
    public List<ItemDto> fromJSONtoItems(String result) {
        JSONObject rjson = new JSONObject(result);
        JSONArray items = rjson.getJSONArray("items");
        List<ItemDto> itemDtoList = new ArrayList<>();
        for (int i=0; i<items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
            ItemDto itemDto = new ItemDto(itemJson);
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }
}
```
검색 결과가 문자열로 반환되던 기존방식에서, JSON으로 변환하고 변환한 JSON을 바탕으로 ItemDto를 만들어 클라이언트에게 반환한다.

<br>

DTO클래스
```java
@Getter
public class ItemDto {
    private String title;
    private String image;
    private int lprice;
    private String link;

    public ItemDto(JSONObject itemJson) {
        this.title = itemJson.getString("title");
        this.image = itemJson.getString("imgae");
        this.lprice = itemJson.getInt("lprice");
        this.link = itemJson.getString("link");
    }
}
```

<br>

#### 자바에서 JSON 다루기

자바에서 JSON을 다루기 위해서는, org.json 패키지를 설치해야 한다.

maven repository 접속 -> json 검색 -> JSON In Java 클릭 -> 대중적인 버전 클릭 -> Gradle 탭 클릭 -> build.gradle > dependencies에 붙여넣기

``` java
// String -> JSON
JSONObject rjson = new JSONObject(result);
```

``` java
// JSON에서 배열꺼내기 (JSON에 들어있는 'items'배열을 꺼낸다)
JSONArray items = rjson.getJSONArray("items");
```

``` java
// JSONArray에 저장되어 있는 데이터 꺼내기
for (int i=0; i<items.length(); i++) {
	JSONObject itemJson = items.get(i);
	System.out.println(itemJson);
}
```

``` java
// 꺼내온 데이터(JSON)에서 String,int등등 데이터 뽑기
String title = itemJson.getString("title");
int lprice = itemJson.getInt("lprice");
```