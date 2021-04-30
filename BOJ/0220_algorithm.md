# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 8. 기본 수학1

Java / Python
<br>

### 5. ACM 호텔
[10250번](https://www.acmicpc.net/problem/10250) 

> 호텔 방 번호의 규칙을 찾아 출력하는 문제
![](https://images.velog.io/images/jini_eun/post/182d3f68-5903-495b-a91b-df804778a3a1/image.png)
손님은 엘리베이터를 타고 이동하는 거리는 신경 쓰지 않는다. 다만 걷는 거리가 같을 때에는 아래층의 방을 더 선호한다. 예를 들면 102 호 방보다는 301 호 방을 더 선호하는데, 102 호는 거리 2 만큼 걸어야 하지만 301 호는 거리 1 만큼만 걸으면 되기 때문이다. 같은 이유로 102 호보다 2101 호를 더 선호한다.
여러분이 작성할 프로그램은 초기에 모든 방이 비어있다고 가정하에 이 정책에 따라 N 번째로 도착한 손님에게 배정될 방 번호를 계산하는 프로그램이다. 첫 번째 손님은 101 호, 두 번째 손님은 201 호 등과 같이 배정한다. 그림 1 의 경우를 예로 들면, H = 6이므로 10 번째 손님은 402 호에 배정해야 한다.

> 01호를 H만큼 다 채우고난 뒤 02호를 H만큼 채우는 방식이기 때문에, 몇 호인지 구하는 방식은 N을 H로 나눈 몫에 1을 더한 값과 같습니다. 그리고 층 수는 N을 H로 나눈 나머지와 같습니다. 다만, 이 때 N%H의 나머지가 0이면 H층, N/H번에 머문다고 볼 수 있어, 조건문을 통해 처리해주었습니다. (4층 짜리 호텔에 4번째 손님(H=4, N=4) 이면 401호인 것과 같음)

- Java

```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
 
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int H = sc.nextInt();
            int W = sc.nextInt();
			int N = sc.nextInt();
            
            int X = N%H, Y = (N/H) + 1;
            if(N % H == 0) {
                Y = N/H;
                X = H;
            }
            System.out.println(X*100+Y);
		}    
	}
}
``` 

> 

<br>

- Python

```python
T = int(input())

for i in range(T):
    H, W, N = map(int, input().split())
    y = N//H+1
    x = N%H
    if x==0 :
        y -= 1
        x = H
    print(x*100+y)
```

<br><br>

---

<br>


> 오늘은 기본 수학1 예제였습니다!
규칙을 찾는 게 중요한 것 같습니다!! 
