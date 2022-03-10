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

## Swagger 기능

1. API Design (API 설계)
Swagger-editor를 통해 api를 문서화하고 빠르게 명세 가능

2. API Development
Swagger-codepen을 통해 작성된 문서를 통해 SDK를 생성하여 빌드 프로세스를 간소화할 수 있도록 도와준다.
3. API Documentation
Swagger-UI를 통해 작성된 API를 시각화시켜준다.

4. API Testing
Swagger-Inspector를 통해 API를 시각화하고 빠른 테스팅을 진행할 수 있다.

5. Standardize
Swagger-hub를 통해 개인, 팀원들이 API 정보를 공유하는 Hub

## 애노테이션 

- @Api
해당클래스가 Swagger 리소스라는 것을 명시한다
`value` : 태그를 작성한다.
`tags` : 사용하여 여러 개의 태그를 정의할 수도 있다.

- @ApiOperation
한 개의 operation(즉 API URL과 Method)을 선언한다
`value` : API에 대한 간략한 설명(제목같은 느낌으로)을 작성한다
`notes` : 더 자세한 설명을 작성해준다.

- @ApiParam
operation의 가능한 reponse를 명시한다.
`code` : 응답모드를 작성한다.
`message` : 응답에 대한 설명을 작성.
`responseHeaders` : 헤더를 추가할 수 있다.

- @ApiParam
파라미터에 대한 정보를 명시한다.
`value` : 파라미터 정보를 작성한다.
`required` : 필수 파라미터이면 true, 아니면 false를 작성한다.
`example` : 테스트를 할 때 보여줄 예시를 작성한다.


## 실습

### Springboot에 Swagger 적용
 
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

Springboot Config 파일
`@EnableSwagger2` 애노테이션 붙이기

**Swagger확인**

`/swagger-ui/index.html`
에서 생성한 컨트롤러 별로 input, output을 확인할 수 있으며 심지어 그 안에서 API 테스트도 할 수 있다는 것을 확인할 수 있다.