# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 3. for문

Java / Python
<br>

### 1. 구구단
[2739번](https://www.acmicpc.net/problem/2739) 

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
        
		for (int i = 1; i <= 9; i++){
			System.out.println(num + " * " + i + " = " + num*i);
		}      
	}
}
```


- Python
~~~~python
num = int(input())

for i in range(1,10):
    print(num,"*",i,"=",num*i)
~~~~

---
>구구단: 출력형식 `num * i = num*i`

<br><br>

### 2. A + B - 3
[10950번](https://www.acmicpc.net/problem/10950) 

- Java
~~~java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a+b);
		}      
		sc.close();
	}
}
~~~

- Python
```python
num = int(input())

for i in range(num):
    a, b = input().split()
    a = int(a)
    b = int(b)
    print(a+b)
```
> A+B-3 문제:
첫째 줄에 테스트 케이스의 개수
각 테스트 케이스는 한 줄, 각 줄에 a와 b
각 테스트 케이스마다 A+B 출력

<br>

---
오늘은 for문 기본 예제들입니다.
