package com.campusdual.UsersMenu;

import com.campusdual.Components.User;

import static com.campusdual.Main.usersList;
import static com.campusdual.UtilsDani.InputScanner.input;

public class HomeMenu implements Menu{
    public static void display(String usrName) {
        User myUsr = usersList.get(usrName);
        int selection;

        System.out.println("-------------------------\n");
        System.out.println("1. Followed users");
        System.out.println("2. Create a new post");
        System.out.println("3. Check user posts");
        System.out.println("4. Delete user");
        System.out.print("\n(" + usrName + ") What do you want to do? ");
        selection = input.nextInt();

        switch (selection) {
            case 1:
                FollowedMenu.display(myUsr);
                break;
            case 2:
                NewPostMenu.display(myUsr);
                break;
            case 3:
                YourPostsMenu.display(myUsr);
                break;
            case 4:
                myUsr.removeAccount(usersList);
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}
