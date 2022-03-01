# [React] 절대 경로 설정하기

개발 환경 : Mac + VScode + React + js <br><br>

.이나 ..을 이용해 ../component/Header와 같이 상대 경로로 작성하면, 상대경로이기 때문에 해당 폴더나 파일 이동할 때 경로가 달라져 import 오류가 날 수 있다.
혹은 사용할 때 헷갈릴 수도 있다.. <br>

따라서 'import {Header} from 'component/Header'와 같이 절대경로를 이용하면 편하고,
경로 오류 문제도 해결 가능하다. <br>

<br><br>

## 해결방법

<br>

검색하니 env를 이용하는 방법도 있는데 아래 방법으로 간단히 해결할 수 있어서, 아래 방법만 담았다.
*~~이 방법으로 `../.`의 지옥을 탈출했다..~~*


jsconfig.json 파일을 만들고, 아래 코드를 삽입한다.

json 파일의 위치는 package.json파일과 동일한 위치에 생성한다.

(typescript일 경우 tsconfig.json으로 파일을 생성한다.)

<br>

```json
{
    "compilerOptions": {
        "baseUrl": "src"
    },
    "includes": [
        "src"
    ]
}
```

<br><br>

References
- https://velog.io/@rimo09/React%EC%97%90%EC%84%9C-%EC%BB%B4%ED%8F%AC%EB%84%8C%ED%8A%B8-%EA%B2%BD%EB%A1%9C-%EA%B9%94%EB%81%94%ED%9E%88-%EA%B4%80%EB%A6%AC%ED%95%98%EA%B8%B0 (2022.03.02)

- https://velog.io/@mollang/React-%EC%A0%88%EB%8C%80%EA%B2%BD%EB%A1%9C-%EC%84%A4%EC%A0%95 (2022.03.02)

<br><br>

끝🐧

<br>