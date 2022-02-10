# 운영체제

<br><br>

## Byte Ordering 

Byte Ordering이란 데이터가 저장되는 순서를 의미한다.
방식에는 빅엔디안(Big Endian), 리틀엔디안(Little Endian)이 있다.

- Big Endian
    - MSB가 가장 낮은 주소에 위치하는 저장 방식
    - 네트워크에서 데이터를 전송할 때 주로 사용됨
    - 가장 낮은 주소에서 MSB가 저장되므로, offset=0인 Byte를 보면 양수/음수를 바로 파악할 수 있다.

<br>

- Little Endian
    - MSB가 가장 높은 주소에 위치하는 방식
    - 마이크로프로세서에서 주로 사용된다.
    - 가장 낮은 주소에 부호값이 아닌 데이터가 먼저 오기 때문에, 바로 연산을 할 수 있다.

<br>

> **MSB, LSB**
> LSB란 <br>
> = Least Significant Bit <br>
> 하나의 데이터 형에서의 가장 낮은 위치의 Bit를 의미한다.
> <br><br>
> MSB란 <br>
> Most Significant Bit <br>
> 어떠한 데이터 형의 최상위 비트를 의미한다.




