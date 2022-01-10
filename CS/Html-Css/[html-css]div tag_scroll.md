# [HTML-CSS] div 태그에 스크롤바(Scroll Bar) 붙이기

div tag에 다음과 같은 방법을 이용해 스타일을 지정하면 스크롤바를 붙일 수 있다.

- overflow:scroll; 
div 내용이 넘치든 아니든, 항상 스크롤바가 붙는다. 가장 많이 쓰이고 가장 무난한 방법. <br>

- overflow:auto; 
내용이 div 박스 밖으로 넘칠 때에만 스크롤바가 붙는다. 
많이 쓰이는 편이지만, 내용의 양에 따라서, 스크롤바가 붙었다 안 붙었다 하기 때문에 디자인에 좀 어려움이 있을 수 있다. <br>

- verflow:hidden; 
div 박스 밖으로 넘치는 것은 보여주지 않고 그냥 숨겨 버리며, 스크롤바도 붙지 않는다. 
특별한 목적이 있을 때에만 사용된다. <br>

- white-space:nowrap;
문자열이 길면 다음줄로 자동으로 행갈이가 되는데, nowrap 은 행갈이를 하지 말고 한 줄로 길게 이어서 쓰라는 의미이다. 프로그래밍 소스 코드 등을 표현할 때에는 행갈이를 하지 않는 것이 자연스럽다. <br>


```html
<div style="overflow:scroll; width:300px; height:150px; padding:10px; background-color:gold;">

스크롤바 예시(이런식으로 스타일을 적용해 사용한다)

</div>
```
