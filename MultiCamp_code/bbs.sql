DROP TABLE bbs PURGE; 
 
CREATE TABLE bbs ( 
  bbsno    NUMBER(7)       NOT NULL,   -- 글 일련 번호, -9999999 ~ +9999999 
  wname   VARCHAR(20)    NOT NULL,   -- 글쓴이 
  title        VARCHAR(100)  NOT NULL,   -- 제목(*) 
  content   VARCHAR(4000) NOT NULL,  -- 글 내용 
  passwd   VARCHAR(15)     NOT NULL,  -- 비밀 번호 
  viewcnt   NUMBER(5)       DEFAULT 0,  -- 조회수, 기본값 사용 
  wdate     DATE               NOT NULL,  -- 등록 날짜, sysdate 
  grpno     NUMBER(7)       DEFAULT 0, -- 부모글 번호 
  indent    NUMBER(2)       DEFAULT 0,  -- 답변여부,답변의 깊이
  ansnum  NUMBER(5)       DEFAULT 0,  -- 답변 순서 
  PRIMARY KEY (bbsno)  
); 

-- c(create, insert)
-- 일련번호 생성
SELECT max(bbsno) AS max FROM bbs;

SELECT * FROM bbs
ORDER BY bbsno asc;


SELECT nvl(max(bbsno),0)+1 AS bbsno FROM bbs;

INSERT INTO bbs(bbsno, wname, title, content, passwd, wdate)  
VALUES((SELECT NVL(MAX(bbsno), 0) + 1 as bbsno FROM bbs), 
'홍길동', '게시판제목', '게시판내용', '1234', sysdate);              


-- read(select)
UPDATE bbs
SET VIEWCNT = VIEWCNT + 1
WHERE bbsno=1;

SELECT * FROM bbs
WHERE bbsno = 1;

--update(수정)
UPDATE BBS
SET wname = '왕눈이',
	title = '제목수정',
	content = '내용 수정'
WHERE BBSNO = 1;

-- 비번 검증 (cnt : 1-인증성공(1234) / cnt:0-인증실패(12345) )
SELECT count(bbsno) AS cnt
FROM bbs
WHERE bbsno = 1
AND PASSWD = '1234';


-- DELETE(삭제)
DELETE FROM BBS
WHERE bbsno=1;

--목록(페이징, 검색)
SELECT bbsno, wname, title, content, viewcnt, wdate
FROM bbs
ORDER BY bbsno DESC;

SELECT bbsno, wname, passwd FROM bbs;


-- 1) 성명 검색 글 목록(S:Search List) 
SELECT bbsno, wname, title, content, passwd, viewcnt, wdate, grpno, indent, ansnum 
FROM bbs  
WHERE wname LIKE '%왕눈이%' 
ORDER BY bbsno DESC;  
 
 
-- 2) 제목 검색 글 목록(S:Search List) 
SELECT bbsno, wname, title, content, passwd, viewcnt, wdate, grpno, indent, ansnum 
FROM bbs  
WHERE title LIKE '%독도%' 
ORDER BY bbsno DESC;  
 
 
 
-- 3) 내용 검색 글 목록(S:Search List) 
SELECT bbsno, wname, title, content, passwd, viewcnt, wdate, grpno, indent, ansnum 
FROM bbs  
WHERE content LIKE '%독도%' 
ORDER BY bbsno DESC;  
 
 
-- 4) 파이프 기호를 통한 SQL 결합 
SELECT ('A' || 'B' || 'C' || 'D') as "grade" 
FROM dual; 

 
SELECT ('등록자: ' || wname) as "wname"  
FROM bbs; 


-- 1001

-- 10개 정도 추가한다.
INSERT INTO bbs(bbsno, wname, title, content, passwd, wdate,grpno)  
VALUES((SELECT NVL(MAX(bbsno), 0) + 1 as bbsno FROM bbs), 
'왕눈이', '제목', '내용', '123', sysdate,
(SELECT NVL(MAX(grpno), 0) + 1  FROM bbs)
);
 
select * from bbs;
 
 
2. 페이징이 되는 소스
--정렬
SELECT bbsno, wname, title, viewcnt, wdate, grpno, indent, ansnum
FROM bbs  
ORDER BY grpno DESC, ansnum ASC; 
 
 
-- rownum 생성 
SELECT bbsno, wname, title, viewcnt, wdate, grpno, 
indent, ansnum, rownum
FROM ( 
      SELECT bbsno, wname, title, viewcnt, wdate, grpno,
      indent, ansnum
      FROM bbs  
      ORDER BY grpno DESC, ansnum ASC 
);
 
 
-- rownum 값에 따른 페이지 분리 
SELECT bbsno, wname, title, viewcnt, wdate, grpno, 
indent, ansnum, r 
From(
    SELECT bbsno, wname, title, viewcnt, wdate, grpno, 
    indent, ansnum, ROWNUM r
    FROM ( 
         SELECT bbsno, wname, title, viewcnt, wdate, grpno,
         indent, ansnum
         FROM bbs  
         ORDER BY grpno DESC, ansnum ASC 
    ) 
)where r >= 1 and r <= 10

-- 추가부분
SELECT bbsno, wname, title, viewcnt, wdate, grpno, 
indent, ansnum, r 
From(
    SELECT bbsno, wname, title, viewcnt, wdate, grpno, indent, ansnum, ROWNUM r
    FROM ( 
         SELECT bbsno, wname, title, viewcnt, wdate, grpno, indent, ansnum
         FROM bbs  
         WHERE wname LIKE '%왕%' 
         ORDER BY grpno DESC, ansnum ASC 
    ) 
)where r >= 1 and r <= 10



-- 답변
-- indent 답변의 깊이.. 답변의 답변.



-- 1) 모든 레코드 삭제 
DELETE FROM bbs; 

       
 
-- 2) 부모글(일반적인 글) 등록 
 
INSERT INTO bbs(bbsno, wname, title, content, passwd, wdate, 
grpno)  
VALUES((SELECT NVL(MAX(bbsno), 0) + 1 as bbsno FROM bbs), 
'왕눈이', '부모글3', '내용', '123', sysdate,
(SELECT NVL(MAX(grpno), 0) + 1 as grpno FROM bbs)
);                 
 
         
SELECT bbsno, title, PASSWD, grpno, indent, ansnum 
FROM bbs  
ORDER BY grpno DESC, ansnum ASC; 
  
     
-- 3) 답변처리
-- read(부모의 title,grpno,indent,ansnum) : 첫번째
select bbsno, title, grpno, indent, ansnum
from bbs
where bbsno=2 --부모의 글

     

-- 답변등록(부모의같은 grpno, 부모+ 1 -> indent,ansnum): 세번째
INSERT INTO bbs(bbsno, wname, title, content, passwd, wdate, grpno, indent, ansnum)
VALUES((SELECT NVL(MAX(bbsno), 0) + 1 AS bbsno
	FROM bbs), 
  '아로미', '부모글1 답변글2', '내용', '123', sysdate, 2, 1, 1);
 
     
-- 부모글의 2차이상의 답변인 경우 ansnum(답변의 순서) 재정렬 :두번째
UPDATE bbs 
SET ansnum = ansnum + 1 
WHERE grpno=2 AND ansnum > 0; 


DELETE FROM BBS
WHERE grpno = 0;

SELECT bbsno, wname, wdate
FROM bbs;
