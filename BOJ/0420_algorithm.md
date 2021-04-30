# Baekjoon Online Judge

## algorithm practice
<br>

## - 단계별 문제풀기
<br>

## 17. 정수론 및 조합론

> 정수론과 조합론을 배워 봅시다.

<br>

---

<br>

**Java / Python**

<br>

### 1. 배수와 약수
[5086번](https://www.acmicpc.net/problem/5086) 
> 배수와 약수를 배우는 문제

<br>

![](https://images.velog.io/images/jini_eun/post/4c32090e-9c63-4a56-9b1f-26532256d3d3/image.png)

<br>

> 이번 문제는 첫번째 수가 두번째 숫자의 약수라면 factor, 배수라면 mutiple, 둘 다 아니면 neither를 출력하는 비교적 간단한 문제입니다.

<br><br>

- Java

<br>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int num1 = 0;
		int num2 = 0;
        
		StringTokenizer st;
        
		while(true){
			st = new StringTokenizer(br.readLine(), " ");
            
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
            
			if(num1 == 0 && num2 == 0) break;
            
			if(num2 % num1 == 0){
				System.out.println("factor");
			}else if(num1 % num2 == 0){
				System.out.println("multiple");
			}else{
				System.out.println("neither"); 
			}
            
		}
	
	}
}
```


<br><br><br>

- Python 

<br>

```python
import sys
while True:
    num1, num2 = map(int, sys.stdin.readline().split())
    
    if num1 == 0 and num2 == 0:
        break
        
    if num2 % num1 == 0:
        print("factor")
    elif num1 % num2 == 0:
        print("multiple")
    else:
        print("neither")

```

<br><br>

---

<br>

