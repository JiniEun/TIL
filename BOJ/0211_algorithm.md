# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 7. 문자열

Java / Python
<br>

### 1. 아스키 코드
[11654번](https://www.acmicpc.net/problem/11654) 
> 아스키 코드에 대해 알아보는 문제

- Java

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String ascii = sc.next();
        int result = ascii.charAt(0);
        
        System.out.println(result);
    }
}
```
> charAt() 함수 : String으로 저장된 문자열 중에서 한 글자만 선택해서 char 타입으로 변환해주는 함수

<br>

- Python

```python
asciis = input()
print(ord(asciis))
```
<br>

---


<br><br>

### 2. 숫자의 합
[11720번](https://www.acmicpc.net/problem/11720) 
> 정수를 문자열로 입력받는 문제

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
        
		int T = sc.nextInt();
		String num = sc.next();
		sc.close();
		
		int sum = 0;
        
		for(int i = 0; i < T; i++) {
			sum += num.charAt(i)-'0';
		}
		System.out.print(sum);
	}
}
```

<br>

- Python

```python
case = int(input())
num = list(input())

result=0

for i in num:
    result += int(i)
print(result)
```

<br><br>

---

<br>

> 오늘은 문자열 단계 예제입니다!

