## 좋아요 기능 기록; 게시물 좋아요

### DB 구성

```sql
create table PostLike
(
    post_id    int         not null,
    user_email varchar(40) not null,
    like_id    int auto_increment
        primary key,
    constraint postlike_ibfk_1
        foreign key (post_id) references Post (post_id)
);
```

like_id(pk), post_id (fk), user_email 를 포함한 테이블로 create

### Like.java (DTO)

```java
package com.blackshirts.threeblackshirts.data;

public class Like {
    private int like_id ;
    private String user_email;
    private int post_id;

    public Like(){

    }

    public Like(int like_id, String user_email, int post_id) {
        this.like_id = like_id;
        this.user_email = user_email;
        this.post_id = post_id;
    }

    @Override
    public String toString() {
        return "Like{" +
                "like_id=" + like_id +
                ", user_email='" + user_email + '\\'' +
                ", post_id=" + post_id +
                '}';
    }

    public int getLike_id() {
        return like_id;
    }

    public void setLike_id(int like_id) {
        this.like_id = like_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
}
```

### Mapper, Rep, Service, ServiceImpl

`cntPostLike` : 해당 게시물의 총 좋아요 수를 셈

`updatePostLike` : 좋아요 insert

`deletePostLike` : 좋아요 삭제

`checkPostLike` : 현재 사용자가 해당 post를 좋아요 했는 지 확인

likeMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "<http://mybatis.org/dtd/mybatis-3-mapper.dtd>">
<!--test-->
<mapper namespace="com.blackshirts.threeblackshirts.repository.LikeRep">
    <select id="cntPostLike" parameterType="java.lang.Integer" resultType="int">
        SELECT COUNT(*)
        FROM PostLike
        WHERE post_id = #{post_id}
    </select>
    <insert id="updatePostLike" parameterType="com.blackshirts.threeblackshirts.data.Like">
        INSERT INTO PostLike (post_id, user_email)
        VALUES (#{post_id}, #{user_email})
    </insert>
    <delete id="deletePostLike" parameterType="com.blackshirts.threeblackshirts.data.Like">
        DELETE FROM PostLike
        WHERE post_id = #{post_id} AND user_email = #{user_email}
    </delete>
    <!--동일 게시글 추천 여부-->
    <select id="checkPostLike" parameterType="com.blackshirts.threeblackshirts.data.Like" resultType="java.lang.Integer">
        SELECT COUNT(*)
        FROM PostLike
        WHERE user_email = #{user_email} and post_id = #{post_id}
    </select>
</mapper>
```

LikeRep.java

```java
package com.blackshirts.threeblackshirts.repository;

import com.blackshirts.threeblackshirts.data.Like;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeRep {
    int cntPostLike(int post_id);
    void updatePostLike(Like like);
    void deletePostLike(Like like);
    int checkPostLike(Like like);
}
```

LikeService.java

```java
package com.blackshirts.threeblackshirts.service;

import com.blackshirts.threeblackshirts.data.Like;

public interface LikeService {
    int cntPostLike(int post_id);

    void updatePostLike(Like like);

    void deletePostLike(Like like);

    int checkPostLike(Like like);

}
```

LikeServiceImpl.java

```java
package com.blackshirts.threeblackshirts.service;

import com.blackshirts.threeblackshirts.data.Like;
import com.blackshirts.threeblackshirts.repository.LikeRep;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LikeServiceImpl implements LikeService {

    private LikeRep likeRep;

    public LikeServiceImpl(LikeRep likeRep) {
        this.likeRep = likeRep;
    }

    @Override
    public int cntPostLike(int post_id) {
        return likeRep.cntPostLike(post_id);
    }

    @Override
    public void updatePostLike(Like like) {
        likeRep.updatePostLike(like);
    }

    @Override
    public void deletePostLike(Like like) {
        likeRep.deletePostLike(like);
    }

    @Override
    public int checkPostLike(Like like) {
        return likeRep.checkPostLike(like);
    }

}
```

### LikeController.java

```java
		@PostMapping("/cntlike")
    private String likeCnt(Like like, Model model) throws Exception {

        log.info("like cnt");
        log.info(String.valueOf(like.getPost_id()));
        log.info(String.valueOf(like.getUser_email()));

        int plike_cnt = likeService.cntPostLike(like.getPost_id());
        model.addAttribute("plike", plike_cnt);

        return "postdetail";
    }
```

`@PostMapping("/cntlike") likeCnt` : post page 가 보여질 때 이 게시물의 총 좋아요 수가 보여지도록 함

```java
		@RequestMapping("/likeview")
    @ResponseBody // Json전달가능
    private Map<String, Object> like_view(Model model, int post_id, HttpServletRequest request) throws Exception {

        User user = boardService.getUserFromCookie(request);
        Like like = new Like();
        like.setPost_id(post_id);
        like.setUser_email(user.getUseremail());

        // 현재 로그인 유저가 좋아요를 눌렀는지 1 = 누름, 0 = 안누름
        int cnt = likeService.checkPostLike(like);

        // 이 게시물 자체의 좋아요 개수
        int total_cnt = likeService.cntPostLike(post_id);

        // Map으로 만들어준다음 return
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("cnt", cnt); // 헷갈리지 않게 이름은 똑같이 설정
        m.put("total_cnt", total_cnt);

        return m;
    }
```

jsp 파일이 로딩 될 때 처음에 실행됨. ajax - post 방식으로 post_id를 받음

이 게시물에 현재 로그인 유저가 눌렀는지 여부,

이 게시물의 좋아요 개수

→ return

```java
		@RequestMapping("/updatelike")
    @ResponseBody
    public int update(Like like, HttpServletRequest request) {
        log.info("UPDATE LIKE");
        User user = boardService.getUserFromCookie(request);
        like.setUser_email(user.getUseremail());
        log.info(like.toString());

        likeService.updatePostLike(like);

        return 1;
//        "redirect:/post/{post_id}";
    }
```

좋아요 선택 시 좋아요 insert (ajax - post 방식으로 post_id를 받음)

```java
		@RequestMapping("/deletelike")
    @ResponseBody
    private int like_delete(int post_id, HttpServletRequest request) throws Exception {
        User user = boardService.getUserFromCookie(request);
        Like like = new Like();
        like.setPost_id(post_id);
        like.setUser_email(user.getUseremail());

        likeService.deletePostLike(like);
        return 1;
    }
```

### postdetail.jsp → like 부분

postdetail.jsp 의 script 에서 like 기능 부분

ajax로 비동기 통신. post_id 를 post방식으로 전송.

- `function likeview()` : 처음 이 페이지가 열릴 때 실행.

현재 유저가 이 게시물을 좋아요 눌렀는 지 확인. 총 게시물 수 확인.

```java
function likeview() {
        $.ajax({
            url : '/likeview',
            type : 'post',
            async : true,
            data : {'post_id' : ${post.post_id}}, // postid 보냄
            dataType : 'json', // data가 json타입
            success : function(data) {
                var a = '';
                if (data.cnt == 1) {   // 현재 로그인 유저가 포스팅 좋아요를 눌렀음
                    a += '<button type="button" id="like" class="likebtn" onclick="likeDelete();">' // likeDelete는 밑에서
                    a += '<img class="likeimg" src="/css/img/heart1.png" alt="" style="width: 50px; height: auto;"></button> <br />'
                    a += '<span class="glyphicon glyphicon-comment" aria-hidden="true"></span> <br />'
                    a += '<span><b>좋아요 ' + data.total_cnt + '개</b></span>' // 총 좋아요 개수
                } else if (data.cnt == 0) { // 안눌렀음
                    a += '<button type="button" id="like" class="likebtn" onclick="likeInsert();">' // likeInsert는 위에서
                    a += '<img class="likeimg" src="/css/img/heart2.png" alt="" style="width: 50px; height: auto;"></button> <br />'
                    a += '<span class="glyphicon glyphicon-comment" aria-hidden="true"></span> <br />'
                    a += '<span><b>좋아요 ' + data.total_cnt + '개</b></span>'
                }
                $('.like').html(a); // <div class="like></div> 이부분에 나타남
            }
        });
    }
```

- `function likeInsert()` : 현재 유저가 좋아요 버튼을 누를 경우 (현재 안눌러져 있는 경우)

db에 저장시키고 listview 다시 실행.

```java
function likeInsert(){
        $.ajax({
            // onclick="likeInsert('+ id +');
            url : '/updatelike',
            type : 'post',
            data : {'post_id' : ${post.post_id}}, // postid 보냄
            dataType : 'json', // data가 json타입
            success : function(data){
                if(data == 1)
                    likeview();
            }
        });
    }
```

- `function likeDelete()` : 현재 유저가 좋아요 버튼을 누를 경우 (현재 눌러져 있는 경우 - 좋아요 취소)

db에 저장시키고(삭제하고) listview 다시 실행.

```java
function likeDelete(){
        $.ajax({
            url : '/deletelike',
            type : 'post',
            data : {'post_id' : ${post.post_id}}, // postid 보냄
            dataType : 'json', // data가 json타입
            success : function(data){
                if(data == 1)
                    likeview();
            }
        });
    }
```

좋아요 delete (ajax - post 방식으로 post_id를 받음)