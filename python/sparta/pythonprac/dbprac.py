from pymongo import MongoClient
client = MongoClient('localhost', 27017)
db = client.dbsparta

# 코딩 시작
# insert / find / update / delete

# 저장 - 예시
# 딕셔너리를 만들고, db에 insert
doc = {'name':'bobby','age':21}
db.users.insert_one(doc)

# 여러개 찾기 - 예시 ( _id 값은 제외하고 출력)
# find({조건},{id값 가져오기x})
same_ages = list(db.users.find({},{'_id':False}))

for person in same_ages:
    print(person['name'])

# 한 개 찾기 - 예시
user = db.users.find_one({'name':'bobby'},{'_id':False})

# 바꾸기 - 예시
# update({이름이 bobby인 컬럼},{나이를 19로 바꿔라})
db.users.update_one({'name':'bobby'},{'$set':{'age':19}})

# 지우기 - 예시
# delete({이름이 bobby인 컬럼 삭제})
db.users.delete_one({'name':'bobby'})