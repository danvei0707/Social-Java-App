package com.campusdual;

import com.campusdual.Components.Post;
import com.campusdual.Components.PostsContent.ImageContent;
import com.campusdual.Components.PostsContent.TextContent;
import com.campusdual.Components.PostsContent.VideoContent;
import com.campusdual.Components.User;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.campusdual.UtilsDani.Utils.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Loading social Java app...\n");

        populateUsersList();

        testAll();
    }

    static void testMethod(Method m, int index, String message) throws Exception{
        System.out.println("***** TEST " + (index) + ": "+ message + "*****");

        // Try method, if exception occurs rethrow to testAll() Try/Catch
        try {
            m.invoke(null);
            // Log success
            System.out.println();
            System.out.print("TEST " + index + ": ");
            System.out.println(colorString(GREEN,"SUCCESS"));
            System.out.println();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    static HashMap<String, User> usersList = new HashMap<String, User>();

    public static void populateUsersList(){
        // Array with test names
        ArrayList<String> mockUsers = new ArrayList<String>(Arrays.asList(
                "carla_g18","davidlopez_99","ana_heart_23","sofia_mart","luis_4ever","nat_perez",
                "javi_bae","laura_xoxo","ricardo.89","isabelita_17","fer_alv_12","cris_dreamer",
                "mari_jim","alejandro_2024","pattyc_07","ed_cordoba","vero_bella","gabo_life",
                "naty_cool","miguez.99"
        ));

        // Addition to User List
        for (String username: mockUsers) {
            User mockUser = new User(username);
            usersList.put(username, mockUser);
        }


        // Console output
        System.out.print("ADDED MOCK USERS: ");
        for (String username: usersList.keySet()){
            System.out.print(username + ", ");
        }
        System.out.print("\n\n");
    }

    // TEST METHODS
    public static void testAll(){
        System.out.println("**************************");
        System.out.println("| INITIALIZING APP TESTS |");
        System.out.println("**************************");
        System.out.println();
        try {
            int n = 1;

            Method createUserMethod = Main.class.getMethod("CreateUserSelf");
            testMethod(createUserMethod, n++, "Create user (self)");

//            Method createContentMethod = Main.class.getMethod("CreatePostContents");
//            testMethod(createContentMethod, n++, "Try all types of post content");

            Method createPostMethod = Main.class.getMethod("createPost");
            testMethod(createPostMethod, n++, "Create and delete posts");

            Method followUsersMethod = Main.class.getMethod("followUsers");
            testMethod(followUsersMethod, n++, "Follow users with main account");

            Method removeUserMethod = Main.class.getMethod("removeUser");
            testMethod(removeUserMethod, n++, "Remove a user and its content from the app");

        } catch (Exception e){
            System.out.println(colorString(RED, "Some tests have failed: ") + e.getCause());
        }

    }

    // ALL METHODS

    public static void CreateUserSelf(){
        User me = new User("danvei");
        usersList.put(me.getUsername(), me);

        System.out.println("Welcome back, " + me.getUsername() + "!");
    }

    public static void CreatePostContents(){

        VideoContent vc = new VideoContent("Pool Party", 720, 113);
        ImageContent ic = new ImageContent("Sunset View", "3/4");
        TextContent tc = new TextContent("What does this button do?");

        vc.getDetails();
        ic.getDetails();
        tc.getDetails();
    }

    public static void createPost(){
        User me = usersList.get("danvei");
        if (me == null) {
            System.out.println("User 'danvei' not found in usersList.");
        } else {
            // Create all post types and display them
            System.out.println("A | TRYING TO CREATE...");
            me.createPost(new Post(new TextContent("Holaaa!! ")));
            me.createPost(new Post(new VideoContent("Fun weekend", 1720, 122)));
            me.createPost(new Post(new ImageContent("Photo with bro", "16/9")));
            me.listMyPosts(10);

            // Choose a post to delete and delete it
            System.out.println("B | TRYING TO DELETE...");
            // Get the id from one of my posts
            String idToDelete1 = me.getMyPosts().get(0).getId();
            String idToDelete2 = me.getMyPosts().get(1).getId();
            String idToDelete3 = me.getMyPosts().get(2).getId();


            me.deletePostById(idToDelete1);
            me.deletePostById(idToDelete2);
            me.deletePostById(idToDelete3);
            me.listMyPosts(10);
        }
    }

    public static void followUsers(){
        User me = usersList.get("danvei");


        System.out.println("A | TRYING TO FOLLOW...");
        me.followUser(usersList, "mari_jim");
        me.followUser(usersList, "pattyc_07");
        me.followUser(usersList, "ed_cordoba");

        System.out.println();

        System.out.println(me.getUsername() + ": Your followed users list:");
        for (String s : me.getFollowedUsersList()) {
            System.out.println(s);
        }

        System.out.println();


        System.out.println("B | TRYING TO UNFOLLOW...");
        me.unfollowUser( usersList,"mari_jim");

        System.out.println();

        System.out.println(me.getUsername() + ": Your followed users list:");
        for (String s : me.getFollowedUsersList()) {
            System.out.println(s);
        }
    }

    public static void removeUser(){
        System.out.println("A | TRYING TO DELETE...");
        User toDelete = usersList.get("pattyc_07");
        toDelete.removeAccount(usersList);

        System.out.println();

        System.out.println("B | TRYING TO FIND DELETED USER...");
        System.out.println(usersList.get(toDelete));
    }
}