package com.campusdual.Components;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class User {
    // Nombre, lista de usuarios a los que sigue, lista de posts
    private String name;
    private ArrayList<User> followedUsersList;
    private HashMap<Date, Post> myPosts;

    public User(String name) {
        this.name = name;
    }

    // Getters

    public String getName() {
        return name;
    }

    public ArrayList<User> getFollowedUsersList() {
        return followedUsersList;
    }

    public HashMap<Date, Post> getMyPosts() {
        return myPosts;
    }
}
