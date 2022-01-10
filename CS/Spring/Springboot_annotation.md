# Springboot Annotation

<br>

- [@PostConstruct](#@postconstruct)


<hr/>



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