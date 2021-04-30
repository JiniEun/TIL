# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 10. 재귀

Java / Python
<br>

### 3. 별 찍기 -10
[2447번](https://www.acmicpc.net/problem/2447) 
> 재귀적인 패턴을 재귀함수로 찍는 문제 1
>> 재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.<br>
크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.<br>
```
***
* *
***
```
N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
```
***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
*********         *********
* ** ** *         * ** ** *
*********         *********
***   ***         ***   ***
* *   * *         * *   * *
***   ***         ***   ***
*********         *********
* ** ** *         * ** ** *
*********         *********
***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
```

<br><br>

- Java

```java
import java.util.*;

public class Main {
	
	static char arr[][]; //n크기의 2차원 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		arr = new char[num][num];
		
		for(int i=0;i<arr.length;i++) {
			Arrays.fill(arr[i],' ');    // ' '으로 배열 초기화
		}
		star(0,0,num);
        
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}	
	}
    
	public static void star(int x,int y,int n) { // 별 그리는 함수(재귀 함수)
		int div = 0;
		if(n==1) { // 재귀 호출이 끝 부분
			arr[x][y] = '*';
			return;
		}
		
		div= n/3;
		
		for(int i=0;i<3;i++) { // 3x3크기의 별
			for(int j=0;j<3;j++) {
				if(i==1 && j ==1) continue;
				star(x+(div*i),y+(div*j),div); //시작점을 옮김. 예: 27=> (0,0) (0,9) 
			}
		}
	        
	}
}
``` 


<br>

- Python

```python
def stars(n):
    arr=[]
    for i in range(3 * len(n)):
        if i // len(n) == 1:
            arr.append(n[i % len(n)] + " " * len(n) + n[i % len(n)])
        else:
            arr.append(n[i % len(n)] * 3)
    return(list(arr))

star = ["***","* *","***"] # n = 3 일때 ( 가장 작은 형태 기본 모양)
n = int(input())
k = 0
while n != 3:
    n = int(n / 3)
    k += 1
    
for i in range(k):
    star = stars(star)
for i in star:
    print(i)
```
> 이 문제는 프랙탈 도형을 그리는 문제라고 볼 수 있습니다. 프랙탈은 일부 작은 조각이 전체와 비슷한 기하학적 형태로, 최소 단위로 쪼개서, 분할 정복 알고리즘(Divide and Conquer)을 이용해 풀 수 있습니다. 분할 정복 알고리즘의 단계를 분할, 정복, 합치기 세 개로 나누어 비교적 쉽게 풀어낼 수 있습니다. (분할 정복 알고리즘: 문제를 나눌 수 없을 때까지 나누어서 각각 풀면서 다시 합병하여 문제의 답을 얻는 알고리즘)



<br><br><br>

### 4. 하노이 탑 이동 순서
[11729번](https://www.acmicpc.net/problem/11729) 
> 재귀적인 패턴을 재귀함수로 찍는 문제 2
>> 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다. <br>
한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.<br>
아래 그림은 원판이 5개인 경우의 예시이다.
![](https://images.velog.io/images/jini_eun/post/4ab6fea1-a81a-4309-b101-8279c6e49ea5/image.png)

<br><br>

- Java

```java
import java.util.Scanner;
public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 원판의 개수
        sb.append((int) (Math.pow(2, N) - 1)).append('\n');
        Hanoi(N, 1, 2, 3);
        System.out.println(sb);
        sc.close();
    }

    public static void Hanoi(int N, int start, int mid, int dest) {
        // start : 출발, mid : 옮기기 위해 이동해야 장소, dest : 목적지
        // 이동할 원반의 수가 1개 -> 종료
        if (N == 1) {
            sb.append(start + " " + dest + "\n");
            return; 
        }
        // 1 : N-1개 A-> B
        Hanoi(N - 1, start, dest, mid);
        // 2 : 1개를 A-> C
        sb.append(start + " " + dest + "\n");
        // 3 : N-1개 B-> C
        Hanoi(N - 1, mid, start, dest);
    }
}
``` 


<br>

- Python

```python
def hanoi(n, a, b, c):
    if n == 1:
        print(a, c)
    else:
        hanoi(n - 1, a, c, b)
        print(a, c)
        hanoi(n - 1, b, a, c)
        
num = int(input())        
sum = 1
for i in range(num - 1):
    sum = sum * 2 + 1
print(sum)
hanoi(num, 1, 2, 3)
```

<br><br>

---

<br>


> 오늘까지는 재귀함수 예제였습니다!
 
