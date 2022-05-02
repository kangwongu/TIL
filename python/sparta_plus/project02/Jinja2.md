# Jinja2 사용하기

SSR을 해볼건데, 나는 플라스크를 사용중이기에, 플라스크에서 사용하는 템플릿 언어인 Jinja2를 사용


## 플라스크에서 페이지 이동하기

`<a href="/detail">상세페이지로 가기</a>`

주소가 ‘/detail’인 곳으로 이동하려 할 때, HTML a태그를 이용해 페이지를 이동시킬 수 있다.

<br>

`<button onclick="***window***.location.href='/'">메인으로 돌아가기</button>`

버튼을 통해서도 페이지 이동하도록 할 수 있다.    
주소가 ‘/’인 곳으로 이동한다.

onclick에 함수가 들어가야 하지만, 한 줄짜리 함수는 바로 onclick자리에 넣어줄 수 있다.

<br>

## Jinja2 템플릿을 이용해 페이지에 값을 넣어보기

``` python
@app.route('/')
def main():
    myname = "Saka"
    return render_template("index.html", name=myname)
```

변수에 값을 넣고, index.html을 그릴 때, name값으로 보내준다

`<h3>{{ name }}아 안녕~</h3>`

index.html에서 받은 name값을 띄워준다.

<br>

### 반복문 조건문을 통해 더 다양하게 값을 넣어보기

**Ajax를 이용해보기**

복합적인 방법으로 페이지 그려보기

url로 요청을 하고 데이터를 받아온 후, 필요한 데이터를 뽑아 html태그로 만들고 붙여넣는다.

```jsx
function get_list() {
    $('#gu-list').empty()
    $.ajax({
        type: "GET",
        url: "http://openapi.seoul.go.kr:8088/6d4d776b466c656533356a4b4b5872/json/RealtimeCityAir/1/99",
        data: {},
        success: function (response) {
            let rows = response["RealtimeCityAir"]["row"];
            for (let i=0; i<rows.length; i++) {
                let gu_name = rows[i]['MSRSTE_NM']
                let gu_mise = rows[i]['IDEX_MVL']

                if (gu_mise >= 60) {
                    let html_temp = `<li>${gu_name}: ${gu_mise}</li>`

                    $('#gu-list').append(html_temp)
                }

            }
        }
    })
}
```
<br>

**Jinja2를 이용해보기**

SSR

우선, 서버에서 해당하는 데이터를 가져와야 한다

```python
@app.route('/detail/<keyword>')
def detail(keyword):
    # jinja2를 이용하기
    # requests를 이용해 해당 url로 get요청을 보낸다
    r = requests.get('http://openapi.seoul.go.kr:8088/6d4d776b466c656533356a4b4b5872/json/RealtimeCityAir/1/99')
    response = r.json()  # 서버에서 얻어온 값을 json으로 변환
    rows = response['RealtimeCityAir']['row']

    return render_template("detail.html", rows=rows)
```

detail.html을 그릴 때, rows값을 함께 보내준다.  
detail.html에서 rows값을 사용 가능하다

파이참에게 Jinja2 템플릿 언어 사용을 알려주는 방법

Settings - Languages & Frameworks - Templete Languages - None → Jinja2변경

<br>

```html
<ul id="gu-list">
<!-- 반복문 -->
	{% for row in rows %}
		<!-- jinja2 변수 선언 -->
		{% set gu_name = row["MSRSTE_NM"] %}
		{% set gu_mise = row["IDEX_MVL"]|int %}  <!-- 정수로 나타내기 -->
			<!-- 조건문 -->
			{% if gu_mise >= 60 %}
				<li>{{ gu_name }}: {{ gu_mise }} </li>
			{% endif %} <!-- 조건문이 끝남을 알림 -->
	{% endfor %} <!-- 반복문이 끝남을 알림 -->
</ul>
```

Jinja2 템플릿 언어를 통해 html의 값을 채워 넣는다.  
Jinja2에서 변수 선언하는 방법, 반복문, 조건문을 사용했다.

Jinja2를 이용해 script태그나, title태그의 값을 채워 넣을 수도 있다

<br>

### URL 주소에서 데이터를 받아서 Jinja2로 넘겨주기

```python
@app.route('/detail')
def detail(keyword):
    # get요청으로 보낸 파라미터를 받기
    word_receive = request.args.get("word_give")
    print(word_receive)
    return render_template("detail.html", word=word_receive)
```

예를 들어, /detail?word_give=hi 로 요청을 하면 request.args.get()을 통해 word_give값을 받을 수 있다.

받은 값을 detail.html과 함께 보내주면,

`<h3>받은 단어는 {{ word }} </h3>`

위와 같이 detail.html에서 사용이 가능하다

<br>

### 플라스크에서 주소의 일부를 변수처럼 사용하는 방법

```python
@app.route('/detail/<keyword>')
def detail(keyword):
    
    return render_template("detail.html", word=keyword)
```

/detail뒤에 /하고 들어오는 값들을 keyword에 저장하고 함수에 넘겨주면, 그 값을 바로 detail.html에 넘겨줄 수 있다

예를 들어, /detail/hello로 요청을 하면, keyword에 hello가 저장되고, detail.html에 word값으로 전달된다.

<br>

### API와 응용해서 사용해보기

오픈 API인 사전 API에 요청하고, 해당하는 값을 받아보기

**Ajax로 해보기**

```jsx
$.ajax({
    type: "GET",
    url: `https://owlbot.info/api/v4/dictionary/${word}`,
    beforeSend: function (xhr) {
        xhr.setRequestHeader("Authorization", "Token [받은 토큰]");
    },
    data: {},
    error: function (xhr, status, error) {
        alert("에러 발생!");
    },
    success: function (response) {
        console.log(response)
    }
})
```
하지만 Ajax로 이러한 작업을 수행하면, 새로고침을 할 때마다 깔끔하게 화면이 보여지는 것이 아니라, 샘플데이터가 잠깐 보였다가 화면이 그려지게 된다.

Ajax요청을 하고 사전 API에서 그 데이터를 받아와서 그걸 채워 넣는데에 시간이 걸리기 때문이다.

이 부분이 사용자 입장에서 매우 어색하게 보일 수 있기 때문에 Jinja2를 이용해서 미리 html을 완성해서 보내주는, Server-side rendering을 해주는 것이 좋은 방법이다!

<br>

**Jinja2로 해보기**

```python
@app.route('/detail/<keyword>')
def detail(keyword):
    # jinja2를 이용하기
    r = requests.get(f"https://owlbot.info/api/v4/dictionary/{keyword}", headers={"Authorization": "Token [받은 토큰]"})
    result = r.json()
    print(result)

    return render_template("detail.html", word=keyword, result=result)
```

keyword를 받고, 해당 keyword로 사전 API에 요청하고 해당하는 값을 받아온다.

받아온 값을 result에 넣어 detail.html과 함께 보내준다.

detail.html에서는 result값을 이용해서 값을 채워주면 된다.

```html
<div class="container">
    <div class="d-flex justify-content-between align-items-end">
        <div>
            <h1 id="word" style="display: inline;">{{ result.word }}</h1>
            <!--pronunciation값이 있으면 보여주고, 없으면 생략 -->
            {% if result.pronunciation %}
                <h5 id="pronunciation" style="display: inline;">/{{ result.pronunciation }}/</h5>
            {% endif %}
        </div>
        <button id="btn-save" class="btn btn-outline-sparta btn-lg">
            <i class="fa fa-floppy-o" aria-hidden="true"></i>
        </button>
        <button id="btn-delete" class="btn btn-sparta btn-lg">
            <i class="fa fa-trash-o" aria-hidden="true"></i> 
        </button>
    </div>
    <hr>
    <div id="definitions">
        <div style="padding:10px">
            {% for definition in result.definitions %}
                <i>{{ definition.type }}</i>
                <!-- 깨진 글자들은 버림 -->
                <br>{{ definition.definition.encode('ascii', 'ignore').decode('utf-8')}}<br>
                <!-- example값이 None이 아니면 보여주고, None이면 생략 -->
                {% if definition.example %}
                    <!-- Jinja2에서 태그를 무시하기 때문에 태그가 들어오면 태그를 표시하도록 설정해줘야 함 -->
                    <span class="example">{{ definition.example.encode('ascii', 'ignore').decode('utf-8')|safe }}</span><br>
                {% endif %}
            {% endfor %}
        </div>
    </div>
</div>
```

<br>

HTML 태그 쓰는 것을 허용한다
``` html
{{ definition.example|safe }}
```

<br>

깨진 글자들 버리기
``` html
definition.example.encode('ascii', 'ignore').decode('utf-8')
```
문자열을 아스키코드로 바꿀 수 있는지 확인하고, 바꿀 수 없는 문자는 버린다

<br>

### 상태 정보 값을 넘겨줘서 상태마다 다르게 표시해보기
``` python
@app.route('/detail/<keyword>')
def detail(keyword):
    status_receive = request.args.get("status_give")
    # API에서 단어 뜻 찾아서 결과 보내기
    r = requests.get(f"https://owlbot.info/api/v4/dictionary/{keyword}", headers={"Authorization": "Token 143a72db769a4abe0021d8c92b8610e5db637825"})
    result = r.json()
    print(result)

    return render_template("detail.html", result=result, word=keyword, status=status_receive)
```
status_give값을 추가,
예를 들어 '/detail/hello/status_give=new'로 요청을 하면, status_receive에 new값이 담기고, detail.html에 전달된다.

<br>

``` html
{% if status=='new' %}
    <button id="btn-save" class="btn btn-outline-sparta btn-lg">
        <i class="fa fa-floppy-o" aria-hidden="true"></i>
    </button>
{% else %}
    <button id="btn-delete" class="btn btn-sparta btn-lg">
        <i class="fa fa-trash-o" aria-hidden="true"></i>
    </button>
{% endif %}
```
서버에서 넘어온 status값에 따라 표시되는 버튼이 달라진다!

<br>

### DB에서 불러온 값을 넘겨주기

메인화면으로 이동할 때마다 DB에서 데이터를 가져와 보내준다.
``` python
@app.route('/')
def main():
    # DB에서 저장된 단어 찾아서 HTML에 나타내기
    words = list(db.words.find({}, {'_id':False}))
    return render_template("index.html" ,words=words)
```

<br>

index.html에서 서버에서 보내준 값을 사용한다.
``` javascript
// json임을 알려줌
let words = {{ words|tojson }};
```
