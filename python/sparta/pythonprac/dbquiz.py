from pymongo import MongoClient
client = MongoClient('localhost', 27017)
db = client.dbsparta

# 영화제목 '매트릭스'의 평점 가져오기
movie_name = db.movies.find_one({'title':'매트릭스'},{'_id':False})
print(movie_name['star'])

# '매트릭스'의 평점과 같은 평점의 영화제목들 가져오기
matrix_star = movie_name['star']
movie_stars = list(db.movies.find({'star':matrix_star},{'_id':False}))
for movie_star in movie_stars:
    print(movie_star['title'])

# 매트릭스 영화의 평점 0으로 만들기
db.movies.update_one({'title':'매트릭스'},{'$set':{'star':'0'}})

