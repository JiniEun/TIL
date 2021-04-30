# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 12. 정렬

> 배열의 원소를 순서대로 나열하는 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 8. 단어 정렬
[1181번](https://www.acmicpc.net/problem/1181) 
> 단어의 순서를 정의하여 정렬하는 문제
> 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
1. 길이가 짧은 것부터
2. 길이가 같으면 사전 순으로

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
        String[] arr = new String[N];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                else {// 그 외의 경우
                    return s1.length() - s2.length();
                }
            }
        });
        System.out.println(arr[0]);
        for (int i = 1; i < N; i++) { // 중복되지 않는 단어만 출력
            if (!arr[i].equals(arr[i - 1])) {
                System.out.println(arr[i]);
            }
        }
    }
}

```


<br><br>

- Python

<br>

```python
import sys
N = int(sys.stdin.readline())
words = []

for _ in range(N):
    words.append(sys.stdin.readline())

#중복 삭제
words = list(set(words))
words_list = []

# 단어의 길이와 단어를 같이 리스트화 시켜 저장
for w in words:
    words_list.append((len(w), w))      
words_list.sort()

# 리스트를 순환시켜 순서대로 출력
for len_w, w in words_list:       
    print(w)
```

(더 간단한 방법입니다..!)
```python
import sys
v = list(set([sys.stdin.readline() for _ in range(int(sys.stdin.readline()))]))
v.sort(key = lambda x :(len(x),x))
print("\n".join(v))
```
>*다른분들도 이런식으로 코드 작성하셨던데, 백준에서 지금 이렇게하면 출력형식이 잘못된다고 떠서(?) 출력부분을 print(w,end="") / print("".join(v) 이렇게 붙여 출력하면 맞았다고 뜹니다.!*

<br><br>

---

<br>
