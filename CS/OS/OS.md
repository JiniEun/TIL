# 운영체제

- [Byte Ordering](#byte-ordering)
- [메모리](#메모리)
- [process 와 thread의 차이](#process-와-thread의-차이)
- [Context Switching](#context-switching)
- [멀티 프로세스, 멀티 쓰레드](#-멀티-프로세스,-멀티-쓰레드)
- [DeadLock](#deadlock)

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

## 메모리
메모리란 컴퓨터에서 작업을 수행하기 위해 처리 대상이나 결과 등을 저장하기 위한 공간이다. <br>
프로그램을 실행하기 위한 정보들은 메모리에 저장되어 처리된다.

<br><br>

## process 와 thread의 차이

<br>

### Process 

정의 : 메모리에 올라와 실행되고 있는 프로그램의 인스턴스

#### 특징

- 운영체제로부터 독립된 메모리 영역을 할당받는다. (다른 프로세스의 자원에 접근 X)
- 프로세스들은 독립적이기 때문에 통신하기 위해 IPC를 사용해야 한다.
- 프로세스는 최소 1개의 쓰레드(메인 쓰레드)를 가지고 있다. 

<br><br>

### Thread

정의 : 프로세스 내에서 할당받은 자원을 이용해 동작하는 실행 단위 

#### 특징

- 쓰레드는 프로세스 내에서 Stack만 따로 할당 받고, Code, Data, Heap 영역은 공유한다.
- 쓰레드는 프로세스의 자원을 공유하기 때문에 다른 쓰레드에 의한 결과를 즉시 확인할 수 있다.
- 프로세스 내에 존재하며 프로세스가 할당받은 자원을 이용하여 실행된다.


<br><br>

> **IPC** <br>
> Inter Process Communication : 프로세스 간 통신 

<br><br><br>

## Context Switching

Context Switching이란 interrupt를 발생시켜 CPU에서 실행중인 프로세스를 중단하고, 다른 프로세스를 처리하기 위한 과정이다. <br>
현재 실행중인 프로세스의 상태(Context)를 먼저 저장하고, 다음 프로세스를 동작시켜 작업을 처리한 후에 이전에 저장된 프로세스의 상태를 다시 복구한다. <br>

<br><br>

> **Interrupt** <br>
> 인터럽트(Interrupt) :  CPU가 프로세스를 실행하고 있을 때, 입출력 하드웨어 등의 장치나 예외상황이 발생하여 처리가 필요함을 CPU에 알리는 것.

<br><br><br>

## 멀티 프로세스, 멀티 쓰레드

<br>

### 멀티 프로세스

하나의 프로그램을 여러 개의 프로세스로 구성하여 각 프로세스가 1개의 작업을 처리하도록 하는 것

#### 특징

- 1개의 프로세스가 죽어도, 자식 프로세스 이외의 다른 프로세스들은 계속 실행된다.
- Context Switching을 위한 오버헤드(캐시 초기화, 인터럽트 등)가 발생한다.
- 프로세스는 각각 독립적인 메모리를 할당받았기 때문에 통신하는 것이 어렵다.

<br><br>

### 멀티 쓰레드

하나의 프로그램을 여러 개의 쓰레드로 구성하여 각 쓰레드가 1개의 작업을 처리하도록 하는 것

#### 특징

- 프로세스를 위해 자원을 할당하는 시스템콜이나 Context Switching의 오버헤드를 줄일 수 있다.
- 쓰레드는 메모리를 공유하기 때문에, 통신이 쉽고 자원을 효율적으로 사용할 수 있다.
- 하나의 쓰레드에 문제가 생기면 전체 프로세스가 영향을 받는다.
- 여러 쓰레드가 하나의 자원에 동시에 접근하는 경우 자원 공유(동기화)의 문제가 발생할 수 있다.

<br><br>

## DeadLock

데드락(= DeadLock = 교착상태)이란 한정된 자원을 여러 프로세스가 사용하고자 할 때 발생하는 상황으로, 프로세스가 자원을 얻기 위해 영구적으로 기다리는 상태이다.
<br>

Ex) 자원 A를 가진 프로세스 P1, 자원 B를 가진 프로세스 P2가 있는 경우 <br>
P1이 B를 필요로 하고, P2가 A를 필요로 하게 되는 경우에 두 프로세스 P1, P2는 서로 자원을 얻기 위해 무한정 기다리게 된다.

<br><br>

## 멀티 쓰레드 프로그래밍 작성 시 유의점

멀티 쓰레드 프로그램을 개발한다면, 다수의 쓰레드가 공유 데이터에 동시에 접근하는 경우, 상호배제 또는 동기화 기법을 통해 동시성 문제 또는 교착 상태가 발생하지 않도록 주의해야 한다.

<br><br>

## CPU의 메모리 I/O 도중 생기는 병목 현상 해결 방법

- 메모리 계층화
- 자주 접근하는 데이터인 경우 캐시에 저장하여 접근 속도 향상 시키며 부하를 줄인다.

<br><br>