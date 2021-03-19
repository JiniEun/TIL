# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 12. 정렬

> 배열의 원소를 순서대로 나열하는 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 7. 좌표 정렬하기 2
[11651번](https://www.acmicpc.net/problem/11651) 
> 좌표를 다른 순서로 정렬하는 문제
>> 2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

<br><br>

- Java
<br>

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
 
        Scanner sc = new Scanner(System.in);
 
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
 
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                if(x[1]==y[1]){
                    return Integer.compare(x[0], y[0]);
                }
                return Integer.compare(x[1], y[1]);
            }
        });
 
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
```
> 11650번과 비슷한 문제입니다. 정렬 기준만을 변경해, Comparator override부분만 수정해주면 간단하게 해결됩니다.

<br><br>

- Python

<br>

```python
import sys

N = int(sys.stdin.readline())
coords = []

for i in range(N):
    coords.append(list(map(int, sys.stdin.readline().split())))
    
coords.sort(key=lambda x: (x[1], x[0]))

for k in coords:
    print(k[0], k[1])
```
> 빠른 수행시간을 위해 sys.stdin.readline()을 이용했습니다. 두번째 세로줄부터 정렬을 해야하므로 x[1]과 x[0]을 차례대로 lambda를 이용하도록 sort 함수를 이용해서 정렬했습니다.

<br><br>

---

<br>
