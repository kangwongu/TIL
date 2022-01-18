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
@app.route('/review', methods=['POST'])
def write_review():
    # 클라이언트에서 넘어오는 제목, 저자, 리뷰데이터를 받음
    title_receive = request.form['title_give']
    author_receive = request.form['author_give']
    review_receive = request.form['review_give']

    # DB에 저장하기 위해 딕셔너리로 만듦
    doc = {
        'title': title_receive,
        'author': author_receive,
        'review': review_receive
    }

    # DB에 저장
    db.bookreview.insert_one(doc)

    return jsonify({'msg': '저장 완료!'})


@app.route('/review', methods=['GET'])
def read_reviews():
    # DB에 있는 리뷰데이터들을 클라이언트에 보내줌

    # DB에 저장되어 있는 모든 데이터 가져옮
    reviews = list(db.bookreview.find({},{'_id':False})) # id는 표시x

    # 클라이언트에 보내줌
    return jsonify({'all_reviews': reviews})


if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)