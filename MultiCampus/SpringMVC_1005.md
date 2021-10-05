# Spring

## MVC(Model, View, Controller) 모델

### 비즈니스 로직과 표현의 분리

- 장점

\- 디자이너는 표현에 집중하여 개발, 프로그래머는 비즈니스 로직에 전념하여 개발 -> 효율성이 높아짐

\- 웹 응용프로그램의 수정이 쉽다.

\- 웹 응용프로그램의 확장이 쉽다.

\- 웹 응용프로그램의 유지보수가 쉽다.

\- jsp와 javabeans로 개발한 경우는 비즈니스 로직과 표현을 완전히 분리하기 쉽지 않을 뿐 아니라 프로젝트 규모가 커질수록 더욱 어려움이 생긴다.

\- 이런문제의 해결책으로 웹 응용프로그램을 비즈니스 로직과 표현으로
 분리하여 개발하고자 하는 것이 MVC 모델.



### MVC 모델 정의

\- 1979년 제록스 사 팔로 알토 연구소에서 스몰톡(SmallTalk)이라는 객체지향 언어를 사용한 사용자 인터페이스 개발에 소개된 개념으로 오랫동안 GUI(Graphical User Interface)개발 분야에서 사용된 개발 패턴이다.

\- 새로운 개발 방법이 아니라 기존의 MVC 개발 모델이 웹 응용프로그램 개발에도 적합하다는 것이 입증되어, JSP개발자들에게 권고하는 개발 모델이다.

\- 모델은 웹 응용프로그램을 구성하는 서버 모듈을 사용자에게 보이는 표현을 뷰(View)로, 자료와 비즈니스 로직 처리를 모델(Model)로, 그리고 이들 상호 간의 흐름을 제어하는 컨트롤러(Controller)로 분리하여 개발하는 모델.



| MVC 요소   | 구현 프로그램 | 역할                                   |
| ---------- | ------------- | -------------------------------------- |
| Model      | 자바빈즈      | 자료의 비즈니스 로직 처리              |
| View       | JSP, HTML     | 표현(Presentation) 부분 처리           |
| Controller | 서블릿        | 적절한 Model을 처리하여 뷰로 제어 이동 |



![image-20211005093626710](SpringMVC_1005.assets/image-20211005093626710.png)



## MVC 개발

### JSP+JavaBeans 개발과 MVC 모델 구조

#### Model 1(JSP+JavaBeans)의 구조 

![image-20211005093841724](SpringMVC_1005.assets/image-20211005093841724.png)



#### Model2(MVC) 구조

![image-20211005093900406](SpringMVC_1005.assets/image-20211005093900406.png)



#### Controller의 처리순서







#### Command Pattern에 기반한 Controller의 처리순서 









### MVC App 개발 순서

#### JSP + JavaBeans 개발 순서 



① DBMS 설정 
② DTO(Data Transfer Object) Class 제작 
③ DAO(Data Access Object) Class 제작 
④ Service Class 제작 
⑤ Service/DAO test 
⑥ JSP 생성 연동 



#### MVC Web Application 개발 순서 

① DBMS 설정 
② DTO(Data Transfer Object) Class 제작 
③ DAO(Data Access Object) Class 제작 
④ Service Class 제작 
⑤ Service/DAO test 
⑥ Servlet Controller 제작 
⑦ Action Interface 제작 
⑧ Action 구현 Class 제작 
    . Service Class 연동 

⑨ JSP 생성 연동 





## Properties class, String class, Class class

### Properties Class

 \- 키와 값의 구조를 가지고 있으며 특정 객체를 생성하는 경우에 초기값으로 많이 
  사용한다. 
 \- 상속 구조 
java.lang.Object 
  java.util.Dictionary<K,V> 
    java.util.Hashtable<Object,Object> 
      java.util.Properties<String,String> 



#### Properties 파일

\- STS Setting 
  . Project Type: Dynamic Web Project 
  .       Name: test



jdbc.properties













> classTest.java

실행

![image-20211005112633035](SpringMVC_1005.assets/image-20211005112633035.png)

코드

```
```





## request JSP 내부 객체



### request 객체에 객체 저장

\- mvc_test 프로젝트에서 작업

> request_test.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="font-size:xx-large; text-align: center;">
<% 
	request.setAttribute("name", "개발자"); 
	out.println("name: " + request.getAttribute("name") + "<br/>"); 
 
	request.setAttribute("count", 0); 
	out.println("count: " + request.getAttribute("count") + "<br/>"); 
 
	Object obj = request.getAttribute("count"); 
	int count = (Integer)obj; 
	count = count + 100; 
	
	request.setAttribute("count", count); 
 
	out.println("count: " + request.getAttribute("count") + "<br/>"); 
 
%> 
</div>
</body>
</html>
```



> 결과 확인

```
http://localhost:8000/test/request_test.jsp
```

![image-20211005130931919](SpringMVC_1005.assets/image-20211005130931919.png)



### 다른 페이지 요청

![image-20211005131014572](SpringMVC_1005.assets/image-20211005131014572.png)

#### `<jsp:forward page="" />`

\- 기존요청에 대신 응답으로 다른페이지로 이동한다.
\- 기존의 request객체가 살아있으므로 그영역의 저장된 모든 데이터는
  유지된다.

![image-20211005132647192](SpringMVC_1005.assets/image-20211005132647192.png)

#### `response.sendRedirect( );`
 \-  재요청에 대한 응답으로  다른 페이지로 이동합니다.
 \-  새로운 request객체가 생성되므로  기존 request영역에 저장된 모든 데이터가 없어진다.

#### `<jsp:include page=""/>`
 \- 다른 자원을 요청 페이지에 포함시킨다.

![image-20211005132654054](SpringMVC_1005.assets/image-20211005132654054.png)





> request.PageInfo.java

```java
package request;

public class PageInfo {
	private int nowPage = 0;
	private String searchColumn = "";
	private String searchWord = "";

	/**
	 * 기본 생성자
	 */
	public PageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nowPage
	 * @param searchColumn
	 * @param searchWord
	 */
	public PageInfo(int nowPage, String searchColumn, String searchWord) {
		super();
		this.nowPage = nowPage;
		this.searchColumn = searchColumn;
		this.searchWord = searchWord;
	}

	/**
	 * @return the nowPage
	 */
	public int getNowPage() {
		return nowPage;
	}

	/**
	 * @param nowPage the nowPage to set
	 */
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	/**
	 * @return the searchColumn
	 */
	public String getSearchColumn() {
		return searchColumn;
	}

	/**
	 * @param searchColumn the searchColumn to set
	 */
	public void setSearchColumn(String searchColumn) {
		this.searchColumn = searchColumn;
	}

	/**
	 * @return the searchWord
	 */
	public String getSearchWord() {
		return searchWord;
	}

	/**
	 * @param searchWord the searchWord to set
	 */
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
}
```



> webapp/request/pageinfo.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="request.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	PageInfo info = new PageInfo();
	info.setNowPage(1);
	info.setSearchColumn("title"); 
	info.setSearchWord("JSP");
	
	request.setAttribute("info", info);
	
	//response.sendRedirect("pageinfo2.jsp"); 
%>
<!-- 현재페이지 요청을 pageinfo2.jsp가 대신 응답된다.-->  
<jsp:forward page="/request/pageinfo2.jsp"/>
</body>
</html>
```



> webapp/request/pageinfo2.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="request.*"%>
<%
	PageInfo info = (PageInfo) request.getAttribute("info");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="font-size: xx-large; text-align: center;"> 
<h2>  pageinfo2.jsp 입니다.</h2> 
    nowPage:      <%=info.getNowPage() %> <br/> 
    searchColumn: <%=info.getSearchColumn() %> <br/> 
    searchWord:   <%=info.getSearchWord() %> <br/> 
 
</div> 
</body>
</html>
```



> 결과 확인

```
http://localhost:8000/test/request/pageinfo.jsp
```



![image-20211005132536538](SpringMVC_1005.assets/image-20211005132536538.png)







## MVC의 구현(Service, Action)

### 템플릿 기반의 URI Command Pattern에 기반한 MVC의 구현 
 \- URI상에 있는 주소를 얻어와 명령어로 처리하는 패턴입니다. 
 \- STS Setting 
  . Project Type: Dynamic Web Project 
  .       Name: mvc (web.xml 만들어지도록 선택하고 생성)
  . Package Name: action, controller, model

   \- 폴더 구조 
    mvc/src/main/webapp/view     : jsp 파일들 
    mvc/src/main/webapp/template  : template관련 파일들 
    mvc/src/main/webapp/WEB-INF  : web.xml 환경 설정 파일 위치 
    mvc/src/main/java           : 서블릿 클래스 위치
    mvc/src/main/webapp/WEB-INF/config  : properties 파일등, 기타 리소스 파일 
    mvc/src/main/webapp/WEB-INF/lib     : jar 파일의 라이브러리 위치, 자동 생성 



### Service Class

> CommandService.java

```java
package model;

import java.util.Date;

public class CommandService {

	public StringBuffer getHello() {
		StringBuffer sb = new StringBuffer();

		sb.append("<li> 안녕하세요..MVC 입니다.<br>");
		sb.append("<li> Template Page<br>");
		sb.append("<li> URI Command Pattern<br>");
		sb.append("<li> Properties 파일을 이용한 처리입니다.<br>");

		return sb;
	}

	public String getDate() {
		Date dt = new Date();
		String str = dt.toLocaleString();

		return str;
	}
}
```



### Command Handler 
 \- 인터페이스 또는 추상클래스로 구현.

 \- 비즈니스 로직 클래스(자식 클래스)들이 동일한 메소드를 실행 하도록 강제성 부여하며 표준 인터페이스 역할. 

> Action.java 

```

```



### Action Class 
\- Action Interface를 상속받아 구현 

> HelloAction.java

```java
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommandService;

public class HelloAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 1. 모델 사용 
		CommandService commandService = new CommandService();
		StringBuffer sb = commandService.getHello();
		// 2. 결과 저장 
		request.setAttribute("hello", sb);
		System.out.println("HelloAction Loading");

		// 3. 뷰 페이지 리턴 
		// Context Path을 제거한 경로 지정
		return "/view/hello.jsp";
	}

}
```



> DateAction.java

```java
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommandService;

public class DateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		CommandService commandService= new CommandService(); 
        String str = commandService.getDate(); 
         
        // 가져온 날짜 문자열을 request 객체에 저장 
        request.setAttribute("date", str); 
        return "/view/date.jsp"; 
	}
}

```



> NullAction.java

```java
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		return "/view/nullCommand.jsp";
	}

}

```















