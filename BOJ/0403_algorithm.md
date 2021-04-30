# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 14. 동적 계획법1

> 기초적인 동적 계획법 문제들을 풀어봅시다.


**Java / Python**

<br><br>

### 5. RGB거리
[1149번](https://www.acmicpc.net/problem/1149) 
> i번째 집을 각각의 색으로 칠할 때, 1~i번째 집을 모두 칠하는 최소 비용으로 부분문제를 정의해봅시다.

![](https://images.velog.io/images/jini_eun/post/df6a4c61-26d9-4b05-b13f-f1759fae129d/image.png)

> 모든 집을 칠하는 비용의 최솟값을 구하는 문제이기 때문에, 각 집의 최솟값을 찾아 누적합을 구하는 것이 아닌 모든 경로의 경우의 수를 찾아서 최종적으로 작은 누적합을 찾아야 하는 문제입니다. <br>
각 집의 최솟값만 찾아 누적합을 구하면, 초반에 적은 비용인 곳을 칠해나가다가 인접한 집의 칠하게 되는 색이 최고 비용이 된다고 하면 최소 비용으로 모두 칠하지 못하는 상황이 나오기 때문에 모든 경로의 값을 비교해야 되는 것 같습니다.

<br><br><br>

- Java

<br>

> Scanner + 재귀호출을 이용한 코드입니다.

<br>

```java
import java.util.Scanner;
 
public class Main {
	
	final static int R = 0;
	final static int G = 1;
	final static int B = 2;
	
	static int[][] Cost;
	static int[][] DP;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
        
		Cost = new int[N][3];
		DP = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			Cost[i][R] = sc.nextInt();
			Cost[i][G] = sc.nextInt();
			Cost[i][B] = sc.nextInt();
		}
		
		// DP의 첫번째 집 - 각 색의 비용의 첫번째 값으로 초기화
		DP[0][R] = Cost[0][R];
		DP[0][G] = Cost[0][G];
		DP[0][B] = Cost[0][B];
		
		System.out.print(Math.min(Paint(N- 1, R), Math.min(Paint(N - 1, G), Paint(N - 1, B))));
		sc.close();
    }
	
	static int Paint(int N, int color) {
		
		// 탐색하지 않은 배열의 경우
		if(DP[N][color] == 0) {
			
			// color의 색에 따라 이전 집의 서로 다른 색을 재귀호출 
			// 최솟값과 현재 집의 비용을 더해서 DP에 저장
			if(color == R) {
				DP[N][R] = Math.min(Paint(N - 1, G), Paint(N - 1, B)) + Cost[N][R];
			}
			else if(color == G) {
				DP[N][G] = Math.min(Paint(N - 1, R), Paint(N - 1, B)) + Cost[N][G];
			}
			else {
				DP[N][B] = Math.min(Paint(N - 1, R), Paint(N - 1, G)) + Cost[N][B];
			}
		}	
		return DP[N][color];
	}
}
```


<br><br><br>

- Python 

<br>

> Python의 경우 반복문을 이용한 코드입니다.

<br>

```python
import sys
N = int(sys.stdin.readline())
P = []
for i in range(N):
    P.append(list(map(int, sys.stdin.readline().split())))
for i in range(1, len(P)):    # 0, 1, 2 = R, G, B
    P[i][0] = min(P[i - 1][1], P[i - 1][2]) + P[i][0]
    P[i][1] = min(P[i - 1][0], P[i - 1][2]) + P[i][1]
    P[i][2] = min(P[i - 1][0], P[i - 1][1]) + P[i][2]
print(min(P[N - 1][0], P[N - 1][1], P[N - 1][2]))
```
<br><br>


---

<br>

