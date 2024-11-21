package com.campusdual.AdminMenu;

import com.campusdual.UsersMenu.HomeMenu;
import com.campusdual.UtilsDani.Menu;

import java.util.ArrayList;
import java.util.List;

import static com.campusdual.SocialJavaApp.usersList;
import static com.campusdual.Utils.integer;
import static com.campusdual.Utils.showAndSelectFromList;
import static com.campusdual.UtilsDani.Utils.*;

public class ManagementMenu implements Menu {
    public static void display() {
        List<String> userList = new ArrayList<>(usersList.keySet());

        System.out.println("\n-- MANAGEMENT ADMIN MENU -------------------------");
        System.out.println("1. Users");
        System.out.println("2. Posts");
        System.out.println("3. Create followers");
        System.out.println();
        System.out.println("0. Prev Menu");

        // Validation logics
        int selection;
        boolean valid = false;
        do {
            selection = integer("\nChoose an action (0 to exit):  ");
            if (selection < 0 || selection > 3) System.out.println("Select a valid option");
            else valid = true;
        } while (!valid);

        switch (selection) {
            case 0: // Prev
                HomeMenu.display();
                break;
            case 1: // Users
                UsersAdmin.display();
                break;
            case 2: // Posts
                PostsAdmin.display();
                break;
            case 3: // See posts
                ManagementMenu.forceFollow();
                break;
        }

    }

    private static void forceFollow() {
        if (usersList.isEmpty() || usersList.size() == 1) {
            System.out.println("There are not enough users. Currently: " + usersList.size());
            display();
        }
        else {
            List<String> usernameList = new ArrayList<>(usersList.keySet());
            String username1;
            String username2;

            List<String> selection1 = showAndSelectFromList(usernameList, true);
            if (!selection1.isEmpty()){
                username1 = selection1.get(0);

                List<String> selection2 = showAndSelectFromList(usernameList, true);
                if (!selection2.isEmpty()){
                    username2 = selection2.get(0);
                    usersList.get(username1).followUser(username2);
                }
                else display(); // Exit
            }
            else display(); // Exit

            boolean repeat = wantTo("connect more users");
            if (repeat) forceFollow();
            else display(); // Exit
        }

    }
}
