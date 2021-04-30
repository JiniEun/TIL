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

### 2. 약수
[1037번](https://www.acmicpc.net/problem/1037) 
> 약수의 성질을 활용하는 문제

<br>

![](https://images.velog.io/images/jini_eun/post/f6cac301-8430-44a3-9d93-d5804c08eb35/image.png)

<br>

> 이번 문제는 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 문제입니다.
따라서 입력되는 약수 중 최솟값과 최대값을 곱해서 N을 구하는 방식으로 작성했습니다.

<br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
        
		int min = Integer.MAX_VALUE;
		int max = -1;
        
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
  
		while(T-- > 0){
			int n = Integer.parseInt(st.nextToken()); 
			if(n > max) max = n;
			if(n < min) min = n;
		}
		System.out.println(max * min);   
	}
}
```


<br><br><br>

- Python 

<br>

```python
import sys
T = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
max_num = max(A)
min_num = min(A)
print(max_num * min_num)
```

<br><br>

---

<br>

