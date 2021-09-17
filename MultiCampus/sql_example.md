## [평가문제] SQL 평가 문제

1. 사원 테이블과 부서 테이블에서 사원 번호와 사원 이름, 소속부서 번호, 소속부서 이름을 출력하도록 표준 inner join 코드를 생성하세요

```sql
SELECT e.EMPNO, e.ENAME, e.DEPTNO, d.DNAME 
FROM EMP e INNER JOIN DEPT d
ON e.DEPTNO = d.DEPTNO;
```

2. 사원 테이블과 부서 테이블에서 사원 번호와 사원이름, 소속부서 번호와 소속부서 이름을 출력하도록 natural join 코드를 생성하세요.

```sql
SELECT e.EMPNO, e.ENAME, DEPTNO, d.DNAME 
FROM EMP e NATURAL JOIN dept d;
-- 조인에 사용되는 칼럼은 식별자 X
```

3. Player 테이블에서 정남일 선수 소속팀의 선수들에 대한 선수명, 포지션, 백넘버를 출력하는 서브쿼리를 작성하세요. 선수이름으로 오름차순 정렬

```sql
SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버
FROM PLAYER
WHERE TEAM_ID = (SELECT TEAM_ID
					FROM PLAYER p
					WHERE PLAYER_NAME='정남일')
ORDER BY PLAYER_NAME;
```

4. 선수들 중에서 키가 평균 이하인 선수들의 선수명, 포지션, 백넘버를 출력하는 서브쿼리를 작성하세요. 선수이름 오름차순 정렬

```sql
SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버,
FROM PLAYER 
WHERE HEIGHT <= (SELECT AVG(HEIGHT)
					FROM PLAYER)
ORDER BY PLAYER_NAME ;
```

5. 선수테이블과 팀테이블을 조인하여, 선수 자신이 속한 팀의 평균 키보다 작은 선수들의 정보를 출력하는 연관 서브쿼리를 작성하세요.

   선수명으로 오름차순 정렬

```sql
SELECT t.TEAM_NAME 팀명, p.TEAM_ID, p.PLAYER_NAME 선수명, p.POSITION 포지션, p.BACK_NO 백넘버, p.HEIGHT 키
FROM PLAYER p, TEAM t
WHERE p.TEAM_ID = t.TEAM_ID 
AND p.HEIGHT < (SELECT AVG(x.HEIGHT) 
				FROM PLAYER x 
				WHERE x.TEAM_ID = p.TEAM_ID
				GROUP BY x.TEAM_ID) 
ORDER BY PLAYER_NAME;
```

6. 부서명과 업무명을 기준으로 사원수와 급여 합을 GROUP BY SQL 문장을 생성하세요, 부서, 업부별 오름차순정렬

```sql
SELECT d.DNAME, e.JOB, COUNT(*) EMP_CNT, SUM(e.SAL) SAL_SUM
FROM EMP e, DEPT d 
WHERE d.DEPTNO = e.DEPTNO 
GROUP BY d.DNAME, e.JOB
ORDER BY d.DNAME, e.JOB;
```

7. 부서명과 업무명을 기준으로 집계한 일반적인 GROUP BY SQL 문장에 ROLLUP 함수를 사용하여 사원수와 급여합계에 대한 소계를 출력하세요부서, 업무별로 오름차순 정렬

```sql
SELECT d.DNAME, e.JOB, COUNT(*) EMP_CNT, SUM(e.SAL) SAL_SUM
FROM  EMP e, DEPT d
WHERE  d.DEPTNO = e.DEPTNO
GROUP BY ROLLUP (d.DNAME, e.JOB)
ORDER BY d.DNAME, e.JOB;
```

8. 직속상사가  'JONES'인 사원의 사원번호, 사원이름, 직속상사번호를 조회하는 셀프조인을 작성하세요.

   관리자(MGR)가 'JONES'의 EMPNO인 행 조회

```sql
SELECT B.EMPNO, B.ENAME, B.MGR
FROM EMP A, EMP B
WHERE A.ENAME = 'JONES'
AND B.MGR = A.EMPNO;
```

9. 홍길동 선수를 INSERT하려고 할때 PLAYER_ID값은 기존 최대값에 + 1을 더한 값으로 넣고자 합니다. VALUES절에 서브쿼리를 사용해 SQL을 작성하세요.

```sql
INSERT INTO PLAYER (PLAYER_ID, PLAYER_NAME, TEAM_ID)
VALUES ((SELECT TO_CHAR(MAX(TO_NUMBER(PLAYER_ID))+1) FROM PLAYER), '홍길동', 'K06');
```

10. 선수 테이블의 포지션이 NULL인 선수들의 포지션을 ‘MF’로 수정하세요.

```sql
UPDATE PLAYER 
SET POSITION = 'MF'
WHERE POSITION IS NULL;
```



## SQL 문법 순서

- SQL 문법 작성 순서

```
① SELECT 컬럼명
② FROM 테이블명
③ WHERE 조건식
④ GROUP BY 컬럼명
⑤ HAVING 조건식
⑥ ORDER BY 칼럼명
```

- SQL 실행 작동 순서

```
① FROM
② ON
③ JOIN
④ WHERE
⑤ GROUP BY
⑥ CUBE | ROLLUP
⑦ HAVING
⑧ SELECT 
⑨ DISTINCT
⑩ ORDER BY
⑪ TOP
```



