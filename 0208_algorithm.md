# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 5. 1차원 배열

Java / Python
<br>

### 4. 나머지
[3052번](https://www.acmicpc.net/problem/3052) 
> 수를 42로 나누었을 때, 서로 다른 나머지가 몇 개 있는지 출력하는 문제

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		int arr[] = new int[10];
		int count = 0;
		int counts[] = new int[42];
        
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
        
		for (int i = 0; i < arr.length; i++){
			counts[arr[i]%42]++;
		}
		for (int i = 0; i < counts.length; i++){
			if(counts[i] != 0){
				count++;
			}
		}
		System.out.println(count);
	}
}
```

<br>

- Python

```python
nlist = []
for _ in range(10):
    num = int(input())
    nlist.append(num % 42)
nlist = set(nlist)
print(len(nlist))
```
<br>

---


<br><br>

### 5. 평균
[1546번](https://www.acmicpc.net/problem/1546) 
> 평균을 조작하는 문제

- Java
```java


```

<br>

- Python

```python

```

<br><br>

---
<br>

> 오늘은 1차원 배열 문제입니다!
1차원 배열을 잘 응용할 수 있다면 충분히 풀 수 있는 문제들인 것 같습니다!
