# Springboot Annotation

<br>

- [Java에서 어노테이션이란?](#java에서-어노테이션이란?)
- [@PostConstruct](#postconstruct)


<hr/>


<br><br>

## Java에서 어노테이션이란?

자바 개발을 하면 클래스 또는 메서드 또는 변수 앞에 @Override 같은 @ 표시를 많이 볼 수 있다.
이 어노테이션은 JEE5(Java Platform, Enterprise Edition 5)부터 새롭게 추가된 요소이다.

이 어노테이션으로 인해 데이터의 유효성 검사 등을 쉽게 알 수 있고, 이와 관련한 코드가 깔끔해지게 된다.
어노테이션의 용도는 다양한 목적이 있지만 메타 데이터의 비중이 가장 크다 할 수 있다.

> 메타-테이터(Meta-Data) : 데이터를 위한 데이터를 의미하며, 데이터에 대한 설명을 의미하는 데이터. (자신의 정보를 담고 있는 데이터)

<br><br>

### @PostConstruct

@PostConstruct는 의존성 주입이 이루어진 후 초기화를 수행하는 메서드이다. <br>
@PostConstruct가 붙은 메서드는 클래스가 service를 수행하기 전에 발생한다. 이 메서드는 다른 리소스에서 호출되지 않는다해도 수행된다.  <br>

<br>

#### 사용하는 이유(장점)

1) 생성자(일반)가 호출될 때, 빈이 아직 초기화되지 않는데, @PostConstruct를 사용하면, 빈(bean)이 초기화 됨과 동시에 의존성을 확인할 수 있다. 

\+ 클래스 내에 @Autowired를 붙여서 객체를 사용할 경우에 생성자가 필요하다면 @PostConstruct를 사용하면 될 것 같다. 

<br>

2) bean lifecycle에서 오직 한 번만 수행된다는 것을 보장할 수 있다. 
그래서 @PostConstruct를 사용하면 bean이 여러번 초기화되는 것을 방지할 수 있다.

<br>

### @Slf4j

로깅에 대한 추상 레이어를 제공하는 인터페이스의 모음이다. (로깅 Facade) <br>

인터페이스를 사용하여 로깅을 구현하게 되면 좋은 점은 추후에 필요로 의해 로깅 라이브러리를 변경할 때 코드의 변경 없이 가능하다는 점이다. <br>

로깅이 필요한 부분에는 log 변수로 로그를 생성하면 된다.
로깅 레벨은 (많은 로깅) trace > warn > info > debug > error (적은 로깅) 순이다. <br>


<br>