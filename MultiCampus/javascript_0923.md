# JavaScript

## 객체

### 속성과 메소드

- 배열 내부에 있는 값 : 요소 / 객체 내부의 값 : 속성
- 객체의 속성중 자료의 처리하는 속성을 메서드라 부른다.
- 메소드 내에서 자신의 속성을 출력하고 싶을 때는 this 키워드 사용.

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <p id="demo"></p>

    <script>
        // 속성과 메소드 1
        /* 
        let person = {
            firstName: "John",
            lastName: "Doe",
            id: 5566,
            fullName: function () {
                return `${this.firstName} ${this.lastName}`;
            }
        }; 
        */

        /*
        document.getElementById("demo").innerHTML = person.fullName();
        */

        // 속성과 메소드 2 
        let person = {
            name: '홍길동',
            eat: function (food) {
                alert(this.name + '이 ' + food + '을/를 먹습니다.');
            }
        };

        person.eat('밥');

    </script>
</body>

</html>
```



### 생성자 함수

\- new 키워드로 객체를 생성할 수 있는 함수를 의미한다.
\- new 키워드 없이 객체를 생성하면 생성자 함수라 할 수 없다.
\- this 키워드로 객체의 속성과 함수에 접근한다.

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <p id="demo"></p>

    <script>
        // 생성자 함수
        function Person(first, last, age, eye) {
            this.firstName = first;
            this.lastName = last;
            this.age = age;
            this.eyeColor = eye;
        }

        let myFather = new Person("John", "Doe", 50, "blue");
        let myMother = new Person("Sally", "Rally", 48,"green");

        document.getElementById("demo").innerHTML =
                'My father is ' + myFather.age + ". My mother is " + myMother.age;

    </script>
</body>
</html>
```



\- 객체에 속성과 함수 추가
\- 두개의 객체를 생성할 경우 하나의 객체에만 추가될 수있다.
 아래 예제에서는 myFather객체에만 추가된다.

// myFather.nationality , myFather.name = function(){}

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <p id="demo"></p>

    <script>
        // 생성자 함수
        function Person(first, last, age, eye) {
            this.firstName = first;
            this.lastName = last;
            this.age = age;
            this.eyeColor = eye;
        }

        let myFather = new Person("John", "Doe", 50, "blue");
        let myMother = new Person("Sally", "Rally", 48,"green");

        myFather.nationality = "English";
        myFather.name = function(){
            return this.firstName + ", " + this.lastName;
        }

        document.getElementById("demo").innerHTML =
                'My father is ' + myFather.name();


    </script>
</body>
</html>
```



### 프로토 타입

\- 프로토타입은 생성자함수로 생성된 객체가 공통으로 가지는 공간이다.
\- 프로토타입을 사용하지 않고 메소드를 만들경우는 객체가 생성될때 마다 속성과 동일한 함수를 계속 만들어 자료수가 많아지면 쓸데없이 메모리를 잡아 비효율이 된다.

\- 프로토타입으로 속성 및 메소드 생성

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <p id="demo"></p>

    <script>
        // 생성자 함수
        function Person(first, last, age, eye) {
            this.firstName = first;
            this.lastName = last;
            this.age = age;
            this.eyeColor = eye;
        }

        Person.prototype.nationality = "English";
        Person.prototype.name = function(){
            return this.firstName + ", " + this.lastName;
        };

        let myFather = new Person("John", "Doe", 50, "blue");
        let myMother = new Person("Sally", "Rally", 48,"green");


        document.getElementById("demo").innerHTML =
                'My father is ' + myFather.name() + '<br> My mother is ' + myMother.name();


    </script>
</body>
</html>
```



### 클래스 사용

-- index.html

```html
<!--index.html-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src='object/class.js'></script>
</head>
<body>
</body>
</html>
```

-- class.js

```js
'use strict';
//class : template
//object : instance of a class

//class declarations
class Person {
    //constructor
    constructor(name, age) {
        //fields
        this.name = name;
        this.age = age;
    }

    //methods
    speak() {
        console.log(`${this.name}: hello! `);
    }
}

const hong = new Person('hong', 20);
console.log(hong.name)
console.log(hong.age);
hong.speak();
```



## 배열 생성 및 사용, 배열 메소드, 배열 Sort

### 배열(Array) 생성 및 사용

\- new Array() 생성자로 배열생성
\- 한개의 요소만으로 배열생성시 undefined 발생

```js
 var array = new Arrray(12,20);
 array[0] : 12 
 array[1] : 20
 var array  = new Array(12); 
 array[0] : undefined //잘못된 결과값 발생
```

 -- array.html

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=<device-width>, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <p id='demo'></p>
    <script>
        /*
        let person = { firstName: "John", lastName: "Doe", age: 46 };
        document.getElementById("demo").innerHTML = person["firstName"];
        document.getElementById("demo").innerHTML =
person['firstname'] + ": " + person; 
*/
        let fruits, text, flen, i;
        fruits = ["Banana", "Orange", "Apple", "Mango"];
        flen = fruits.length;
        text = "<ul>";

        //for
        for (i = 0; i < flen; i++) {
            text += '<li>' + fruits[i] + "</li>";
        }

        // for of
        for(let fruit of fruits){
            console.log(fruit);
        }

        // forEach
        fruits.forEach((fruit) => console.log(fruit));

        text += '</ul>';
        document.getElementById("demo").innerHTML = text;

    </script>
</body>

</html>
```



### 배열의 메소드

\- toString() : 배열의 값을 comma로 구분된 하나의 String값으로 변환

\- join() : toString()와 같은 역할을 하지만 특별한 구분자를 사용할 수 있다.

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=<device-width>, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <p id='demo'></p>
    <script>
        
        let fruits, text, flen, i;
        fruits = ["Banana", "Orange", "Apple", "Mango"];
        flen = fruits.length;

        document.getElementById("demo").innerHTML = fruits.toString();
        document.getElementById("demo").innerHTML = fruits.join(' * ');
    </script>
</body>

</html>
```

---

\- push() : push는 배열의 마지막 요소로 추가되며 추가후 배열의 길이를 가져옴

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>The push method returns the new array length.</p>
    
    <button onclick="myFunction()">Try it</button>
    
    <p id="demo"></p>
    
    <script>
        let fruits = ["Banana", "Orange", "Apple", "Mango"];
        document.getElementById('demo').innerHTML = fruits;

        function myFunction() {
            console.log(fruits.push("Kiwi"));
            document.getElementById('demo').innerHTML = fruits;
        }
    </script>
</body>
</html>
```

\- pop() : pop은 배열의 마지막 요소값을 삭제하며 삭제한 값을 가져옴

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>The push method returns the new array length.</p>
    
    <button onclick="myFunction()">Try it</button>
    
    <p id="demo"></p>
    
    <script>
        let fruits = ["Banana", "Orange", "Apple", "Mango"];
        document.getElementById('demo').innerHTML = fruits;

        function myFunction() {
            // console.log(fruits.push("Kiwi"));
            console.log(fruits.pop());
            document.getElementById('demo').innerHTML = fruits;
        }
    </script>
</body>
</html>
```

---

\- unshift() : 배열의 첫번째 요소에 값을 추가하며 배열의 길이를 리턴
\- shift() : 배열 첫번째 요소값을 제거하며 제거된 값을 가져온다.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>The push method returns the new array length.</p>
    
    <button onclick="myFunction()">Try it</button>
    
    <p id="demo"></p>
    
    <script>
        let fruits = ["Banana", "Orange", "Apple", "Mango"];
        document.getElementById('demo').innerHTML = fruits;

        function myFunction() {
            // console.log(fruits.unshift("Lemon"));
            console.log(fruits.shift());
            document.getElementById('demo').innerHTML = fruits;
        }
    </script>
</body>
</html>
```

\- 배열 요소값 추가

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>The push method returns the new array length.</p>
    
    <button onclick="myFunction()">Try it</button>
    
    <p id="demo"></p>
    
    <script>
        let fruits = ["Banana", "Orange", "Apple", "Mango"];
        document.getElementById('demo').innerHTML = fruits;

        function myFunction() {
            console.log(fruits[fruits.length] = 'kiwi');
            document.getElementById('demo').innerHTML = fruits;
        }
    </script>
</body>
</html>
```

\- splice() : item을 지정된 위치에서 지운다.
\- splice(start:number, deleteCount?:number, 추가될 요소값:string[]) : string[] 

deleteCount? 옵션으로 생략가능, 생략하면 추가될 요소가 하나 지워진다.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>The push method returns the new array length.</p>
    
    <button onclick="myFunction()">Try it</button>
    
    <p id="demo"></p>
    
    <script>
        let fruits = ["Banana", "Orange", "Apple", "Mango"];
        document.getElementById('demo').innerHTML = fruits;

        function myFunction() {
            console.log(fruits.splice(2, 0, "Lemon", "Kiwi"));
            document.getElementById('demo').innerHTML = fruits;
        }
    </script>
</body>
</html>
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>The push method returns the new array length.</p>
    
    <button onclick="myFunction()">Try it</button>
    
    <p id="demo"></p>
    
    <script>
        let fruits = ["Banana", "Orange", "Apple", "Mango"];
        document.getElementById('demo').innerHTML = fruits;

        function myFunction() {
            fruits.splice(0,1);
						document.getElementById('demo').innerHTML = fruits;
        }
    </script>
</body>
</html>
```

\- concat() : 두개 또는 이상의 배열을 연결해서 새로운 배열을 만들어냄

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <p id="demo"></p>

    <script>
        var myGirls = ["Cecilie", "Lone"];
        var myBoys = ["Emil", "Tobias", "Linus"];
        let myChildren = myGirls.concat(myBoys);

        document.getElementById("demo").innerHTML = myChildren;
    </script>
</body>
</html>
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <p id="demo"></p>

    <script>
        var myGirls = ["Cecilie", "Lone"];
        var myBoys = ["Emil", "Tobias", "Linus"];
        var arr3 = ["Robin", "Morgan"];

        let myChildren = myGirls.concat(myBoys, arr3);

        document.getElementById("demo").innerHTML = myChildren;
    </script>
</body>
</html>
```



\- slice() :기존 배열에서 잘라내서 새로운 배열로 만들어냄
 slice(시작인덱스,끝인덱스(포함되지 않음))

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>The push method returns the new array length.</p>
    
    <button onclick="myFunction()">Try it</button>
    
    <p id="demo"></p>
    
    <script>
        let fruits = ["Banana", "Orange", "Lemon", "Apple", "Mango"];
        document.getElementById('demo').innerHTML = fruits + '<br>' + fruits.slice(3);
      //  document.getElementById('demo').innerHTML = fruits + '<br>' + fruits.slice(1, 3);

        function myFunction() {
            document.getElementById('demo').innerHTML = fruits;
        }
    </script>
</body>
</html>
```



### 배열 정렬

 \- sort() : 오름차순으로 정렬해줌

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>The push method returns the new array length.</p>
    
    <button onclick="myFunction()">Try it</button>
    
    <p id="demo"></p>
    
    <script>
        let fruits = ["Banana", "Orange", "Lemon", "Apple", "Mango"];
        document.getElementById('demo').innerHTML = fruits;
        // + '<br>' + fruits.slice(1, 3);

        function myFunction() {
            // console.log(fruits.push("Kiwi"));
            // console.log(fruits.pop());
            // console.log(fruits.unshift("Lemon"));
            // console.log(fruits.shift());
            // console.log(fruits[fruits.length] = 'kiwi');
            // console.log(fruits.splice(2, 0, "Lemon", "Kiwi"));
            // fruits.splice(0,1);
            fruits.sort();
            document.getElementById('demo').innerHTML = fruits;
        }
    </script>
</body>
</html>
```

\- 숫자 배열 sort

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>The push method returns the new array length.</p>
    
    <button onclick="myFunction()">Try it</button>
    
    <p id="demo"></p>
    
    <script>
        // let fruits = ["Banana", "Orange", "Lemon", "Apple", "Mango"];
        var fruits = [1, 8, 5, 4];
        document.getElementById('demo').innerHTML = fruits;

        function myFunction() {

            fruits.sort();
            document.getElementById('demo').innerHTML = fruits;
        }
    </script>
</body>
</html>
```

\- reverse

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>The push method returns the new array length.</p>
    
    <button onclick="myFunction()">Try it</button>
    
    <p id="demo"></p>
    
    <script>
        // let fruits = ["Banana", "Orange", "Lemon", "Apple", "Mango"];
        var fruits = [1, 8, 5, 4];
        document.getElementById('demo').innerHTML = fruits;

        function myFunction() {
            fruits.reverse();
            document.getElementById('demo').innerHTML = fruits;
        }
    </script>
</body>
</html>
```



### 실습 예제

입력된 문장에 금지어가 있는 경우 금지어를 추출하여 출력 후 원본 문자열도

출력하는 스크립트를 작성하세요.

[조건]

\- 태그는 <TEXTAREA>와 <INPUT TYPE='button'>만을 사용합니다.

\- indexOf() 함수를 활용.

```
[실행 결과]

원본문자열:

   가을에는 단풍 여행을 내장산으로 가야한다고 한다.

   내장산은 단풍이 웅장하고 걷기편해 산책하기 좋다.

   단풍 나무와 함께 감나무에 감이 주렁주렁 열려 가을을 느끼기에 아주 좋다.

   하지만 단풍과 기암 괴석의 경치를 감사하고 싶으면 가을 설악의 단풍을

   추천한다. 하지만 교통체증이 너무 심해 새벽 2시 출발을 각오해야 한다.  

수정 문자열: 

   XX에는 XX 여행을 내장산으로 가야한다고 한다.

   내장산은 XX이 웅장하고 걷기편해 산책하기 좋다.

   XX 나무와 함께 감나무에 감이 주렁주렁 열려 XX을 느끼기에 아주 좋다.

   하지만 XX과 기암 괴석의 경치를 감사하고 싶으면 XX 설악의 XX을

   추천한다. 하지만 교통체증이 너무 심해 새벽 2시 출발을 각오해야 한다. 
```

-- exam01.html

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
        * {
            font-family: gulim;
            font-size: 22px;
        }
    </style>
    <script>
        function check() {
            let f = document.frm; // frm : form name
            let str = f.data.value;
            // console.log(str);

            let warning = ["가을", "단풍"];   // 금지어

            // javascript는 (java)replaceAll()이 없음으로 직접 구현
            for (let i = 0; i < warning.length; i++) {  // 금지어 수 만큼 순환
                let sw = true;               

                while (sw) {
                    let index = str.indexOf(warning[i]);   // 금지어 검색
                    if (index >= 0) {  // 발견 안되면 -1
                        // alert('index: ' + index);
                        str = str.replace(warning[i], "XX"); // 금지어 변경
                    } else {
                        sw = false; // 단어가 없을 경우 순환 중지
                    }
                }
            }
            // document.getElementById("panel").innerHTML = str; // 출력
            f.panel.value = str;
            
        }
    </script>
</head>
<body>
    <form name='frm'>
        <textarea name='data' rows='10' cols='70'>
가을에는 단풍 여행을 내장산으로 가야한다고 한다.
내장산은 단풍이 웅장하고 걷기편해 산책하기 좋다.
단풍 나무와 함께 감나무에 감이 주렁주렁 열려 가을을 느끼기에 아주 좋다.
하지만 단풍과 기암 괴석의 경치를 감사하고 싶으면 가을 설악의 단풍을
추천한다. 하지만 교통체증이 너무 심해 새벽 2시 출발을 각오해야 한다.  
        </textarea>
        <br><br>
        <input type='button' value='변환' onclick="check();">

        <br><br>
        <textarea name='panel' rows='10' cols='70'></textarea>
    </form>
</body>
</html>
```

-- Output

![image-20210923143708781](javascript_0923.assets/image-20210923143708781.png)



## BUTTON, SUBMIT 태그의 Event 처리

### Event의 처리(BUTTON, SUBMIT) 

\- `<a href="javascript:sendit();">`에서 javascript 생략 불가능.

#### 1. Anchor 태그에서 click 이벤트를 받는 소스

-- /event/event.html

-- Upgrade: [주소 이동] 버튼을 추가하여 주소 이동을 하는 기능 구현

```html
<!--event.html-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
        * {
            font-family: gulim;
            font-size: 22px;
        }
    </style>
    <script>
        function sendit() {
            let str = document.getElementById("url").value; //id 로 검색 
            console.log(`str : ${str}`);

            if (str == "") {
                alert("주소를 입력해 주세요");
                document.regiform.url.focus(); // 마우스 커서 
                // name속성으로 검색 
            } else {
                location.href = str;     // location 객체: 주소 관련 객체, href: 주소 값, 이동
            }
        }
    </script>
</head>

<body>
<form name='regiform'>
    <!-- id  : 태그 검색시 자바 스크립트가 사용, document.getElementById('url');
         name: request.getParameter("url") -->
    <input type="text" id="url" name="url" size="50">
    <a href="javascript: sendit();">주소 이동</a>
		<!-- <button type="button" onclick="sendit()">주소 이동</button> -->
</form>
</body>
</html>
```



-- Upgrade: 'http://' 이 문자열이 없으면 주소 이동이 안됨으로, 입력이 없을시 자동으로 주소가 추가되도로 해주세요

```html
<!--event_upgrade.html-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
        * {
            font-family: gulim;
            font-size: 22px;
        }
    </style>
    <script>
        function sendit() {
            let str = document.getElementById("url").value; //id 로 검색 
            console.log(`str : ${str}`);

            if (str == "") {
                alert("주소를 입력해 주세요");
                document.regiform.url.focus(); 
            } else {
                location.href = "https://" + str;     // https:// + str 로 이동
            }
        }
    </script>
</head>

<body>
    <form name='regiform'>
        Https:// <input type="text" id="url" name="url" size="50">
        <a href="javascript: sendit();">주소 이동</a>
    </form>
</body>
</html>
```



-- Upgrade:  미리 버튼에 [DAUM], [기상청], [교보문고]를 준비하여 클릭시 주소가 자동으로 입력창에 할당 되도록 하기

```html
<!--event_upgrade2.html-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
        * {
            font-family: gulim;
            font-size: 22px;
        }
    </style>
    <script>
        function sendit() {
            let str = document.getElementById("url").value; 
            console.log(`str : ${str}`);

            if (str == "") {
                alert("주소를 입력해 주세요");
                document.regiform.url.focus();
            } else {
                location.href = "https://" + str;     // https:// + str 로 이동
            }
        }

        function moveDaum(){
            location.href = 'https://www.daum.net';
        }
    </script>
</head>
<body>
    <form name='regiform'>
        Https:// <input type="text" id="url" name="url" size="50">
        <a href="javascript: sendit();">주소 이동</a>
        <button type="button" onclick="moveDaum()">DAUM</button>
        <button type="button" onclick="location.href='https://www.weather.go.kr'">기상청</button>
        <button type="button" onclick="location.href='https://www.kyobobook.co.kr'">교보문고</button>
    </form>
</body>
</html>
```



#### 2. 입력값을 검사하는 기본 자바 스크립트

- button 태그는 항상 자바스크립트 함수와 같이 사용된다.

  \- onClick='check(this.form)': this.form -> 폼 태그

- SUBMIT 버튼의 사용

    \- reset: 태그의 기본 값으로 돌아감.

    \- submit: 서버로 폼의 내용을 전송함.

   \- onsubmit: submit 버튼이 작동되면 자동으로 호출됨.

- image는 submit 과 같은 기능 + 버튼 이미지를 사용할 수 있음.

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
        * {
            font-family: gulim;
            font-size: 22px;
        }
    </style>
    <script>
        function check(f) {
            if (f.wname.value == '' || f.wname.value.length == 0) {
                alert("이름을 입력하세요");
                f.wname.focus();
                // return false; // button이 submit기능을 가지고 있을 때 작성
            } else if (f.subject.value.length == 0) {
                alert("제목을 입력하세요");
                f.subject.focus();
                // return false; // button이 submit기능을 가지고 있을 때 작성
            } else if (f.wcontent.value == "" || f.wcontent.value.length == 0) {
                alert("내용을 입력하세요");
                f.wcontent.focus();
                // return false; // button이 submit기능을 가지고 있을 때 작성
            } else {
                // 모든 데이터를 입력 한 경우 서버로 전송
                alert("데이터 정상 입력, 계속 진행합니다.");
                f.submit(); // button이 submit 기능이 없을 때 호출
            }
        }

    </script>
</head>

<body>
    <!-- 데이터 입력 형식 제공 -->
    <form method='post' action='' name='myform' onsubmit="return check(this)">
        <h2>방명록</h2>
        이름 : <input name="wname" type="text"> <br>
        제목 : <input name="subject" type="text" size="50"> <br>
        내용 : <textarea name='wcontent' rows='8' cols='54'></textarea> <br>
        <!--<button type="button" onclick="check(this.form)">저장</button>-->
        <!--<button>저장</button> --><!--submit 버튼-->
        <!--<button type='image' src='./disks.jpg' width="50px"></button>-->
        <a href="javascript:check(myform)">
            <img src="./disks.jpg" border='0'>
        </a>


    </form>
</body>
</html>
```



- [과제 1] Input 태그에서 행의 수와 열의 수를 입력받아 자바스크립트로 테이블을 생성하는 예제를 작성하세요.  입력되는 값은 수만 입력가능하며, 문자열 입력시 에러 메시지를 출력하세요. 입력 가능 값의 범위는 3 ~ 10 만 가능하며 이 값의 범위를 벗어나면 역시 에러메세지를 출력하세요.

  조건: 1) 숫자 입력 여부 검사, 2) 입력되는 수의 범위 검사

  힌트: 함수 안에서 다른 함수를 호출할 수 있습니다. 

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
        * {
            font-family: gulim;
            font-size: 22px;
        }
    </style>
    <script>
        function makeTable() {
            let row = document.getElementById("row").value;
            let col = document.getElementById("col").value;
            let table = "";

            if (isNaN(row) || isNaN(col)) {
                alert('숫자만 입력하세요(3~10)');
            } else if (row < 3 || row > 10 || col < 3 || col > 10) {
                alert('숫자만 입력하세요(3~10)');
            } else {
                table += '<table border="1.5">';
                for (let i = 0; i < row; i++) {
                    table += '<tr>';
                    for (let j = 0; j < col; j++) {
                        table += '<td>';
                        table += (i + ", " + j);
                        table += '</td>';
                    }
                    table += '</tr>';
                }
                table += '</table>';
            }
            console.log(table);
            document.getElementById("panel").innerHTML = table;
        }
    </script>
</head>
<body>
    <form>
        행의수: <input type="text" name="row" id="row" value="5" size="20"><br>
        열의수: <input type="text" name="col" id="col" value="5" size="20"><br>
    </form>
    <button onclick="makeTable()">table</button>
    <div id='panel'></div>
</body>
</html>
```





## CHECKBOX, RADIO 태그의 Event 처리

### Event의 처리 (CHECKBOX, RADIO)

   \- 입력 값의 범위 지정.

   \- 사용자는 시각적인 인터페이스로 사용이 편리.

#### split()함수를 이용 - 입력된 값을 분리하여 출력하는 스크립트 작성

 \- onload event: 페이지 로딩시 자동실행 함수 선언, body tag 실행 후 실행

 \- 자바스크립트를 BODY태그 안에서 호출시 결과가 body tag 안에 들어감

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
        * {
            font-family: gulim;
            font-size: 22px;
        }
    </style>
    <script>
        function searchW() {
            let str = '기획자/설계자/개발자/디자이너';
            let strout = '';
            let strSplit = str.split('/');
            console.log(`추출된 문자열 갯수:  ${strSplit.length}`);
            for (let i = 0; i < strSplit.length; i++) {
                strout += '▶ ' + strSplit[i] + ' ';
            }
            let panel = document.getElementById('panel');
            panel.innerHTML = strout;
        }
    </script>
</head>

<body onload="searchW()">

    <div id='panel'></div>

</body>
</html>
```



#### 파일의 확장자를 검사하는 함수

  \- 아래의 자바스크립트를 호출하는 HTML을 작성하세요.

  \- 검색이되면 0보다 크거나 같은 값이 나오고 발견이 안되면 -1을 리턴함.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
        * {
            font-family: gulim;
            font-size: 22px;
        }
    </style>
    <script type="text/javascript">
        function checkInput(word) {
            var ext = word.toLowerCase();  // 소문자로 변경 

            if (ext.lastIndexOf(".exe") > 0) {
                alert('파일의 확장자가 EXE 인것은 전송할 수 없습니다.');
                return false; // 실행 취소
            }

            if (ext.lastIndexOf(".jsp") > 0) {
                alert('파일의 확장자가 JSP 인것은 전송할 수 없습니다.');
                return false; // 실행 취소
            }

            if (ext.lastIndexOf(".jpg") > 0) {
                alert('파일의 확장자가 JPG 인 이미지임으로 전송 가능.');
            }

            alert('전송할 수 있는 파일 형식입니다.');
        }
    </script>
</head>

<body>
    자바 스크립트 확장자 호출 테스트입니다.<br>

    <script type="text/javascript">
        while (true) {
            var filename = prompt('파일명을 입력하세요(종료는 999).', '');

            if (filename == '999') {
                break; // while 종료
            }

            checkInput(filename);

        }

        document.write('사용해 주셔서 감사합니다.');
    </script>
</body>
</html>
```

\- 

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
        * {
            font-family: gulim;
            font-size: 22px;
        }
    </style>
    <script type="text/javascript">
        // 페이지 로딩시 자동 실행 함수, 이름이 없는 무명 함수로 1회만 실행됨.
        window.onload = function () {
            var word1 = document.getElementById("word1");
            var result1 = document.getElementById("result1");

            word1.innerHTML = "test.jsp";  // SPAN 태그로 값을 할당
            var str = word1.innerHTML;     // SPAN 태그에서 값을 추출

            if (str.lastIndexOf(".jsp") >= 0) {
                result1.innerHTML = "전송할수 없는 형식입니다.";  // SPAN 태그로 값을 할당
            }
        }
    </script>
</head>
<body>
    <h1>자바 스크립트 확장자 검사</h1><br><br>

    <div id="panel">
        <span id="word1"></span>: <span id="result1"></span><br>
    </div>
</body>
</html>
```



#### RADIO, CHECKBOX Type의 사용

  \- CHECKBOX는 같은 이름을 사용가능하며 RADIO 타입처럼 배열로 태그의 이름을 처리함.

 ```html
 <!DOCTYPE html>
 <html lang="en">
 <head>
     <meta charset="UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Document</title>
     <style type="text/css">
         * {
             font-family: gulim;
             font-size: 22px;
         }
     </style>
     <script>
         window.onload = function () {
             // document.frm.태그 배열(같은 이름의 태그가 여러개 존재하면 자동으로 배열 발생)
             document.frm.product[1].checked = true; 
             // checked="checked"
             check(document.frm); // 금액 계산 함수
         }
 
         function check(f) {
             let wonkum = 0;  // 원금
             let dc = 0;      // 주문 금액
             let selectedImage = 0; // 현재 선택 이미지
             let len = f.product.length; // product 태그의 갯수 출력
             console.log(`제품의 갯수: ${len}`); 
             
             if (f.product[0].checked) {       // 첫번째 옵션이 체크
                 wonkum = 1000000;                      
                 selectedImage = f.product[0].value;    // 1
             } else if (f.product[1].checked) { // 두번째 옵션이 체크
                 wonkum = 700000;                        
                 selectedImage = f.product[1].value;    // 2  
             } else if (f.product[2].checked) { // 세번째 옵션이 체크
                 wonkum = 400000;                        
                 selectedImage = f.product[2].value;    // 3
             }
             
             dc = wonkum; // 원금은 보관
 
             if (f.check1.checked) { // 10%
                 dc = wonkum - (wonkum * parseFloat(f.check1.value)); // 0.1
             }
 
             if (f.check2.checked) { // 5%
                 dc = wonkum - (wonkum * parseFloat(f.check2.value)); // 0.05
             }
 
             if (f.check3.checked) { // 50%
                 dc = wonkum - (wonkum * parseFloat(f.check3.value)); // 0.5
             }
 
             if (!f.check1.checked && !f.check2.checked && !f.check3.checked) {
                 dc = wonkum;
             }
 
             f.orderval.value = wonkum; // 원금, 선택한 가격
             f.discount.value = dc;     // 할인된 금액
 
             var imgStr = '';
             if (selectedImage == 1) {
                 imgStr = "<img src='./notebook1.jpg' width='30%'>";
             } else if (selectedImage == 2) {
                 imgStr = "<img src='./notebook2.jpg' width='30%'>";
             } else if (selectedImage == 3) {
                 imgStr = "<img src='./notebook3.png' width='30%'>";
             }
             document.getElementById("panel").innerHTML = imgStr;
         }
     </Script>
 </head>
 
 <body>
     <h1>노트북</h1>
 
     <div id="panel"></div>
 
     <form name="frm">
         [선택]
         <input type="radio" name="product" value="1" onclick="check(this.form);">고가제품
         <input type="radio" name="product" value="2" onclick="check(this.form);">중가제품
         <input type="radio" name="product" value="3" onclick="check(this.form);">저가제품
         <br><br>
 
         [할인율]
         <input TYPE="checkbox" NAME="check1" value="0.1" onclick="check(this.form);">우수고객
         <input TYPE="checkbox" NAME="check2" value="0.05" onclick="check(this.form);">장기고객
         <input TYPE="checkbox" NAME="check3" value="0.5" onclick="check(this.form);">국가유공자
         <br><br>
 
         [선택한 가격]<input type="text" name="orderval"> <!-- 가격 출력 -->
         [할인된 가격]<input type="text" name="discount"> <!-- 가격 출력 -->
     </form>
 </body>
 </html>
 ```



##  SELECT ~ OPTION 태그 Event의 처리

### Event의 처리 (SELECT ~ OPTION)

   \- 입력 값의 범위 지정.

   \- 사용자는 시각적인 인터페이스로 사용이 편리.

   \- CheckBox, RADIO 버튼보다 좁은 공간에 많은 항목의 나열 가능.

#### select 태그 자바스크립트에서 연동하기

  \- SELECT 태그에서 선택한 값을 텍스트 상자에 출력되도록 아래의 소스를 완성하세요.

  \- 지역변수로 선언해야 form 인식 가능

  ` var frm = document.frmData;`

  \- select 콘트롤에서 선택한 아이템의 인덱스(순번, 0부터 시작~)

   `f.ansqu.selectedIndex`

  \- select 콘트롤에서 선택한 아이템의 레이블(출력 문자열)

   `var str = f.ansqu.options[f.ansqu.selectedIndex].text;`

  \- select 콘트롤에서 선택한 아이템의 value

  ` frm.ansqu.value = f.ansqu.options[f.ansqu.selectedIndex].value;`

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
        * {
            font-family: gulim;
            font-size: 22px;
        }
    </style>
    <Script type="text/javascript">
        function ansquChange(f) {
            // f = document.frm

            alert(f.ansqu.selectedIndex);  // 0부터 시작 ~
            // SELECT 레이블 추출
            // var str = f.ansqu.options[1].text;
            var str = f.ansqu.options[f.ansqu.selectedIndex].text;
            f.title.value = str;
        }

        function partChange(f) {
            // f.pt.selectedIndex
            var str = f.title.value;

            // 기존값에 새로운 값 추가
            str = str + f.pt.options[f.pt.selectedIndex].text + " ";
            f.title.value = str;
            f.title.focus();
        }
    </Script>
</head>
<body>
    <form name="frm">
        <!-- onchange: 값이 변경 되었을때 발생되는 이벤트 -->
        <select name="ansqu" onchange='ansquChange(this.form)'>
            <option selected='selected'> [종류 선택] </option> <!-- selectedIndex = 0 -->
            <option> [질문] </option> <!-- selectedIndex = 1 -->
            <option> [답변] </option>
            <option> [참고] </option>
            <option> [공지] </option>
            <option> [추천] </option>
            <option> [선택 안함] </option>
        </select>

        <select name="pt" onchange='partChange(this.form)'>
            <option selected='selected'> [분야 선택] </option>
            <option> [ANDROID] </option>
            <option> [C] </option>
            <option> [C++] </option>
            <option> [JAVA] </option>
            <option> [JSP] </option>
            <option> [MOBILE] </option>
            <option> [JavaScript] </option>
            <option> [ORACLE] </option>
            <option> [MS-SQL] </option>
            <option> [DB 설계] </option>
            <option> [SI/MIS/ERP] </option>
            <option> [알고리즘] </option>
            <option> [정보처리기사/기능사] </option>
            <option> [사무자동화산업기사] </option>
            <option> [전자상거래관리사] </option>
            <option> [컴퓨터활용능력] </option>
            <option> [선택 안함] </option>
        </select>

        <input type="text" name="title" size="60" style="font-size:12; color:#000000; height:18; border:1px dashed"
            maxlength="100">
    </form>
</body>
</html>
```



\- text, value 차이만

```js
  var str = f.ansqu.options[f.ansqu.selectedIndex].text; // 레이블
  f.title.value=str;
  
  frm.ansqu.value = f.ansqu.options[f.ansqu.selectedIndex].value; // 서버로 전송되는 값
```



#### substring 함수

(실습은 안함)

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css"> 
*{ 
  font-family: gulim; 
  font-size: 22px; 
} 
</style>
</head>
<body>
<h1>
<script type="text/javascript">
    var str = '123ABC 가나다/가나다';
    document.write(str + '<br>');
 
    // '123'만 추출하세요.
    // substring(start index, end index)
    document.write(str.substring(0, 3) + '<br>');
 
    // 'ABC'만 추출하세요.
    document.write(str.substring(3, 6) + '<br>');
 
    // '가나다/가나다'만 추출하세요.
    // substring(start index)
    document.write(str.substring(7) + '<br>');
 
    // '가나다' 문자열이 마지막으로 나나탄 위치는?
    document.write(str.lastIndexOf('가나다') + '<br>');
 
</script>
</h1>
</body>
</html>
```



#### 문자열에서 공백을 제거하는 스크립트

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
        * {
            font-family: gulim;
            font-size: 22px;
        }
    </style>
    <script type="text/javascript">
        function trimSpace(f) {
            let str = f.txtData.value;
            console.log(str);
            for (let i = 0; i < str.length; i++) {
                if (str.charAt(i) == ' ') {
                    str = str.substring(0, i) + str.substring(i + 1, str.length);
                    i = i - 1; // 빈공간이 생기기 때문에 인덱스 -1 해줘야 함.
                }
            }
            // 폼으로 데이터를 주는 경우 
            f.txtData2.value = str;
        }

    </script>
</head>

<body>
    <form name="myform" method="GET">
        원본 문자열 : <input name="txtData" type="text" size=60 maxlength=60>
        <a href="javascript:trimSpace(myform)"><b>문자열 공백지우기</b></a>
        <br><br>
        공백 제거 문자열 : <input name="txtData2" type="text" size=60 maxlength=60>
    </form>
</body>
</html>
```





