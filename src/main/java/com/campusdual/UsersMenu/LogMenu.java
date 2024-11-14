package com.campusdual.UsersMenu;

import com.campusdual.Components.User;

import java.util.Scanner;

import static com.campusdual.Main.usersList;

public class LogMenu implements Menu{
    public static String display() {

        Scanner input = new Scanner(System.in);
        String username;

        while (true) {
            System.out.print("Enter your username (6-30 characters): ");
            username = input.nextLine();

            if (username.length() < 6 || username.length() > 30) {
                System.out.println("The username must be 6 to 30 characters long");
            } else if (usersList.get(username) != null) {
                System.out.println("The username is already registered");
            } else {
                break;
            }
        }
        User me = new User(username);
        usersList.put(username, me);

        System.out.println("Account created!");
        return username;
    }
}
