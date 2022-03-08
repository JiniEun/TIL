# Swagger

Rest API를 눈으로 보기 쉽게 그려주는 역할

## Swagger란

- Open Api Specification(OAS)를 위한 프레임워크이다.
- API들이 가지고 있는 스펙(spec)을 명세, 관리할 수 있는 프로젝트/문서
- API 사용 방법을 사용자에게 알려주는 문서
- Springboot에서 Swagger를 사용하면, 컨트롤러에 명시된 어노테이션을 해석하여 API문서를 자동으로 만들어준다.
- 참고로 Swagger는 Java에 종속된 라이브러리가 아니다.
- URL에 /swagger-ui.heml으로 접근하면 swagger가 만들어주는 페이지에 접근할 수 있다.

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


`/swagger-ui/index.html`
에서 생성한 컨트롤러 별로 input, output을 확인할 수 있으며 심지어 그 안에서 API 테스트도 할 수 있다는 것을 확인할 수 있다.