# CSS

## CSS Float, FlexBox

\- 문서에 사진이나 글그림을 왼쪽이나 오른쪽에 띄어서 정렬하거나 각 객체를 오른쪽이나 왼쪽으로 정렬하여 문서를 배치한다.
\- float는 left right none으로 설정할 수 있다.
\- block형 요소에만 사용된다. 예) div, p, ol, ul, table, img ...
\- https://developer.mozilla.org/en-US/docs/Web/CSS/float

```html
<!DOCTYPE html>
<html>
<head>
<style>
.thumbnail {
    float: left;
    width: 110px;
    height: 90px;
    margin: 5px;
}
</style>
</head>
<body>
 
<h3>Image Gallery</h3>
<p>Try to resize the browser-window to see what happens when the images do not have enough room.</p>
<img class="thumbnail" src="klematis_small.jpg" width="107" height="90">
<img class="thumbnail" src="klematis2_small.jpg" width="107" height="80">
<img class="thumbnail" src="klematis3_small.jpg" width="116" height="90">
<img class="thumbnail" src="klematis4_small.jpg" width="120" height="90">
<img class="thumbnail" src="klematis_small.jpg" width="107" height="90">
<img class="thumbnail" src="klematis2_small.jpg" width="107" height="80">
<img class="thumbnail" src="klematis3_small.jpg" width="116" height="90">
<img class="thumbnail" src="klematis4_small.jpg" width="120" height="90">
 
</body>
</html>
```

\- result

![image-20210916235434420](html&js_0916.assets/image-20210916235434420.png)









# JavaScript

## JavaScript

 \- 1995년 Netscape의 브랜든 아이크에 의해 모카를 개발, 후에 LiveScript로 변경 되었으며 최종적으로 JavaScript로 지정되었다.  
 \- HTML과 Server Script(백앤드) 사이에서 접속자의 마우스 클릭, 키보드 입력등 이벤트 처리를 주로 담당

 HTML + CSS : 출력

Javascript : 동작/이벤트

백앤드 : 데이터베이스 접속 처리(Oracle, MySQL...)

 \- Javascript는 Ajax 통신을 이용하여 서버와 태그단위로(JSP는 페이지단위 통신, 페이지단위 이동) 비동기 통신이 가능하며, jQuery로 Framework화 되어 발전되어 사용한다.

 \- 요즘은 Ajax 통신의 결과를 SPA(Single Page Application)로 구현하기 위해 typescript, React등을 사용.

 \- javascript 코드는 Chrome(V8 엔진, 가장 고속), IE, FF등의 브러우저가 처리함.

 \- 모든 브라우저는 현재 ECMAScript 10 in 2019 등 표준화로 정착되어 사용한다.

 \- 참조 사이트 : https://developer.mozilla.org/en-US/docs/Web/JavaScript



### 1. 자바스크립트 실행





~ [[03\][JS] 함수(현재)]까지 정리하기

금욜에 함수 호출부터



