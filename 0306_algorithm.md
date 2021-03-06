# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 9. 기본 수학2

Java / Python
<br>

### 11. 터렛
[1002번](https://www.acmicpc.net/problem/1002) 
> 두 원의 교점의 개수를 구하는 문제
>> 조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다.<br>
이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.<br>
조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때, 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.

<br><br>

- Java

```java
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();

			double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1,2));
            
			if(x1==x2&&y1==y2&&r1==r2) System.out.println(-1);
			else if(d==r1+r2||Math.abs(r1-r2)==d)
				System.out.println(1);
			else if(d>r1+r2||x1==x2&&y1==y2&&r1!=r2||d<Math.abs(r1-r2))
				System.out.println(0);
			else System.out.println(2);
		}
	}
}

``` 


<br>

- Python

```python

```


<br><br>

---

<br>


> 오늘은 기본 수학2 예제였습니다!
