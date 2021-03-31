# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 14. 동적 계획법1

> 기초적인 동적 계획법 문제들을 풀어봅시다.

>- **동적 계획법이란?**<br>
복잡한 문제를 간단한 여러 개의 문제로 나누어 푸는 방법을 말한다. 부분 문제 반복과 최적 부분 구조를 가지고 있는 알고리즘을 일반적인 방법에 비해 더욱 적은 시간 내에 풀 때 사용한다. <br>
일반적으로 주어진 문제를 풀기 위해서, 문제를 여러 개의 하위 문제(subproblem)로 나누어 푼 다음, 그것을 결합하여 최종적인 목적에 도달하는 것이다. 각 하위 문제의 해결을 계산한 뒤, 그 해결책을 저장하여 후에 같은 하위 문제가 나왔을 경우 그것을 간단하게 해결할 수 있다. 이러한 방법으로 동적 계획법은 계산 횟수를 줄일 수 있다. 특히 이 방법은 하위 문제의 수가 기하급수적으로 증가할 때 유용하다.
동적 계획 알고리즘은 최단 경로 문제, 행렬의 제곱 문제 등의 최적화에 사용된다. 이것은 동적 계획법은 문제를 해결하기 위한 모든 방법을 검토하고, 그 중에 최적의 풀이법을 찾아내기 때문이다. 문제가 가능한 모든 방법을 충분히 빠른 속도로 처리할 수 있는 경우, 동적 계획법은 최적의 해법이라고 말할 수 있다.
[[출처 : 위키백과]](https://ko.wikipedia.org/wiki/%EB%8F%99%EC%A0%81_%EA%B3%84%ED%9A%8D%EB%B2%95)<br>
- 메모이제이션(Memoization)
컴퓨터 프로그램이 동일한 계산을 반복해야 할 때, 이전에 계산한 값을 메모리에 저장함으로써 동일한 계산의 반복 수행을 제거하여 프로그램 실행 속도를 빠르게 하는 기술이다. 동적 계획법의 핵심이 되는 기술이다. 메모아이제이션이라고도 한다.<br>
- 동적계획법의 특징은 대체로 재귀 + 메모이제이션(Memoization)이라고 합니다.


**Java / Python**

<br>

### 2. 신나는 함수 실행
[9184번](https://www.acmicpc.net/problem/9184) 
> 재귀 호출만 생각하면 신이 난다! 아닌가요?

![](https://images.velog.io/images/jini_eun/post/48212d4f-c154-44bb-81af-df9730bf7343/image.png)

<br>

>  DP를 도입해서, w(a, b, c)의 값들을 저장해두고 해당 값을 사용해야 할 때, 저장해놓은 값을 이용하며 재귀의 깊이를 줄일 수 있다.

<br><br><br>

- Java
<br>

```java
import java.util.Scanner;
 
public class Main {

	static int[][][] dp = new int[21][21][21];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		
		while(true) {		
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if (a == -1 && b == -1 && c == -1) {    // 모두 -1이면 while문 종료
				break;
			}
			
			System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
		}
		sc.close();
	}
	
	static int w(int a, int b, int c) { 
        // 주어진 함수 w
        // a, b, c가 20이 넘으면 w(20, 20, 20)을 호출한다.
        // 각 배열의 크기가 21 (0~20)을 넘기지 않는다.
		// a, b, c가 범위를 벗어나지 않으면서 메모이제이션이 되어있는 경우
		if(RangeCheck(a, b, c) && dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		
		if(a > 20 || b > 20 || c > 20) {
			return dp[20][20][20] = w(20, 20, 20);
		}
		
		if(a < b && b < c) {
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}
		
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}
	
	static boolean RangeCheck(int a, int b, int c) {    //숫자가 범위 안인지 확인하는 함수
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20; 
	}
}
```


<br><br><br>

- Python 

<br>

```python
import sys

def w(a, b, c):
    if a <= 0 or b <= 0 or c <= 0:
        return 1
    elif a > 20 or b > 20 or c > 20:
        return w(20, 20, 20)

    if dp[a][b][c] :
        return dp[a][b][c]

    if a<b<c :
        dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c)
    else:
        dp[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1)

    return dp[a][b][c]


dp = [[[0 for _ in range(21)] for _ in range (21)] for _ in range (21)]
while True:
    a,b,c = map(int, sys.stdin.readline().split())
    if a==-1 and b==-1 and c==-1:
        break
    print("w({}, {}, {}) = {}".format(a,b,c,w(a,b,c)))
```

<br><br>

---

<br>

