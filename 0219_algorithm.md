# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 8. 기본 수학1

Java / Python
<br>

### 4. 달팽이는 올라가고 싶다
[2869번](https://www.acmicpc.net/problem/2869) 

> 달팽이의 움직임을 계산하는 문제
>> 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

> A : 올라가는 높이, B : 내려가는 높이, V : 총 높이

- Java

```java
import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int day = (V - B) / (A - B);    
		if ((V-B) % (A-B) != 0) {
			day++;
		}
		System.out.println(day);
	}
}
``` 

> 시간제한으로 코드 수행시간이 짧아야 하는 문제이기 때문에, BufferedReader 을 쓰는 방식을 이용했습니다.
br.readLine()으로 문자열로 데이터를 읽으며, StringTokenizer로 문자열 분리 후 해당 토큰을 꺼내서 쓸 때 int 형으로 이용하기 위해, Integer.parseInt() 함수를 이용하여 String 형을 int 형으로 변환시켜주었습니다.

<br>

- Python

```python
import math
A, B, V = map(int,input().split())
print(math.ceil((V-A)/(A-B)) + 1)
```

> 하루동안 A-B의 높이를 올라간다고 볼 수 있고, 올라가는 높이를 식으로 구해보면, (A-B)*n + A = V와 같습니다. a만큼 올라가고 b만큼 떨어지는 것을 n만큼 반복하고 마지막 날에는 a만큼 올라간 후에는 더 이상 떨어지지 않기 때문입니다.
따라서 구하려는 n을 기준으로 식을 변환하면, (V-A) / (A-B)로 바꿀 수 있습니다. (단, 마지막으로 a만큼 올라간 하루가 계산에서 빠지기 때문에 +1을 해줄 수 있다.)

> python의 경우 math의 ceil 함수를 이용 : 소수를 올림 하는 정수를 반환하는 함수

<br><br>

---

<br>


> 오늘은 기본 수학1 예제였습니다!
규칙을 찾는 게 중요한 것 같습니다!! 이번 문제의 경우 시간초과도 고려해야 하는 문제였습니다. 코드를 작성할 때, 빠르게 수행되는 방법도 항상 생각해봐야 할 것 같습니다..!
