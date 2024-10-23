package com.campusdual.Components;

import java.util.Date;

public class Comment {
    // Un texto, una fecha y un propietario (User)
    private String content;
    private Date publishDate;
    private User author;

    public Comment(String content, Date publishDate, User author) {
        this.content = content;
        this.publishDate = publishDate;
        this.author = author;
    }

    // Getters
    public String getContent() {
        return content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public User getAuthor() {
        return author;
    }
}
