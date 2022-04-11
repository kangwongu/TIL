# 크롤링
# 코드단에서 요청하기, 요청으로 가져온 html에서 내가 원하는 정보를 가져오는 것
# requests로 요청하고 beautifulsoup으로 솎아냄


import requests
from bs4 import BeautifulSoup

headers = {'User-Agent' : 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36'}
data = requests.get('https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20200303',headers=headers)

soup = BeautifulSoup(data.text, 'html.parser')

# 코딩 시작


# select_one, select

trs = soup.select('#old_content > table > tbody > tr')
for tr in trs:
    a_tag = tr.select_one('td.title > div > a')

    if a_tag is not None:
        star = tr.select_one('td.point').text
        title = a_tag.text
        rank = tr.select_one('td:nth-child(1) > img')['alt']
        print(rank, title, star)



#old_content > table > tbody > tr:nth-child(2)
#old_content > table > tbody > tr:nth-child(2) > td:nth-child(1) > img
#old_content > table > tbody > tr:nth-child(3) > td:nth-child(1) > img
# #old_content > table > tbody > tr:nth-child(2) > td.title > div > a
#old_content > table > tbody > tr:nth-child(2) > td.point
#old_content > table > tbody > tr:nth-child(3) > td.point