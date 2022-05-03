# 회원가입 구현해보기
회원가입을 할 때 중요한 점은 비밀번호를 암호화 하는 것이다.  
암호화할 때는 해시 함수를 이용했다.

<br>

## 해시 함수

입력한 데이터를 랜덤한 암호화된 값으로 변환해주는 함수이다.  
일종의 암호화 알고리즘  
항상 똑같은 길이의 암호화된 값을 반환해 준다.

<br>

## 예시
비밀번호를 저장할 때는 암호화해서 값을 저장한다
```python
@app.route('/api/register', methods=['POST'])
def api_register():
    id_receive = request.form['username_give']
    pw_receive = request.form['password_give']

    # 비밀번호 암호화
    pw_hash = hashlib.sha256(pw_receive.encode('utf-8')).hexdigest()

    db.user.insert_one({'id': id_receive, 'pw': pw_hash, 'nick': id_receive})

    return jsonify({'result': 'success'})
```
비밀번호를 암호화해서 저장한다.

<br>

``` javascript
// 회원가입
function sign_up() {
    let username = $("#input-username").val()
    let password = $("#input-password").val()
    let password2 = $("#input-password2").val()
    console.log(username, password, password2)

    // 중복검사
    if ($("#help-id").hasClass("is-danger")) {
        alert("아이디를 다시 확인해주세요.")
        return;
    } else if (!$("#help-id").hasClass("is-success")) {
        alert("아이디 중복확인을 해주세요.")
        return;
    }

    // 패스워드 검사
    // 중복검사
    if (password == "") {
        $("#help-password").text("비밀번호를 입력해주세요.").removeClass("is-safe").addClass("is-danger")
        $("#input-password").focus()
        return;
    // 패스워드 조건검사 (정규표현식)
    } else if (!is_password(password)) {
        $("#help-password").text("비밀번호의 형식을 확인해주세요. 영문과 숫자 필수 포함, 특수문자(!@#$%^&*) 사용가능 8-20자").removeClass("is-safe").addClass("is-danger")
        $("#input-password").focus()
        return
    } else {
        $("#help-password").text("사용할 수 있는 비밀번호입니다.").removeClass("is-danger").addClass("is-success")
    }

    if (password2 == "") {
        $("#help-password2").text("비밀번호를 입력해주세요.").removeClass("is-safe").addClass("is-danger")
        $("#input-password2").focus()
        return;
    // 패스워드1과 패스워드2가 일치하는지 검사
    } else if (password2 != password) {
        $("#help-password2").text("비밀번호가 일치하지 않습니다.").removeClass("is-safe").addClass("is-danger")
        $("#input-password2").focus()
        return;
    } else {
        $("#help-password2").text("비밀번호가 일치합니다.").removeClass("is-danger").addClass("is-success")
    }
    $.ajax({
        type: "POST",
        url: "/api/register",
        data: {
            username_give: username,
            password_give: password
        },
        success: function (response) {
            alert("회원가입을 축하드립니다!")
            window.location.replace("/login")  // 로그인 창으로 이동
        }
    });

}
```
회원가입 기능을 구현하기 위해 고려해야 할 것이 많다는 것을 기억하기 위해 긴 예시를 가져왔다..  
생각해야 할 기능이 많다.

아이디, 비밀번호 공백검사, 조건검사등등 비밀번호와 비밀번호 확인이 일치하는지, 여러 생각해야 할 점이 많다!

참고하자