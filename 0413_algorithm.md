# Baekjoon Online Judge

## algorithm practice
<br>

## - 단계별 문제풀기
<br>

## 15. 동적 계획법1 

> 기초적인 동적 계획법 문제들을 풀어봅시다.

<br>

---

<br>

**Java / Python**

<br>

### 15. 연속합
[1912번](https://www.acmicpc.net/problem/1912) 
> 가장 큰 연속합을 구하는 문제

<br>

![](https://images.velog.io/images/jini_eun/post/8cfcd719-69fc-4f16-b4b4-bd578841a275/image.png)

<br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    
	static Integer[] dp;
	static int[] nums;
	static int max;
    
	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
        
		dp = new Integer[N];
		nums = new int[N];
        
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
        
		dp[0] = nums[0];    //index 0 값은 첫 원소로 탐색할 것 X
		max = nums[0];
		
		repeat(N - 1);    // dp의 마지막 index N-1부터 Top-Down 탐색 
		
		System.out.println(max);
        
	}
    
	static int repeat(int N) {
 
		// 탐색하지 않은 인덱스의 경우
		if(dp[N] == null) {
 
			// (이전 배열의 누적합 + 현재 값)과 현재 값을 비교-> 최댓값 N위치에 저장
			dp[N] = Math.max(repeat(N - 1) + nums[N], nums[N]);
		    
			max = Math.max(dp[N], max);
		}	
		return dp[N];
	}  
    
}
```


<br><br><br>

- Python 

<br>

```python
import sys 
N  = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
dp = [nums[0]]

for i in range(len(nums) - 1):
    dp.append(max(dp[i] + nums[i + 1], nums[i + 1]))
    
print(max(dp))
```
<br><br>


---

<br>

