# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 9. 기본 수학2

Java / Python
<br>

### 5. 베르트랑 공준
[4948번](https://www.acmicpc.net/problem/4948) 

> 소수 응용 문제 1
>> 베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다. <br>
이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.<br>
예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)<br>
자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오. 

<br>

- Java

```java
import java.util.Scanner;
public class Main {
// n > 123456 이므로 2n 은 최대 246912 이다.
// 0 부터 시작하므로 246912 + 1
    public static boolean[] prime = new boolean[246913];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        get_prime(); // 소수 얻는 함수
        while(true) {
            int n = sc.nextInt();
            if(n == 0) break; // n == 0 : 종료
            int cnt = 0; 
            for(int i = n + 1; i <= 2 * n; i++) {
                if(!prime[i]) cnt++;
            }
            System.out.println(cnt);
        }
    }
    // 소수 얻는 함수
    public static void get_prime() {
    // 0 과 1 은 소수가 아니므로 ture
        prime[0] = prime[1] = true;
        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}

``` 

<br>

- Python

```python

```

<br><br>

---

<br>


> 오늘은 기본 수학2 예제였습니다!

