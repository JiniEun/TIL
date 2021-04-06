# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 15. 동적 계획법1

> 기초적인 동적 계획법 문제들을 풀어봅시다.


**Java / Python**

<br><br>

### 8. 1로 만들기
[1463번](https://www.acmicpc.net/problem/1463) 
> 메모이제이션으로 N을 1로 바꾸기 위해 주어진 연산을 몇 번 사용하는지 계산하는 문제

![](https://images.velog.io/images/jini_eun/post/9aec39a6-ef9d-4f21-841b-418c68e55e15/image.png)

> 문제의 테스트 케이스를 보면, <br>
*10의 경우에 10 -> 9 -> 3 -> 1 로 3번 만에 만들 수 있다.*<br>
는 말이 있습니다.<br>
따라서, 단순히 n/3 , n/2 , n-1 순서대로 조건문을 이용해 푸는 것이 아니라, 최솟값을 비교하며 진행되는 형태로 코드를 작성해야 하는 문제였습니다.

<br><br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	static Integer[] DP;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
 
		DP = new Integer[N + 1];
		DP[0] = DP[1] = 0;
 
		System.out.print(calculate(N));
 
	}
 
	static int calculate(int N) {
 
		if (DP[N] == null) {
			if (N % 6 == 0) {
				DP[N] = Math.min(calculate(N - 1), Math.min(calculate(N / 3), calculate(N / 2))) + 1;
			}else if (N % 3 == 0) {
				DP[N] = Math.min(calculate(N / 3), calculate(N - 1)) + 1;
			}else if (N % 2 == 0) {
				DP[N] = Math.min(calculate(N / 2), calculate(N - 1)) + 1;
			}else {    // 2와 3으로 나누어지지 않는 경우
				DP[N] = calculate(N - 1) + 1;
			}
		}
		return DP[N];
	}
}
```


<br><br><br>

- Python 

<br>

> 점화식 : dp(N) = min ( dp(N//3) +1, dp(N//2)+1 , dp(N-1)+1 ) <br>


<br>

```python
import sys
N = int(sys.stdin.readline())
DP = [0 for _ in range(N+1)]

for i in range(2, N+1):
    DP[i] = DP[i-1] + 1  

    if i%2 == 0 and DP[i] > DP[i//2] + 1 :
        DP[i] = DP[i//2]+1
        
    if i%3 == 0 and DP[i] > DP[i//3] + 1 :
        DP[i] = DP[i//3] + 1
        
print(DP[N])
```
<br><br>


---

<br>

