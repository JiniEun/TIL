# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 2. if문

Java / Python
<br>

### 3. 윤년
[2753번](https://www.acmicpc.net/problem/2753) 

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int A = sc.nextInt();
		sc.close();
        
		if ( (A % 4 == 0 && A % 100 != 0)||A%400==0) {
 			System.out.println("1");
		} else {
 			System.out.println("0");
		}
	}
}
```


- Python
~~~~python
a = int(input())
if (a%4==0 and a%100!=0) or a%400==0:
    print("1")
else:
    print("0")
~~~~

---
>윤년 문제는 처음 if문을 배울 때, 꽤 자주 나오는 기본문제 같습니다..!
*윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 / 또는 400의 배수일 때 입니다!*

<br><br>

### 4. 사분면 고르기
[14681번](https://www.acmicpc.net/problem/14681) 

- Java
~~~java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();
        
		if ( x>0 && y>0) {
 			System.out.println("1");
		} else if(x<0 && y>0){
			System.out.println("2");
		} else if(x<0 && y<0){
			System.out.println("3");
		}else {
			System.out.println("4");
		}
	}
}
~~~

- Python
```python
x = int(input())
y = int(input())

if (x>0 and y>0):
    print("1")
elif (x<0 and y>0):
    print("2")
elif (x<0 and y<0):
    print("3")
else:
    print("4")
```

<br><br>

### 5. 알람 시계
[2884번](https://www.acmicpc.net/problem/2884)

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int h = sc.nextInt();
		int m = sc.nextInt();
		sc.close();

		if ( m < 45 ) {
			m = m + 15;
			h = h - 1;
			if( h < 0 ){
				h = 23;
			}
		}else{
			m = m - 45;
		}
		System.out.println(h+" "+m);
	}
}
````

- Python
```python
h, m = input().split()
h = int(h)
m = int(m)

if m >= 45:
    m = m - 45
else:
    if h <= 0:
        h = 23
    else: 
        h = h - 1
    m = m + 15
print(h, m)
```

>알람시계 문제의 경우,
시(h)와 분(m)을 if문 조건을 어떻게 나눌것인지 기준을 정해야 한다.
간단하게 조건을 정리해보면 다음과 같다.
>> 1. (m >=45) => m = m -45
>>2. (m < 45) => m = 60 - (45 - m)
>>	 2-1. h <= 0 => h = 23
>>	 2-2. h = h - 1


---
if문을 잘 사용하는 지 알아보는 문제들입니다!
if문은 조건을 잘 나누는 연습도 중요한 것 같습니다!
