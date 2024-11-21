package com.campusdual.Components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static com.campusdual.SocialJavaApp.usersList;
import static com.campusdual.UtilsDani.Utils.*;

public class User {
    // Nombre, lista de usuarios a los que sigue, lista de posts
    private final String username;
    private final List<String> followedUsersList = new ArrayList<>();
    private final List<Post> myPosts = new ArrayList<>();
    private final List<Comment> myComments = new ArrayList<>();

    public User(String name) {
        this.username = name;
        this.followedUsersList.add(name);
    }

    // Method to create a new post
    public void createPost(Post post) {
        try {
            myPosts.add(post);
            System.out.print("Published: ");
            post.getPostDetails(false);
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

    // Method to follow a user
    public void followUser(String username){
        if (usersList.get(username) != null) {
            followedUsersList.add(username);
            System.out.println(this.username +  ": " + colorString(CYAN,"Followed " + username));
        }
        else {
            System.out.println("The user you're trying to follow doesn't exist");
        }

    }

    // Method to unfollow a user
    public void unfollowUser(String username){
        if (usersList.get(username) != null || followedUsersList.contains(username)) {
            followedUsersList.remove(username);
            System.out.println(this.username + ": " + colorString(YELLOW, "Unfollowed " + username));
        }
        else {
            System.out.println("You are not following the user " + username +  " already");
        }

    }

    // Method to delete the user
    public void removeAccount(HashMap<String, User> usersList){
        System.out.println(colorString(RED, "Deleting account: " + this.username));


//        // Delete all the related information
//        this.username = "deletedAccount";
//        this.followedUsersList = null;
//        this.myPosts = null;

        // Remove this object from the app array
        usersList.remove(this.username);
        System.out.println("Account removed");
    }

    // Getters

    public String getUsername() {
        return username;
    }

    public List<String> getFollowedUsersList() {
        return followedUsersList;
    }

    public void showFollowedUsersList(){
        if (followedUsersList.isEmpty()){
            System.out.println("There are no followed users yet");
        }
        else {
            for (String following: followedUsersList){
               if (!following.equals(this.username)) System.out.println("- User " + following);
            }
        }
    }

    public List<Post> getMyPosts() {
        return myPosts;
    }

    public Post getSpecificPost(String id) {
        Post postById = null;
        for (Post post: myPosts){
            if (Objects.equals(post.getId(), id)){
                postById = post;
            }
        }
        return postById;
    }

    public void listMyPosts(int limit) {
        if (myPosts.isEmpty()) {
            System.out.println("The user " + this.username + " does not have posts published");
            return;
        }

        for (int i = 0; i < limit; i++) {
            if (i >= myPosts.size()) {
                System.out.println();
                return;
            } else {
                myPosts.get(i).getPostDetails(true);
                System.out.println();
            }
        }
    }
}
