package com.campusdual.AdminMenu;

import com.campusdual.Components.User;
import com.campusdual.UsersMenu.NewPostMenu;
import com.campusdual.UtilsDani.Menu;

import java.util.Objects;
import java.util.Scanner;

import static com.campusdual.Main.listUserList;
import static com.campusdual.Main.usersList;
import static com.campusdual.UtilsDani.InputScanner.input;
import static com.campusdual.UtilsDani.Utils.*;

public class ManagementMenu implements Menu {
    public static void display() {
        int selection;

        System.out.println("\n-- MANAGEMENT ADMIN MENU -------------------------");
        System.out.println("1. Users");
        System.out.println("2. Posts");
        System.out.println("3. Create followers");
        System.out.println();
        System.out.println("0. Prev Menu");

        do {
            System.out.print("\nChoose an action:  ");
            selection = input.nextInt();
        } while (selection < 0 || selection > 5);

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
            String username1;
            String username2;

            username1 = validateUsername("GET");
            do {
                username2 = validateUsername("GET");
                if (Objects.equals(username2, username1)) System.out.println("One user can't follow itself, choose a valid one");
            } while (Objects.equals(username2, username1));

            usersList.get(username1).followUser(username2);

            boolean repeat = wantTo("connect more users");
            if (repeat) forceFollow();
            else display();
        }

    }
}
