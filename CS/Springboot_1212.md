# [Springboot] 민감정보 숨기기 (Argument 입력)

application.properties 또는 application.yml 파일을 작성하다 보면 `datasource.username`, `datasource.password`와 같이 형상관리 페이지에는 숨기고 싶은 정보들이 존재한다.
따라서 사용자 입력을 통해 argument로 정보를 전달하고 파일에는 포함시키지 않는 방법을 알아보았다.

**사용자 입력을 통해 application.yml에 Argument 전달하는 방법 정리**

- 간단하게,아래 코드 처럼 **-변수명=value** 형태로 값을 전달한다.

```java
java -jar {jar 경로} --datasource.username=홍길동 --datasource.password=비밀번호 --datasource.url=링크
```

.yml 사용 시

```java
spring:
  datasource:
    url: ${datasource.url}
    username: ${datasource.username}
    password: ${datasource.password}
```

.properties 사용 시

```java
spring.datasource.url: ${datasource.url} 
spring.datasource.username: ${datasource.username} 
spring.datasource.password: ${datasource.password}
```

여기서 `${  }` 를 통해 argument 이름을 정할 수 있으며 상황에 맞게 원하는 이름으로 변경한다.

예시에서는 datasource의 username임을 명시하기 위해 datasource.username을 사용했지만 입력 시 너무 귀찮으면, username 또는 USERNAME 처럼 대문자로 명시해도 된다.

이곳에 명시된 argument는 command에서 입력될 때 같은 이름이어야 한다.

## 예시

민감정보인 username을 전달한다고 가정하면 아래와 같다.

```
spring:
  datasource:
    username: ${DATASOURCE_USERNAME}
```

위와 같이 네이밍을 했다면 커맨드에선 아래와 같이 전달하면 된다.

```
java -jar {jar 경로} --DATASOURCE_USERNAME=홍길동
```


- 출처

```java
https://imksh.com/95
```
