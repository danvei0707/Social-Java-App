package com.campusdual.UsersMenu;

import com.campusdual.Components.User;

import java.util.Scanner;

import static com.campusdual.Main.usersList;
import static com.campusdual.UtilsDani.InputScanner.input;

public class FollowedMenu implements Menu{
    public static void display(User myUsr){
        System.out.println("-------------------------\n");
        System.out.println(myUsr.getUsername() + "'s following list:");
        myUsr.showFollowedUsersList();
        System.out.println();

        int selection;
        do {
            System.out.println("1.Follow user | 2.Unfollow User | 0-Prev Menu");
            selection = input.nextInt();
        } while (selection < 0 | selection > 2);

        switch (selection){
            case 1:
                Scanner sc1 = new Scanner(System.in);
                System.out.print("\nUsername to follow: ");
                String toFollow = sc1.nextLine();
                myUsr.followUser(usersList, toFollow);

                FollowedMenu.display(myUsr); // Reset menu
                break;
            case 2:
                Scanner sc2 = new Scanner(System.in);
                System.out.print("\nUsername to unfollow: ");
                String toUnfollow = sc2.nextLine();
                myUsr.unfollowUser(usersList, toUnfollow);

                FollowedMenu.display(myUsr); // Reset menu
                break;
            case 0:
                HomeMenu.display(myUsr.getUsername());
                break;
            default:
                System.out.println("Invalid action");
                HomeMenu.display(myUsr.getUsername());
                break;

        }
    }
}
