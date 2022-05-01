# Python에서 MongoDB사용하기

Python에서 MongoDB사용하기 위해서는 'pymongo'라이브러리를 설치해야 함
<br><br>

## pymongo를 사용하기 위한 기본코드

``` python
from pymongo import MongoClient

# localhost:27017에서 동작중인 mongoDB에 접속
client = MongoClient('localhost', 27017)

# dbsparta라는 DB 이름으로 접속
db = client.dbsparta
```

<br>

## 서버에서 설치한 MongoDB인 경우

로컬에서 작업했을 땐 아이디, 비밀번호가 필요하지 않았지만, 서버(EC2, Linux)에서 MongoDB를 설치할 때 아이디와 비밀번호를 추가했기 때문에 입력 필수!

``` python
# 서버에서 설치한 MongoDB에서는 ID,PWD 필요 / ID:test, PWD:test로 접속
client = MongoClient('mongodb://test:test@localhost', 27017)
# client = MongoClient('localhost', 27017)
```

<br>

## 기본적인 Insert, Find, Update, Delete 사용해보기
**Insert**
``` python
# 저장 - 예시
# 딕셔너리를 만들고, db에 insert
doc = {'name':'Bukayo Saka','age':20}
db.users.insert_one(doc)
```

<br>

**Find**
``` python
# 여러개 찾기 - 예시 ( _id 값은 제외하고 출력)
# find({조건},{id값 가져오기x}) 
same_ages = list(db.users.find({'age':20},{'_id':False})) # False를 붙이면 가져오지 않음

# 한 개 찾기 - 예시
user = db.users.find_one({'name':'Bukayo Saka'})
```

<br>

**Update**
``` python
# 바꾸기 - 예시
# update({이름이 Bukayo Saka 컬럼},{나이를 21 바꿔라})
db.users.update_one({'name':'Bukayo Saka'},{'$set':{'age':21}})
```

<br>

**Delete**
``` python
# 지우기 - 예시
# delete({이름이 Bukayo Saka인 컬럼 삭제})
db.users.delete_one({'name':'Bukayo Saka'})

# 전체 지우기
db.users.delete_many({})
```

<br>

## 데이터 찾아가기? 
****  
정확한 단어를 잘 모르겠..


``` python
idx = (list(db.weeklytest1.find({}).sort([("idx", -1)])))[0]['idx'] + 1
```
예를 들어, DB에 저장되어 있는 데이터를 가져오는데, idx값 기준 역순으로 가져오고, 그 중 가장 처음 값(idx가 가장 큰 값)의 idx값을 + 1해 idx에 저장한다.

말이 장황하지만, Pymongo에서는 이렇게 직관적으로 데이터를 찾아갈 수 있다!

<br>

## 유용한 함수들

DB에 저장된 데이터 수를 가져오기
``` python
post_count = db.weeklytest1.estimated_document_count({})
```