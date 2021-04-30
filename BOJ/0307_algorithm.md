# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 10. 재귀

Java / Python
<br>

### 1. 팩토리얼
[10872번](https://www.acmicpc.net/problem/10872) 
> 팩토리얼은 단순 for문으로도 구할 수 있지만, 학습을 위해 재귀를 써 봅시다. 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

<br><br>

- Java

```java
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        System.out.println(factorial(N));
        sc.close();
        
    }
    public static int factorial(int n){
        if (n <= 1){
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }   
}
``` 


<br>

- Python

```python
def fact(n):
    if n <= 1:
        return 1
    else :
        return n * fact(n-1)

N = int(input())
print(fact(N))
```

<br><br><br>

### 2. 피보나치 수 5
[10870번](https://www.acmicpc.net/problem/10870) 
> 피보나치 수 역시 단순 for문으로도 구할 수 있지만, 학습을 위해 재귀를 써 봅시다.<br>
피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.<br>
이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
n=17일때 까지 피보나치 수를 써보면 다음과 같다.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597<br>
n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.

<br><br>

- Java

```java
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        System.out.println(Fibonacci(N));
        sc.close();
        
    }
    public static int Fibonacci(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        return Fibonacci(N - 1) + Fibonacci(N - 2);
    }
}
``` 


<br>

- Python

```python
def fibonacci(n):
    if n <= 1:
        return n
    else :
        return fibonacci(n-1) + fibonacci(n-2)

N = int(input())
print(fibonacci(N))
```

<br><br>

---

<br>


> 오늘부터는 재귀함수 예제였습니다!
오랜만에 (원리와 재귀함수를 이용하는 방법만 알면) 비교적 간단한 예제들이었던 것 같습니다. 
