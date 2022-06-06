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