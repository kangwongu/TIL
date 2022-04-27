# 프론트부분과 백엔드부분으로 분리하기

**AWS의 마인드**

여러 개의 서비스를 조각조각 나누어 만들고 사용자들이 레고처럼 조립하면서 쓰게 만드는 형태를 추구한다.  
-> 분리해야 할 부분은 무조건 분리하는 것

<br>

## AWS 아키텍처
이전엔 Monolithic이 자주 쓰였지만 점점 MSA로 바뀌어가는 추세이다.

EX) 빨리 개발을 하기위해 서버를 나누지 않고 프로젝트 요소들을 전부 하나의 서버에 넣고 작업을 했는데, 특정 부분을 수정하면 다른 부분에서 영향을 받아 에러가 발생하는 등의 이슈들이 생기게 되었고,  이로 인해 점점 MSA로 바뀌어 가게 됐다.  
(기능 간 의존성을 줄이기위해 잘게 쪼개는 것)

- Monolithic
    - 프론트엔드와 백엔드가 물리적으로 같은 위치에 저장되어있다
    - 하나의 서버에 전부 저장

- MSA
    - 프론트, 백엔드를 물리적으로 다른 서버에 배치
        - EX) 프론트는 S3, 백은 EC2

<br><br>

## 프론트 부분 구성하고 배포하기

### CloudFront

CloudFront는 AWS에서 제공하는 CDN 서비스이며, 캐싱을 통해 사용자에게 좀 더 빠른 전송 속도를 제공함을 목적으로 한다.  
CloudFront는 전 세계 이곳저곳에 Edge Server(Location)을 두고 Client에 가장 가까운 Edge Server를 찾아 Latency를 최소화시켜 빠른 데이터를 제공!

S3 에 저장된 파일들을 지역에 관계없이 빠르게 접근이 가능하도록 할  수 있다.

- CloudFront를 사용하지 않는다면?
    - 서울 리전에 있는 버킷을 호스팅하면 미국에서 접근할 때, 사이트가 매우 느린 속도로 접속될 것
    - 그렇다면 버킷을 서비스하는 나라의 가까운 리전마다 생성해야 할까?
      - No, 그래서 CloudFront를 사용하는 것
    

#### Edge Server = Edge Location
- AWS에서 실질적으로 제공하는 전 세계에 퍼져있는 서버 Edge Server에는 요청받은 데이터에 대해서, 같은 요청을 빠르게 응답해주기 위해 **Cache 기능** (기본적으로 한번 발생한 요청에 대해서는 Edge Server에 캐싱된 상태로 저장)을 제공합니다.

#### 동작 과정

1. 클라이언트로부터 Edge Server로의 요청이 발생

2. Edge Server는 요청이 발생한 데이터에 대하여 캐싱 여부를 확인

    a. 사용자의 근거리에 위치한 Edge Server 중 캐싱 데이터가 존재한다면 사용자의 요청에 맞는 데이터를 응답

    b. 사용자의 요청에 적합한 데이터가 캐싱되어 있지 않은 경우 Origin Server(S3, Ec2 instance)로 요청이 포워딩

3. 요청받은 데이터에 대해 Origin Server에서 획득한 후  Edge Server에 캐싱 데이터를 생성하고, 클라이언트로 응답이 발생합니다.

> **AWS 공식 레퍼런스** <BR>.html, .css, .js 및 이미지 파일과 같은 정적 및 동적 웹 콘텐츠를 사용자에게 빠르게 배포하는 웹 서비스입니다. CloudFront는 엣지 로케이션이라고 하는 전 세계 데이터 센터 네트워크를 통해 콘텐츠를 제공합니다. 사용자가 CloudFront에서 제공하는 콘텐츠를 요청하면 가장 짧은 지연 시간(시간 지연)을 제공하는 엣지 로케이션으로 요청이 라우팅되므로 콘텐츠가 가능한 최고의 성능으로 제공됩니다.
> 

<br>

#### 사용 예시
서울에서 S3 버킷을 생성하고 정적 파일을 올리고, CloudFront를 사용하면 edge location으로 배포된다.

미국에서 접근해도, 빠른 시간에 접속이 가능해짐

<br>

#### 설정
CloudFront - 배포 - 배포생성

설정에서 Default-root를 설정해야 함

<br>

도메인으로 접속하면 CloudFront로 접속  
CloudFront로 접속하면 S3에 네트워크 접속하는 과금이 없다!

<br><br>

### 배포를 자동화하는 방법 

- Github Action를 활용

GitHub Action은 CD를 해주는 서비스

- 서버에 소스코드를 배포하는 서비스
- 소스코드가 원격 저장소로 push됐을 때 서버로 배포

<br>

#### Github Action을 통해 자동 배포 만들기

먼저 IAM에 권한을 추가한다

- CloudFront권한을 추가하는 것

파이참과 깃리포지토리를 연동하고

배포 스크립트를 추가한다

```python
{프로젝트 폴더}/.github/workflows/main.yml
```

```yaml
name: my-front
on:
  push:
    branches:
      - main
jobs:
  build:
    runs-on: ubuntu-latest
    env:
      AWS_ACCESS_KEY_ID: ${{ secrets.AWS_ACCESS_KEY_ID }}
      AWS_SECRET_ACCESS_KEY: ${{ secrets.AWS_SECRET_ACCESS_KEY }}
      AWS_REGION: 'ap-northeast-2'

    steps:
      - name: Checkout source code.
        uses: actions/checkout@master

      - name: Upload binary to S3 bucket
        uses: jakejarvis/s3-sync-action@master
        with:
          args: --acl public-read --exclude '*' --include 'index.html'
        env:
          AWS_S3_BUCKET: ${{ secrets.BUCKET_NAME }}

      - name: Invalidate cache CloudFront
        uses: chetan/invalidate-cloudfront-action@master
        env:
          DISTRIBUTION: ${{ secrets.DISTRIBUTION_ID }}
          PATHS: '/index.html'
        continue-on-error: true
```

깃허브 리포지토리 -> Settings -> Secrets에서 AWS 연동을 설정한다.

secrets.~ → ~에 해당하는 AWS 정보들을 추가해준다.

DISTRIBUTION_ID : CloudFront의 ID

Actions에 가보면 동작확인 가능

<br><br>

## 백엔드 부분 구성하고 배포하기

### EC2
  - 대표적 백엔드 리소스
  - 서버 컴퓨터 역할
  - AWS의 가장 기본적인 서비스

EC2를 구매하고, SSH를 이용하여 인스턴스에 접속
``` bash
ssh -i [받은키페어를끌어다놓기] ubuntu@[AWS에적힌본인아이피]
```

서버에 접속해 파이썬 설치, 설정하고 FLASK로 된 서버프로그램을 실행시킨 후, 포트 5000번을 열어주면 전세계 어디서든 접속 가능!

<br><br>

### ELB (Elastic Load Balancer)

EC2만으로는 서버를 관리하기 어렵기 때문에 EC2 + ELB 형태로 구성 

여러 대의 EC2를 묶어서 사용하기 위한 서비스

장점?

- 서비스 중에, EC2의 성능이 부족한 경우, 인스턴스를 추가할 수 있다

갑자기 많은 트래픽이 몰렸을 때, EC2 하나로는 감당이 안되니까 EC2의 자원을 늘려야한다.
하지만 자원을 늘리려면 시간이 필요하다
-> 서버의 트래필 용량을 증설시킬 수 있는 가장 간단한 방법이 EC2에 ELB를 연결하는 것

트래픽이 증가하면 EC2가 한 개였던 걸 두 개로 늘려주고하는 방식으로, 실시간으로 대응이 가능해진다

EC2 - 로드밸런서 - 로드밸런서 생성을 통해 로드밸런서를 생성한다.
생성 과정 중에, 라우팅을 구성하는 부분이 있는데, 이 과정은 ELB에서 EC2로 연결되는 부분에 대해 설정하는 부분이다.

라우팅을 구성하기 위해 대상그룹을 설정하는 작업이 선행되어야 한다.
대상그룹은 ELB에 EC2를 연결하기 위해서는 먼저 그룹을 만들어 놓고 
트래픽에 따라 그룹에 EC2를 추가/삭제하는 방식이다

나는 EC2에서 파이썬 플라스크로 서버를 돌렸기 때문에 내가 만든 EC2에서 사용할 포트를 5000으로 설정했다.

상태검사(헬스체크)는 연결된 EC2 인스턴스의 상태를 계속 검사해서 
만약에 EC2에 문제가 있으면 해당 EC2에는 트래픽을 보내지 않는 설정이다.

만약 두 서버 중 한 쪽 서버가 고장나면, 다른 한 쪽 서버로 트래픽을 받는 failover기능 존재

로드밸런서를 생성하고 대상 등록을 통해 ELB와 연결할 인스턴스를 선택하는 작업을 마치면 완료!

로드밸런서의 DNS 이름으로 접속하면 된다

<br>

#### ELB에서 자동으로 EC2 추가하기


EC2 - image

- EC2에 운영하고 있던 파일 디스크에 있는 걸 그대로 복사해놓은 것
- 이를 통해 다음 EC2를 생성할 때 사용 가능

Auto Scaling

자동으로 인스턴스를 추가하거나 삭제하는 기능

이미지를 만들고 로드밸런서 설정을 하면, 사용자가 EC2를 늘려달라고 하면 요청한대로 수행됨

Auto Scaling - 시작 구성 생성에서 생성가능  
생성 후, Auto Scaling - Auto Scaling 그룹 - Auto Scaling 그룹 생성  
그룹 생성 시, '시작 구성'으로 전환하고 설정한다

- Scale out
    - 인스턴스 (EC2)가 늘어난다

Auto Scaler를 사용 후, 단점은 직접 서버에 들어가 파이썬 서버(플라스크)를 실행시켜야 한다는 점 

<br><br>

### EB (ElasticBeanstalk)

ELB + Auto Scaling + EC2를 한번에 관리할 수 있는 서비스이다.  
따로 관리하면 설정도 어렵고 까다롭기 때문에,
AWS에서 통합해서 관리할 수 있는 서비스인 ElasticBeanstalk를 제공한다.


배포만 하면 EC2, Auto Scaler, ELB등을 AWS 상에서 설정으로만 간단하게 조절할 수 있는 형태의 서비스!

Elastic Beanstalk - Create Application에서 생성한다.

구성 변경
  - [본인환경이름] - 구성

#### EB에 파이썬 소스 배포해보기

먼저 IAM에 권한을 추가한다

- EB권한을 추가하는 것

파이참과 깃리포지토리를 연동하고  
백엔드 코드를 Github에 업로드한다 (application.py)

``` python
import boto3
from flask import Flask, render_template, request, jsonify
from flask_cors import CORS
import os # 리눅스 어딘가에 저장되어 있는 환경변수를 사용하기 위함

application = Flask(__name__)
# 다른 도메인간에 API 통신을 허용
# 프론트, 백엔드 간의 도메인이 다르기 때문에 API 통신을 하려면 CORS를 허용해야 함
cors = CORS(application, resources={r"/*": {"origins": "*"}})

@application.route('/')
def main():
    return "hello python"

@application.route('/fileupload', methods=['POST'])
def file_upload():
    file = request.files['file']
    # AWS와 연동, EB의 환경변수에서 설정
    s3 = boto3.client('s3',
                      aws_access_key_id=os.environ["AWS_ACCESS_KEY_ID"],
                      aws_secret_access_key=os.environ["AWS_SECRET_ACCESS_KEY"]
                      )
    # S3 [버킷이름]에 파일 업로드                  
    s3.put_object(
        ACL="public-read",
        Bucket=os.environ["BUCKET_NAME"],
        Body=file,
        Key=file.filename,
        ContentType=file.content_type
    )
    return jsonify({'result': 'success'})

if __name__ == '__main__':
    application.debug = True
    application.run()
```

<br>
EB 환경변수에 os.environ[]정보들을 설정한다.

배포 스크립트를 추가한다

```
{프로젝트 폴더}/.github/workflows/main.yml
```
``` yml
name: backend
on:
  push:
    branches:
      - main
jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout source code.
        uses: actions/checkout@master

      - name: Set up Python 3.8
        uses: actions/setup-python@v1
        with:
          python-version: "3.8"

      - name: Generate deployment package
        run: zip -r deploy.zip . -x '*.git*'

      - name: Get timestamp
        uses: gerred/actions/current-time@master
        id: current-time

      - name: Run string replace
        uses: frabert/replace-string-action@master
        id: format-time
        with:
          pattern: '[:\.]+'
          string: "${{ steps.current-time.outputs.time }}"
          replace-with: '-'
          flags: 'g'

      - name: Deploy to EB
        uses: einaregilsson/beanstalk-deploy@v16
        with:
          aws_access_key: ${{ secrets.AWS_ACCESS_KEY_ID }}
          aws_secret_key: ${{ secrets.AWS_SECRET_ACCESS_KEY }}
          application_name: [EB어플이름]
          environment_name: [EB환경이름]
          version_label: "python-${{ steps.format-time.outputs.replaced }}"
          region: ap-northeast-2
          deployment_package: deploy.zip
```

깃허브 리포지토리 -> Settings -> Secrets에서 AWS 연동을 설정한다.

secrets.~ → ~에 해당하는 AWS 정보들을 추가해준다.

파이썬 라이브러리를 설치한다.
EB는 EC2처럼 서버에 직접 접속해 설치하지 않는다
EB에 배포할 때, 라이브러리들 목록을 requirements.txt로 만들어줘야 한다.

``` bash
// 필요한 라이브러리를 추가
pip install boto3 flask flask_cors

pip freeze > requirements.txt
```

소스를 push하면 배포가 된다.

<br><br>

Actions에 가보면 동작확인 가능

## 백엔드와 프론트 연동하기

프론트 코드를 수정
``` javascript
function save() {
            var form_data = new FormData($('#upload-file')[0]);
            $.ajax({
                type: 'POST',
                url: '{EB URL}/fileupload',  // EB에 백엔드 부분이 배포된 상태
                data: form_data,
                processData: false,
                contentType: false,
                success: function (data) {
                    alert("파일이 업로드 되었습니다!!");
                },
            });
        }
```

배포되어있는 CloudFront에 접속해서 테스트해보면 연동 되어있는 것을 확인 가능