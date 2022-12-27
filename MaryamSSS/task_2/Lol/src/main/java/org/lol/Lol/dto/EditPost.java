package org.lol.Lol.dto;

import java.util.Date;

public class EditPost {
    private Long postId;
    private String content;
    private Date datetime;

    public EditPost(Long postId, String content, Date date){
        this.postId = postId;
        this.content = content;
        this.datetime = date;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void setDatetime(Date date) {
        this.datetime = date;
    }

    public Long getPostId() {
        return postId;
    }
    public String getContent() {
        return content;
    }
    public Date getDatetime() {
        return datetime;
    }
}
