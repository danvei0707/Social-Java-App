package com.campusdual.UsersMenu;

import com.campusdual.AdminMenu.HomeMenu;
import com.campusdual.UtilsDani.Menu;
import com.campusdual.Components.User;
import static com.campusdual.UtilsDani.Utils.*;
import java.util.Scanner;
import static com.campusdual.Main.usersList;

public class LogMenu implements Menu {
    public static void display() {

        Scanner input = new Scanner(System.in);
        int selection;

        System.out.println("\n-------------------------");
        System.out.println("1. Log In");
        System.out.println("2. Register");
        System.out.println();
        System.out.println("0. Prev Menu");

        do {
            System.out.print("\nChoose an action:  ");
            selection = input.nextInt();
        } while (selection < 0 || selection > 2);

        switch (selection) {
            case 0: // Prev
                HomeMenu.display();
                break;
            case 1: // Log
                logIn();
                break;
            case 2: // Register
               register();
               break;
        }
    }
    public static void logIn() {
        if (!usersList.isEmpty()) {
            String existingUsername = validateUsername("GET");
            System.out.println("Welcome back " + existingUsername + "!");
            UserMenu.display(existingUsername);
        }
        else {
            System.out.println(colorString(YELLOW, "No users in the app"));
            System.out.println("Switching to register screen...");
            register();
        }
    }

    public static void register(){
        String newUsername = validateUsername("POST");
        User me = new User(newUsername);
        usersList.put(newUsername, me);
        System.out.print("----  Account created || Welcome " + newUsername + "!  ");
        UserMenu.display(newUsername);
    }
}
