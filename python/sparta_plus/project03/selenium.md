# Selenium

Selenium은 브라우저 제어 프로그램이다.

웹스크래핑 뿐만 아니라 브라우저 제어 기능을 응용하면 정해진 시간에 게시판에 글을 작성하는 등 다양한 업무를 자동화하는 데 쓰일 수 있고, HTML 띄우기, 스크롤, 버튼 클릭 등 다양한 동작을 수행 할 수 있다.

<br>

## 웹 스크래핑

웹 페이지에서 우리가 원하는 정보를 가져오는 것이다.

정적인 웹페이지를 스크래핑할 때는 requests라이브러리를 통해 가져오고 bs4로 가공하면 쉽게 가져올 수 있었다.  
하지만 동적인 웹페이지를 스크래핑할 때는 Selenium을 이용해 브라우저에 띄운 후, 소스코드를 가져오는 방법을 써야 제대로 스크래핑을 할 수 있다.

<br>

## Selenium을 이용해서 웹 스크래핑 해보기

Selenium을 사용하기 위해선 크롬 드라이버가 필요하다

- Selenium이 크롬을 통제할 수 있도록 하기 위해!

크롬 버전을 확인하고 해당하는 버전의 크롬 드라이버를 다운로드한다.  
다운 받은 크롬 드라이버를 Selenium을 사용할 파일과 같을 위치로 이동시킨다

<br>

Selenium 시작 코드 예시

```python
from bs4 import BeautifulSoup
from selenium import webdriver
from time import sleep

driver = webdriver.Chrome('./chromedriver')  # 드라이버를 실행합니다.

url = "https://www.melon.com/chart/day/index.htm"
# headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36'}
# data = requests.get(url, headers=headers)

driver.get(url)  # 드라이버에 해당 url의 웹페이지를 띄웁니다.
sleep(5)  # 페이지가 로딩되는 동안 5초 간 기다립니다.

req = driver.page_source  # html 정보를 가져옵니다.
driver.quit()  # 정보를 가져왔으므로 드라이버는 꺼줍니다.

# soup = BeautifulSoup(data.text, 'html.parser')
soup = BeautifulSoup(req, 'html.parser')  # 가져온 정보를 beautifulsoup으로 파싱해줍니다.

```

bs4로 가져온 html을 가공하는 것은 동일하다.  
다만, Selenium을 이용해서 가져올 건지, requests를 이용해서 가져올 건지가 다른 점이다

주석은 requests를 이용해서 스크래핑을 했을 때의 예시코드이다.

<br>

Selenium은 크롬드라이버에게 명령을 내리는 것이다.  
그래서 다양한 것을 수행할 수 있다

스크롤 내리기 예시

```python
# ""안에 있는 명령어를 크롬브라우저에게 시키는 일
driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
```

스크롤을 위에서 부터 끝까지 내리는 코드

driver.execute_script()을 통해 크롬드라이버에게 명령을 내린다

<br>

## 네이버 지도 API 사용해보기

네이버 클라우드 플랫폼에서 어플리케이션을 등록 후, Web Dynamic Map와 Geocoding API를 선택하고, Web 서비스 URL에 http://localhost:5000 (로컬에서만 사용할 것이기 때문!)을 추가해준다.

<br>

### 사용하기!
```jsx
$(document).ready(function () {
    // 네이버에서 지도를 만든다는 뜻
    let map = new naver.maps.Map('map', {
        // (위도, 경도)값의 위치를 지도의 중앙에 두고
        center: new naver.maps.LatLng(37.4981125, 127.0379399),
        // 줌을 10정도 땡기기
        zoom: 10
    });
})
```


네이버 지도를 만들고 설정한 후에, `<div id="map"></div>` id가 map인 곳에 네이버 지도를 그려준다.

HTML과 JS함수를 우리가 연결하지 않았지만, 연결이 되어 네이버 지도 API를 사용할 수 있게 되는데, 이는 네이버 지도 API가 연결해준 것이다.

id값이 바뀌면 연결을 해제된다.

<br>

### 확대/축소 버튼 넣어보기
```jsx
let map = new naver.maps.Map('map', {
    center: new naver.maps.LatLng(37.4981125, 127.0379399),
    zoom: 10,
    // 확대, 축소 컨트롤 하는 설정을 켜기
    zoomControl: true,
    zoomControlOptions: {
        // 확대/축소 버튼의 옵션
        style: naver.maps.ZoomControlStyle.SMALL,
        position: naver.maps.Position.TOP_RIGHT
    }
});
```

지도 관련한 것은 map안에 옵션을 줌으로써 사용이 가능하다

지도를 띄울 땐 new naver.maps.Map({~})

<br>

### 마커 띄워보기

```jsx
// 마커 띄우기
let marker = new naver.maps.Marker({
    // 어느 위치에 보여줄 건지
    position: new naver.maps.LatLng(37.4981125, 127.0379399),
    // 어느 지도에 보여줄 건지
    map: map
});
```
마커를 띄울 땐 new naver.maps.Marker({~})

<br>

#### 마커 이미지 바꾸기 
`icon: "{{ url_for('static', filename='rtan_heart.png') }}"`

마커 이미지를 바꾸려면 위의 코드를 마커 띄우는 코드에 추가한다.

<br>

### 정보창 (infoWindow) 띄워보기

```jsx
// 정보창 띄우기
let infowindow = new naver.maps.InfoWindow({
    // 이 내용을 정보창으로 보여주겠다는 의미
    content: `<div style="width: 50px;height: 20px;text-align: center"><h5>안녕!</h5></div>`,
});
// 만든 정보창을 열겠다는 명령어 (내가 만든 맵, 지정한 마커)
infowindow.open(map, marker);
```

정보창을 띄울땐 naver.maps.InfoWindow({})

정보창을 닫을 땐 아래 코드를 추가

`infowindow.close(); // 닫기`

<br>

### 리스너를 추가해 사용자 동작에 따라 다르게 구현해보기

```jsx
// 네이버 맵의 이벤트 등록 ( 사용자가 마커에 클릭을 하는지 체크 )
naver.maps.Event.addListener(marker, "click", function () {
console.log(infowindow.getMap()); // 정보창이 열려있을 때는 연결된 지도를 반환하고 닫혀있을 때는 null을 반환
    if (infowindow.getMap()) {
        infowindow.close();
    } else {
        infowindow.open(map, marker);
    }
});
```

사용자가 마커를 클릭하면 정보창을 띄우고 닫는 기능

<br>

## Selenium과 지도 API 활용해보기


### Selenium으로 스크래핑 하기

SBS TV 맛집사이트에서 스크래핑

```python
from selenium import webdriver
from bs4 import BeautifulSoup
import time
from selenium.common.exceptions import NoSuchElementException
from pymongo import MongoClient
import requests

client = MongoClient('[AWS주소]', 27017, username="아이디", password="비밀번호")
db = client.dbsparta_plus_week3

driver = webdriver.Chrome('./chromedriver')

url = "http://matstar.sbs.co.kr/location.html"

driver.get(url)
time.sleep(5)

# 더보기 버튼 클릭하기 (10번 클릭)
for i in range(10):
    try:
        btn_more = driver.find_element_by_css_selector("#foodstar-front-location-curation-more-self > div > button")
        btn_more.click()
        time.sleep(5)
    except NoSuchElementException:
        break

req = driver.page_source
driver.quit()

soup = BeautifulSoup(req, 'html.parser')

places = soup.select("ul.restaurant_list > div > div > li > div > a")
print(len(places))

for place in places:
    title = place.select_one("strong.box_module_title").text
    address = place.select_one("div.box_module_cont > div > div > div.mil_inner_spot > span.il_text").text
    category = place.select_one("div.box_module_cont > div > div > div.mil_inner_kind > span.il_text").text
    show, episode = place.select_one("div.box_module_cont > div > div > div.mil_inner_tv > span.il_text").text.rsplit(" ", 1)
```

Selenium을 이용해 해당 브라우저에서 더보기 버튼을 클릭하고 스크래핑 하는 코드

<br>

### 스크래핑한 정보를 지도에 띄워보기

맛집 정보를 스크래핑 해왔는데, 이 맛집의 위치를 지도에 띄워보자

주소를 좌표로 변환해주는 geocoding API를 활용한다.

요청 방법

```html
curl -G "[https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode](https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode)" \
--data-urlencode "query={주소}" \
--data-urlencode "coordinate={검색_중심_좌표}" \
-H "X-NCP-APIGW-API-KEY-ID: {애플리케이션 등록 시 발급받은 client id값}" \
-H "X-NCP-APIGW-API-KEY: {애플리케이션 등록 시 발급받은 client secret값}" -v
```

<br>

스크래핑해서 가져온 맛집 주소를 geocoding API로 요청해서 해당 주소의 위도, 경도값을 알아온다. (지도에 표시하기 위해)

```python
# geocoding API 사용하기
headers = {
    "X-NCP-APIGW-API-KEY-ID": "[내 클라이언트 아이디]",
    "X-NCP-APIGW-API-KEY": "[내 클라이언트 시크릿 키]"
}
# 스크래핑해서 가져온 결과값 중 하나인 address로 geocoding API 요청
    r = requests.get(f"https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query={address}", headers=headers)
    response = r.json()
    # 요청이 성공적이었으면 실행
    if response["status"] == "OK":
        if len(response["addresses"]) > 0:
						# 위도, 경도값 가져오기
            x = float(response["addresses"][0]["x"])
            y = float(response["addresses"][0]["y"])
            print(title, address, category, show, episode, x, y)

            # DB에 저장하기
            doc = {
                "title": title,
                "address": address,
                "category": category,
                "show": show,
                "episode": episode,
                # 위도, 경도값도 같이 저장
                "mapx": x,
                "mapy": y}
            db.matjips.insert_one(doc)

        else:
            print(title, "좌표를 찾지 못했습니다")
```
맛집의 위도, 경도값을 알아낸 후에 DB에 저장한다

<br>

### DB에 저장되어 있는 맛집 리스트를 가져오기
``` javascript
function get_matjips() {
    $('#matjip-box').empty();
    $.ajax({
        type: "GET",
        url: '/matjip',
        data: {},
        success: function (response) {
            let matjips = response["matjip_list"]
            for (let i = 0; i < matjips.length; i++) {
                let matjip = matjips[i]
                console.log(matjip)
                make_card(i, matjip)  // 맛집 정보를 html카드로 만들기
                let marker = make_marker(matjip)  // 맛집 위치를 지도에 마커로 띄우기
                add_info(i, marker, matjip)  // 마커에 정보창 띄우기
            }
        }
    });
}
```
페이지에 접속할 때마다, 맛집 리스트를 가져오도록 구성했다.  
맛집리스트를 가져와 HTML로 만들어 붙이고, 해당하는 맛집 위치를 지도에 마커로 띄우고 정보창까지 띄워보는 것이 할 일

<br>

### 클라이언트에서 DB에 저장된 카드들을 HTML로 표시하기
```jsx
function make_card(i, matjip) {
    let temp_html = `<div class="card" id="card-${i}">
                        <div class="card-body">
                            <h5 class="card-title"><a href="#" class="matjip-title">${matjip.title}</a></h5>
                            <h6 class="card-subtitle mb-2 text-muted">${matjip.category}</h6>
                            <p class="card-text">${matjip.address}</p>
                            <p class="card-text" style="color:blue;">${matjip.show}</p>
                        </div>
                    </div>`
    $('#matjip-box').append(temp_html);
```
DB에 저장되어 있는 맛집 리스트를 불러와 HTML카드로 만들어 보여준다

<br>

### 각 맛집의 위도, 경도값에 마커 띄우기
```jsx
// 맛집 정보를 가지고 마커 만들기
function make_marker(matjip) {
    let marker = new naver.maps.Marker({
        // 맛집의 위도 경도를 넣어줌
        position: new naver.maps.LatLng(matjip["mapy"], matjip["mapx"]),
map:map
});
    markers.push(marker)
    return marker
}
```
해당 맛집의 위도, 경도를 이용해 지도에 마커를 띄운다.

<br>

### 마커를 클릭했을 때, 정보창 띄우고 닫기
```jsx
// 마커를 클릭했을 때, 정보창 띄우기
function add_info(i, marker, matjip) {
    // 띄울 정보창
    let html_temp = `<div class="iw-inner">
                        <h5>${matjip['title']}</h5>
                        <p>${matjip['address']}
                    </div>`;

    let infowindow = new naver.maps.InfoWindow({
        content: html_temp,
        maxWidth: 200,
        backgroundColor: "#fff",
        borderColor: "#888",
        borderWidth: 2,
        anchorSize: new naver.maps.Size(15, 15),
        anchorSkew: true,
        anchorColor: "#fff",
        pixelOffset: new naver.maps.Point(10, -10)
    });
		infowindows.push(infowindow)
		// 마커를 클릭하면 정보창을 띄우고 닫게 하기기
    naver.maps.Event.addListener(marker, "click", function (e) {
        if (infowindow.getMap()) {
            infowindow.close();
        } else {
            infowindow.open(map, marker);
						map.setCenter(infowindow.position)// 정보창을 지도 가운데에 띄우기
						// 선택한 카드위치로 스크롤 하기
            $("#matjip-box").animate({
                scrollTop: $("#matjip-box").get(0).scrollTop + $(`#card-${i}`).position().top
            }, 2000);
				}
		});
}
```

단순히 정보창만 띄우는 게 아니라, 정보창을 지도 가운데에 띄우거나, 마커를 클릭하면 해당 맛집 리스트로 스크롤하는 기능들을 추가할 수 있다.

<br>

### 리스트 제목 클릭하면, 마커와 정보창 띄우기

a태그의 href속성을 변경

```html
<div class="card" id="card-${i}">
    <div class="card-body">
        <h5 class="card-title"><a href="javascript:click2center('${i}')" class="matjip-title">${matjip.title}</a></h5>
        <h6 class="card-subtitle mb-2 text-muted">${matjip.category}</h6>
        <p class="card-text">${matjip.address}</p>
        <p class="card-text" style="color:blue;">${matjip.show}</p>
    </div>
</div>
```

클릭하면 js함수가 실행되도록 변경

리스트의 제목을 클릭하면 click2center(i)함수가 실행

```jsx
function click2center(i) {
    let marker = markers[i]
    let infowindow = infowindows[i]
    if (infowindow.getMap()) {
        infowindow.close();
    } else {
        infowindow.open(map, marker);
map.setCenter(infowindow.position)
    }
}
```
해당하는 맛집의 마커와 정보창을 띄운다