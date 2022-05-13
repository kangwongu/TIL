# AWS에서 데이터베이스 다루기

이전에는 DB의 역할이 매우 중요했다.  
사용자 정보등을 저장하고 있는 DB가 어플리케이션에서는 가장 중요한 부분이기 때문이다.

하지만 클라우드의 등장이후로 DB가 가벼워지기 시작했고, DB가 클라우드에서 관리 되는 서비스들로 인해 DB를 직접 다루어야 하는 일들이 줄어 드는 추세이다.

하나의 DB에서 전부 관리되는 형태에서 MSA방식에 따라 DB도 분리되어가는 중

<br>

**데이터베이스 종류**

- RDBMS(SQL)
    - 서비스의 메인 데이터베이스
    - 정형 데이터
    - 엑셀에 가까운 종류
    - 미리 속성(컬럼)을 만들어 두고 데이터 저장, 수정이 쉽지않음
    - 데이터가 일관적이고 데이터 분석에 용이
    - 데이터 뽑아오기가 쉬움
    - ex) MS-SQL, Oracle, MySQL
- NoSQL
    - 비정형 데이터
    - JSON 형태로 적재
    - 데이터 적재가 자유롭다
    - 데이터 일관성이 부족
    - ex) MongoDB

<br><br>

## RDS

AWS에서 관리하는 관계형 데이터베이스 서비스이다.  
DB케어에 많은 신경을 쓰지 않고, 개발에만 집중하도록 해주는 서비스

클라우드 서비스를 이용해 인프라는 AWS에 맡기고, 개발에만 집중해 급변하는 사용자의 니즈를 캐치하기 위해 사용한다.

- RDS를 사용하지 않는다면

    - EC2서버를 구입하고, EC2서버에 접속해 MySQL을 설치하고 설정하는 작업을 수행했어야 한다 → 번거로움

- RDS를 사용하면

    - AWS에서 구입하고 생성해서 웹 서비스에 연결해주면 됨

애플리케이션과 연동하려면 엔드포인트를 이용한다.  
EB도 엔드포인트가 있었고, CloudFront도 도메인이 있던 것처럼, RDS도 엔드포인트가 존재

클라우드는 커맨드를 통해 설정하고 명령을 내리는 것을 지양하고 웬만하면 자동화가 되어있다.

<br>
RDS 엔드포인트로 파이참의 database와 연동한다

EB와 RDS를 연동하기위해 보안그룹을 설정해준다.

실습을 위해 모든 아이피(0.0.0.0/0)을 받아들이도록 인바운드 규칙 설정!

<br>
application.py에 mysql정보를 추가한다.

나는 RDS로 mysql을 사용했고 USER, PASSWORD, DB, HOST정보를 추가했다.

``` python
# mysql
mysql = MySQL()
application.config['MYSQL_DATABASE_USER'] = os.environ["MYSQL_DATABASE_USER"]
application.config['MYSQL_DATABASE_PASSWORD'] = os.environ["MYSQL_DATABASE_PASSWORD"]
application.config['MYSQL_DATABASE_DB'] = os.environ["MYSQL_DATABASE_DB"]
application.config['MYSQL_DATABASE_HOST'] = os.environ["MYSQL_DATABASE_HOST"]
mysql.init_app(application)
```

파이썬 라이브러리를 추가한다
``` bash
pip install install flask-mysql
```

EB배포를 위해 requirements.txt에 필요한 라이브러리들을 담는다.
``` bash
pip freeze > requirements.txt
```
<br>

EB 환경변수 설정을 통해 RDS 정보들을 추가한다

이렇게 하면 EB와 RDS는 연동이 되었다.

<br><br>

### Redis

인메모리 DB

파일이 아닌 메모리에 데이터를 저장하는 방식

속도가 빠름

RDBMS의 부하를 덜어주기 위해 사용

<br><br>

## ElastiCache

Redis를 관리해주는 서비스

생성 전에 보안 그룹을 만들어 주어야 한다

RDS는 생성하면서 보안 그룹을 만들 수 있다.

Redis는 모든 아이피를 받겠다고 열어놔도, AWS 내에서만 접속이 된다

EB에 배포 후, 어떻게 작동하는지 확인해야 한다

<br>

application.py에 Redis 정보를 추가한다
``` python
# redis
db = redis.Redis(os.environ["REDIS_HOST"], decode_responses=True)
```
REDIS_HOST=ElastiCache(Redis) 엔드포인트 (포트빼고) 

<br>

파이썬 라이브러리를 추가한다
``` bash
pip install redis
```

EB배포를 위해 requirements.txt에 필요한 라이브러리들을 담는다.
``` bash
pip freeze > requirements.txt
```
<br>

EB 환경변수 설정을 통해 Redis 정보를 추가한다

<br><br>

## 로그 관리

클라우드에서 로그를 효과적으로 다룰 수 있다.

이전에는 파일로 관리  
파일에 쌓아서 하드디스크등에 저장해서 관리하는 방식이었다.

하지만 이는 비효율적이고 찾기 힘들고, 나아가 분석할 수 조차 없었다.

로그는 비정형 데이터인데, 이런 비정형 데이터안에서 유의미한 데이터를 찾기 위한 노력들이 시작되었고, 이는 로그를 분석하자는 움직임으로 확산 되었다. 

→ 로그 분석  
클라우드를 바탕으로 로그를 분석하게 되었고, 다양한 분석도구들이 등장했다
- kibana
- fluentd등등

<br><br>

### Elasticsearch

이전에는 검색엔진으로 사용되었지만, 
지금은 로그를 쌓고 검색하는 용도로 사용된다

<br>

**ELK**

최근에 가장 많이 사용하는 로그분석 제품

내가 운영하는 모든 서비스, 모든 서버에서 모든 MSA 찢어져 있는 MSA 서버에서 로그 중앙화를 통해 중앙에서 모든 로그를 관리

<br>

### Elasticsearch Service

Elasticsearch를 쉽게 관리할 수 있게 해준다
로그를 저장하고, 데이터화를 할 수 있게 해주는 데이터베이스 서비스

Ellasticsearch Service에는 elasticsearch, kibana가 포함되어 있지만, logstash는 포함되어 있지 않기 때문에 따로 설치를 해주어야 한다.

****logstash설치****
1. EC2를 생성한다
2. JAVA를 설치한다.
3. logstash를 설치한다
4. logstash를 실행한다.

<br>

application.py에 logstash정보를 추가한다.
``` python
#logstash
python_logger = logging.getLogger('python-logstash-logger')
python_logger.setLevel(logging.INFO)
python_logger.addHandler(AsynchronousLogstashHandler(os.environ["LOGSTASH_HOST"], 5044, database_path=''))
```
LOGSTASH_HOST = logstash설치한 EC2의 주소

<br>

파이썬 라이브러리를 추가한다
``` bash
pip install python-logstash-async
```

EB배포를 위해 requirements.txt에 필요한 라이브러리들을 담는다.
``` bash
pip freeze > requirements.txt
```
<br>

EB 환경변수 설정을 통해 logstash 정보를 추가한다



