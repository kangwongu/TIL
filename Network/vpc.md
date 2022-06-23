## VPN (Virtual Private Network)
가상 사설망이라고 불리는 VPN은 실제로는 같은 네트워크 상에 있지만 논리적으로 다른 네트워크인 것처럼 동작한다.

예를 들어, 네트워크가 구성되어있는 회사에서 보안상의 이유로 직원간 네트워크를 분리하고 싶다면 어떻게 해야할까?  
기존 인터넷선 공사를 다시하고, 다 뜯어고쳐서 다시 설정하기엔 무리가 있기에 VPN을 사용한다.  
VPN 사용으로 물리적으로 네트워크를 분리하지 않아도 된다.

<br>

## VPC (Virtual Private Cloud)
사용자가 정의하는 가상의 네트워크이다.  
VPC를 통해 인스턴스가 속하는 네트워크를 구분하고, 각 네트워크에 맞는 설정을 부여할 수 있다.

**VPC가 없다면?**

![VPC가 없을때](https://user-images.githubusercontent.com/59812251/174433777-ce7d1526-bf67-4c58-b18a-6f899c24846d.png)

VPC가 없다면 인스턴스들이 복잡하게 연결된며 이는 시스템 복잡도 증가로 이어지고, 인터넷을 통해 전달되는 트래픽 전송이 굉장히 비효율적이게 된다.

<br>

**VPC 적용**

![VPC를 적용했을 때](https://user-images.githubusercontent.com/59812251/174433780-244d291a-ce1e-42f1-9a1b-b37480f65354.png)

VPC를 적용하면 VPC별로 네트워크를 구성할 수 있고 각각의 VPC에 따라 다르게 네트워크 설정을 줄 수 있게 된다.  
AWS는 VPC의 중요성을 강조해 2019년부터 모든 서비스에 VPC를 적용하도록 강제한다.

<br>

### VPC 구축하기
VPC의 아이피범위를 RFC1918이라는 사설 IP대역에 맞추어 구축해야 한다.

VPC에서 사용하는 사설 IP 대역
```
- 10.0.0.0 ~ 10.255.255.255(10/8 prefix)
- 172.16.0.0 ~ 172.31.255.255(182.16/12 prefix)
- 192.168.0.0 ~ 192.168.255.255(192.168/16 prefix)
```

<br>

#### 사설 IP

![공인_사설IP](https://user-images.githubusercontent.com/59812251/174434145-67d47d96-66ee-46d8-8ef2-de43cc9567f2.png)

💻➡🌏 : 사설 IP를 할당받은 스마트폰 혹은 개인 PC가 데이터 패킷을 인터넷으로 전송하면, 라우터(공유기)가 해당 사설 IP를 공인 IP로 바꿔서 전송한다.

🌏➡💻 : 인터넷에서 오는 데이터 패킷의 목적지도 해당하는 사설 IP로 변경한 후 개인 스마트폰 혹은 PC에 전송한다.

```
누군가 '안방에서 리모컨좀 가져다달라'하면 저는 옆집을 가는게 아닌 우리집에 있는 '안방'으로 찾아간다. 이 때, 안방이 사설 IP 우리집 주소가 공인 IP이다.

옆집도 안방이 있고 우리집도 안방이 있지만 서로 안방을 들었을때 헷갈리지 않습니다. '안방', '작은방', '큰방'처럼 내부에서 쓰는 주소를 사설 IP 대역이라고 부르며 내부 네트워크내에서 위치를 찾아갈때 사용한다.
```

<br>

### 서브넷

![서브넷](https://user-images.githubusercontent.com/59812251/174434522-ce5b87a0-7046-4104-b3b0-af6b6995b617.png)

VPC의 IP 주소를 나누어 리소스가 배치되는 물리적인 주소 범위를 뜻하며, VPC를 잘게 나눈 것이다.

서브넷 안에 RDS, EC2와 같은 리소스들을 위치시킬 수 있다.

<br>

### 라우터

![라우터](https://user-images.githubusercontent.com/59812251/174434676-64d873fa-7ae4-42f0-86df-92581b6b205d.png)

네트워크 요청이 발생하면 데이터는 우선 라우터로 향하고, 라우팅 테이블에 따라 라우팅하게 된다.

서브넷A의 라우팅테이블은 172.31.0.0/16 즉 VPC안의 네트워크 범위를 갖는 네트워크 요청은 로컬에서 찾도록 되어있다.  
하지만 그 이외 외부로 통하는 트래픽을 처리할 수 없다.  
이때 인터넷 게이트웨이를 사용한다.

<br>

### 인터넷 게이트웨이

![인터넷게이트웨이](https://user-images.githubusercontent.com/59812251/174434677-294d68a2-86e0-48c8-bdc2-594b69d6b79f.png)

VPC 리소스와 인터넷 간 통신을 활성화하기 위해 VPC에 연결하는 게이트웨이이다. 즉, VPC와 인터넷을 연결해준다

서브넷B의 라우팅테이블에 0.0.0.0/0으로 정의되어있는데, 이 뜻은 모든 트래픽에 대하여 IGA(인터넷 게이트웨이) A로 향하라는 뜻이다.  
라우팅테이블은 가장 먼저 목적지의 주소가 172.31.0.0/16에 매칭되는지를 확인한 후 매칭되지 않는다면 IGA A로 보낸다.

<br>

### 네트워크 ACL과 보안그룹

![acl_보안그룹](https://user-images.githubusercontent.com/59812251/174434678-574bbee6-97e8-4d85-97e1-a0a6a786c52e.png)

방화벽 역할을 수행하며, 인바운드 트래픽, 아웃바운드 트래픽 보안정책을 설정할 수 있다.

<br>

### NAT 게이트웨이

![NAT 게이트웨이](https://user-images.githubusercontent.com/59812251/174434679-85119259-c6b2-4f8b-938f-87c6c7a1e230.png)

Private 서브넷이 직접 인터넷과 통신할 수 없기 때문에, 트래픽을 Public 서브넷에 속한 인스턴스에 전송해서 인터넷과 통신을 할 수 있게 되는데, 이러한 역할을 NAT 게이트웨이가 수행한다.  
Private 서브넷에서 발생하는 요청이 VPC 내부 주소를 목적지로 하는 것이 아니라면, Public 서브넷에 존재하는 NAT 게이트웨이로 트래픽을 전송하고, NAT는 Public 서브넷의 라우팅 규칙에 따라 처리함으로써 Private 서브넷이 인터넷과 통신할 수 있도록 한다.

<br>

## 참고
https://medium.com/harrythegreat/aws-%EA%B0%80%EC%9E%A5%EC%89%BD%EA%B2%8C-vpc-%EA%B0%9C%EB%85%90%EC%9E%A1%EA%B8%B0-71eef95a7098

https://jbhs7014.tistory.com/164

https://velog.io/@hidaehyunlee/%EA%B3%B5%EC%9D%B8Public-%EC%82%AC%EC%84%A4Private-IP%EC%9D%98-%EC%B0%A8%EC%9D%B4%EC%A0%90