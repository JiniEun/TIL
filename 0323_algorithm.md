# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 13. 백트래킹

> 모든 경우를 탐색하는 백트래킹 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 1. N과 M (2) 
[15650번](https://www.acmicpc.net/problem/15650) 
> 백트래킹 입문 문제 2
>> 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
- 고른 수열은 오름차순이어야 한다.

<br><br>

- Java
<br>

```java
import java.util.Scanner;
 
public class Main {
 
	public static int[] arr;
	public static int N, M;
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		N = sc.nextInt();
		M = sc.nextInt();
 
		arr = new int[M];
        
		dfs(1, 0);
        sc.close();
	}
 
	public static void dfs(int at, int depth) {
 
		if (depth == M) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
        
		for (int i = at; i <= N; i++) {
 
			arr[depth] = i;
			dfs(i + 1, depth + 1);
 
		}
	}
}
```


<br><br>

- Python

<br>

```python
N, M = map(int, input().split())
visited = [False] * N
result = []

def backt(depth, idx, N, M):
    if depth == M:
        print(' '.join(map(str, result)))
        return
    for i in range(idx, N):
        if not visited[i]:
            visited[i] = True
            result.append(i+1)
            backt(depth+1, i+1, N, M)
            visited[i] = False
            result.pop()
backt(0, 0, N, M)
```

(Python 내부 함수  itertools의 combinations를 이용하는 간단한 방법)
```python
from itertools import combinations
N, M = map(int, input().split())
C = combinations(range(1, N+1), M)  # iter(tuple)
for i in C:
    print(' '.join(map(str, i)))  # tuple -> str
```

<br><br>

---

<br>

> 백트래킹에 대해서도 정리를 해보아야겠습니다.
