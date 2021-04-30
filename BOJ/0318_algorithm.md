# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 12. 정렬

> 배열의 원소를 순서대로 나열하는 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 6. 좌표 정렬하기
[11650번](https://www.acmicpc.net/problem/11650) 
> 좌표를 정렬하는 문제
>> 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

<br><br>

- Java
<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
 
public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] arr = new int[N][2];
        String[] str = new String[2];
        
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            arr[i][0] =Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }
 
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                if (x[0] == y[0]) {
                    return Integer.compare(x[1], y[1]);
                }
                return Integer.compare(x[0], y[0]);
            }
 
        });
 
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
```
> 이번에도 빠른 수행시간을 위해 BufferedReader와StringBuilder 를 이용했습니다.
Comparator를 사용한 정렬을 이용했습니다.
1열의 값이 같을 경우 2열의 값을 비교하고, 작은 값이 위로 가도록 정렬했고, 1열부터 값의 차이가 있는 경우에는 1열을 기준으로 정렬하고 return 하도록 했습니다.

<br><br>

- Python

<br>

```python
import sys
N = int(sys.stdin.readline())
coords = []
for i in range(N):
    [x, y] = map(int, sys.stdin.readline().split())
    coords.append([x, y])

coords = sorted(coords) 
for i in range(N): 
    print(coords[i][0], coords[i][1])
```
> 빠른 수행시간을 위해 sys.stdin.readline()을 이용했습니다. sorted 함수를 이용해서 간단하게 정렬했습니다..!

<br><br>

---

<br>
