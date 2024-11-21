package com.campusdual.UtilsDani;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static com.campusdual.Main.listUserList;
import static com.campusdual.Main.usersList;
import static com.campusdual.Utils.integer;
import static com.campusdual.UtilsDani.InputScanner.input;

public class Utils {
    // ANSI color codes
    public static final String RESET = "\u001B[0m";  // Reset to default color
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String GRAY = "\u001B[90m";
    public static final String YELLOW = "\u001B[33m";

    public static String colorString(String color, String message){
        return color + message + RESET;
    }

    public static boolean wantTo (String actionToRepeat){
        System.out.println("Do you want to " + actionToRepeat + "? (y/n): ");
        String restartCreation = input.next();
        return Objects.equals(restartCreation, "y") || Objects.equals(restartCreation, "Y");
    }


    // Username Validators
    public static boolean isValidUsername(String username) {
        if (username.length() < 6 || username.length() > 30) {
            System.out.println(colorString(YELLOW, "The username must be 6 to 30 characters long"));
            return false;
        }
        else  return true; // All good
    };

    public static int getActionInt(int min, int max, String message){
        int x;
        do {
            System.out.print(message);
            x = integer();
        } while (x < min || x > max);

        return x;
    };

    public static boolean isValidUsername(String username, boolean noRepeat) {
        if (username.length() < 6 || username.length() > 30) {
            System.out.println(colorString(YELLOW, "The username must be 6 to 30 characters long"));
            return false;
        }
        else {
            if (noRepeat){ // Checks that the username is not in use
                List<String> usernameList = new ArrayList<>(usersList.keySet());
                if (usernameList.contains(username)) {
                    System.out.println(colorString(YELLOW, "Username already in use"));
                    return false;
                }
                else return true; // All good (noRepeat: true)
            }
            else return true; // All good  (noRepeat: false)
        }
    };

    public static String validateUsernameOld(String action){
        Scanner newInput = new Scanner(System.in);
        String message = ("Username" + colorString(GRAY, "type 'c' to cancel || not yet UtilsDani:Utils:35") + ":");

        String username = "";
        boolean valid = false;

//        if (usersList.isEmpty()) {
//            System.out.println(colorString(YELLOW, "No users in the app"));
//            return "";
//        }
        // TODO: como gestionar cuando no hay usuarios en la lista

        switch (action) {
            case "GET":
                // Lógica conseguir un username válido y existente
                do {
                    System.out.print("Existing users (" + usersList.size() + "): ");
                    listUserList();

                    System.out.print("Enter the username: ");
                    username = newInput.nextLine();

                    if (username.length() < 6 || username.length() > 30) {
                        System.out.println(colorString(YELLOW, "The username must be 6 to 30 characters long"));
                    } else if (usersList.get(username) == null) {
                        System.out.println("The user '" + username + "' doesn't exist");
                    } else {
                        valid = true;
                    }
                } while (!valid);
                break;
            case "POST":
                // Lógica conseguir un username único
                do {
                    System.out.print("Enter the username: ");
                    username = newInput.nextLine();

                    if (username.length() < 6 || username.length() > 30) {
                        System.out.println(colorString(YELLOW, "The username must be 6 to 30 characters long"));
                    } else if (usersList.get(username) != null) {
                        System.out.println("The username already exists");
                    }
                    else {
                        valid = true;
                    }
                } while (!valid);
        }

        return username;
    }
}
