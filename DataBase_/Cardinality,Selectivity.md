# Cardinality, Selectivity

## Cardinality

Cardinality란 사전적 의미로는 집합원의 개수라고 한다. (원소의 개수)

카디널리티(Cardinality, 기수성)는 특정 데이터 집합의 유니크(Unique)한 값의 개수이다.

예를 들어, 데이터베이스의 '성별' 컬럼의 경우 남자와 여자라는 값만 가질 수 있다.
따라서 이 때 카디널리티는 2다. <br>
반면, 주민등록번호는 모든 레코드가 고유한 값을 가지기 때문에 전체 레코드 개수와 카디널리티는 일치한다.

선택도는 0~1사이의 값이며, 1일 때 모든 값이 유니크하다는 뜻인데, <br>
카디널리티로부터 아래와 같이 계산할 수 있다. <br>

```
선택도 = 카디널리티 / 전체 레코드 수
```



<br>


