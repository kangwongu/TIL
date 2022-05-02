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