# Baekjoon Online Judge

## algorithm practice
<br>

## - 단계별 문제풀기
<br>

## 16. 그리디 알고리즘(Greedy Algorithm)

> 특정 상황에서 성립하는 그리디 알고리즘을 배워 봅시다.

<br>

---

<br>

**Java / Python**

<br>

### 3. ATM
[11399번](https://www.acmicpc.net/problem/11399) 
> 기다리는 시간의 합을 최소화하는 문제

<br>

![](https://images.velog.io/images/jini_eun/post/a866225e-c859-4d06-9f0b-53a96b26f810/image.png)

<br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int pre = 0;
		int sum = 0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
        
		Arrays.sort(arr);
        
		for(int i = 0; i < N; i++){
			sum += pre + arr[i];    // 이전 대기시간 + 현재 사람 걸리는 시간
			pre += arr[i];    // 누적합 + 현재 걸리는 시간 
		}
		System.out.println(sum);      
	}
}
```


<br><br><br>

- Python 

<br>

```python
import sys
N = int(sys.stdin.readline())
arr = list(map(int, input().split()))
sum_n = 0  
pre = 0
arr.sort()

for i in range(N):
    sum_n += pre + arr[i]    # 이전 대기시간 + 현재 사람 걸리는 시간
    pre += arr[i]    # 누적합 + 현재 걸리는 시간
    
print(sum_n)
```

<br><br>

---

<br>

