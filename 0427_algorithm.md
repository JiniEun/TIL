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

### 8. 이항 계수 2
[11051번](https://www.acmicpc.net/problem/11051) 
> 더 넓은 범위의 이항 계수를 동적 계획법으로 구하는 문제

<br>

![](https://images.velog.io/images/jini_eun/post/0dc21cc9-1244-440e-9055-3a465bdf082a/image.png)

<br>

> 이번 문제는 저번 이항 계수 1 문제와 비슷한데, 이항 계수 값에 10,007로 나눈 나머지를 출력하는 문제입니다. 파스칼의 삼각형을 이용하여 풀었습니다.
*파스칼의 삼각형*
![](https://images.velog.io/images/jini_eun/post/f3e90e61-c844-4467-8ed9-49d9da4eaabf/image.png)
![](https://images.velog.io/images/jini_eun/post/c52c8df4-a48b-47ab-a03f-0b2e93980bc0/image.png)

<br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static final int div = 10007;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] Triangle = new int[N+1][N+1]; 
        
		for(int i = 0; i < Triangle.length; i++) { 
			for(int j = 0; j <= i; j++) { 
				if(i == j || j == 0) Triangle[i][j] = 1; 
				else Triangle[i][j] = (Triangle[i-1][j-1] + Triangle[i-1][j]) % 10007; 
			} 
		} 
		System.out.println(Triangle[N][K]);
	}
}
```


<br><br><br>

- Python 

<br>

```python
import sys
N, K = map(int, sys.stdin.readline().split())
dp = []

for i in range(N+1) :
    dp.append([1]*(i+1))

for i in range(2, N+1) :
    for j in range(1, i) :
        dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%10007

print(dp[N][K])
```

<br>

( python 의 math 라이브러리에서 제공하는 factorial 함수를 이용한 코드 )

```python
from math import factorial
import sys
n, k = map(int, sys.stdin.readline().split())
result = factorial(n) // (factorial(k) * factorial(n - k))
print(result % 10007)
```

<br><br>

---

<br>

