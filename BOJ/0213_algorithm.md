# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 7. 문자열

Java / Python
<br>

### 5. 단어 공부
[1157번](https://www.acmicpc.net/problem/1157) 
> 주어진 단어에서 가장 많이 사용된 알파벳을 출력하는 문제

- Java

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toUpperCase();
     
        int max = 0;
        int[] cnt = new int[26];
        char ans = '?';

        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 65]++;
            if (max < cnt[str.charAt(i) - 65]) {
                max = cnt[str.charAt(i) - 65];
                ans = str.charAt(i);
            } else if (max == cnt[str.charAt(i) - 65]) {
                ans = '?';
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
```
> charAt() 함수 : String으로 저장된 문자열 중에서 한 글자만 선택해서 char 타입으로 변환해주는 함수

<br>

- Python

```python
words = input().upper()
alphabets = list(set(words))  
cnt_list = []

for x in alphabets :
    cnt = words.count(x)
    cnt_list.append(cnt) 

if cnt_list.count(max(cnt_list)) > 1 :
    print('?')
else :
    max_index = cnt_list.index(max(cnt_list)) 
    print(alphabets[max_index])
```
> 문자열을 입력받고 중복 요소를 제거한 변수를 선언하고, 알파벳이 사용된 횟수를 리스트로 저장한다. if조건식을 이용해서 출력문을 작성할 수 있는데, count 숫자 최대값이 중복되면 ?를 출력하거나 count 숫자 최대값 인덱스인 list 값을 출력한다.

<br>

---


<br><br>
### 6. 단어의 개수
[1152번](https://www.acmicpc.net/problem/1152) 
> 단어의 개수를 구하는 문제

- Java
```java
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        sc.close();
         
        if (str.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(str.split(" ").length);
        }
    }
}
```

<br>

- Python

```python
str = input().split()
print(len(str))
```

<br><br>

---

<br>

> 오늘은 문자열 단계 예제입니다!
문자열을 분리하기도 하고 조건에 따라 문자열을 잘 가지고 응용하는 것을 연습해야 될 것 같습니다!


