# [MySQL] 데이터베이스 명명 규칙

### 공통

1. 소문자를 사용한다.
2. 단어를 임의로 축약하지 않는다.
    register_date (O) | reg_date(X)
3. 가능하면 약어 사용을 피한다.
    (약어를 사용해야 하는 경우, 약어 역시 소문자를 사용한다.)
4. 동사는 능동태를 사용한다.
    register_date (O) | registered_date (X)

<br><br>

### Table

1. 복수형을 사용한다.
2. 이름을 구성하는 각각의 단어를 underscore로 연결하는 snake case를 사용한다.
3. 교차 테이블 (many-to-many)의 이름에 사용할 수 있는 직관적인 단어가 있다면 해당 단어를 사용한다.

<br><br>

### Column

1. auto increment 속성의 PK를 대리키로 사용하는 경우, "테이블 이름의 단수형"_id의 규칙으로 명명한다.
2. 이름을 구성하는 각각의 단어를 underscore(_)로 연결하는 snake case를 사용한다.
