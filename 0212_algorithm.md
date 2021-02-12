# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 7. 문자열

Java / Python
<br>

### 3. 알파벳 찾기
[10809번](https://www.acmicpc.net/problem/10809) 
> 한 단어에서 각 알파벳이 처음 등장하는 위치를 찾는 문제

- Java

```java
import java.util.Scanner;
public class Main {
       public static void main(String[] args) {
             Scanner sc = new Scanner(System.in);
             String input = sc.next();
             
             for (char c = 'a' ; c <= 'z' ; c++)
                    System.out.print(input.indexOf(c) + " ");
       }
}
```
> JAVA에서 문자열의 위치를 반환하는 indexOf() 함수를 사용해서 문제를 간단히 풀어냈습니다..!
indexOf() 함수 : 해당 문자가 처음으로 등장하는 위치를 반환하며,
만약 해당 문자가 문자열에 없으면 -1을 반환한다.

<br>

- Python

```python
S = input()
alphabet = list(range(97,123))  

for c in alphabet :
    print(S.find(chr(c))) 
```
> list의 범위는 알파벳의 아스키코드 숫자 범위입니다!

<br>

---


<br><br>

### 4. 문자열 반복
[2675번](https://www.acmicpc.net/problem/2675) 
> 각 문자를 반복하여 출력하는 문제

- Java
```java
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for(int i = 0; i < num ; i++) {
			int n = sc.nextInt();
			String str = sc.next();
			for(int j = 0; j < str.length() ; j++) {
				for(int k = 0; k < n; k++)
					System.out.print(str.charAt(j));
			}
			System.out.println();
		}

	}
}
```

<br>

- Python

```python
T = int(input())
for i in range(T):
    num, s = input().split()
    text = ''
    for i in s:
        text += int(num) * i
    print(text)
```

<br><br>

---

<br>

> 오늘은 문자열 단계 예제입니다!
설이라 간단한 예제 2개만 하고 끝냅니다! 
다들 새해복 많이 받으세요 ㅎㅎ

