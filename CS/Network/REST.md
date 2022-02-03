# [Network] REST, REST API, RESTful이란?

- [REST의 개념](#rest의-개념)
- [REST의 장단점](#rest의-장단점)
- [REST 구성 요소](#rest-구성-요소)
- [REST의 특징](#rest-특징)
- [REST API](#rest-api)
- [REST API의 정의](#rest-api의-정의)
- [REST API 설계 기본 규칙](#rest-api-설계-기본-규칙)
- [RESTful](#restful)

<hr/>

<br>

## REST의 개념

<br>

### REST의 정의

REST = Representational State Transfer

자원을 이름(자원의 표현)으로 구분하여 해당 자원의 상태(정보)를 주고 받는 모든 것. <br>

즉, 자원(resource)의 표현(representation) 에 의한 상태 전달

<br>

**자원** <br>

해당 소프트웨어가 관리하는 모든 것을 의미. <br>
ex) DB 안에 들어가 있는 데이터 하나하나, 이미지 하나하나 등

**상태 전달** <br>

데이터가 요청되는 시점에서 요청받은 자원의 상태(정보)를 전달 보통 JSON 형태나 XML 형태를 이용하여 자원의 상태를 전달.

<br>

- 월드 와이드 웹과 같은 분산 하이퍼미디어 시스템을 위한 소프트웨어 아키텍처의 한 형식이다.

- 기본적으로 웹의 기존 기술과 HTTP 프로토콜을 그대로 활용하기 때문에 웹의 장점을 최대한 활용할 수 있는 아키텍처 스타일이다.

- 네트워크 상에서 Client와 Server 사이의 통신 방식 중 하나이다.

<br>

### REST의 구체적인 정의

HTTP URI(Uniform Resource Identifier)를 통해 자원(Resource)을 명시하고, HTTP Method(POST, GET, PUT, DELETE)를 통해
해당 자원에 대한 CRUD Operation을 적용하는 것이다. <br>

즉, 자원 기반의 구조(ROA, Resource Oriented Architecture) 설계의 중심에 Resource가 있고 HTTP Method를 통해 Resource를 처리하도록 설계된 아키텍처이다. <br>

웹 사이트의 이미지, 텍스트, DB 내용 등의 모든 자원에 고유한 ID인 HTTP URI를 부여한다. <br>

<br><br>

## REST의 장단점

<br>

### REST의 장점

- HTTP 프로토콜의 인프라를 그대로 사용 하므로 REST API 사용을 위한 별도의 인프라를 구출할 필요가 없다. 

- HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용이 가능하다.

- Hypermedia API의 기본을 충실히 지키면서 범용성을 보장한다.

- REST API 메시지가 의도하는 바를 명확하게 나타내므로 의도하는 바를 쉽게 파악할 수 있다. 

- 여러 가지 서비스 디자인에서 생길 수 있는 문제를 최소화한다.

- 서버와 클라이언트의 역할을 명확하게 분리한다.

<br>

### REST의 단점

- 표준이 존재하지 않는다.

- 사용할 수 있는 메소드가 4가지 밖에 없다. (HTTP Method 형태가 제한적이다.)

- 브라우저를 통해 테스트할 일이 많은 서비스라면 쉽게 고칠 수 있는 URL보다 Header 값이 왠지 더 어렵게 느껴진다.

- 구형 브라우저가 제대로 지원하지 못하는 부분이 존재한다. (PUT, DELETE를 사용하지 못하는 점, pushState를 지원하지 않는 점)

<br><br>

## REST가 필요한 이유

- 애플리케이션 분리 및 통합

- 다양한 클라이언트의 등장

- 최근 서버 프로그램은 다양한 브라우저, 모바일 디바이스에서도 통신이 가능해야 한다.

- 멀티 플랫폼에 대한 지원을 위해 서비스 자우너에 대한 아키텍처를 세우고 이용하는 방법과의 연관성

<br><br>

## REST 구성 요소

### 1. 자원(Resource) : URI

- 모든 자원에 고유한 ID가 존재하고, 이 자원은 Server에 존재한다.

- 자원을 구별하는 ID는 '/groups/:group_id'와 같은 HTTP URI이다.

- Client는 URI를 이용해서 자원을 지정하고 해당 자원의 상태(정보)에 대한 조작을 Server에 요청한다.

### 2. 행위(Verb) : HTTP Method

- HTTP 프로토콜의 Method를 사용한다.

- HTTP 프로토콜을 GET, POST, PUT, DELETE와 같은 Method를 제공한다.

### 3. 표현(Representation of Resource)

- Client가 자원의 상태(정보)에 대한 조작을 요청하면 Server는 이에 적절한 응답(Representation)을 보낸다.

- REST에서 하나의 자원은 JSON, XML, TEXT, RSS 등 여러 형태의 Representation으로 나타낼 수 있다.

- JSON 혹은 XML를 통해 데이터를 주고 받는 것이 일반적이다.

<br><br>

## REST 특징

<br>

### 1. Server-Client(서버-클라이언트 구조)

- REST Server : (자원이 있는 쪽) API를 제공하고 비즈니스 로직 처리 및 저장을 책임진다.

- Client : (자원 요청) 사용자 인증이나 context(세션, 로그인 정보) 등을 직접 관리하고 책임진다.

<br>

서로 간 의존성이 줄어든다.

<br>

### 2. Stateless(무상태)

- HTTP 프로토콜은 Stateless Protocol이므로 REST 역시 Stateless 이다. 

- Client의 context를 Server에 저장하지 않는다.
    - 즉, 세션과 쿠키와 같은 context 정보를 신경쓰지 않아도 되므로 구현이 단순해진다.

- Server는 각각의 요청을 완전히 별개의 것으로 인식하고 처리한다.
    - 각 API 서버는 Client의 요청만을 단순 처리한다.
    - 즉, 이전 요청이 DB를 수정하여 DB에 의해 바뀌는 것은 허용한다.
    - Server 처리 방식에 일관성을 부여하며 부담이 줄어, 서비스의 자유도가 높아진다.

<br>

### 3. Cacheable(캐시 처리 가능)

- 웹 표준 HTTP 프로토콜을 그대로 사용하므로 웹에서 사용하는 기존 인프라 그대로 활용 가능하다.
    - 즉, HTTP가 가진 가장 강력한 특징 중 하나인 캐싱 기능을 적용할 수 있다.
    - HTTP 프로토콜 표준에서 사용하는 Last-Modified 태그나 E-Tag를 이용하면 캐싱 구현이 가능하다.

- 대량 요청을 효율적으로 처리하기 위해 캐시가 요구된다.

- 캐시 사용을 통해 응답시간이 빨라지며, REST Server 트랜잭션이 발생하지 않기 때문에 전체 응답시간, 성능, 서버의 자원 이용률을 향상시킬 수 있다.

<br>

### 4. Layered System(계층화)

- Client는 REST API Server만 호출한다.

- REST Server는 다중 계층으로 구성될 수 있다.
    - API Server는 순수 비즈니스 로직을 수행하고 그 앞단에 보안, 로드밸런싱, 암호화, 사용자 인증 등을 추가하여 구조상의 유연성을 줄 수 있다.
    - 로드밸런싱, 공유 캐시 등을 통해 확장성과 보안성을 향상시킬 수 있다.

- PROXY, 게이트웨이 같은 네트워크 기반의 중간 매체를 사용할 수 있다.

<br>

### 5. Code-On-Demand(optional)

- Server로부터 스크립트를 받아서 Client에서 실행한다.

- 반드시 충족할 필요는 없다.

<br>

### 6. Uniform Interface(인터페이스 일관성)

- URI로 지정한 Resource에 대한 조작을 통일되고 한정적인 인터페이스로 수행한다.

- HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용이 가능하다.
    - 특정 언어나 기술에 종속되지 않는다.

<br><br>

## REST API

<br>

### REST API란?

#### API = Application Programming Interface

데이터와 기능의 집합을 제공하여 컴퓨터 프로그램간 상호작용을 촉진하며, 서로 정보를 교환가능 하도록 하는 것 

<br>

#### REST API의 정의

REST 기반으로 서비스 API를 구현한 것.

최근 OpenAPI (*누구나 사용 가능하도록 공개된 API;구글 맵, 공공 데이터*), 마이크로 서비스(*하나의 큰 애플리케이션을 여러 개의 작은 애플리케이션으로 나눠 변경과 조합이 가능하도록 만든 아키텍처*) 등을 제공하는 업체 대부분이 REST API를 제공한다.

<br>

### REST API 특징

사내 시스템들도 REST 기반으로 시스템을 분산해 확장성과 재사용성을 높여 유지보수 및 운용을 편리하게 할 수 있다.
<br>
REST는 HTTP 표준을 기반으로 구현하므로, HTTP를 지원하는 프로그램 언어로 클라이언트, 서버를 구현할 수 있다.
<br>
즉, REST API를 제작하면 자바, C#, 웹 등을 이용해 클라이언트를 제작할 수 있다.

### REST API 설계 기본 규칙

1. URI는 정보의 자원을 표현해야 한다.

2. 자원에 대한 행위는 HTTP Method(GET, PUT, POST, DELETE 등)로 표현한다.

<br><br>

## RESTful

<br>

### RESTful이란?

일반적으로 REST라는 아키텍처를 구현하는 웹 서비스를 나타내기 위해 사용되는 용어이다.
<br>
즉, 'REST API'를 제공하는 웹 서비스를 'RESTful'하다고 할 수 있다.
<br>
REST를 REST답게 쓰기 위한 방법으로, 누군가가 공식적으로 발표한 것이 아니며, 즉, REST 원리를 따르는 시스템은 RESTful이란 용어로 지칭된다.

<br>

### RESTful의 목적

RESTful의 목적은 결국 이해하기 쉽고, 사용하기 쉬운 REST API를 만드는 것이라 할 수 있다. <br>

RESTful한 API를 구현하는 근본적인 목적은 성능 향상이라기 보다는 일관적인 컨벤션을 통한 API의 이해도 및 호환성을 높이는 것이 주 동기기 때문에
성능이 중요한 상황에서는 굳이 RESTful한 API를 구현할 필요는 없다. <br>

<br>

### RESTful하지 못한 경우

ex1) CRUD 기능을 모두 POST로만 처리하는 API
<br>
ex2) route에 resource, id 외의 정보가 들어가는 경우(/students/updateName)

<br><br>

끝🐧
