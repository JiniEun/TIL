# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 8. 기본 수학1

Java / Python
<br>

### 2. 벌집
[2292번](https://www.acmicpc.net/problem/2292) 
> 벌집이 형성되는 규칙에 따라 벌집의 위치를 구하는 문제
![](https://images.velog.io/images/jini_eun/post/c4be7701-5438-4d53-a982-5c25c1ccaac4/image.png)

> 
num :   1 /  2 ~ 7 /  8 ~ 19 /  ...
갯수 : 1개 /   6개  /   12개  /   ...
출력 :  1 /   2   /    3   /   ...
1을 제외하고 6개마다 방개수가 증가하는 규칙을 찾고, 코드를 작성했습니다.
(등차수열 문제!)

- Java

```java
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
		int cnt = 1; 
		int sum = 6;
        int result = 1; 

		while (true) {
			if (num <= cnt) {
				break;
			}
			cnt += sum;
			sum += 6;
			result++;
		}
		System.out.println(result);
    }
}
``` 

<br>

- Python

```python
num = int(input())
cnt = 1
while num > 1:
    num -= (6 * cnt)
    cnt += 1
print(cnt)
```

<br><br>

---

<br>


> 오늘은 기본 수학1 예제였습니다!
규칙을 찾는 게 중요한 것 같습니다!!
