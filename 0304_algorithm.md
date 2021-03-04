# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 9. 기본 수학2

Java / Python
<br>
<br>

### 7. 직사각형에서 탈출
[1085번](https://www.acmicpc.net/problem/1085) 

> 직사각형과 점의 거리를 구하는 문제
>> 한수는 지금 (x, y)에 있다. 직사각형의 왼쪽 아래 꼭짓점은 (0, 0)에 있고, 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.

<br>

- Java

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        
        System.out.println(Math.min(Math.min(x, w-x), Math.min(y, h-y))); // x와 y축 최소거리 중 가장 작은 값
        sc.close();
    }
}
``` 

<br>

- Python

```python
x, y, w, h = list(map(int, input().split()))
print(min([x, y, w - x, h - y]))
```
>  x, y좌표를 기준으로 w, h까지의 거리와 (0, 0)까지의 거리를 고려해야합니다. 
직사각형은 경계선까지의 거리를 고려할 때 대각선이 최소인 경우가 없기 때문에 대각선은 고려하지 않았습니다.

<br><br>

### 8. 네 번째 점
[3009번](https://www.acmicpc.net/problem/3009) 

> 직사각형을 완성하는 문제

<br>

- Java

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] xy_1 = { sc.nextInt(), sc.nextInt() }; // 첫 번째 좌표
        int[] xy_2 = { sc.nextInt(), sc.nextInt() }; // 두 번째 좌표
        int[] xy_3 = { sc.nextInt(), sc.nextInt() }; // 세 번째 좌표
        sc.close();
        int x4 = 0;
        int y4 = 0;
        
        if(xy_1[0] == xy_2[0]){
            x4 = xy_3[0];
        }
        else if(xy_1[0] == xy_3[0]){
            x4 = xy_2[0];
        }
        else if(xy_2[0] == xy_3[0]){
            x4 = xy_1[0];
        }
        else{
            System.out.println(-1);
        }
        
        if(xy_1[1] == xy_2[1]){
            y4 = xy_3[1];
        }
        else if(xy_1[1] == xy_3[1]){
            y4 = xy_2[1];
        }
        else if(xy_2[1] == xy_3[1]){
            y4 = xy_1[1];
        }
        else{
            System.out.println(-1);
        }
        
        System.out.println(x4 + " "+ y4);
        
    }
}
``` 

<br>

- Python

```python
x_nums = []
y_nums = []
for _ in range(3):
    x, y = map(int, input().split())
    x_nums.append(x)
    y_nums.append(y)

for i in range(3):
    if x_nums.count(x_nums[i]) == 1:
        x4 = x_nums[i]
    if y_nums.count(y_nums[i]) == 1:
        y4 = y_nums[i]
print(x4, y4)
```
>  

<br><br>

---

<br>


> 오늘은 기본 수학2 예제였습니다!
