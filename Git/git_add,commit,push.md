# [Git] git add, git commit, git push 취소하기

<br>

## git add 취소하기 (파일 상태를 Unstage로 변경하기)

`git add *` 명령을 사용하여 모든 파일을 Staging Area에 넣었는데 <br>
Staging Area(git add 명령 수행한 후의 상태)에 넣은 파일을 취소하고 싶은 경우가 있을 수 있다.

<br>

```
// 모든 파일이 Staged 상태로 바뀐다.
$ git add *
// 파일들의 상태 확인
$ git status
On branch master
Changes to be committed:
(use "git reset HEAD <file>..." to unstage)
  modified:    README.md 
```

<br>

이때, `git reset HEAD [file]` 명령어를 통해 `git add`를 취소할 수 있다.

<br>

파일명을 적으면 해당 파일을 Unstaged 상태로 변경한다.

```
$ git reset HEAD README.md
```

*뒤에 파일명이 없으면 add한 파일 전체를 취소한다.* <br>

<br>

## git commit 취소하기 

생각한 것보다 너무 일찍 commit한 경우, <br>
어떤 파일을 빼먹고 commit한 경우 이미 완료한 commit을 취소하려고 한다면 <br>

이때, git reset HEAD^ 명령어를 통해 git commit을 취소할 수 있다.

<br>


먼저, commit 목록을 확인한다.

```
$ git log
```

<br>

### 방법 1. commit을 취소하고 해당 파일들은 staged 상태로 워킹 디렉터리에 보존

```
$ git reset --soft HEAD^
```

<br>

### 방법 2. commit을 취소하고 해당 파일들은 unstaged 상태로 워킹 디렉터리에 보존

```
$ git reset --mixed HEAD^ // 기본 옵션
$ git reset HEAD^ // 위와 동일
$ git reset HEAD~2 // 마지막 2개의 commit을 취소
```

<br>

### 방법 3. commit을 취소하고 해당 파일들은 unstaged 상태로 워킹 디렉터리에서 삭제하는 방법

```
$ git reset --hard HEAD^
```

<br>

### commit message 변경하기

git commit –amend 명령어를 통해 git commit message를 변경할 수 있다.

```
git commit --amend
```

<br>

## *`git reset`명령어 옵션*

reset 옵션
- `-soft` : index 보존(add한 상태, staged 상태), 워킹 디렉터리의 파일 보존. 즉 모두 보존.
- `-mixed` : index 취소(add하기 전 상태, unstaged 상태), 워킹 디렉터리의 파일 보존 (기본 옵션)
- `-hard` : index 취소(add하기 전 상태, unstaged 상태), 워킹 디렉터리의 파일 삭제. 즉 모두 취소. -> hard 옵션은 주의해서 사용하는 것이 좋다.

ex. 아래와 같이 hard 옵션을 이용할 경우 워킹 디렉터리를 원격 저장소의 마지막 commit 상태로 되돌린다.
```
git reset --hard HEAD
```

<br>

## git push 취소하기

commit을 원하는 시점으로 되돌려 다시 push해서, 원하지 않았던 부분을 없애면서 강제로 덮어쓰기를 하는 방법이다.

자신의 local의 내용을 remote에 강제로 덮어쓰기를 하는 것이기 때문에 주의해야 하고, 되돌아간 commit 이후의 모든 commit 정보가 사라지기 때문에 주의해야 한다. <br><br>
특히, 협업 프로젝트에서는 동기화 문제가 발생할 수 있으므로 특별히 주의해야 한다.

1. 가장 최근의 commit을 취소하고 워킹 디렉토리에서 commit을 되돌린다.

```
// 가장 최근의 commit을 취소 (기본 옵션: --mixed)
$ git reset HEAD^

// Reflog(브랜치와 HEAD가 지난 몇 달 동안에 가리켰었던 커밋) 목록 확인
$ git reflog 또는 $ git log -g

// 원하는 시점으로 워킹 디렉터리를 되돌린다.
$ git reset HEAD@{number} 또는 $ git reset [commit id]
```

<br>

2. 되돌려진 상태에서 다시 새롭게 commit을 한다.

```
git commit -m "Write new Commit messages"
```

<br>

3. 원격 저장소에 강제로 push 한다.

`-f` 옵션(=`-force`)이나 `+`를 이용한다.

`git push origin +[branch name]` <br>
or <br>
`git push origin [branch name] -f`


ex) main 브랜치를 원격 저장소에 강제로 push 하기
```
$ git push origin +main
```

<br>

## untracked 파일 삭제하기

git clean 명령을 이용해 .gitignore 에 명시하여 무시되는 파일을 제외하고 추적중이지 않은 파일만 지운다.

```
// 디렉터리를 제외한 파일들만 삭제
$ git clean -f 

// -d : 디렉터리까지 삭제
$ git clean -f -d 

// -x : 무시된 파일까지 삭제
$ git clean -f -d -x 

// -n : 가상으로 실행해보고 어떤 파일들이 지워질지 알려주는 것
```

<br>

## References

- https://git-scm.com/book/ko/v2/Git%EC%9D%98-%EA%B8%B0%EC%B4%88-%EB%90%98%EB%8F%8C%EB%A6%AC%EA%B8%B0
- https://git-scm.com/book/ko/v2/Git-%EB%8F%84%EA%B5%AC-Reset-%EB%AA%85%ED%99%95%ED%9E%88-%EC%95%8C%EA%B3%A0-%EA%B0%80%EA%B8%B0#r_git_reset
