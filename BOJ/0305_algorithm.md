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
>>택시 기하학에서의 원
![](https://images.velog.io/images/jini_eun/post/f01853d8-ec64-4d71-8eb5-f2d92021e8d7/image.png)
[출처](https://terms.naver.com/entry.nhn?docId=3567439&cid=58944&categoryId=58970)<br><br>
유클리드 기하학에서 원의 넓이 : pi x R^2
택시 기하학에서 원의 넓이 : 밑변의 길이와 높이가 R인 마름모꼴 형태의 정사각형의 넓이
유클리드 기하학의 원의 방정식은 
(x-a)^{2}+(y-b)^{2}=r^{2}이지만, 
택시 기하학에서의 원의 방정식은 원의 중심이 (a,b) 이고, 거리가 d 일때 아래와 같이 표현된다.
|x - a| + |y - b| = d∣x−a∣+∣y−b∣=d
반지름이 r이라고 하면 마름모니까 넓이는 2 x r^2이 된다.

<br>

- Java

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double R = sc.nextDouble(); // 반지름 R
        sc.close();
        System.out.println(R * R * Math.PI); // 유클리드 기하학
        System.out.println(2 * R * R); // 택시 기하학 
    }
}
``` 

<br>

- Python

```python
import math
R = int(input())
print(R*R*math.pi)
print(R*R*2)
```

<br><br>

---

<br>


> 오늘은 기본 수학2 예제였습니다!
