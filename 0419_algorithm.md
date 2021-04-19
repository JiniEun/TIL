# Baekjoon Online Judge

## algorithm practice
<br>

## - 단계별 문제풀기
<br>

## 16. 그리디 알고리즘(Greedy Algorithm)

> 특정 상황에서 성립하는 그리디 알고리즘을 배워 봅시다.

<br>

---

<br>

**Java / Python**

<br>

### 5. 주유소
[13305번](https://www.acmicpc.net/problem/13305) 
> 최소 비용으로 주유하여 일직선 도로를 달리는 문제

<br>

![](https://images.velog.io/images/jini_eun/post/84b1ac63-78ca-4211-bcf0-2094eb8bd483/image.png)

<br>

> 이번 문제는 입력받은 도시별 기름 가격을 내림차순으로 만들어 각 도시별 거리를 곱하여 더해주면 되는 방식입니다!

<br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int N = Integer.parseInt(br.readLine());
        
		long[] cost = new long[N];    // 비용을 위한 변수
		long[] dist = new long[N-1];    // 거리를 위한 변수
		long sum = 0;
        
		// 거리 입력 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N - 1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
        
		// 기름값 입력
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}
        
		long min_cost = cost[0];    // 주유 최소 비용
        
		for(int i = 0; i < N - 1; i++){
			if(cost[i] < min_cost){
				min_cost = cost[i];
			}
			sum += (min_cost * dist[i]);
		}
		System.out.println(sum);  
	}
}
```


<br><br><br>

- Python 

<br>

```python
import sys
N = int(sys.stdin.readline())
dist = []
cost = []
dist = list(map(int, sys.stdin.readline().split()))
cost = list(map(int, sys.stdin.readline().split()))

result = 0
min_cost = cost[0]

for i in range(N - 1):
    if cost[i] < min_cost:
        min_cost = cost[i]
    result += min_cost * dist[i]

print(result)
```

<br><br>

---

<br>

