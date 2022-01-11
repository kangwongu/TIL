# pymongo 기본 코드
from pymongo import MongoClient
client = MongoClient('localhost', 27017)
db = client.dbsparta

# star = db.movies.find_one({'title':'매트릭스'},{'_id':False}, )
# print(star['start'])

# movie = db.movies.find_one({'title':'매트릭스'},{'_id':False}, )
# target_star = movie['start']

# movie_list = list(db.movies.find({'start':target_star},{'_id':False}))
# for movie in movie_list:
#   print(movie['title']

db.movies.update_one({'title':'매트릭스'},{'$set':{'start':'0'}})