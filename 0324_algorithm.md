# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 13. 백트래킹

> 모든 경우를 탐색하는 백트래킹 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 3. N과 M (3) 
[15651번](https://www.acmicpc.net/problem/15651) 
> 백트래킹 입문 문제 3
>> 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
- 1부터 N까지 자연수 중에서 M개를 고른 수열
- 같은 수를 여러 번 골라도 된다.

- N과 M(1) 예제에서 같은 수 중복 제거 조건을 뺀 문제입니다.

<br><br>

- Java
<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
    
    public static int N, M;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        // 공백을 기준으로 입력받기 때문에 공백 구분을 위해 StringTokenizer 객체를 함께 사용
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
 
		arr = new int[M];
		dfs(0);
		System.out.println(sb);
	}
 
	public static void dfs(int depth) {
 
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
 
		for (int i = 1; i <= N; i++) {
			arr[depth] = i;
			dfs(depth + 1);
		}
	}
}
```
> 수행시간을 빠르게 하기 위해 BufferedReader와 StringBuilder를 이용했습니다. 

<br><br>

- Python

<br>

```python
N, M = map(int, input().split())
result = []

def dfs(depth, N, M):
    if depth == M:
        print(' '.join(map(str, result)))
        return
    for i in range(N):
        result.append(i+1)
        dfs(depth+1, N, M)
        result.pop()

dfs(0, N, M)
```

<br><br>

---

<br>

> 백트래킹에 대해서도 자세히 정리하려고 합니다.
