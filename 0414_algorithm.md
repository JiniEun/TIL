# Baekjoon Online Judge

## algorithm practice
<br>

## - 단계별 문제풀기
<br>

## 15. 동적 계획법1 

> 기초적인 동적 계획법 문제들을 풀어봅시다.

<br>

---

<br>

**Java / Python**

<br>

### 16. 평범한 배낭
[12865번](https://www.acmicpc.net/problem/12865) 
> 대표적인 DP 문제 중 하나인 "냅색 문제"

<br>

![](https://images.velog.io/images/jini_eun/post/ac469e23-eb38-4d57-8cc8-3003c4c5b14d/image.png)

<br>

> 짐을 쪼갤 수 없는 배낭문제 0/1 Knapsack Problem입니다.

<br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    
	static Integer[][] dp;
	static int[] W;
	static int[] V;
    
	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
        
		dp = new Integer[N][K+1];
		W = new int[N];
		V = new int[N];
        
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
        
		System.out.println(knapsack(N - 1, K));
        
	}
    
	static int knapsack(int n, int k) {
        
		if(n < 0){
			return 0;
		}

		// 탐색하지 않은 인덱스의 경우
		if(dp[n][k] == null) {
            
			if(W[n] > k){    // 현재 물건 못 담는 경우         
				dp[n][k] = knapsack(n - 1, k);
                
			}else{
				// (이전 n값과 이전 n값에 대한 k - W[i]의 값 + V[i]) => 큰 값을 저장  
				dp[n][k] = Math.max(knapsack(n - 1, k), knapsack(n - 1, k - W[n]) + V[n]);
			}
		}	
		return dp[n][k];
	}   
}
```


<br><br><br>

- Python 

<br>

```python
import sys 
N, K = map(int, sys.stdin.readline().split())
dp = [[0] * (K + 1) for i in range(N + 1)]
weight = [0]
value = [0]

for i in range(N):
    w, v = map(int, sys.stdin.readline().split())
    weight.append(w)
    value.append(v)
    
for i in range(1, N + 1):
    for j in range(K, 0, - 1):
        if weight[i] > j:
            dp[i][j] = dp[i - 1][j]        
        else:
            dp[i][j] = max(value[i] + dp[i - 1][j - weight[i]], dp[i - 1][j])
            
print(max(dp[N]))
```
<br><br>

- 찾아보니, dp를 1차원 배열로 두고 메모리를 절약해서 풀 수도 있다고 합니다. 위 코드보다는 알고리즘이 어떻게 구현됬는 지 직관적으로 알기는 조금 힘든 것 같습니다만, 위 코드보다는 메모리도 적게 들고 시간이 더 적게 듭니다!

```python
import sys

N, K = map(int, sys.stdin.readline().split())
bag = [tuple(map(int, sys.stdin.readline().split())) for _ in range(N)]
dp = [0 for _ in range(K+1)]

for i in range(N):
    for j in range(K, 1, -1):
        if bag[i][0] <= j:
            dp[j] = max(dp[j], dp[j-bag[i][0]] + bag[i][1])

print(dp[-1])
````

<br><br>

---

<br>

