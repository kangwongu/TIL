# JPA

JPA를 사용하기 전에는 SQL 중심으로 개발을 진행해야 했다.  
객체지향으로 테이블을 설계하면, SQL 매핑하는 부분이 복잡해지기 때문에, SQL 중심으로 테이블을 설계해야 했다.

이러한 문제점을 극복하고자, 객체를 자바 컬렉션에 저장하듯이 DB에 저장할 수 있는 방법인 JPA가 등장하게 되었다.

<br>

## ORM (Object-relational mapping)
객체는 객체대로, 관계형 DB는 관계형 DB대로 설계를 하고 ORM 프레임워크가 중간에서 매핑을 해주는 것이다.  
객체는 객체지향스럽게 개발을 하고, 관계형 DB는 관계형 DB대로 설계하면 된다.

<br>

## JPA 구동 방식

JPA를 사용하기 위해선 일단 EntityManagerFactory가 필요하다.

``` java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
```
EntityManagerFactory는 하나만 생성해서 애플리케이션 전체에서 공유된다.  
"hello"는 persistence.xml 속성의 이름이다.

<br>

생성한 EntityManagerFactory로 EntityManager를 생성한다.
``` java
EntityManager em = emf.createEntityManager();
```
EntityManager를 통해 JPA를 쿼리를 작성하고 사용할 수 있다.

<br>

**JPA의 모든 데이터 변경은 트랜잭션 안에서 실행되어야 한다.**
``` java
EntityTransaction tx = em.getTransaction();
tx.begin(); // 트랜잭션 시작

try {
    // 코드 작성

    tx.commit(); // 커밋
} catch (Exception e) {
    tx.rollback(); // 예외 발생하면 롤백
} finally {
    em.close();
}
emf.close();
```
EntityManager 객체로 트랜잭션을 생성하고 직접적인 코드 작성은 트랜잭션 안에서 실행되도록 하고, 커밋을 해야 적용된다.

<br>

## JPQL
JPA는 SQL을 추상화한 JPQL이라는 객체지향 쿼리언어를 제공한다.

JPQL은 엔티티 객체를 대상으로 쿼리를 날리고, SQL은 DB테이블을 대상으로 쿼리를 날린다.

``` java
// jpql, 객체지향 쿼리, 각 db에 맞게 자기가 알아서 변형시켜준다
List<Member> result = em.createQuery("select m from Member m", Member.class)
        .getResultList();
```

<br>

## 영속성 컨텍스트
엔티티를 영구 저장하는 환경이라는 뜻이며 EntityManager를 통해서 영속성 컨텍스트에 접근한다.

엔티티의 생명주기
```
비영속 (new/transient)
영속성 컨텍스트와 전혀 관계가 없는 새로운 상태

영속 (managed)
영속성 컨텍스트에 관리되는 상태

준영속 (detached)
영속성 컨텍스트에 저장되었다가 분리된 상태

삭제 (removed)
삭제된 상태
```

<br>

### 비영속
객체가 영속성 컨텍스트에 저장되지 않은 상태이다.  

<br>

### 영속
영속성 컨텍스트에 객체가 저장된 상태이다.

``` java
...
em.persist(member);
```

<br>

### 준영속
객체를 영속성 컨텍스트에서 분리한 상태

``` java
...
em.detach(member);
```

<br>

### 삭제
객체를 삭제한 상태

``` java
...
em.remove(member);
```

<br>

### 영속성 컨텍스트의 이점
```
1차 캐시
동일성(identity) 보장
트랜잭션을 지원하는 쓰기 지연 (transactional write-behind)
변경 감지(Dirty Checking)
지연 로딩(Lazy Loading)
```

<br>

#### 1차 캐시

``` java
// 비영속
Member member = new Member();
member.setId(10L);
member.setName("박");

// 영속
em.persist(member);

// 1차 캐시에서 조회 -> DB에서 데이터를 가져오는 것이 아님
Member findMember = em.find(Member.class, 10L);
System.out.println("findMember.getId() = " + findMember.getId());
System.out.println("findMember.getName() = " + findMember.getName());
```
객체를 만들고 persist하면 영속성 컨텍스트에 저장되고, 1차 캐시에 저장된다.  
이 때, 해당 객체를 조회하면, DB에서 가져오는 것이 아니라 1차 캐시에서 가져옮  
DB 쿼리를 통해 조회해오는 것이 아니다.

<br>

DB에서 데이터를 조회해온다고 가졍
``` java
Member findMember = em.find(Member.class, 1L); // DB에서 조회
Member findMember2 = em.find(Member.class, 1L);// 1차캐시에서 조회
```
처음 조회를 할 땐, DB에서 조회를 한다.  
이 때, 조회를 해오면서, 영속성 컨텍스트에 해당 객체가 저장이 되고, 1차 캐시에 저장된다.  
다시 조회를 하면, DB에서 조회하는 것이 아니라, 1차 캐시에서 조회해온다.  
즉, DB 쿼리는 1번만 날라간다

<br>

#### 쓰기 지연
DB 쿼리는 persist때 나가는 것이 아니라 commit때 나간다.
persist하면 영속성 컨텍스트에 저장되면서 1차 캐시에 저장이 되는데, 영속성 컨텍스트에는 `쓰기 지연 SQL 저장소`라는 것도 존재한다.  
DB 쿼리는 이곳에 모아두었다가, commit때 한꺼번에 DB로 쿼리를 날린다.

<br>

``` java
// DB 쿼리는 persist에서 나가는 것이 아니라, commit때 나간다.
Member member1 = new Member(13L, "박지성");
Member member2 = new Member(7L, "손흥민");

// 이 때 DB로 쿼리를 날리는 것이 아니라 영속성 컨텍스트의 쓰기 지연 SQL 저장소에 저장된다.
em.persist(member1);
em.persist(member2);

// 이 때 쓰기 지연 SQL 저장소에 있는 DB 쿼리들이 DB로 날라간다.
em.commit();
```

<br>

#### 변경 감지 (Dirty Checking)
트랜잭션내에서 commit시, 1차 캐시에 저장된 객체와 스냅샷을 비교해서 변경된 부분이 있는지 찾고, 변경되었다면 update 쿼리가 작성되어 쓰기 지연 SQL 저장소에 저장된 후 DB로 쿼리를 날린다.

``` java
// 값 변경 후, persist 안해줘도 알아서 update 쿼리가 나간다.
Member findMember = em.find(Member.class, 13L);
findMember.setName("김보경");  // 박지성 -> 김보경

tx.commit();
```

<br>

#### 플러시
트랜잭션내에서
영속성 컨텍스트의 변경내용을 DB에 반영하는 것이다.

엔티티가 수정되면 쓰기 지연 SQL 저장소에 쿼리가 등록되고, 저장소에 등록된 쿼리가 DB로 전송된다.

```
em.flush() - 직접 호출 (거의 안씀)
트랜잭션 커밋 - 플러시 자동 호출
JPQL 쿼리 실행 - 플러시 자동 호출
```

<br>

## 엔티티 매핑

```
객체와 테이블 매핑: @Entity, @Table

필드와 컬럼 매핑: @Column

기본 키 매핑: @Id

연관관계 매핑: @ManyToOne,@JoinColumn
```

<br>

### 객체와 테이블 매핑

<br>

#### @Entity
이 애노테이션이 붙은 클래스는 JPA가 관리한다.  
JPA를 사용해서 테이블과 매핑할 클래스에게 붙인다.

기본 생성자 필수  
리플렉션, 객체 프록시할 때 필요하기 때문이다.

```
속성
name
- JPA에서 사용할 엔티티 이름
```

<br>

#### @Table
엔티티와 매핑할 테이블을 지정할 때 쓴다.

```
속성
name
- 매핑할 테이블 이름
```

<br>

### 데이터베이스 스키마 자동 생성
DDL을 애플리케이션 실행 시점에 자동 생성하는 기능이다.

hibernate.hbm2ddl.auto
```
속성

create
- 기존테이블 삭제 후 다시 생성 (DROP + CREATE)

create-drop
- create와 같으나 종료시점에 테이블 DROP

update
- 변경분만 반영(운영DB에는 사용하면 안됨)

validate
- 엔티티와 테이블이 정상 매핑되었는지만 확인

none
- 사용하지 않음
```
hibernate.hbm2ddl.auto을 create로 설정하면 스키마가 자동 생성된다.

예시)
``` java
Hibernate: 
    
    drop table Member if exists
Hibernate: 
    
    create table Member (
       id bigint not null,
        name varchar(255),
        primary key (id)
    )
```
주의할 점은, 이러한 설정은 운영 단계에서 절대 사용하면 안된다는 것이다.

<br>

### 필드와 컬럼 매핑
```
@Column
- 컬럼 매핑

@Temporal
- 날짜 타입 매핑

@Enumerated
- enum 타입 매핑

@Lob
- BLOB, CLOB 매핑

@Transient
- 특정 필드를 컬럼에 매핑하지 않음(매핑 무시)
```

<br>

#### @Column
```
name
- 필드와 매핑할 테이블의 컬럼 이름

nullable(DDL)
- null 값의 허용 여부를 설정한다. false로 설정하면 DDL 생성 시에 not null 제약조건이 붙는다.

unique(DDL)
- @Table의 uniqueConstraints와 같지만 한 컬럼에 간단히 유니크 제
약조건을 걸 때 사용한다.
```

<br>

#### @Enumerated
자바 enum 타입을 매핑할 때 사용한다.  
무조건 EnumType.STRING을 쓰자

<br>

### 기본 키 매핑

```
직접 할당: @Id만 사용
자동 생성(@GeneratedValue)
• IDENTITY: 데이터베이스에 위임, MYSQL
• SEQUENCE: 데이터베이스 시퀀스 오브젝트 사용, ORACLE
    • @SequenceGenerator 필요
• TABLE: 키 생성용 테이블 사용, 모든 DB에서 사용
    • @TableGenerator 필요
• AUTO: 방언에 따라 자동 지정, 기본값
```

<br>

#### IDENTITY 전략
기본 키 생성을 데이터베이스에 위임한다.

<br>

#### SEQUENCE 전략
유일한 값을 순서대로 생성하는 특별한 데이터베이스 오브젝트이다.