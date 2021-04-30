# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 15. 동적 계획법1

> 기초적인 동적 계획법 문제들을 풀어봅시다.


**Java / Python**

<br><br>

### 12. 가장 긴 바이토닉 부분 수열
[11054번](https://www.acmicpc.net/problem/11054) 
> LIS 응용 문제 1

![](https://images.velog.io/images/jini_eun/post/53136349-0409-4216-82db-f0c5bf89acd6/image.png)

> **바이토닉 수열**이란, 
길이 N의 수열 S의 특정 수 S<sub>k</sub>를 기준으로
S<sub>1</sub> < S<sub>2</sub> < ... < S<sub>k-1</sub> < S<sub>k</sub> > S<sub>k+1</sub> > ... > S<sub>N</sub>
를 만족하는 수열을 의미합니다.
즉, 한 값을 기준으로 왼쪽은 증가하는 수열이고 오른쪽은 감소하는 수열을 이루는 형태입니다.

<br><br><br>

- Java

<br>

> LIS(최장 증가 부분수열)와 LDS(최장 감소 부분수열)를 이용하여 순방향(LIS)과 역방향(LDS)의 오름차순 부분수열을 구하는 방식입니다.

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	
	static int[] nums;
	static Integer[] LIS_DP;
	static Integer[] LDS_DP;
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		LIS_DP = new Integer[N];
		LDS_DP = new Integer[N];
        
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			LIS(i);
			LDS(i);
		}
		
		int max = -1;
        
		for(int i = 0; i < N; i++) {
			max = Math.max(max, LIS_DP[i] + LDS_DP[i]);
		}
		System.out.println(max - 1);
	}
    
	static int LIS(int N) {
		// 탐색하지 않던 위치 
		if(LIS_DP[N] == null) {
			LIS_DP[N] = 1;	// 1로 초기화 
			
			// N-1 부터 0까지 중에서 N보다 작은 값들을 찾으면서 재귀호출. 
			for(int i = N - 1; i >= 0; i--) {
				if(nums[i] < nums[N]) {
					LIS_DP[N] = Math.max(LIS_DP[N], LIS(i) + 1);
				}
			}
		}
		return LIS_DP[N];
	}
    
	static int LDS(int N) {	
		// 탐색하지 않던 위치
		if (LDS_DP[N] == null) {
			LDS_DP[N] = 1; // 1로 초기화
 
			// N 이후값들 노드들 탐색
			for (int i = N + 1; i < LDS_DP.length; i++) {
			    // nums[N]의 값보다 작은 걸 발견했을 경우
			    if (nums[i] < nums[N]) {
				    LDS_DP[N] = Math.max(LDS_DP[N], LDS(i) + 1);
			    }
		    }
	    }
	    return LDS_DP[N];
	}
}
```


<br><br><br>

- Python 

<br>

```python
import sys
N = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
inc = [1 for i in range(N)]
dec = [1 for i in range(N)]
result = [0 for i in range(N)]

for i in range(N):
    for j in range(i):
        if nums[i] > nums[j]:
            inc[i] = max(inc[i], inc[j]+1)


for i in range(N-1, -1, -1):
    for j in range(N-1, i, -1):
        if nums[i] > nums[j]:
            dec[i] = max(dec[i], dec[j]+1)

for i in range(N):
    result[i] = inc[i] + dec[i] -1 

print(max(result))
```
<br><br>


---

<br>

