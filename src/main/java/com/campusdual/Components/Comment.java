package com.campusdual.Components;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {
    // Un texto, una fecha y un propietario (User)
    private final String content;
    private final Date publishDate;
    private final User author;

    public Comment(String content, User author) {
        this.content = content;
        this.publishDate = new Date();
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

    public String getCommentDetails(){
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  hh:mm");

        sb.append(sdf.format(this.publishDate)).append(" - ")
                .append(this.author.getUsername()).append(": ")
                .append(this.content);

        return sb.toString();
    }
}
