# [Network] REST, REST API, RESTful이란?

- [REST의 개념](#rest의-개념)
- [REST의 특징](#rest-특징)
- [REST API의 개념]
- [REST API의 설계 규칙]
- [RESTful의 개념]


<hr/>

## REST의 개념

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

<br>

## REST의 장단점

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

<br>

## REST가 필요한 이유

- 애플리케이션 분리 및 통합

- 다양한 클라이언트의 등장

- 최근 서버 프로그램은 다양한 브라우저, 모바일 디바이스에서도 통신이 가능해야 한다.

- 멀티 플랫폼에 대한 지원을 위해 서비스 자우너에 대한 아키텍처를 세우고 이용하는 방법과의 연관성

<br>

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

<br>

## REST 특징

### 1. Server-Client(서버-클라이언트 구조)

- REST Server : (자원이 있는 쪽) API를 제공하고 

- Client : (자원 요청) 

### 2. Stateless(무상태)


### 3. Cacheable(캐시 처리 가능)