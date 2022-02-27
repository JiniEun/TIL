# HTTP 상태 코드

## api 요청이 성공적으로 완료된 경우
- 2로 시작되는 상태 코드
- 200(OK) : 요청 성공의 기본 상태 코드
- 201(No Content) : body에 응답 내용이 없을 경우 이용

## 클라이언트 측 에러 응답
- 4로 시작되는 상태 코드
- 400(Bad Request) : request 형식 틀렸을 경우
- 401(Unathorized) : 리소스 접근 권한 없는 경우
- 403(Forbidden) : 해당 리소스에 접근하는 것이 허락되지 않을 경우
- 404(Not Found) : 존재하지 않는 URI
- 405(Method Not Allowed) : 존재하지 않는 request method
- 406(Not Acceptable) : request의 Accept header에 설정한 MIME 타입이 지원 불가능한 경우
- 414(URI Too Long) : 요청한 URI가 너무 김

## 서버 측 에러 응답
- 5로 시작되는 상태 코드
- 500(Internal Server Error) : 서버에서 에러가 발생한 경우에 설정되는 기본 상태 코드
- 503(Service Unavailable) : 외부 서비스가 현재 멈춘 상태 이거나 이용할 수 없는 서비스


출처: https://blog.jiniworld.me/71 [hello jiniworld]