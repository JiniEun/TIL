# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 14. 동적 계획법1

> 기초적인 동적 계획법 문제들을 풀어봅시다.


**Java / Python**

<br><br>

### 4. 파도반 수열
[9461번](https://www.acmicpc.net/problem/9461) 
> 피보나치 수와 비슷한 규칙을 찾아 동적 계획법으로 푸는 문제

![](https://images.velog.io/images/jini_eun/post/aede5bee-9fb4-4104-b4b7-6a0cc2b193d4/image.png)

<br><br><br>

- Java
<br>
> 파도반 수열의 경우 N = 100의 경우 int형 범위를 넘어가기 때문에 long 타입으로 해주어야 합니다. Top-Down(재귀)방식에 메모이제이션을 이용한 방법으로 작성했습니다.

<br>

```java
import java.util.Scanner;
 
public class Main {
	
	public static long[] P = new long[101];
 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 101; i++) {
			P[i] = -1;
		}
		P[0] = 0;
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		
		int T = sc.nextInt();
		
		while(T-- > 0) {
			int N = sc.nextInt();
			System.out.println(Padovan(N));
		}
        sc.close();
	}
	
	public static long Padovan(int N) {
		if(P[N] == -1) {	// 탐색하지 않은 index의 경우 -> 재귀호출
			P[N] = Padovan(N - 2) + Padovan(N - 3);
		}
		return P[N];
	}
 
}
```


<br><br><br>

- Python 

<br>

```python
import sys

P = [0 for i in range(101)]
P[1] = 1
P[2] = 1
P[3] = 1	

for i in range(0, 98):
    P[i + 3] = P[i] + P[i + 1]
    
T = int(sys.stdin.readline()) 

for i in range(T):
    N = int(sys.stdin.readline())
    print(P[N])

```
<br><br>


---

<br>

