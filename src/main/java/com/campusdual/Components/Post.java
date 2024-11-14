package com.campusdual.Components;

import com.campusdual.Components.PostsContent.Content;


import java.util.*;

import static com.campusdual.UtilsDani.Utils.GRAY;
import static com.campusdual.UtilsDani.Utils.colorString;

public class Post {
    // Fecha, lista de comentarios, contenido
    private final String id;
    private final Date publishDate;
    private final List<Comment> comments;
    private final Content content;

    public Post(Content content) {
        try {
            this.id = UUID.randomUUID().toString().substring(0,6);
            this.publishDate = new Date();
            this.content = content;
            this.comments = new ArrayList<Comment>();
        } catch (Exception e){
            System.out.println("Posts constructor error: ");
            throw e;
        }

    }

    public List<Comment> getComments(){
        return this.comments;
    }

    public void addComment(Comment c){
        comments.add(c);
        System.out.println(c.getAuthor().getUsername() + " commented: " + c.getContent());
    }

    public void removeComment(Comment c){
        // Implement validation: its comment owner? its post owner?
        comments.remove(c);
        System.out.print("Deleted the comment: " + colorString(GRAY, c.getCommentDetails()));
    }

    public void deleteComment(String content){
        int indexToDelete = 999;
        for (int i = 0; i < comments.size(); i++) {
            if (Objects.equals(comments.get(i).getContent(), content)){
                indexToDelete = i;
            }
        }

        if (indexToDelete != 999){
            comments.remove(indexToDelete);
            System.out.println("Comment removed");
        }
        else {
            System.out.println("The comment was not found");
        }
    }

    // Getters
    public Date getPublishDate() {
        return publishDate;
    }

    public String getId() {
        return id;
    }

    public void getPostDetails(boolean expandComments){
        System.out.print(colorString(GRAY, this.id + " "));
        this.content.getDetails();

        if (!this.comments.isEmpty()){
            if (expandComments){
                for (int i = 0; i < comments.size(); i++){
                    System.out.print("\n" + colorString(GRAY, comments.get(i).getCommentDetails()));
                }
            }
            else {
                System.out.println(colorString(GRAY, " | " + this.comments.size() + " comments"));
            }
        }
        else {
            System.out.println(" | " + colorString(GRAY, "No comments"));
        }


    }
}
