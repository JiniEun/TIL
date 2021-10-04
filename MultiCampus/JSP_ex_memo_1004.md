# JSP

## Memo Example

메모 

(게시판 기능 코드 연습. 게시판에서 작성한 코드들을 memo에 맞게 다시 코딩 해보기)

- sql

```sql
CREATE TABLE memo ( 
  memono    NUMBER(7)       NOT NULL,   -- 글 일련 번호, -9999999 ~ +9999999 
  wname   VARCHAR(20)    NOT NULL,   -- 글쓴이 
  title        VARCHAR(100)  NOT NULL,   -- 제목(*) 
  content   VARCHAR(4000) NOT NULL,  -- 글 내용 
  passwd   VARCHAR(15)     NOT NULL,  -- 비밀 번호 
  viewcnt   NUMBER(5)       DEFAULT 0,  -- 조회수, 기본값 사용 
  wdate     DATE               NOT NULL,  -- 등록 날짜, sysdate 

  PRIMARY KEY (memono)  
); 

insert into memo(memono, wname, title, content, passwd, wdate)
values((SELECT nvl(MAX(memono),0)+1 from memo),
'홍길동', '오늘의 일정', '2시 점심약속', '1234', sysdate);

SELECT * FROM memo;


SELECT * FROM memo
WHERE memono = 1;

-- update
UPDATE memo
SET title = '오늘의 일정 취소',
	content = '2시 점심 약속을 7시 저녁 약속으로 변경'
WHERE memono = 1;

-- delete
DELETE memo
WHERE memono = 1;

-- passcheck 
SELECT count(memono) AS cnt
FROM memo
WHERE memono = 1 AND passwd = '1234';


-- 조회수 증가
UPDATE memo
SET viewcnt = viewcnt + 1
WHERE memono = 1;

-- 목록 
SELECT memono, wname, title, viewcnt, wdate, r
FROM(
	SELECT memono, wname, title, viewcnt, wdate, rownum r
	FROM (
		SELECT memono, wname, title, viewcnt, wdate
		FROM memo
		--WHERE wname LIKE '%김%'; -- wname, title, content, title_content
		ORDER BY memono DESC
	)
)WHERE r >= 5 AND r <= 10;
```



- MemoDTO

```java
package memo;

public class MemoDTO {
	private int memono;
	private String wname;
	private String title;
	private String content;
	private String passwd;
	private int viewcnt;
	private String wdate;
	public MemoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemoDTO(int memono, String wname, String title, String content, String passwd, int viewcnt, String wdate) {
		super();
		this.memono = memono;
		this.wname = wname;
		this.title = title;
		this.content = content;
		this.passwd = passwd;
		this.viewcnt = viewcnt;
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "MemoDTO [memono=" + memono + ", wname=" + wname + ", title=" + title + ", content=" + content
				+ ", passwd=" + passwd + ", viewcnt=" + viewcnt + ", wdate=" + wdate + "]";
	}
	public int getMemono() {
		return memono;
	}
	public void setMemono(int memono) {
		this.memono = memono;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
}
```



- MemoDAO

```java
package memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import utility.DBClose;
import utility.Open;

public class MemoDAO {
	public boolean create(MemoDTO dto) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into memo(memono, wname, title, content, passwd, wdate) ");
		sql.append(" values((SELECT nvl(MAX(memono),0)+1 from memo), ");
		sql.append(" ?,?,?,?, sysdate) ");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getWname());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPasswd());

			int cnt = pstmt.executeUpdate();

			if (cnt > 0)
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, con);
		}

		return flag;
	}

	public MemoDTO read(int memono) {
		MemoDTO dto = null;
		Connection con = Open.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT memono, wname, title, content, viewcnt, ");
		sql.append(" to_char(wdate,'yyyy-mm-dd') wdate ");
		sql.append(" FROM memo   ");
		sql.append(" WHERE memono = ?  ");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, memono);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new MemoDTO();
				dto.setMemono(rs.getInt("memono"));
				dto.setWname(rs.getString("wname"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setViewcnt(rs.getInt("viewcnt"));
				dto.setWdate(rs.getString("wdate"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstmt, con);
		}

		return dto;
	}

	public void upViewcnt(int memono) {
		Connection con = Open.getConnection();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE memo ");
		sql.append(" SET viewcnt = viewcnt + 1 ");
		sql.append(" WHERE memono = ? ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, memono);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, con);
		}
	}

	public boolean update(MemoDTO dto) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();

		sql.append(" UPDATE memo ");
		sql.append(" SET         ");
		sql.append("     wname = ?, ");
		sql.append("     title = ?, ");
		sql.append(" 	 content = ? ");
		sql.append(" WHERE memono = ? ");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getWname());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getMemono());

			int cnt = pstmt.executeUpdate();
			if (cnt > 0)
				flag = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, con);
		}

		return flag;
	}

	public boolean delete(int memono) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" delete from memo ");
		sql.append(" where memono = ? ");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, memono);

			int cnt = pstmt.executeUpdate();
			if (cnt > 0)
				flag = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstmt, con);
		}

		return flag;
	}

	public boolean passCheck(Map map) {
		boolean flag = false;
		Connection con = Open.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT count(memono) AS cnt ");
		sql.append(" FROM memo ");
		sql.append(" WHERE memono = ? AND passwd = ? ");
		
		int memono = (Integer)map.get("memono");
		String passwd = (String)map.get("passwd");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, memono);
			pstmt.setString(2, passwd);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			int cnt = rs.getInt("cnt");
			
			if(cnt>0) flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstmt, con);
		}

		return flag;
	}

	public List<MemoDTO> list(Map map) {
		List<MemoDTO> list = new ArrayList<MemoDTO>();
		Connection con = Open.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String col = (String)map.get("col"); //wname, title, content, title_content
		String word = (String)map.get("word");
		int sno = (Integer)map.get("sno");
		int eno = (Integer)map.get("eno");
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT memono, wname, title, content, viewcnt, to_char(wdate,'yyyy-mm-dd') wdate, r ");
		sql.append(" FROM( ");
		sql.append(" 	SELECT memono, wname, title, viewcnt, content, wdate, rownum r ");
		sql.append(" 	FROM ( ");
		sql.append(" 		SELECT memono, wname, title, content, viewcnt, wdate ");
		sql.append(" 		FROM memo ");
		
		if(word.trim().length() > 0 && col.equals("title_content")) {
			sql.append("       where title like '%'||?||'%' ");// =>'%왕%' 왕=>word
			sql.append("       or  content like '%'||?||'%' ");
		} else if (word.trim().length() > 0) {
			sql.append("       where "+col+" like '%'||?||'%' ");
		}
		
		sql.append(" 		ORDER BY memono DESC ");
		sql.append(" 	) ");
		sql.append(" )WHERE r >= ? AND r <= ? ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
		
			int i = 0;
			
			if(word.trim().length() > 0 && col.equals("title_content")) {
				pstmt.setString(++i, word);
				pstmt.setString(++i, word);
				
			} else if (word.trim().length() > 0) {
				pstmt.setString(++i, word);
			}
			
			pstmt.setInt(++i, sno);
			pstmt.setInt(++i, eno);
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				MemoDTO dto = new MemoDTO();
				dto.setMemono(rs.getInt("memono"));
				dto.setWname(rs.getString("wname"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setViewcnt(rs.getInt("viewcnt"));
				dto.setWdate(rs.getString("wdate"));
				
				list.add(dto);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstmt, con);
		}
		
		return list;
	}

	public int total(String col, String word) {
		int total = 0;
		Connection con = Open.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT count(*) from memo ");
		if(word.trim().length() > 0 && col.equals("title_content")) {
			sql.append(" where title like '%'||?||'%' ");// =>'%왕%' 왕=>word
			sql.append(" or  content like '%'||?||'%' ");
		} else if (word.trim().length() > 0) {
			sql.append(" where "+col+" like '%'||?||'%' ");
		}
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			if(word.trim().length() > 0 && col.equals("title_content")) {
				pstmt.setString(1, word);
				pstmt.setString(2, word);
				
			} else if (word.trim().length() > 0) {
				pstmt.setString(1, word);
			}
						
			rs = pstmt.executeQuery();
			
			rs.next();
			total = rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		
		return total;
	}

}
```

































































