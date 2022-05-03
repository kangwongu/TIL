# Bulma 프레임워크
부트스트랩과 비슷한 CSS 프레임워크이다.

<br>

## 왜 쓸까?
부트스트랩과 다르게 순수 CSS로 구성되어 있다.   

기능을 직접 구현해야하지만 비교적 자유롭게 커스터마이징이 쉽다.  

문법이 직관적이라 사용하기 쉽다.

<br>

## Bulma 사용해보기

``` html
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">
```
head태그 안에 추가해줘야 한다

<br>

## 사용 예시
Hero 배너
```html
<body>
    <section class="hero is-primary is-bold is-medium">
        <div class="hero-body">
            <div class="container">
                <h1 class="title">
                    Hero title 화이팅
                </h1>
                <h2 class="subtitle">
                    Hero subtitle
                </h2>
            </div>
        </div>
    </section>
</body>
```
화면 전체 너비를 채우는 배너 클래스

<br>

Section
```html
<section class="section">
    <div class="container">
        <h1 class="title">Section</h1>
        <h2 class="subtitle">
            A simple container to divide your page into <strong>sections</strong>, like the one you're
            currently reading
        </h2>
    </div>
</section>
```
body 태그 안에서 사용되고, 구역을 나눌 때 사용한다.

```css
.section {
    width: 600px;
    max-width: 100vw;
    margin: auto;
}
```
section클래스의 css를 cnrk(커스터마이징)

<br>

Box와 Media
``` html
<div class="box">
    <article class="media">
        <div class="media-left">
            <figure class="image is-64x64">
                <img src="https://bulma.io/images/placeholders/128x128.png" alt="Image">
            </figure>
        </div>
        <div class="media-content">
            <div class="content">
                <p>
                    <strong>John Smith</strong> <small>@johnsmith</small> <small>31m</small>
                    <br>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean efficitur sit
                    amet massa fringilla egestas. Nullam condimentum luctus turpis.
                </p>
            </div>
            <nav class="level is-mobile">
                <div class="level-left">
                    <a class="level-item" aria-label="reply">
                            <span class="icon is-small">
                              <i class="fas fa-reply" aria-hidden="true"></i>
                            </span>
                    </a>
                    <a class="level-item" aria-label="retweet">
                            <span class="icon is-small">
                              <i class="fas fa-retweet" aria-hidden="true"></i>
                            </span>
                    </a>
                    <a class="level-item" aria-label="like">
                            <span class="icon is-small">
                              <i class="fas fa-heart" aria-hidden="true"></i>
                            </span>
                    </a>
                </div>
            </nav>
        </div>
    </article>
</div>
```
box는 테두리와 그림자 등을 이용해 만든 카드

media는 이미지와 글의 조합

<br>

Button
``` html
<button class="button is-primary is-outlined is-large is-fullwidth is-loading"></button>
```

<br>

예시에서 볼 수 있듯이 Bulma는 직관적으로 태그명과 같은 클래스를 쓰고, 각 기능을 모듈화해 적용하고 싶은 CSS를 추가하는 방식이다.

is-primary, is-large등등

<br>

### 특정 요소를 보여주기/감추기
Bulma에서는 클래스를 이용해서 요소를 숨길 수 있다.

``` html
is-hidden
```
이 클래스를 숨겨야하는 요소들에 붙이면 숨겨진다.

<br>

내가 이전에 사용했던 제이쿼리 방식
```jsx
function toggle_sign_up() {
    if ($("#sign-up-box").hasClass("is-hidden")) {
        $("#sign-up-box").removeClass("is-hidden")
    } else {
        $("#sign-up-box").addClass("is-hidden")
    }
}
```
특정 요소의 클래스 존재여부에 따라 보여주고, 감추는 코드

이렇게 구현할 수도 있지만, 제어해야 할 요소가 많아지면 코드가 길어진다

<br>

```jsx
function toggle_sign_up() {
    $("#sign-up-box").toggleClass("is-hidden")
    $("#div-sign-in-or-up").toggleClass("is-hidden")
    $("#btn-check-dup").toggleClass("is-hidden")
    $("#help-id").toggleClass("is-hidden")
    $("#help-password").toggleClass("is-hidden")
    $("#help-password2").toggleClass("is-hidden")
}
```

그래서 .toggleClass()를 이용한다.

is-hidden을 가지고 있으면 없애고, 없으면 생성하라는 내용의 함수