# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 13. 백트래킹

> 모든 경우를 탐색하는 백트래킹 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 1. N과 M (1) 
[15649번](https://www.acmicpc.net/problem/15649) 
> 백트래킹 입문 문제 1
>> 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

<br><br>

- Java
<br>

```java
import java.util.Scanner;
public class Main {
    public static int[] arr;
    public static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[M];
        visit = new boolean[N];
        dfs(0, N, M);
        sc.close();
    }
    public static void dfs( int depth, int N, int M) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1, N, M);
                visit[i] = false;
            }
        }
    }
}
```


<br><br>

- Python

<br>

```python
N, M = map(int, input().split())
visited = [False] * N  # 탐사 여부 확인하는 list
check = []  

def DFS(depth, N, M):
    if depth == M:  
        print(' '.join(map(str, check)))  
        return
    for i in range(len(visited)):  
        if not visited[i]:  # 탐사 안했다면
            visited[i] = True  # 탐사 시작(중복 제거)
            check.append(i+1)  # 탐사 내용
            DFS(depth+1, N, M)  # 깊이 우선 탐색
            visited[i] = False  # 깊이 탐사 완료
            check.pop()  # 탐사 내용 제거

DFS(0, N, M)
```

(Python 내부 함수 itertools의 permutations를 이용해서 중복하지 않는 순열을 찾아주는 간단한 방법)
```python
import sys
from itertools import permutations
N, M = map(int, sys.stdin.readline().split())
P = permutations(range(1, N+1), M)  # iter(tuple)
for i in P:
    print(' '.join(map(str, i)))  # tuple -> str
```

<br><br>

---

<br>

> 백트래킹의 방법 중 하나인 DFS(깊이 우선 탐색)을 이용하는 예제였습니다. DFS, BFS에 대해서도 정리를 해보아야겠습니다.
