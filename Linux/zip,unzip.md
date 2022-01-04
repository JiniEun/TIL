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
zip -r compress.zip /path/dir1 /path/dir2 /path/file1
```

<br>

### zip에 내용 추가

이미 존재하는 zip 파일에 새로운 파일 추가한다.

```
zip compress.zip path/file
```

<br>

### 특정 폴더 제외하기

`-x` 옵션을 사용한다.
아래는 `.git` 폴더는 빼고 압축하는 예제이다. (`.git` 앞뒤 (*) 주의)

```
zip -9 -r compress.zip /path/dir -x '*.git*'
```

<br>

## unzip

`unzip`은 `zip`으로 압축된 파일을 푸는 명령어이다.

<br>

### 압축 파일 목록 보기

압축을 해제하지 않고 압축 파일 내의 목록만 출력하는 방법이다.

```
unzip -l compress.zip 
```

<br>

### 압축 해제

현재 폴더에 압축 해제하는 방법이다.

```
unzip compress.zip 
```

<br>

### 특정 폴더에 해제

압축이 풀릴 대상을 지정하는 -d 옵션을 사용하면 원하는 폴더에 압축을 해제할 수 있다.

```
unzip compress.zip  -d /path/to/put
```

<br>

### 여러 파일 압축 해제

여러 압축 파일을 해제할 경우 bash 의 for 함수를 이용해서 간단하게 처리할 수 있다.

```
for i in *.zip; do unzip $i -d /path/to/put;done
```

<br>

unzip 은 `file globing` 을 제대로 지원하지 않아서 다음과 같이는 사용할 수가 없다.

```
unzip *.zip  -d /path/to/put
```

<br>

## 주요 옵션

### zip

- -r : 디렉토리까지 압축
- -1 : 빠른 압축(압축률 ⬇)
- -9 : 높은 압축률 (속도 ⬇)
- -e : zip 파일에 암호 설정
- -x : 압축시 파일 제외

### unzip

- -d : 지정한 디렉토리에 압축 해제
- -l : 압축 파일내 목록 보기