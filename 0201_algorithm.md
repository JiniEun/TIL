# Baekjoon Online Judge

### algorithm practice

### 1. 입출력과 사칙연산

C++ / Java / Python
<br>

## 5. A + B
[1000번](https://www.acmicpc.net/problem/1000) A + B
[1001번](https://www.acmicpc.net/problem/1001) A - B
[10998번](https://www.acmicpc.net/problem/10998) A x B
[A - B(1001번), A x B(10998번) 문제는 부호만 다르게 하면 됩니다!]

- Java
~~~~java
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        
        Scanner s = new Scanner(System.in);
        
        int a_1 = s.nextInt();
        int b_1 = s.nextInt();
        s.close();
        
        System.out.println(a_1 + b_1);
    }
}
~~~~

- C++
~~~~cpp
#include <iostream>

using namespace std;

int main(void){
    int a, b;
    
    cin >> a >> b;
    cout << a + b << endl;
    return 0;
}
~~~~

- Python
~~~~python
a, b = map(int, input().split())
print(a+b)
~~~~


## 8. A / B
[1008번](https://www.acmicpc.net/problem/1008)

- Java
~~~java
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        sc.close();
         
        System.out.println(a / b);
    }
}
~~~

- C++
~~~cpp
#include <iostream>

using namespace std;

int main(void){
    double a, b;
    
    cin >> a >> b;
    cout.precision(15);
    cout << a / b << endl;
    return 0;
}
~~~

- Python
~~~python
a, b = map(int, input().split())
print(a/b)
~~~

---
나눗셈의 경우 실수형인 double을 이용하고, c++에서는 정확도를 위해 유효숫자 15자리를 출력하겠다는 의미를 담은 `cout.precision(15);`코드를 추가했습니다!
