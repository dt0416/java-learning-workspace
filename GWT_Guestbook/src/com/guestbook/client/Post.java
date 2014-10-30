package com.guestbook.client;

import java.io.Serializable;
//import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Post implements Serializable {
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    Long id;
    @Persistent
    String nickname;
    @Persistent
    String title;
    @Persistent
    String content;
//    @Persistent
//    Date date;
    
    public Post() {}
    
//    public Post(String nickname, String title, String content, Date date) {
    public Post(String nickname, String title, String content) {
        super();
        this.nickname = nickname;
        this.title = title;
        this.content = content;
//        this.date = date;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
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
//    public Date getDate() {
//        return date;
//    }
//    public void setDate(Date date) {
//        this.date = date;
//    }
}
