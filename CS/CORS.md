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

- Access-Control-Allow-Origin <br>
브라우저가 해당 origin이 자원에 접근할 수 있도록 허용한다. <br>
`*`은 credentials이 없는 요청에 한해서 모든 origin에서 접근이 가능하도록 허용한다.

- Access-Control-Expose-Headers <br>
브라우저가 액세스할 수 있는 서버 화이트리스트 header를 허용한다.

- Access-Control-Max-Age <br>
얼마나 오랫동안 preflight요청이 캐싱 될 수 있는지를 나타낸다.

- Access-Control-Allow-Credentials <br>
`Credentials`가 true 일 때 요청에 대한 응답이 노출될 수 있는지를 나타내며, `preflight`요청에 대한 응답의 일부로 사용되는 경우 실제 자격 증명을 사용하여 실제 요청을 수행 할 수 있는지를 나타낸다. <br>
간단한 GET 요청은 `preflight`되지 않으므로 자격 증명이 있는 리소스를 요청하면 헤더가 리소스와 함께 반환되지 않으면 브라우저에서 응답을 무시하고 웹 콘텐츠로 반환하지 않는다.

- Access-Control-Allow-Methods <br>
`preflight`요청에 대한 대한 응답으로 허용되는 method들을 나타낸다.

- Access-Control-Allow-Headers <br>
`preflight`요청에 대한 대한 응답으로 실제 요청 시 사용할 수 있는 HTTP header를 나타낸다.
