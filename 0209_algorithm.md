# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 5. 1차원 배열

Java / Python
<br>

### 6. OX 퀴즈
[8958번](https://www.acmicpc.net/problem/8958) 
> OX 퀴즈의 결과를 일차원 배열로 입력받아 점수를 계산하는 문제

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String arr[] = new String[sc.nextInt()];
 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		sc.close();
		
		for (int i = 0; i < arr.length; i++) {
			int cnt = 0;	
			int sum = 0;	
			
			for (int j = 0; j < arr[i].length(); j++) {
				
				if (arr[i].charAt(j) == 'O') {
					cnt++;
				} 
				else {
					cnt = 0;
				}
				sum += cnt;
			}
			System.out.println(sum);
		}
	}
}
```

<br>

- Python

```python
num = int(input())
for i in range(num):
    g = str(input())
    nsum = 0
    cnt = 0
    for j in list(g):
        if j =='O':
            cnt += 1
        else:
            cnt = 0
        nsum += cnt
    print(nsum)
```
<br>

---


<br><br>

### 7. 평균은 넘겠지
[4344번](https://www.acmicpc.net/problem/4344) 
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

> 오늘은 1차원 배열단계 문제 마지막입니다!
1차원 배열을 잘 응용할 수 있다면 충분히 풀 수 있는 문제들인 것 같습니다!
