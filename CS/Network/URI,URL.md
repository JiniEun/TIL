# URI, URL 차이점

## URI

특정 리소스를 식별하는 통합 자원 식별자(Uniform Resource Identifier)를 의미한다. <br>
웹 기술에서 사용하는 논리적 또는 물리적 리소스를 식별하는 고유한 문자열 시퀀스이다.

<br>

### URI의 구조


일반 URI는 다음과 같은 형태를 나타낸다.

```
scheme:[//[user[:password]@]host[:port]][/path][?query][#fragment]
```

scheme : 사용할 프로토콜을 뜻하며 웹에서는 http 또는 https를 사용 <br>

user, password : (서버에 있는) 데이터에 접근하기 위한 사용자의 이름과 비밀번호 <br>

host, port : 접근할 대상(서버)의 호스트명과 포트번호 <br>

path : 접근할 대상(서버)의 경로에 대한 상세 정보 <br>

query : 접근할 대상에 전달하는 추가적인 정보 (파라미터) <br>

fragment : 메인 리소스 내에 존재하는 서브 리소스에 접근할 때 이를 식별하기 위한 정보 <br>

<br><br>

## URL

URL은 흔히 웹 주소라고 하며, 컴퓨터 네트워크 상에서 리소스가 어디 있는지 알려주기 위한 규약이다. URI의 서브셋이다.

<br>
