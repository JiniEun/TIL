# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 9. 기본 수학2

Java / Python
<br>

### 2. 소수 
[2581번](https://www.acmicpc.net/problem/2581) 

> 2부터 X-1까지 모두 나눠서 X가 소수인지 판별하는 문제 2

<br>

- Java

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int min =10001;  // M, N이 10,000이하의 자연수
        int cnt=0;
        int result=0;
        
        int input = Integer.parseInt(br.readLine());
        int input2 = Integer.parseInt(br.readLine());
    	for(int i=input; i<=input2; i++) {
    		for(int j=2; j<i; j++) {
    			if(i%j == 0) 
    				cnt++;
    		}
    			if(cnt == 0 && i != 1) {
    				result+=i;
    				if(min>i)
    					min=i;
   				}
   			cnt=0;
   		}
    	if(min==10001) {
    		System.out.println("-1");
    	}else {
    	System.out.println(result);
    	System.out.println(min);
    	}
    }    
}
``` 

<br>

- Python

```python
min_n = int(input())
max_n = int(input())
dc_list = []
 
for i in range(min_n, max_n+1):     
    cnt = 0
    for j in range(1, i+1):          
        if i % j == 0:
            cnt += 1                  
            if cnt > 2:               
                break
    if cnt == 2:                    # 소수
        dc_list.append(i)
if len(dc_list) != 0:              
    print(sum(dc_list))
    print(dc_list[0])
else:                                # 소수가 하나도 없다면
    print('-1')
```

<br><br>

---

<br>


> 오늘은 기본 수학2 예제였습니다!
앞으로는 코드 구현에 관련해서 더 자세히 적어보려고 합니다..!ㅠㅠ
