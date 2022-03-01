[Spring Boot] ResponseEntity

# ResponseEntity

HttpEntity<T> 클래스를 상속받아 구현한 클래스이다.<br>

ResponseEntity는 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스이며, HttpStatus, HttpHeaders, HttpBody를 포함한다. 

```
public class RequestEntity<T> extends HttpEntity<T>
```

> **HttpEntity** <br>
> Spring Framework에서 제공하는 클래스d. <br>
> HTTP 요청(Request) 또는 응답(Response)에 해당하는 HttpHeader와 HttpBody를 포함하는 클래스이다. <br>
> ```
> public class HttpEntity<T> {
>
>	private final HttpHeaders headers;
>
>	@Nullable
>	private final T body;
> }
> ```
> 

ResponseEntity를 활용해, body와 헤더 정보, 상태 코드를 담아 응답을 전달할 수 있다.

