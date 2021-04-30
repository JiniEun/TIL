# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 12. 정렬

> 배열의 원소를 순서대로 나열하는 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 9. 나이순 정렬
[10814번](https://www.acmicpc.net/problem/10814) 
> 값이 같은 원소의 전후관계가 바뀌지 않는 정렬 알고리즘을 안정 정렬(stable sort)이라고 합니다.
>> 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.

<br><br>

- Java
<br>

```java
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[][] arr = new String[N][2];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++) {
            arr[i][0] = sc.next(); // 나이
            arr[i][1] = sc.next(); // 이름
        }
        
        Arrays.sort(arr, new Comparator<String[]>() {          
        @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });
        
        for(int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}
```


<br><br>

- Python

<br>

```python
import sys
num = int(sys.stdin.readline())
member_list = []

for _ in range(num):
    member_age, member_name = map(str, sys.stdin.readline().split())
    member_age = int(member_age)
    member_list.append((member_age, member_name))

# 정렬 나이 -> 가입순
member_list.sort(key = lambda member: (member[0]))

for member in member_list:
    print(member[0], member[1])
```


<br><br>

---

<br>

> 정렬단계 마지막 예제였습니다!
