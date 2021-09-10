# Git

분산 버전 관리 시스템

- 코드의 버전을 관리하는 도구
- 개발되어온 과정 파악 가능
- 이전 버전과의 변경 사항 비교 및 분석

안녕하세용

중앙 집중 - 은행

분산형 - 블록체인 

## Github

: Git 기반의 저장소 서비스

Git은 명령어를 통해서 사용

CLI : Command-Line Interface

GUI : Graphical User Interface

## 간단한 Unix/Linux 명령어

- 현재 위치의 폴더, 파일 목록보기  ls
- 현재 위치 이동하기 : cd <path> / cd .. (상위 폴더로 이동)
- 폴더 생성하기 : mkdir <name>
- 파일 생성하기 : touch <name>
- 삭제하기 : rm <name> / rm -r <name>

Repository

특정 디렉토리를 버전 관리하는 저장소

## Git 기본기

### Git commit 원리

Working Directory / Staging Area / Repository

커밋(commit)은 위 3 가지 영역을 바탕으로 동작한다.

- Working Directory : 내가 작업하고 있는 실제 디렉토리
- Staging Area : 커밋(commit)으로 남기고 싶은, 특정 버전으로 관리하고 싶은 파일이 있는 곳
- Repository : 커밋(commit)들이 저장되는 곳

working dir 에서 수정되면, git add를 통해 staged 시킬 수 있다.

staged된 파일들은 COMMIT을 통해 repo에 기록할 수 있다.

### git 기본 명령어들 간단 정리

`git init` : 로컬 저장소 생성 / .git 디렉토리에 버전 관리에 필요한 모든 것이 저장된다.

`git status` : 현재 git으로 관리되고 있는 파일들의 상태를 알 수 있는 명령어.

`git add .` : 추적 되지 않은 모든 파일과 추적하고 있는 파일 중 수정된 파일을 모두 Staging Area에 올린다.

`git commit -m "commit_msg"` : 커밋 메세지를 적으며 commit (저장소에 기록)

> - git 사용자 적기
>
> `git config --global user.name "user_name"`
>
> `git config --global user.email "user_email"`

git 에서 origin : (remote repository) 원격 저장소 이름

`git log` : git commit log 확인

`git clone {remote_repo} ` :  remote repository를 local로 복사한다.



- Github Pages

Github에서 제공하는 무료 웹 호스팅 서비스

Github repo와 직접적으로 연동되어 있어서, push하면 바로 반영된다.

(push 후 적용에 시간은 좀 걸릴 수 있다.)