# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 13. 백트래킹

> 모든 경우를 탐색하는 백트래킹 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 8. 스타트와 링크
[14889번](https://www.acmicpc.net/problem/14889) 
> 삼성 SW 역량 테스트 기출 문제 2

![](https://images.velog.io/images/jini_eun/post/44201b60-6557-4292-97c4-930806ef8dae/image.png)

> 이 문제의 경우 설명이 복잡해 보여 이해가 어려워보입니다만, 
<br>간단히 중요한 점을 정리하면, 두 팀으로 나누는데, 각 팀의 능력치 차이를 최소화 한다는 것입니다. <br>즉, 팀의 전력차가 적게 나도록 팀을 구성하도록 하면 되는 것 같습니다.
모든 조합의 경우의 수를 탐색하여 두 팀의 능력치가 최소가 되는 수를 찾고 출력하면 되는 것 같습니다.

<br><br><br>

- Java
<br>

```java
import java.util.Scanner;
 
public class Main {
	
	static int N;
	static int[][] map;
	static boolean[] visit;
	
	static int Min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
    
		Scanner sc = new Scanner(System.in);
 
		N = sc.nextInt();
 
		map = new int[N][N];
		visit = new boolean[N];
 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		combi(0, 0);
		System.out.println(Min);
		sc.close();
	}
 
	static void combi(int idx, int count) {
		// 팀 조합이 완성될 경우
		if(count == N / 2) {
			diff();
			return;
		}
 
		for(int i = idx; i < N; i++) {
			if(!visit[i]) { // 방문 안한 경우
				visit[i] = true;	// 방문으로 변경
				combi(i + 1, count + 1);	// 재귀 호출
				visit[i] = false;	// 재귀가 끝나면 비방문으로 변경
			}
		}
	}
 
	// 능력치 차 계산 함수 
	static void diff() {
        // 방문한 팀과 방문하지 않은 팀을 각각 나누어 각 팀의 점수를 구한 뒤 최솟값을 찾는다.
		int team_start = 0;
		int team_link = 0;
        int val = 0;
 
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visit[i] == true && visit[j] == true) {
					team_start += map[i][j];
					team_start += map[j][i];
				}else if (visit[i] == false && visit[j] == false) {
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}
        
		val = Math.abs(team_start - team_link);
		
		// 두 팀의 점수차 = 0 = 가장 낮은 최솟값 = 더이상의 탐색 필요X, 0을 출력, 종료
		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		Min = Math.min(val, Min);	
	}
}
```

<br><br><br>

- Python 

<br>

```python
from itertools import combinations
            
N = int(input())
board = []
for _ in range(N):
    board.append(list(map(int, input().split())))

num_list = [i for i in range(N)]
res = float('inf')            

def solve():
    global res
    
    # 조합을 이용하여 각 후보자를 생성함
    for cand in combinations(num_list, N // 2):
        # 선택된 후보와 나머지
        start_member = list(cand)
        link_member = list(set(num_list) - set(cand))
        
        # 점수 비교 2명씩
        start_combi = list(combinations(start_member, 2))
        link_combi = list(combinations(link_member, 2))
        
        # 점수 구하기
        team_start = 0
        for x, y in start_combi:
            team_start += (board[x][y] + board[y][x])
            
        team_link = 0
        for x, y in link_combi:
            team_link += (board[x][y] + board[y][x])
        
        if(res > abs(team_start - team_link)):
            res = abs(team_start - team_link)
solve()
print(res)
```

<br><br>

---

<br>

