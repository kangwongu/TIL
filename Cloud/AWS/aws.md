# AWS

## 클라우드
인터넷 상의 가상화된 서버에 프로그램을 두고 필요할때마다 컴퓨터나 스마트폰 등에 불러와 사용하는 서비스 <br><br>

## AWS (Amazon Web Service)는 뭘까?

- 클라우드 서비스
    - 기존의 서버 컴퓨팅 시장을 빠르게 대체중 (핫함)
    - 개발을 할 수 있게 만들어주는 베이스 인프라
    - 웹사이트를 돌리기 위해 필요한 도메인, 서버, 데이터베이스 등등을 제공
- 아마존에서 제공하는 웹 서비스, 클라우드 서비스 중에 제일 잘 나가는 서비스
- 비용적으로 엄청난 장점이 있진 않지만, 인프라를 프로그래밍하게(CLI환경, 개발언어연동등) 사용할 수 있어서 개발을 신속하고 자동화 되게 할 수 있다는 장점이 있어서 사용
<br><br>

### 리전, 존
서비스하려고 하는 지역과 가까운 곳의 리전을 사용할수록 사용자들에게 더 빠른 속도로 서비스 제공 가능
- 리전
    - 데이터 센터(IDC)가 있는 나라
- 존
    - 리전 내의 데이터 센터 위치
 > ex) 서울에 데이터 센터가 영등포, 강남, 도봉에 위치하고 있으면 서울리전에 영등포 존, 강남 존, 도봉 존 
- 리전 내의 존을 나누는 이유?
  - 서버가 작동되지 않는 상황을 막기 위해 존 나눠놓음   
  - 서울의 데이터센터가 영등포에만 있을 때, 만약 영등포 데이터센터에 문제가 생기면 넷플릭스 같이 AWS를 이용하는 기업들은 한국 서울리전에서 서비스가 안되는 문제 발생
  -> 그래서 리전 내의 존을 나눔
  >ex) 영등포 존이 작동하지 않으면 강남 존이 백업, 강남 존에 문제가 생기면 도봉 존이 백업

<br><br>

## S3 (파일 저장소)

- 버킷
    - 파일을 저장하는 폴더 역할
    - 버킷안에 파일을 업로드(저장)
- S3에 저장되는 모든 파일에 객체 URL이 부여됨
- 버킷과 저장된 파일의 권한을 변경해야 URL을 통해 파일을 볼 수 있음
- '정적 웹 사이트 호스팅'기능 사용가능
  - 저장된 파일을 웹사이트로 만들어준다.
  

    
<br><br>

## IAM (Identity and Access Management)
- AWS내의 사용자(계정)와 역할을 관리하는 서비스

- 프로그래밍 언어와 S3를 연동시키기 위해 사용

    - 사용자를 추가 할 때, **프로그래밍 방식 액세스** 유형을 통해 개발 언어와 연계해서 사용할 수 있다.

<br><br>

## AWS SDK?
- AWS의 서비스를 좀 더 프로그래밍 하게 사용하게 해주는 라이브러리

AWS SDK설치를 통해 CLI환경에서 AWS 작업을 할 수 있다.

aws configure 명령어로 AWS 계정 연결(인증 정보 설정)
을 하고 나면, 파이썬의 boto3 라이브러리로 S3에 접근할 수 있다.

예시 (버킷이름에 업로드하기)
``` bash
aws s3 cp {파일명} s3://{버킷이름} --acl public-read
``` 

<br><br>

## 프로그래밍 언어와 연동해 사용하기

- 실무에서 자주 쓰이는 방식
- AWS 서비스의 모든 제품들은 SDK 라이브러리를 거의 모든 언어에 제공하기 
때문에 개발언어와 연동해서 사용

예시 (파이썬 플라스크)

``` python
import boto3 # Python용 AWS SDK

@app.route('/fileupload', methods=['POST'])
def file_upload():
    # 1. 클라이언트에서 넘어오는 'file'을 받는다.
    file = request.files['file']

    # 2. s3와 연동한다.
    s3 = boto3.client('s3')

    # 3. s3에 'file'을 업로드 한다.
    # CLI환경 cp / 파이썬 put_object()
    s3.put_object(
        ACL="public-read",
        Bucket="19sparta",
        Body=file,
        Key=file.filename,
        ContentType=file.content_type)
    return jsonify({'result': 'success'})
```

<br>

#### AWS를 바라보아야 할 마음가짐
AWS는 인프라를 ‘쇼핑’하는 것과 같은 개념이다.  
어려워할 필요 없다!