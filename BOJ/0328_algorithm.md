# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 13. 백트래킹

> 모든 경우를 탐색하는 백트래킹 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 7. 연산자 끼워넣기
[14888번](https://www.acmicpc.net/problem/14888) 
> 삼성 SW 역량 테스트 기출 문제 1

![](https://images.velog.io/images/jini_eun/post/1268728f-ef35-4880-9808-c8d8fef009c9/image.png)

![](https://images.velog.io/images/jini_eun/post/2baae49a-4d81-4f05-ac15-2a0f60fae33e/image.png)


<br><br><br>

- Java
<br>

```java
import java.util.Scanner;
 
public class Main {
 
	public static int MAX = Integer.MIN_VALUE;	// 최댓값 
	public static int MIN = Integer.MAX_VALUE;	// 최솟값 
	public static int[] oper = new int[4];	    // 연산자 개수 
	public static int[] nums;					// 숫자 
	public static int N;						// 숫자 개수 
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		N = sc.nextInt();
		nums = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
 
		for (int i = 0; i < 4; i++) {
			oper[i] = sc.nextInt();
		}
		dfs(nums[0], 1);
		sc.close();
		System.out.println(MAX);
		System.out.println(MIN);

	}
 
	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
 
		for (int i = 0; i < 4; i++) {
			if (oper[i] > 0) {
 
				oper[i]--;
 
				switch (i) {
				    case 0:	dfs(num + nums[idx], idx + 1);	break;
				    case 1:	dfs(num - nums[idx], idx + 1);	break;
				    case 2:	dfs(num * nums[idx], idx + 1);	break;
				    case 3:	dfs(num / nums[idx], idx + 1);	break;
				}
				oper[i]++;
			}
		}
	}
}
```

<br><br><br>

- Python 

<br>

```python
import sys
N = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
add, sub, mul, div = map(int, sys.stdin.readline().split())

min_num, max_num = 1e9, -1e9

def dfs(i, res, add, sub, mul, div):
    global max_num, min_num
    if i == N:
        max_num = max(res, max_num)
        min_num = min(res, min_num)
        return

    else:
        if add:
            dfs(i+1, res+nums[i], add-1, sub, mul, div)
        if sub:
            dfs(i+1, res-nums[i], add, sub-1, mul, div)
        if mul:
            dfs(i+1, res*nums[i], add, sub, mul-1, div)
        if div:
            dfs(i+1, int(res/nums[i]), add, sub, mul, div-1)

dfs(1, nums[0], add, sub, mul, div)
print(max_num)
print(min_num)
```

<br><br>

---

<br>

