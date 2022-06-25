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
auto_increment

전략이 IDENTITY면 persist할 때 DB에 Insert 쿼리가 날라가고, DB에서 ID값을 가져온다.  
JPA는 보통 commit할 때 DB로 쿼리가 날라가지만, auto_increment는 DB에 Insert가 된 후에야 ID값을 알 수 있기 때문에 전략이 IDENTITY일 때만 persist시, ID값 세팅을 위해 DB쿼리가 날라간다.  
그리고 나서, 영속성 컨텍스트에 저장한다

<br>

#### SEQUENCE 전략
유일한 값을 순서대로 생성하는 특별한 데이터베이스 오브젝트이다.  
시퀀스 오브젝트를 가져와서 세팅한다.

``` java
@Entity
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR", sequenceName = "MEMBER_SEQ")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;
    ...
}
```

![시퀀스](https://user-images.githubusercontent.com/59812251/175187075-47cb7075-a82f-4f7d-8cff-824ad1c41a87.png)

MEMBER_SEQ를 이름으로 한 데이터베이스 시퀀스가 생성된다.  
이 시퀀스를 가져와서 ID값으로 세팅하는 것

```
name
-식별자 생성기 이름

sequenceName
- 데이터베이스에 등록되어 있는 시퀀스 이름

initialValue
- DDL 생성 시에만 사용됨, 시퀀스 DDL을 생성할 때 처음 1 시작하는
수를 지정한다.

allocationSize
- 시퀀스 한 번 호출에 증가하는 수(성능 최적화에 사용됨
데이터베이스 시퀀스 값이 하나씩 증가하도록 설정되어 있으면 이 값
을 반드시 1로 설정해야 한다
기본값이 50

catalog, schema
- 데이터베이스 catalog, schema 이름
```

```
allcationSize 설정 안하면 기본값 50이라 아래처럼 된다.

ID  NAME  
1	박지성
52	손흥민
102	김보경
```

<br>

persist할 때, 데이터베이스 시퀀스에서 값을 얻어온 후, ID값으로 세팅하고 영속성 컨텍스트에 저장하는 순으로 동작한다. (아직 DB에 쿼리가 날라간 것은 아님)  
commit 시점에 DB 쿼리가 날라간다.

<br>

#### TABLE 전략
키 생성 전용 테이블을 만드는 것이다.  
데이터베이스 시퀀스를 흉내낸 것이다.

<br>

### 권장하는 식별자 전략

기본 키 제약조건에 부합해야 한다.  
null이면 안되고, 유일해야 하며, 변하면 안되는 속성!  
그런데, 이 조건을 미래까지 만족시킬 자연키를 찾기는 어렵다.

<br>

**자연키**

비즈니스적으로 의미있는 식별할 수 있는 정보들  
ex) 주민등록번호. 전화번호등

**대체키(대리키)**

비즈니스와 전혀 상관없는 시퀀스값, 랜덤값, uuid등

<br>

예를 들어, 주민등록번호가 PK인 테이블이 있는데, 주민등록번호를 테이블에 담으면 안된다는 지침이 내려온다면?  
PK가 바뀌게 되고, 헤딩 PK를 참조하는 다른 테이블까지 영향을 끼치게 된다.  
이렇게 변경 가능성이 많으니 되도록 대체키를 PK로 삼도록 하자!

권장하는 방식 : Long형 + 대체키 + 키 생성전략 사용(IDENTITY, SEQUENCE)

<br>

## 연관관계 매핑
테이블에 맞춰서 외래키를 가져와서 조회하는 방식이 아니라 다이렉트로 객체를 가져올 수 있는, 연관관계를 맺어서 객체지향스럽게 설계하는 방법

``` java
// 주문한 멤버 찾기, 객체지향스럽지 않은 방식
Order order = em.find(Order.class, 1L);

Long memberId = order.getMemberId();
Member member = em.find(Member.class, memberId);

// 식별자를 가져와서 객체를 가져오는 것이 아니라, 바로 객체를 가져올 수 있어야한다.
```

<br>

객체와 테이블 연관관계의 차이를 이해해야 하고, 이해를 바탕으로 객체의 '참조'와 테이블의 '외래키'를 매핑하는 방법을 알아야 한다.

```
방향(Direction): 단방향, 양방향
다중성(Multiplicity): 다대일(N:1), 일대다(1:N), 일대일(1:1), 다대다(N:M) 이해
연관관계의 주인(Owner): 객체 양방향 연관관계는 관리 주인이 필요
```

<br>

### 단방향 관계

![단방향](https://user-images.githubusercontent.com/59812251/175203327-930f46dc-920f-47f4-a6c2-467e50e507c2.png)

Member와 Team은 다대일 관계
``` java
@Entity
@Getter @Setter
public class Member {

    ...
    // 외래키
   @Column(name = "TEAM_ID")
   public Long teamId;
    ...
}
```
객체 참조가 아닌, 외래키를 그대로 사용

<br>

``` java
// 저장
Team team = new Team();
team.setName("Arsenal");
em.persist(team);

Member member = new Member();
member.setUsername("사카");
member.setTeamId(team.getId()); // 외래키를 직접 다룬다, 객체지향적 x
em.persist(member);

// 조회
Member findMember = em.find(Member.class, member.getId());
// 객체를 바로 꺼낼 수 있는 것이 아니라, 외래키를 사용해서 꺼내야함
Long findTeamId = findMember.getTeamId();
Team findTeam = em.find(Team.class, findTeamId);

tx.commit();
```
Member에 Team을 넣으려면 외래키를 직접 사용  
객체지향적이 아닌, 테이블 중심

<br>

연관관계 사용
``` java
@Getter @Setter
public class Member {
    
    ...
    // ORM 매핑
    @ManyToOne // 연관관계 설정
    @JoinColumn(name = "TEAM_ID")   // 외래키와 매핑
    private Team team;

}
```
객체의 참조와 테이블의 외래키를 매핑시킴

<br>

``` java
// 저장
Team team = new Team();
team.setName("Arsenal");
em.persist(team);

Member member = new Member();
member.setUsername("사카");
member.setTeam(team);   // JPA가 알아서 PK값을 FK로 등록해준다. 단방향 연관관계 설정
em.persist(member);

// 조회
Member findMember = em.find(Member.class, member.getId());

// 객체를 바로 꺼낼 수 있다.
Team findTeam = findMember.getTeam();
System.out.println("findTeam.getName() = " + findTeam.getName());
tx.commit();
```

<br>

### 양방향 연관관계

![양방향](https://user-images.githubusercontent.com/59812251/175203328-e3ef92ae-861b-4dc2-ab09-90b05b655248.png)

``` java
@Entity
@Getter @Setter
public class Team {

    ...
    @OneToMany(mappedBy = "team") // 무엇과 매핑되어 있는지
    private List<Member> members = new ArrayList<>();
}
```

테이블은 외래키를 통해 연관관계가 맺어지면 양방향으로 참조가 가능하다.  
하지만 객체에서 양방향 관계는 사실 서로를 참조하는 단방향 관계 2개인 것이다.  
(Member -> Team, Team -> Member)

그래서 객체에서 양방향으로 참조하려면 단방향 연관관계 2개를 만들어야 한다.

<br>

여기서, 테이블은 외래키 하나로 두 테이블의 연관관계를 관리한다.  
그럼 객체는 어떻게 해야할까?

객체에서 2개의 단방향 연관관계중에서 하나를 연관관계의 주인으로 지정해야 한다.
주인은 외래 키를 관리(@JoinColumn)하고, 주인이 아닌쪽은 읽기(mappedby)만 가능하다.

주인은 테이블에서 외래키가 있는 곳을 주인으로 정한다.  
Member와 Team은 다대일 관계로, Member에 외래키가 담겨있기 때문에, Member 객체의 Team객체가 연관관계의 주인이 되는 것이다.

<br>

주의할 점은 양방향 관계시, 연관관계의 주인에 값을 입력해야 반영이 된다.  
되도록 순수 객체 상태를 고려해서 항상 양쪽에 값을 설정해야 한다.

연관관계 편의 메소드)
``` java
@Entity
@Getter @Setter
public class Member {
    ...

    // 연관관계 편의 메소드, 양방향 관계일 때 사용
    public void changeTeam(Team team) {
        // 양쪽에 값을 세팅하기 위함
        // 하나의 값을 변경할 때, 나머지 하나의 값도 같이 바꿔줌
        this.team = team;
        team.getMembers().add(this);
    }
}
```
양방향 관계일 때, 양쪽에 값을 편하게 설정하기 위해 사용한다.  
양쪽에 메소드를 만드는 것이 아니라, 한 쪽을 선택해서 한 쪽에만 만들고 사용한다.

<br>

#### 양방향 매핑 정리

처음 설계 시, 단방향 매핑으로 설계를 끝내야 한다  
객체와 테이블 매핑은 단방향 매핑으로 끝난 것이며, 양방향 매핑은 반대 방향으로 조회하는 기능이 추가된 것 뿐이다.

단방향 매핑을 잘 해놓고 양방향 매핑은 필요할 때 추가하면 된다.  
(JPQL로 역방향으로 탐색할 일이 많다.)

<br>

## 연관관계 매핑시 고려사항 3가지
- 다중성
- 단방향, 양방향
- 연관관계의 주인

<br>

### 다중성
```
다대일: @ManyToOne
일대다: @OneToMany
일대일: @OneToOne
다대다: @ManyToMany
```

<br>

#### 다대일
외래키가 있는 쪽이 연관관계 주인이다.  
가장 많이 쓰이는 연관관계

<br>


#### 일대다
거의 사용하지 않는다.  
되도록이면 다대일을 쓰는 걸 권장

<br>

#### 일대일
주 테이블이나 대상 테이블 중중 아무 곳에 외래 키를 넣을 수 있다.  
외래 키에 유니크 제약조건이 추가된다.

다대일 방향처럼 외래 키가 있는 곳이 연관관계의 주인이 된다.

대상 테이블에서 외래 키 단방향은 지원되지 않고, 양방향 관계만 지원된다.

<br>


#### 다대다
실무에서 다대다를 쓰면 안된다.  
일대다, 다대일로 풀어서 써야한다.

<br>

### 단방향, 양방향
```
테이블
 - 외래 키 하나로 양쪽 조인 가능
 - 방향이라는 개념이 없음

객체
 - 참조용 필드가 있는 쪽으로만 참조 가능
 - 한쪽만 참조하면 단방향
 - 양쪽이 서로 참조하면 양방향
```

<br>

### 연관관계 주인
테이블은 외래 키 하나로 두 테이블이 연관관계를 맺는다.  
객체는 한쪽만 참조하면 단방향이고, 양쪽이 서로 참조하면 양방향인데, 양방향은 단방향이 2개라고 생각하면 편하다.  
양방향 관계시, 외래 키를 관리할 곳을 지정해야 한다.

```
연관관계의 주인: 외래 키를 관리하는 참조
주인의 반대편: 외래 키에 영향을 주지 않음, 단순 조회만 가능
```