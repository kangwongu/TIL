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

<br>

## JWT를 이용해 로그인 된 사용자정보 이용하기

로그인 된 사용자가 게시글 저장하기
```python
@app.route('/posting', methods=['POST'])
def posting():
    # 쿠키에 있는 JWT 토큰 값을 가져옮
    token_receive = request.cookies.get('mytoken')
    try:
        payload = jwt.decode(token_receive, SECRET_KEY, algorithms=['HS256'])

        # 포스팅하기
        user_info = db.users.find_one({"username": payload["id"]})
        comment_receive = request.form["comment_give"]
        date_receive = request.form["date_give"]
        doc = {
            "username": user_info["username"],
            "profile_name": user_info["profile_name"],
            "profile_pic_real": user_info["profile_pic_real"],
            "comment": comment_receive,
            "date": date_receive
        }
        db.posts.insert_one(doc)

        return jsonify({"result": "success", 'msg': '포스팅 성공'})
    except (jwt.ExpiredSignatureError, jwt.exceptions.DecodeError):
        return redirect(url_for("home"))
```
쿠키에 있는 JWT 토큰 값을 가져와 로그인된 사용자임을 확인하고, 사용자의 정보를 포스팅 내용과 함께 DB에 저장
어떤 사용자가 포스팅을 했는지 알 수 있다.

<br>

```jsx
// 게시글 저장
function post() {
    let comment = $("#textarea-post").val()  // 모달에 작성된 내용
    let today = newDate().toISOString() // 작성 날짜 기록
    $.ajax({
        type: "POST",
        url: "/posting",
        data: {
            comment_give: comment,
            date_give: today
        },
        success: function (response) {
            $("#modal-post").removeClass("is-active") // 모달 닫음
            window.location.reload()
        }
    })
}
```
클라이언트는 모달(포스팅 입력 박스)의 내용과 작성 날짜를 서버에 보내주는데, 자동으로 쿠키가 같이 전달된다.

<br>

로그인된 사용자의 게시글 목록 불러오기

```python
@app.route("/get_posts", methods=['GET'])
def get_posts():
    token_receive = request.cookies.get('mytoken')
    try:
        payload = jwt.decode(token_receive, SECRET_KEY, algorithms=['HS256'])

        # 포스팅 목록 받아오기
        posts = list(db.posts.find({}).sort("date", -1).limit(20)) # 'date' 역순으로 20개 가져옮
        for post in posts:
            post["_id"] = str(post["_id"]) # _id값을 ObjectID -> String 형변환

        return jsonify({"result": "success", "msg": "포스팅을 가져왔습니다.", 'posts':posts})
    except (jwt.ExpiredSignatureError, jwt.exceptions.DecodeError):
        return redirect(url_for("home"))
```
각 포스트를 구분할 수 있게 하기위해 _id값을 문자열로 형변환

<br>

```jsx
// 게시글 목록 가져오기
function get_posts() {
    $("#post-box").empty()
    $.ajax({
        type: "GET",
        url: "/get_posts",
        data: {},
        success: function (response) {
            if (response["result"] == "success") {
                let posts = response["posts"]
                for (let i = 0; i < posts.length; i++) {
                    let post = posts[i]
                    let time_post = newDate(post["date"])
                    let time_before = time2str(time_post)  // 언제 포스팅했는지 시간계산
                    let html_temp = `<div class="box" id="${post["_id"]}">
                                        <article class="media">
                                            <div class="media-left">
                                                <a class="image is-64x64" href="/user/${post['username']}">
                                                    <img class="is-rounded" src="/static/${post['profile_pic_real']}"
                                                        alt="Image">
                                                </a>
                                            </div>
                                            <div class="media-content">
                                                <div class="content">
                                                    <p>
                                                        <strong>${post['profile_name']}</strong> <small>@${post['username']}</small> <small>${time_before}</small>
                                                        <br>
                                                        ${post['comment']}
                                                    </p>
                                                </div>
                                                <nav class="level is-mobile">
                                                    <div class="level-left">
                                                        <a class="level-item is-sparta" aria-label="heart" onclick="toggle_like('${post['_id']}', 'heart')">
                                                            <span class="icon is-small"><i class="fa fa-heart"
                                                                                        aria-hidden="true"></i></span>&nbsp;<span class="like-num">2.7k</span>
                                                        </a>
                                                    </div>

                                                </nav>
                                            </div>
                                        </article>
                                    </div>`
                                $("#post-box").append(html_temp)
                }
            }
        }
    })
}
```

html을 만들어 붙여줄 때, id값을 구분해서 붙여준다.  
각 포스트를 구별하기 위함

<br>

sns기능 (좋아요) 기능 구현하기

``` python
# 좋아요 추가
@app.route('/update_like', methods=['POST'])
def update_like():
    token_receive = request.cookies.get('mytoken')
    try:
        payload = jwt.decode(token_receive, SECRET_KEY, algorithms=['HS256'])

        # 좋아요 수 변경
        user_info = db.users.find_one({"username": payload["id"]}) # 로그인 된 사용자 정보
        post_id_receive = request.form["post_id_give"] # 어떤 포스트인지
        type_receive = request.form["type_give"]
        action_receive = request.form["action_give"]
        doc = {
            "post_id": post_id_receive,
            "username": user_info["username"],
            "type": type_receive
        }
        # 좋아요인지 아닌지 체크
        if action_receive == "like":
            db.likes.insert_one(doc)
        else:
            db.likes.delete_one(doc)
        # 해당 포스트에 해당 타입의 반응이 몇 개인지
        count = db.likes.count_documents({"post_id": post_id_receive, "type": type_receive})
        return jsonify({"result": "success", 'msg': 'updated', "count": count})

        return jsonify({"result": "success", 'msg': 'updated'})
    except (jwt.ExpiredSignatureError, jwt.exceptions.DecodeError):
        return redirect(url_for("home"))
```
JWT 토큰을 통해 로그인된 사용자의 정보를 불러오고, 

<br>

``` jsx
// 좋아요 업데이트
function toggle_like(post_id, type) {
    console.log(post_id, type)
    let $a_like = $(`#${post_id} a[aria-label='heart']`)
    let $i_like = $a_like.find("i")
    // 하트가 클릭되어 있는 상태
    if ($i_like.hasClass("fa-heart")) {
        $.ajax({
            type: "POST",
            url: "/update_like",
            data: {
                post_id_give: post_id,
                type_give: type,
                action_give: "unlike"
            },
            success: function (response) {
                console.log("unlike")
                // 꽉 찬 하트를 빼고, 빈 하트를 추가
                $i_like.addClass("fa-heart-o").removeClass("fa-heart")
                $a_like.find("span.like-num").text(response["count"])
            }
        })
    // 하트가 클릭되어 있지 않은 상태
    } else {
        $.ajax({
            type: "POST",
            url: "/update_like",
            data: {
                post_id_give: post_id,
                type_give: type,
                action_give: "like"
            },
            success: function (response) {
                console.log("like")
                // 빈 하트를 빼고, 꽉 찬 하트를 추가
                $i_like.addClass("fa-heart").removeClass("fa-heart-o")
                $a_like.find("span.like-num").text(num2str(response["count"]))  // 좋아요 수 출력 형식 변경
            }
        })

    }
}
```
좋아요를 클릭한건지, 좋아요를 취소한건지 구별하는 방법으로, 아이콘의 클래스가 fa-heart인지 fa-heart-o인지로 구별했다.

<br>

포스트의 좋아요 개수와 로그인된 사용자가 좋아요를 클릭했는지 여부를 클라이언트에 전달
``` python
#포스팅 목록 받아오기
posts = list(db.posts.find({}).sort("date", -1).limit(20)) # 'date' 역순으로 20개 가져옮
for post in posts:
    post["_id"] = str(post["_id"]) # _id값을 ObjectID -> String 형변환
    post["count_heart"] = db.likes.count_documents({"post_id": post["_id"], "type": "heart"})  # 해당 포스트의 heart가 몇개인지
    post["heart_by_me"] = bool(db.likes.find_one({"post_id": post["_id"], "type": "heart", "username": payload['id']})) # 해당 포스트에 사용자가 heart표시 했는지 체크

return jsonify({"result": "success", "msg": "포스팅을 가져왔습니다.", 'posts':posts})
```
저장된 포스트를 불러올 때, 각 포스트들의 좋아요 개수와, 로그인한 사용자가 좋아요를 체크했는지 확인하는 기능을 추가했다.

<br>

포스팅을 불러오는 함수에 추가
``` jsx
// 사용자가 좋아요를 눌렀는지 안눌렀는지 상태를 동적으로 보여줌
let class_heart = post['heart_by_me'] ? "fa-heart" : "fa-heart-o"
// 좋아요 개수
let count_heart = post['count_heart']
```
서버에서 받아온 값을 이용해 사용자가 좋아요를 누른 상태인지 체크, 좋아요 개수를 포스팅 html에 추가해준다.