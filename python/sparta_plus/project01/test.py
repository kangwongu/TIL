# f-string
name = "사카"
age = '20'

hello = f'제 이름은 {name}입니다. 나이는 {age}입니다'
print(hello)

# datetime
from datetime import datetime

today = datetime.now()
mytime = today.strftime('%Y-%m-%d-%H-%M-%S')

filename = f'file-{mytime}'

print(filename)