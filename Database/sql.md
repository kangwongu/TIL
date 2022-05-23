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