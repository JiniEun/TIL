# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 6. 함수

Java / Python
<br>

### 1. 정수 N개의 합
[15596번](https://www.acmicpc.net/problem/15596) 
> 정수 n개가 주어졌을 때, n개의 합을 구하는 함수를 작성하는 문제

- Java

```java
public class Test {
    long sum(int[] a) {
        long ans = 0;
        for(int i = 0; i < a.length; i++) {
			ans += a[i];
		}
        return ans;
    }
}

```

<br>

- Python

```python
def solve(a):
    ans = 0
    for num in a:
        ans += num
    return ans
```
<br>

---


<br><br>

### 2. 셀프 넘버
[4673번](https://www.acmicpc.net/problem/4673) 
> 양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수 구현 문제 

- Java
```java
public class Main {
 
    public static void main(String[] args) {
        boolean[] isNotSelfNumber = new boolean[10001];
         
        for (int i = 1; i <= 10000; ++i) {
            int dn = getDn(i);
            if (dn <= 10000) {
                isNotSelfNumber[dn] = true;             
            }
        }
         
        for (int i = 1; i < isNotSelfNumber.length; ++i) {
            if (!isNotSelfNumber[i]) {
                System.out.println(i);              
            }
        }
    }
    private static int getDn(int n) {
        int dn = n;
        while(n > 0) {
            dn += n % 10;
            n /= 10;
        }
        return dn;
    }
}
```

<br>

- Python

```python
num = set(range(1,10001))
g_num = set()
for i in range(1,10001):
    for j in str(i):
        i += int(j)
    g_num.add(i)
self_num = num - g_num
for k in sorted(self_num):
    print(k)
```

<br><br>

### 3. 한수
[1065번](https://www.acmicpc.net/problem/1065) 
> X가 한수인지 판별하는 함수를 정의하여 문제

- Java
```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(hansu(n));
	}

	public static int hansu(int n) {
		int cnt = 0;		
		for(int i = 1; i <= n; i++ ) {
			if(i < 100) {
				cnt ++;	
			} else if(i < 1000) {
				int i1 = i % 10;
				int i2 = (i / 10) % 10;
				int i3 = (i / 100) % 10;
				
				if(i1 - i2 == i2 - i3) {
					cnt ++;		
				}
			}
		}
		return cnt;
	}
}
```

<br>

- Python

```python
n = int(input())
han = 0
for i in range(1, n + 1):
    if i < 100:
        han += 1
    else:
        ns = list(map(int, str(i)))
        if (ns[0] - ns[1] == ns[1] - ns[2]):
            han += 1
print(han)
```

<br><br>

---

<br>

> 오늘은 함수 예제입니다!
함수를 작성하는 법을 잘 숙지하고 이용하면 잘 풀 수 있는 문제들 같습니다
