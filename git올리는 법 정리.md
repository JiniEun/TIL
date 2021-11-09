# ☆ Git 올리는 법 ☆

❗️ *항상 Git 올리기 전에, 코드 수정하기 전에는* `git pull`

→ 브랜치 혼자 파서 쓰고 있으면 상관 없음

1. `git branch` 확인 → 현재 브랜치에 작업 할거면 그냥 진행

## 올릴 때

1. `git status` 로 상태 확인

   > 빨간색 줄로 나오면 수정된 파일들 -> add, commit, push해야될..( 초록색 줄이면 push할 준비 됨 <- 3번 하면 이렇게 됨 )그냥 nothing to commit이면 수정된 거 X

2. `git add .` 수정한 모든 파일 커밋에 추가될 Staged 상태 (.은 모든 파일)

3. `git commit -m "커밋 메세지"`

   ex) `git commit -m "add test.xml"`

   > feat : 새로운 기능에 대한 커밋fix : 버그 수정에 대한 커밋build : 빌드 관련 파일 수정에 대한 커밋chore : 그 외 자잘한 수정에 대한 커밋ci : CI관련 설정 수정에 대한 커밋docs : 문서 수정에 대한 커밋style : 코드 스타일 혹은 포맷 등에 관한 커밋refactor :  코드 리팩토링에 대한 커밋test : 테스트 코드 수정에 대한 커밋

4. `git push origin <branchname>`

   > ex. (`git push origin feature/user`)