package com.campusdual.UsersMenu;

import com.campusdual.AdminMenu.HomeMenu;
import com.campusdual.UtilsDani.Menu;
import com.campusdual.Components.User;

import static com.campusdual.Utils.string;
import static com.campusdual.UtilsDani.Utils.*;
import java.util.Scanner;
import static com.campusdual.Main.usersList;

public class LogMenu implements Menu {
    public static void display() {

        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("1. Log In");
        System.out.println("2. Register");
        System.out.println();
        System.out.println("0. Prev Menu");

        String msg = "\nChoose an action (0 to exit): ";
        int selection = getActionInt(0, 2, msg);

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
        if (usersList.isEmpty()) {
            System.out.println(colorString(YELLOW, "No users in the app"));
            System.out.println("Switching to register screen...");
            register();
        }
        else { // There are users in the app
            String logName = "";
            do {
                logName = string("Introduce your username (0 to exit): ");
                if (logName.equals("0")) break; // Exit

                else if (isValidUsername(logName)){
                    if (!usersList.keySet().contains(logName)){
                        System.out.println("The username doesn't exist"); // Loop
                    }
                    else break; // All good
                }
            } while (true);

            if (logName.equals("0")) display(); // Reset menu
            else {
                System.out.println("Welcome back " + logName + "!");
                UserMenu.display(logName); // Log in
            }
        }
    }

    public static void register(){
        String newUsername = "";
        do {
            newUsername = string("Introduce a new username (0 to exit): ");
            if (newUsername.equals("0")) break; // Exit
        } while (!isValidUsername(newUsername, true));

        if (newUsername.equals("0")) display(); // Reset menu
        else {
        User me = new User(newUsername);
        usersList.put(newUsername, me);
        System.out.print("(Account created) Welcome " + newUsername + "!  ");
        UserMenu.display(newUsername);
        }
    }
}
