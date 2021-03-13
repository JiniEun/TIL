# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 12. 정렬

> 배열의 원소를 순서대로 나열하는 알고리즘을 배워 봅시다.

**Java / Python**

<br>

### 1. 수 정렬하기
[1436번](https://www.acmicpc.net/problem/1436) 
> 시간 복잡도가 O(n²)인 정렬 알고리즘으로 풀 수 있습니다. 예를 들면 삽입 정렬, 거품 정렬 등이 있습니다.
>> N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

<br><br>

- Java
<br>
1. sort 함수 이용

```java
import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        for(int val : arr) {
            System.out.println(val);
        }
    }
}
```

2. 버블 정렬

```java
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        // bubble sort
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N-1; j++) {
                if (arr[j] > arr[j + 1]) { // 앞에 있는 정수가 더 크다면 교환
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for(int val : arr) {
            System.out.println(val);
        }
    }
}
```

3. 삽입 정렬

```java
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        // Insert sort
        for(int i = 0; i < N; i++) {
            int temp = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j] > temp){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        for(int val : arr) {
            System.out.println(val);
        }
    }
}
```

<br><br>

- Python

<br>

1. sort 함수 이용

```python
N = int(input())
num = list()

for i in range(N):
    num.append(int(input()))
num.sort()

for k in num:
    print(k)
```
<br>

2. 버블 정렬

```python
N = int(input())

num = []

for _ in range(N) : 
    num.append(int(input()))

# Bubble Sort
for i in range(len(num)) : 
    for j in range(len(num)) : 
        if num[i] < num[j] : 
            num[i], num[j] = num[j], num[i]
            
for k in num : 
    print(k)
```

<br>

3. 삽입 정렬

```python
N = int(input()) 
num = [] 

for i in range(N): 
    num.append(int(input())) 
    
for j in range(len(num)-1): 
    min_num = min(num[j:]) # 최소값 구하기 
    index = num.index(min_num) 
    num[index] = num[j] 
    num[j] = min_num

for k in num: 
    print(k)
```


<br><br>

---

<br>
