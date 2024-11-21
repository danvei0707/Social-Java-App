package com.campusdual.UtilsDani;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static com.campusdual.SocialJavaApp.usersList;
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
}
