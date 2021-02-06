# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 4. While문

Java / Python
<br>

### 1. A + B - 5
[10952번](https://www.acmicpc.net/problem/10952) 
> 0 0이 들어올 때까지 A+B를 출력하는 문제

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		while(true){
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == 0 && b == 0){
				break;
			}
			System.out.println(a+b);  
		}
		sc.close();
	}
}
```

<br>

- Python

```python
while(True):
    a, b = map(int,input().split())
    if a == 0 and b ==0:
        break
    print(a+b)
```
<br>

---


<br><br>

### 2. A + B - 4
[10951번](https://www.acmicpc.net/problem/10951) 
> 입력이 끝날 때까지 A+B를 출력하는 문제. EOF에 대해 알아 보기
>> *EOF: end of file / 파일끝 => 컴퓨팅에서, 파일 끝은 데이터 소스로부터 더 이상 읽을 수 있는 데이터가 없음을 나타낸다.*

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
			
		while(sc.hasNextInt()){
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a+b);
		}	
		sc.close();
	}
}
```
> Java의 경우 hasNextInt()를 이용했습니다. hasNextInt()의 경우 입력값이 정수일경우 true를 반환하며, 정수가 아닐경우 바로 예외를 던지며 더이상의 입력을 받지 않고 hasNextInt()에서 false를 반환하면서 반복문이 종료됩니다!


<br>

- Python

방법 1
```python
while True:
    try:
        a, b = map(int, input().split())
        print(a+b)
    except:
        break
```

방법 2
```python
try:
    while True:
        a,b = map(int, input().split())
        print(a+b)
except:
    exit()
```

> 파이썬의 경우 try/except를 이용하여 예외 처리를 했습니다.
살짝 다른 방식으로 2가지 방법으로 코드를 작성해보았습니다..!

<br>

---

<br><br>

### 3. 더하기 사이클
[1110번](https://www.acmicpc.net/problem/1110) 
> 원래 수로 돌아올 때까지 연산을 반복하는 문제

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;    
		int N = num;	
		while(true){
			count = count + 1;
			N = ( (N%10)*10 ) + ( ((N/10) + (N%10))%10 );
			if(num == N){
				break;
			}
		}	
		System.out.println(count);
		sc.close();
	}
}
```

<br>

- Python

```python
N = num = int(input())
count = 0

while True:
    ten = N // 10
    one = N % 10
    total = ten + one
    count = count + 1
    N = int(str(N % 10) + str(total % 10))
    if(num == N):
        break
        
print(count)
```

<br><br>

---
> 오늘은 While문을 이용한 예제들을 풀어보았습니다!
while문의 경우, if문을 통해 조건을 정해서, break하는 방식으로 문제를 풀어보았습니다!
