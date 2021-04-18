# Baekjoon Online Judge

## algorithm practice
<br>

## - 단계별 문제풀기
<br>

## 16. 그리디 알고리즘(Greedy Algorithm)

> 특정 상황에서 성립하는 그리디 알고리즘을 배워 봅시다.

<br>

---

<br>

**Java / Python**

<br>

### 4. 잃어버린 괄호
[1541번](https://www.acmicpc.net/problem/1541) 
> 식의 값을 가능한 한 작게 만드는 문제

<br>

![](https://images.velog.io/images/jini_eun/post/41f3c1d5-1534-400a-97d9-d67f889cca85/image.png)

<br>

> "잃어버린 괄호" 문제는 가장 최소의 결과를 얻는 괄호를 쳐서 최소의 결과를 얻어내는 문제입니다. 
마이너스를 만날 때 가장 큰 수를 빼면 되는 방식입니다. 마이너스를 만나면 다음 마이너스 까지, 아니면 다음 마이너스가 없으면 모든 수를 더해서 한 번에 빼주는 것입니다. 즉, 뺄셈을 기준으로 문자열을 분리하고 덧셈 부분을 먼저 계산해주고 분리된 문자열들을 뺄셈해주는 것입니다. 

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
        
		int sum = Integer.MAX_VALUE;
		StringTokenizer sub = new StringTokenizer(br.readLine(),"-");
        
		while(sub.hasMoreTokens()){
		int temp = 0;
            
			// 뺄셈으로 토큰 나눔 -> 덧셈으로 분리해서 해당 토큰 더함
			StringTokenizer add = new StringTokenizer(sub.nextToken(),"+");
            
			// 덧셈으로 나누어진 토큰들은 모두 더하기
			while(add.hasMoreTokens()){
				temp += Integer.parseInt(add.nextToken());
			}
            
			if(sum == Integer.MAX_VALUE){
				sum = temp;    // 첫번째 토큰은 temp값이 첫번째 수 
			}else{
				sum -= temp;
			}
		}
		System.out.println(sum);
	}
}
```


<br><br><br>

- Python 

<br>

```python
import sys
N = sys.stdin.readline().split('-')
num = 0

for i in N[0].split('+'):
    num += int(i)
    
for i in N[1:]:
    for j in i.split('+'):
        num -= int(j)
        
print(num)
```

<br><br>

---

<br>

