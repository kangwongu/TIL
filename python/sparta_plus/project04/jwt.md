# JWT를 이용해 로그인기능 구현하기

## JWT (JSON Web Token)

JSON 객체를 이용해서 사용자의 정보를 안정성 있게 전달하는 웹표준 방식이다.

JSON을 통한 정보 전달 방식, 정보를 Token이라 한다.

브라우저에서 로그인을 한 번 하면 다시 아이디와 패스워드를 묻지 않는데, 이는 로그인했다는 정보를 서버와 클라이언트가 계속 주고받고 있기 때문이다.

<br>

서버
```python
@app.route('/api/login', methods=['POST'])
def api_login():
    id_receive = request.form['id_give']
    pw_receive = request.form['pw_give']

    # 회원가입 때와 같은 방법으로 pw를 암호화합니다.
    pw_hash = hashlib.sha256(pw_receive.encode('utf-8')).hexdigest()

    # id, 암호화된pw을 가지고 해당 유저를 찾습니다.
    result = db.user.find_one({'id': id_receive, 'pw': pw_hash})

    # 찾으면 JWT 토큰을 만들어 발급합니다.
    if result is not None:
        # JWT 토큰에는 로그인 정보가 담겨있다.
        # JWT 토큰에는, payload와 시크릿키가 필요합니다.
        # 시크릿키가 있어야 토큰을 디코딩(=풀기) 해서 payload 값을 볼 수 있습니다.
        # 아래에선 id와 exp를 담았습니다. 즉, JWT 토큰을 풀면 유저ID 값을 알 수 있습니다.
        # exp에는 만료시간을 넣어줍니다. 만료시간이 지나면, 시크릿키로 토큰을 풀 때 만료되었다고 에러가 납니다.
        payload = {
            'id': id_receive,
            'exp': datetime.datetime.utcnow() + datetime.timedelta(seconds=5)
        }
        # payload를 암호화
        token = jwt.encode(payload, SECRET_KEY, algorithm='HS256')

        # token을 클라이언트에 줍니다.
        return jsonify({'result': 'success', 'token': token})
    # 찾지 못하면
    else:
        return jsonify({'result': 'fail', 'msg': '아이디/비밀번호가 일치하지 않습니다.'})

```

DB에서 아이디 패스워드가 일치하는 사용자의 정보를 가져오고, 가져온 데이터를 JWT토큰으로 만들어 클라이언트에게 보낸다.

<br>

암호화할 때 SECRET_KEY는 토큰을 만들 때 필요한 문자열이다.
```python
# JWT 토큰을 만들 때 필요한 비밀문자열입니다. 아무거나 입력해도 괜찮습니다.
# 이 문자열은 서버만 알고있기 때문에, 내 서버에서만 토큰을 인코딩(=만들기)/디코딩(=풀기) 할 수 있습니다.
SECRET_KEY = 'SPARTA'
```

<br>

클라이언트
```jsx
function login() {
    $.ajax({
        type: "POST",
        url: "/api/login",
        data: {id_give: $('#userid').val(), pw_give: $('#userpw').val()},
        success: function (response) {
            if (response['result'] == 'success') {
                // 로그인이 정상적으로 되면, 토큰을 받아옵니다.
                // 이 토큰을 mytoken이라는 키 값으로 쿠키에 저장합니다.
                $.cookie('mytoken', response['token']);

                alert('로그인 완료!')
                window.location.href = '/'  // 로그인에 성공하면 메인화면으로 이동
            } else {
                // 로그인이 안되면 에러메시지를 띄웁니다.
                alert(response['msg'])
            }
        }
    })
}
```
서버에서 토큰을 받으면 '쿠키'에 mytoken이라는 이름으로 JWT토큰을 저장한다.
로그인에 성공하면 메인화면으로 이동시킨다.

<br>

### 쿠키
브라우저에 저장되는 정보이며, 딕셔너리로 형태로 저장된다.  
클라이언트가 서버에 요청할 때, 쿠키값이 항상 같이 보내진다.  
서버는 쿠키를 확인하고 토큰이 있으면 로그인이 된 사용자임을 인식할 수 있게 된다. 

<br>

메인 화면
```python
@app.route('/')
def home():
    # JWT 토큰
    token_receive = request.cookies.get('mytoken')
    try:
        # 시크릿키를 이용해 JWT토큰을 디코딩
        payload = jwt.decode(token_receive, SECRET_KEY, algorithms=['HS256'])
        user_info = db.user.find_one({"id": payload['id']})
        return render_template('index.html', nickname=user_info["nick"])
    except jwt.ExpiredSignatureError:
        return redirect(url_for("login", msg="로그인 시간이 만료되었습니다."))
    except jwt.exceptions.DecodeError:
        return redirect(url_for("login", msg="로그인 정보가 존재하지 않습니다."))
```
클라이언트에서 보내는 쿠키를 확인하고, 토큰이 있으면 받아온 후, 디코딩한다.  
DB에서 해당하는 값을 찾아 닉네임을 index.html과 함께 보내준다.