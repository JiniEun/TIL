# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 3. for문

Java / Python
<br>

### 5. N 찍기
[2741번](https://www.acmicpc.net/problem/2741) 
> 1부터 n까지를 출력하는 문제

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
        
		for (int i = 1; i <= num; i++){
			System.out.println(i);
		}	
	}
}
```

<br>

- Python
~~~~python
num = int(input())

for i in range(1, num+1):
    print(i)
~~~~

---


<br><br>

### 6. 기찍 N
[2742번](https://www.acmicpc.net/problem/2742) 
> n부터 1까지 거꾸로 찍는 문제

- Java
~~~java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
        
		for (int i = num; i >= 1; i--){
			System.out.println(i);
		}	
	}
}
~~~


<br>

- Python
```python
num = int(input())

for i in range(num, 0, -1):
    print(i)
```


<br>


---
오늘은 for문 기본 예제입니다!
