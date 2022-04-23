# Ajax
자바스크립트로 서버에 데이터(JSON)만 요청해 주고 받을 수 있는 방법<br><br>

## Ajax 형식
``` javascript
$.ajax({
  type: "HTTP METHOD",  // GET / POST등
  url: "URL주소",       // URL
  data: {},             // POST시에만 data를 넣어서 서버에 요청
  success: function(response){
    // 요청 성공 시, response에 서버에서 응답한 값이 들어감
    ...
  }
})
```
<br>

## 어떤 식으로 수행이 이루어지는지

1. Ajax를 통해 서버로부터 데이터를 (요청)받아온다.
2. 받은 데이터를 가공하기 (for문을 통해 데이터를 가공, jquery를 통해 html의 내용 교체 등등)
3. 가공한 데이터 활용하기 (jquery를 통해 html의 내용 교체, 특정 위치에 붙여넣기 등등)
