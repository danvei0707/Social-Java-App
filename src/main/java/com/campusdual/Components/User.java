package com.campusdual.Components;

import java.util.ArrayList;

import static com.campusdual.UtilsDani.Utils.YELLOW;
import static com.campusdual.UtilsDani.Utils.colorString;

public class User {
    // Nombre, lista de usuarios a los que sigue, lista de posts
    private String username;
    private ArrayList<User> followedUsersList = new ArrayList<User>();
    private ArrayList<Post> myPosts = new ArrayList<Post>(); // Changed to ArrayList

    public User(String name) {
        this.username = name;
    }

    // Method to create a new post
    public void createPost(Post post) {
        try {
            myPosts.add(post);
        } catch (Exception e) {
            System.out.println("User.class | createPost method error: ");
            throw e;
        }
    }

    // Method to delete a post by id
    public void deletePostById(String idToDelete) {
        boolean found = false;
        for (int i = 0; i < myPosts.size(); i++) {
            Post post = myPosts.get(i);
            if (post.getId().equals(idToDelete)) {
                myPosts.remove(i);
                found = true;
                System.out.println(colorString(YELLOW, "Post with ID " + idToDelete + " has been deleted."));
                break; // Salir del bucle una vez encontrado y eliminado
            }
        }
        if (!found) {
            System.out.println("Post with ID " + idToDelete + " not found.");
        }
    }

    // Getters

    public String getUsername() {
        return username;
    }

    public ArrayList<User> getFollowedUsersList() {
        return followedUsersList;
    }

    public ArrayList<Post> getMyPosts() {
        return myPosts;
    }

    public void listMyPosts(int limit) {
        if (myPosts.isEmpty()) {
            System.out.println(this.username + ", aún no tienes posts en tu perfil.");
            return;
        }

        for (int i = 0; i < limit; i++) {
            if (i >= myPosts.size()) {
                System.out.println("Es todo lo que tienes, " + this.username + "!");
                System.out.println();
                return;
            } else {
                myPosts.get(i).getContentDetails();
            }
        }
    }
}
