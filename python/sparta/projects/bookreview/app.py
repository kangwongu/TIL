from flask import Flask, render_template, jsonify, request
app = Flask(__name__)

from pymongo import MongoClient
client = MongoClient('localhost', 27017)
db = client.dbsparta

## HTML을 주는 부분
@app.route('/')
def home():
    return render_template('index.html')

## API 역할을 하는 부분
# POST
@app.route('/review', methods=['POST'])
def write_review():
    # 1. 클라이언트에서 넘어오는 제목, 저자, 리뷰값들을 받는다.
    title_receive = request.form['title_give']
    author_receive = request.form['author_give']
    review_receive = request.form['review_give']

    # 2. 받은 값들을 딕셔너리로 만든다
    doc = {
        'title':title_receive,
        'author':author_receive,
        'review':review_receive
    }

    # 3. db에 저장한다
    db.bookreivew.insert_one(doc)

    return jsonify({'msg': '저장 완료!'})


# GET
@app.route('/review', methods=['GET'])
def read_reviews():
    reviews = list(db.bookreivew.find({}, {'_id': False}))

    return jsonify({'all_reviews':reviews})


if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)