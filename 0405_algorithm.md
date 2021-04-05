# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 14. 동적 계획법1

> 기초적인 동적 계획법 문제들을 풀어봅시다.


**Java / Python**

<br><br>

### 7. 계단 오르기
[2579번](https://www.acmicpc.net/problem/2579) 
> i번째 계단에 오를 때, 몇 개의 연속한 계단을 올랐는지를 고려하여 부분문제를 정의해봅시다.

![](https://images.velog.io/images/jini_eun/post/f3bd0f02-5074-4c69-8531-d0a3a781eca9/image.png)

<br><br><br>

- Java

<br>

> Bottom-Up 방법(반복문 이용)입니다. 계단 1층부터 하나씩 값을 더해가면서 채워나가 마지막 계단에서 누적 된 합을 구하면 되는 문제인데,
현재 인덱스 i 에 대해 두 칸 전(i - 2)의 '메모이제이션 값'과 첫 칸 전(i - 1)의 값 + 셋 째칸 전(i - 3)의 '메모이제이션 값' 중 큰 값을 현재 i 계단의 값과 합하여 DP배열에 저장(Memoization)을 하는 방식을 이용했습니다.

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];    // 계단 점수 입력 받을 배열
		int[] DP = new int[N + 1];
		
 
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
 
		// index = 0 = 시작점
		DP[1] = arr[1];
		
		// N = 1이 입력될 수도 있어서 예외처리
		if (N >= 2) {
			DP[2] = arr[1] + arr[2];
		}
 
		for (int i = 3; i <= N; i++) {
			DP[i] = Math.max(DP[i - 2] , DP[i - 3] + arr[i - 1]) + arr[i];
		}
 
		System.out.println(DP[N]);
	}
}
```


<br><br><br>

- Python 

<br>

```python
import sys

N = int(sys.stdin.readline())
DP = [0 for _ in range(N+3)]
arr = [0 for _ in range(N+3)]

for i in range(1,N+1):
    arr[i] = int(sys.stdin.readline())

DP[1] = arr[1]
DP[2] = arr[1] + arr[2]
DP[3] = max(arr[1] + arr[3] ,arr[2] + arr[3])

# DP[i-2] + arr[i] : i칸을 밟기 전의 칸이 i-2이므로 3칸 연속 X
# dp[i-3] + arr[i-1] + arr[i] 
# 한칸 전의 dp가 아닌, 3칸 전의 dp로 이동시킨뒤에 마지막칸은 셀프로 더해, 3칸 연속 가능성 제외
for i in range(4, N+1):
    DP[i] = max(DP[i-3] + arr[i-1] + arr[i] ,  DP[i-2] + arr[i] ) 
    
print(DP[N])
```
<br><br>


---

<br>

