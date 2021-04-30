# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 13. 백트래킹

> 모든 경우를 탐색하는 백트래킹 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 4. N과 M (4) 
[15652번](https://www.acmicpc.net/problem/15652) 
> 백트래킹 입문 문제 4
>> ![](https://images.velog.io/images/jini_eun/post/85ef3afc-9634-4fea-97c0-55e3758434b5/image.png)
- 비내림차순(순열의 오른쪽 요소가 크거나 같음)

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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
 
		dfs(1, 0);
        
		System.out.println(sb);
	}
 
	public static void dfs(int at, int depth) {
 
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
 
		for (int i = at; i <= N; i++) {
			arr[depth] = i;
			dfs(i, depth + 1);
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

def dfs(depth, index, N, M):
    if depth == M:
        print(' '.join(map(str, result)))
        return
    for i in range(index, N):
        result.append(i+1)
        dfs(depth+1,i, N, M)
        result.pop()

dfs(0, 0, N, M)
```

<br><br>

---

<br>

> 백트래킹에 대해서도 자세히 정리하려고 합니다.
