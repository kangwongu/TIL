# 팀 협업을 위한 Git/Github

**내일배움캠프 클라우드 트랙**에서 진행한 미니 프로젝트 기간에 사용한 Git/Github 시나리오를 정리<br/><br/>

팀 프로젝트를 위해 gitHub에서 Organizations 개설

'People'탭에서 팀원을 추가 (역할 부여 가능)

Repository 생성 후, 'Issue'를 할당함

'Issue'탭에서 'Label'과 'Milestones'를 설정

팀원들에게 Issue를 할당하며 할 일을 분배<br/><br/>

구현에 앞서, 전체적인 작업은 git-flow를 통해 진행

>[git flow](https://inpa.tistory.com/entry/GIT-%E2%9A%A1%EF%B8%8F-github-flow-git-flow-%F0%9F%93%88-%EB%B8%8C%EB%9E%9C%EC%B9%98-%EC%A0%84%EB%9E%B5)를 참고하자<br/>

Clone을 통해 로컬 Repo에 원격 Repo내용을 받아온다  

Branch를 나눠가며 작업 시작

각자 작업이 끝날 때마다 Commit하고 Push한다  
>Commit 메시지는 [커밋 메시지형식](https://github.com/Breeding-Me/StepWithDog/wiki/%EC%BB%A4%EB%B0%8B-%EB%A9%94%EC%8B%9C%EC%A7%80-%ED%98%95%EC%8B%9D)을 참고해서 작성했음

Pull requests하고 Merge한다  
Merge후, 작업이 끝난 Branch는 삭제 (깔끔함위해)

팀원이 수행한 작업을 받아올 때는 pull한다 (작업한 Branch)
