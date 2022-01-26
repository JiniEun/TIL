# [Network] REST, REST API, RESTful이란?

- [REST의 개념]
- [REST의 특징]
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




<br>
