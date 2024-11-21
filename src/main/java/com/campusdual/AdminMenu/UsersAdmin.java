package com.campusdual.AdminMenu;

import com.campusdual.Components.User;
import com.campusdual.UtilsDani.Menu;
import com.campusdual.UtilsDani.Utils;

import java.util.ArrayList;
import java.util.List;

import static com.campusdual.Main.usersList;
import static com.campusdual.Utils.showAndSelectFromList;
import static com.campusdual.Utils.string;
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
        String username = "";
        do {
            username = string("Introduce the new username (type 0 to exit): ");
            if (username.equals("0")) break;
        } while (!isValidUsername(username, true));

        if (!username.equals("0")) {
            User newUser = new User(username);
            usersList.put(username, newUser);

            boolean repeat = wantTo("create another user");
            if (repeat) createUser();
            else display();
        }
        else display();

    }

    private static void deleteUser() {
        List<String> usernameList = new ArrayList<>(usersList.keySet());
        List<String> selection = showAndSelectFromList(usernameList, true);
        if (!selection.isEmpty()){
            String username = selection.get(0);
            usersList.remove(username);
            System.out.println(colorString(RED, ("User '" + username + "' has been deleted")));

            boolean repeat = wantTo("delete another user");
            if (repeat) deleteUser();
            else display(); // Exit
        }
        else display(); // Exit
    }
}
