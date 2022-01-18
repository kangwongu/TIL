from flask import Flask, render_template, jsonify, request

app = Flask(__name__)

from pymongo import MongoClient
                                # id:password
client = MongoClient('mongodb://test:test@localhost', 27017)
# client = MongoClient('localhost', 27017)
db = client.dbsparta


@app.route('/')
def home():
    return render_template('index.html')


## API 역할을 하는 부분
# 주문정보 생성
@app.route('/order', methods=['POST'])
def product_order():
    # 1. 주문자 이름, 수량, 주소, 전화번호 값을 받는다.
    name_receive = request.form['name_give']
    number_receive = request.form['number_give']
    address_receive = request.form['address_give']
    phone_receive = request.form['phone_give']

    print(name_receive, number_receive, address_receive, phone_receive)
    # 2. DB에 저장한다
    # json으로 만듦
    doc = {
        'name': name_receive,
        'number': number_receive,
        'address': address_receive,
        'phone': phone_receive
    }

    # db에 저장
    db.product.insert_one(doc)

    # 3. 성공 메세지를 보내준다
    return jsonify({'msg': '주문 완료!'})

# 주문정보 보여주기
@app.route('/order', methods=['GET'])
def product_read():
    # 1. DB에서 모든 데이터를 꺼내온다
    order_list = list(db.product.find({}, {'_id': False}))

    # 2. 클라에 보내준다
    return jsonify({'order_list':order_list})


if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)