# Baekjoon Online Judge

### algorithm practice

### 2. if문

Java / Python
<br>

## 1. 두 수 비교하기
[1330번](https://www.acmicpc.net/problem/1330) 

- Java
~~~~java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int A = sc.nextInt();
		int B = sc.nextInt();
        
		sc.close();
        if ( A > B ) {
            System.out.println(">");
        } else if(A == B){
            System.out.println("==");
        } else {
            System.out.println("<");
        }
    }
}
~~~~


- Python
~~~~python
a,b = input().split()
a = int(a)
b = int(b)
if a>b:
    print(">")
elif a<b:
    print("<")
else:
    print("==")
~~~~


## 2. 시험 성적
[9498번](https://www.acmicpc.net/problem/9498)

- Java
~~~java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int A = sc.nextInt();
        sc.close();
        
        if ( A >= 90 ) {
            System.out.println("A");
        } else if(A >= 80){
            System.out.println("B");
        } else if(A >= 70){
            System.out.println("C");
        } else if(A >= 60){
            System.out.println("D");
        }else {
            System.out.println("F");
        }
    }
}
~~~


- Python
~~~python
a = int(input())
if a>=90:
    print("A")
elif a>=80:
    print("B")
elif a>=70:
    print("C")
elif a>=60:
    print("D")
else:
    print("F")
~~~

---
if문을 잘 사용하는 지 알아보는 문제 같습니다!
if문은 조건을 잘 나누는 연습도 중요한 것 같아요..
