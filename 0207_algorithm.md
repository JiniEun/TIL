# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 5. 1차원 배열

Java / Python
<br>

### 1. 최소, 최대
[10818번](https://www.acmicpc.net/problem/10818) 
> 최솟값과 최댓값을 찾는 문제

- Java
```java
import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		int num = sc.nextInt();
		int[] arr = new int[num];
        
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
        
		Arrays.sort(arr);
		System.out.print(arr[0] + " " + arr[num - 1]);
	}
}
```

<br>

- Python

```python
num = int(input())
arr = list(map(int,input().split()))
print('{} {}'.format(min(arr),max(arr)))
```
<br>

---


<br><br>

### 2. 최댓값
[2562번](https://www.acmicpc.net/problem/2562) 
> 최댓값이 어디에 있는지 찾는 문제

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9];
		int max = 0;
		int index = 0;
        
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
            
			if(arr[i] > max){
				max = arr[i];
				index = i+1;
			}
		}
		sc.close();
   
		System.out.println(max);
		System.out.println(index);
	}
}
```

<br>

- Python

```python
nlist = []
for i in range(9):
    nlist.append(int(input()))
    
print(max(nlist))
print(nlist.index(max(nlist))+1)
```

<br>

---

<br><br>

### 3. 숫자의 개수
[2577번](https://www.acmicpc.net/problem/2577) 
> 각 숫자가 몇 번 나왔는지 저장하기 위해 일차원 배열을 만드는 문제

- Java
```java

```

<br>

- Python

```python

```
> 

<br><br>

---
> 오늘은 1차원 배열 문제입니다!
