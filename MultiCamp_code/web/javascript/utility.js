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