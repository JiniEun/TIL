# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 8. 기본 수학1

Java / Python
<br>

### 1. 손익분기점
[1712번](https://www.acmicpc.net/problem/1712) 
> 이익이 발생하는 지점을 찾는 문제

> 고정 비용 : A, 가변 비용: B, 판매 비용: C이다.
문제에서 원하는 손익분기점을 구하기 위해서는, 물건의 개수가 n이라면, n X C > A + (n X B) 의 수식을 만족하는 n을 구해야 하는 것입니다.
따라서 n = (A/(C-B)) + 1을 구하는 문제라고 할 수 있습니다.
이를 고려하여 다음과 같이 코드를 작성해보았습니다.

- Java

```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int A = sc.nextInt();	// 고정 비용
		int B = sc.nextInt();	// 가변 비용
		int C = sc.nextInt(); 	// 판매 비용
        
		if (C <= B) {
			System.out.println("-1");
		} 
		else {
			System.out.println((A/(C-B))+1);
		}
        sc.close();
	}
}
``` 

<br>

- Python

```python
A, B, C = list(map(int, input().split()))
BREAK_EVEN_POINT = 0

if(C <= B):
    BREAK_EVEN_POINT = -1
else:
    BREAK_EVEN_POINT = A // (C - B) + 1 
print(BREAK_EVEN_POINT)
```

<br><br>

---

<br>


> 오늘은 기본 수학1 예제였습니다!
