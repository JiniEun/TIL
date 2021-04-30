# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 11. 브루트 포스

> 가장 간단한 알고리즘인, 모든 경우의 수를 검사하는 브루트 포스 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 4. 체스판 다시 칠하기
[1018번](https://www.acmicpc.net/problem/2231) 
> 체스판을 만드는 모든 경우를 시도하여 최적의 방법을 찾는 문제
>> 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 MxN 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8x8 크기의 체스판으로 만들려고 한다. <br>
체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.<br>
보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8x8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 당연히 8x8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

<br><br>

- Java

```java
import java.util.Scanner;
 
public class Main {
    private static char[][] BOARD;
    private static char[][] WnB;
    
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		WnB = new char[2][8];
        // toCharArray(): 문자열을 char형 배열로 변환
		WnB[0] = "WBWBWBWB".toCharArray(); 
		WnB[1] = "BWBWBWBW".toCharArray();
		
		BOARD = new char[n][m];
		for(int i = 0; i < n; i++) {
		    BOARD[i] = sc.nextLine().toCharArray();
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n - 7; i++) {
		    for(int j = 0; j < m - 7; j++) {
		        min = Math.min(min, draw(i, j));
		    }
		}
		System.out.println(min);
    }
    
    private static int draw(int y, int x) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < WnB.length; i++) {
            int cnt = 0;
            for(int j = 0; j < WnB[0].length; j++) {
                for(int k = 0; k < WnB[0].length; k++) {
                    if(BOARD[y+j][x+k] != WnB[(i+j)%2][k]) {
                        cnt++;
                    }
                }
            }
            min = Math.min(min, cnt);
        }
        return min;
    }
}
``` 
> W로 시작할 때, B로 시작할 때를 먼저 한 줄에 저장하고
draw함수를 통해 조건에 따라 작성하도록 했습니다..

<br><br>

- Python

```python
n, m = map(int, input().split())
board = []
min_value = []

for _ in range(n):
    board.append(input())

for a in range(n - 7):
    for i in range(m - 7):
        start_W = 0
        start_B = 0
        for b in range(a, a + 8):
            for j in range(i, i + 8):              # 8X8 범위를 B와 W로 번갈아가면서 검사
                if (j + b)%2 == 0:
                    if board[b][j] != 'W': start_W += 1  
                    if board[b][j] != 'B': start_B += 1
                else :
                    if board[b][j] != 'B': start_W += 1
                    if board[b][j] != 'W': start_B += 1
        min_value.append(start_W)                          # W로 시작했을 때 칠해야 할 부분
        min_value.append(start_B)                          # B로 시작했을 때 칠해야 할 부분

print(min(min_value))                                   # 칠해야 하는 개수의 최소값
```
> 8X8범위만큼 가능한 모든 경우의 수를 검사하는 방향으로 코드를 작성했습니다..

<br><br>

---

<br>
