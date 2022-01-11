# pymongo 기본 코드
from pymongo import MongoClient
client = MongoClient('localhost', 27017)
db = client.dbsparta

# 코딩 시작

# insert / find / update / delete

# insert
# doc = {'name':'biky','age':20,'gender':'female'}
# db.users.insert_one(doc)

# find

# 여러개 찾기 - 예시 ( _id 값은 제외하고 출력)
# same_ages = list(db.users.find({'age':20},{'_id':False})) # 나이가 20인 데이터 가져옮, id는 표시x
#
# for person in same_ages:
#     print(person)

# 한 개 찾기 - 예시
# user = db.users.find_one({'name':'bobby'})
# user = db.users.find_one({'name':'bobby'},{'_id':False})

# update
# db.users.update_one({'name':'bobby'},{'$set':{'age':19}})

# delete
db.users.delete_one({'name':'bobby'})

