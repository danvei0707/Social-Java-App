package com.campusdual.AdminMenu;

import com.campusdual.UsersMenu.NewPostMenu;
import com.campusdual.UtilsDani.Menu;

import java.util.Objects;
import java.util.Scanner;

import static com.campusdual.Main.listUserList;
import static com.campusdual.Main.usersList;
import static com.campusdual.UtilsDani.InputScanner.input;
import static com.campusdual.UtilsDani.Utils.validateUsername;
import static com.campusdual.UtilsDani.Utils.wantTo;

public class PostsAdmin implements Menu {
    public static void display(){
        int selection;

        System.out.println("\n--- ADMIN POSTS MENU -------------------------");
        System.out.println("1. List User Posts");
        System.out.println("2. Create User Post");
        System.out.println();
        System.out.println("0. Prev Menu");

        do {
            System.out.print("\nChoose an action:  ");
            selection = input.nextInt();
        } while (selection < 0 || selection > 2);
        switch (selection)
        {
            case 0: // Prev
                ManagementMenu.display();
                break;
            case 1: // Post listing
                checkPosts();
                break;
            case 2: // Post creation
                forcePost();
                break;
        }
    }

    public static void checkPosts() {
        String username = validateUsername("GET");
        if (!Objects.equals(username, "")){
            usersList.get(username).listMyPosts(100);

            boolean repeat = wantTo("see another user");
            if (repeat) checkPosts();
            else display();
        }
        else {
            display();
        }



    }

    private static void forcePost() {
        String username = validateUsername("GET");
        NewPostMenu.display(usersList.get(username), true);

        boolean repeat = wantTo("choose another user to post");
        if (repeat) forcePost();
        else display();
    }
}
