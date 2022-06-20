# 도커
도커는 컨테이너 가상화 기술이며, 컨테이너를 더 쉽게 사용할 수 있게 해준다.

도커를 사용하면 개발환경이 편해진다  
다양한 db를 테스트하려 할 때, 일일이 다 설치하고 세팅해서 해야할까?  
No, 너무 비효율적이기에 도커를 사용해서 하나씩 돌려보며 테스트할 수 있다

MSA시에, 도커를 사용한다.  
EC2 100개가 플라스크를 사용하고 있는데, 그 중, 30개를 스프링으로 변환해야 한다면?  
일일이 변경해야 할까?  
No, 도커를 사용해서 비교적 쉽게 할 수 있다.

<br>

**컨테이너**

호스트 OS상에 논리적인 구획(컨테이너)을 만들고, 어플리케이션을 작동시키기 위해 필요한 라이브러리나 어플리케이션 등을 하나로 모아, 마치 별도의 서버인 것처럼 사용할 수 있게 만든 것

컨테이너는 운영체제 수준에서 가상화를 실시하여 다수의 컨테이너를 OS 커널에서 직접 구동합니다. 컨테이너는 훨씬 가볍고 운영체제 커널을 공유하며, 시작이 훨씬 빠르고 운영체제 전체 부팅보다 메모리를 훨씬 적게 차지합니다.

이미지 - 클래스  
컨테이너 - 인스턴스

<br>

## 도커 이미지

도커 이미지는 컨테이너를 실행하긴 위해 필요한 파일들의 모음이며, 이미지를 만들기 위해서는 Dockerfile이라는 이미지 생성 파일이 필요하다.

<br>

Dockerfile 이미지 예시
``` docker
FROM openjdk:8-jdk-alpine #베이스 이미지 파일
COPY build/libs/demo-0.0.1-SNAPSHOT.jar app.jar #컨테이너 내부로 파일 복사
ENTRYPOINT ["java","-jar","/app.jar"] #컨테이너 생성되면서 실행
```

<br>

이미지 생성
```
docker build -t {이미지명}:{태그} {Dockerfile 파일 위치}
```

<br>

## 도커 컨테이너

컨테이너는 실제로 실행되는 프로세스이다.

컨테이너 생성
``` bash
docker run --name {컨테이너 이름} -p {호스트 포트}:{컨테이너 포트} -d {이미지명}:{이미지태그}
```

<br>

## 사용해보기

스프링부트 프로젝트 빌드

![스프링부트 프로젝트 빌드, 도커파일 생성](https://user-images.githubusercontent.com/59812251/174508278-00b738b8-2bfa-4ef1-a2d6-b84f0e4ae199.png)

우선 스프링 프로젝트를 빌드해야 도커를 활용할 수 있다.

<br>

도커파일 작성 (프로젝트 최상단)

![도커파일](https://user-images.githubusercontent.com/59812251/174508281-55b9d5c6-ff40-4969-9e93-bff1d6e9237d.png)

도커 이미지를 생성하기 위해 프로젝트 최상단에 도커파일을 작성한다.  
이 때, 파일이름은 무조건 Dockerfile로 지어야한다.

<br>

도커 빌드 (이미지 생성)

![도커이미지생성](https://user-images.githubusercontent.com/59812251/174508282-96aa4f17-7aa8-4cef-8aa2-2dacebf0e0b9.png)

스프링 프로젝트를 빌드하고, 도커파일을 작성하면 도커 이미지를 생성할 수 있다.

<br>

생성된 도커 이미지를 확인할 수 있다.

![이미지 생성](https://user-images.githubusercontent.com/59812251/174508283-c7de209b-706c-4376-a948-679ff929a71e.png)

<br>

도커 실행 (컨테이너 생성)

![도커 컨테이너 생성](https://user-images.githubusercontent.com/59812251/174508285-ea3f88a2-57ee-45ae-8ae4-97c4ea4aa227.png)

도커 이미지를 생성했으면, 컨테이너를 생성해 실행할 수 있다!

![실행중인 컨테이너](https://user-images.githubusercontent.com/59812251/174508288-1e07222a-0e2d-41a4-9032-1a757d9fb5c5.png)

<br>

![실행성공](https://user-images.githubusercontent.com/59812251/174508289-3f1572df-e03f-4bad-953b-e1de981c4ea0.png)

도커 컨테이너를 생성이 성공한 것을 확인할 수 있다.

<br>

## 데이터베이스 사용

```jsx
docker run --name some-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -d mysql
```
mysql이라는 이미지가 로컬에 없기 때문에 실행이 안될 것 같지만, 로컬에 없으면 도커 허브에서 해당 이미지를 찾고 컨테이너를 실행시킨다.

<br>

데이터베이스 컨테이너를 생성해서 사용하면, 컨테이너가 내려갔을 때, 데이터들이 전부 사라지기 때문에, 외부에 파일을 두는 형태로 관리한다.  

기존 컨테이너 생성 방식
```
docker run --name some-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -d mysql
```

<br>

컨테이너를 생성할 때 폴더 경로를 적어서 파일로 관리하게 한다.
```
docker run --name some-mysql -v {폴더 절대경로}:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -d mysql
```

<br>

## 도커 허브 리포지토리를 이용해 이미지 활용하기

도커 허브에서 리포지토리를 생성했다.  
kwg0527/my-repo로 생성

<br>

도커 로그인

![도커 로그인](https://user-images.githubusercontent.com/59812251/174533709-9dc9b615-9bea-419f-a623-cf3b51e9ccab.png)

리포지토리에 업로드하기 위해선 로그인이 필요하다.

<br>

도커 태깅

![태깅](https://user-images.githubusercontent.com/59812251/174533677-bd0bb595-337f-4f75-83e6-71f3e9043156.png)

```jsx
docker tag {이미지명}:{태그} {리파지토리 이미지명}:{태그}
```

리포지토리에 푸시할 이미지를 기입한다.

<br>

도커 푸쉬하기

![푸쉬](https://user-images.githubusercontent.com/59812251/174533680-0b32fa60-cd58-4aa1-9623-5924e382d6c3.png)

```jsx
docker push {리파지토리 이미지명}:{태그}
```

리포지토리에 푸시한다.

<br>

![업로드 확인](https://user-images.githubusercontent.com/59812251/174533785-af0614e3-b84e-4d7c-860a-c196949a3e73.png)

업로드 된 것을 확인할 수 있다.  
태그가 latest인 건, 내가 푸시할 때 태그를 안붙였기 때문이다.

<br>

```
docker pull {도커 허브 이미지명}:{태그}
```
pull 명령어를 통해 리포지토리에 업로드 되어있는 이미지를 받을 수 있다.