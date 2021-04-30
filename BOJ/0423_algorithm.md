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

### 4. 최소공배수
[1934번](https://www.acmicpc.net/problem/1934) 
> 유클리드 알고리즘으로 더 빠르게 푸는 문제

<br>

![](https://images.velog.io/images/jini_eun/post/89fc6575-f047-4d5d-9c3e-62899f852b41/image.png)

<br>

> 두 개의 자연수를 입력받아 최소 공배수를 출력하는 문제로, 유클리드 알고리즘을 이용하는 문제입니다. <br>
*유클리드 호제법 (Euclidean algorithm)이란*
2개의 자연수 또는 정식(整式)의 최대공약수를 구하는 알고리즘의 하나이며, 정리는 다음과 같습니다.
![](https://images.velog.io/images/jini_eun/post/33b2dab1-590a-4c42-a2fb-60feb4e5e633/image.png)

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
		StringTokenizer st;
        
		while(T-- > 0){
			st = new StringTokenizer(br.readLine(), " ");
        
			int number1 = Integer.parseInt(st.nextToken());
			int number2 = Integer.parseInt(st.nextToken());
			int result1 = gcd(number1, number2);
		
			System.out.println(number1 * number2 / result1);
		}
	}
    
	public static int gcd(int n1, int n2){    // 최대 공약수
		if(n2 == 0) return n1;
		return gcd(n2, n1 % n2);
	}
}
```


<br><br><br>

- Python 

<br>

```python
import sys
T = int(sys.stdin.readline())

# gcd
def gcd(n1, n2):
    if n2 == 0 : 
        return n1
    else : 
        return gcd(n2, n1 % n2)
    
while T > 0 :  
    num1, num2 = map(int, sys.stdin.readline().split())
    result = gcd(num1, num2)
    # 최소공배수
    print(num1 * num2 // result)
    T -= 1
```

<br><br>

---

<br>

