# 스프링 심화반 4주차

## ORM (Object-Relational Mapping)
백엔드 개발자가  SQL 작성보다 비즈니스 로직 개발에 더 많은 노력을 들일 수 있도록 하기 위해 등장한 기술

![ORM](https://user-images.githubusercontent.com/59812251/173481251-1ff35b3f-2d1e-4d00-80e2-786595a422a8.png)

<br>

## JPA (Java Persistence API)
자바 ORM 기술에 대한 표준 명세이다.  
이전엔 SQL 매퍼(MyBatis, JdbcTemplate)위주로 개발했었는데, 최근엔 JPA 사용 빈도가 높아졌다.  
JPA를 구현한 프레임워크 중 가장 많이 쓰이는 것이 '하이버네이트'

![JPA](https://user-images.githubusercontent.com/59812251/173481258-0b7a3f71-d27e-46b2-a40d-957dd2f62e70.png)

<br>

## Spring Data JPA
위의 JPA와 다른 개념이다.  
JPA를 편리하게 사용하기 위해 JPA를 기반으로 한 Spring Data JPA가 탄생했다.  
Repostiory 인터페이스만 작성하면, 필요한 구현은 스프링이 대신 알아서 해주는 장점이 있다.

쿼리메소드 작성 방법
```
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
```

<br>

## 영속성 컨텍스트
영속성 컨텐스트란 엔티티를 영구 저장하는 환경이라는 뜻이다.  
애플리케이션과 데이터베이스 사이에서 객체를 보관하는 가상의 데이터베이스 같은 역할을 한다.

### 영속성 컨텍스트 매니저
객체와 DB의 소통을 효율적으로 관리하며, 영속성 컨텍스트 매니저가 관리하는 것이 영속성 컨텍스트이다.

### 1차 캐시
영속성 컨텍스트의 1차 캐시를 사용하면, DB 조회를 줄일 수 있어서 그에 따른 성능 향상을 기대할 수 있고, 객체의 동일성을 보장한다.

저장)

![1차캐시 저장](https://user-images.githubusercontent.com/59812251/173575576-cc1c2303-4bfe-42b5-9c4d-2b19143eb5ef.png)

<br>

조회)

![1차캐시 조회1](https://user-images.githubusercontent.com/59812251/173575583-e136168b-d739-41ca-92e1-36a283f4dd4c.png)

![1차캐시 조회2](https://user-images.githubusercontent.com/59812251/173575587-2e4bcbc3-07b5-456b-aa59-c7fcfacfbbe7.png)

<br>

삭제)

![1차캐시 삭제](https://user-images.githubusercontent.com/59812251/173575590-5c49f0e2-eb35-4e72-89a8-1ea591000074.png)

<br>

수정)

![1차캐시 업데이트 실패](https://user-images.githubusercontent.com/59812251/173575592-c1986529-7389-4047-8400-2f6fa198fcae.png)

1차 캐시 Entity 객체에만 업데이트 반영되고, User DB 에는 반영되지 않는다.  

<br>

Repository의 save메소드, @Transactional 사용으로 해결할 수 있다.

save메소드 사용

![1차캐시 업데이트 성공1](https://user-images.githubusercontent.com/59812251/173575594-a01d0023-7899-4a67-80fd-a6e58e102453.png)

``` java
public User updateUser1() {
    // 테스트 회원 "user1" 생성
    User user = new User("user1", "RM", "고기");
    // 회원 "user1" 객체를 영속화
    User savedUser1 = userRepository.save(user);
    // 회원의 nickname 변경
    savedUser1.setNickname("남준이");
    // 회원의 favoriteFood 변경
    savedUser1.setFavoriteFood("육회");
    // user1 을 저장
    User savedUser2 = userRepository.save(savedUser1);
    assert(savedUser1 == savedUser2);
    return savedUser2;
}
```

<br>

@Transactional 사용

``` java
@Transactional
public User updateUser2() {
    // 테스트 회원 "user1" 생성
    // 회원 "user1" 객체 추가
    User user = new User("user1", "진", "꽃등심");
    // 회원 "user1" 객체를 영속화
    User savedUser = userRepository.save(user);
    // 회원의 nickname 변경
    savedUser.setNickname("월드와이드핸섬 진");
    // 회원의 favoriteFood 변경
    savedUser.setFavoriteFood("까르보나라");
    return savedUser;
}
```
함수가 끝나는 시점에 변경된 부분을 알아서 업데이트 해 준다. (이를 'Dirty
check' 라고 함)
