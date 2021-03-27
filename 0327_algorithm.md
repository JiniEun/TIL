# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 13. 백트래킹

> 모든 경우를 탐색하는 백트래킹 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 6. 스도쿠
[2580번](https://www.acmicpc.net/problem/2580) 
> 조금 더 복잡한 백트래킹 문제 2

![](https://images.velog.io/images/jini_eun/post/01d391c4-18a1-4b97-827a-41c84474223e/image.png)

스도쿠의 숫자를 채우기 위한 중복 검사 순서는 다음과 같다.
1. 같은 행에 있는 열 원소 중에 겹치는 수가 있는지 검사
2. 같은 열에 있는 행 원소 중에 겹치는 수가 있는지 검사
3. 같은 3×3 칸에 중복되는 수가 있는지 검사
( 3×3의 위치는 9×9 사이즈에서 3개로 나누면 총 9칸 )

<br><br>

- Java
<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static int[][] arr = new int[9][9];
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열 분리 StringTokenizer 이용
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sudoku(0, 0);
	}
 
	public static void sudoku(int row, int col) {

		// 현재 row가 다 채워진 경우, 다음 row의 첫 col부터 시작
		if (col == 9) {
			sudoku(row + 1, 0);
			return;
		}
 
		// row, col 다 채워진 경우 출력 후, 종료
		if (row == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}
 
		// 1부터 9까지 중 가능한 수 탐색
		if (arr[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (Check(row, col, i)) {    // i 값 중복 검사
					arr[row][col] = i;
					sudoku(row, col + 1);
				}
			}
			arr[row][col] = 0;
			return;
		}
		sudoku(row, col + 1); // 다음 열 재귀 호출
	}
 
	public static boolean Check(int row, int col, int value) {
 
		// 같은 행에 겹치는 열 원소 검사
		for (int i = 0; i < 9; i++) {
			if (arr[row][i] == value) {
				return false;
			}
		}
 
		// 같은 열에 겹치는 행 원소 검사
		for (int i = 0; i < 9; i++) {
			if (arr[i][col] == value) {
				return false;
			}
		}
 
		// 3*3 칸 중복 검사
		int set_row = (row / 3) * 3;
		int set_col = (col / 3) * 3;
 
		for (int i = set_row; i < set_row + 3; i++) {
			for (int j = set_col; j < set_col + 3; j++) {
				if (arr[i][j] == value) {
					return false;
				}
			}
		}
		return true; // 중복되는 것이 없을 경우
	}
 
}
```



<br><br>

- Python (PyPy3)

> Python의 경우 이번 예제에서 거의 계속 시간 초과의 문제가 있었습니다. 찾아보니, PyPy3가 일부 Python 프로그램의 경우 몇 배나 빠른 Python 인터프리터 대체 도구로, Python으로 계속 시간초과가 된다면, PyPy3를 이용하라는 말이 많아서, PyPy3로 언어를 설정하고 수행했습니다.


<br>

```python
import sys

# 행 체크
def RowCheck(x, val):
    if val in sudoku[x]:
        return False
    return True

# 열 체크
def ColCheck(y, val):
    for i in range(9):
        if val == sudoku[i][y]:
            return False
    return True

# 3x3 체크
def Bythree(x, y, val):
    nx = x//3 * 3
    ny = y//3 * 3
    for i in range(3):
        for j in range(3):
            if val == sudoku[nx+i][ny+j]:
                return False
    return True


def DFS(index):
    if index == len(zeros):
        for row in sudoku:
            for n in row:
                print(n, end=" ")
            print()
        sys.exit(0)
    else:
        for i in range(1, 10):
            nx = zeros[index][0]
            ny = zeros[index][1]
            # 숫자 중복 검사
            if RowCheck(nx, i) and ColCheck(ny, i) and Bythree(nx, ny, i):
                sudoku[nx][ny] = i
                DFS(index+1)
                sudoku[nx][ny] = 0


sudoku = [list(map(int, sys.stdin.readline().split())) for _ in range(9)]
zeros = [(i, j) for i in range(9) for j in range(9) if sudoku[i][j] == 0]
DFS(0)
```

<br><br>

---

<br>

