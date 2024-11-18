package com.campusdual.UtilsDani;

import com.campusdual.Components.Comment;
import com.campusdual.Components.Post;
import com.campusdual.Components.PostsContent.ImageContent;
import com.campusdual.Components.PostsContent.TextContent;
import com.campusdual.Components.PostsContent.VideoContent;
import com.campusdual.Components.User;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.campusdual.Main.usersList;
import static com.campusdual.UtilsDani.Utils.*;

public class TestRunner {
    static void testMethod(Method m, int index, String message) throws Throwable {
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
            throw e.getCause();
        }
    }

    // Usernames for the test users
    static final String MY_NAME = "danvei";
    static final String USER_1 = "joaquin_67";
    static final String USER_2 = "loli02";


    // TEST METHODS
    public static void testAll(){
        System.out.println("**************************");
        System.out.println("| INITIALIZING APP TESTS |");
        System.out.println("**************************");
        System.out.println();
        try {
            int n = 1;

            Method createObjectsMethod = TestRunner.class.getMethod("createObjects");
            testMethod(createObjectsMethod, n++, "Create users, posts and comments");

            Method followUsersMethod = TestRunner.class.getMethod("followUsers");
            testMethod(followUsersMethod, n++, "Follow and unfollow other user accounts");

            Method listUsersContentMethod = TestRunner.class.getMethod("listUsersContent");
            testMethod(listUsersContentMethod, n++, "List comments from posts");

            Method removeUserMethod = TestRunner.class.getMethod("removeObjects");
            testMethod(removeUserMethod, n++, "Remove a user and its content from the app");



        } catch (Exception e){
            System.out.println(colorString(RED, "Some tests have failed: ") + e.getCause());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }

    // ALL METHODS

    public static void createObjects(){
        User me = new User(MY_NAME);
        usersList.put(me.getUsername(), me);

        // Create all post types and display them
        System.out.println("A | TRYING TO CREATE...");
        me.createPost(new Post(new TextContent("Helloooo!! Welcome to my profile")));
        me.createPost(new Post(new VideoContent("Fun weekend", 1720, 122)));
        me.createPost(new Post(new ImageContent("Photo with bro", "16/9")));
        System.out.println();

        System.out.println("B | ADDING COMMENTS...");
        User u1 = new User(USER_1);
        usersList.put(USER_1, u1);
        User u2 = new User(USER_2);
        usersList.put(USER_2, u2);

        List<Post> myPosts = me.getMyPosts();
        myPosts.get(0).addComment(new Comment("Hello friend!!!", u1));
        myPosts.get(0).addComment(new Comment("How are you!!", u1));

        myPosts.get(1).addComment(new Comment("This is fun for you...?", u2));
        myPosts.get(1).addComment(new Comment("Always doing the best plans!!", u1));
        myPosts.get(1).addComment(new Comment("What's wong with the picture " + u2.getUsername() + "?", me));

        myPosts.get(2).addComment(new Comment("Sorry for the bad quality", me));

        System.out.println();


        System.out.println("C | LISTING MY POSTS WITH COMMENT COUNTER...");
        me.listMyPosts(5);


        System.out.println("D | LISTING ONE OF MY POSTS WITH COMMENTS...");
        me.getMyPosts().get(1).getPostDetails(true);
        System.out.println("\n");
    }

    public static void followUsers(){
        User me = usersList.get("danvei");

        if (me == null) {
            System.out.println("User 'Danvei' not found in userlist");
        }

        System.out.println("A | TRYING TO FOLLOW...");
        me.followUser(USER_1);
        me.followUser(USER_2);

        System.out.println();

        List<String> followed = me.getFollowedUsersList();

        System.out.println("Your followed users list, " + me.getUsername() + ":");
        for (int i = 0; i < followed.size(); i++ ) {
            System.out.println((i+1) + " - " + followed.get(i));
        }
        System.out.println();

        System.out.println("B | TRYING TO UNFOLLOW...");
        me.unfollowUser( "loli02");

        System.out.println();

        System.out.println("Your followed users list, " + me.getUsername() + ":");
        for (int i = 0; i < followed.size(); i++ ) {
            System.out.println((i+1) + " - " + followed.get(i));
        }
    }

    public static void listUsersContent(){

        System.out.println("A | SHOWING COMMENT COUNTER LIST...");
        usersList.get(MY_NAME).listMyPosts(4);
        System.out.println();

        System.out.println("B | SHOWING POST DETAIL...");
        usersList.get(MY_NAME).getMyPosts().get(1).getPostDetails(true);
        System.out.println();
    }

    public static void removeObjects(){
        User me = usersList.get(MY_NAME);

        System.out.println("A | DELETING USER...");
        User toDelete = usersList.get(USER_2);
        toDelete.removeAccount(usersList);

        System.out.println();

        System.out.println(USER_2 + " exists: " + (usersList.get(USER_2))); // Test if it still exist
        System.out.println();

        System.out.println("B | DELETING COMMENTS...");
        Comment toBeRemoved = me.getMyPosts().get(1).getComments().get(1);
        me.getMyPosts().get(1).removeComment(toBeRemoved);

        me.getMyPosts().get(1).getComments();
        System.out.println("\n");

        System.out.println("C | DELETING POSTS...");
        // Get the id from one of my posts
        String idToDelete1 = me.getMyPosts().get(0).getId();
        String idToDelete2 = me.getMyPosts().get(1).getId();
        String idToDelete3 = me.getMyPosts().get(2).getId();

        me.deletePostById(idToDelete1);
        me.deletePostById(idToDelete2);
        me.deletePostById(idToDelete3);
        System.out.println("\nChecking deletion: ");
        me.listMyPosts(5);
    }
}
