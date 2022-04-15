# [NGINX] NGINX란? NGINX 설치

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7ae9848f-bbda-4700-837e-902362a7bbed/Untitled.png)

# Nginx란?

> NginX란? 
웹 서버 소프트웨어로, 가벼움과 높은 성능을 목표로 한다.
웹 서버, 리버스 프록시 및 메일 프록시 기능을 가진다. Nginx는 요청에 응답하기 위해 비동기 이벤트 기반 구조를 가지며, 이는 아파치 HTTP 서버의 스레드/프로세스 기반 구조를 가지는 것과는 대조적이다. 
이러한 구조는 서버에 많은 부하가 생길 경우의 성능을 예측하기 쉽게 해준다.
출처: [[위키백과]](https://ko.wikipedia.org/wiki/Nginx)
> 

간단하게 말하면 경량 웹 서버이며, 클라이언트로부터 요청을 받았을 때 요청에 맞는 정적 파일을 응답해주는 HTTP Web Server로 활용되기도 하고, Reverse Proxy Server로 활용하여 WAS 서버의 부하를 줄일 수 있는 로드 밸런서로 활용되기도 한다.

# NGINX 설치하기

개발 환경: Mac 

아래 방법으로 NGINX를 설치하기 전 brew 패키지 관리자가 설치되어 있어야 한다.

- Homebrew 버전 확인

```java
brew -v
```

- nginx 설치하기

```java
brew install nginx
```

→ brew를 이용해 NginX를 설치한다.

# nginx.conf 파일 경로 확인하기

```java
brew info nginx
```

→ `brew info ${package명}`: 해당 패키지가 어느 위치에 설치되어 있는 지 확인 가능하다.

설치되어 있는 경우 아래와 같이 정보를 확인할 수 있다.

```java
nginx: stable 1.21.6, HEAD
HTTP(S) server and reverse proxy, and IMAP/POP3 proxy server
https://nginx.org/
/opt/homebrew/Cellar/nginx/1.21.6_1 (26 files, 2.2MB) *
  Poured from bottle on 2022-04-13 at 14:30:40
From: https://github.com/Homebrew/homebrew-core/blob/HEAD/Formula/nginx.rb
License: BSD-2-Clause
==> Dependencies
Required: openssl@1.1 ✔, pcre2 ✔
==> Options
--HEAD
        Install HEAD version
==> Caveats
Docroot is: /opt/homebrew/var/www

The default port has been set in /opt/homebrew/etc/nginx/nginx.conf to 8080 so that
nginx can run without sudo.

nginx will load all files in /opt/homebrew/etc/nginx/servers/.

To restart nginx after an upgrade:
  brew services restart nginx
Or, if you don't want/need a background service you can just run:
  /opt/homebrew/opt/nginx/bin/nginx -g daemon off;
==> Analytics
install: 39,803 (30 days), 123,899 (90 days), 485,441 (365 days)
install-on-request: 39,713 (30 days), 123,684 (90 days), 484,435 (365 days)
build-error: 24 (30 days)
```

맥 버전이나 상황에 따라 설치 위치가 다를 수 있으니, 스스로 확인해보는 것이 제일 정확하다.

본인의 경우에는

```java
/opt/homebrew/etc/nginx/nginx.conf
```

에 conf 파일이 위치해 있다.

# nginx.conf 파일 수정

아래 코드를 통해 nginx.conf 파일을 수정할 수 있다. (password를 요구하는 경우 컴퓨터 비밀번호를 입력하면 된다.)

```java
sudo vim /opt/homebrew/etc/nginx/nginx.conf
```

nginx.conf 파일을 확인 하면 server 부분이 설정되어 있다.

```java
server {
        listen       8080;
        server_name  localhost;

        #charset koi8-r;

        #access_log  logs/host.access.log  main;

        location / {
            root   html;
            index  index.html index.htm;
        }

        #error_page  404              /404.html;
```

- 기본 포트를 변경하고 싶다면

```java
listen 80; 
```

위와 같이 원하는 포트로 수정이 가능하다.

- root html은 웹 루트 디렉토리의 심볼릭 링크이며 개인용으로 사용한다면 루트 디렉터리 설정을 변경하는 것보다 심볼릭 링크를 그대로 가져와서 사용하려면 아래와 같이 이용한다.

```java
# 접근하기 쉽고, 원하는 디렉토리에서 심볼릭 링크를 생성.
ln -s /opt/homebrew/var/www [링크 이름]
```

# Homebrew로 백그라운드 서비스 관리

```java
brew services # 자동으로 homebrew/services를 tap, 현재 설치된 서비스 목록 확인
brew services [run|start|stop|restart|cleanup] service_name # 명령어
# run - 시작하되, 시작프로그램으로 등록하지 않음
# start - 시작하고 시작프로그램으로 등록

brew services start nginx # nginx 시작
```

homebrew services를 이용하면 쉽게 백그라운드 서비스를 관리할 수 있다.

conf 파일 수정을 완료한다면 아래 명령어로 nginx를 재시작 할 수 있다.

```java
brew service restart nginx
```

# NGINX 명령어

```java
# 시작
nginx

# 중지
nginx -s stop

# 재시작
nginx -s reload
```

# Reference

[https://ko.wikipedia.org/wiki/Nginx](https://ko.wikipedia.org/wiki/Nginx)

[https://icarus8050.tistory.com/57](https://icarus8050.tistory.com/57)

[https://jehwanyoo.net/2021/04/06/mac-NGINX-Tutorial-1-NGINX-설치/](https://jehwanyoo.net/2021/04/06/mac-NGINX-Tutorial-1-NGINX-%EC%84%A4%EC%B9%98/)