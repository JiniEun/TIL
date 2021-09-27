# HTML DOM 실습



### 자식 노드의 갯수 산출

- 주석도 태그로 인식된다.

> childNodesCount.html

\- childNodes.length 이용

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        window.onload = function(){
            let divel = document.getElementById('divHolder');
            alert('divHolder div의 자식노드의 개수 '+divel.childNodes.length);
        }
    </script>
</head>
<body>
    <div id="divHolder">
        <!-- Ajax 정복 루트 -->
        <div>HTML</div>
        <div>JavaScript</div>
        <div>DOM</div>
        <div>Ajax</div>
    </div>
</body>
</html>
```



### 주석을 뺀 태그의 갯수만 산출

\- childNodes.length -> childNodes[i].nodeType == 1 

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        window.onload = function(){
            let divel = document.getElementById('divHolder');
            let count = 0;
            for(i=0; i < divel.childNodes.length; i++){
                if(divel.childNodes[i].nodeType == 1){
                    count++;
                }
            }
            alert('divHolder div의 자식노드의 개수 ' + count);
        }
    </script>
</head>
<body>
    <div id="divHolder">
        <!-- Ajax 정복 루트 -->
        <div>HTML</div>
        <div>JavaScript</div>
        <div>DOM</div>
        <div>Ajax</div>
    </div>
</body>
</html>
```



### DIV 태그의 값을 가져오기

- document.all : document tag안의 tag의 id 또는 name 속성을 찾는다. 비표준
- innerText : tag의 Text값에 접근한다. 비표준.

> div.html

\- document.all, innerText 이용

\- 삼항 연산자 이용

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        window.onload = function(){
            let div1text = document.all.div1.innerText;
            let div2el = document.getElementById('div2');
            let div2text = div2el.firstChild.nodeValue;
            let div3text = (document.getElementById('div3').textContent)? document.getElementById('div3').textContent : document.getElementById('div3').innerText;
        
            console.log(`div1text : ${div1text}, div2text : ${div2text}, div3text : ${div3text}`);
        }
    </script>
</head>
<body>
    <div id='div1'>백두산</div><br>
    <div id='div2'>한라산</div><br>
    <div id='div3'>금강산</div><br>
    <div id='div4'>설악산</div><br>
    <div id='div5'>관악산</div><br>
</body>
</html>
```



\- 삼항 연산자를 이용하지 않은 예제

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        window.onload = function(){
            let div1text = document.all.div1.innerText;
            let div2el = document.getElementById('div2');
            let div2text = div2el.firstChild.nodeValue;
            let div3text = document.getElementById('div3').textContent;
        
            console.log(`div1text : ${div1text}, div2text : ${div2text}, div3text : ${div3text}`);
        }
    </script>
</head>
<body>
    <div id='div1'>백두산</div><br>
    <div id='div2'>한라산</div><br>
    <div id='div3'>금강산</div><br>
    <div id='div4'>설악산</div><br>
    <div id='div5'>관악산</div><br>
</body>
</html>
```



### div tag로 내용 저장

> innerHTML.html

\- 버튼을 추가하여 테이블 생성 / 테이블 삭제

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        function setDiv() {
            var str = "<table><tr bgcolor='#00ff00'>";
            str = str + "<td width='500' height='200' align='center' valign='middle'>";
            str = str + "<font color='#ff0000' size='5'>";

            str = str + "A0001 - 컴퓨터 A<br>";
            str = str + "A0002 - 컴퓨터 B<br>";
            str = str + "A0003 - 컴퓨터 C<br>";
            str = str + "A0004 - 컴퓨터 D<br>";
            str = str + "</font>";
            str = str + "</td></tr></table>";

            document.getElementById("div1").innerHTML = str;
        }

    </script>
</head>
<body>
    <div id='div1'>*****</div><br>
    <button onclick="setDiv()">테이블 생성</button>
</body>
</html>
```



### 태그(Element)의 생성, 이미지 변경

> img.html



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        function imgShow(){
            let img = document.createElement('img');
            img.src = 'http://www.apache.org/images/ac2008us_343x114.jpg';

            // imgPlaceHolder DIV 태그 검색
            var holder = document.getElementById("imgPlaceHolder");
            
            // div 태그에 img 태그 추가
            holder.appendChild(img);
        }
    </script>
</head>
<body>
    <button onclick="imgShow()">이미지 표시</button>

    <div id='imgPlaceHolder'></div>
</body>
</html>
```



--

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        window.onload = function () {
            var img1 = document.createElement("img");
            img1.src = "./images/showImg/01.jpg";
            img1.width = 80;
            img1.height = 80;
            var show1Div = document.getElementById("show1");
            show1Div.appendChild(img1);

            var img2 = document.createElement("img");
            img2.src = "./images/showImg/02.jpg";
            img2.width = 80;
            img2.height = 80;
            var show2Div = document.getElementById("show2");
            show2Div.appendChild(img2);

            var img3 = document.createElement("img");
            img3.src = "./images/showImg/03.jpg";
            img3.width = 80;
            img3.height = 80;
            var show3Div = document.getElementById("show3");
            show3Div.appendChild(img3);

            var img4 = document.createElement("img");
            img4.src = "./images/showImg/04.jpg";
            img4.width = 80;
            img4.height = 80;
            var show4Div = document.getElementById("show4");
            show4Div.appendChild(img4);

            var img5 = document.createElement("img");
            img5.src = "./images/showImg/05.jpg";
            img5.width = 80;
            img5.height = 80;
            var show5Div = document.getElementById("show5");
            show5Div.appendChild(img5);
        }

        function show(div) {
            // alert(div); return;

            let temp = div.firstChild;
            //alert(temp); return;

            let mainImg = document.createElement("img");
            mainImg.src = temp.src; // 이미지 경로 전달
            mainImg.width = 570;
            mainImg.height = 400;
            let showMain = document.getElementById("showMain");
            showMain.innerHTML = "";
            showMain.appendChild(mainImg);
        }

    </script>
</head>
<body>
    <table width="700" height="420" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="571" bgcolor="#ECE9D8">
                <!-- 큰 이미지: 570 * 400 -->
                <table width="570" height="400" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td height="147">
                            <div id="showMain"></div>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="100" bgcolor="#ECE9D8">
                <!-- 작은 이미지: 80 * 80-->
                <table align="center" width="80" height="400" border="0" cellspacing="0" cellpadding="1">

                    <tr>
                        <td>
                            <div id="show1" onclick="show(this)"></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div id="show2" onclick="show(this)"></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div id="show3" onclick="show(this)"></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div id="show4" onclick="show(this)"></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div id="show5" onclick="show(this)"></div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</body>
</html>
```



체크 상자의 선택 상태를 읽거나 변경하기

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        // id를 받지 않는 경우
        function check() {
            document.getElementById("chkLCD").checked = true;
        }

        function uncheck() {
            document.getElementById("chkLCD").checked = false;
        }

        // id를 받는 경우
        function check2(id) {
            document.getElementById(id).checked = true;
        }

        function uncheck2(id) {
            document.getElementById(id).checked = false;
        }

        // 선택된 체크 상자 구함
        function getOption() {
            var lcd = document.getElementById("chkLCD"); // 태그 검색
            var ram = document.getElementById("chkRAM"); // 태그 검색
            var printer = document.getElementById("chkPrinter"); // 태그 검색
            var str = "";

            if (lcd.checked == true) {
                str = lcd.value + "   ";
            }

            if (ram.checked == true) {
                str = str + ram.value + "   ";
            }

            if (printer.checked == true) {
                str = str + printer.value;
            }

            // alert(str); // 선택값의 출력
            document.getElementById('opt').value = str;

        }
    </script>
</head>
<body>
    <form>
        <p>상품 옵션 선택 </p>
        <p>
            <input type="checkbox" id="chkLCD" value="LCD 24" />
            <input type="button" onClick="check()" value="LCD 24' 선택" />
            <input type="button" onClick="uncheck()" value="LCD 24' 선택 안함 " />
        </p>
        <p>
            <input type="checkbox" id="chkRAM" value="RAM 2G" />
            <input type="button" onClick="check2('chkRAM')" value="RAM 2G 선택" />
            <input type="button" onClick="uncheck2('chkRAM')" value="RAM 2G 선택 안함 " />
        </p>
        <p>
            <input type="checkbox" id="chkPrinter" value="프린터" />
            <input type="button" onClick="check2('chkPrinter')" value="프린터 선택" />
            <input type="button" onClick="uncheck2('chkPrinter')" value="프린터 선택 안함 " />
        </p>
        <p>
            <input type="button" name="btnOpt" value="선택한 옵션" onClick="getOption()">
            <input type="text" id="opt" size="40">
        </p>
    </form>
</body>
</html>
```



 태그에 특정 CSS 적용하기

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        function cssapply(cssName) {
            document.getElementById("content").className = cssName;  // DIV tag
        }
    </script>
    <style>
        .greenText {
            padding: 0px 0px 4px 0px;
            margin: 0px;
            font: bold italic 26px Georgia, serif;
            color: #7e9e50;
        }

        .redText {
            padding: 0px 0px 4px 0px;
            margin: 0px;
            font: bold italic 26px Georgia, serif;
            color: #FF493f;
        }

        .hide {
            display: NONE;
        }
    </style>
</head>
<body>
    <div id="content">
        JAVA-MySQL, JSP-Oracle, MVC-Struts, OJT
    </div>

    <input type="button" onclick="cssapply('greenText');" value="CSS 적용 1(녹색 텍스트)" />
    <input type="button" onclick="cssapply('redText');" value="CSS 적용 2(적색 텍스트)" />
    <input type="button" onclick="cssapply('hide');" value="CSS 적용 3(감추기)" />
</body>
</html>
```



화면의 특정 영역을 동적으로 숨기거나 감추기

> divOnOff.html

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        // 태그 보이기
        function show() {
            document.getElementById("content").style.display = "";
        }

        // 태그 감추기
        function hide() {
            document.getElementById("content").style.display = "none";
        }
    </script>
</head>
<body>
    <div id="content">
        DIV 태그 출력<br />
        <img src='http://www.apache.org/images/ac2008us_343x114.jpg' width='300' height='250'>
    </div> 
    
    <button onclick="show()">div 보이기</button>
    <button onclick="hide()">div 감추기</button>
</body>
</html>
```



텍스트의 링크를 동적으로 변경하기

```
```



텍스트를 div 태그로 감싸서 추가

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script type="text/javascript">
        function show() {
            // DIV 태그 검색
            let parentdiv = document.getElementById('textHolder');
            // 새로운 DIV 태그 생성
            let divel = document.createElement('div');
            // 새로운 DIV태그에 텍스트 생성
            divel.appendChild(document.createTextNode('CBD Developer 8'));
            // 새로운 DIV 태그를 부모 DIV 태그인 'textHolder'에 추가
            parentdiv.appendChild(divel);
        }

        function del(){
            let parentdiv = document.getElementById('textHolder');
            let divel = parentdiv.firstChild;
            if(divel != undefined){
                parentdiv.removeChild(divel);
            }
        }

    </script>
</head>
<body>
    <button onclick="show()">텍스트 추가</button>
    <button onclick="del()">텍스트 삭제</button>
    <div id="textHolder"></div>
</body>
</html>
```

























