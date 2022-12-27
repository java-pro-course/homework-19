package ru.codemika.db.dto;

import java.sql.Date;

public class CreateNewPost {
    private Long id;
    private String content;
    private Date datetime;
    private Long userId;

    public CreateNewPost(Long id, String content, Date datetime, Long userId) {
        this.id = id;
        this.content = content;
        this.datetime = datetime;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
