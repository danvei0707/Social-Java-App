package com.campusdual;

import com.campusdual.Components.PostsContent.ImageContent;
import com.campusdual.Components.PostsContent.TextContent;
import com.campusdual.Components.PostsContent.VideoContent;
import com.campusdual.Components.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Loading social Java app...");

        testCreateUser();
        testCreatePostContents();
    }

    public static void testCreateUser(){
        User me = new User("Dani");

        System.out.println("Welcome back, " + me.getName() + "!");
    }

    public static void testCreatePostContents(){
        VideoContent vc = new VideoContent("Pool Party", 720, 113);
        ImageContent ic = new ImageContent("Sunset View", "3/4");
        TextContent tc = new TextContent("What does this button do?");

        vc.getDetails();
        ic.getDetails();
        tc.getDetails();
    }
}