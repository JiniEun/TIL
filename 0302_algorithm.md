# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 9. 기본 수학2

Java / Python
<br>

### 6. 골드바흐의 추측
[9020번](https://www.acmicpc.net/problem/9020) 

> 소수 응용 문제 2
>> 1보다 큰 자연수 중에서  1과 자기 자신을 제외한 약수가 없는 자연수를 소수라고 한다. 예를 들어, 5는 1과 5를 제외한 약수가 없기 때문에 소수이다. 하지만, 6은 6 = 2 × 3 이기 때문에 소수가 아니다. <br>
골드바흐의 추측은 유명한 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다. 이러한 수를 골드바흐 수라고 한다. 또, 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다. 예를 들면, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7이다. 10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다. <br>
2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오. 만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.

<br>

- Java

```java
import java.util.Scanner;
public class Main {
// false : 소수
// range : 0 ~ 10000
    public static boolean[] prime = new boolean[10001];
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        get_prime();
        int T = sc.nextInt(); 
        
        while (T-- > 0) {
            int n = sc.nextInt();
            int partition1 = n / 2;
            int partition2 = n / 2;
            while (true) {    // 두 파티션이 모두 소수일 경우
                if (!prime[partition1] && !prime[partition2]) {
                    System.out.println(partition1 + " " + partition2);
                    break;
                }
                partition1--;
                partition2++;
            }
        }
    }
    // 에라토스테네스의 체 소수 얻는 함수
    public static void get_prime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
``` 

<br>

- Python

```python
prime = [False, False] + [True] * 10000
    
for i in range(2, 101):
    if prime[i] == True:
        for j in range(i + i, 10001, i):
            prime[j] = False

T = int(input())
for _ in range(T):
    N = int(input())
    num = N // 2
    for j in range(num, 1, -1):
        if prime[N - j] and prime[j]:
            print(j, N - j)
            break
```
> 입력값이 10000까지 주어질 수 있기 때문에 길이가 0, 1번 인덱스가 False이고 나머지가 True인 길이 10002인 배열 선언.
입력값이 10000까지 주어지기 때문에 101보다 작은 소수들의 배수들을 False로 바꿔주면 소수만 남는다.

<br><br>

---

<br>


> 오늘은 기본 수학2 예제였습니다!
기본 수학2의 경우 소수와 관련된 예제들이 많은 것 같습니다! 소수와 관련해서 다양하게 코딩하는 방법을 공부할 수 있던 것 같습니다. 저도 소수를 가지고 다양하게 코딩해본 적이 없어서 많이 어려웠습니다..😂
