# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 3. for문

Java / Python
<br>

### 9. 별 찍기 -1
[2438번](https://www.acmicpc.net/problem/2438) 
> 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++){
			for (int j = 1; j <= i; j++){
				System.out.print("*");
			}
			System.out.println();
		}      
		sc.close();
	}
}
```

<br>

- Python

방법 1
```python
num = int(input())

for i in range(1, num+1):
    for j in range(i):
        print("*", end="")
    print()
```
    
방법 2
```python
num = int(input())

for i in range(1, num+1):
    print("*"*i)
```

---


<br><br>

### 10. 별 찍기 -2
[2439번](https://www.acmicpc.net/problem/2439) 
> 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제 
(단, 오른쪽 정렬)

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++){
			for (int j = 1; j <= num-i; j++){
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++){
				System.out.print("*");
			}
			System.out.println();
		}      
		sc.close();
	}
}
```


<br>
- Python

방법 1
```python
num = int(input())

for i in range(1, num+1):
    for j in range(num-i):
        print(" ", end="")
    for j in range(i):
        print("*", end="")
    print()
```
    
방법 2
```python
num = int(input())

for i in range(1, num+1):
    print(" "*(num-i), end="")
    print("*"*i)
```
<br>


---
오늘은 for문을 이용한 별 찍기 문제입니다. 이중 for문을 활용할 수 있는 지 확인하는 문제같습니다.
