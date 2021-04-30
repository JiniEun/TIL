# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 15. 동적 계획법1

> 기초적인 동적 계획법 문제들을 풀어봅시다.


**Java / Python**

<br><br>

### 9. 쉬운 계단 수 
[10844번](https://www.acmicpc.net/problem/10844) 
> 동적 계획법을 이용해 계단 수를 구하는 문제

![](https://images.velog.io/images/jini_eun/post/99785a3f-e4af-4d60-ab9e-cc01a3df4876/image.png)

<br><br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	
	final static long MOD = 1000000000;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] DP = new long[N + 1][10];
		
		// 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1개
		for(int i = 1; i < 10; i++) {
			DP[1][i] = 1;    // DP 배열 초기 상태 
		}
		
		// 2 ~ N 탐색
		for(int i = 2; i <= N; i++) {
			
			for(int j = 0; j < 10; j++) {
				
				if(j == 0) {    // 끝이 0이면 1만 가능
					DP[i][0] = DP[i - 1][1] % MOD;
				}else if (j == 9) { // 9라면 8만 가능
					DP[i][9] = DP[i - 1][8] % MOD;
				}else {    // -1,+1
					DP[i][j] = (DP[i - 1][j - 1] + DP[i - 1][j + 1]) % MOD;
				}
			}
		}
		
		long result = 0;
		
		// 각 자릿값마다 경우의 수를 모두 더하기
		for(int i = 0; i < 10; i++) {
			result += DP[N][i];
		}
		
		System.out.println(result % MOD);
	}
 
}
```


<br><br><br>

- Python 

<br>

```python
import sys
N = int(sys.stdin.readline())
DP = [[0 for i in range(10)] for j in range(101)]
mod = 1000000000
for i in range(1, 10):
    DP[1][i] = 1
    
for i in range(2, N + 1):
    for j in range(10):
        if j == 0:
            DP[i][j] = DP[i-1][1]
        elif j == 9:
            DP[i][j] = DP[i-1][8]
        else:
            DP[i][j] = DP[i-1][j-1] + DP[i-1][j+1]

print(sum(DP[N]) % mod)
```
<br><br>


---

<br>

