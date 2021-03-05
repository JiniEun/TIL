# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 9. 기본 수학2

Java / Python
<br>

### 9. 직각삼각형
[4153번](https://www.acmicpc.net/problem/4153) 
> 피타고라스의 정리에 대해 배우는 문제

<br><br>

- Java

```java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 3;            
        while(cnt != 0) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            cnt = a;
            if(cnt==0) {break;}
            int[] arr= {a,b,c};        
            Arrays.sort(arr);

            if(arr[2] * arr[2] == arr[0] * arr[0] + arr[1] * arr[1]) {
                System.out.println("right");
            }else {
                System.out.println("wrong");
            }    
        }          
    }
}
``` 
> array로 받아 sort를 이용해 가장 큰 수를 찾아주고 계산했습니다!

<br>

- Python

```python
while True:
        triangle = list(map(int, input().split()))
        max_number = max(triangle)
        if sum(triangle) == 0:
                break
        triangle.remove(max_number)
        if triangle[0] ** 2 + triangle[1] ** 2 == max_number ** 2:
                print('right')
        else:
                print('wrong')
```


<br><br>

### 10. 택시 기하학
[3053번](https://www.acmicpc.net/problem/3053) 
> 유클리드 기하학과 택시 기하학에 대한 문제

<br>

- Java

```java

``` 

<br>

- Python

```python

```
>  

<br><br>

---

<br>


> 오늘은 기본 수학2 예제였습니다!
