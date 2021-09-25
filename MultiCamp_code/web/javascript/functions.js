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