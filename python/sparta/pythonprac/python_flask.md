# Flask 프레임워크 사용하기

## Flask 프레임워크 설치하기
Flask 프레임워크를 설치한다.  
File -> settings -> Python Interpreter -> flask 검색 후 설치<br><br>

## Flask 기본 코드

```python
from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def home():
	 # templates폴더에 있는 index.html파일을 클라이언트에 전달
   return render_template('index.html')  

if __name__ == '__main__':  
   app.run('0.0.0.0',port=5000,debug=True)
```

## Flask 폴더 구조

static 폴더 : CSS, JS, 이미지 파일 담아놓는 곳  
templates 폴더 : HTML파일들을 담아놓는 곳<br><br>

## API만들기

GET - 데이터 조회  
POST - 데이터 생성, 변경, 삭제

API를 만들고 클라이언트에서 Ajax로 요청하는 방식

### 예시

**API (GET)**

```python
# GET
@app.route('/test', methods=['GET'])
def test_get():
   # DB에서 데이터를 가져온다
   samples = list(db.sample.find({},{'_id':False}))

   # 가져온 데이터를 클라이언트에 보낸다
   return jsonify({'samples':sample})
```

**Ajax (GET)**

```jsx
$.ajax({
    type: "GET",
    url: "/test",  // /test로 요청
    data: {},
    success: function(response){
      // 서버로부터 받은 데이터를 가공
      for(...) {
        // 필요한 데이터 추출   
        ...
        // HTML로 만들기
        let temp_html = `태그`
        // 추가하고자 하는 태그(id)에 붙이기
        $('$[id값]').append(temp_html)
      }	 
    }
  })
```
<br>

**API (POST)**

```python
# POST
@app.route('/test', methods=['POST'])
def test_post():
  # 서버에 sample_give로 넘어온 값을 sample_receive에 저장
  sample_receive = request.form['sample_give']
  
  # 클라이언트에서 리스트로 넘어오는 값을 받기 
  sample_list = request.form.getlist('sample_list[]')
	 
  # DB에 저장하기 위해 딕셔너리로 만들기
  doc = {
    'sample':sample_receive,  
    'sample_list':sample_list  # Array형으로 저장된다
  }	 

  # 만든 딕셔너리르 DB에 저장하기
  db.sample.insert_one(doc)  

  # 클라이언트에 반환
  return jsonify({'result':'success', 'msg': '이 요청은 POST!'})
```

**Ajax (POST)**

```jsx
$.ajax({
    type: "POST",
    url: "/test",
    data: { 
      sample_give:'샘플',
      sample_list: [리스트]
    },  
    success: function(response){
       console.log(response)
    }
  })
```
<br>




번외) 프로젝트 구현 시, 이런 방향으로 구현하면 좋다

1. 클라이언트와 서버 연결 확인
2. 서버부터 만들기
3. 클라이언트 만들기
4. 핑퐁 하면서 완성하기
<br>

개념을 익히는 것도 중요하지만, 앞으로 구현하고 싶은 기능이 뭔지 생각하면서 접근하는 것이 중요하다고 느낌

내가 어떤 기능을 구현하고 싶은지에 대해 정확히 이해하려 노력하기
