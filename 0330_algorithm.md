# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 14. 동적 계획법1

> 기초적인 동적 계획법 문제들을 풀어봅시다.

**Java / Python**

<br>

### 1. 피보나치 함수
[1003번](https://www.acmicpc.net/problem/1003) 
> 단순 재귀로 피보나치 수를 구하면 왜 느릴까요? 함수 호출의 개수가 기하급수적으로 늘어나기 때문입니다.

![](https://images.velog.io/images/jini_eun/post/ef00afbe-ff56-4506-82c9-035615ba224b/image.png)

![](https://images.velog.io/images/jini_eun/post/8bae9818-bf90-4788-a0b3-dcbfbc102989/image.png)

<br><br><br>

- Java
<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	static Integer[][] dp = new Integer[41][2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp[0][0] = 1;	// N=0 일 때의 0 호출 횟수
		dp[0][1] = 0;	// N=0 일 때의 1 호출 횟수
		dp[1][0] = 0;	// N=1 일 때의 0 호출 횟수
		dp[1][1] = 1;	// N=1 일 때의 1 호출 횟수
		
		int T = Integer.parseInt(br.readLine());	
		StringBuilder sb = new StringBuilder();
		
		while(T --> 0){
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(dp[N][0] + " " + dp[N][1]).append('\n');
		}
		System.out.println(sb);
	}
	
	static Integer[] fibonacci(int N) {
		
		if(dp[N][0] == null || dp[N][1] == null) {    // N - 0, 1의 호출 횟수가 없는 경우(탐색X)
			// 각 N에 대한 0 호출 횟수와 1 호출 횟수를 재귀호출
			dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
			dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
		}
		return dp[N];
 
	}
}
```
> 시간 초과가 나와서 코드 실행시간을 줄이기 위해 BufferedReader와 StringBuilder를 이용했습니다.

<br><br><br>

- Python 

<br>

```python
T = int(input())
for i in range(T):
    n = int(input())
    zero = 1
    one = 0
    cnt = 0
    for _ in range(n):
        cnt = one
        one = one + zero
        zero = cnt
    print(zero, one)
```

<br><br>

---

<br>

