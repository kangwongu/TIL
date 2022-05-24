## SQL
Structured Query Language의 약자로, 데이터베이스에 요청(query)를 날려서 원하는 데이터를 가져오는 것을 도와주는 언어이다.

### 쿼리(Query)문
데이터베이스에 명령을 내리는 것이다.

<br>

### Select 쿼리문
데이터베이스에서 데이터를 선택해서 가져오겠다는 의미이다.
어떤 테이블에서, 어떤 필드의 데이터를 가져올지로 구성된다.

#### 사용 예시

``` sql
select 필드 from 테이블;
```

**테이블, 필드**

![테이블,필드](https://user-images.githubusercontent.com/59812251/169727278-d78cc7bf-a939-4ee9-a1d1-559348f2a39a.png)

테이블은 데이터가 담긴 엑셀 시트와 유사한 개념이다.
그림에서 'orders'가 테이블을 의미한다.

필드는 속성을 의미하며, order_no, created_at등등이 필드이다.

<br>

### 특정 데이터만 가져오기
Where 절을 사용한다.  
Where 절은 Select 쿼리문으로 가져올 데이터에 조건을 걸어주는 것을 의미한다.

``` sql
/* order 테이블에서 결제수단이 카카오페이인 데이터 가져오기 */
select * from orders
where payment_method = 'kakaopay';
```

``` sql
/* 강의가 앱개발종합반이고 결제수단이 카드인 데이터 가져오기*/
select * from orders
where course_title = '앱개발 종합반' and payment_method = 'CARD';
```

#### Where절과 자주 같이 쓰이는 문법

같지 않음 조건
``` sql
select * from orders
where payment_method != 'CARD'
```

범위 조건
``` sql
select * from point_users
where point between 20000 and 30000
```

포함 조건
``` sql
select * from checkins
where week in (1,3);
```

패턴 조건
``` sql
select * from users
where email like 's%com'
and name like '이%';
```

일부 데이터만 가져오기
``` sql
select * from orders
where payment_method = 'kakaopay'
limit 5;
```

중복 데이터 제외하고 가져오기
``` sql
select distinct(payment_method) from orders
```

몇 개인지 숫자 세보기
``` sql
select count(*) from orders
```

``` sql
select count(distinct(name)) from users
```

<br>

### 통계 구하기
데이터베이스에 저장된 날 것의 데이터들을 최대, 최소, 평균, 개수등 의미있는 정보로 변환할 수 있다.

#### 동일한 범주의 데이터를 묶어주는 Group by

``` sql
select 범주별로 세어주고 싶은 필드명, count(*) from 테이블명
group by 범주별로 세어주고 싶은 필드명;
```
``` sql
/* group by로 합쳐진 데이터의 개수를 세어준다. */
select name, count(*) from users
group by name
```

동일한 범주에서 최소값 구하기
``` sql
select 범주가 담긴 필드명, min(최솟값을 알고 싶은 필드명) from 테이블명
group by 범주가 담긴 필드명;
```
동일한 범주에서 최대값 구하기
``` sql
select 범주가 담긴 필드명, max(최댓값을 알고 싶은 필드명) from 테이블명
group by 범주가 담긴 필드명;
```
동일한 범주의 평균 구하기
``` sql
select 범주가 담긴 필드명, avg(평균값을 알고 싶은 필드명) from 테이블명
group by 범주가 담긴 필드명;
```
동일한 범주의 합계 구하기
``` sql
select 범주가 담긴 필드명, sum(합계를 알고 싶은 필드명) from 테이블명
group by 범주가 담긴 필드명;
```

#### 깔끔하게 데이터를 정렬해주는 Order by

``` sql
select * from 테이블명
order by 정렬의 기준이 될 필드명;
```

오름차순으로 정렬하기
``` sql
select name, count(*) from users
group by name
order by count(*) (asc);
```
내림차순으로 정렬하기
``` sql
select name, count(*) from users
group by name
order by count(*) desc;
```

#### Where, Group by, Order by 함께 사용해보기
``` sql
select payment_method, course_title, count(*) from orders
where course_title = '웹개발 종합반'
group by payment_method
order by count(*)
```

#### 별칭 기능 Alias
이름으로 인한 혼동을 최소화하고 원하는 이름으로 결과를 출력하기 위해 사용한다.

``` sql
select payment_method, count(*) as cnt from orders o
where o.course_title = '앱개발 종합반'
group by payment_method
```

<br>

### 여러 테이블을 연결하는 Join

두 테이블의 공통된 정보(key값)를 기준으로 테이블을 연결해서 한 테이블처럼 보는 것을 의미한다.

#### Left Join

어디에다가 무엇을 붙일건지, 순서가 중요하다

![Left join](https://user-images.githubusercontent.com/59812251/169930291-2360d4eb-3062-45ad-ae61-cb5d8b4dc159.png)

``` sql
select * from users u
left join point_users p
on u.user_id = p.user_id
```

어떤 데이터는 모든 필드가 채워져있지만, 어떤 데이터는 비어있는 필드가 있을 수 있는데, 그 이유는 해당 데이터의 user_id 필드값이 point_users 테이블에 존재하지 않기 때문이다.

**사용 예시**

가입은 했지만 강의 수강을 시작하지 않은 유저들을 성씨별로 세어보기
``` sql
select u.name, count(*) from users u
left join point_users pu on u.user_id = pu.user_id
where pu.point_user_id is NULL
group by u.name
```

<br>

#### Inner Join

![Inner join](https://user-images.githubusercontent.com/59812251/169930283-f6982ab5-f818-40cb-9cb7-995e14c03095.png)

``` sql
select * from users u
inner join point_users p
on u.user_id = p.user_id
```

Left Join과는 다르게, 여기서는 비어있는 필드가 있는 데이터가 없다.  
그 이유는, 같은 user_id를 두 테이블에서 모두 가지고 있는 데이터만 출력했기 때문이다.

**사용 예시**

결제하고 시작하지 않은 유저들을 성씨별로 세어보기
``` sql
select name, count(*) cnt_name from enrolleds e
inner join users u on e.user_id = u.user_id
where is_registered = 0
group by name
order by cnt_name desc
```

<br>

### 결과물 합치는 Union

각 강의의 주차별 체크인 수를 세어보는데, 7월과 8월에 강의를 구매한 고객들의 한해서 검색하기

``` sql
(
	select '7월' as month, c1.title, c2.week, count(*) as cnt from courses c1
	inner join checkins c2 on c1.course_id = c2.course_id
	inner join orders o on c2.user_id = o.user_id
	where o.created_at < '2020-08-01'
	group by c1.title, c2.week
)
union all
(
	select '8월' as month, c1.title, c2.week, count(*) as cnt from courses c1
	inner join checkins c2 on c1.course_id = c2.course_id
	inner join orders o on c2.user_id = o.user_id
	where o.created_at >= '2020-08-01'
	group by c1.title, c2.week
)

```

<br>

### Subquery
쿼리 안의 쿼리라는 의미이다.
하위 쿼리의 결과를 상위 쿼리에서 사용하면, SQL 쿼리가 간단해진다는 이점이 있다.

#### 간단한 비교
아래 두 쿼리는 같은 내용이지만, 보다시피 다른 방법으로 구현이 가능하다.

**Join 활용**

``` sql
select u.user_id, u.name, u.email from users u
inner join orders o on u.user_id = o.user_id
where o.payment_method = 'kakaopay'
```

**서브쿼리 활용**
``` sql
select user_id, name, email from users u
where user_id in (
	select user_id from orders
	where payment_method = 'kakaopay'
)
```

<br>

#### Where에 들어가는 서브쿼리

서브쿼리의 결과를 조건에 활용하는 방식으로 사용한다.
```
where 필드명 in (서브쿼리)
```

``` sql
select user_id, name, email from users u
where user_id in (
	select user_id from orders
	where payment_method = 'kakaopay'
)
```

#### Select에 들어가는 서브쿼리

기존 테이블에 함께 보고싶은 통계 데이터를 붙이는 방식으로 사용한다.

```
select 필드명, 필드명, (서브쿼리) from ..
```

``` sql
select c.checkin_id,
       c.user_id,
       c.likes,
       (
       	select avg(likes) from checkins
		where user_id = c.user_id
	   ) as avg_likes_user
  from checkins c
```

#### From에 들어가는 서브쿼리

내가 만든 select와 이미 있는 테이블을 Join하고 싶을 때 사용한다.

``` sql
select pu.user_id, pu.point, a.avg_likes from point_users pu
inner join (
	select user_id, round(avg(likes), 2) as avg_likes from checkins
	group by user_id
) a on pu.user_id = a.user_id

```