# Azure
Microsoft에서 제공하는 클라우드 서비스이다.

<br>

![Untitled (2)](https://user-images.githubusercontent.com/59812251/168274055-91d1e3d6-d428-4d16-af5d-beb776a45772.png)


응용 프로그램을 빌드하고, 배포하고 관리할 수 있는 유연한 개방형 클라우드 플랫폼이며, AWS보다 데이터센터 수는 적지만 많이 사용된다.

On-premiss방식으로 운영된다.  
- 자체적으로 보유한 전산실 서버에 직접 설치해 운영하는 방식
- Off-premise : 클라우드 원격 환경에서 운영하는 방식

<br>

![Untitled (3)](https://user-images.githubusercontent.com/59812251/168274062-7c597ee1-0bee-4d9c-9e02-be7ee1460e60.png)

<br>

![Untitled (4)](https://user-images.githubusercontent.com/59812251/168274071-24f1e6f6-3c4a-4faf-b13b-9da237438484.png)

Azure은 Windows Server 및 SQL Server용 AWS보다 약 5배 더 저렴하다는 장점도 있다.

<br>

![Untitled (5)](https://user-images.githubusercontent.com/59812251/168274087-eb98bffa-66b5-4bba-a4cf-bcc1a0cc8a90.png)

<br>

![Untitled (6)](https://user-images.githubusercontent.com/59812251/168274097-59d20f15-851b-423e-bb69-e4ee55abc6d0.png)

<br>

## 클라우드 인프라
클라우드 인프라는 가상화되어 인터넷을 통해 서비스로 제공되어 사용된다는 점을 제외하고 일반적인 데이터 센터 인프라와 다르지 않다. 서버, 스토리지, 컴퓨팅 리소스, 보안은 모두 클라우드 인프라의 핵심 구성요소이다.

![20220516_212133](https://user-images.githubusercontent.com/59812251/168591408-f2ac44aa-c432-41dd-a506-44acd21b7d2a.png)

1. 지역 (Regions)
    - 전세계 주요도시에 데이터센터 구축해서 운영한다.

2. 가용성 영역 (Availability zones)
    - 가용성이란, 시스템이 중단없이 계속 서비스가 가능함을 의미한다.
    - Microsoft 는 전세계 다양한 지역에 데이터 센터 집합이 있고, 그 곳의 서버를 사용하여 Azure상의 리소스를 만드는 것이다.  
    단일 데이터 센터 전체에 장애가 발생하는 경우를 방지하기 위해 여러 데이터 센터를 묶어 분산 구성하는 방식으로 각 영역은 독립된 전원, 냉각 및 네트워킹을 갖춘 하나 이상의 데이터 센터로 구성되어 있고, 리전당 3개의 가용성 영역을 가진다.  
    zone 1번에 장애가 발생하더라도 나머지 zone 2, 3번은 정상 작동이 되어 서비스 연속성을 보장할 수 있게 된다.
    - 가용성 영역을 사용하면 중단 없이 영역 간에 자동으로 전환하는 애플리케이션 및 데이터베이스를 디자인하고 운영할 수 있다.
3. 지리 (Geographies)
    - 지리적인 단위로 리전을 구분하고, 주로 국가단위로 구분한다.

4. 지역 쌍(Region pair)
    - 동일한 지리적 위치 내에 존재하는 2개의 지역을 의미한다.
    - 지역 쌍을 통해 비즈니스의 연속성을 보장하고 데이터 손실을 방지하며 데이터 가용성을 보장하려는 목적

<br>

## 링크 참조

[Azure 가입하고 계정생성하기](https://programuniverse.tistory.com/6)  
[Azure 용어와 개념](https://byounghee.tistory.com/259)