package ru.codemika.db.dto;

import javax.persistence.Column;
import java.util.Date;

public class CreateNewPost {
    private Long id;
    private String content;
    private Date datetime;
    private Long user_id;

    public CreateNewPost(Long id, String content, Date datetime, Long user_id) {
        this.id = id;
        this.content = content;
        this.datetime = datetime;
        this.user_id = user_id;
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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
