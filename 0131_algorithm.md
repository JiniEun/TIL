# Baekjoon Online Judge

### algorithm practice

### 1. 입출력과 사칙연산

C++ / Java / Python
<br>

## 1. Hello World 
[2557번](https://www.acmicpc.net/problem/2557)

- Java
~~~~java
public class Main {
 
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
~~~~

- C++
~~~~cpp
#include <iostream>
using namespace std;

int main(){
    cout << "Hello World!" <<endl;
}
~~~~

- Python
~~~~python
print("Hello World!")
~~~~

## 3. 고양이 
[10171번](https://www.acmicpc.net/problem/10171)

- Java
~~~~java
public class Main {
    public static void main(String[] args) {
        System.out.println("\\    /\\");
        System.out.println(" )  ( ')");
        System.out.println("(  /  )");
        System.out.println(" \\(__)|");
        
    }
}
~~~~

- C++
~~~~cpp
#include <iostream>
using namespace std;
int main(void){
    cout << "\\    /\\" << endl;
    cout << " )  ( ')" << endl;
    cout << "(  /  )" << endl;
    cout << " \\(__)|";
}
~~~~

- Python
~~~~python
print("\\    /\\")
print(" )  ( \')")
print("(  /  )")
print(" \\(__)|")
~~~~

## 4. 개
[10172번](https://www.acmicpc.net/problem/10172)

- Java
~~~~java
public class Main {
    public static void main(String[] args) {
        System.out.println("|\\_/|");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"`    |");
        System.out.println("||_/=\\\\__|");
    }
}
~~~~

- C++
~~~~cpp
#include <iostream>
using namespace std;
int main(void){
    cout << "|\\_/|" << endl;
    cout << "|q p|   /}" << endl;
    cout << "( 0 )\"\"\"\\" << endl;
    cout << "|\"^\"`    |" << endl;
    cout << "||_/=\\\\__|";
}
~~~~

- Python
~~~~python
print("|\_/|")
print("|q p|   /}")
print('( 0 )\"\"\"\\')
print("|\"^\"`    |")
print("||_/=\\\\__|")
~~~~




---
그대로 출력하는 문제들은 기본적인 print()문을 이용할 때, 따옴표 등 특수문자를 출력하는 방법을 알고 있는 지 확인하는 문제 같습니다!
( \ : 백슬래시(Back Slash)를 이용해 따옴표, 특수문자를 그대로 출력할 수 있습니다!)  
```python
print("\"")
``` 
=> 출력결과 : `"`
