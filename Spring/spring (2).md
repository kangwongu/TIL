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