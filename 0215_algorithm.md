# Baekjoon Online Judge

## algorithm practice

## 단계별 문제풀기

## 7. 문자열

Java / Python
<br>

### 9. 크로아티아 알파벳
[2941번](https://www.acmicpc.net/problem/2941) 
> 크로아티아 알파벳의 개수를 세는 문제

- Java

```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] croatia= {"c=","c-","dz=","d-","lj","nj","s=","z="};
        String input = sc.nextLine().trim();
        sc.close();
        
        for(int i=0;i < croatia.length;i++) {
            if(input.contains(croatia[i])) {
                input = input.replaceAll(croatia[i],"a");
            }
        }   
        System.out.println(input.length());
    }
}
```
> 참고사항 : 'dz='의 경우 'z='을 포함하고 있기 때문에 순서를 먼저 해주어야 합니다..!

<br>

- Python

```python
word = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
alpha = input() 
for a in word: 
    alpha = alpha.replace(a, '*') 
print(len(alpha))
```

<br>

---


<br><br>
### 10. 그룹 단어 체커
[1316번](https://www.acmicpc.net/problem/1316)
> 조건에 맞는 문자열을 찾는 문제

- Java
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] words = new String[num];
        int groupWordsCount = 0;

        for (int i = 0; i < num; i++) {
            words[i] = sc.next();
        }

        for (int i = 0; i < num; i++) {
            int[] groupWords = new int[26];
            boolean groupWordsCheck = true;

            for (int j = 0; j < words[i].length(); j++) {
                if (groupWords[(int)words[i].charAt(j) - 97] > 0) {
                    groupWordsCheck = false;
                    break;
                }
                int cnt = 1;

                for (int k = j + 1; k < words[i].length(); k++) {
                    if (words[i].charAt(j) != words[i].charAt(k)) {
                        groupWords[(int)words[i].charAt(j) - 97] = cnt;
                        break;
                    }

                    j++;
                    cnt++;
                }
            }

            if (groupWordsCheck) {
                groupWordsCount++;
            }
        }

        System.out.println(groupWordsCount);
    }
}
```
> 조건에 따라 나눠서 다른 예제보다 코드가 좀 길어졌는데, 다음에 시간이 된다면 조금은 더 간단하게 수정하고자 합니다..ㅎ

<br>

- Python

```python
num = int(input())
result = 0

for i in range(num):
    word = input()
    for j in range(len(word)):
        if j!=len(word)-1:
            if word[j]==word[j+1]:
                pass
            elif word[j] in word[j+1:]:
                break
        else:
            result+=1
print(result)
```

<br><br>

---

<br>


> 오늘은 문자열 단계 마지막 예제입니다!
문자열을 분리하기도 하고 조건에 따라 문자열을 잘 가지고 응용하는 것을 연습해야 될 것 같습니다!
