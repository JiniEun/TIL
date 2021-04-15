# Baekjoon Online Judge

## algorithm practice
<br>

## - 단계별 문제풀기
<br>

## 16. 그리디 알고리즘(Greedy Algorithm)

> 특정 상황에서 성립하는 그리디 알고리즘을 배워 봅시다.

<br>

---

<br>

**Java / Python**

<br>

### 2. 회의실 배정
[1931번](https://www.acmicpc.net/problem/1931) 
> 가능한 한 많은 구간을 선택하는 문제

<br>

![](https://images.velog.io/images/jini_eun/post/3522693b-4a4e-4ff4-8122-9cf81bedc16d/image.png)

<br>

> 이 문제의 특징은 '한 사람이 한번에 하나의 활동에 대해서만 작업할 수 있다'라는 점입니다. 즉, 하나의 활동을 완료하기 전까지는 다른 활동을 선택할 수 없다는 것입니다. 이전의 선택 결과가 이후의 결과에 영향을 미치지 않기 위해 '이전 선택의 종료 시간'과 '이후 선택의 시작 시간'이 서로 겹치지 않도록 합니다. 
종료시간을 기준으로 정렬해, 이전 종료시간에 대해 겹치는 것들은 제외하고 남은 것들 중 선택하는 방식입니다.

<br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		int N = Integer.parseInt(br.readLine());
        
		int[][] time = new int[N][2];
		// time[][0] = 시작시점
		// time[][1] = 종료시점
		int cnt = 0;
		int pre_end_time = 0;    // 직전 종료 시간
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i][0] = Integer.parseInt(st.nextToken());	// 시작시간 
			time[i][1] = Integer.parseInt(st.nextToken());	// 종료시간 
		}
				
		// compare 재정의 : 끝나는 시간을 기준으로 정렬
		Arrays.sort(time, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				// 종료 시간이 같을 경우 시작 시간이 빠른순으로 정렬
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
 
		});
		
		for(int i = 0; i < N; i++) {
				
			if(pre_end_time <= time[i][0]) { 
				pre_end_time = time[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
 
}
```


<br><br><br>

- Python 

<br>

```python
import sys 
N = int(sys.stdin.readline()) 
time = [[0]*2 for _ in range(N)] 
cnt = 1 
for i in range(N): 
    s, e = map(int, sys.stdin.readline().split()) 
    time[i][0] = s 
    time[i][1] = e 
time.sort(key = lambda x: (x[1], x[0])) 
end_time = time[0][1] 

for i in range(1, N): 
    if time[i][0] >= end_time: 
        cnt += 1 
        end_time = time[i][1] 
        
print(cnt)
```

<br><br>

---

<br>

