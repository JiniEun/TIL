# Swagger

Rest API를 눈으로 보기 쉽게 그려주는 역할

## Swagger란
Web API 문서화를 위한 도구이다. 
일반적으로 프로그램을 개발할 때, 백엔드 개발자와 프론트엔드 개발자가 서로 협력하는 형태로 개발을 진행하게 된다.
이 때, 클라이언트 - 서버 사이에서 어떠한 방식으로 데이터를 주고 받을지에 대한 명세, 즉, API 명세서가 필요할 수 있다. 

Springboot에 Swagger 적용
 
Maven pom.xml에 Dependency 추가

```
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>3.0.0</version>
</dependency>
<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger-ui</artifactId>
   <version>3.0.0</version>
</dependency>
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-boot-starter</artifactId>
	<version>3.0.0</version>
</dependency>
```
