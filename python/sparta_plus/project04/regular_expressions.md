# 정규표현식 활용하기

## 정규표현식 이용해 복잡한 조건 체크하기

정규표현식을 이용해 입력의 조건을 걸어둘 수 있다.

<br>

### 예시
```jsx
// 중복확인
function check_dup() {
    let username = $("#input-username").val()
console.log(username)
    // id가 공백일 때
    if (username == "") {
        $("#help-id").text("아이디를 입력해주세요.").removeClass("is-safe").addClass("is-danger")
        $("#input-username").focus()
        return;
    }
    // 아이디가 조건(정규표현식)에 일치하는지?
    if (!is_nickname(username)) {
        $("#help-id").text("아이디의 형식을 확인해주세요. 영문과 숫자, 일부 특수문자(._-) 사용 가능. 2-10자 길이").removeClass("is-safe").addClass("is-danger")
        $("#input-username").focus()
        return;
    }
    $("#help-id").addClass("is-loading")

    $.ajax({
        type: "POST",
        url: "/sign_up/check_dup",
        data: {
            username_give: username
        },
        success: function (response) {
            // id가 중복일 때
            if (response["exists"]) {
                $("#help-id").text("이미 존재하는 아이디입니다.").removeClass("is-safe").addClass("is-danger")
                $("#input-username").focus()
            } else {
                $("#help-id").text("사용할 수 있는 아이디입니다.").removeClass("is-danger").addClass("is-success")
            }
            $("#help-id").removeClass("is-loading")

        }
    });
}
```

<br>

정규표현식
```jsx
function is_nickname(asValue) {
    // 정규표현식
    var regExp = /^(?=.*[a-zA-Z])[-a-zA-Z0-9_.]{2,10}$/;
    return regExp.test(asValue);
}
```

입력의 조건을 `문자, 숫자, 일부 특수문자(._-)만 사용 가능, 2-10자 길이`로 제한했을 때, 위처럼 정규표현식을 이용해 표현한다.

정규표현식은 크게 바뀌지 않기 때문에 인터넷에서 형식을 찾고 필요에 따라 수정하면 된다.

<br>

``` jsx
function is_password(asValue) {
    var regExp = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z!@#$%^&*]{8,20}$/;
    return regExp.test(asValue);
}
```
`영문, 숫자는 1개 씩 무조건 포함, 일부 특수문자 사용 가능, 8-20자 길이`