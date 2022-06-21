# 스프링 클라우드
MSA 구현을 위한 도구 모음이다.  
모든 프로젝트를 처음부터 MSA로 구현하기는 어렵고, 도메인 분리와 각 도메인간 하드웨어 할당이 어느정도 되어 있어야 MSA로 구현이 가능하다.

<br>

## Service Discovery
MSA의 핵심 요소 중 한가지이며, 각 서비스의 위치를 알 수 있도록 하는 기능을 제공한다.  
Service Discovery의 기술 중 하나인 **Eureka**는 application.properties에 어플리케이션 이름으로 ip주소와 포트를 대체한다.

즉, 지정한 애플리케이션 이름으로 통신이 가능해진다는 간편함 제공


EurekaServer)  
스프링 부트 프로젝트를 생성할 때, Eureka Server 의존성 추가해줘야 한다

![유레카 서버](https://user-images.githubusercontent.com/59812251/174707880-5c067668-ed15-4273-8247-7a97fb52ead9.png)

EurekaServer의 포트번호를 8761로 설정하고, 애플리케이션 이름을 설정한다.

<br>

![유레카 서버2](https://user-images.githubusercontent.com/59812251/174707879-c2562468-9890-4148-a706-3c78711a0aad.png)

@EnableEurekaServer 애노테이션을 붙여준다.


<br>

EurekaClient)  
스프링 부트 프로젝트를 생성할 때, Eureka Discovery Client 의존성 추가해줘야 한다

![유레카 클라이언트](https://user-images.githubusercontent.com/59812251/174707876-6f8c6b81-be11-434c-bc60-5de90603bc52.png)

랜덤 포트로 설정했고, 애플리케이션 이름을 설정했다.

<br>

![유레카 클라이언트2](https://user-images.githubusercontent.com/59812251/174707875-cd5f7d79-9ac1-4c42-8bce-d3431a72104c.png)

@EnableEurekaClient 애노테이션을 붙여준다.

<br>

EurekaServer, EurekaClient를 만들면 EurekaClient가 EurekaServer에 등록된다.  
localhost:8761)

![등록](https://user-images.githubusercontent.com/59812251/174707874-089a19bf-d166-4d80-935f-1cc1553244af.png)

EurekaClient의 ip주소, 포트번호를 몰라도 지정한 애플리케이션 이름으로 접근할 수 있다.

<br>

## Spring Cloud Gateway

HTTP 요청이 들어올 통일된 창구가 필요한데, Eureka는 단지 등록된 서비스들을 관리하는 역할만 수행한다.

스프링 클라우드 게이트웨이를 사용해서 통일된 창구를 만들어 줄 수 있다.

Gateway)  
스프링 부트 프로젝트를 생성할 때, Gateway, Eureka Discovery Client 의존성 추가해줘야 한다.

![게이트웨이](https://user-images.githubusercontent.com/59812251/174707871-ceba8443-cf00-4386-8cfd-0e54214c2ee9.png)

포트와 애플리케이션 이름을 설정해주고, 라우트할 정보를 설정했다.

<br>

![게이트웨이2](https://user-images.githubusercontent.com/59812251/174707870-f777522d-0bc6-4874-9bc0-5e062056dc4c.png)

HTTP 요청이 들어오면, 게이트웨이가 받고, 해당하는 서비스로 중개해준다.

<br>

EurekaClient(my-service1)에 컨트롤러를 만들었다.

![myservice1컨트롤러](https://user-images.githubusercontent.com/59812251/174707869-bed3c244-de6a-4834-adf3-5bc26969cd9b.png)


[http://localhost:8080/serv1/test](http://localhost:8080/serv1/test)로 접근하면, 게이트웨이로 설정한 8080포트로 요청이 들어가고 라우팅 정보에 따라 해당 서비스로 중개해준다.

<br>

Eureka에 등록된 my-service1의 컨트롤러로 접근되는 것을 확인할 수 있다.

![화면](https://user-images.githubusercontent.com/59812251/174707866-b778c878-13c5-45bd-ab64-3e28dd8c2703.png)

<br>

필터를 사용해서 요청 URL을 생략도 가능하다.

게이트웨이 application.yml에 RewirtePath를 추가해준다

```jsx
cloud:
    gateway:
      routes:
        - id: my-serv1
          uri: lb://MY-SERVICE1
          predicates:
            - Path=/serv1/**
          filters:
            - RewritePath=/serv1/?(?<segment>.*), /$\{segment}
```

my-service1 서비스로 가는 요청은 /serv1이 붙게 된다.

위의 MyController의 요청 URL을 `/serv1/test` 에서 `/test` 로 변경할 수 있게된다.