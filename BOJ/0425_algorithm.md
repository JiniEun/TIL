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

### 6. 링
[3036번](https://www.acmicpc.net/problem/3036) 
> 첫번째 링을 한 바퀴 돌렸을 때, 나머지 링이 몇 바퀴 도는지 구하는 문제

<br>

![](https://images.velog.io/images/jini_eun/post/61efdeea-0ced-4f44-8afd-70aa835369f9/image.png)

<br>

> 이번 문제는 첫 번째 링을 한 바퀴 돌리면, 나머지 링은 몇바퀴 돌아가는 지 출력하면 되는데, 기약분수 형태로 출력하면 되기 때문에, 반지름만 가지고 분모와 분자의 최대 공약수로 나눠주면 되는 문제입니다. 

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
 
		int N = Integer.parseInt(br.readLine());
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 		
		int ring1 = Integer.parseInt(st.nextToken());    // 첫 번째 링
 
		for (int i = 1; i < N; i++) {
			
			// 다른 링
			int rings = Integer.parseInt(st.nextToken());
			
			// 기약분수로 만들기 위해 최대공약수 찾기
			int gcd = gcd(ring1, rings);
 
			// 분모와 분자를 최대공약수로 나누기 
			System.out.println((ring1 / gcd) + "/" + (rings / gcd));
		}
 
	}
	// 최대 공약수 구하는 함수
	static int gcd(int x, int y) {
		int temp;
		while (y != 0) {
			temp = x % y;
			x = y;
			y = temp;
		}
		return x;
	}
}
```


<br><br><br>

- Python 

<br>

```python
import sys

def gcd(n1, n2):
    while n2 :
        n1, n2 = n2, n1 % n2
    return n1

N = int(sys.stdin.readline())
rings = list(map(int,  sys.stdin.readline().split()))
for i in range(1, N):
    gcd_val = gcd(rings[0], rings[i])
    print('{0}/{1}'.format(rings[0]//gcd_val, rings[i]//gcd_val))
```

<br><br>

---

<br>

