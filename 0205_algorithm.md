# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 3. for문

Java / Python
<br>

### 7. A + B -7
[11021번](https://www.acmicpc.net/problem/11021) 
> 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하는 문제

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println("Case #"+i+": "+(a+b));
            
		}      
		sc.close();
	}
}
```

<br>

- Python
~~~~python
num = int(input())

for i in range(num):
    a, b = input().split()
    a = int(a)
    b = int(b)
    print("Case #%s: %s"%(i+1,a+b))
~~~~

---


<br><br>

### 8. A + B - 8
[11022번](https://www.acmicpc.net/problem/11022) 
> 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하는 문제

- Java
~~~java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println("Case #"+i+": "+a+" + "+b+" = "+(a+b));
            
		}      
		sc.close();
	}
}
~~~


<br>

- Python
```python
num = int(input())

for i in range(num):
    a, b = input().split()
    a = int(a)
    b = int(b)
    print("Case #%s: %s + %s = %s"%(i+1, a, b, a+b))
```


<br>


---
오늘은 for문 기본 예제입니다! 지난번 예제 A + B 예제에서 조금 다른 형태로 출력하는 문제입니다.
