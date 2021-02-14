# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 7. 문자열

Java / Python
<br>

### 7. 상수
[2908번](https://www.acmicpc.net/problem/2908) 
> 숫자를 뒤집어서 비교하는 문제

- Java

```java
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        num1 = (num1 % 10) * 100 + ((num1 % 100) / 10) * 10 + (num1 / 100);
        num2 = (num2 % 10) * 100 + ((num2 % 100) / 10) * 10 + (num2 / 100);
        
        if(num1 > num2)
            System.out.println(num1);
        else
            System.out.println(num2);
        sc.close();
        
    }
}
```
> - (num % 10) * 100 => 일의 자리 수를 백의 자리로
((num1 % 100) / 10) * 10 => 십의 자리 수를 십의 자리로
(num2 / 100) => 백의 자리 수를 일의 자리로 
만들도록 해주었습니다.
- int로 수를 받기 때문에 나눗셈을 이용하여 숫자를 구하고 자릿수에 맞게 10을 곱해주는 방식을 이용했습니다.
- string, list로 하면 위치를 바꿔주거나 출력을 바꿔주면 될 것 같습니다(크기 비교할때만 Integer.parseInt()함수를 이용)

<br>

- Python

```python
num1, num2 = input().split()

num1 = int(num1[::-1]) 
num2 = int(num2[::-1])

if num1 > num2 : 
    print(num1)
else :
    print(num2)
```
> 자바로는 수를 그냥 int 변수로 받아서, 수식으로 계산해냈다면, 파이썬으로는 문자열을 받아 역순으로 바꾸고 int로 변환해주었습니다. 아무래도 언어 특성상 간단하게 매우 간단하게 변환할 수 있어서 이런 식으로 코드를 짜보았습니다..!

<br>

---


<br><br>
### 8. 다이얼
[5622번](https://www.acmicpc.net/problem/5622) 
> 규칙에 따라 문자에 대응하는 수를 출력하는 문제

- Java
```java
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
    
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
 
		int cnt = 0;
		int k = str.length();
        
		for(int i = 0; i < k; i++) {
        
			switch(str.charAt(i)) {
            
			case 'A' : case 'B': case 'C' : 
				cnt += 3;
				break;
               
			case 'D' : case 'E': case 'F' :
				cnt += 4; 
				break;
                
			case 'G' : case 'H': case 'I' :
				cnt += 5; 
				break;
                
			case 'J' : case 'K': case 'L' : 
				cnt += 6;
				break;
                
			case 'M' : case 'N': case 'O' :
				cnt += 7;
				break;
                
			case 'P' : case 'Q': case 'R' : case 'S' : 
				cnt += 8; 
				break;
                
			case 'T' : case 'U': case 'V' : 
				cnt += 9;
				break;
                
			case 'W' : case 'X': case 'Y' : case 'Z' : 
				cnt += 10;
				break;
			}
		}		
		System.out.print(cnt);
	}
}
```
> 이 예제의 경우, 케이스가 여러개로 나뉘어져 있기 때문에, if문과 switch문 중 (그동안 예제에서도 많이 사용하지 않은) switch문을 사용하여 풀어보았습니다. 

<br>

- Python

```python
word = input()
dial = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']
time = 0
for j in range(len(word)):
    for i in dial:
        if word[j] in i:
            time += dial.index(i) + 3
print(time)
```

<br><br>

---

<br>

> 오늘은 문자열 단계 예제입니다!
문자열을 분리하기도 하고 조건에 따라 문자열을 잘 가지고 응용하는 것을 연습해야 될 것 같습니다!
