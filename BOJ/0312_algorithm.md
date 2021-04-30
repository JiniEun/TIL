# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 11. 브루트 포스

> 가장 간단한 알고리즘인, 모든 경우의 수를 검사하는 브루트 포스 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 5. 영화감독 숌
[1436번](https://www.acmicpc.net/problem/1436) 
> N번째 종말의 수가 나올 때까지 차례대로 시도하는 문제
>> 666은 종말을 나타내는 숫자라고 한다. 따라서, 많은 블록버스터 영화에서는 666이 들어간 제목을 많이 사용한다. 영화감독 숌은 세상의 종말 이라는 시리즈 영화의 감독이다. 조지 루카스는 스타워즈를 만들 때, 스타워즈 1, 스타워즈 2, 스타워즈 3, 스타워즈 4, 스타워즈 5, 스타워즈 6과 같이 이름을 지었고, 피터 잭슨은 반지의 제왕을 만들 때, 반지의 제왕 1, 반지의 제왕 2, 반지의 제왕 3과 같이 영화 제목을 지었다. <br>
하지만 숌은 자신이 조지 루카스와 피터 잭슨을 뛰어넘는다는 것을 보여주기 위해서 영화 제목을 좀 다르게 만들기로 했다.<br>
종말의 숫자란 어떤 수에 6이 적어도 3개이상 연속으로 들어가는 수를 말한다. 제일 작은 종말의 숫자는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, .... 과 같다.<br>
따라서, 숌은 첫 번째 영화의 제목은 세상의 종말 666, 두 번째 영화의 제목은 세상의 종말 1666 이렇게 이름을 지을 것이다. 일반화해서 생각하면, N번째 영화의 제목은 세상의 종말 (N번째로 작은 종말의 숫자) 와 같다.<br>
숌이 만든 N번째 영화의 제목에 들어간 숫자를 출력하는 프로그램을 작성하시오. 숌은 이 시리즈를 항상 차례대로 만들고, 다른 영화는 만들지 않는다.

<br><br>

- Java

```java
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int num = 666;
        int cnt = 1;
        
        while(cnt != N) {
            num++;
            if(String.valueOf(num).contains("666")) {
                cnt++;
            }
        }
        System.out.println(num);
    }
}
``` 
> 입력받은 N과, cnt가 같아질 때까지 num을 1씩 증가시켜 666이 포함되는지를 계속 검사하는 방법을 이용했습니다.

<br><br>

- Python

```python
N = int(input())
num = 666

while N:
    if "666" in str(num):
        N -= 1
    num += 1

print(num - 1)
```
> while 문 내에서 입력 N 값에 따라서 0이 될 때까지 순위에 따라 666이 있는 수를 출력합니다.

<br><br>

---

<br>
