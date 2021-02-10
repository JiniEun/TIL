# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 5. 1차원 배열

Java / Python
<br>

### 6. OX 퀴즈
[8958번](https://www.acmicpc.net/problem/8958) 
> OX 퀴즈의 결과를 일차원 배열로 입력받아 점수를 계산하는 문제

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String arr[] = new String[sc.nextInt()];
 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		sc.close();
		
		for (int i = 0; i < arr.length; i++) {
			int cnt = 0;	
			int sum = 0;	
			
			for (int j = 0; j < arr[i].length(); j++) {
				
				if (arr[i].charAt(j) == 'O') {
					cnt++;
				} 
				else {
					cnt = 0;
				}
				sum += cnt;
			}
			System.out.println(sum);
		}
	}
}
```

<br>

- Python

```python
num = int(input())
for i in range(num):
    g = str(input())
    nsum = 0
    cnt = 0
    for j in list(g):
        if j =='O':
            cnt += 1
        else:
            cnt = 0
        nsum += cnt
    print(nsum)
```
<br>

---


<br><br>

### 7. 평균은 넘겠지
[4344번](https://www.acmicpc.net/problem/4344) 
> 평균을 조작하는 문제

- Java
```java
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   
        int stnum = 0;              
        
        double avg = 0;       
        int[] arr = new int[1000];

        for (int i=0; i < T; i++) {
            stnum = sc.nextInt();
            int total = 0;          // 합계 한번 돌때마다 초기화
            int num = 0;            // 평균넘는 학생수 한번 돌때마다 초기화
        
            for(int j=0; j < stnum; j++) {  // 입력 반복문
                arr[j] = sc.nextInt();
                total += arr[j];        // 합계구하기
            }
            avg = (double)total / stnum; // 평균구하기
            
            for(int j=0; j < stnum; j++) { // 학생수 세기
                if(arr[j]>avg) {
                    num++;
                }
            }
            System.out.printf("%.3f", 100.0 * num / stnum);
            System.out.println("%");
        }
        sc.close();
    }
}


```

<br>

- Python

```python
n = int(input())

for _ in range(n):
    nums = list(map(int, input().split()))
    avg = sum(nums[1:])/nums[0] 
    cnt = 0
    for score in nums[1:]:
        if score > avg:
            cnt += 1  
    rate = cnt/nums[0] *100
    print(f'{rate:.3f}%')
```

<br><br>

---
<br>

> 오늘은 1차원 배열단계 문제 마지막입니다!
1차원 배열을 잘 응용할 수 있다면 충분히 풀 수 있는 문제들인 것 같습니다!
