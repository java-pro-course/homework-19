package ru.codemika.db.dto;

import java.time.LocalDate;

public class CreateNewPost {
    private String content;
    private LocalDate date;

    public CreateNewPost(String content, LocalDate date) {
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
