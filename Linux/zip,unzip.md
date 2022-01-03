# Linux zip/unzip 으로 압축하고 해제하기

<br>

## zip
`zip` 은 여러 파일을 묶고 압축할 수 있는 유틸리티로 `tar` 와는 달리 아카이빙과 압축을 같이 할 수 있다. 

<br>

### 하위 디렉터리 압축

하위 디렉터리를 포함하는 압축 옵션인 `-r` 을 사용해서 compress.zip 파일에 /path/dir 내용을 압축한다.

```
zip -r compress.zip /path/dir
```

<br>

### 여러 소스 압축

dir1, dir2, file1 세 개의 소스를 압축한다.

```
zip -r compressed.zip /path/dir1 /path/dir2 /path/file1
```

<br>

### zip에 내용 추가

