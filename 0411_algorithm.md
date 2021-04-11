# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 15. 동적 계획법1

> 기초적인 동적 계획법 문제들을 풀어봅시다.


**Java / Python**

<br><br>

### 13. 전깃줄
[2565번](https://www.acmicpc.net/problem/2565) 
> LIS 응용 문제 2

<br>

![](https://images.velog.io/images/jini_eun/post/86b6df09-07d2-4228-9249-2c2d468851d4/image.png)

<br>

> 철거되어야 할 전선의 최소 개수를 수하는 문제입니다. 
철거할 전선의 개수는 (전체 전선 개수 - 설치 가능 개수) = 철거 개수 
로 구할 수 있습니다. 

<br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
 
public class Main {
 
	static Integer[] DP;
	static int[][] wire;
    
	static int repeat(int N) {
		
		// 탐색하지 않았던 위치의 경우
		if(DP[N] == null) {
			DP[N] = 1;	// 최솟값 1
			
			// A의 N번째, 이후의 전봇대들 비교 
			for(int i = N + 1; i < DP.length; i++) {
				// A전봇대의 N번째 전선이 연결되어있는 B전봇대보다 
				// A의 i번째 전봇대의 전선이 이어진 B전봇대가 뒤에 있을 경우 전선 설치
				if(wire[N][1] < wire[i][1]) {
					// 연결 가능한 전선의 경우의 수 중 큰 값을 dp에 저장
					DP[N] = Math.max(DP[N], repeat(i) + 1);
				}
			}
		}
		return DP[N];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		DP = new Integer[N];
		wire = new int[N][2];
		
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 첫 번째 원소(A전봇대)를 기준으로 오름차순으로 정렬
		Arrays.sort(wire, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int max = 0;		
		
		// i번째 A전봇를 기준으로 연결가능한 개수 탐색, 최댓값 찾기
		for(int i = 0; i < N; i++) {
			max = Math.max(repeat(i), max);
		}
		
		// result = 전선 개수 - 최댓값 
		System.out.println(N - max);
		
	}
}
```


<br><br><br>

- Python 

<br>

```python
import sys

N = int(sys.stdin.readline())
wire = []
dp = [1] * N

for _ in range(N):
    a, b = map(int, sys.stdin.readline().split())
    wire.append((a, b))

wire.sort()

# a 전깃줄 번호를 기준으로 오름차순 정렬된 b 전깃줄 번호의 수열
ab_wire = list(map(lambda x: x[1], wire))

for i in range(1, N):
    for j in range(i):
        if ab_wire[i] > ab_wire[j]:
            dp[i] = max(dp[i], dp[j] + 1)

# 철거할 전깃줄의 최소 개수 = 현재 전깃줄의 개수 - 최대 전깃줄의 개수
print(N - max(dp))
```
<br><br>


---

<br>

