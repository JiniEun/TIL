# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 9. 기본 수학2

Java / Python
<br>

### 3. 소인수분해 
[11653번](https://www.acmicpc.net/problem/11653) 

> N을 소인수분해하는 문제

<br>

- Java

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=2;
        while (n >= i){
            if(n%i == 0){
                System.out.println(i);
                n /=i;
            }else {
                i++;
            }
        }
    }
}
``` 

<br>

- Python

```python
N = int(input())
i = 2
while N != 1:
    if N % i == 0:
        N = N / i
        print(i)
    else:
        i = i+1
```

<br><br>

---

<br>


> 오늘은 기본 수학2 예제였습니다!

