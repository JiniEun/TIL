# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 8. 기본 수학1

Java / Python
<br>

### 3. 분수 찾기
[1193번](https://www.acmicpc.net/problem/1193) 
> 분수의 순서에서 규칙을 찾는 문제

> 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하고, X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하는 문제입니다. 

> 대각선을 기준으로 각 줄을 순서에 맞춰 나눠보면, 
[1/1], [1/2, 2/1], [3/1, 2/2, 1/3], [1/4, 2/3, 3/2, 4/1] 
이런 방식으로 나타낼 수 있습니다. 
규칙을 찾아 보았습니다만, 
1개 -> 2개 -> 3개 이런식으로 n개씩 늘어난다고 하면,
홀수 줄 : 분자는 n부터 1까지 줄어들고 분모는 1부터 n까지 늘어나고, 
짝수 줄 : 분자는 1부터 n까지 늘어나고 분모는 n부터 1까지 줄어듭니다. 

- Java

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int tmp = 0, cnt = 0, b = 0, a = 0;
        while(num > cnt){
            tmp += 1;
            cnt += tmp;
        }
        cnt -= tmp;
        if ( tmp % 2 == 0){
            a = num - cnt;
            b = tmp - a + 1;
        }else{
            a = tmp - (num - cnt) + 1;
            b = num - cnt;
        }
        System.out.print(a + "/" + b);
        sc.close();
    }
}
``` 

<br>

- Python

```python
X = int(input())
num = 0
num_count = 0

while X > num_count:
    num += 1
    num_count += num

num_count -= num

if num % 2 == 0:
    a = X - num_count
    b = num - a + 1
else:
    a = num - (X - num_count) + 1
    b = X - num_count
    
print(a, '/', b, sep='')
```

<br><br>

---

<br>


> 오늘은 기본 수학1 예제였습니다!
규칙을 찾는 게 중요한 것 같습니다!!
