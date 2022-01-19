from flask import Flask, render_template, request, jsonify
app = Flask(__name__)

from pymongo import MongoClient
client = MongoClient('localhost', 27017)
db = client.dbsparta

## URL 별로 함수명이 같거나,
## route('/') 등의 주소가 같으면 안됩니다.

@app.route('/')
def home():
   return render_template('index.html')


# 주문 생성, POST, /order
@app.route('/order', methods=['POST'])
def product_order():
   # 클라에게 주문자 이름, 주소, 전화번호, 수량을 넘겨받고, DB에 저장
   # 1. 클라이언트에서 넘어오는 주문자 이름, 주소, 전화번호, 수량을 넘겨받는다.
   name_receive = request.form['name_give']
   address_receive = request.form['address_give']
   tel_receive = request.form['tel_give']
   num_receive = request.form['num_give']

   # DB로 만들기 위해 딕셔너리로 만든다.
   doc = {
      'name':name_receive,
      'address':address_receive,
      'tel':tel_receive,
      'num':num_receive
   }

   # 2. DB에 저장한다.
   db.product.insert_one(doc)

   return jsonify({'result':'success', 'msg': '주문이 완료되었어요!'})


# 주문 조회, GET, /order
@app.route('/order', methods=['GET'])
def product_show():
   # DB에 저장되어 있는 데이터를 클라이언트에 반환한다.
   # 1. DB에서 데이터들을 전부 가져온다.
   order_list = list(db.product.find({}, {'_id': False}))

   # 2. 클라이언트에 가져온 데이터를 보내준다.
   return jsonify({'order_list': order_list})

if __name__ == '__main__':
   app.run('0.0.0.0', port=5000, debug=True)