# CS _ backend(Spring 위주)

#### [CORS]

CORS(Cross-Origin-Resource-Sharing)란 
도메인이 다른 2개의 사이트가 데이터를 주고 받을 때 발생하는 문제이다. 
예를 들어 jj.com에서 jin.com으로 데이터를 요청한다고 할 때, 
따로 설정을 해주지 않는 한 CORS 에러를 만나게 된다.


#### [was와 ws의 차이]

- WAS(Web Application Server)

비지니스 로직을 넣을 수 있음
Tomcat, PHP, ASP, .Net 등

- WS(Web Server)

비지니스 로직을 넣을 수 없음
Nginx, Apache 등

#### [ 많은 트래픽이 발생한 경우 대처하는 방법 ]

스케일 업(Scale Up): 서버에 CPU나 RAM 등을 추가하여 서버의 하드웨어 스펙을 향상시키는 방법이다.
스케일 아웃(Scale Out): 서버를 여러 대 추가하여 시스템을 증가시키는 방법이다.

