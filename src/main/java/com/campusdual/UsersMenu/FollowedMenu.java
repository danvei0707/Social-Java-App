package com.campusdual.UsersMenu;

import com.campusdual.UtilsDani.Menu;
import com.campusdual.Components.User;

import java.util.Objects;
import java.util.Scanner;

import static com.campusdual.Main.listUserList;
import static com.campusdual.Main.usersList;
import static com.campusdual.UtilsDani.InputScanner.input;
import static com.campusdual.UtilsDani.Utils.validateUsername;

public class FollowedMenu implements Menu {
    public static void display(User myUsr){
        System.out.println("\n---" + myUsr.getUsername() + "'s following list:----------------------");
        myUsr.showFollowedUsersList();
        System.out.println();

        int selection;
        do {
            System.out.println("1.Follow user | 2.Unfollow User | 0-Prev Menu");
            selection = input.nextInt();
        } while (selection < 0 | selection > 2);

        switch (selection){
            case 1:
                if (usersList.isEmpty() || usersList.size() == 1) {
                    System.out.println("There are not enough users. Currently: " + usersList.size());
                    display(myUsr);
                }
                else followLogics(myUsr);
                break;
            case 2:
                if (usersList.isEmpty() || usersList.size() == 1) {
                    System.out.println("There are not enough users. Currently: " + usersList.size());
                    display(myUsr);
                }
                unfollowLogics(myUsr);
                break;
            case 0:
                UserMenu.display(myUsr.getUsername());
                break;
            default:
                System.out.println("Invalid action");
                UserMenu.display(myUsr.getUsername());
                break;

        }
    }

    public static void followLogics(User myUsr) {
        String toFollow;
        do {
            toFollow = validateUsername("GET");
            if (Objects.equals(toFollow, myUsr.getUsername())) System.out.println("One user can't follow itself, choose a valid one");
        } while (Objects.equals(toFollow, myUsr.getUsername()));

        myUsr.followUser(toFollow);

        FollowedMenu.display(myUsr); // Reset menu
    }

    public static void unfollowLogics(User myUsr) {
        String toUnfollow;
        do {
            toUnfollow = validateUsername("GET");
            if (Objects.equals(toUnfollow, myUsr.getUsername())) System.out.println("One user can't unfollow itself, choose a valid one");
        } while (Objects.equals(toUnfollow, myUsr.getUsername()));

        myUsr.unfollowUser(toUnfollow);

        FollowedMenu.display(myUsr); // Reset menu
    }
}
