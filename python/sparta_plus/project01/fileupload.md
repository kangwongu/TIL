# 파일 업로드 기능 사용하기

우선 클라이언트에서 파일을 서버로 보내려면 FormData로 전송을 해야한다.

<br>

## 클라이언트

파일 가져오기
``` javascript
let file = $('#file')[0].files[0] 
```

<br>

파일을 가져온 후에 FormData로 만드는 작업이 필요하다
``` javascript
let form_data = new FormData()

// FormData에 파일담기
form_data.append("file_give", file)
/// 추가로 보낼 데이터들이 있으면 FormData로 담은 후에 보낸다.
... 
```

<br>

Ajax로 서버에 요청할 때에는 3가지 속성을 기본으로 false로 설정해준다.
``` javascript
data: form_data,
// 파일 보낼때 기본 설정
cache: false,
contentType: false,
processData: false
```

Ajax 요청으로 인해 서버로 파일이 전달!

<br><br>

## 서버

클라이언트에서 보낸 파일을 아래와 같이 받는다.
``` python
file = request.files["file_give"]

```
<br>

받은 파일의 이름과 경로를 설정해 저장한다.

``` python
filename = f'file-{mytime}'  # 파일 이름
save_to = f'static/{filename}.{extension}'  # 파일을 저장할 위치
file.save(save_to) # save_to 경로와 이름으로 파일 저장
```
나는 static폴더안에 저장했다.

이렇게 하면 static 폴더에 파일이 저장된다.

<br>

DB에 파일 이름을 저장해 같은 정보들을 묶어줬다.
``` python
doc = {
        'title': title_receive,
        'content': content_receive,
        'file':f'{filename}.{extension}',
        'time':post_time
    }

    db.diary.insert_one(doc)
```
<br>

해당 파일의 제목과 본문을 가져와야할 때 필요하기 때문이다
![sample](https://user-images.githubusercontent.com/59812251/165753206-d09d07e5-1486-47d6-808c-1f5860c416d1.png)