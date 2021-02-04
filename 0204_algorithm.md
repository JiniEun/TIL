# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 3. for문

Java / Python
<br>

### 3. 합
[8393번](https://www.acmicpc.net/problem/8393) 
> 1부터 n까지의 합을 출력하는 문제.

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		
		for (int i = 1; i <= num; i++){
			sum = sum + i;
		}
		System.out.println(sum);
		sc.close();
	}
}
```

<br>

- Python
~~~~python
num = int(input())
sum = 0

for i in range(1, num+1):
	sum = sum + i
    
print(sum)
~~~~

---


<br><br>

### 4. 빠른 A + B
[15552번](https://www.acmicpc.net/problem/15552) 
> 문제 중요 point
>>- Java를 사용하고 있다면, Scanner와 System.out.println 대신 BufferedReader와 BufferedWriter를 사용할 수 있다. BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다.
- Python을 사용하고 있다면, input 대신 sys.stdin.readline을 사용할 수 있다. 단, 이때는 맨 끝의 개행문자까지 같이 입력받기 때문에 문자열을 저장하고 싶을 경우 .rstrip()을 추가로 해 주는 것이 좋다.

- Java
~~~java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
		int Num = Integer.parseInt(br.readLine());
        
		StringTokenizer st;
 
		for (int i = 0; i < Num; i++) {
			st = new StringTokenizer(br.readLine()," ");
			bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))+ "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
~~~

> 입력의 경우 BufferedReader.readLine()으로 받았다.
출력의 경우 반환타입 string인 토큰을 int로 변환하고, 더한 값을 BufferedWriter.write()을 이용해 출력했다.
문제에도 언급된 대로 버퍼를 비운 뒤에는 닫아줘야한다(flush / close).

<br>

- Python
```python
import sys
 
num = int(input())
for i in range(num):
        a,b = map(int, sys.stdin.readline().split())
        print(a+b)

```


<br>

---
오늘 4번 문제는 속도를 빠르게 하기 위해서, 처음에 배우는 입출력 함수들이 아닌 다른 방식을 이용해야 하는 문제입니다.
*저도 자주 사용하던 방식은 아니라, 어떻게 구현할 지 고민하고, 실수도 많이 하고 공부하게 된 것 같습니다..!*
