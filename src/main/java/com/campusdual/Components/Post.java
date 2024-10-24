package com.campusdual.Components;

import com.campusdual.Components.PostsContent.Content;
import com.campusdual.Components.PostsContent.ImageContent;
import com.campusdual.Components.PostsContent.TextContent;
import com.campusdual.Components.PostsContent.VideoContent;


import java.util.*;

import static com.campusdual.UtilsDani.Utils.GRAY;
import static com.campusdual.UtilsDani.Utils.colorString;

public class Post {
    // Fecha, lista de comentarios, contenido
    private String id;
    private Date publishDate;
    private Stack<Comment> comments; // ARRAY LIST??
    private Content content;

    public Post(Content content) {
        try {
            this.id = UUID.randomUUID().toString().substring(0,6);
            this.publishDate = new Date();
            this.content = content;
        } catch (Exception e){
            System.out.println("Posts constructor error: ");
            throw e;
        }

    }



    // Getters
    public Date getPublishDate() {
        return publishDate;
    }

    public String getId() {
        return id;
    }

    public void getContentDetails(){
        System.out.print(colorString(GRAY, this.id + " "));
        this.content.getDetails();
    }


}
