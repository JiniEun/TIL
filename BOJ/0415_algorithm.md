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

### 1. 동전 0
[11047번](https://www.acmicpc.net/problem/11047) 
> 동전의 조건이 특별해서 동적 프로그래밍보다 빠르게 답을 찾을 수 있는 문제

<br>

![](https://images.velog.io/images/jini_eun/post/b300dd9e-47b1-4013-865f-0c34a282f51d/image.png)

<br>

> **Greedy Algorithms(탐욕법, 탐욕 알고리즘)이란**
문제를 해결하는 과정에서 그 순간순간마다 최적이라고 생각되는 결정을 하는 방식으로 진행하여 최종 해답에 도달하는 문제 해결 방식입니다.
그리디 알고리즘에서 중요한 점은 "그리디 알고리즘은 항상 최적의 해를 도출해내는 것은 아니다"라는 점입니다.

<br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N];
		
		for(int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
 
		for(int i = N - 1; i >= 0; i--) {
			
			if(coin[i] <= K) {    // 현재 동전의 가치가 K보다 작거나 같은 경우				
				count += (K / coin[i]);    // 현재 가치의 동전으로 구성할 수 있는 개수를 더한다.
				K = K % coin[i];
			}
		}
		System.out.println(count);
	} 
}
```


<br><br><br>

- Python 

<br>

```python
import sys
N,K = map(int,sys.stdin.readline().split())
coin = [int(sys.stdin.readline()) for _ in range(N)]
cnt = 0

for i in range(N - 1, -1, -1):
    if coin[i] <= K:
        cnt = cnt + K // coin[i]
        K = K % coin[i]
		
print(cnt)
```

<br><br>

---

<br>

