# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 15. 동적 계획법1

> 기초적인 동적 계획법 문제들을 풀어봅시다.


**Java / Python**

<br><br>

### 10. 포도주 시식
[2156번](https://www.acmicpc.net/problem/2156) 
> 규칙에 따라 포도주를 마실 때, 최대로 마실 수 있는 포도주의 양을 구하는 문제

![](https://images.velog.io/images/jini_eun/post/8323d649-b52a-4d21-a746-22d92f8b6fc7/image.png)

<br><br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
        
		int[] DP = new int[N + 1];
		int[] arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
 
		DP[1] = arr[1];
        
		if (N > 1) {
			DP[2] = arr[1] + arr[2];    //DP[2] 같은 경우는 첫 번째와 두 번째를 합한 값 = 최댓값
		}
		for (int i = 3; i <= N; i++) {
			DP[i] = Math.max(DP[i - 1], Math.max(DP[i - 2] + arr[i], DP[i - 3] + arr[i - 1] + arr[i]));
 
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
arr = [0]
DP = [0]
for i in range(N):
    arr.append(int(sys.stdin.readline()))

DP.append(arr[1])
        
if N > 1:
    DP.append(arr[1] + arr[2])
for i in range(3, N + 1):
    DP.append(max(DP[i - 1], DP[i - 3] + arr[i - 1] + arr[i], DP[i - 2] + arr[i]))
        
print(DP[N])
```
<br><br>


---

<br>

