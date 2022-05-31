## SAM

Serverless Applicaition Model의 약자로, AWS 환경에서 제공하는 서버리스 어플리케이션 구축용 오픈 소스 프레임워크이다.

IaC(Infrastructure as Code) 개념이 적용되었다.

<br>

**Iac (Infrastructure as Code)**

'프로그래밍형 인프라'라고 하며, 인프라 구성을 마치 소프트웨어를 프로그래밍하는 것처럼 처리하는 방식이다.  
코드를 배포하는 것으로 인프라가 생기고 관리할 수 있다.

<br>

### 설치

```bash
https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html
```

```bash
sam --version
```

AWS-CLI 설치 확인
```
https://awscli.amazonaws.com/AWSCLIV2.msi
```

```
aws --version
```

### IAM 사용자 추가

AdministratorAccess 정책 연결해준다.

발급받은 액세스 키, 비밀 액세스 키를 로컬 AWS-CLI에 등록해준다.

```
aws configure
```

### 사용
강의자료를 참고