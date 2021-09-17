

# Javascript

## function(함수)

- 매개변수가 함수에 들어가서 어떤 기능을 처리한 후 결과 리턴
- 모든 함수는 return value 또는 return undefined가 정의되어 있고 return undefined는 생략 가능
- 함수 선언 : function name(param1, param2, ...){body... return;}
- 하나의 함수는 한가지 일을 위해 작성한다.
- 함수의 이름은 동작을 나타내는 것이 좋다. doSomething, command, verb
- 함수는 object로 간주된다. 변수에 할당할 수 있고, 파라미터로 전달 가능, 리턴 가능. (First-class Function)



- 함수 선언 : js 엔진은 함수 선언문을 맨 위로 올려준다. 함수 선언문보다 먼저 함수를 호출할 수 있다. (hoisted (hoisging : js에서 호이스팅은 코드에 선언된 변수 및 함수를 코드 상단으로 끌어올리는 것.) )
- 함수 표현 : 함수를 변수에 할당하여 할당된 변수를 호출하여 함수를 실행할 수 있다. 함수 표현은 변수에 할당하기 전에는 함수를 호출할 수 없다.

-- functions.js

```javascript
function printHelo() {
    console.log('Hello');
}
printHelo();

function log(message) {
    console.log(message);
}

log('Hello@');
log(12345);

// parameters
// premitive parameters : passed by value
// object parameters: passed by reference

function changeName(obj) {
    obj.name = 'coder';
}

const kim = { name: 'kim' };
changeName(kim);
console.log(kim);

//default parameters(added in ES6)
function showMessage(message, from) {
    console.log(`${message} by ${from}`);
}

showMessage('hi'); //from undifined

function showMessage2(message, from = 'unknown') {
    console.log(`${message} by ${from}`);
}

showMessage2('hi'); //from unknown 출력

//Rest parameters (added in ES6) : 배열형태로 전달 
function printAll(...args) {
    for (let i = 0; i < args.length; i++) {
        console.log(args[i]);
    }

    for (const arg of args) {
        console.log(arg);
    }

    args.forEach((arg) => console.log(arg));
}

printAll('developer', 'coder', 'team');

// local scope 
let globalMessage = 'global'; //전역변수
function printMessage3() {
    let message = 'hello'; //지역변수
    console.log(message);
    console.log(globalMessage);
}
printMessage3();
//console.log(message);//오류

//return a value
//console.log(sum(3,3)); //호출 가능(hoisted)
function sum(a, b) {
    return a + b;
}

const result = sum(1, 2);
console.log(`sum: ${sum(1, 2)}`)

//early return, early exit
//bad : {}안에서 긴 로직코드가 구현되면 가독성이 떨어진다.
function upgradeUser(user) {
    if (user.point > 10) {
        //long upgrade logic....
    }
}

//good :조건이 맞지 않을때 빨리 리턴 해서 함수 종료하고 조건이 맞을때만  로직을 구현한다.
function upgradeUser(user) {
    if (user.point > 10) {
        return;
    }
    //long upgrade logic.....
}


//First-class function
//Function expression
//변수 에 함수 할당
//print(); //오류
const print = function () {  //anonymous function

    console.log('print');

};
print();

const printAgain = print;
printAgain();
const sumAgain = sum;
console.log(sumAgain(1, 2));

//callback function using function expression
//함수를 파라미터로 전달
function randomQuiz(answer, printYes, printNo) {
    if (answer === 'love you') {
        printYes();
    } else {
        printNo();
    }
}

const printYes = function () {
    console.log('Yes !');
};
const printNo = function print() { //named function - 함수안에서 자신 스스로를 부룰때 쓸수 있다.
    console.log('No !');
};

randomQuiz('wrong', printYes, printNo);
randomQuiz('love you', printYes, printNo);

//Arrow function
//always anonymous , {} 생략 , 리턴 키워드 생략
// const simplePrint = function(){
//     console.log('simplePrint');
// };

const simplePrint = () => console.log('simplePrint');
const add = (a, b) => a + b;
const simpleMultiply = (a, b) => { //{}사용하면 리턴 키워드 사용해야 함
    //do something more
    return a + b;
}

//IIFE: Immediately Invoked Function Expression
//함수선언과 동시에 호출하기
(function hello() {
    console.log('IIFE')
})();
```

-- utility.js

```js
// utility.js
// 자주 사용되는 공통 함수를 정의

function p(str) {
    if (typeof str == 'undefined') {  // 문자열이 없는 경우 
        document.write("<br>");
    } else {
        document.write(str);
    }
}

function pl(str) {
    if (typeof str == 'undefined') {    // 문자열이 없는 경우
        document.write("<br/>");
    } else {
        document.write(str + "<br/>");
    }
}
```



> 함수 예제 8 종류

\- 매개변수(Parameter, 함수로 전달 값)가 있는 함수의 호출

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {
            font-family: gulim;
            font-size: 22px;
        }
    </style>
    <script type="text/javascript">
        function pl(str) {
            document.write(`value:${str}, type:${typeof str} <br>`);
        }
    </script>

</head>

<body>
    <h1>함수의 사용예 2</h1>
    <script>
        temp1 = 10;
        temp2 = '안녕하세요';
        pl('두번째 함수 예제입니다.');
        pl(temp1);
        pl(temp2);
        pl(10.5);
        pl(true);
    </script>
</body>
</html>
```

\- 함수 실행 후 반환값이 있는 함수의 호출

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
        // 함수의 정의, return type이 없음
        function adding(x, y) {
            //입력된 값의 합을 계산
            let z = x + y;
            return z;
        }

        //print 함수의 정의
        function pl(str) {
            //입력된 값과 <BR>태그를 연결하여 출력
            document.write(str + "<br>");
        }
    </script>
</head>

<body>
    <h1>함수의 사용예 3</h1>

    <script type="text/javascript">
        let a = 10;
        let b = 20;
        let c = adding(a, b);  // 숫자 전달시는 계산 
        pl("두 변수의 합은 " + c);

        a = "야식이 건강 해치는 진짜 이유";
        b = "<br>-소화 불량, 숙면 방해, 비만 유발, 식도염 발생, 신진 대사 방해";
        c = adding(a, b);      // 문자열 전달시는 연결이 됨
        pl("두 변수의 합은 " + c);
    </script>
</body>
</html>
```

\- confirm 내장함수 

사용자가 확인이나 취소버튼을 클릭할 경우 true나 false를 리턴하는 함수

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
    <script type="text/javascript" src="./utility.js"></script>
</head>

<body>
    <h2>confirm의 사용 예제</h2>

    <script type="text/javascript">
        let temp;
        temp = window.confirm("확인 또는 취소를 선택하세요");

        //temp값은 true 또는 false
        if (temp) {
            pl(`확인 선택: ${temp}`);
        } else {
            pl(`취소 선택: ${temp}`);
        }
    </script>

</body>
</html>
```

 \- escape, unescape 내장 함수

숫자, 영문자를 제외한 한글등을 16진수 Unicode 형태로 인코딩(변환)하여 서버로 전송함, 변환을 하지 않으면 한글 깨짐.

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {
            font-family: gulim;
            font-size: 22px;
        }
    </style>
    <script type="text/javascript" src="./utility.js"></script>
</head>

<body>
    <h1>escape, unescape 내장 함수</h1>
    <script>
        pl(`원본: 123-ABC-abc-미합중국/러시아/중국-!?#$% <br>`);
        let temp1 = escape('123-ABC-abc-미합중국/러시아/중국-!?#$%');
        let temp2 = unescape(temp1);
        pl(`escape: ${temp1} <br><br>`);
        pl(`unescape: ${temp2}`);
    </script>
</body>
</html>
```

\- isFinite 내장 함수

정상적인 숫자가 입력되면 true를 그렇지 않고 문자등이 입력되면 false 리턴

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
    <script src="./utility.js"></script>
</head>

<body>
    <H2>isFinite함수 예제<br>

        <script type="text/javascript">

            let temp1, temp2;

            // 메시지, 기본값
            temp1 = prompt("값을 입력하세요", 100);

            // 숫자인지 검사
            if (isFinite(temp1)) {
                pl(`${temp1} 은 유한한 숫자`);
            } else {
                pl(`${temp1}은 무한대이거나 숫자가 아님`);
            }
        </script>

    </H2>
</body>
</html>
```

\- isNaN 내장 함수

입력된 값이 문자이면 true를 반환하고 그렇지 않고 숫자이면 false 리턴

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
    <script src="./utility.js"></script>
</head>

<body>
    <script>

        let temp1 = prompt("값을 입력하세요", 100.5);

        // 문자열 형태
        // 문자 : true, 숫자 : false

        if (isNaN(temp1)) {
            pl(`${temp1} 은 문자임<br>`);
        } else {
            pl(`${temp1} 은 숫자임<br>`);
        }
    </script>
</body>
</html>
```

\- 문자열 관련 함수 응용

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
    <script src="./utility.js"></script>
</head>

<body>
    <h1>문자열 함수 예제</h1>
    <strong>
    <script>
        let wc = "KOREA VICTORY";
        let prn = wc.charAt(0);  // 0번째 문자 추출

        //p('<b>');
        pl(prn);                 
        pl(wc.charAt(1));        
        pl(wc.charAt(2));        
        pl();                    
        pl(`V의 위치: ${wc.indexOf('V')}`); // 6
        pl(`R이 마지막으로 나타난 위치: ${wc.lastIndexOf('R')}`); // 11
        pl(`문자열의 길이: ${'대한민국 WBC'.length}`); // 8

        let tot = 10;
        pl(`tot+tot: ${tot + tot}`); // 20
        pl(`parseInt: ${parseInt('10') + parseInt('10')}`); //20

        //p('</b>');
    </script>
    </strong>
</body>
</html>
```

\- 입력 값의 이동

(value.html)

```html
<!--value.html-->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        let oldVal = '';
        let newVal = '';

        function ok(f) {
            if (oldVal === '' && newVal === '') {
                newVal = f.keyword.value;
            } else if (f.keyword.value === '') {
                return;
            } else {
                oldVal = newVal;
                newVal = f.keyword.value;
            }

            let divTag = document.getElementById('panel');

            let str = `oldVal: ${oldVal} / newVal: ${newVal}`;

            divTag.innerHTML = divTag.innerHTML + '<br>' + str;
            // divTag.append(`${str}`);
            // ivTag.innerHTML = divTag.innerHTML + '<br>';

        }
    </script>
</head>

<body>
    <form>
        <input type='text' name='keyword' value='' style='width:90%'>
        <button type='button' onclick="ok(this.form);">확인</button>
    </form>
    <br>
    <div id='panel' style="font-size:24px"></div>
</body>
</html>
```

\- split 함수 응용

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
    <script src="./utility.js"></script>
</head>
<body>
    <h2>split() 함수</h2>
    <hr>
    <script>
        let dtolist = '가길동, 100, 90/나길동, 100, 90/다길동, 100, 90';
        let arraydto = dtolist.split('/');
        console.log(`배열길이: ${arraydto.length}`);

        for(let i=0; i < arraydto.length; i++){
            pl(`${arraydto[i]} <br>`);
        }
        pl('<hr>');
        pl(`<h2> <성적 계산 목록> </h2>`);

        for(let i=0; i < arraydto.length; i++){
            let str = arraydto[i].split(',');
            console.log(`배열길이: ${str.length}`);

            pl(`성명:${str[0]}`);
            pl(`영어:${str[1]}`);
            pl(`수학:${str[2]}`);
            

            let eng = parseInt(str[1]);
            let math = parseInt(str[2]);

            pl(`총점 : ${eng+math}`);
            pl(`평균 : ${(eng + math)/2}`);

            pl('------------------------');
        }


    </script>
    
</body>
</html>
```



## 함수 활용하기

### 1. Math 함수

- Math.round() : 정수로 형변환
- Math.pow(10, 1) : 10^1 거듭제곱

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
    <script src="./utility.js"></script>
</head>

<body>
    <h2>Math.round, Math.pow 함수 사용</h2>
    <hr>
    <script>
        pl(Math.round(3.4595));
        pl(Math.round(3.5595));
        pl('<hr>');

        let digits = Math.pow(10, 1);
        let t = Math.round(3.5595 * digits);

        pl(`10^1 거듭제곱 : ${digits}`);
        pl(`t: ${t}`);
        pl(`${t / digits} <br/>`);

        digits = Math.pow(10, 2);
        t = Math.round(3.5595 * digits);

        pl(`10^2 거듭제곱 : ${digits}`);
        pl(`t: ${t}`);
        pl(`${t / digits}`);

    </script>
</body>
</html>
```



### 2. 함수 매개변수 전달 및 함수 리턴하기

\- 함수도 하나의 자료형이므로 매개변수로 전달할 수 있다.

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        // 함수 선언
        function callTenTimes(callback) { // callboack 매개변수
            for (let i = 0; i < 10; i++) {
                callback();
            }
        }

        callTenTimes(function (i) {
                alert(`함수 호출${i}`);
            });

        // 함수 표현식
        // let callback = function (i) {
        //     alert(`함수 호출${i}`);
        // }

        // callTenTimes(callback); // callback 실인수, 전역변수의 값
        
    </script>
</head>
<body>
</body>
</html>
```

### 3. 클로저

- 함수 안에 선언된 변수는 지역변수이기 때문에, 함수 외부에서 사용불가
- 클로저는 위 규칙을 위반할 수 있다.
- 흔히 함수 내에서 함수를 정의하고 사용하면 클로저라 할 수 있음.
- but, 대개는 정의한 함수를 리턴하고 사용은 바깥에서 하게 된다.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        function returnFunction(){
            return function(){
                alert('Hello Function.....!');
            }
        }

        returnFunction()();
    </script>
</head>
<body>
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
    <script>

        function test(name) {
            let output = `Hello ${name} ...!`;

            return function () {
                console.log(output);
            }
        }

        let test1 = test('Web');
        let test2 = test('Ajax');

        test1();
        test2();
    </script>
</head>
<body>
</body>
</html>
```



### 4. 중첩함수와 익명의 자기 함수 호출

- 중첩함수 : 부모의 함수의 변수에 접근 가능
- (아래 코드) 중첩함수 예제의 문제를 익명의 자기 호출 함수로 해결 가능

```html

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        /* function add(){
            let counter = 0;
            function plus(){
                counter += 1;
            }
            plus();
            return counter;
        }*/

        let add = (function () {
            let counter = 0;
            return function () {
                return counter += 1;
            }
        })();

        function myFunction() {
            document.getElementById('demo').innerHTML = add();
        }
    </script>
</head>

<body>
    <button type='button' onclick="myFunction()">Count!</button>
    <p id='demo'>0</p>
</body>
</html>
```



## 타이머 함수

- 타이머 함수 : 특정한 시간에 특정한 함수를 실행할 수 있게 하는 함수
- setTimeout() 함수 : 특정한 시간 후에 함수 한 번 실행
- setInterval() 함수 : 특정한 시간마다 함수 실행
- 지속적인 실행은 컴퓨터 자원을 소비함으로 타이머가 더이상 필요없을 경우 타이머 stop (clearTimeout(), clearInterval()  사용)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <script>
        /*
        setTimeout(function () {
            alert('3초가 지났습니다.');
        },3000);
        */
        setTimeout(()=> { alert('3초가 지났습니다.');},3000)
    </script>
</head>
<body>
</body>
</html>
```

---

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <script>
        let intervalId = setInterval(() => {
            alert(` ${new Date()} `);
        },1000); // 1초

        setTimeout(() => {clearInterval(intervalId)},10000); // 10초 후 종료
    </script>
</head>
<body>
</body>
</html>
```

---

- 자바스크립트 실행순서  (A -> C -> B)
- 타이머 함수 : 웹 브라우저가 처리하고 완료된 것을 자바스크립트에 알려준다.
- 이런 함수는 먼저 요청을 보내고 나머지 자바스크립트 코드를 실행한 후에 요청 결과를 받아서 처리.

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <script>
        // console.log('A');
        // setTimeout(()=>{console.log('B')},0);
        // console.log('C');

        //for(let i = 0; i<3; i++){
        //    setTimeout(()=> {console.log(i);},0);
        //}

        [0, 1, 2].forEach((i) => {
            setTimeout(() => { console.log(i); }, 0);
        });
    </script>
</head>

<body>
</body>
</html>
```

- setTimeout() 함수를 호출하는 시점이 반복문이 모두 끝난 이후가 된다.

```html
<script>
	for(let i = 0; i<3; i++){
		setTimeout(()=> {console.log(i);},0);
	}
</script>
```

- 배열의 forEach() 메소드를 이용한 배열값 출력
- [].forEach(callback,thisArg) :callback은 함수, thisArg는
   this의 참조를 나타낸다.

```html
<script>
	[0, 1, 2].forEach((i) => {
		setTimeout(() => { console.log(i); }, 0);
	});
</script>
```

- prototype

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        function Counter() {
            this.sum = 0;
            this.count = 0;
        }

        Counter.prototype.add = function (array) {
            array.forEach(entry => {
                this.sum += entry;
                ++this.count;
            }, this);
        }

        let obj = new Counter();
        obj.add([2,5,9]);
        console.log(`count : ${obj.count}`); // 3
        console.log(`sum : ${obj.sum}`); // 16
    </script>
</head>
<body>
</body>
</html>
```



## 객체, 객체의 프로퍼터(속성)와 메소드, 생성자 함수, 프로토타입, 클래스

### 1. 객체

- 자바스크립트에서는 거의 모든 것이 객체이다.
- 배열도 객체의 타입으로 인식할 만큼 객체와 유사하다.
- 배열 vs. 객체 : 배열은 인덱스와 요소가 있고, 객체는 이름과 값이 있다.
- 이름의 키를 사용하여 객체의 값에 접근한다.
- 객체는 배열처럼 하나 이상의 값을 가질 수 있다.

(1) 객체 값 접근 & 객체의 반복문 for(key in obj)

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
    <p>Creating a JavaScript Object.</p>
    <p id="demo"></p>
    <p id="demo2"></p>
    <script>
        let person = {
            firstName: "John",
            lastName: "Doe",
            age: 50,
            eyeColor: "blue"
        };
        document.getElementById("demo").innerHTML =
            //`${person.firstName} is ${person.age} years old.`;
            `${person['firstName']} is ${person['age']} years old2.`;

        let output = '';
        for (let key in person) {
            output += `● ${key} : ${person[key]} <br>`;
            // output += `● ${key} : ${person.key} <br>`; // undefined (출력 // 안됨 . 다음에는 name명이 와야)
        }
        document.getElementById('demo2').innerHTML = output;
    </script>
</body>
</html>
```



(2) in 키워드와 with 키워드

- in : 속성이 객체안에 있는지를 확인할 수 있다. 존재하면 true값 리턴.
- with : 객체의 속성을 출력할 때 여러번 사용되는 객체명을 줄여준다.

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        let output = '';
        let student = {
            이름: '연하진',
            국어: 92,
            수학: 98,
            영어: 96,
            과학: 98
        };

        // in 키워드 사용
        output += `이름 in student (${'이름' in student}) `;
        output += `성별 in student (${'성별' in student}) `;
        console.log(output);

        // with 사용안한 겨웅 출력
        let output2 = '';
        output2 += `이름 : ${student.이름} \n`;
        output2 += `국어 : ${student.국어} \n`;
        output2 += `수학 : ${student.수학} \n`;
        output2 += `영어 : ${student.영어} \n`;
        output2 += `과학 : ${student.과학} \n`;
        output2 += `총점 : ${(student.국어 + student.수학 + student.영어 + student.과학)} \n`;
        console.log(output2);

        // with 사용
        console.log("with 사용");
        let output3 = '';
        with (student) {
            output3 += `이름 : ${이름} \n`;
            output3 += `국어 : ${국어} \n`;
            output3 += `수학 : ${수학} \n`;
            output3 += `영어 : ${영어} \n`;
            output3 += `과학 : ${과학} \n`;
            output3 += `총점 : ${(국어 + 수학 + 영어 + 과학)} \n`;
        }
        console.log(output3);
    </script>
</head>
<body>

</body>
</html>
```

(3) push 함수를 사용하여 객체 생성

- 배열안에 객체를 하나씩 만들어 넣는다.
- 서로 다른 형태의 객체를 배열에 담는다.

````html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <script>
        let students = [];
        students.push({
            이름: '홍길동',
            국어: 87,
            수학: 98, 영어: 88, 과학: 95,
            장래희망: '생명공학자'
        })
        students.push({
            이름: '김길순', 국어: 92,
            수학: 98, 영어: 96, 과학: 98,
            특기: '요리', 취미: '일렉 기타'
        });
        students.push({
            이름: '이길동', 국어: 76,
            수학: 96, 영어: 94, 과학: 90,
            장래희망: '프로그래머'
        });
        console.log(students);
    </script>
</head>

<body>

</body>

</html>
````

(4) 객체 복사

-- index.html

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src='object/object.js'></script>
</head>
<body>
</body>
</html>
```

-- object.js

 ```js
 const user = { name: 'clare', age: 20 }
 const user2 = user;
 // console.log(user);
 user2.name = 'coder';
 console.log(user)
 
 //복사1
 const user3 = {};
 for (key in user) {
     user3[key] = user[key];
 }
 user3.name = 'developer';
 console.log(user3);
 
 //복사 2  
 // assign위에서 Ctrl + 클릭 -> assign 사용법 확인
 // const user4 = {};
 // Object.assign(user4, user);
 const user4 = Object.assign({}, user)
 user4.name = 'team';
 console.log(user4);
 // console.log(user);
 
 
 // 두 개 넣어보기 
 // Object.assign(desc, [obj1, obj2, obj3....])
 const fruit1 = { color: 'red' };
 const fruit2 = { color: 'blue', size: 'big' };
 
 const mixed = Object.assign({}, fruit1, fruit2); // 같은 값은 뒤에서 앞으로 덮어씀
 console.log(mixed.color);
 console.log(mixed.size);
 ```



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
        let person = {
            firstName: "John",
            lastName: "Doe",
            id: 5566,
            fullName: function () {
                return `${this.firstName} ${this.lastName}`;
            }
        };

        document.getElementById("demo").innerHTML = person.fullName();
    </script>
</body>
</html>
```

