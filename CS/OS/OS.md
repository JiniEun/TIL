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

> **MSB, LSB** <br>
> LSB란 <br>
> = Least Significant Bit <br>
> 하나의 데이터 형에서의 가장 낮은 위치의 Bit를 의미한다.
> <br><br>
> MSB란 <br>
> Most Significant Bit <br>
> 어떠한 데이터 형의 최상위 비트를 의미한다.

<br><br>

## 메모리란
메모리란 컴퓨터에서 작업을 수행하기 위해 처리 대상이나 결과 등을 저장하기 위한 공간이다. <br>
프로그램을 실행하기 위한 정보들은 메모리에 저장되어 처리된다.

<br><br>

## process 와 thread의 차이

### Process 

정의 : 메모리에 올라와 실행되고 있는 프로그램의 인스턴스

특징

- 운영체제로부터 독립된 메모리 영역을 할당받는다. (다른 프로세스의 자원에 접근 X)
- 프로세스들은 독립적이기 때문에 통신하기 위해 IPC를 사용해야 한다.


### Thread

<br><br>

> **IPC** <br>
> Inter Process Communication : 프로세스 간 통신 

<br><br>
