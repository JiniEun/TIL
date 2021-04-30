# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 11. 브루트 포스

> 가장 간단한 알고리즘인, 모든 경우의 수를 검사하는 브루트 포스 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 1. 블랙잭
[2798번](https://www.acmicpc.net/problem/2798) 
> 세 장의 카드를 고르는 모든 경우를 고려하는 문제
>> 카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.<br>
한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.<br>
김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.<br>
이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.<br>
N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.


<br><br>

- Java

```java
import java.util.Scanner;
public class Main{
    static int search(int n, int m, int[] arr){
        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int temp = arr[i] + arr[j] + arr[k];
                    if (m == temp) {
                        return temp;
                    }
                    if(result < temp && temp < m) {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int result = search(N, M, arr);
        System.out.println(result);
    }
}
``` 

<br><br>

- Python

```python
N, M = map(int,input().split())
nlist = list(map(int, input().split()))
length = len(nlist)
result = 0
for i in range(0, length-2):
    for j in range(i + 1, length-1):
        for k in range(j + 1, length):
            nsum = nlist[i] + nlist[j] + nlist[k]
            if nsum <= M:
                result = max(result, nsum)
print(result)
```



<br><br><br>

### 2. 분해합
[2231번](https://www.acmicpc.net/problem/2231) 
> 모든 경우를 시도하여 N의 생성자를 구하는 문제
>> 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.<br>
자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

<br><br>

- Java

```java
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
           
        for(int i = 0; i < N; i++) {
            int num = i;
            int sum = 0; // 각 자릿수 합
            while(num != 0) {
                sum += num % 10; // 각 자릿수 더하기
                num /= 10;
            }
            if(sum + i == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
        sc.close();
    }
}
``` 

<br><br>

- Python

```python
N = int(input())
result = 0
for i in range(1, N+1):
    num = list(map(int,str(i)))
    result = i + sum(num)
    if result == N:
        print(i)
        break
        
    if i == N :    # 생성자가 없을 경우
        print(0)
```

<br><br>

---

<br>


 
