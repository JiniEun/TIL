# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 9. 기본 수학2

Java / Python
<br>

### 4. 소수 구하기 
[1929번](https://www.acmicpc.net/problem/1929) 

> 에라토스테네스의 체로 풀어 봅시다.
>> 에라토스테네스의 체란 간단하게 말해서, 일정 범위내 수열에서 배수들을 제거해 소수만 남기는 방법이다.
예를 들어) 수열 [2 3 4 5 6 7 8 9 10] 에서 2의 배수 제거
=> [2 3 5 7 9] 에서 3의 배수 제거
=> [2 3 5 7] 와 같은 방식이다.
즉, 말그대로 체로 걸러서 소수만 남기는 원리이다.

<br>

- Java

```java
import java.util.Scanner;
 
 
public class Main {
	public static boolean[] prime;
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		prime = new boolean[N + 1];
		is_prime();
				
		for(int i = M; i <= N; i++) {
			// false = 소수 
			if(!prime[i]) System.out.println(i);
		}
	}
 
 
	// 에라토스테네스의 체
	public static void is_prime() {
		// true = 소수X , false = 소수
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
}
``` 

<br>

- Python

```python
M, N = map(int, input().split())

def is_prime(m, n):
    n += 1                               # for문 사용을 위한 N 증가
    prime = [True] * n                   # N개의 True가 있는 리스트 생성
    for i in range(2, int(n**0.5)+1):    # 범위 : N의 제곱근까지
        if prime[i]:                      # if prime[i] == True
            for j in range(2*i, n, i):    # prime 내 i의 배수들을 False로 변환
                prime[j] = False

    for i in range(m, n):
        if i > 1 and prime[i] == True:    # 소수 출력
            print(i)

is_prime(M, N)
```

<br><br>

---

<br>


> 오늘은 기본 수학2 예제였습니다!
소수를 구하기 위해 에라토스테네스의 체에 대해 공부하고, 구현 방법에 대해 검색해보고 참고하며 구현할 수 있었던 것 같습니다..!
