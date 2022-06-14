# 스프링 심화반 2주차


## 인증, 인가

### 인증(Authentication)
사용자 신원을 확인하는 행위이다.

<br>

### 인가(Authorization)
사용자 권한을 확인하는 행위이다.

<br>

### 웹에서의 인증, 인가
```
인증 : 로그인을 통해 본인임을 확인 (주로, 아이디와 패스워드 이용)
인가 : 주로 역할에 따른 사용 권한 관리
```

<br>

## 쿠키와 세션

HTTP는 상태 정보를 저장하지 않아 사용자를 구별하지 못하는 특성(Stateless)을 가진다.  
같은 클라이언트에서 서버에 여러번 요청해도, 같은 클라이언트에서 보내는 요청임을 알 수 없다.

쿠키와 세션은 HTTP에 상태 정보를 유지(Stateful)하기 위해 사용된다.  
쿠키와 세션을 통해 서버에서는 클라이언트를 식별하고, 클라이언트 별로 인증 및 인가를 할 수 있게 된다!

<br>

### 쿠키
클라이언트에 저장되는 작은 정보를 담은 파일이다.  
웹사이트 접속시 접속자의 개인장치에 다운로드 되고 브라우저에 저장되는 작은 텍스트 파일이다.

<br>

### 세션
서버에서 일정시간 동안 클라이언트 상태를 유지하기 위해 사용한다.  
서버에서 클라이언트 별로 유일무이한 '세션 ID' 를 부여한 후 클라이언트 별 필요한 정보를 서버에 저장한다.  
서버에서 생성한 '세션 ID' 는 클라이언트의 쿠키값('세션 쿠키' 라고 부름)으로 저장되어 클라이언트 식별에 사용된다.

#### 세션 동작 방식
```
1. 클라이언트가 서버에 1번째 요청
2. 서버가 세션ID 를 생성하고, 응답 헤더에 전달
    a. 세션 ID 형태: "SESSIONID = 12A345"
3. 클라이언트가 쿠키를 저장 ('세션쿠키') (쿠키안에 세션ID가 담겨있음)
4. 클라이언트가 서버에 2번째 요청
    a. 쿠키값 (세션 ID) 포함하여 요청
5. 서버가 세션ID 를 확인하고, 1번 요청과 같은 클라이언트임을 인지
```

<br>

## 스프링 시큐리티 프레임워크
스프링 시큐리티 프레임워크는 스프링 서버에 필요한 인증, 인가 기능을 제공해준다

### 스프링 시큐리티 프레임워크 추가 (Gradle에 추가)
``` java
// build.gradle
implementation 'org.springframework.boot:spring-boot-starter-security'
```

<br>

### 스프링 시큐리티 활성화 예시
``` java
@Configuration	// 스프링 서버가 구동되면 읽음
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {	// 상속을 받아야 함
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                // image 폴더를 login 없이 허용
                .antMatchers("/images/**").permitAll()
                // css 폴더를 login 없이 허용
                .antMatchers("/css/**").permitAll()
                // 어떤 요청이든 '인증'
                .anyRequest().authenticated()
                .and()
                    // 로그인 기능 허용
                    .formLogin()
                    .loginPage("/user/login")
                    .defaultSuccessUrl("/") // 인증에 성공하면 보내게 될 위치
                    .failureUrl("/user/login?error")
                    .permitAll()    // 로그인 기능을 허용
                .and()
                    // 로그아웃 기능 허용
                    .logout()
                    .permitAll();
    }
}
```
'/' 로 접근하면 ⇒ '/user/login' 페이지로 이동한다  
시큐리티를 활성화하면 시큐리티가 요청을 막기 때문에 URL 허용 정책 변경에 신경 써야 함!  

<br>

POST 요청을 시큐리티가 막음
``` java
@Override
protected void configure(HttpSecurity http) throws Exception {
	// 회원 관리 처리 API (POST /user/**) 에 대해 CSRF 무시
	http.csrf()
		.ignoringAntMatchers("/user/**");
        ...
```
위와 같은 설정으로 시큐리티의 허용 정책을 변경해줌  
/user/\*\* URL 요청 (POST)을 허용  

<br>

H2-console 사용을 시큐리티가 막음
``` java
@Override
public void configure(WebSecurity web) {
    // h2-console 사용에 대한 허용 (CSRF, FrameOptions 무시)
    web
            .ignoring()
            .antMatchers("/h2-console/**");
}
```
위와 같은 설정으로 시큐리티의 허용 정책을 변경해줌  
스프링 시큐리티를 사용하기 위해선 프레임워크의 룰을 알고 따라야 한다!  

<br>
※ 패스워드 암호화

회원 등록 시 '비밀번호'는 사용자가 입력한 문자 그대로 DB 에 안 된다  
'정보통신망법, 개인정보보호법' 에 의해 비밀번호는 암호화(Encryption)가 의무!!

따라서, 패스워드를 암호화 해야한다.  
스프링 시큐리티를 이용해 암호화 가능하며, 스프링 시큐리티에서 '권고'하고 있는 'BCrypt 해시함수'를 사용해 패스워드를 암호화하여 DB 에 저장한다.

<br>

스프링 시큐리티에 암호화 알고리즘을 '빈(Bean)'으로 등록
``` java
@Bean
public BCryptPasswordEncoder encodePassword() {
    return new BCryptPasswordEncoder();
}
```

<br>

패스워드 암호화 구현
``` java
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    ...
    
    public void registerUser(SignupRequestDto requestDto) {
        ...

        // 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());
      
        // 패스워드 암호화하고 DB에 저장
        User user = new User(username, password, email, role);
        userRepository.save(user);
    }
}
```

<br>

### 로그인, 로그아웃 기능 구현

스프링 시큐리티 사용으로, 클라이언트의 요청은 모두 스프링 시큐리티를 거치게 된다.

#### 스프링 시큐리티의 역할
```
인증/인가
- 성공 시: Controller 로 Client 요청 전달, Client 요청 + 사용자 정보 (UserDetails)
- 실패 시: Controller 로 Client 요청 전달되지 않음, Client 에게 Error Response 보냄
```

<br>

#### 로그인 처리 과정

![스프링 시큐리티 로그인](https://user-images.githubusercontent.com/59812251/173498003-8e3d2e46-5a6e-4944-9f2f-bc7c484e3bb0.png)

```
1. 인증 관리자가 username을 UserDetailsService에게 전달한다.

2. UserDetailsService는 넘겨받은 username으로 DB에서 회원 조회
- 조회된 회원 정보를 UserDetails로 변환해서 인증 관리자에게 반환
- 회원 정보가 없으면 Error발생

3. 인증 관리자는 Client의 username, password와 UserDetailsService 가 전달해준 UserDetails 의 username, password의 일치 여부를 확인
```
인증 성공 -> 세션에 로그인 정보 저장  
인증 실패 -> Error 발생

인증에 성공해 로그인이 완료되면, 스프링 시큐리티가 '로그인된 회원 정보'를 Controller에게 전달해 준다

Controller에서 '로그인된 회원 정보'를 사용할 수 있다!
``` java
@Controller
public class TestController {
    @GetMapping("/")
    public String test(@AuthenticationPrincipal UserDetailsImpl userDetails) {
    }
}
```
로그인된 회원 정보가 UserDetailsImpl로 넘어온다

<br>

#### 로그아웃 처리
로그아웃 URL로 요청하면 서버 세션에 저장되어 있는 로그인 사용자 정보를 삭제하며, 스프링 시큐리티가 알아서 삭제한다.

<br>

※ UserDetailsService, UserDetails 구현

직접 UserDetailsService, UserDetails를 구현해야 스프링 시큐리티의 로그인, 로그아웃이 동작한다  
ex)
- UserDetailsService 인터페이스 → UserDetailsServiceImpl 클래스
- UserDetails 인터페이스 → UserDetailsImpl 클래스

<br>

ㅇ 스프링 시큐리티에 권한 설정방법
1.  회원 상세정보 (UserDetails를 구현한 클래스) 를 통해 "권한 (Authority)" 설정 가능
2.  권한을 1개 이상 설정 가능
3.  "권한 이름" 규칙
    -   "ROLE\_" 로 시작해야 함
        -   예) "ADMIN" 권한 부여 → "ROLE\_ADMIN"
        -   예) "USER" 권한 부여 -> "ROLE\_USER"

``` java
// 권한 설정
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    // 1. 로그인된 회원의 역할 정보를 확인해 USER인지 ADMIN인지 확인한다
    UserRoleEnum role = user.getRole();
    String authority = role.getAuthority(); // ROLE_ADMIN, ROLE_USER

    // 2. 해당 역할에 맞게 권한을 설정한다.
    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);
    Collection<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(simpleGrantedAuthority);

    // 스프링 시큐리티가 알아서 권한을 확인
    return authorities;
}
```

<br>

ㅇ 스프링 시큐리티에 설정한 권한을 이용해 API 별 권한 제어 방법
-   Controller 에 "@Secured" 어노테이션으로 권한 설정 가능
    -   @Secured("권한 이름") 선언
        -   권한 1개 이상 설정 가능 

``` java
// 관리자, 등록된 모든 관심 상품 조회
@Secured("ROLE_ADMIN")  // 권한이 ADMIN인 회원만 접근가능
@GetMapping("/api/admin/products")
public List<Product> getAllProducts() {
    return productService.getAllProducts();
}
```

-   "@Secured" 어노테이션 활성화 방법

``` java
@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
@EnableGlobalMethodSecurity(securedEnabled = true) // @Secured 어노테이션 활성화
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
```

<br>

### 소셜 로그인 사용하기 ( OAuth )

카카오 로그인 사용하기

![소셜로그인-카카오](https://user-images.githubusercontent.com/59812251/173507807-e522c32f-50bf-4a6e-aff5-e8d340d0e833.png)


일단 카카오 로그인을 사용하기 위해서는 카카오 개발 사이트에서 '애플리케이션 등록'이 필요하다.  
'카카오 개발자' 사이트로 이동하여, 회원가입을 진행하고, 본인만의 애플리케이션을 등록을 한다.  
카카오 서버에 인가코드를 요청하고, 인가 코드를 전달 받는다.

인가코드 요청 방법
```
https://kauth.kakao.com/oauth/authorize?client_id={REST_API_KEY}&redirect_uri={REDIRECT_URI}&response_type=code
```

등록한 앱의 REST API 키와, 인가코드를 응답으로 받을 URI주소를 입력한다.  
이렇게 설정하면, 카카오 서버에 인가코드를 요청하고 응답을 받을 수 있게 된다.

예시)

![소셜로그인-카카오2](https://user-images.githubusercontent.com/59812251/173507898-9eb3c061-e724-4ac2-8a8f-ea7f768acb1a.png)


'동의하고 계속하기'를 클릭하면, 인가코드가 넘어온다

넘어오는 인가코드를 Controller로 받고, 인가코드를 가지고 구체적인 카카오 로그인 처리는 Service에서 수행한다.

Service에서 '인가 코드로 토큰 요청'과 '토큰으로 API 호출'을 수행하고, 카카오 회원 정보를 얻어온다.