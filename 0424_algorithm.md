# Baekjoon Online Judge

## algorithm practice
<br>

## - 단계별 문제풀기
<br>

## 17. 정수론 및 조합론

> 정수론과 조합론을 배워 봅시다.

<br>

---

<br>

**Java / Python**

<br>

### 5. 검문
[2981번](https://www.acmicpc.net/problem/2981) 
> N개의 수를 M으로 나누었을 때, 나머지가 전부 같은 M을 찾는 문제

<br>

![](https://images.velog.io/images/jini_eun/post/31d5b962-48a8-4ce7-b8cd-fdfab94a9124/image.png)

<br>

> 이번 문제의 key는 'M이 하나 이상 존재하는 경우로만 주어진다'는 것과 '나머지가 모두 같게 되는 M을 찾으려고 한다'라는 점입니다. 즉, M이 공약수라는 뜻으로 볼 수 있습니다.
결국, 최대 공약수를 찾고 최대 공약수와 그 약수들을 구하는 문제입니다.

<br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int N = Integer.parseInt(br.readLine());
        
		int[] arr = new int[N];
        
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);    // 정렬
        
		// 음수가 되지 않도록 큰 수 - 작은 수
		int gcd_val = arr[1] - arr[0];
		
		for(int i = 2; i < N; i++){
			gcd_val = gcd(gcd_val, arr[i] - arr[i - 1]);
		}
        
		// 최대 공약수의 약수들 찾기
		for(int i = 2; i <= gcd_val; i++){
			if(gcd_val % i == 0) System.out.print(i + " ");
		}
        
	}
    
	public static int gcd(int n1, int n2){    // 최대 공약수
		while(n2 != 0){
			int temp = n1 % n2;
			n1 = n2;
			n2 = temp;
		}
		return n1;
	}
}
```


<br><br><br>

- Python 

<br>

```python
def gcd(n1, n2):
    while n2 :
        n1, n2 = n2, n1 % n2
    return n1

import sys
N = int(sys.stdin.readline())
arr = []
for _ in range(N):
    arr.append(int(sys.stdin.readline()))

arr.sort()

gcd_val = arr[1] - arr[0]

for i in range(2, N):
    gcd_val = gcd(gcd_val, arr[i] - arr[i-1])
        
sol = [gcd_val]
for i in range(2, int(gcd_val**0.5)+1):
	if gcd_val % i == 0:
		print(i, end=' ')
		if i != gcd_val//i:
			sol.insert(0, gcd_val//i)
for num in sol:
	print(num, end=' ')
```

<br><br>

---

<br>

