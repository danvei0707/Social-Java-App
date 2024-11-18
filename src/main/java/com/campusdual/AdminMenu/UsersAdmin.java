package com.campusdual.AdminMenu;

import com.campusdual.Components.User;
import com.campusdual.UtilsDani.Menu;

import static com.campusdual.Main.usersList;
import static com.campusdual.UtilsDani.InputScanner.input;
import static com.campusdual.UtilsDani.Utils.*;

public class UsersAdmin implements Menu {
    public static void display() {
        int selection;

        System.out.println("\n--- ADMIN USERS MENU -------------------------");
        System.out.println("1. Create User");
        System.out.println("2. Delete User");
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
            case 1: // Users
                createUser();
                break;
            case 2: // Delete
               deleteUser();
                break;
        }
    }

    private static void createUser() {
        String username = validateUsername("POST");

        User newUser = new User(username);
        usersList.put(username, newUser);

        boolean repeat = wantTo("create another user");
        if (repeat) createUser();
        else display();
    }

    private static void deleteUser() {
        String username = validateUsername("GET");

        usersList.remove(username);
        System.out.println(colorString(RED, ("User '" + username + "' has been deleted")));

        boolean repeat = wantTo("delete another user");
        if (repeat) deleteUser();
        else display();

    }
}
