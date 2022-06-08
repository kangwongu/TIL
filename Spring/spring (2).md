# 스프링 핵심 원리 - 기본편

스프링 부트는 스프링을 쉽게 사용할 수 있게 해주는 것이다.  
스프링 부트만으로 무엇인가 할 수는 없다.

<br>

## 스프링의 핵심 개념

객체 지향 애플리케이션을 개발할 수 있게 도와주는 프레임워크

<br>

## 좋은 객체지향 프로그래밍?

프로그램을 유연하고 변경이 용이하게 한다.
```
레고 블록 조립하듯이 컴포넌트를 쉽고 유연하게 변경하면서 개발하는 것!
-> 다형성
```

### 다형성

역할과 구현으로 세상을 구분한다.

![다형성](https://user-images.githubusercontent.com/59812251/171974882-d10b31b8-29cf-4c50-a17d-ff6dc866a001.png)


단순하게 바라 볼 수 있고, 유연해지며 변경이 편리해진다는 이점이 발생한다.

클라이언트에 영향을 주지 않고 새로운 기능을 제공할 수 있다.  
새로운 구현체가 나와도, 클라이언트에서 수정할 필요가 없다.  
클라이언트는 대상의 역할(인터페이스)만 알면 된다. (내부 구조 몰라도 ok, 내부 구조 변경되어도 영향 x)

<br>

자바의 다형성이 위의 개념을 구현했다.  
역할 = 인터페이스  
구현 = 인터페이스를 구현한 클래스

객체 설계 시, 역할과 구현을 정확히 분리해야 한다.
-> 객체 간 협력 관계를 그대로 재사용할 수 있다!

<br>

## 스프링과 객체지향

스프링은 다형성을 극대화해서 이용할 수 있게 도와준다.  
스프링 DI, IoC는 다형성을 활용해서 역할과 구현을 편리하게 다룰 수 있도록 지원한다.

<br>

## 객체지향 설계 5가지 원칙 (SOLID)
```
SRP (Single Responsibility Principle) - 단일 책임 원칙
OCP (Open/Closed Principle) - 개방-폐쇄 원칙
LSP (Liskov Substitution Principle) - 리스코프 치환 원칙
ISP (Interface Segregation Principle) - 인터페이스 분리 원칙
DIP (Dependency Inversion Principle) -  의존관계 역전 원칙
```

<br>

### SRP
하나의 클래스는 하나의 책임만 가져야 한다.  
중요한 기준은 변경이며, 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것이다.  
ex) 객체의 생성과 사용 분리

<br>

### OCP
확장에는 열려있으나, 변경에는 닫혀있어야 한다.  
다형성을 활용

<br>

### LSP
하위클래스는 인터페이스 규약을 지켜야 한다.
ex) 자동차 인터페이스의 '엑셀'기능은 앞으로 가는 것, 뒤로 가게 구현하면 LSP 위반

<br>

### ISP
인터페이스를 기능별로 나누는 것  
분리로 인해, 인터페이스가 명확해지고, 대체하기 쉬워진다.  
ex) 자동차 인터페이스 -> 운전 인터페이스, 정비 인터페이스

<br>

### DIP
클라이언트가 구현 클래스에 의존하지 말고 인터페이스에 의존해야 한다는 것  
구현이 아닌 역할에 의존해야 한다. 구현(구현 클래스)에 의존하면 변경이 어려워지기 때문!  
역할(인터페이스)에 의존해야 유연하게 변경할 수 있다.

<br>

다형성 만으로 유연하고 변경이 용이하게 개발할 수 없다.  
구현 객체를 변경할 때 클라이언트 코드 변경 (OCP 위반)  
인터페이스에 의존하지만 구현 클래스에도 의존하게 된다. (DIP 위반)  
이러한 문제를 스프링에서 해결했다. (DI 사용)

<br>

### OCP, DIP 준수하기

자바의 다형성만으로는 OCP, DIP 위반 문제를 해결할 수 없다.

``` java
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
```
기존 코드 변경을 위해 FixDiscountPolicy -> RateDiscountPolicy로 변경을 하는 즉시 OCP를 위반한다. (코드가 변경됐기 때문에)

또한, 추상(인터페이스)뿐만 아니라 구현(구현 클래스)에도 의존하고 있기에 DIP 위반이다.

인터페이스에만 의존하도록 변경하면 해결?
``` java
//private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
 private DiscountPolicy discountPolicy;
```
이렇게 변경하면 DIP는 지켜지지만 NullPointerException이 발생

**해결방안**은 누군가 DiscountPolicy의 구현 객체를 대신 생성하고 주입해주어야 한다. (DI)

<br>

#### AppConfig
구현 객체를 생성하고 연결하는 책임을 가지는 별도의 설정 클래스

``` java
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
```
실제 동작에 필요한 구현 객체를 AppConfig 클래스에서 생성한다.  
생성한 객체들은 생성자를 통해서 주입(연결)해준다.

``` java
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 직접 생성하지 않고 생성자를 통해 외부에서 주입하도록 함 -> 추상에만 의존하게 되므로 DIP가 준수됨
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    ...
}
```
OrderServiceImpl의 생성자를 통해서 어떤 구현 객체를 주입할지는 오직 외부(AppConfig)에서 결정되며, 의존관계에 대한 부분은 외부에 맡기고 실행에만 집중할 수 있게 된다.

<br>

#### AppConfig 리팩토링

중복을 제거하고, 역할에 따른 구현이 잘 보일수있도록 변경한다.
``` java
public class AppConfig {

    // 역할과 구현이 드러남, 설계에 대한 그림이 드러난다.
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    private MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
```
기존의 new MemoryMemberRepository()부분 중복을 제거했다.

리팩토링 후를 보면, 역할과 구현 클래스가 한눈에 들어오며 애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악할 수 있다.

<br>

### AppConfig 등장의 의미

AppConfig 등장으로 애플리케이션이 크게 사용 영역과, 객체를 생성하고 구성하는 영역으로 분리되었다.

![AppConfig](https://user-images.githubusercontent.com/59812251/172087569-f17c0897-bb55-4b00-ba02-1fe38c551af3.png)

FixDiscountPolicy에서 RateDiscountPolicy로 변경해도 구성 영역인 AppConfig만 변경되고, 사용 영역(OrderServiceImpl)에선 전혀 영향을 받지 않는다.

이를 통해, OCP와 DIP를 준수할 수 있게 된다!

<br>

## IoC, DI, 컨테이너

### IoC
프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 제어의 역전(IoC)이라고 한다.

AppConfig 사용으로, 구현 객체는 자신의 로직을 실행하는 역할만 담당하고, 제어 흐름은 AppConfig가 담당한다

<br>

### DI
애플리케이션 실행 시점에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결되는 것을 의존관계 주입이라고 한다.

<br>

### IoC 컨테이너, DI 컨테이너
AppConfig처럼 객체를 생성하고 관리하면서 의존관계를 연결해 주는 것을 IoC 컨테이너 / DI 컨테이너라고 하며, 최근에는 주로 DI 컨테이너라고 한다.

<br>

## 스프링으로 전환하기

기존에 작성한 AppConfig 클래스를 스프링에서 사용하기 위해 바꿔준다.
``` java
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }
    ...
}
```

<br>

적용
``` java
public class OrderApp {
    public static void main(String[] args) {
//        기존 방식
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        // 스프링 컨테이너, 모든 객체들을 관리 (bean), AppConfig안에 있는 정보들을 전부 스프링 컨테이너에 넣는다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // 스프링 컨테이너에서 객체를 가져온다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        ...
    }
}
```

<br>

### 스프링 컨테이너
ApplicationContext(인터페이스)를 스프링 컨테이너라고 한다.  
기존에는 직접 AppConfig를 사용해서 직접 객체를 생성하고 DI를 해줬지만, 이제부터는 스프링 컨테이너를 통해서 사용한다.

@Configure이 붙은 AppConfig를 설정 정보로 사용하며, @Bean이 붙은 메소드를 모두 호출해 반환된 객체를 스프링 컨테이너에 등록한다.  
이 때, 등록된 객체를 스프링 빈이라고 한다.

등록 후, 스프링 컨테이너는 설정 정보를 참고해서 의존관계를 주입(DI)한다.

이전에는 필요한 객체를 AppConfig를 사용해서 얻어왔지만, 이제부터는 스프링 컨테이너를 통해서 스프링 빈(객체)를 찾아야 한다.

<br>

#### 빈 조회하기

``` java
AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext([설정정보 클래스]);

// 모든 빈 이름 출력하기
// 1. 빈 이름 조회
ac.getBeanDefinitionNames()
// 2. 빈 이름으로 빈 객체 조회
ac.getBean(빈이름, 타입) / ac.getBean(타입)

// 해당 타입의 모든 빈 조회하기
ac.getBeansOfType([타입])
```

**빈 상속 관계**

부모 타입으로 조회하면, 자식 타입도 함께 조회된다.

<br>

### 싱글톤 컨테이너

우리가 기존에 만들었던 순수한 DI 컨테이너인 AppConfig는 요청을 할 때마다 새로운 객체를 생성하는데, 이는 메모리 낭비가 심하다.  

웹 어플리케이션은 보통 여러 고객이 동시에 요청을 하기 때문에, 싱글톤으로 설계해야 한다.

<br>

스프링 컨테이너는 객체를 싱글톤으로 관리한다.  
싱글톤 컨테이너 역할을 하며, 이로 인해 고객의 요청이 올 때 마다 객체를 새로 생성하는 것이 아니라, 이미 만들어진 객체를 공유해서 효율적으로 재사용할 수 있게된다.

<br>

#### 싱글톤 방식의 주의점

여러 클라이언트가 하나의 같은 객체 인스턴스를 공유하기 때문에 상태를 유지(stateful)하게 설계하면 절대 안된다!  
무상태(stateless)로 설계해야 한다!

예시
``` java
public class StatefulService {
    private int price;  // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제
    }

    public int getPrice() {
        return price;
    }
}
```

``` java
@Test
void statefulServiceSingleton() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    StatefulService statefulService1 = ac.getBean(StatefulService.class);
    StatefulService statefulService2 = ac.getBean(StatefulService.class);

    // ThreadA: A사용자 10000원 주문
    statefulService1.order("userA", 10000);
    // ThreadB: B사용자 20000원 주문
    statefulService2.order("userB", 20000);

    // ThreadA : 사용자A 주문 금액 조회
    int price = statefulService1.getPrice();
    //ThreadA: 사용자A는 10000원을 기대했지만, 기대와 다르게 20000원 출력
    System.out.println(price);

    Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
}
```
```
[출력]
name = userA price = 10000
name = userB price = 20000
20000
```
A사용자는 10000원을 주문했는데 20000원이 주문되는 대참사 발생!

필드가 공유되기 때문에 이런 현상이 발생한다.  
따라서 스프링 빈은 항상 무상태(stateless)로 설계해야 한다. (지역변수, 파라미터, ThreadLocal등등)

변경 예시
``` java
public class StatefulService {

    // private int price;  // 상태를 유지하는 필드를 사용하지 않는다

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        // this.price = price; // 여기가 문제
        return price;
    }
}
```
공유되는 필드를 제거한다. 

<br>

### @Configuration

스프링 컨테이너는 싱글톤 레지스트리(싱글톤 객체를 생성하고 관리하는 기능)로, 스프링 빈이 싱글톤이 되도록 보장해야 한다.  
스프링은 이를 위해 @Configuration을 적용토록 했다. (설정클래스에 @Configuration 붙이기)

이 애노테이션이 붙으면 CGLIB라는 바이트코드 조작 라이브러리를 사용해서, 개발자가 작성한 클래스가 아니라 작성한 클래스를 상속받은 임의의 다른 클래스를 만들고, 그 다른 클래스를 스프링 빈으로 등록한다.  
이 클래스가 싱글톤이 보장되도록 해준다  
```
@Bean이 붙은 메서드마다 이미 스프링 빈이 존재하면 존재하는 빈을 반환하고, 스프링 빈이 없으면
생성해서 스프링 빈으로 등록하고 반환하는 코드가 동적으로 만들어진다
```

<br>

### 컴포넌트 스캔

직접 스프링 빈으로 등록하는 것은 귀찮은 일이기에, 스프링은 설정 정보가 없어도 자동으로 스프링 빈을 등록하는 컴포넌트 스캔 기능을 제공한다.

컴포넌트 스캔을 사용하려면 `@ComponentScan`을 설정 정보에 붙이면 된다.  
이전과 다르게, 직접 @Bean으로 등록하지 않아도 된다.

``` java
@Configuration
@ComponentScan
public class AutoAppConfig {

}
```

<br>

컴포넌트 스캔은 `@Component`애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록한다.  
ex) MemberServiceImpl -> memberServiceImpl
``` java
@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // 스프링 컨테이너가 자동으로 해당 스프링 빈을 찾아 주입
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    ...
}
```
이전엔 설정 클래스(AppConfig)에서 @Bean으로 직접 설정 정보를 작성했고, 의존관계도 직접 명시했지만, 이제는 설정 정보 자체가 없기 때문에 의존관계 주입을 클래스 내에서 해결해야 한다.  
`@Autowired`를 사용해 의존관계를 자동으로 주입한다  

<br>

스캔할 위치를 지정할 수 있다.
``` java
@ComponentScan(
 basePackages = "hello.core",
)
```
하지만 권장하는 방법으로는 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것이다.  
```
com.hello
com.hello.serivce
com.hello.repository

com.hello에 설정 정보 클래스를 두고 @ComponentScan을 붙이고, basePackages를 생략한다.

이렇게 하면 com.hello를 포함한 하위는 모두 자동으로 컴포넌트 스캔의 대상이 된다.
```

<br>

#### 컴포넌트 스캔 기본 대상
```
@Component : 컴포넌트 스캔에서 사용
@Controlller : 스프링 MVC 컨트롤러에서 사용
@Service : 스프링 비즈니스 로직에서 사용
@Repository : 스프링 데이터 접근 계층에서 사용
@Configuration : 스프링 설정 정보에서 사용
```

<br>

#### 필터

@ComponentScan에 필터 정보를 추가한다.
```
includeFilters : 컴포넌트 스캔 대상을 추가로 지정한다.
excludeFilters : 컴포넌트 스캔에서 제외할 대상을 지정한다.
```

옵션
```
ANNOTATION: 기본값, 애노테이션을 인식해서 동작한다.
ex) org.example.SomeAnnotation

ASSIGNABLE_TYPE: 지정한 타입과 자식 타입을 인식해서 동작한다.
ex) org.example.SomeClass

ASPECTJ: AspectJ 패턴 사용
ex) org.example..*Service+

REGEX: 정규 표현식
ex) org\.example\.Default.*

CUSTOM: TypeFilter 이라는 인터페이스를 구현해서 처리
ex) org.example.MyTypeFilter
```

개인적으로 옵션을 변경하면서 사용하기보다는 스프링의 기본 설정에 최대한 맞추어 사용하는 것이 권장된다.

<br>

#### 중복 등록과 충돌
컴포넌트 스캔에 의해 자동으로 스프링 빈이 등록될 때 이름이 같다면 ConflictingBeanDefinitionException 예외가 발생한다.

수동 빈 등록과 자동 빈 등록에서 빈 이름이 충돌되면 수동 빈 등록이 우선권을 가진다.  
(최근 스프링 부트에선 수동 빈 등록과 자동 빈 등록이 충돌나면 오류가 발생하도록 기본값이 변경됨)

<br>

### 다양한 의존관계 주입 방법

크게 4가지 방법이 존재
```
생성자 주입
수정자 주입(setter 주입)
필드 주입
일반 메소드 주입
```

<br>

#### 생성자 주입
불변, 필수 의존관계에 주로 사용되고 대체로 생성자 주입을 통해 의존관계를 주입한다.

``` java
@Component
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    // 생성자 주입
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy
    discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
}
```

<br>

#### 수정자 주입
선택, 변경 가능성이 있는 의존관계에 사용한다.  
많이 쓰이진 않는 방식이다.

``` java
@Component
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    // 수정자 주입
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
```

<br>

#### 필드 주입
필드에 바로 주입하는 방식이다.  
이 방법은 더 이상 사용되지 않는다.  
외부에서 변경이 불가능해서 테스트가 어렵다는 단점이 존재한다

``` java
@Component
public class OrderServiceImpl implements OrderService {
    // 필드 주입 방식
    @Autowired
    private MemberRepository memberRepository;
    
    @Autowired
    private DiscountPolicy discountPolicy;
}
```

<br>

#### 일반 메소드 주입
일반 메소드를 통해서 주입받을 수도 있다.  
일반적으로 사용하지 않는다.

``` java
@Component
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    // 일반 메소드 주입
    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy
    discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
}
```

<br>

### 옵션 처리
주입할 스프링 빈이 없다면?  

자동 주입 대상을 옵션으로 처리하는 방법
```
@Autowired(required=false) : 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
org.springframework.lang.@Nullable : 자동 주입할 대상이 없으면 null이 입력된다.
Optional<> : 자동 주입할 대상이 없으면 Optional.empty 가 입력된다.
```

<br>

예시)  
Member클래스는 스프링 빈으로 등록되어 있지 않다고 가정
``` java
@Autowired(required = false)
public void setNoBean1(Member member1) {
    System.out.println("member1 = " + member1);
}

@Autowired
public void setNoBean2(@Nullable Member member2) {
    System.out.println("member2 = " + member2);
}

@Autowired
public void setNoBean3(Optional<Member> member3) {
    System.out.println("member3 = " + member3);
}
```
```
[출력]
member2 = null
member3 = Optional.empty
```

<br>

### Lombok

생성자 주입 방식은 좋지만 코드를 많이 작성해야 한다.  
생성자, 주입 받은 값을 대입하는 코드 등등..

이를 개선하기위해 Lombok이 등장했다

``` java
// build.gradle
configurations {
    compileOnly {
    extendsFrom annotationProcessor
    }
}

compileOnly 'org.projectlombok:lombok'
annotationProcessor 'org.projectlombok:lombok'
testCompileOnly 'org.projectlombok:lombok'
testAnnotationProcessor 'org.projectlombok:lombok'
```

plugin - lombok 설치  
Annotation Processors -> Enable annotation processing 체크

<br>

### @Autowired 필드 명, @Qualifier, @Primary

@Autowired는 타입으로 조회를 한다.  
타입으로 조회했을 때, 선택된 빈이 2개 이상이면 문제가 발생한다.

``` java
@Component
public class FixDiscountPolicy implements DiscountPolicy {}

@Component
public class RateDiscountPolicy implements DiscountPolicy {}
```
DiscountPolicy의 하위 타입들을 스프링 빈으로 선언하고, @Autowired로 의존관계 자동 주입을 하면 오류(NoUniqueBeanDefinitionException)가 발생한다.

#### 해결 방법
```
@Qualifier -> @Qualifier끼리 매칭 -> 빈 이름 매칭
@Primary 사용
```

<br>

**@Qualifier 사용**

추가 구분자를 붙여주는 방법

``` java
@Component
@Qualifier("mainDiscountPolicy")
public class RateDiscountPolicy implements DiscountPolicy {}
```

주입할 때 등록한 이름을 붙인다.
``` java
@Autowired
public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
}
```
@Qualifier로 주입할 때, 등록한 이름을 못찾으면, 스프링 빈 이름에서 찾는다.  
(@Qualifier는 @Qualifier를 찾는 용도로만 사용하는게 명확)

<br>

추가로, 위에서 @Qualifier를 사용할 때, 아래와 같이 사용했는데, 이렇게 문자열로 적으면 컴파일시 타입 체크가 안되는 문제가 발생한다.  
애노테이션을 만들어서 이를 해결할 수 있다.
``` java
@Component
@Qualifier("mainDiscountPolicy") DiscountPolicy
```

<br>

애노테이션 사용
``` java
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {}
```

**@Primary 사용**

우선순위를 정하는 방법이며, @Autowired시에 여러 빈이 매칭될 때 우선권을 갖는다.

``` java
@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy {}

@Component
public class FixDiscountPolicy implements DiscountPolicy {}
```
우선권을 RateDiscountPolicy가 갖는다.  
선택된 빈이 2개여서 오류가 발생했었는데, 우선순위를 설정하면 오류가 발생하지 않는다.

<br>

### 조회한 빈이 모두 필요할 때

해당 타입의 스프링 빈이 다 필요한 경우도 있을 수 있는데, 이때는 List, Map을 사용해 조회한 빈을 담는다.

<br>

### 자동/수동 운영 기준

어플리케이션은 크게 업무 로직과 기술 지원 로직으로 나눌 수 있다.
```
업무 로직 빈
- 웹을 지원하는 컨트롤러, 핵심 비즈니스 로직이 있는 서비스, 데이터 계층의 로직을 처리하는
리포지토리등이 모두 업무 로직이다. 보통 비즈니스 요구사항을 개발할 때 추가되거나 변경된다

기술 지원 빈
- 기술적인 문제나 공통 관심사(AOP)를 처리할 때 주로 사용된다. 데이터베이스 연결이나,
공통 로그 처리 처럼 업무 로직을 지원하기 위한 하부 기술이나 공통 기술들이다
```

기술 지원 로직들은 가급적 수동 빈 등록을 사용해서 명확하게 드러내는 것이 좋다


다형성을 적극 활용하는 비즈니스 로직도 수동으로 등록하는 것이 좋은 방법일 수 있다.  
자동으로 하면 특정 패키지에 같이 묶어두는 것이 좋다.

<br>

### 빈 생명주기 콜백
애플리케이션 시작 시점에 필요한 연결을 미리 해두고,
애플리케이션 종료 시점에 연결을 모두 종료하는 작업을 진행하려면, 객체 초기화와 종료 작업이 필요하다.

스프링을 통해 이러한 초기화 작업과 종료 작업은 어떻게 할까?  
(빈 생명주기 콜백)

```
객체 생성 -> 의존관계 주입
```
스프링 빈은 위와 같은 단계를 거친 후에야 필요한 데이터를 사용할 수 있는 준비가 완료된다.  
스프링은 의존관계 주입이 완료되면 스프링 빈에게 콜백 메소드를 통해서 초기화 시점을 알려주는 기능들을 제공하며, 스프링 컨테이너가 종료되기 직전에 소멸 콜백을 준다.

<br>

스프링 빈의 이벤트 라이프 사이클
```
1. 스프링 컨테이너 생성
2. 스프링 빈 생성
3. 의존관계 주입
4. 초기화 콜백
5. 사용
6. 소멸전 콜백
7. 스프링 종료

초기화 콜백: 빈이 생성되고, 빈의 의존관계 주입이 완료된 후 호출
소멸전 콜백: 빈이 소멸되기 직전에 호출
```

<br>

스프링은 다양한 방식으로 생명주기 콜백을 지원한다.
```
인터페이스(InitializingBean, DisposableBean)
설정 정보에 초기화 메서드, 종료 메서드 지정
@PostConstruct, @PreDestroy 애노테이션 지원
```

#### 인터페이스 InitializingBean, DisposableBean

지금은 거의 사용하지 않는 방법이다.  
인터페이스를 구현해 초기화와 소멸을 구현한다.

``` java
public class NetworkClient implements InitializingBean, DisposableBean {

    ...
    // 스프링이 의존관계 주입 끝나면 호출
    // 초기화 콜백
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    // 소멸전 콜백
    @Override
    public void destroy() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
```

<br>

#### 빈 등록 초기화, 소멸 메서드 지정
설정 정보에 초기화, 소멸 메소드를 지정하는 방법이다.  
코드를 고칠 수 없는 외부 라이브러리를 초기화, 종료해야 할 때 사용한다.

``` java
public class NetworkClient {

    ...
    // 초기화 콜백
    public void init() {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    // 소멸전 콜백
    public void close() {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
```

<br>

빈을 등록할 때, 초기화, 소멸 메소드를 지정한다.
``` java
@Bean(initMethod = "init", destroyMethod = "close")
public NetworkClient networkClient() {
    NetworkClient networkClient = new NetworkClient();
    networkClient.setUrl("http://hello-spring.dev");
    return networkClient;
}
```

<br>

#### 애노테이션 @PostConstruct, @PreDestroy
애노테이션을 사용해 초기화와 소멸 메소드를 지정한다.  
이것을 메인으로 사용하고 외부 라이브러리를 초기화, 소멸할 때는 @Bean의 기능을 사용한다.

``` java
public class NetworkClient {

    ...
    // 스프링이 의존관계 주입 끝나면 호출
    // 초기화 콜백
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    // 소멸전 콜백
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
```
<br>

### 빈 스코프
빈이 존재할 수 있는 범위를 뜻한다.

<br>

스코프 종류
```
싱글톤: 기본 스코프, 스프링 컨테이너의 시작과 종료까지 유지되는 가장 넓은 범위의 스코프이다.

프로토타입: 스프링 컨테이너는 프로토타입 빈의 생성과 의존관계 주입까지만 관여하고 더는 관리하지 않는
매우 짧은 범위의 스코프이다.
```

<br>

등록 방법
``` java
// 자동
@Scope("prototype")
@Component
public class HelloBean {}

// 수동
@Scope("prototype")
@Bean
PrototypeBean HelloBean() {}
```

<br>

#### 프로토타입 스코프
프로토타입 스코프를 스프링 컨테이너에 조회하면 스프링 컨테이너는 항상 새로운 인스턴스를 생성해서
반환한다.  
이는, 프로토타입 스코프에서 생성되는 빈은 생성, 의존관계 주입, 초기화까지만 처리된다는 것을 의미한다.  
클라이언트에 빈을 반환하고, 이후 스프링 컨테이너는 생성된 빈을 관리하지 않는다.

따라서, 종료 메소드가 호출되지 않고 클라이언트가 직접 호출해야 한다.

<br>

프로토타입 스코프를 싱글톤 빈과 함께 사용할 때는 Provider를 사용한다.

``` java
@Scope("singleton")
static class ClientBean {

    // 지정한 빈을 컨테이너에서 대신 찾아준다 (여기서 PrototypeBean은 프로토타입 스코프)
    @Autowired
    private ObjectProvider<PrototypeBean> prototypeBeanProvider;


    public int logic() {
        // 항상 새로운 프로토타입 빈이 생성된다.
        PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
        prototypeBean.addCount();
        return prototypeBean.getCount();
    }
}
```
DL(Dependency Lookup) : 직접 필요한 의존관계를 찾는 것  
ObjectProvider의 getObject()를 호출하면 내부에서는 스프링 컨테이너에서 해당 빈을 찾아서 반환한다. (DL)

<br>

### 웹 스코프
웹 환경에서 동작하며, 스프링이 해당 스코프의 종료시점까지 관리한다.

웹 스코프는 웹 환경에서만 동작하기 때문에 라이브러리를 추가해야 한다.

``` java
// build.gradle
implementation 'org.springframework.boot:spring-boot-starter-web'
```
스프링 부트가 내장 톰캣 서버를 활용해 웹 서버와 스프링을 함께 실행시킨다

<br>

```
웹 스코프 종류
request: HTTP 요청 하나가 들어오고 나갈 때 까지 유지되는 스코프, 각각의 HTTP 요청마다 별도의 빈
인스턴스가 생성되고, 관리된다.
session: HTTP Session과 동일한 생명주기를 가지는 스코프
application: 서블릿 컨텍스트( ServletContext )와 동일한 생명주기를 가지는 스코프
websocket: 웹 소켓과 동일한 생명주기를 가지는 스코프
```

request 스코프 빈은 HTTP 요청이 들어와야 생성된다.

<br>

### 프록시

``` java
@Component
// 클래스 - TARGET_CLASS, 인터페이스 - INTERFACES
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
}
```
request 스코프의 빈인 MyLogger의 가짜 프록시 클래스를 만들어두고, HTTP 요청과 상관없이 가짜 프록시 클래스를 다른 빈에 미리 주입하는 게 가능하다.

진짜 객체 조회를 필요한 시점까지 지연처리할 수 있다!
(MyLogger는 request 스코프이기 때문에 HTTP 요청이 와야 생성된다. 따라서 일반 싱글톤 빈의 멤버로 있으면 에러가 발생하는데, 이를 해결해준다.)

``` java
@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    // 에러, MyLogger는 request 스코프이기 때문에 일반 싱글톤 빈은 주입가능하지만, MyLogger는 생성되지 않는다.
    private final MyLogger myLogger;

    ...
}
```
프록시를 사용하지 않은 request 스코프 빈(MyLogger)은 에러가 발생했지만, 프록시를 적용하면 에러가 발생하지 않는다.

프록시가 적용되면, 가짜 프록시 객체를 생성하고, 이 객체는 request 스코프와 관계가 없다.  
이 객체의 내부에는 요청이 오면 진짜 빈을 요청하는 위임 로직이 포함되어 있다.

정리해보면, 프록시가 적용되면 가짜 객체가 생성된다.  
LogDemoController 멤버의 MyLogger는 가짜 객체이며 reqeust 스코프 빈이 아니기 때문에 문제가 없다.  
후에 이 객체를 사용할 때, 진짜 MyLogger를 호출한다.