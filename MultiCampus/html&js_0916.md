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



~ [[03\][JS] 함수(현재)]까지 정리하기

금욜에 함수 호출부터



