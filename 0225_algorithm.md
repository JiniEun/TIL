# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 9. 기본 수학2

Java / Python
<br>

### 1. 소수 찾기 
[1978번](https://www.acmicpc.net/problem/1978) 

> 2부터 X-1까지 모두 나눠서 X가 소수인지 판별하는 문제 1

<br>

- Java

```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			
			boolean isPrime = true;
			
			int num = sc.nextInt();
			
			if(num != 1) { 
			    for(int j = 2; j <= Math.sqrt(num); j++) {
			    	if(num % j == 0) {
			    		isPrime = false;	
			    		break;
			    	}
		    	}
		    	if(isPrime) {	
		    		cnt++;
		    	}
			}else{}
		}
		System.out.println(cnt);
	} 
}
``` 

<br>

- Python

```python
n = int(input())
numbers = map(int, input().split())
cnt = 0
for num in numbers:
    err = 0
    if num > 1 :
        for i in range(2, num): 
            if num % i == 0:
                err += 1  
        if err == 0:
            cnt += 1
print(cnt)
```

<br><br>

---

<br>


> 오늘은 기본 수학2 예제였습니다!
