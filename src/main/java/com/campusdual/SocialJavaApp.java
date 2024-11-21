package com.campusdual;

import com.campusdual.Components.User;
import com.campusdual.UsersMenu.LogMenu;
import com.campusdual.UtilsDani.MockData;

import java.util.HashMap;

public class SocialJavaApp {
    public static HashMap<String, User> usersList = new HashMap<String, User>();
    public static User activeUser = null;

    public static void main(String[] args) {
        System.out.println("Loading social Java app...\n");
        //testAll();

        MockData.build();
        LogMenu.display();
    }


    // Getters and setters

    public static User getActiveUser() {
        return activeUser;
    }

    public static void setActiveUser(String username) {
        SocialJavaApp.activeUser = usersList.get(username);
    }
}