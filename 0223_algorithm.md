# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 8. 기본 수학1

Java / Python
<br>

### 8. 큰 수 A+B
[10757번](https://www.acmicpc.net/problem/10757) 

> 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

- Java

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.math.BigInteger;
 
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		BigInteger A = new BigInteger(st.nextToken());
		BigInteger B = new BigInteger(st.nextToken());
		
		A = A.add(B);
		
		System.out.println(A.toString());
	}
}
``` 
> 자바의 경우 큰 수 계산을 위해 Java에서 제공하는 BigInteger 클래스를 이용하는 방식으로 구현했습니다. BigInteger은 java.math안에 있으며, 문자열 형태로 이루어져 있어 숫자의 범위가 무한하기에 어떠한 숫자이든지 담을 수 있습니다.


<br>

- Python

```python
A, B = map(int,input().split())
print(A+B)
```
> 숫자가 지나치게 클 경우 C언어는 메모리에 담지 못하고 에러를 출력하지만 이 문제의 경우 파이썬은 상관이 없어, 기존과 크게 다르지 않게 작성했습니다..!

<br><br>

---

<br>


> 오늘은 기본 수학1 예제였습니다!
이번 예제의 경우 자바는 BigInteger를 이용하고, 파이썬은 10,000자리 정도의 자연수도 자유롭게 다룰 수 있어, 쉽게 작성했으나, c, c++은 직접 구현해서 작성해야 하기 때문에 c++로 작성해보고 코드를 추가해볼 예정입니다..!
