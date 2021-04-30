# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 13. 백트래킹

> 모든 경우를 탐색하는 백트래킹 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 5. N-Queen
[9663번](https://www.acmicpc.net/problem/9663) 
> 조금 더 복잡한 백트래킹 문제 1
>> ![](https://images.velog.io/images/jini_eun/post/8310731b-b20d-40b3-af5e-132b2b87ff32/image.png)


<br><br>

- Java
<br>

```java
import java.util.Scanner;
 
public class Main {
	public static int N;
	public static int[] arr;
	public static int result = 0;
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		sc.close();
		nQueen(0);
		System.out.println(result);
	}
 
	public static void nQueen(int depth) {
	
		if (depth == N) {	// 모든 원소가 채워진 상태 경우 result 증가, return 
			result++;
			return;
		}
 
		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			if (Possibility(depth)) { // 퀸을 놓을 수 있는 위치의 경우 재귀호출
				nQueen(depth + 1);
			}
		}
 
	}
 
	public static boolean Possibility(int col) {
 
		for (int i = 0; i < col; i++) {
			
			if (arr[col] == arr[i]) {    // 같은 행에 존재할 경우
				return false;
			} else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			} // 대각선상에 놓여있는 경우
			 // (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우
		}
		
		return true;
	}
}
```
> 자바의 경우 재귀호출함수부분과 조건을 확인하는 함수를 다르게 작성했습니다.


<br><br>

- Python (PyPy3)

> Python의 경우 이번 예제에서 거의 계속 시간 초과의 문제가 있었습니다. 찾아보니,  PyPy3가 일부 Python 프로그램의 경우 몇 배나 빠른 Python 인터프리터 대체 도구로, Python으로 계속 시간초과가 된다면, PyPy3를 이용하라는 말이 많아서, PyPy3로 언어를 설정하고 수행했습니다. 

<br>

```python
import sys
 
def nqueen(idx):
    global N, col, slash, backSlash, result
    if idx == N:
        result += 1
        return
    for j in range(N):
        if not (col[j] or slash[idx + j] or backSlash[idx - j + N - 1]):
            col[j] = slash[idx + j] = backSlash[idx - j + N - 1] = True
            nqueen(idx + 1)
            col[j] = slash[idx + j] = backSlash[idx - j + N - 1] = False
 
 
N = int(sys.stdin.readline())
col, slash, backSlash = [False] * N, [False] * (2 * N - 1), [False] * (2 * N - 1)
result = 0
nqueen(0)
print(result)
```

<br><br>

---

<br>

> 백트래킹에 대해서도 자세히 정리하려고 합니다.
제 경우에는 처음에 갑자기 난이도가 좀 높아진 느낌이었는데, 자바 코드 작성할 때 친절하게 설명해주신 사이트를 참고해서, 덕분에 이해하고 그런 방식으로 작성했습니다! 공부를 더 많이 해야겠습니다ㅠㅠ
