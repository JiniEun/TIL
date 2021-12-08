# [Browser] CORS란?

CORS(Cross-Origin-Resource-Sharing) = 교차 출처 리소스 공유라고도 한다. <br>

개발하다보면 한 번씩 만날 수 있는 CORS policy 오류 메세지는 CORS 정책을 위반할 때 발생하게 된다.

추가적인 HTTP header를 사용해서 애플리케이션이 다른 origin 의 리소스에 접근할 수 있도록 하는 메커니즘을 말한다. 하지만 다른 origin에서 내 리소스에 함부로 접근하지 못하게 하기 위해 사용된다.

즉, 간단하게 말하면 도메인이 다른 2개의 사이트가 데이터를 주고 받을 때 발생하는 문제이다. 
예를 들어 jj.com에서 jin.com으로 데이터를 요청한다고 할 때, 
따로 설정을 해주지 않는 한 CORS 에러를 만나게 되는 것이다.

### 동일 출처 정책

다른 서버에서 API를 호출할 때는 멀쩡히 잘 동작하다가 브라우저에서 API를 호출할 때만 CROS policy 오류가 발생할 때가 있는데, 이것은 브라우저가 동일 출처 정책 (Same-Origin Policy, SOP)를 지켜서 다른 출처의 리소스 접근을 금지하기 때문이다.

#### 동일 출처 정책의 장점
동일 출처 정책을 지키면 외부 리소스를 가져오지 못해 불편하지만, XSS나 XSRF 등의 보안 취약점을 노린 공격을 방어할 수 있다. <br>
그래도 외부 리소스를 참고해야 할 경우가 있기 때문에 외부 리소스를 사용하기 위한 SOP의 예외 조항으로 CORS가 있다.

#### CORS가 필요한 이유
따라서 만약 본인이 서비스하고 있지 않은 사이트에서 세션을 요청해서 세션을 획득할 수 있다면, 해당 사이트는 악의적으로 내 세션을 탈취하거나 다른 행동을 할 수 있다.(피싱 사이트) <br>
그래서 브라우저에서는 이러한 요청을 막고 내가 허용한 origin들만 요청할 수 있도록 하기 위해 필요하다.

### 요청 헤더 목록

- Origin

- Access-Control-Request-Method <br>
`preflight` 요청을 할 때 실제 요청에서 어떤 Method를 사용할 것인지 서버에세 알리기 위해 사용된다.

- Access-Control-Request-Headers <br>
`preflight` 요청을 할 때 실제 요청에서 어떤 Header를 사용할 것인지 서버에세 알리기 위해 사용된다.

### 응답 헤더 목록

- Origin

- Access-Control-Request-Method <br>
`preflight` 요청을 할 때 실제 요청에서 어떤 Method를 사용할 것인지 서버에세 알리기 위해 사용된다.

- Access-Control-Request-Headers <br>
`preflight` 요청을 할 때 실제 요청에서 어떤 Header를 사용할 것인지 서버에세 알리기 위해 사용된다.

