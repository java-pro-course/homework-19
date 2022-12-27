package org.lol.Lol.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "maryamsss", name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(name = "content")
    private String content;

    @Column(name = "datetime")
    private Date datetime = new Date();

    public void setPostId(Long postId) {
        this.postId = postId;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
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
