# MySQL

MySQL을 이용한 SpringBoot 웹 프로젝트에서 
페이징 처리를 진행할 때 이용한 방식을 정리해보았습니다.

## LIMIT 방식 (MySQL)

LIMIT 방식을 활용하여 원하는 만큼의 행을 출력할 수 있습니다.

`LIMIT <skip> <count>` 

위 코드와 같이 이용합니다.

예를 들어

``` sql
select *
from board
order by board_id desc
limit 10, 10;
```

일 경우, 10개의 행을 skip 하고 10개(count) 행을 선택한다는 의미입니다.
즉, limit 방식을 활용하여 board_id 기준 역순으로 정렬된 테이블에서 11행부터 20행을 출력합니다.

LIMIT방식은 Rownum방식에 비해 전체적으로 빠른 검색 속도를 보여줍니다. (하지만 LIMIT 방식도 'Rownum 방식 2'와 똑같이 뒷 행으로 갈수록 검색 속도가 느려지는 현상이 나타난다고 합니다.)
