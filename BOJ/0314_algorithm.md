# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 12. 정렬

> 배열의 원소를 순서대로 나열하는 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 2. 수 정렬하기2
[2751번](https://www.acmicpc.net/problem/2751) 
> 시간 복잡도가 O(n²)인 정렬 알고리즘으로 풀 수 있습니다. 예를 들면 삽입 정렬, 거품 정렬 등이 있습니다.
>> N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

<br><br>

- Java
<br>
1. sort 함수 이용

```java
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        for(int value : list) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}
```
> 빠른 속도가 중요한 문제라, BufferedReader를 이용해보았습니다. ArrayList에 모든 원소를 입력받아 저장하고, Collections에 있는 sort() 함수를 이용하여 정렬하는 코드로 구성했습니다.


<br><br>

- Python

<br>

1. sorted 함수 이용

```python
import sys
N = int(input())
num = []
for i in range(N):
    num.append(int(sys.stdin.readline()))
for i in sorted(num):
    sys.stdout.write(str(i)+'\n')
```
> 빠른 수행시간이 중요하고 생각해서, input()과 print()함수를 사용하지 않고 import sys를 통해, system input과 system output을 사용하는 방법을 적용하였습니다!
> Python sorted 함수는 시간복잡도 O(nlogn)입니다.

<br><br>

---

<br>



 
