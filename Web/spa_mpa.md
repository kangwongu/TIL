## SPA, MPA

### SPA (Single Page Application)
- CSR에 속함(초기 페이지 로딩 속도 느림, 완전 1:1이라고 할 수 없음.)
- 페이지를 한 개로 서비스함.
- 유저에 요청에 따라 페이지 내부를 바꿔줌.
- 직접 구현하려면 엄청난 Hide와 동적 로딩 필요(여러분이 했던 ajax해서 html 다 지우고 다시 붙이는 일 같은 것들…이 힘들어서 나온게 아래 프레임워크들)
- React,Vue,Angular,Svelte 등등 프레임워크가 꾸준히 발전 중
- 검색 엔진 최적화 SEO(Search Engine Optimization)가 안됨 → Next.js/Nuxt.js/Gatsy.js (CSR,SSG,SSR) 등 많은 방안이 나옴
- Client 성능이 좋아져서 나온것

<br>

### MPA (Multi Page Application)
- SSR에 속함(완전 1:1 이라고 할 수 없음. MPA도 CSR로 할 수 있음 → Hybrid 했던것처럼)
- 여러 개(multi)의 Page로 구성된 application
- Flask에서 render_template 처럼 서버에서 html을 만들어줌.
- 페이지가 바뀔때 마다 서버에 요청해서 페이지 깜빡임과 속도가 SPA비해 느림.
- 서버 부담이 좀 더 큼

<br>

## 참고
https://hanamon.kr/spa-mpa-ssr-csr-%EC%9E%A5%EB%8B%A8%EC%A0%90-%EB%9C%BB%EC%A0%95%EB%A6%AC/

https://velog.io/@thms200/SPA-vs.-MPA