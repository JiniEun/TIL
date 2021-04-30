# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 12. 정렬

> 배열의 원소를 순서대로 나열하는 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 5. 소트인사이드
[1427번](https://www.acmicpc.net/problem/1427) 
> 숫자를 정렬하는 문제
>> 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

<br><br>

- Java
<br>

```java
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}
```


<br><br>

- Python

<br>

```python
N = int(input())
arr = []
arr = list(map(int, str(N)))
arr.sort(reverse=True)
for s in arr:
    print(s,end="")
```


<br><br>

---

<br>
