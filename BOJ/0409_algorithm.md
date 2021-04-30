# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 15. 동적 계획법1

> 기초적인 동적 계획법 문제들을 풀어봅시다.


**Java / Python**

<br><br>

### 11. 가장 긴 증가하는 부분 수열
[11053번](https://www.acmicpc.net/problem/11053) 
> LIS(Longest Increasing Subsequence)를 구하는 문제

![](https://images.velog.io/images/jini_eun/post/ec7fe316-a062-4ff9-8585-73991114bc15/image.png)

> 먼저, N번째 값에 대해 이전에 탐색한 결과물이 있는지를 검사해야 합니다.
만약 없다면 탐색하지 않았다는 뜻이기 때문에 DP[N]을 1로 초기화합니다.(모든 부분수열의 길이는 '최소한 1 이상'이기 때문)
다음으로는, N-1 부터 0까지 N보다 작은 노드들을 탐색하면서 해당 노드의 값이 N번째 값보다 작은 경우를 찾습니다. 반복문은 i 2에서 한 번 재귀탐색을 시작하고, 0에서 재귀탐색을 시작합니다.

<br><br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	
	static int[] nums;
	static Integer[] DP;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		DP = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			LIS(i);
		}
		
		int max = DP[0];
        
		for(int i = 1; i < N; i++) {
			max = Math.max(max, DP[i]);
		}
		System.out.println(max);
	}
	
	
	static int LIS(int N) {
		
		// 탐색하지 않던 위치 
		if(DP[N] == null) {
			DP[N] = 1;	// 1로 초기화 
			
			// N-1 부터 0까지 중에서 N보다 작은 값들을 찾으면서 재귀호출. 
			for(int i = N - 1; i >= 0; i--) {
				if(nums[i] < nums[N]) {
					DP[N] = Math.max(DP[N], LIS(i) + 1);
				}
			}
		}
		return DP[N];
	}
}
```


<br><br><br>

- Python 

<br>

```python
import sys
N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
DP = [0 for i in range(N)]
for i in range(N):
    for j in range(i):
        if arr[i] > arr[j] and DP[i] < DP[j]:
            DP[i] = DP[j]
    DP[i] += 1
print(max(DP))
```
<br><br>


---

<br>

