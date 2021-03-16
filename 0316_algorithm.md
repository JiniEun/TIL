# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 12. 정렬

> 배열의 원소를 순서대로 나열하는 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 4. 통계학
[2108번](https://www.acmicpc.net/problem/2108) 
> 정렬을 활용하는 문제
>> 수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.<br>
1. 산술평균 : N개의 수들의 합을 N으로 나눈 값
2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값
4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이<br>
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

<br><br>

- Java
<br>

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int [] arr = new int[N];
        int [] check = new int[8001];    //최빈값 계산할 배열
        int total = 0;
        int max = 0;
        
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(br.readLine());
            total += arr[i];        //입력 받으면서 총 합 계산
            check[arr[i]+4000]++;
        }
        
        System.out.println((int)Math.round((double)total/N)); //산술평균
        Arrays.sort(arr);
        System.out.println(arr[N/2]); //중앙값
        
        for(int i=0;i<8001;i++) {            
            if(check[i]>=max) {
                max = check[i];
            }
        }       
        for(int i=0;i<8001;i++) {
            if(check[i]==max) {
                list.add(i-4000);
            }
        }
        
        if(list.size()==1) {
            System.out.println(list.get(0));
        }
        else {
            Collections.sort(list);
            System.out.println(list.get(1)); //여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력
        }
        System.out.println(Math.abs(arr[arr.length-1]-arr[0]));  //범위             
    }
}
```


<br><br>

- Python

<br>

```python
import sys
from collections import Counter

N = int(sys.stdin.readline())
arr = []
for _ in range(N):
    arr.append(int(sys.stdin.readline()))

# 산술 평균
print("%.f"%(sum(arr)/N))

# 중앙값
arr.sort()
print(arr[N//2])

# 최빈값
k = Counter(arr).most_common()
# most_common(): 빈도수가 높은 순으로 리스트 안의 튜플형태로 반환

if len(arr) > 1:  #입력값이 하나면, 바로 최빈값
    if k[0][1] == k[1][1]:print(k[1][0]) 
    # 최빈값의 빈도수를 비교, 2개이상의 최빈값이 있으면 두번째로 작은값 출력
    else : print(k[0][0]) 
else : print(arr[0]) 

# 범위
print(arr[-1] -  arr[0])
```
> most_common(): 빈도수가 높은 순으로 리스트 안의 튜플형태로 반환. 
만약 첫번째와 두번째의 value값을 비교해서 같다면 두번째 key값 출력

<br><br>

---

<br>
