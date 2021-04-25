# Baekjoon Online Judge

## algorithm practice
<br>

## - 단계별 문제풀기
<br>

## 17. 정수론 및 조합론

> 정수론과 조합론을 배워 봅시다.

<br>

---

<br>

**Java / Python**

<br>

### 7. 이항 계수 1
[11050번](https://www.acmicpc.net/problem/11050) 
> N개의 물건 중 순서를 고려하지 않고 K개를 고르는 경우의 수, 이항 계수를 구하는 문제

<br>

![](https://images.velog.io/images/jini_eun/post/6e98287f-f330-4295-8e26-f0d73c564ca6/image.png)

<br>

> 이번 문제는 계수를 구하기 위해서 nCr을 구하면 되는 문제인 것 같습니다.
* nCr
![](https://images.velog.io/images/jini_eun/post/5ecf9c0d-01ae-435d-a4c0-806264507fb4/image.png)

<br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
 
		// nCk = n! / ((n-k)! * k!)
		System.out.println(factorial(N) / (factorial(N - K) * factorial(K)));
	}
 
	static int factorial(int N) {		
		if (N <= 1)	{    // 0! = 1
			return 1;
		}
		return N * factorial(N - 1);
	}
}
```


<br><br><br>

- Python 

<br>

```python
import sys

def fact(n):
    if n <= 1:
        return 1
    return n * fact(n - 1)

N, K = map(int, sys.stdin.readline().split())

print(fact(N) // (fact(N - K) * fact(K)))
```

<br>

( python 의 math 라이브러리에서 제공하는 factorial 함수를 이용한 코드 )

```python
from math import factorial
import sys

N, K = map(int, sys.stdin.readline().split())

print(factorial(N) // (factorial(N - K) * factorial(K)))

```

<br><br>

---

<br>

