# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 8. 기본 수학1

Java / Python
<br>

### 6. 부녀회장이 될테야
[2775번](https://www.acmicpc.net/problem/2775) 

> 층과 거주자 수의 규칙을 찾는 문제
>>평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다. <br>
이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다. <br>
아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라. 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.

- Java

```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] apt = new int[15][14];
        
		for (int i = 0; i < 14; i++) {
			apt[0][i] = i + 1;
		}
        
		for (int i = 1; i <= 14; i++) {
			for (int j = 0; j < 14; j++) {
				for (int q = 0; q <= j; q++) {
					apt[i][j] += apt[i - 1][q];
				}
			}
		}
		for (int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();

			System.out.println(apt[k][n - 1]);
		}
	}
}
``` 


<br>

- Python

```python
T = int(input())

for i in range(T):
    k = int(input())    # 층
    n = int(input())    # 호
    k0 = [x for x in range(1, n+1)]    # 0층
    for i in range(k):  # 층 수 만큼 반복
        for j in range(1, n):  
            k0[j] += k0[j-1]  
    print(k0[-1])  
```

<br><br>

---

<br>


> 오늘은 기본 수학1 예제였습니다!
규칙을 찾는 게 중요한 것 같습니다!! 
