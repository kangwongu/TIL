from flask import Flask, render_template, jsonify, request
app = Flask(__name__)

from pymongo import MongoClient
# client = MongoClient('localhost', 27017)
client = MongoClient('mongodb://test:test@localhost', 27017)
db = client.dbsparta_plus_week1

from datetime import datetime

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/diary', methods=['GET'])
def show_diary():
    diaries = list(db.diary.find({}, {'_id': False}))

    return jsonify({'all_diary':diaries})

@app.route('/diary', methods=['POST'])
def save_diary():
    title_receive = request.form['title_give']
    content_receive = request.form['content_give']

    # 클라이언트에서 보낸 파일 가져옮
    file = request.files["file_give"]

    # 확장자
    extension = file.filename.split('.')[-1]

    today = datetime.now()
    mytime = today.strftime('%Y-%m-%d-%H-%M-%S') # 파일 저장에 쓰일 부분
    post_time = today.strftime('%Y.%m.%d') # 파일 저장한 일자

    # 파일 이름, 경로 설정
    filename = f'file-{mytime}'
    save_to = f'static/{filename}.{extension}'
    file.save(save_to) # save_to 경로와 이름으로 파일 저장

    doc = {
        'title': title_receive,
        'content': content_receive,
        'file':f'{filename}.{extension}',
        'time':post_time
    }

    db.diary.insert_one(doc)

    return jsonify({'msg': '저장 완료!'})

if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)