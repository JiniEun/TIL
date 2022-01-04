# [Git] git add, git commit, git push 취소하기

## git add 취소하기 (파일 상태를 Unstage로 변경하기)

실수로 git add * 명령을 사용하여 모든 파일을 Staging Area에 넣은 경우,
Staging Area(git add 명령 수행한 후의 상태)에 넣은 파일을 빼고 싶을 때(취소하고 싶을 때)가 있다.

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

이때, git reset HEAD [file] 명령어를 통해 git add를 취소할 수 있다.
