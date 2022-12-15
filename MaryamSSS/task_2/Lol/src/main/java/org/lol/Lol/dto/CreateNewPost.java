package org.lol.Lol.dto;

import java.util.Date;

public class CreateNewPost {
    private String content;
    private Date datetime;

    public CreateNewPost(String content, Date datetime){
        this.content = content;
        this.datetime = datetime;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getContent() {
        return content;
    }
    public Date getDatetime() {
        return datetime;
    }
}
